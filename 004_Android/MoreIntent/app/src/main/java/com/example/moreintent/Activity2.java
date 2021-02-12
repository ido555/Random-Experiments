package com.example.moreintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        TextView injectedText = findViewById(R.id.injectedText);
        String text = getIntent().getStringExtra("key");
        injectedText.setText(text);
    }
}