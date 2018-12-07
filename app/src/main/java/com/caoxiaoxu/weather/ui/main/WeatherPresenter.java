package com.caoxiaoxu.weather.ui.main;

import android.util.Log;

import com.caoxiaoxu.weather.base.presenter.BasePresenter;
import com.caoxiaoxu.weather.data.bean.AppInfo;
import com.caoxiaoxu.weather.data.bean.PageBean;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
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
//        mModel.setWeather(new Callback<PageBean<AppInfo>>() {
//            @Override
//            public void onResponse(Call<PageBean<AppInfo>> call, Response<PageBean<AppInfo>> response) {
//                mView.dismissLoadingDialog();
//                Log.e("xxxx",response.toString());
//                mView.setWeather();
//
//            }
//
//            @Override
//            public void onFailure(Call<PageBean<AppInfo>> call, Throwable t) {
//                mView.dismissLoadingDialog();
//                Log.e("xxxx","xxxx失败");
//            }
//        })


        Subscriber<PageBean<AppInfo>> subscriber = new Subscriber<PageBean<AppInfo>>() {


            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(PageBean<AppInfo> appInfoPageBean) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
        mModel.setWeather().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }
}
