package com.caoxiaoxu.weather.common.exception;

import android.content.Context;

import com.caoxiaoxu.weather.R;

/**
 * 作者：caoxu
 * 时间：2018/12/14.
 */

public class ErrorMessageFactory {
    public static String create(Context context, int code) {

        String errorMsg = null;


        switch (code) {

            case BaseException.HTTP_ERROR:

                errorMsg = context.getResources().getString(R.string.error_http);

                break;

            case BaseException.SOCKET_TIMEOUT_ERROR:

                errorMsg = context.getResources().getString(R.string.error_socket_timeout);

                break;
            case BaseException.SOCKET_ERROR:

                errorMsg = context.getResources().getString(R.string.error_socket_unreachable);

                break;


            case BaseException.ERROR_HTTP_400:

                errorMsg = context.getResources().getString(R.string.error_http_400);

                break;


            case BaseException.ERROR_HTTP_404:

                errorMsg = context.getResources().getString(R.string.error_http_404);

                break;

            case BaseException.ERROR_HTTP_500:

                errorMsg = context.getResources().getString(R.string.error_http_500);

                break;


            case ApiException.ERROR_API_SYSTEM:
                errorMsg = context.getResources().getString(R.string.error_system);
                break;

            case ApiException.ERROR_API_ACCOUNT_FREEZE:
                errorMsg = context.getResources().getString(R.string.error_account_freeze);
                break;


            case ApiException.ERROR_API_NO_PERMISSION:
                errorMsg = context.getResources().getString(R.string.error_api_no_perission);
                break;

            case ApiException.ERROR_API_LOGIN:
                errorMsg = context.getResources().getString(R.string.error_login);
                break;
            case ApiException.INVALID_KEY:
                errorMsg = context.getResources().getString(R.string.invalid_key);
                break;
            case ApiException.UNKNOWN_LOCATION:
                errorMsg = context.getResources().getString(R.string.unknown_location);
                break;
            case ApiException.NO_DATA_FOR_THIS_LOCATION:
                errorMsg = context.getResources().getString(R.string.no_data_for_this_location);
                break;
            case ApiException.NO_MORE_REQUESTS:
                errorMsg = context.getResources().getString(R.string.no_more_requests);
                break;
            case ApiException.PARAM_INVALID:
                errorMsg = context.getResources().getString(R.string.param_invalid);
                break;
            case ApiException.TOO_FAST:
                errorMsg = context.getResources().getString(R.string.too_fast);
                break;
            case ApiException.DEAD:
                errorMsg = context.getResources().getString(R.string.dead);
                break;
            case ApiException.PERMISSION_DENIED:
                errorMsg = context.getResources().getString(R.string.permission_denied);
                break;
            case ApiException.SIGN_ERROR:
                errorMsg = context.getResources().getString(R.string.sign_error);
                break;
            case ApiException.NO_DATA:
                errorMsg = context.getResources().getString(R.string.no_data);
                break;


            default:
                errorMsg = context.getResources().getString(R.string.error_unkown);
                break;


        }


        return errorMsg;

    }

    ;
}
