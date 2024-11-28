package com.example.calculator2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText lengthInput, widthInput;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lengthInput = findViewById(R.id.lengthInput);
        widthInput = findViewById(R.id.widthInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(v -> {
            String lengthStr = lengthInput.getText().toString();
            String widthStr = widthInput.getText().toString();

            if (!lengthStr.isEmpty() && !widthStr.isEmpty()) {
                double length = Double.parseDouble(lengthStr);
                double width = Double.parseDouble(widthStr);
                double area = length * width;
                resultTextView.setText("Площадь: " + area);
            } else {
                resultTextView.setText("Введите корректные значения");
            }
        });
    }

    public void Click1(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}