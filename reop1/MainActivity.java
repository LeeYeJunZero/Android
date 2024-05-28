package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);

        Button buttonPriceCalculator = findViewById(R.id.buttonPriceCalculator);
        buttonPriceCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PriceCalculatorActivity.class);
                startActivity(intent);
            }
        });

        Button buttonCalculator = findViewById(R.id.buttonCalculator);
        buttonCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAgeCalculator = findViewById(R.id.buttonAgeCalculator);
        buttonAgeCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AgeCalculatorActivity.class);
                startActivity(intent);
            }
        });

        Button buttonTemperatureConverter = findViewById(R.id.buttonTemperatureConverter);
        buttonTemperatureConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TemperatureConverterActivity.class);
                startActivity(intent);
            }
        });

        Button buttonOrder = findViewById(R.id.buttonOrder);
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAverageCalculator = findViewById(R.id.buttonAverageCalculator);
        buttonAverageCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AverageCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }
}
