package com.kevintoh0305gmail.gastronome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class RecipeInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);

        Recipe selectedRecipe = RecipeAdapter.selectedRecipe;
        String title = selectedRecipe.getTitle();
        String shortDesc = selectedRecipe.getShortDesc();
        String prepTime = "" + selectedRecipe.getPrepTime();
        String difficulty = selectedRecipe.getDifficulty();
        String dietary = selectedRecipe.getDietary();
        long servSize = selectedRecipe.getServSize();
        List<String> ingredients = selectedRecipe.getIngredients();
        List<String> instructions = selectedRecipe.getInstructions();



        }
}
