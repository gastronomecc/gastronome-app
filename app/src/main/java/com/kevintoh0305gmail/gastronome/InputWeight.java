package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InputWeight extends AppCompatActivity {
    EditText txtWeight;
    FloatingActionButton fab;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_weight);
        txtWeight = findViewById(R.id.etWeight);
        fab = findViewById(R.id.fabnextpage5);
        login = findViewById(R.id.tvWeightText2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtWeight.getText().toString().isEmpty()){
                    txtWeight.setError("Weight is empty");
                    txtWeight.requestFocus();
                }
                else{
                    double weight = Double.parseDouble(txtWeight.getText().toString().trim());
                    if (weight>0) {
                        HelloPage.profile.setWeight(weight);
                        startActivity(new Intent(InputWeight.this, ChooseGoal.class));
                    }
                    else{
                        txtWeight.setError("Invalid weight entered");
                        txtWeight.requestFocus();
                    }
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InputWeight.this, Login.class));
            }
        });
    }
}
