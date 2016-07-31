package com.code19.drawer.utils;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;

import com.code19.drawer.R;
import com.code19.drawer.activity.DocActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016/7/11.
 */

public class Utils {

    public static void openURLDoc(Context context, String url) {
        Intent intent = new Intent(context, DocActivity.class);
        intent.putExtra(DocActivity.DOCURL, url);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    public static void openAssetsDoc(Context context, String url) {
        Intent intent = new Intent(context, DocActivity.class);
        intent.putExtra(DocActivity.DOCURL, "file:///android_asset/blog/" + url);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    //Activity 从右边往左滑动
    public static void right2left(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    //Activity 从左边往右滑动
    public static void left2right(Context context) {
        ((Activity) context).overridePendingTransition(R.anim.in_from_left, R.anim.out_to_right);
    }

    public static void crash2File(Context context, String msg) {
        String absolutePath = context.getExternalCacheDir().getAbsolutePath();
        File file = new File(absolutePath + "/log_" + System.currentTimeMillis() + ".log");
        FileOutputStream trace = null;
        try {
            trace = new FileOutputStream(file, true);
            OutputStreamWriter writer = new OutputStreamWriter(trace, "utf-8");
            writer.write(msg);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createShotCut(Context context, String name, int icon, Class<?> cls) {
        Intent shottcutIntent = new Intent(Intent.ACTION_MAIN);
        //加入action和category之后，卸载程序会删除快捷方式
        shottcutIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        shottcutIntent.setClass(context, cls);
        shottcutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Intent shortcut = new Intent(Intent.ACTION_CREATE_SHORTCUT);
        shortcut.putExtra("duplicate", false);//不允许重复
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shottcutIntent);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, name);//名称
        Intent.ShortcutIconResource.fromContext(context, R.drawable.user_avatar);//图标id
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
        shortcut.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        context.sendBroadcast(shortcut);
    }

    //获取当前进程名字
    public static String getProcessName(Context appContext) {
        String currentProcessName = null;
        int pid = android.os.Process.myPid();
        ActivityManager manager = (ActivityManager) appContext.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == pid) {
                currentProcessName = processInfo.processName;
                break;
            }
        }
        return currentProcessName;
    }

    public static class Doc_Config {
        public static String WaverViewDocURL = "http://3lin9.19code.com/documents/WaveView.html";
        public static String OpenSourceURL = "http://3lin9.19code.com/os.txt";
    }
}
