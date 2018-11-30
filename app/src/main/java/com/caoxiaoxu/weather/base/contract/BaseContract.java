package com.caoxiaoxu.weather.base.contract;

/**
 * Created by T560 on 2018/11/30.
 */

public interface BaseContract {
    public interface BaseModel {
    }

    public interface BasePresenter {
    }

    public interface BaseView {
        /**
         * 显示加载框
         */
        void showLoadingDialog();

        /**
         * 隐藏加载框
         */
        void dismissLoadingDialog();
    }
}

