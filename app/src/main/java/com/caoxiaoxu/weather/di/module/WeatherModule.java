package com.caoxiaoxu.weather.di.module;

import com.caoxiaoxu.weather.data.net.ApiService;
import com.caoxiaoxu.weather.ui.main.WeatherContract;
import com.caoxiaoxu.weather.ui.main.WeatherModel;
import com.caoxiaoxu.weather.ui.main.WeatherPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：caoxu
 * 时间：2018/12/3.
 */
@Module
public class WeatherModule {
    private WeatherContract.View mView;

    public WeatherModule(WeatherContract.View mView) {
        this.mView = mView;
    }

    @Provides
    public WeatherContract.Presenter providePresenter(WeatherContract.View view) {
        return new WeatherPresenter(view);
    }

    @Provides
    public WeatherContract.View provideView() {
        return mView;
    }

    @Provides
    public WeatherModel provideModel(ApiService apiService) {
        return new WeatherModel(apiService);
    }
}
