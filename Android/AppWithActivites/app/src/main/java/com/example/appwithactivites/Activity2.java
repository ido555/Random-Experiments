package com.example.appwithactivites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        findViewById(R.id.btnWeb).setOnClickListener(this);
        findViewById(R.id.btnDial).setOnClickListener(this);
        findViewById(R.id.btnMap).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnWeb:
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
                startActivity(intentWeb);
                break;
            case R.id.btnDial:
                Intent dial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:911"));
                startActivity(dial);
                break;
            case R.id.btnMap:
                Intent map = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:34.45,32.78"));
                startActivity(map);
                break;
        }
    }
}