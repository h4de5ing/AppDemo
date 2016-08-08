package com.code19.drawer.utils;

import android.util.Log;
import android.util.LogPrinter;

/**
 * Created by Administrator on 2016/8/8.
 * 输出系统级的日志,调用Log.print_native本地方法输出
 */

public class L {

    public static void v(String tag, String msg) {
        new LogPrinter(Log.VERBOSE, tag).println(msg);
    }

    public static void d(String tag, String msg) {
        new LogPrinter(Log.DEBUG, tag).println(msg);
    }

    public static void i(String tag, String msg) {
        new LogPrinter(Log.INFO, tag).println(msg);
    }

    public static void w(String tag, String msg) {
        new LogPrinter(Log.WARN, tag).println(msg);
    }

    public static void e(String tag, String msg) {
        new LogPrinter(Log.ERROR, tag).println(msg);
    }

}
