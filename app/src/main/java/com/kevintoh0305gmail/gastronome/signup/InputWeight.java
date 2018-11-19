package com.kevintoh0305gmail.gastronome.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kevintoh0305gmail.gastronome.R;

public class InputWeight extends AppCompatActivity {
    EditText txtWeight;
    Button btnBack, btnNext;
    TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_weight);
        txtWeight = findViewById(R.id.etWeight);
        tvError = findViewById(R.id.tvWeightError);
        btnBack = findViewById(R.id.btnWeightBack);
        btnNext = findViewById(R.id.btnWeightNext);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InputWeight.this, InputHeight.class));
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isWeightValid())
                {
                    HelloPage.profile.setWeight(Double.parseDouble(txtWeight.getText().toString()));
                    startActivity(new Intent(InputWeight.this, ContinueToSignUp.class));
                }
            }
        });
        txtWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(isWeightValid()) {
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

    public boolean isWeightValid() {
        if(txtWeight.getText().toString().isEmpty()){
            tvError.setText("Please enter your weight.");
            return false;
        }
        else{
            double weight = Double.parseDouble(txtWeight.getText().toString().trim());
            if (weight>0 && weight< 500) {
                tvError.setText("");
                return true;
            }
            else{
                tvError.setText("Please enter a valid height.");
                return false;
            }
        }
    }
}
