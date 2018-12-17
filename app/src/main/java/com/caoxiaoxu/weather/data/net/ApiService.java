package com.caoxiaoxu.weather.data.net;

import com.caoxiaoxu.weather.base.bean.BaseBean;
import com.caoxiaoxu.weather.data.bean.Weather;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者：caoxu
 * 时间：2018/11/30.
 */

public interface ApiService {
    //    public static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";
    public static final String BASE_URL = "https://free-api.heweather.com/s6/";
    public static final String APP_KEY = "7754e4085d884c109abdeabda46b060a";


    //    @GET("featured")
//    public Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);
    @GET("featured")
    public Observable<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);

    @GET("weather/forecast")
    public Observable<BaseBean<Weather>>  getWeather(@Query("location") String location, @Query("key") String key);
}
