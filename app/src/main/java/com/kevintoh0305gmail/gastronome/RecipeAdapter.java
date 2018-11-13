package com.kevintoh0305gmail.gastronome;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {
    Context context;
    ArrayList<Recipe> recipes = new ArrayList<>();

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
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int i) {
        recipeViewHolder.txtTitle.setText(recipes.get(i).getTitle());
        recipeViewHolder.txtShortDesc.setText(recipes.get(i).getShortDesc());
        recipeViewHolder.wv.loadUrl("https://firebasestorage.googleapis.com/v0/b/p2fsdgastro.appspot.com/o/01e1ef88-be15-483b-93b9-b5964a756969.jpg?alt=media&token=c719f0ee-7e6e-4505-9ab9-295440d808fb");

        recipeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(context,Login.class);
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



