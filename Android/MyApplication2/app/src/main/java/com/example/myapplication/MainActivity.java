package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // implicit automatic Casting from View to Button
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        btn1.setText("Changed from java!");
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // not safe to cast here but just for the example

        switch (view.getId()) {
            case R.id.btn1:
                ((Button) view).setText("Clicked on button 1");
                break;
            case R.id.btn2:
                ((Button) view).setText("Clicked on button 2");
                break;
        }

    }
}