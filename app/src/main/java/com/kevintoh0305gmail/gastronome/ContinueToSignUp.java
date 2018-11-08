package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContinueToSignUp extends AppCompatActivity {
    Button btnEmailSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_to_sign_up);
        btnEmailSignUp = findViewById(R.id.btnContinueEmail);
        btnEmailSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContinueToSignUp.this, Registration.class));
            }
        });
    }
}
