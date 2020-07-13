package com.example.androidhw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        findViewById(R.id.btnPlus).setOnClickListener(this);
        findViewById(R.id.btnMinus).setOnClickListener(this);
        findViewById(R.id.btnMult).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView result = findViewById(R.id.textResult);
        Double num1 = Double.parseDouble(String.valueOf(((EditText) (findViewById(R.id.numBox1))).getText()));
        Double num2 = Double.parseDouble(String.valueOf(((EditText) (findViewById(R.id.numBox2))).getText()));
        switch (view.getId()) {
            case R.id.btnPlus:
                result.setText(String.valueOf(num1 + num2));
                break;
            case R.id.btnMinus:
                result.setText(String.valueOf(num1 - num2));
                break;
            case R.id.btnMult:
                result.setText(String.valueOf(num1 * num2));
                break;
            case R.id.btnDiv:
                if (num1 == 0 || num2 == 0)
                    result.setText("cannot divide by zero");
                result.setText(String.valueOf(num1 / num2));
                break;
        }
    }
}