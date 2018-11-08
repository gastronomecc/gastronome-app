package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChooseGoal extends AppCompatActivity {
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_goal);
        login = findViewById(R.id.tvGoalText3);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseGoal.this, Login.class));
            }
        });
    }
    public void onLoseWeightClick(View view){
        HelloPage.profile.setGoal("Lose weight");
        startActivity(new Intent(ChooseGoal.this, ContinueToSignUp.class));
    }
    public void onGetFitterClick(View view){
        HelloPage.profile.setGoal("Get fitter");
        startActivity(new Intent(ChooseGoal.this, ContinueToSignUp.class));
    }
    public void onGainMuscle(View view){
        HelloPage.profile.setGoal("Gain muscle");
        startActivity(new Intent(ChooseGoal.this, ContinueToSignUp.class));
    }

}
