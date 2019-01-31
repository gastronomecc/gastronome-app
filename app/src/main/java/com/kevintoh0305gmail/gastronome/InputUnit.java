package com.kevintoh0305gmail.gastronome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class InputUnit extends AppCompatActivity {
    
    Button btnNext, btnBack;
    RadioGroup unitRadioGroup;
    RadioButton imperial, metric;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_unit);
        btnBack = findViewById(R.id.btnUnitBack);
        unitRadioGroup = (RadioGroup) findViewById(R.id.unitGroup);
        imperial = (RadioButton) findViewById(R.id.radioImperial);
        metric = (RadioButton) findViewById(R.id.radioMetric);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InputUnit.this, InputHeight.class));
            }
        });
        btnNext = findViewById(R.id.btnUnitNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = unitRadioGroup.getCheckedRadioButtonId();
                if (radioId == imperial.getId())
                {
                    HelloPage.profile.setUnit("imperial");
                }
                else if (radioId == metric.getId())
                {
                    HelloPage.profile.setUnit("metric");
                }
                else
                    Log.i("ImportUnit", "error");
                startActivity(new Intent(InputUnit.this, InputHeight.class));
            }
        });
    }
}

