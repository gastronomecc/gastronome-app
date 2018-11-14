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

public class WeekyLog extends AppCompatActivity {


    RecyclerView rvToday;
    FirebaseDatabase database;
    DatabaseReference ref;
    RecipeNoAddAdapter recipeAdapter;
    ArrayList<Recipe> recipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weeky_log);

        //rvToday = findViewById(R.id.rvToday);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Recipes");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Recipe recipe = ds.getValue(Recipe.class);
                    recipes.add(recipe);
                }
                recipeAdapter = new RecipeNoAddAdapter(WeekyLog.this, recipes);
                rvToday.setAdapter(recipeAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(WeekyLog.this);
                rvToday.setLayoutManager(manager);
                rvToday.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("The read failed: " , "" + databaseError.getCode());
            }
        });
    }
}

