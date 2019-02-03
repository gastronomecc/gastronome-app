package com.kevintoh0305gmail.gastronome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Favourites_Activity extends AppCompatActivity {
    ArrayList<Recipe> favRecipes = new ArrayList<>();

    FirebaseDatabase database;
    FirebaseAuth mAuth;
    RecipeNoAddAdapter recipeAdapter;
    DatabaseReference favRef, recipeRef;
    LinearLayoutManager manager;
    RecyclerView rvFavs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_favourites_);

        rvFavs = findViewById(R.id.rvFav);


        favRef = database.getInstance().getReference("ZFavs").child(mAuth.getInstance().getCurrentUser().getUid());
        favRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    Favourites fav = ds.getValue(Favourites.class);
                    favRecipes.add(fav.getRecipe());
                }

                recipeAdapter = new RecipeNoAddAdapter(getApplicationContext(), favRecipes);
                rvFavs.setAdapter(recipeAdapter);
                manager = new LinearLayoutManager(getApplicationContext());
                rvFavs.setLayoutManager(manager);
                rvFavs.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("The read failed: " , "" + databaseError.getCode());
            }
        });
    }

   /* public Recipe getRecipes() {
        Recipe recipe;
        recipeRef = database.getInstance().getReference("Recipes");
    }*/
}

