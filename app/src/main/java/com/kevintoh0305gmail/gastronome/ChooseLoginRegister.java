package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseLoginRegister extends AppCompatActivity {
    Button btnSignUp, btnLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_login_register);
        btnSignUp = findViewById(R.id.btnChooseSignUp);
        btnLogIn = findViewById(R.id.btnChooseLogin);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseLoginRegister.this, HelloPage.class));
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseLoginRegister.this, Login.class));
            }
        });
    }
}
