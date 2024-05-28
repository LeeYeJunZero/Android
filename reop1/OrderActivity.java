package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    private EditText pizzaQuantityEditText;
    private EditText spaghettiQuantityEditText;
    private EditText saladQuantityEditText;
    private TextView resultTextView;
    private TextView orderCountTextView;

    private static final int PIZZA_PRICE = 15000;
    private static final int SPAGHETTI_PRICE = 13000;
    private static final int SALAD_PRICE = 9000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        pizzaQuantityEditText = findViewById(R.id.pizzaQuantityEditText);
        spaghettiQuantityEditText = findViewById(R.id.spaghettiQuantityEditText);
        saladQuantityEditText = findViewById(R.id.saladQuantityEditText);
        resultTextView = findViewById(R.id.resultTextView);
        orderCountTextView = findViewById(R.id.orderCountTextView);

        Button calculateButton = findViewById(R.id.calculateButton);
        Button resetButton = findViewById(R.id.resetButton);
        Button backButton = findViewById(R.id.backButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateOrder();
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

    private void calculateOrder() {
        String pizzaQuantityStr = pizzaQuantityEditText.getText().toString();
        String spaghettiQuantityStr = spaghettiQuantityEditText.getText().toString();
        String saladQuantityStr = saladQuantityEditText.getText().toString();

        if (pizzaQuantityStr.isEmpty() || spaghettiQuantityStr.isEmpty() || saladQuantityStr.isEmpty()) {
            Toast.makeText(this, "모든 항목의 수량을 입력해주세요.", Toast.LENGTH_SHORT).show();
        } else {
            try {
                int pizzaQuantity = Integer.parseInt(pizzaQuantityStr);
                int spaghettiQuantity = Integer.parseInt(spaghettiQuantityStr);
                int saladQuantity = Integer.parseInt(saladQuantityStr);

                int totalAmount = (pizzaQuantity * PIZZA_PRICE) + (spaghettiQuantity * SPAGHETTI_PRICE) + (saladQuantity * SALAD_PRICE);
                int totalCount = pizzaQuantity + spaghettiQuantity + saladQuantity;

                resultTextView.setText(String.format("총 금액: %,d원", totalAmount));
                orderCountTextView.setText(String.format("주문 개수: %d개", totalCount));
            } catch (NumberFormatException e) {
                Toast.makeText(this, "유효한 숫자를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void resetFields() {
        pizzaQuantityEditText.setText("");
        spaghettiQuantityEditText.setText("");
        saladQuantityEditText.setText("");
        resultTextView.setText("총 금액:");
        orderCountTextView.setText("주문 개수:");
    }
}

