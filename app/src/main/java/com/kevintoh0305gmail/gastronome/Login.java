package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = findViewById(R.id.btnLogin);

    }

    public void onClick(View v) {
        startActivity(new Intent(this, HelloPage.class));
    }

    public void onRegistrationClick(View v) {
        startActivity(new Intent(this, Registration.class));
    }

}
