package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseGoal extends AppCompatActivity {
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_goal);
        btnBack = findViewById(R.id.btnChooseGoalBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseGoal.this, HelloPage.class));
            }
        });
    }
    public void onLoseWeightClick(View view){
        HelloPage.profile.setGoal("Lose weight");
        startActivity(new Intent(ChooseGoal.this, GenderSelection.class));
    }
    public void onGetFitterClick(View view){
        HelloPage.profile.setGoal("Get fitter");
        startActivity(new Intent(ChooseGoal.this, GenderSelection.class));
    }
    public void onGainMuscle(View view){
        HelloPage.profile.setGoal("Gain muscle");
        startActivity(new Intent(ChooseGoal.this, GenderSelection.class));
    }

}
