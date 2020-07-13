package com.example.appwithactivites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAct2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity", "MainActivity Destroyed!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity", "MainActivity Started!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity", "MainActivity Stopped!");
    }
}