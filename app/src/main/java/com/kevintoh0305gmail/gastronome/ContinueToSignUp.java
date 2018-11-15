package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContinueToSignUp extends AppCompatActivity {
    Button btnEmailSignUp, btnBack;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_to_sign_up);
        btnEmailSignUp = findViewById(R.id.btnContinueEmail);
        btnBack = findViewById(R.id.btnContinueSignUpBack);
        login = findViewById(R.id.tvContinueText2);
        btnEmailSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContinueToSignUp.this, Registration.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContinueToSignUp.this, InputWeight.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ContinueToSignUp.this, Login.class));
            }
        });
    }
}
