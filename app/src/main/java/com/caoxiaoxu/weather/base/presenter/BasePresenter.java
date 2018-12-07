package com.caoxiaoxu.weather.base.presenter;

import com.caoxiaoxu.weather.base.contract.BaseContract;

/**
 * 作者：caoxu
 * 时间：2018/12/6.
 */

public class BasePresenter<M, V extends BaseContract.BaseView> {
    protected M mModel;
    protected V mView;

    public BasePresenter(M m, V v) {
        this.mModel = m;
        this.mView = v;
    }
}
