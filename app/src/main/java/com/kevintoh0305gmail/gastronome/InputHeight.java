package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InputHeight extends AppCompatActivity {
    EditText txtHeight;
    FloatingActionButton fab;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_height);
        txtHeight = findViewById(R.id.etHeight);
        fab = findViewById(R.id.fabnextpage4);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtHeight.getText().toString().isEmpty()){
                    txtHeight.setError("Height is empty");
                    txtHeight.requestFocus();
                }
                else
                {
                    double height = Double.parseDouble(txtHeight.getText().toString().trim());
                    if (height > 0 && height < 300){
                        HelloPage.profile.setHeight(height);
                        startActivity(new Intent(InputHeight.this, InputWeight.class));
                    }
                    else{
                        txtHeight.setError("Invalid height");
                        txtHeight.requestFocus();
                    }
                }
            }
        });
    }
}
