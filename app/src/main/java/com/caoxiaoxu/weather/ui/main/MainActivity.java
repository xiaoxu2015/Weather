package com.caoxiaoxu.weather.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.caoxiaoxu.weather.R;
import com.caoxiaoxu.weather.WeatherApplication;
import com.caoxiaoxu.weather.di.component.DaggerWeatherComponent;
import com.caoxiaoxu.weather.di.module.WeatherModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements WeatherContract.View {
    @Inject
    WeatherContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerWeatherComponent.builder().appComponent(((WeatherApplication) getApplication()).getAppComponent()).weatherModule(new WeatherModule(this)).build().inject(this);
        findViewById(R.id.tv_hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getWeather();
            }
        });

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void dismissLoadingDialog() {

    }


    @Override
    public void setWeather() {
        Toast.makeText(MainActivity.this, "哈哈", Toast.LENGTH_LONG).show();
    }
}
