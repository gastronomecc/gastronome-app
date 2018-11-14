package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InputAge extends AppCompatActivity {
    EditText txtAge;
    FloatingActionButton fab;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_age);
        txtAge = findViewById(R.id.etAge);
        fab = findViewById(R.id.fabnextpage3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String age = txtAge.getText().toString().trim();
                if (age.isEmpty()) { //Check whether the email textbox is empty
                    txtAge.setError("Age is required");
                    txtAge.requestFocus();
                }
                else{
                    if (Integer.parseInt(age) < 13)
                    {
                        txtAge.setError("You must be 13 and above.");
                        txtAge.requestFocus();
                    }
                    else {
                        HelloPage.profile.setAge(Integer.parseInt(txtAge.getText().toString()));
                        startActivity(new Intent(InputAge.this, InputHeight.class));
                    }
                }
            }
        });
    }
}
