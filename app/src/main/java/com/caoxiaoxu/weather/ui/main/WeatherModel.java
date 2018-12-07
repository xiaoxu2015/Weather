package com.caoxiaoxu.weather.ui.main;

import android.util.Log;

import com.caoxiaoxu.weather.data.bean.AppInfo;
import com.caoxiaoxu.weather.data.bean.PageBean;
import com.caoxiaoxu.weather.data.net.ApiService;

import io.reactivex.Observable;
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
    public Observable<PageBean<AppInfo>> setWeather() {
        Log.e("xxxx", "page");
        return mApiService.getApps("{'page':0}");

    }
}
