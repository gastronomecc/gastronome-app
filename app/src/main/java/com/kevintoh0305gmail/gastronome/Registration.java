package com.kevintoh0305gmail.gastronome;


import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    EditText txtName, txtEmail, txtPassword, txtCfmPassword;
    TextView tvLogin;
    Button btnRegister, btnBack;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        txtName = findViewById(R.id.etRegistrationName);
        txtEmail = findViewById(R.id.etRegistrationEmail);
        txtPassword = findViewById(R.id.etRegistrationPW);
        txtCfmPassword = findViewById(R.id.etRegistrationCfmPW);
        btnRegister = findViewById(R.id.btnRegisterAccount);
        tvLogin = findViewById(R.id.tvRegisterText2);
        btnBack = findViewById(R.id.btnRegisterBack);
        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Log.d("Check Here", String.valueOf(HelloPage.profile.getWeight()));

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String user_name = txtName.getText().toString().trim();
                final String user_email = txtEmail.getText().toString().trim();
                String user_password = txtPassword.getText().toString().trim();
                String user_cfmPassword = txtCfmPassword.getText().toString().trim();

                if (isValid(user_name, user_email, user_password, user_cfmPassword)) {
                    mAuth.createUserWithEmailAndPassword(user_email, user_password);
                    mAuth.signInWithEmailAndPassword(user_email, user_password).addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            // Unit will be kg for now
                            User newUser = new User(FirebaseAuth.getInstance().getCurrentUser().getUid(), user_name, user_email, HelloPage.profile.getGoal(), HelloPage.profile.getGender(), HelloPage.profile.getUnit(), HelloPage.profile.getAge(), HelloPage.profile.getHeight(), HelloPage.profile.getWeight(), calculateBMI(HelloPage.profile.getHeight(), HelloPage.profile.getWeight()));
                            firebaseDatabase.getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(newUser);
                            mAuth.signOut();
                            Intent in = new Intent(Registration.this, Login.class);
                            //Clear activity stack
                            in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(in);
                        }
                    });
                } else {
                    Toast.makeText(Registration.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, Login.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration.this, ContinueToSignUp.class));
            }
        });
    }

    public boolean isValid(String user_name, String user_email, String user_password, String user_cfmPassword){
        //If Username Field is empty
        if (user_name.isEmpty()) {
            txtName.setError("Your Name is required");
            txtName.requestFocus();
            //Return Error
            return false;
        }
        //If Email Field is empty
        else if (user_email.isEmpty()) {
            txtEmail.setError("Email is required");
            txtEmail.requestFocus();
            //Return Error
            return false;
        }
        //If Email Address is in wrong format
        else if (!Patterns.EMAIL_ADDRESS.matcher(user_email).matches()) {
            txtEmail.setError("Please enter a valid email");
            txtEmail.requestFocus();
            //Return Error
            return false;
        }
        //If Password Field is empty
        else if (user_password.isEmpty()) {
            txtPassword.setError("Password is required");
            txtPassword.requestFocus();
            //Return Error
            return false;
        }
        //If Password is less than 6 characters
        else if (user_password.length()<6) {
            txtPassword.setError("Minimum length of password should be 6");
            txtPassword.requestFocus();
            //Return Error
            return false;
        }
        //If Confirm Password and Password does not match
        else if (!user_cfmPassword.equals(user_password)) {
            txtCfmPassword.setError("The passwords doesn't match");
            txtCfmPassword.requestFocus();
            //Return Error
            return false;
        }
        else {
            return true;
        }
    }

    public double calculateBMI(double height, double weight){
        double bmi = weight / ((height/100) * (height/100));
        return bmi;
    }
}
