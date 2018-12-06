package com.caoxiaoxu.weather;

import android.app.Application;
import android.content.Context;

import com.caoxiaoxu.weather.di.component.AppComponent;
import com.caoxiaoxu.weather.di.component.DaggerAppComponent;
import com.caoxiaoxu.weather.di.module.AppModule;
import com.caoxiaoxu.weather.di.module.HttpModule;

/**
 * 作者：caoxu
 * 时间：2018/11/30.
 */

public class WeatherApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();
    }

    private void initApplicationComponent() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).httpModule(new HttpModule()).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static WeatherApplication get(Context context) {
        return (WeatherApplication) context.getApplicationContext();
    }

    ;
}
