package com.xiasuhuei321.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Weather_Main", "我启动了");
    }
}
