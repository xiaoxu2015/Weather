package com.caoxiaoxu.weather.di.module;

import com.caoxiaoxu.weather.WeatherApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：caoxu
 * 时间：2018/11/30.
 */
@Module
public class AppModule {
    private WeatherApplication mApplication;

    public AppModule(WeatherApplication mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    public WeatherApplication provideApplication() {
        return mApplication;
    }
}
