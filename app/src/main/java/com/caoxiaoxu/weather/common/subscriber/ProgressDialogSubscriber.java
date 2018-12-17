package com.caoxiaoxu.weather.common.subscriber;

import com.caoxiaoxu.weather.base.contract.BaseContract;
import com.caoxiaoxu.weather.common.rx.RxErrorHandler;

/**
 * 作者：caoxu
 * 时间：2018/12/17.
 */

public abstract class ProgressDialogSubscriber<T> extends ErrorHandlerSubscriber<T> {
    private BaseContract.BaseView mView;

    public ProgressDialogSubscriber(BaseContract.BaseView view, RxErrorHandler rxErrorHandler) {
        super(rxErrorHandler);
        this.mView = view;
    }

    @Override
    public void onCompleted() {
        if (isShowDialog())
            dismissProgressDialog();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (isShowDialog())
            showProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        super.onError(e);
        if (isShowDialog())
            dismissProgressDialog();
    }


    private void showProgressDialog() {
        mView.dismissLoadingDialog();

    }

    private void dismissProgressDialog() {
        mView.dismissLoadingDialog();

    }

    private boolean isShowDialog() {
        return true;
    }
}
