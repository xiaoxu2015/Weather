package com.caoxiaoxu.weather.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.caoxiaoxu.weather.R;
import com.caoxiaoxu.weather.base.activity.BaseActivity;
import com.caoxiaoxu.weather.di.component.AppComponent;
import com.caoxiaoxu.weather.di.component.DaggerWeatherComponent;
import com.caoxiaoxu.weather.di.module.WeatherModule;

import butterknife.BindView;

public class MainActivity extends BaseActivity<WeatherPresenter> implements WeatherContract.WeatherView {

    @BindView(R.id.tv_hello)
    Button mTvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mTvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getWeather();

            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerWeatherComponent.builder().appComponent(appComponent).weatherModule(new WeatherModule(this)).build().inject(this);
    }



    @Override
    public void setWeather() {
        Toast.makeText(MainActivity.this, "哈哈", Toast.LENGTH_LONG).show();
    }
}
