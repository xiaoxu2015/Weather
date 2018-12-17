package com.caoxiaoxu.weather.common.exception;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：caoxu
 * 时间：2018/12/11.
 */

public class ApiException extends BaseException {
    public static final int INVALID_KEY = 0x9;
    public static final int UNKNOWN_LOCATION = 0x10;
    public static final int NO_DATA_FOR_THIS_LOCATION = 0x11;
    public static final int NO_MORE_REQUESTS = 0x12;
    public static final int PARAM_INVALID = 0x13;
    public static final int DEAD = 0x14;
    public static final int PERMISSION_DENIED = 0x15;
    public static final int SIGN_ERROR = 0x16;
    public static final int OK = 0x17;
    public static final int TOO_FAST = 0x18;

    public static Map<String, Integer> ERROR_CODE = new HashMap<>();

    static {
        ERROR_CODE.put("ok", OK);
        ERROR_CODE.put("invalid key", INVALID_KEY);
        ERROR_CODE.put("unknown location", UNKNOWN_LOCATION);
        ERROR_CODE.put("no data for this location", NO_DATA_FOR_THIS_LOCATION);
        ERROR_CODE.put("no more requests", NO_MORE_REQUESTS);
        ERROR_CODE.put("param invalid", PARAM_INVALID);
        ERROR_CODE.put("too fast", TOO_FAST);
        ERROR_CODE.put("dead", DEAD);
        ERROR_CODE.put("permission denied", PERMISSION_DENIED);
        ERROR_CODE.put("sign error", SIGN_ERROR);
    }

    /**
     * 获取错误码
     */
    public static int getErrorCode(String key) {

        try {

            if (!TextUtils.isEmpty(key)) {
                key = key.trim();
                return ERROR_CODE.get(key);
            }
        } catch (Exception e) {
            return UNKNOWN_ERROR;
        }
        return UNKNOWN_ERROR;
    }

    public ApiException(int code, String displayMessage) {
        super(code, displayMessage);
    }
}
