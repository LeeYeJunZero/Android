package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemperatureConverterActivity extends AppCompatActivity {

    private EditText temperatureEditText;
    private RadioGroup radioGroup;
    private RadioButton celsiusRadioButton;
    private RadioButton fahrenheitRadioButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        temperatureEditText = findViewById(R.id.temperatureEditText);
        radioGroup = findViewById(R.id.radioGroup);
        celsiusRadioButton = findViewById(R.id.celsiusRadioButton);
        fahrenheitRadioButton = findViewById(R.id.fahrenheitRadioButton);
        resultTextView = findViewById(R.id.resultTextView);

        Button convertButton = findViewById(R.id.convertButton);
        Button resetButton = findViewById(R.id.resetButton);
        Button backButton = findViewById(R.id.backButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
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

    private void convertTemperature() {
        String temperatureStr = temperatureEditText.getText().toString();
        if (temperatureStr.isEmpty()) {
            Toast.makeText(this, "온도를 입력해주세요.", Toast.LENGTH_SHORT).show();
        } else {
            try {
                double temperature = Double.parseDouble(temperatureStr);
                if (celsiusRadioButton.isChecked()) {
                    // 섭씨를 화씨로 변환
                    double fahrenheit = (temperature * 9 / 5) + 32;
                    resultTextView.setText(String.format("변환 결과: %.2f °F", fahrenheit));
                } else if (fahrenheitRadioButton.isChecked()) {
                    // 화씨를 섭씨로 변환
                    double celsius = (temperature - 32) * 5 / 9;
                    resultTextView.setText(String.format("변환 결과: %.2f °C", celsius));
                } else {
                    Toast.makeText(this, "변환 유형을 선택해주세요.", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "유효한 숫자를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void resetFields() {
        temperatureEditText.setText("");
        radioGroup.clearCheck();
        resultTextView.setText("변환 결과:");
    }
}
