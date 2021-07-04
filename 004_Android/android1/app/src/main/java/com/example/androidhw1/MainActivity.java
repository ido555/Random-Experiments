package com.example.androidhw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnGreeting).setOnClickListener(this);
        findViewById(R.id.btnCalc).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGreeting:
                EditText enteredName = findViewById(R.id.nameBox);
                TextView greetingBox = findViewById(R.id.greetingBox);
                greetingBox.setText("Hello " + enteredName.getText() + ", nice to meet you");
                break;
            case R.id.btnCalc:
                Intent intent = new Intent(this, Calculator.class);
                startActivity(intent);
                break;
        }
    }
}