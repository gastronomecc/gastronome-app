package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    Button btnLogin, btnBack;
    EditText txtEmail, txtPassword;
    TextView tvError;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    static SharedGlobals globals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        btnBack = findViewById(R.id.btnLoginBack);
        txtEmail = findViewById(R.id.etUserEmail);
        txtPassword = findViewById(R.id.etUserPassword);
        tvError = findViewById(R.id.tvError);
        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        //mAuth.signInWithEmailAndPassword("dom@gmail.com", "password123");
        //Log.d("TEST", mAuth.getCurrentUser().getEmail());

        mAuth.signInWithEmailAndPassword("dom2@gmail.com", "password1").addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent in = new Intent(Login.this, Home.class);
                            in.setFlags(in.FLAG_ACTIVITY_NEW_TASK | in.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(in);
                        }
                    }
                });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //database.setPersistenceEnabled(true);
                //Intent in = new Intent(Login.this, Home.class);
                //startActivity(in);
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
                            Intent in = new Intent(Login.this, Home.class);
                            in.setFlags(in.FLAG_ACTIVITY_NEW_TASK | in.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(in);
                        }
                        else
                        {
                            Toast.makeText(Login.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                            txtPassword.setText("");
                            tvError.setText("Invalid email or password :-(");
                        }
                    }
                });
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Login.this, ChooseLoginRegister.class);
                //Clear activity stack
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(in);
            }
        });
    }
}