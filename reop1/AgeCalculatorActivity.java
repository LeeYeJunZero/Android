package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AgeCalculatorActivity extends AppCompatActivity {

    private EditText yearEditText;
    private EditText ageEditText;
    private static final int CURRENT_YEAR = 2024;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        yearEditText = findViewById(R.id.yearEditText);
        ageEditText = findViewById(R.id.ageEditText);

        Button calculateAgeButton = findViewById(R.id.calculateAgeButton);
        Button calculateBirthYearButton = findViewById(R.id.calculateBirthYearButton);
        Button resetButton = findViewById(R.id.resetButton);
        Button backButton = findViewById(R.id.backButton);

        calculateAgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAge();
            }
        });

        calculateBirthYearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBirthYear();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calculateAge() {
        String yearStr = yearEditText.getText().toString();
        if (yearStr.isEmpty()) {
            Toast.makeText(this, "년도를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show();
        } else {
            try {
                int birthYear = Integer.parseInt(yearStr);
                int age = CURRENT_YEAR - birthYear + 1;
                Toast.makeText(this, "나이: " + age + "세", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "유효한 숫자를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void calculateBirthYear() {
        String ageStr = ageEditText.getText().toString();
        if (ageStr.isEmpty()) {
            Toast.makeText(this, "나이를 정확히 입력해주세요.", Toast.LENGTH_SHORT).show();
        } else {
            try {
                int age = Integer.parseInt(ageStr);
                int birthYear = CURRENT_YEAR - age + 1;
                Toast.makeText(this, "태어난 해: " + birthYear + "년", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "유효한 숫자를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void resetFields() {
        yearEditText.setText("");
        ageEditText.setText("");
    }
}
