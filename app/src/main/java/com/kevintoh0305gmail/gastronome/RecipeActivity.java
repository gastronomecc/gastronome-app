package com.kevintoh0305gmail.gastronome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    RecyclerView rvRecipe;
    RecipeAdapter recipeAdapter;
    List<Recipe> recipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        rvRecipe = findViewById(R.id.rvRecipes);

        Recipe r = new Recipe();
        r.setTitle("TEST1");
        r.setShortDesc("TEST2");
        recipes.add(r);
        r = new Recipe();
        r.setTitle("TEST1");
        r.setShortDesc("TEST2");
        recipes.add(r);
        r = new Recipe();
        r.setTitle("TEST1");
        r.setShortDesc("TEST2");
        recipes.add(r);
        r = new Recipe();
        r.setTitle("TEST1");
        r.setShortDesc("TEST2");
        recipes.add(r);
        r = new Recipe();
        r.setTitle("TEST1");
        r.setShortDesc("TEST2");
        recipes.add(r);
        r = new Recipe();
        r.setTitle("TEST1");
        r.setShortDesc("TEST2");
        recipes.add(r);

        recipeAdapter = new RecipeAdapter();
        recipeAdapter.recipes = recipes;
        rvRecipe.setAdapter(recipeAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvRecipe.setLayoutManager(manager);
        rvRecipe.setItemAnimator(new DefaultItemAnimator());

    }
}
