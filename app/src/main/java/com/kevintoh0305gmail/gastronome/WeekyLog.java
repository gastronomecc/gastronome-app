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


    RecyclerView rvToday, rvTmr, rvSat, rvSun;
    FirebaseDatabase database;
    DatabaseReference logRef, ref;
    RecipeNoAddAdapter recipeAdapter, recipeAdapter2, recipeAdapter3, recipeAdapter4;
    ArrayList<Recipe> recipes = new ArrayList<>();
    ArrayList<Recipe> logRecipes = new ArrayList<>();
    ArrayList<Recipe> tmrRecipes = new ArrayList<>();
    ArrayList<Recipe> satRecipes = new ArrayList<>();
    ArrayList<Recipe> sunRecipes = new ArrayList<>();
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
        rvTmr = findViewById(R.id.rvTmr);
        rvSat = findViewById(R.id.rvSat);
        rvSun = findViewById(R.id.rvSun);
        //final String Uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        database = FirebaseDatabase.getInstance();
        //String userEmail = mAuth.getCurrentUser().getEmail();
        //Log.d("Email:", userEmail);
        //Log.d("UID", mAuth.getCurrentUser().getUid() );

        GetRecipes();


        logRef = database.getReference("ZLogs");
        logRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    Logs log = ds.getValue(Logs.class);
                    //if (log.getEmail().equals("dom@gmail.com")) { //NEED CHANGE
                    if (log.getDay().equals("" + cal.get(Calendar.DAY_OF_WEEK))) { // FOR TODAY
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                logRecipes.add(r);
                            }
                        }
                        //}
                    }
                    if (log.getDay().equals("" + (cal.get(Calendar.DAY_OF_WEEK) + 1))) {
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                tmrRecipes.add(r);
                            }
                        }
                    }
                    if (log.getDay().equals("7")) {
                        for (Recipe r: recipes) {
                            if (log.getTitle().equals(r.getTitle())){
                                Log.d("SAT", "SAT");
                                satRecipes.add(r);
                            }
                        }
                    }
                    if (log.getDay().equals("1")) {
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                sunRecipes.add(r);
                            }

                        }
                    }
                }

                recipeAdapter = new RecipeNoAddAdapter(WeekyLog.this, logRecipes);
                rvToday.setAdapter(recipeAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(WeekyLog.this);
                rvToday.setLayoutManager(manager);
                rvToday.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter2 = new RecipeNoAddAdapter(WeekyLog.this, tmrRecipes);
                rvTmr.setAdapter(recipeAdapter2);
                LinearLayoutManager manager2 = new LinearLayoutManager(WeekyLog.this);
                rvTmr.setLayoutManager(manager2);
                rvTmr.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter3 = new RecipeNoAddAdapter(WeekyLog.this, satRecipes);
                rvSat.setAdapter(recipeAdapter3);
                LinearLayoutManager manager3 = new LinearLayoutManager(WeekyLog.this);
                rvSat.setLayoutManager(manager3);
                rvSat.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter4 = new RecipeNoAddAdapter(WeekyLog.this, sunRecipes);
                rvSun.setAdapter(recipeAdapter4);
                LinearLayoutManager manager4 = new LinearLayoutManager(WeekyLog.this);
                rvSun.setLayoutManager(manager4);
                rvSun.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("The read failed: " , "" + databaseError.getCode());
            }
        });
    }

    public void GetRecipes()
    {
        ref = database.getReference("Recipes");




        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("Am i second?", "TEST");
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Recipe recipe = ds.getValue(Recipe.class);
                    recipes.add(recipe);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("The read failed: " , "" + databaseError.getCode());
            }
        });

    }
}



