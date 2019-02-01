package com.kevintoh0305gmail.gastronome;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class LogFragment extends Fragment {
    private static DecimalFormat df2 = new DecimalFormat(".##");
    RecyclerView rvToday, rvTmr, rvSat, rvSun;
    FirebaseDatabase database;
    DatabaseReference logRef, ref;
    RecipeNoAddAdapter recipeAdapter, recipeAdapter2, recipeAdapter3, recipeAdapter4;
    TextView tvWelcomeUser, tvEstWeight;
    ArrayList<Recipe> recipes = new ArrayList<>();
    ArrayList<Recipe> logRecipes = new ArrayList<>();
    ArrayList<Recipe> tmrRecipes = new ArrayList<>();
    ArrayList<Recipe> satRecipes = new ArrayList<>();
    ArrayList<Recipe> sunRecipes = new ArrayList<>();
    FirebaseAuth mAuth;
    Calendar cal;
    double totalCal;
    double userWeight;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cal = Calendar.getInstance();
        database = FirebaseDatabase.getInstance();
        totalCal = 0;
        tvEstWeight = view.findViewById(R.id.tvEstWeight);
        tvWelcomeUser = view.findViewById(R.id.tvWelcomeUser);

        //Wed is 4
        Log.d("Day", ""+ cal.get(Calendar.DAY_OF_WEEK));


        rvToday = view.findViewById(R.id.rvToday);
        rvTmr = view.findViewById(R.id.rvTmr);
        rvSat = view.findViewById(R.id.rvSat);
        rvSun = view.findViewById(R.id.rvSun);

        //GET THE USER WEIGHT
        final String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        DatabaseReference dataRef = database.getReference("Users");
        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    User user = ds.getValue(User.class);
                    Log.d("1st Email: ", user.getEmail());
                    Log.d("2nd Email: ", email);
                    if (user.getEmail().equals(email))
                    {
                        userWeight =  user.getWeight();
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //final String Uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        //mAuth.getCurrentUser().getEmail();

        //Log.d("Email:", userEmail);
        //Log.d("UID", mAuth.getCurrentUser().getUid() );

        GetRecipes();
        GetUserName();
        logRef = database.getReference("ZLogs");
        logRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Recipe> logRecipes = new ArrayList<>();
                ArrayList<Recipe> tmrRecipes = new ArrayList<>();
                ArrayList<Recipe> satRecipes = new ArrayList<>();
                ArrayList<Recipe> sunRecipes = new ArrayList<>();
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    Logs log = ds.getValue(Logs.class);
                    //if (log.getEmail().equals("dom@gmail.com")) { //NEED CHANGE
                    if (log.getDay().equals("" + cal.get(Calendar.DAY_OF_WEEK))) { // FOR TODAY
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                logRecipes.add(r);
                                totalCal += r.getCalories();
                            }
                        }
                    }
                    if (log.getDay().equals("" + (cal.get(Calendar.DAY_OF_WEEK) + 1))) {
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                tmrRecipes.add(r);
                                totalCal += r.getCalories();
                            }
                        }
                    }
                    if (log.getDay().equals("7")) {
                        for (Recipe r: recipes) {
                            if (log.getTitle().equals(r.getTitle())){
                                Log.d("SAT", "SAT");
                                satRecipes.add(r);
                                totalCal += r.getCalories();
                            }
                        }
                    }
                    if (log.getDay().equals("1")) {
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                sunRecipes.add(r);
                                totalCal += r.getCalories();
                            }

                        }
                    }
                }

                Log.d("Total Calories: ", "" + totalCal);
                double supposedCal = 12250;
                double excessCal = supposedCal - totalCal;

                double weightChange = excessCal/8;
                double changeInG = weightChange / 1000;

                Log.d("Weight Changed: ", "" +  changeInG);



                double newWeight = userWeight - changeInG;
                Log.d("New Weight: " , "" + df2.format(newWeight));

                tvEstWeight.setText("Estimated Weight after the week: " + df2.format(newWeight) + "kg");




                recipeAdapter = new RecipeNoAddAdapter(getContext(), logRecipes);
                rvToday.setAdapter(recipeAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                rvToday.setLayoutManager(manager);
                rvToday.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter2 = new RecipeNoAddAdapter(getContext(), tmrRecipes);
                rvTmr.setAdapter(recipeAdapter2);
                LinearLayoutManager manager2 = new LinearLayoutManager(getContext());
                rvTmr.setLayoutManager(manager2);
                rvTmr.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter3 = new RecipeNoAddAdapter(getContext(), satRecipes);
                rvSat.setAdapter(recipeAdapter3);
                LinearLayoutManager manager3 = new LinearLayoutManager(getContext());
                rvSat.setLayoutManager(manager3);
                rvSat.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter4 = new RecipeNoAddAdapter(getContext(), sunRecipes);
                rvSun.setAdapter(recipeAdapter4);
                LinearLayoutManager manager4 = new LinearLayoutManager(getContext());
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

    public void GetUserName()
    {
        DatabaseReference reference = database.getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("name");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.getValue(String.class);
                tvWelcomeUser.setText("Welcome, "+ name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Retrieval failed: " , "" + databaseError.getCode());
            }
        });
    }

}
