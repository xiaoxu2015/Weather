package com.caoxiaoxu.weather.ui.main;

import com.caoxiaoxu.weather.base.contract.BaseContract;

import okhttp3.OkHttpClient;

/**
 * Created by T560 on 2018/11/29.
 */

public class WeatherContract {

    public interface Model extends BaseContract.BaseModel {
        void setWeather(String str);
    }

    public interface View extends BaseContract.BaseView {
        void getWeather();
    }

    public interface Presenter extends BaseContract.BasePresenter {
        void getWeather();
    }
}
