package com.kevintoh0305gmail.gastronome.viewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import android.widget.TextView;

import com.kevintoh0305gmail.gastronome.R;

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
