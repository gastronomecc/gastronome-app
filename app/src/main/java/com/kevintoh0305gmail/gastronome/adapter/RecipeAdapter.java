package com.kevintoh0305gmail.gastronome.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevintoh0305gmail.gastronome.R;
import com.kevintoh0305gmail.gastronome.model.Recipe;
import com.kevintoh0305gmail.gastronome.recipe.RecipeInfoActivity;
import com.kevintoh0305gmail.gastronome.viewHolder.RecipeViewHolder;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {
    Context context;
    ArrayList<Recipe> recipes;
    public static Recipe selectedRecipe;


    public RecipeAdapter(Context c, ArrayList<Recipe> l)
    {
        context = c;
        recipes = l;
    }

    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.recipeviewholder,parent,false);
        return new RecipeViewHolder(item, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, final int i) {
        recipeViewHolder.txtTitle.setText(recipes.get(i).getTitle());
        recipeViewHolder.txtShortDesc.setText(recipes.get(i).getShortDesc());
        recipeViewHolder.btnPrepTime.setText(recipes.get(i).getPrepTime() + " MIN");
        recipeViewHolder.btnDifficulty.setText(recipes.get(i).getDifficulty());
        if (recipes.get(i).getDietary().equals("None")) {
            recipeViewHolder.btnMealType.setVisibility(View.INVISIBLE);
        } else {
            recipeViewHolder.btnMealType.setText(recipes.get(i).getDietary());
        }
        recipeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedRecipe = recipes.get(i);
                Intent in = new Intent(context,RecipeInfoActivity.class);
                context.startActivity(in);

            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}



