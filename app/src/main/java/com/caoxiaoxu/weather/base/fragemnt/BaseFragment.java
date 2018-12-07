package com.caoxiaoxu.weather.base.fragemnt;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caoxiaoxu.weather.WeatherApplication;
import com.caoxiaoxu.weather.base.contract.BaseContract;
import com.caoxiaoxu.weather.di.component.AppComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：caoxu
 * 时间：2018/12/7.
 */

public abstract class BaseFragment<T extends BaseContract.BasePresenter> extends Fragment {
    private Unbinder mUnbinder;
    private WeatherApplication mWeatherApplication;
    @Inject
    T mPresenter;
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mWeatherApplication = (WeatherApplication) getActivity().getApplication();
        setupActivityComponent(mWeatherApplication.getAppComponent());
        initView();
        initData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    public abstract void setupActivityComponent(AppComponent appComponent);
}
