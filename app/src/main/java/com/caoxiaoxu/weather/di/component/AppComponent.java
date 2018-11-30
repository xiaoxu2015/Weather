package com.caoxiaoxu.weather.di.component;

import com.caoxiaoxu.weather.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：caoxu
 * 时间：2018/11/30.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
}
