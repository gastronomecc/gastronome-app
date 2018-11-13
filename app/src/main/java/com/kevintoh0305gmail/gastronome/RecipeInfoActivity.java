package com.kevintoh0305gmail.gastronome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecipeInfoActivity extends AppCompatActivity {

    TextView tvTitle, tvShortDesc, tvServSize;
    Button btnPrepTime, btnDifficulty, btnDietary, btnIngredients, btnSteps, btnNutrition;
    RecyclerView rvIngredients;
    IngredientsAdapter ingredientsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);

        tvTitle = findViewById(R.id.tvTitle);
        tvShortDesc = findViewById(R.id.tvShortDesc);
        tvServSize = findViewById(R.id.tvServingQuantity);
        btnPrepTime = findViewById(R.id.btnRecipeInfoPrepTimeHashtag);
        btnDifficulty = findViewById(R.id.btnRecipeInfoDifficultyHashtag);
        btnDietary = findViewById(R.id.btnRecipeInfoMealType);
        rvIngredients = findViewById(R.id.rvIngredients);
        btnIngredients = findViewById(R.id.btnReicpeInfoIngredients);
        btnSteps = findViewById(R.id.btnRecipeInfoSteps);
        btnNutrition = findViewById(R.id.btnRecipeInfoNutrition);

        Recipe selectedRecipe = RecipeAdapter.selectedRecipe;
        String title = selectedRecipe.getTitle();
        String shortDesc = selectedRecipe.getShortDesc();
        String prepTime = "" + selectedRecipe.getPrepTime();
        String difficulty = selectedRecipe.getDifficulty();
        String dietary = selectedRecipe.getDietary();
        long servSize = selectedRecipe.getServSize();
        final ArrayList<String> ingredients = selectedRecipe.getIngredients();
        final ArrayList<String> instructions = selectedRecipe.getInstructions();

        tvTitle.setText(title);
        tvShortDesc.setText(shortDesc);
        btnPrepTime.setText(prepTime + " MIN");
        btnDifficulty.setText(difficulty);
        if (dietary.equals("None"))
        {
            btnDietary.setVisibility(View.INVISIBLE);
        }
        else
        {
            btnDietary.setText(dietary);
        }

        tvServSize.setText("" + servSize);



        btnIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientsAdapter = new IngredientsAdapter(RecipeInfoActivity.this, ingredients);
                rvIngredients.setAdapter(ingredientsAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(RecipeInfoActivity.this);
                rvIngredients.setLayoutManager(manager);
                rvIngredients.setItemAnimator(new DefaultItemAnimator());
                ingredientsAdapter.notifyDataSetChanged();
                btnIngredients.setBackgroundResource(R.drawable.recipe_info_btm_btn_active);
                btnSteps.setBackgroundResource(R.drawable.recipe_info_btm_btn_inactive);
                btnNutrition.setBackgroundResource(R.drawable.recipe_info_btm_btn_inactive);
            }
        });

        btnSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientsAdapter = new IngredientsAdapter(RecipeInfoActivity.this, instructions);
                rvIngredients.setAdapter(ingredientsAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(RecipeInfoActivity.this);
                rvIngredients.setLayoutManager(manager);
                rvIngredients.setItemAnimator(new DefaultItemAnimator());
                ingredientsAdapter.notifyDataSetChanged();
                btnSteps.setBackgroundResource(R.drawable.recipe_info_btm_btn_active);
                btnIngredients.setBackgroundResource(R.drawable.recipe_info_btm_btn_inactive);
                btnNutrition.setBackgroundResource(R.drawable.recipe_info_btm_btn_inactive);
            }
        });

        ingredientsAdapter = new IngredientsAdapter(this, ingredients);
        rvIngredients.setAdapter(ingredientsAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(RecipeInfoActivity.this);
        rvIngredients.setLayoutManager(manager);
        rvIngredients.setItemAnimator(new DefaultItemAnimator());
        ingredientsAdapter.notifyDataSetChanged();
    }
}
