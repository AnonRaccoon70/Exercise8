package com.example.exercise8;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText inputOne;
    private EditText inputTwo;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        output = findViewById(R.id.output);
        inputOne = findViewById(R.id.inputOne);
        inputTwo = findViewById(R.id.inputTwo);
    }
    public void calculate(View view, String operation) {
        try {
            int num1 = Integer.parseInt(inputOne.getText().toString());
            int num2 = Integer.parseInt(inputTwo.getText().toString());
            int result;
            switch (operation) {
                case "add":
                    result = num1 + num2;
                    break;
                case "subtract":
                    result = num1 - num2;
                    break;
                case "multiply":
                    result = num1 * num2;
                    break;
                case "divide":
                    result = num1 / num2;
                    break;
                default:
                    return;
            }
            output.setText(String.valueOf(result));
        } catch (Exception e) {
            output.setText("Invalid input.");
        }
    }

    public void addition(View view) {
        calculate(view, "add");
    }

    public void subtraction(View view) {
        calculate(view, "subtract");
    }

    public void multiplication(View view) {
        calculate(view, "multiply");
    }

    public void division(View view) {
        calculate(view, "divide");
    }

}