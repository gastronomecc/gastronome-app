package com.kevintoh0305gmail.gastronome.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kevintoh0305gmail.gastronome.R;

public class GenderSelection extends AppCompatActivity {
    Button female, male, btnback;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_selection);
        female = findViewById(R.id.btnGenderFemale);
        male = findViewById(R.id.btnGenderMale);
        btnback = findViewById(R.id.btnGenderBack);
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelloPage.profile.setGender("F");
                startActivity(new Intent(GenderSelection.this, InputAge.class));
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelloPage.profile.setGender("M");
                startActivity(new Intent(GenderSelection.this, InputAge.class));
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GenderSelection.this, ChooseGoal.class));
            }
        });
    }
}
