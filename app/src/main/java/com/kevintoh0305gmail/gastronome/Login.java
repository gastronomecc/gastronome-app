package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    Button btnLogin;
    EditText txtEmail, txtPassword;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        txtEmail = findViewById(R.id.etUserEmail);
        txtPassword = findViewById(R.id.etUserPassword);
        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                if (email.isEmpty()) { //Check whether the email textbox is empty
                    txtEmail.setError("Username is required");
                    txtEmail.requestFocus();
                    return; //Do not allow user to authenticate
                }

                if (password.isEmpty()) { //Check whether the password text is empty
                    txtPassword.setError("Password is required");
                    txtPassword.requestFocus();
                    return; //Do not allow user to authenticate
                }

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent in = new Intent(Login.this, HelloPage.class);
                            in.setFlags(in.FLAG_ACTIVITY_NEW_TASK | in.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(in);
                        }
                        else
                        {
                            Toast.makeText(Login.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                            txtPassword.setText("");
                        }
                    }
                });
            }
        });

    }


    public void onRegistrationClick(View v) {
        startActivity(new Intent(this, Registration.class));
    }

}
