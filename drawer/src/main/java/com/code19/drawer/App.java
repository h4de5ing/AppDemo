package com.code19.drawer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.code19.library.L;


/**
 * Created by Administrator on 2016/7/12.
 */

public class App extends Application {
    private static Context mContext;

    public App() {
        //统一管理Activity生命周期
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                //L.i("onActivityCreated", activity.getLocalClassName());
            }

            @Override
            public void onActivityStarted(Activity activity) {
                //L.i("onActivityStarted", activity.getLocalClassName());
            }

            @Override
            public void onActivityResumed(Activity activity) {
                //L.i("onActivityResumed", activity.getLocalClassName());
            }

            @Override
            public void onActivityPaused(Activity activity) {
                //L.i("onActivityPaused", activity.getLocalClassName());
            }

            @Override
            public void onActivityStopped(Activity activity) {
                //L.i("onActivityStopped", activity.getLocalClassName());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                //L.i("onActivitySaveInstanceState", activity.getLocalClassName());
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                //L.i("onActivityDestroyed", activity.getLocalClassName());
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    /**
     * 捕获未捕获的异常，如果发生异常，将异常信息写入到文件中并重启应用
     */
    private class MyUnCaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread thread, Throwable throwable) {
            L.crash2File(App.this, throwable);
            Intent intent = new Intent(App.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            App.this.startActivity(intent);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);//非0数表示非正常退出 0正常退出
        }
    }
}
