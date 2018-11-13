package com.kevintoh0305gmail.gastronome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsViewHolder> {
    Context context;
    ArrayList<String> ingredients;

    public IngredientsAdapter(Context c, ArrayList<String> l)
    {
        context = c;
        ingredients = l;
    }

    public IngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.ingredientsviewholder,parent,false);
        return new IngredientsViewHolder(item, context);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientsViewHolder ingredientsViewHolder, int i) {
        ingredientsViewHolder.txtIngredients.setText(ingredients.get(i));
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }
}
