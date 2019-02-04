package com.kevintoh0305gmail.gastronome;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import android.widget.TextView;

public class IngredientsViewHolder extends RecyclerView.ViewHolder {

    public TextView txtIngredients;
    public View view;
    private Context context;

    public IngredientsViewHolder(View v, Context c)
    {
        super(v);
        view = v;
        txtIngredients = v.findViewById(R.id.txtIngredients);
        context = c;
    }
}
