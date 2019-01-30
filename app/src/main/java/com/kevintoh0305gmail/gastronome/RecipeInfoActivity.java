package com.kevintoh0305gmail.gastronome;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;

public class RecipeInfoActivity extends AppCompatActivity {

    TextView tvTitle, tvShortDesc, tvServSize;
    Button btnPrepTime, btnDifficulty, btnDietary, btnIngredients, btnSteps, btnNutrition, btnIncrease, btnDecrease;
    ImageButton imgBtnAdd;
    ImageView imgRecipeImage, btnFavourite;
    RecyclerView rvIngredients;
    IngredientsAdapter ingredientsAdapter;
    Button btnSun, btnMon, btnTues, btnWed, btnThurs, btnFri, btnSat, btnCancel, btnAddtoRecipe;
    Boolean sunSelect, monSelect, tuesSelect, wedSelect, thursSelect, friSelect, satSelect;
    ArrayList<String> days = new ArrayList<>();
    FirebaseDatabase database;
    FirebaseAuth mAuth;
    String title;
    int servSize;
    Recipe selectedRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_info);
        mAuth = FirebaseAuth.getInstance();
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
        btnFavourite = findViewById(R.id.btnFav);
        btnIncrease = findViewById(R.id.btnRecipeInfoAddServing);
        btnDecrease = findViewById(R.id.btnRecipeInfoRemoveServing);
        imgBtnAdd = findViewById(R.id.imgBtnAdd);
        imgRecipeImage = findViewById(R.id.imgRecipeImage);
        database = FirebaseDatabase.getInstance();

        rvIngredients.setFocusable(false);
        selectedRecipe = RecipeAdapter.selectedRecipe;
        title = selectedRecipe.getTitle();
        String shortDesc = selectedRecipe.getShortDesc();
        String prepTime = "" + selectedRecipe.getPrepTime();
        String difficulty = selectedRecipe.getDifficulty();
        String dietary = selectedRecipe.getDietary();
        servSize = selectedRecipe.getServSize();
        final ArrayList<String> ingredients = selectedRecipe.getIngredients();
        final ArrayList<String> instructions = selectedRecipe.getInstructions();
        String fats = selectedRecipe.getFats();
        String carbs = selectedRecipe.getCarbs();
        String protein = selectedRecipe.getProtein();
        String sugar = selectedRecipe.getSugar();
        final String salt = selectedRecipe.getSalt();
        final ArrayList<String> nutrients = new ArrayList<>();
        nutrients.add("Calories = " + selectedRecipe.getCalories());
        nutrients.add("Fats = " + fats);
        nutrients.add("Carbs = " + carbs);
        nutrients.add("Protein = " + protein);
        nutrients.add("Sugar = " + sugar);
        nutrients.add("Salt = " + salt);

        tvTitle.setText(title);
        tvShortDesc.setText(shortDesc);
        btnPrepTime.setText(prepTime + " MIN");
        btnDifficulty.setText(difficulty);
        if (dietary.equals("None")) {
            btnDietary.setVisibility(View.INVISIBLE);
        } else {
            btnDietary.setText(dietary);
        }

        tvServSize.setText("" + servSize);

        Picasso.get().load(selectedRecipe.getImageURL()).into(imgRecipeImage);

        imgBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sunSelect = false;
                monSelect = false;
                tuesSelect = false;
                wedSelect = false;
                thursSelect = false;
                friSelect = false;
                satSelect = false;
                imgBtnAddClick();
            }
        });

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

        btnFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Clicked", "Clicked");
                Random random = new Random();
                int n = random.nextInt(900000000) + 999999;
                Favourites addFav;
                addFav = new Favourites(mAuth.getCurrentUser().getEmail(), selectedRecipe);
                database.getReference().child("ZFavs").child(mAuth.getCurrentUser().getUid()).child(title+"-"+n).setValue(addFav);
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

        btnNutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientsAdapter = new IngredientsAdapter(RecipeInfoActivity.this, nutrients);
                rvIngredients.setAdapter(ingredientsAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(RecipeInfoActivity.this);
                rvIngredients.setLayoutManager(manager);
                rvIngredients.setItemAnimator(new DefaultItemAnimator());
                ingredientsAdapter.notifyDataSetChanged();
                btnNutrition.setBackgroundResource(R.drawable.recipe_info_btm_btn_active);
                btnIngredients.setBackgroundResource(R.drawable.recipe_info_btm_btn_inactive);
                btnSteps.setBackgroundResource(R.drawable.recipe_info_btm_btn_inactive);
            }
        });

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String serving = "" + tvServSize.getText();
                int newServe = Integer.parseInt(serving);
                newServe++;
                if(newServe > 10) {
                    newServe = 10;
                }
                servSize = newServe;
                tvServSize.setText(""+newServe);
            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String serving = "" + tvServSize.getText();
                int newServe = Integer.parseInt(serving);
                newServe--;
                if(newServe < 1) {
                    newServe = 1;
                }
                servSize = newServe;
                tvServSize.setText(""+newServe);
            }
        });

        ingredientsAdapter = new IngredientsAdapter(this, ingredients);
        rvIngredients.setAdapter(ingredientsAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(RecipeInfoActivity.this);
        rvIngredients.setLayoutManager(manager);
        rvIngredients.setItemAnimator(new DefaultItemAnimator());
        ingredientsAdapter.notifyDataSetChanged();
    }

    public void imgBtnAddClick() {
        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
        final View view = layoutInflater.inflate(R.layout.logdialog, null);
        btnMon = view.findViewById(R.id.btnMon);
        btnTues = view.findViewById(R.id.btnTues);
        btnWed = view.findViewById(R.id.btnWed);
        btnThurs = view.findViewById(R.id.btnThurs);
        btnFri = view.findViewById(R.id.btnFri);
        btnSat = view.findViewById(R.id.btnSat);
        btnSun = view.findViewById(R.id.btnSun);
        btnAddtoRecipe = view.findViewById(R.id.btnDialogAdd);
        btnCancel = view.findViewById(R.id.btnDialogCancel);
        btnSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sunSelect) {
                    sunSelect = false;
                    btnSun.setBackgroundResource(R.drawable.dialog_button_sun_inactive);
                }
                else {
                    sunSelect = true;
                    btnSun.setBackgroundResource(R.drawable.dialog_button_sun_active);
                }

                }
        });
        btnMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (monSelect) {
                    monSelect = false;
                    btnMon.setBackgroundResource(R.drawable.dialog_button_mon_inactive);
                }
                else {
                    monSelect = true;
                    btnMon.setBackgroundResource(R.drawable.dialog_button_mon_active);
                }
            }
        });

        btnTues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tuesSelect) {
                    tuesSelect = false;
                    btnTues.setBackgroundResource(R.drawable.dialog_button_tue_inactive);
                }
                else {
                    tuesSelect = true;
                    btnTues.setBackgroundResource(R.drawable.dialog_button_tue_active);
                }
            }
        });

        btnWed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wedSelect) {
                    wedSelect = false;
                    btnWed.setBackgroundResource(R.drawable.dialog_button_wed_inactive);
                }
                else {
                    wedSelect = true;
                    btnWed.setBackgroundResource(R.drawable.dialog_button_wed_active);
                }
            }
        });

        btnThurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (thursSelect) {
                    thursSelect = false;
                    btnThurs.setBackgroundResource(R.drawable.dialog_button_thurs_inactive);
                }
                else {
                    thursSelect = true;
                    btnThurs.setBackgroundResource(R.drawable.dialog_button_thurs_active);
                }
            }
        });

        btnFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (friSelect) {
                    friSelect = false;
                    btnFri.setBackgroundResource(R.drawable.dialog_button_fri_inactive);
                }
                else {
                    friSelect = true;
                    btnFri.setBackgroundResource(R.drawable.dialog_button_fri_active);
                }
            }
        });

        btnSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (satSelect) {
                    satSelect = false;
                    btnSat.setBackgroundResource(R.drawable.dialog_button_sat_inactive);
                }
                else {
                    satSelect = true;
                    btnSat.setBackgroundResource(R.drawable.dialog_button_sat_active);
                }
            }
        });

        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(RecipeInfoActivity.this);
        dialogBuilder.setView(view);

        final AlertDialog dialog = dialogBuilder.create();

        dialog.show();



        //dialogBuilder.setCancelable(true)
           //     .create().show();



        btnAddtoRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                days = new ArrayList<>();
                if (monSelect)
                    days.add("1");
                if (tuesSelect)
                    days.add("2");
                if (wedSelect)
                    days.add("3");
                if (thursSelect)
                    days.add("4");
                if (friSelect)
                    days.add("5");
                if (satSelect)
                    days.add("6");
                if (sunSelect)
                    days.add("7");
                Log.d("Tester", days.get(0));
                for (String d : days)
                {
                    Random random = new Random();
                    int n = random.nextInt(900000000) + 999999;
                    int calories = selectedRecipe.getCalories();
                    Logs addLog;
                    addLog = new Logs(d, title, mAuth.getCurrentUser().getEmail(),calories);
                    int calories = selectedRecipe.getCalories();
                    addLog = new Logs(d, title, mAuth.getCurrentUser().getEmail(), calories);
                    database.getReference().child("ZLogs").child(mAuth.getCurrentUser().getUid()).child(title+"-"+n).setValue(addLog);

                }
                dialog.cancel();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });

    }
}
