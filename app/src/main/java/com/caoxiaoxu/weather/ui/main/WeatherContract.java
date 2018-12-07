package com.caoxiaoxu.weather.ui.main;

import com.caoxiaoxu.weather.base.contract.BaseContract;
import com.caoxiaoxu.weather.data.bean.AppInfo;
import com.caoxiaoxu.weather.data.bean.PageBean;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Callback;

/**
 * Created by T560 on 2018/11/29.
 */

public class WeatherContract {

    public interface Model extends BaseContract.BaseModel {
        Observable<PageBean<AppInfo>> setWeather();
    }

    public interface WeatherView extends BaseContract.BaseView {
        void setWeather();
    }

//    public interface Presenter extends BaseContract.BasePresenter {
//        void getWeather();
//    }
}
