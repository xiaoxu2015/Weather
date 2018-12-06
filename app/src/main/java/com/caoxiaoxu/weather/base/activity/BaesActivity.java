package com.caoxiaoxu.weather.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.caoxiaoxu.weather.WeatherApplication;
import com.caoxiaoxu.weather.di.component.AppComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：caoxu
 * 时间：2018/12/6.
 */

public abstract class BaesActivity extends AppCompatActivity {
    private Unbinder mUnbinder;
    private WeatherApplication mWeatherApplication;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        this.mWeatherApplication = (WeatherApplication) getApplication();
        //
        setupActivityComponent(mWeatherApplication.getAppComponent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    public abstract int getLayoutId();

    public abstract void setupActivityComponent(AppComponent appComponent);
}
