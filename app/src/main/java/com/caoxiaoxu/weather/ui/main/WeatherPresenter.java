package com.caoxiaoxu.weather.ui.main;

import android.util.Log;

import com.caoxiaoxu.weather.base.presenter.BasePresenter;
import com.caoxiaoxu.weather.common.rx.RxErrorHandler;
import com.caoxiaoxu.weather.common.rx.RxHttpReponseCompat;
import com.caoxiaoxu.weather.common.subscriber.ProgressDialogSubscriber;
import com.caoxiaoxu.weather.data.bean.Weather;

import javax.inject.Inject;

/**
 * Created by T560 on 2018/11/29.
 */

public class WeatherPresenter extends BasePresenter<WeatherModel, WeatherContract.WeatherView> {
    private RxErrorHandler mRxErrorHandler;

    @Inject
    public WeatherPresenter(WeatherModel weatherModel, WeatherContract.WeatherView weatherView, RxErrorHandler errorHandler) {
        super(weatherModel, weatherView);
        this.mRxErrorHandler = errorHandler;
    }


    public void getWeather() {
        mModel.getWeather()
                .compose(RxHttpReponseCompat.<Weather>compatResult())
                .subscribe(new ProgressDialogSubscriber<Weather>(mView, mRxErrorHandler) {

                    @Override
                    public void onNext(Weather weather) {
                        Log.e("xxxx", weather.toString());
                        mView.setWeather();
                    }
                });

    }
}
