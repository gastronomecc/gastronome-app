package com.kevintoh0305gmail.gastronome;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class FeedPopularFragment extends Fragment {
    public static final String SHOW_NOTIFICATION = "showNotification";

    RecyclerView rvPopRecipe;
    RecipeAdapter recipeAdapter;
    ArrayList<Recipe> recipes = new ArrayList<>();
    FirebaseDatabase database;
    DatabaseReference ref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed_popular, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvPopRecipe = view.findViewById(R.id.rvPopRecipes);
        setNotificationVisibility();
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
                for(int i=0; i<recipes.size()/2; i++){
                    Recipe tempRecipe = recipes.get(i);
                    recipes.set(i, recipes.get(recipes.size() - i - 1));
                    recipes.set(recipes.size() - i - 1, tempRecipe);
                }

                recipeAdapter = new RecipeAdapter(view.getContext(), recipes);
                rvPopRecipe.setAdapter(recipeAdapter);
                LinearLayoutManager manager = new LinearLayoutManager(view.getContext());
                rvPopRecipe.setLayoutManager(manager);
                rvPopRecipe.setItemAnimator(new DefaultItemAnimator());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("The read failed: " , "" + databaseError.getCode());
            }
        });
    }

    private void setNotificationVisibility() {
        FragmentActivity activity = getActivity();

        TextView tvNotification = activity.findViewById(R.id.tvNotification);
        TextView tvDismissNotification = activity.findViewById(R.id.textView6);

        final SharedPreferences prefs = activity.getPreferences(MODE_PRIVATE);

        if (!prefs.getBoolean(SHOW_NOTIFICATION, true)) {
            tvNotification.setVisibility(View.GONE);
            tvDismissNotification.setVisibility(View.GONE);
        }
        else {
            tvDismissNotification.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean(SHOW_NOTIFICATION, false);
                    editor.commit();
                    setNotificationVisibility();
                }
            });
        }
    }
}
