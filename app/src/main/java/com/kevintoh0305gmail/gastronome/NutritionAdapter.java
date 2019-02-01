package com.kevintoh0305gmail.gastronome;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NutritionAdapter extends RecyclerView.Adapter<NutritionViewHolder> {
    Context context;
    ArrayList<String> nutritions;

    public NutritionAdapter(Context c, ArrayList<String> l)
    {
        context = c;
        nutritions = l;
    }

    public NutritionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.nutritionviewholder,parent,false);
        return new NutritionViewHolder(item, context);
    }

    @Override
    public void onBindViewHolder(@NonNull NutritionViewHolder nutritionViewHolder, int i) {
        nutritionViewHolder.txtNutritions.setText(nutritions.get(i));
    }

    @Override
    public int getItemCount() {
        return nutritions.size();
    }
}
