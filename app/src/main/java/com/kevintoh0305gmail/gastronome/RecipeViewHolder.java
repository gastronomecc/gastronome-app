package com.kevintoh0305gmail.gastronome;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeViewHolder extends RecyclerView.ViewHolder{
    
    public TextView txtTitle;
    public TextView txtShortDesc;
    public View view;
    public Button btnPrepTime;
    public Button btnDifficulty;
    public Button btnMealType;
    public ImageView imgRecipe;
    public ImageButton btnAddRecipe;
    private Context context;

    public RecipeViewHolder(View v, Context c)
    {
        super(v);
        view = v;
        txtTitle = v.findViewById(R.id.txtTitle);
        txtShortDesc = v.findViewById(R.id.txtShortDesc);
        btnPrepTime = v.findViewById(R.id.btnPrepTimeTag);
        btnMealType = v.findViewById(R.id.btnMealTypeTag);
        btnDifficulty = v.findViewById(R.id.btnDifficultyTag);
        btnAddRecipe = v.findViewById(R.id.imgBtnAddRecipe);
        imgRecipe = v.findViewById(R.id.imgIndex);
        context = c;
    }
}
