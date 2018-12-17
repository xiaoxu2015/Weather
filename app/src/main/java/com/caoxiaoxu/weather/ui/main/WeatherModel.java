package com.caoxiaoxu.weather.ui.main;

import android.util.Log;

import com.caoxiaoxu.weather.base.bean.BaseBean;
import com.caoxiaoxu.weather.data.bean.Weather;
import com.caoxiaoxu.weather.data.net.ApiService;


import retrofit2.Callback;
import rx.Observable;

/**
 * Created by T560 on 2018/11/29.
 */

public class WeatherModel implements WeatherContract.Model {
    private ApiService mApiService;

    public WeatherModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public Observable<BaseBean<Weather>> getWeather() {
        Log.e("xxxx", "page");
        return mApiService.getWeather("北京", ApiService.APP_KEY);

    }
}
