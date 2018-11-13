package com.kevintoh0305gmail.gastronome;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InstructionsViewHolder extends RecyclerView.ViewHolder {
    public TextView txtInstructions;
    public ImageView imgIndex;
    public View view;
    private Context context;

    public InstructionsViewHolder(View v, Context c)
    {
        super(v);
        view = v;
        txtInstructions = v.findViewById(R.id.txtInstructions);
        context = c;
    }
}
