package com.example.moreintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAct2).setOnClickListener(this);
        findViewById(R.id.btnAct3).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAct2:
                Intent intent2 = new Intent(this, Activity2.class);
                intent2.putExtra("key", "hello 123");
                intent2.putExtra("otherKey", "hello again");
                startActivity(intent2);
                break;

            case R.id.btnAct3:
                Intent intent3 = new Intent(this, Activity3.class);
                Dog doggo = new Dog("Max", 6);
                intent3.putExtra("myDog", doggo);
                startActivity(intent3);
                break;
        }
    }
}