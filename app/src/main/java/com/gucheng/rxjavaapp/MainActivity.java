package com.gucheng.rxjavaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.gucheng.dependenceinject.RequestType;
import com.gucheng.dependenceinject.RequestTypeInject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Map<String,String> mapMethod = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestTypeInject.injectView(this, mapMethod);
        CreateOperatorDemo.test1();
    }

    @RequestType(type = 1)
    public void goToNextPage() {
        Log.d("donald", "call goToNextPage");
    }
}