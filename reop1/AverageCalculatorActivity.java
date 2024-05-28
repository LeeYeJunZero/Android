
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AverageCalculatorActivity extends AppCompatActivity {

    private EditText koreanScoreEditText;
    private EditText englishScoreEditText;
    private EditText mathScoreEditText;
    private TextView totalTextView;
    private TextView averageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_calculator);

        koreanScoreEditText = findViewById(R.id.koreanScoreEditText);
        englishScoreEditText = findViewById(R.id.englishScoreEditText);
        mathScoreEditText = findViewById(R.id.mathScoreEditText);
        totalTextView = findViewById(R.id.totalTextView);
        averageTextView = findViewById(R.id.averageTextView);

        Button calculateButton = findViewById(R.id.calculateButton);
        Button resetButton = findViewById(R.id.resetButton);
        Button backButton = findViewById(R.id.backButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAverage();
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

    private void calculateAverage() {
        String koreanScoreStr = koreanScoreEditText.getText().toString();
        String englishScoreStr = englishScoreEditText.getText().toString();
        String mathScoreStr = mathScoreEditText.getText().toString();

        if (koreanScoreStr.isEmpty() || englishScoreStr.isEmpty() || mathScoreStr.isEmpty()) {
            Toast.makeText(this, "모든 과목의 점수를 입력해주세요.", Toast.LENGTH_SHORT).show();
        } else {
            try {
                int koreanScore = Integer.parseInt(koreanScoreStr);
                int englishScore = Integer.parseInt(englishScoreStr);
                int mathScore = Integer.parseInt(mathScoreStr);

                int total = koreanScore + englishScore + mathScore;
                double average = total / 3.0;

                totalTextView.setText(String.format("총점: %d점", total));
                averageTextView.setText(String.format("평균: %.2f점", average));
            } catch (NumberFormatException e) {
                Toast.makeText(this, "유효한 숫자를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void resetFields() {
        koreanScoreEditText.setText("");
        englishScoreEditText.setText("");
        mathScoreEditText.setText("");
        totalTextView.setText("총점:");
        averageTextView.setText("평균:");
    }
}
