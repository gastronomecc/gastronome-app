package com.kevintoh0305gmail.gastronome;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MenuFragment extends Fragment {
    private static DecimalFormat df2 = new DecimalFormat(".##");
    RecyclerView rvToday, rvTmr, rvDay3, rvDay4, rvDay5, rvDay6, rvDay7, rvDay8;
    FirebaseDatabase database;
    DatabaseReference logRef, ref;
    RecipeNoAddAdapter recipeAdapter, recipeAdapter2, recipeAdapter3, recipeAdapter4, recipeAdapter5, recipeAdapter6, recipeAdapter7, recipeAdapter8;
    TextView tvTodayDate, tvTomorrowDate,tvDay3Date, tvDay3Day, tvDay4Date, tvDay4Day, tvDay5Date, tvDay5Day, tvDay6Date, tvDay6Day, tvDay7Date, tvDay7Day, tvDay8Date, tvDay8Day;
    Button btnAddFoodLog, btnAddDrinkLog;
    ArrayList<Recipe> recipes = new ArrayList<>();
    ArrayList<Recipe> todayRecipes = new ArrayList<>();
    ArrayList<Recipe> tmrRecipes = new ArrayList<>();
    ArrayList<Recipe> day3Recipes = new ArrayList<>();
    ArrayList<Recipe> day4Recipes = new ArrayList<>();
    ArrayList<Recipe> day5Recipes = new ArrayList<>();
    ArrayList<Recipe> day6Recipes = new ArrayList<>();
    ArrayList<Recipe> day7Recipes = new ArrayList<>();
    ArrayList<Recipe> day8Recipes = new ArrayList<>();
    FirebaseAuth mAuth;
    Calendar cal;
    double totalCal;
    SimpleDateFormat dayFormat, dateFormat, dateNumberFormat;
    Date currentDay;
    double userWeight;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cal = Calendar.getInstance();
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        totalCal = 0;
        //tvEstWeight = view.findViewById(R.id.tvEstWeight);
        //tvWelcomeUser = view.findViewById(R.id.tvWelcomeUser);

        btnAddFoodLog = view.findViewById(R.id.btnLogFood);
        btnAddDrinkLog = view.findViewById(R.id.btnLogWater);

        //Day Text View
        //Today
        tvTodayDate = view.findViewById(R.id.tvTodayDate);
        //Tomorrow
        tvTomorrowDate = view.findViewById(R.id.tvTommorowDate);
        //3rd Day
        tvDay3Date = view.findViewById(R.id.tvDay3Date);
        tvDay3Day = view.findViewById(R.id.tvDay3Day);
        //4th Day
        tvDay4Date = view.findViewById(R.id.tvDay4Date);
        tvDay4Day = view.findViewById(R.id.tvDay4Day);
        //5th Day
        tvDay5Date = view.findViewById(R.id.tvDay5Date);
        tvDay5Day = view.findViewById(R.id.tvDay5Day);
        //6th Day
        tvDay6Date = view.findViewById(R.id.tvDay6Date);
        tvDay6Day = view.findViewById(R.id.tvDay6Day);
        //7th Day
        tvDay7Date = view.findViewById(R.id.tvDay7Date);
        tvDay7Day = view.findViewById(R.id.tvDay7Day);
        //8th Day
        tvDay8Date = view.findViewById(R.id.tvDay8Date);
        tvDay8Day = view.findViewById(R.id.tvDay8Day);


        //Wed is 4
        Log.d("Day", ""+ cal.get(Calendar.DAY_OF_WEEK));
        currentDay = cal.getTime();
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd MMM");
        dateNumberFormat = new SimpleDateFormat("dd");


        //Recycler View Allow User to see recipes they have logged 7 days from the current date
        rvToday = view.findViewById(R.id.rvToday);
        rvTmr = view.findViewById(R.id.rvTmr);
        rvDay3 = view.findViewById(R.id.rvDay3);
        rvDay4 = view.findViewById(R.id.rvDay4);
        rvDay5 = view.findViewById(R.id.rvDay5);
        rvDay6 = view.findViewById(R.id.rvDay6);
        rvDay7 = view.findViewById(R.id.rvDay7);
        rvDay8 = view.findViewById(R.id.rvDay8);

        btnAddFoodLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetFoodLogDialogFragment();
            }
        });

        btnAddDrinkLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDrinkLogDialogFragment();
            }
        });


        GetDates();
        GetRecipes();
        //GetUserName();

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

        logRef = database.getReference("ZLogs").child(mAuth.getCurrentUser().getUid());
        logRef.addValueEventListener(new ValueEventListener() {
            ArrayList<Recipe> todayRecipes = new ArrayList<>();
            ArrayList<Recipe> tmrRecipes = new ArrayList<>();
            ArrayList<Recipe> day3Recipes = new ArrayList<>();
            ArrayList<Recipe> day4Recipes = new ArrayList<>();
            ArrayList<Recipe> day5Recipes = new ArrayList<>();
            ArrayList<Recipe> day6Recipes = new ArrayList<>();
            ArrayList<Recipe> day7Recipes = new ArrayList<>();
            ArrayList<Recipe> day8Recipes = new ArrayList<>();
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds:  dataSnapshot.getChildren()) {
                    Logs log = ds.getValue(Logs.class);
                    if (log.getDay().equals("" + cal.get(Calendar.DAY_OF_WEEK))) { // FOR TODAY
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                todayRecipes.add(r);
                                totalCal += r.getCalories();
                            }
                        }
                    }
                    if (log.getDay().equals("" + DaySet(cal.get(Calendar.DAY_OF_WEEK) + 1))) {
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                tmrRecipes.add(r);
                                totalCal += r.getCalories();
                            }
                        }
                    }
                    if (log.getDay().equals(""+ DaySet(cal.get(Calendar.DAY_OF_WEEK) + 2))) {
                        for (Recipe r: recipes) {
                            if (log.getTitle().equals(r.getTitle())){
                                day3Recipes.add(r);
                                totalCal += r.getCalories();
                            }
                        }
                    }
                    if (log.getDay().equals(""+ DaySet(cal.get(Calendar.DAY_OF_WEEK) + 3))) {
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                day4Recipes.add(r);
                                totalCal += r.getCalories();
                            }
                        }
                    }
                    if (log.getDay().equals(""+ DaySet(cal.get(Calendar.DAY_OF_WEEK) + 4))) {
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                day5Recipes.add(r);
                                totalCal += r.getCalories();
                            }
                        }
                    }
                    if (log.getDay().equals(""+ DaySet(cal.get(Calendar.DAY_OF_WEEK) + 5))) {
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                day6Recipes.add(r);
                                totalCal += r.getCalories();
                            }
                        }
                    }
                    if (log.getDay().equals(""+DaySet(cal.get(Calendar.DAY_OF_WEEK) + 6))) {
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                day7Recipes.add(r);
                                totalCal += r.getCalories();
                            }
                        }
                    }
                    if (log.getDay().equals(""+DaySet(cal.get(Calendar.DAY_OF_WEEK) + 7))) {
                        for (Recipe r : recipes) {
                            if (log.getTitle().equals(r.getTitle())) {
                                day8Recipes.add(r);
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

//                Log.d("Total Calories: ", "" + totalCal);
//                double supposedCal = 8800;
//                double excessCal = supposedCal - totalCal;
//
//                double weightChange = excessCal/8;
//                double changeInG = weightChange / 1000;
//
//                Log.d("Weight Changed: ", "" +  changeInG);
//
//                //GET THE USER WEIGHT
//                double userWeight = 60;
//                double newWeight = userWeight - changeInG;
//                Log.d("New Weight: " , "" + df2.format(newWeight));

                //tvEstWeight.setText("Estimated Weight after the week: " + df2.format(newWeight) + "kg");

                recipeAdapter = new RecipeNoAddAdapter(getContext(), todayRecipes);
                rvToday.setAdapter(recipeAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                rvToday.setLayoutManager(manager);
                rvToday.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter2 = new RecipeNoAddAdapter(getContext(), tmrRecipes);
                rvTmr.setAdapter(recipeAdapter2);
                LinearLayoutManager manager2 = new LinearLayoutManager(getContext());
                rvTmr.setLayoutManager(manager2);
                rvTmr.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter3 = new RecipeNoAddAdapter(getContext(), day3Recipes);
                rvDay3.setAdapter(recipeAdapter3);
                LinearLayoutManager manager3 = new LinearLayoutManager(getContext());
                rvDay3.setLayoutManager(manager3);
                rvDay4.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter4 = new RecipeNoAddAdapter(getContext(), day4Recipes);
                rvDay4.setAdapter(recipeAdapter4);
                LinearLayoutManager manager4 = new LinearLayoutManager(getContext());
                rvDay4.setLayoutManager(manager4);
                rvDay4.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter5 = new RecipeNoAddAdapter(getContext(), day5Recipes);
                rvDay5.setAdapter(recipeAdapter5);
                LinearLayoutManager manager5 = new LinearLayoutManager(getContext());
                rvDay5.setLayoutManager(manager5);
                rvDay5.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter6 = new RecipeNoAddAdapter(getContext(), day6Recipes);
                rvDay6.setAdapter(recipeAdapter6);
                LinearLayoutManager manager6 = new LinearLayoutManager(getContext());
                rvDay6.setLayoutManager(manager6);
                rvDay6.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter7 = new RecipeNoAddAdapter(getContext(), day7Recipes);
                rvDay7.setAdapter(recipeAdapter7);
                LinearLayoutManager manager7 = new LinearLayoutManager(getContext());
                rvDay7.setLayoutManager(manager7);
                rvDay7.setItemAnimator(new DefaultItemAnimator());

                recipeAdapter8 = new RecipeNoAddAdapter(getContext(), day8Recipes);
                rvDay8.setAdapter(recipeAdapter8);
                LinearLayoutManager manager8= new LinearLayoutManager(getContext());
                rvDay8.setLayoutManager(manager8);
                rvDay8.setItemAnimator(new DefaultItemAnimator());
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
    /*
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
    */

    public void GetDates()
    {
        tvTodayDate.setText(dayFormat.format(currentDay).substring(0,3) + " " + dateFormat.format(currentDay));
        cal.add(Calendar.DAY_OF_YEAR, 1);
        tvTomorrowDate.setText(dayFormat.format(cal.getTime()).substring(0,3) + " " + dateFormat.format(cal.getTime()));
        cal.add(Calendar.DAY_OF_YEAR, 1);
        tvDay3Date.setText(dateFormat.format(cal.getTime()));
        tvDay3Day.setText(dayFormat.format(cal.getTime()));
        cal.add(Calendar.DAY_OF_YEAR, 1);
        tvDay4Date.setText(dateFormat.format(cal.getTime()));
        tvDay4Day.setText(dayFormat.format(cal.getTime()));
        cal.add(Calendar.DAY_OF_YEAR, 1);
        tvDay5Date.setText(dateFormat.format(cal.getTime()));
        tvDay5Day.setText(dayFormat.format(cal.getTime()));
        cal.add(Calendar.DAY_OF_YEAR, 1);
        tvDay6Date.setText(dateFormat.format(cal.getTime()));
        tvDay6Day.setText(dayFormat.format(cal.getTime()));
        cal.add(Calendar.DAY_OF_YEAR, 1);
        tvDay7Date.setText(dateFormat.format(cal.getTime()));
        tvDay7Day.setText(dayFormat.format(cal.getTime()));
        cal.add(Calendar.DAY_OF_YEAR, 1);
        tvDay8Date.setText(dateFormat.format(cal.getTime()));
        tvDay8Day.setText(dayFormat.format(cal.getTime()));
    }

    public int DaySet(int dayValue)
    {
        int day = dayValue%7;
        if(day == 0)
        {
            return 7;
        }
        else {
            return day;
        }
    }

    public void showBottomSheetFoodLogDialogFragment() {
        BottomSheetFoodLogFragment bottomSheetFragment = new BottomSheetFoodLogFragment();
        bottomSheetFragment.show(getFragmentManager(), bottomSheetFragment.getTag());
    }

    public void showBottomSheetDrinkLogDialogFragment() {
        BottomSheetDrinkLogFragment bottomSheetFragment = new BottomSheetDrinkLogFragment();
        bottomSheetFragment.show(getFragmentManager(), bottomSheetFragment.getTag());
    }

}
