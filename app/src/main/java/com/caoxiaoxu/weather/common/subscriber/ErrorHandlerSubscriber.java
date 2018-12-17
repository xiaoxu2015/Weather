package com.caoxiaoxu.weather.common.subscriber;

import com.caoxiaoxu.weather.common.exception.BaseException;
import com.caoxiaoxu.weather.common.rx.RxErrorHandler;

/**
 * 作者：caoxu
 * 时间：2018/12/14.
 */

public abstract class ErrorHandlerSubscriber<T> extends DefualtSubscriber<T> {
    private RxErrorHandler rxErrorHandler;

    public ErrorHandlerSubscriber(RxErrorHandler rxErrorHandler) {
        this.rxErrorHandler = rxErrorHandler;
    }

    @Override
    public void onError(Throwable e) {
        BaseException exception = rxErrorHandler.handlerError(e);
        rxErrorHandler.showErrorMessage(exception);

    }


}
