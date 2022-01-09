package com.gucheng.rxjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.test_just).setOnClickListener(
                v -> CreateOperatorDemo.testJust()
        );
        findViewById(R.id.subcribe_next_and_error).setOnClickListener(
                v -> CreateOperatorDemo.subcribeNextAndError()
        );
        findViewById(R.id.create_and_map).setOnClickListener(
                v->CreateOperatorDemo.testCreateAndMap()
        );
    }
}