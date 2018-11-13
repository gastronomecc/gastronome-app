package com.kevintoh0305gmail.gastronome;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {
    Context context;
    ArrayList<Recipe> recipes;
    static Recipe selectedRecipe;


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
        //recipeViewHolder.wv.loadUrl("https://firebasestorage.googleapis.com/v0/b/p2fsdgastro.appspot.com/o/01e1ef88-be15-483b-93b9-b5964a756969.jpg?alt=media&token=c719f0ee-7e6e-4505-9ab9-295440d808fb");

        recipeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedRecipe = recipes.get(i);
                Intent in = new Intent(context,RecipeInfoActivity.class);
                context.startActivity(in);

            }
        });
        //recipeViewHolder.imgRecipe.setImageURI(recipes.get(i).getShortDesc());
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}



