package com.caoxiaoxu.weather.common.rx;

import android.content.Context;
import android.widget.Toast;

import com.caoxiaoxu.weather.common.exception.ApiException;
import com.caoxiaoxu.weather.common.exception.BaseException;
import com.caoxiaoxu.weather.common.exception.ErrorMessageFactory;

import org.json.JSONException;

import java.net.SocketTimeoutException;

import retrofit2.HttpException;


/**
 * 作者：caoxu
 * 时间：2018/12/14.
 */

public class RxErrorHandler {
    private Context mContext;

    public RxErrorHandler(Context context) {
        this.mContext = context;
    }

    public BaseException handlerError(Throwable e) {
        BaseException exception = new BaseException();
        if (e instanceof ApiException) {
            exception.setCode(((ApiException) e).getCode());

        } else if (e instanceof JSONException) {
            exception.setCode(BaseException.JSON_ERROR);

        } else if (e instanceof HttpException) {
            exception.setCode(((HttpException) e).code());
        } else if (e instanceof SocketTimeoutException) {
            exception.setCode(BaseException.SOCKET_TIMEOUT_ERROR);
        } else {
            exception.setCode(BaseException.UNKNOWN_ERROR);
        }
        exception.setDisplayMessage(ErrorMessageFactory.create(mContext, exception.getCode()));
        return exception;
    }

    public void showErrorMessage(BaseException e) {
        Toast.makeText(mContext, e.getDisplayMessage(), Toast.LENGTH_SHORT).show();

    }
}
