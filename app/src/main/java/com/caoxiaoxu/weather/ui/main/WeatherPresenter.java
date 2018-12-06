package com.caoxiaoxu.weather.ui.main;

/**
 * Created by T560 on 2018/11/29.
 */

public class WeatherPresenter implements WeatherContract.Presenter {
    private WeatherContract.View mView;

    public WeatherPresenter(WeatherContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getWeather() {
        mView.setWeather();

    }
}
