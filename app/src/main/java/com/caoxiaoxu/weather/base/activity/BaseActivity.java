package com.caoxiaoxu.weather.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.caoxiaoxu.weather.WeatherApplication;
import com.caoxiaoxu.weather.base.contract.BaseContract;
import com.caoxiaoxu.weather.base.presenter.BasePresenter;
import com.caoxiaoxu.weather.di.component.AppComponent;
import com.caoxiaoxu.weather.utils.LogUtil;
import com.caoxiaoxu.weather.widget.LoadingDialog;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：caoxu
 * 时间：2018/12/6.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseContract.BaseView {
    private Unbinder mUnbinder;
    private WeatherApplication mWeatherApplication;
    @Inject
    public T mPresenter;

    protected LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        //butterknife 绑定
        mUnbinder = ButterKnife.bind(this);
        this.mWeatherApplication = (WeatherApplication) getApplication();
        //dagger2 注入
        setupActivityComponent(mWeatherApplication.getAppComponent());
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //butterknife 解绑
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    @Override
    public void showLoadingDialog() {
        LogUtil.d("showLoadingDialog");
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        try {
            if (!loadingDialog.isShowing()) {

                loadingDialog.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void dismissLoadingDialog() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            try {
                loadingDialog.dismiss();
                LogUtil.d("dismissLoadingDialog");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    public abstract void setupActivityComponent(AppComponent appComponent);
}
