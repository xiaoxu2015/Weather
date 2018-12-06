package com.caoxiaoxu.weather.di.component;

import com.caoxiaoxu.weather.data.net.ApiService;
import com.caoxiaoxu.weather.di.module.AppModule;
import com.caoxiaoxu.weather.di.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：caoxu
 * 时间：2018/12/6.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    public ApiService getApiService();
}
