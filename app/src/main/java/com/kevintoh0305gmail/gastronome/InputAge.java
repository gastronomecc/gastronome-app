package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputAge extends AppCompatActivity {
    EditText txtAge;
    Button btnNext, btnBack;
    TextView tvError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_age);
        txtAge = findViewById(R.id.etAge);
        tvError = findViewById(R.id.tvAgeError);
        btnBack = findViewById(R.id.btnAgeBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InputAge.this, GenderSelection.class));
            }
        });
        btnNext = findViewById(R.id.btnAgeNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAgeValid()) {
                    HelloPage.profile.setAge(Integer.parseInt(txtAge.getText().toString()));
                    startActivity(new Intent(InputAge.this, InputHeight.class));
                }
            }
        });
        txtAge.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(isAgeValid()) {
                    btnNext.setBackground(btnNext.getContext().getResources().getDrawable(R.drawable.next_button_active));
                }
                else {
                    btnNext.setBackground(btnNext.getContext().getResources().getDrawable(R.drawable.next_button_inactive));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public boolean isAgeValid()
    {
        String age = txtAge.getText().toString().trim();
        if (age.isEmpty()) {
            tvError.setText("Please enter your age.");
            return false;
        }
        else{
            if (Integer.parseInt(age) < 13)
            {
                tvError.setText("You must be 13 and above to continue.");
                return false;
            }
            else {
                tvError.setText("");
                return true;
            }
        }
    }

}
