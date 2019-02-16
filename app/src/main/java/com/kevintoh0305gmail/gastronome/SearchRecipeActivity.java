package com.kevintoh0305gmail.gastronome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SearchRecipeActivity extends AppCompatActivity {

    EditText txtSearch;
    RecyclerView rvSearchRecipes;
    ImageButton btnBack;
    FirebaseDatabase firebaseDatabase;
    ArrayList<Recipe> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipe);
        txtSearch = findViewById(R.id.txtSearchRecipeName);
        rvSearchRecipes = findViewById(R.id.rvSearchRecipes);
        btnBack = findViewById(R.id.btnSearchRecipeBack);
        firebaseDatabase = FirebaseDatabase.getInstance();
        data = new ArrayList<>();
        GetRecipeData();

        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchQuery = txtSearch.getText().toString();
                GetSearchResults(searchQuery);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void GetRecipeData()
    {
        firebaseDatabase.getReference("Recipes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    data.add(ds.getValue(Recipe.class));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Database Error", databaseError.getCode() + " : " + databaseError.getMessage());
            }
        });
    }


    public void GetSearchResults(String searchQuery) {
        Log.d("RecipeData", data.get(0).title);
        ArrayList<Recipe> results = new ArrayList<>();
        for (int i = 0; i < data.size(); i++)
        {
            if(data.get(i).getTitle().toLowerCase().contains(searchQuery.toLowerCase()))
            {
                results.add(data.get(i));
                Log.d("Results", data.get(i).title);
            }
        }
        RecipeAdapter recipeAdapter = new RecipeAdapter(this, results);
        rvSearchRecipes.setAdapter(recipeAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvSearchRecipes.setLayoutManager(manager);
        rvSearchRecipes.setItemAnimator(new DefaultItemAnimator());
    }
}
