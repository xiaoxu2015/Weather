package com.caoxiaoxu.weather.data.net;

import com.caoxiaoxu.weather.data.bean.AppInfo;
import com.caoxiaoxu.weather.data.bean.PageBean;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者：caoxu
 * 时间：2018/11/30.
 */

public interface ApiService {
    public static final String BASE_URL = "http://112.124.22.238:8081/course_api/cniaoplay/";


//    @GET("featured")
//    public Call<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);
    @GET("featured")
    public Observable<PageBean<AppInfo>> getApps(@Query("p") String jsonParam);
}
