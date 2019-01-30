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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FavouritesFragment extends Fragment {
    ArrayList<Recipe> favRecipes = new ArrayList<>();

    FirebaseDatabase database;
    FirebaseAuth mAuth;
    RecipeNoAddAdapter recipeAdapter;
    DatabaseReference favRef, recipeRef;
    LinearLayoutManager manager;
    RecyclerView rvFavs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favourites_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvFavs = view.findViewById(R.id.rvFav);


        favRef = database.getInstance().getReference("ZFavs").child(mAuth.getInstance().getCurrentUser().getUid());
        favRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    Favourites fav = ds.getValue(Favourites.class);
                    favRecipes.add(fav.getRecipe());
                }

                recipeAdapter = new RecipeNoAddAdapter(getContext(), favRecipes);
                rvFavs.setAdapter(recipeAdapter);
                manager = new LinearLayoutManager(getContext());
                rvFavs.setLayoutManager(manager);
                rvFavs.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("The read failed: " , "" + databaseError.getCode());
            }
        });
    }
}
