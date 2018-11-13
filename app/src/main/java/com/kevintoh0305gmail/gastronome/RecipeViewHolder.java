package com.kevintoh0305gmail.gastronome;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeViewHolder extends RecyclerView.ViewHolder{

    public ImageView imgRecipe;
    public TextView txtTitle;
    public TextView txtShortDesc;

    public RecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        imgRecipe = itemView.findViewById(R.id.imgRecipe);
        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtShortDesc = itemView.findViewById(R.id.txtShortDesc);
    }

}
