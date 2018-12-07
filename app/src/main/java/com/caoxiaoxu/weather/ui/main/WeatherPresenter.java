package com.caoxiaoxu.weather.ui.main;

import com.caoxiaoxu.weather.base.presenter.BasePresenter;
import com.caoxiaoxu.weather.data.bean.AppInfo;
import com.caoxiaoxu.weather.data.bean.PageBean;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by T560 on 2018/11/29.
 */

public class WeatherPresenter extends BasePresenter<WeatherModel, WeatherContract.WeatherView> {

    @Inject
    public WeatherPresenter(WeatherModel weatherModel, WeatherContract.WeatherView weatherView) {
        super(weatherModel, weatherView);
    }


    public void getWeather() {
        mView.showLoadingDialog();
        mModel.setWeather(new Callback<PageBean<AppInfo>>() {
            @Override
            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
                mView.dismissLoadingDialog();
                mView.setWeather();

            }

            @Override
            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
                mView.dismissLoadingDialog();
            }
        });


    }
}
