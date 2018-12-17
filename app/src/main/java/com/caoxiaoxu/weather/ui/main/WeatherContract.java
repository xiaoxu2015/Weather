package com.caoxiaoxu.weather.ui.main;

import com.caoxiaoxu.weather.base.bean.BaseBean;
import com.caoxiaoxu.weather.base.contract.BaseContract;
import com.caoxiaoxu.weather.data.bean.Weather;

import rx.Observable;

/**
 * Created by T560 on 2018/11/29.
 */

public class WeatherContract {

    public interface Model extends BaseContract.BaseModel {
        Observable<BaseBean<Weather>> getWeather();
    }

    public interface WeatherView extends BaseContract.BaseView {
        void setWeather();
    }

//    public interface Presenter extends BaseContract.BasePresenter {
//        void getWeather();
//    }
}
