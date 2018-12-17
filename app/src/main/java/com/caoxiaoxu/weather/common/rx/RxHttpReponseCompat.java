package com.caoxiaoxu.weather.common.rx;


import com.caoxiaoxu.weather.base.bean.BaseBean;
import com.caoxiaoxu.weather.common.exception.ApiException;
import com.caoxiaoxu.weather.common.exception.BaseException;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * 作者：caoxu
 * 时间：2018/12/10.
 * 统一捕获网络返回异常
 */

public class RxHttpReponseCompat {

    public static <T extends BaseBean.HeWeather6Bean> Observable.Transformer<BaseBean<T>, T> compatResult() {
        return new Observable.Transformer<BaseBean<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseBean<T>> baseBeanObservable) {

                return baseBeanObservable.flatMap(new Func1<BaseBean<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(final BaseBean<T> tBaseBean) {
                        //判断HeWeather是否为nulll
                        if (tBaseBean.getHeWeather6() != null || tBaseBean.getHeWeather6().size() >= 0) {

                            //获取实际返回值
                            final T bean = tBaseBean.getHeWeather6().get(0);
                            if (bean.success()) {
                                return Observable.create(new Observable.OnSubscribe<T>() {
                                    @Override
                                    public void call(Subscriber<? super T> subscriber) {
                                        try {
                                            subscriber.onNext(bean);
                                            subscriber.onCompleted();
                                        } catch (Exception e) {
                                            subscriber.onError(e);
                                        }
                                    }
                                });
                            } else {
                                //
                                //
                                //处理API返回异常
                                return Observable.error(new ApiException(ApiException.getErrorCode(bean.getStatus()), bean.getStatus()));
                            }

                        } else {
                            //TODO NULL
                            //处理无返回值异常
                            return Observable.error(new ApiException(BaseException.NO_DATA, "NULL"));
                        }


                    }
                    //使网络请求发生在IO线程返回结果在主线程中处理
                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };

    }

    ;

}
