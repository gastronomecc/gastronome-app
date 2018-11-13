package com.kevintoh0305gmail.gastronome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    RecyclerView rvRecipe;
    RecipeAdapter recipeAdapter;
    ArrayList<Recipe> recipes = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        rvRecipe = findViewById(R.id.rvRecipes);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Recipes");
        ref.addValueEventListener(new ValueEventListener() {
                                      @Override
                                      public void onDataChange(DataSnapshot dataSnapshot) {
                                          for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                              Log.d("TEST", "TEST");
                                              Recipe recipe = ds.getValue(Recipe.class);
                                              recipes.add(recipe);
                                          }
                                          recipeAdapter = new RecipeAdapter(RecipeActivity.this, recipes);
                                          rvRecipe.setAdapter(recipeAdapter);
                                          LinearLayoutManager manager = new LinearLayoutManager(RecipeActivity.this);
                                          rvRecipe.setLayoutManager(manager);
                                          rvRecipe.setItemAnimator(new DefaultItemAnimator());
                                      }

                                      @Override
                                      public void onCancelled(DatabaseError databaseError) {
                                          Log.d("The read failed: " , "" + databaseError.getCode());
                                      }
                                  });
    }
}


