package com.kevintoh0305gmail.gastronome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecipeNoAddAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    Context context;
    ArrayList<Recipe> recipes;
    static Recipe selectedRecipe;


    public RecipeNoAddAdapter(Context c, ArrayList<Recipe> l)
    {
        context = c;
        recipes = l;
    }

    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.recipenoaddviewholder,parent,false);
        return new RecipeViewHolder(item, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int i) {
        recipeViewHolder.txtTitle.setText(recipes.get(i).getTitle());
        recipeViewHolder.txtShortDesc.setText(recipes.get(i).getShortDesc());
        recipeViewHolder.btnPrepTime.setText(recipes.get(i).getPrepTime() + " MIN");
        recipeViewHolder.btnDifficulty.setText(recipes.get(i).getDifficulty());
        if (recipes.get(i).getDietary().equals("None")) {
            recipeViewHolder.btnMealType.setVisibility(View.INVISIBLE);
        } else {
            recipeViewHolder.btnMealType.setText(recipes.get(i).getDietary());
        }
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}
