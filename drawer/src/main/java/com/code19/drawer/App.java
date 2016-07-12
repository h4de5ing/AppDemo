package com.code19.drawer;

import android.app.Application;
import android.content.Intent;

/**
 * Created by Administrator on 2016/7/12.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
    }

    private class MyUnCaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread thread, Throwable throwable) {
            throwable.printStackTrace();
            Intent intent = new Intent(App.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            App.this.startActivity(intent);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }
}
