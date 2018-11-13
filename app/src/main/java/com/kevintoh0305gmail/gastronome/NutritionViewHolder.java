package com.kevintoh0305gmail.gastronome;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class NutritionViewHolder extends RecyclerView.ViewHolder {
    public TextView txtNutritions;
    public View view;
    private Context context;

    public NutritionViewHolder(View v, Context c)
    {
        super(v);
        view = v;
        txtNutritions = v.findViewById(R.id.txtNutritions);
        context = c;
    }


}
