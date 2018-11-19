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

public class InputHeight extends AppCompatActivity {
    EditText txtHeight;
    Button btnNext, btnBack;
    TextView tvError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_height);
        txtHeight = findViewById(R.id.etHeight);
        tvError = findViewById(R.id.tvHeightError);
        btnBack = findViewById(R.id.btnHeightBack);
        btnNext = findViewById(R.id.btnHeightNext);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InputHeight.this, InputAge.class));
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isHeightValid()) {
                    HelloPage.profile.setHeight(Double.parseDouble(txtHeight.getText().toString()));
                    startActivity(new Intent(InputHeight.this, InputWeight.class));
                }
            }
        });
        txtHeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(isHeightValid()) {
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

    public boolean isHeightValid(){
        if (txtHeight.getText().toString().isEmpty()){
            tvError.setText("Please enter your height.");
            return false;
        }
        else
        {
            double height = Double.parseDouble(txtHeight.getText().toString().trim());
            if (height > 0 && height < 300){
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
