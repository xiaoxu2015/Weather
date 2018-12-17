package com.caoxiaoxu.weather.utils;

import com.caoxiaoxu.weather.common.logger.Logger;;


/**
 * @作者： caoxu
 * @时间： 2018/2/11
 * @描述： Log打印工具类
 */
@SuppressWarnings("FieldCanBeLocal")
public class LogUtil {
    public static final Boolean sDebug = true;
    private static final String DefaultTag = "CPG_LOG";

    public static void v(String msg) {
        if (sDebug) {
            Logger.t(DefaultTag).v(msg);
        }
    }

    public static void v(String msg, Throwable e) {
        if (sDebug) {
            Logger.t(DefaultTag).v(msg, e);
        }
    }

    public static void d(String msg) {
        if (sDebug) {
            Logger.t(DefaultTag).d(msg);
        }
    }

    public static void d(String msg, Throwable e) {
        if (sDebug) {
            Logger.t(DefaultTag).d(msg, e);
        }
    }

    public static void i(String msg) {
        if (sDebug) {
            Logger.t(DefaultTag).i(msg);
        }
    }

    public static void i(String msg, Throwable e) {
        if (sDebug) {
            Logger.t(DefaultTag).i(msg, e);
        }
    }

    public static void w(String msg) {
        if (sDebug) {
            Logger.t(DefaultTag).w(msg);
        }
    }


    public static void w(String msg, Throwable e) {
        if (sDebug) {
            Logger.t(DefaultTag).w(msg, e);
        }
    }

    public static void e(String msg) {
        if (sDebug) {
            Logger.t(DefaultTag).e(msg);
        }
    }

    public static void e(String msg, Throwable e) {
        if (sDebug) {
            Logger.t(DefaultTag).e(msg, e);
        }
    }

    public static void net(String msg) {
        if (sDebug) {
            Logger.t("网络收发").e(msg);
        }
    }

    public static void json(String msg) {
        if (sDebug) {
            Logger.t("格式化JSON").json(msg);
        }
    }
}
