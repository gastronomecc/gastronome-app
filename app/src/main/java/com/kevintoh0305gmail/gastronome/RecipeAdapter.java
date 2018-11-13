package com.kevintoh0305gmail.gastronome;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    List<Recipe> recipes = new ArrayList<>();
    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recipeviewholder, viewGroup, false);
        RecipeViewHolder holder = new RecipeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int i) {
        recipeViewHolder.txtTitle.setText(recipes.get(i).getTitle());
        recipeViewHolder.txtShortDesc.setText(recipes.get(i).getShortDesc());
        //recipeViewHolder.imgRecipe.setImageURI(recipes.get(i).getShortDesc());
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}



