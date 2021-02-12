package com.example.moreintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        TextView injectedText = findViewById(R.id.dogView);
        Dog dog = getIntent().getParcelableExtra("myDog");
        injectedText.setText("dog name: " + dog.getName() + "\ndog age: " + dog.getAge());
    }
}