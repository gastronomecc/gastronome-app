package com.kevintoh0305gmail.gastronome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class WeekyLog extends AppCompatActivity {


    RecyclerView rvToday;
    FirebaseDatabase database;
    DatabaseReference ref, logRef;
    RecipeNoAddAdapter recipeAdapter;
    ArrayList<Recipe> recipes = new ArrayList<>();
    ArrayList<Recipe> logRecipes = new ArrayList<>();
    FirebaseAuth mAuth;
    Calendar cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weeky_log);
        cal = Calendar.getInstance();


        //Wed is 4
        Log.d("Day", ""+ cal.get(Calendar.DAY_OF_WEEK));


        rvToday = findViewById(R.id.rvToday);
        //final String Uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        database = FirebaseDatabase.getInstance();
        //Log.d("UID", mAuth.getCurrentUser().getUid() );
        ref = database.getReference("Recipes");
        Log.d("TEST", "TEST");

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

        logRef = database.getReference("Logs");
        logRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    Logs log = ds.getValue(Logs.class);
                    //if (log.getEmail().equals("dom@gmail.com")) { //NEED CHANGE
                        if (log.getDay().equals("" + cal.get(Calendar.DAY_OF_WEEK))) { // FOR TODAY
                            Log.d("WOOHOO", "WOO");
                            for (Recipe r : recipes) {
                                if (log.getTitle().equals(r.getTitle())) {
                                    logRecipes.add(r);
                                }
                            }
                        //}

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("The read failed: " , "" + databaseError.getCode());
            }
        });
    }
}

