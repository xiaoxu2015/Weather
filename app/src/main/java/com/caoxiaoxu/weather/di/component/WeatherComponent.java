package com.caoxiaoxu.weather.di.component;

import com.caoxiaoxu.weather.di.ActivityScope;
import com.caoxiaoxu.weather.di.module.WeatherModule;
import com.caoxiaoxu.weather.ui.main.MainActivity;

import dagger.Component;

/**
 * 作者：caoxu
 * 时间：2018/12/3.
 */
@ActivityScope
@Component(modules = WeatherModule.class, dependencies = AppComponent.class)
public interface WeatherComponent {
    void inject(MainActivity activity);
}
