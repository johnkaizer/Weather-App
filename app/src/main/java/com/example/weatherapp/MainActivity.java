package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    final String APP_ID="";
    final  String Weather_URL="https://home.openweathermap.org/data/2.5/weather";
    final long MIN_TIME= 5000;
    final float Min_Distance= 1000;
    final int REQUEST_CODE=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}