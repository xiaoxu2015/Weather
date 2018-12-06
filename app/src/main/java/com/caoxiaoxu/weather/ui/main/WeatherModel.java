package com.caoxiaoxu.weather.ui.main;

import com.caoxiaoxu.weather.data.bean.AppInfo;
import com.caoxiaoxu.weather.data.bean.PageBean;
import com.caoxiaoxu.weather.data.net.ApiService;

import retrofit2.Callback;

/**
 * Created by T560 on 2018/11/29.
 */

public class WeatherModel implements WeatherContract.Model {
    private ApiService mApiService;

    public WeatherModel(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public void setWeather(Callback<PageBean<AppInfo>> callback) {
        mApiService.getApps("{'page':0}").enqueue(callback);

    }
}
