package com.code19.drawer;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.code19.drawer.utils.Utils;

/**
 * Created by Administrator on 2016/7/12.
 */

public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
    }

    public static Context getContext() {
        return mContext;
    }

    private class MyUnCaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread thread, Throwable throwable) {
            throwable.printStackTrace();
            Utils.crash2File(App.this, throwable.getMessage());
            Intent intent = new Intent(App.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            App.this.startActivity(intent);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }
}
