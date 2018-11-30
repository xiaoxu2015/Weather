package com.caoxiaoxu.weather.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.caoxiaoxu.weather.R;

public class MainActivity extends AppCompatActivity implements WeatherContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void dismissLoadingDialog() {

    }

    @Override
    public void getWeather() {

    }
}
