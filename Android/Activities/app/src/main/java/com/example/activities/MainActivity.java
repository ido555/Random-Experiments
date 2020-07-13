package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnShowText).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText editableText = findViewById(R.id.editableText);
        TextView textDisplayer = findViewById(R.id.textDisplayer);

        textDisplayer.setText(editableText.getText());
    }
}