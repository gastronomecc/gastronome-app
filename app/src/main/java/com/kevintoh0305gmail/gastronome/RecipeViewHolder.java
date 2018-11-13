package com.kevintoh0305gmail.gastronome;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeViewHolder extends RecyclerView.ViewHolder{

    public ImageView imgRecipe;
    public TextView txtTitle;
    public TextView txtShortDesc;
    public View view;
    private Context context;

    public RecipeViewHolder(View v, Context c)
    {
        super(v);
        view = v;
        imgRecipe = v.findViewById(R.id.imgRecipe);
        txtTitle = v.findViewById(R.id.txtTitle);
        txtShortDesc = v.findViewById(R.id.txtShortDesc);
        context = c;
    }


}
