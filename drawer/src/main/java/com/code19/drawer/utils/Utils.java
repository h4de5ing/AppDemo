package com.code19.drawer.utils;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.Toast;

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
    }

    public static void openAssetsDoc(Context context, String url) {
        try {
            Intent intent = new Intent(context, DocActivity.class);
            intent.putExtra(DocActivity.DOCURL, "file:///android_asset/blog/" + url);
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "文件没找到", Toast.LENGTH_SHORT).show();
        }
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

    public static boolean saveImg(Bitmap bitmap, String filename) {
        boolean compress = false;
        File file = new File("/sdcard/", filename);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            compress = bitmap.compress(Bitmap.CompressFormat.PNG, 90, outputStream);
            outputStream.flush();
            outputStream.close();
            compress = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compress;
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

    public static class Doc_Config {
        public static String WaverViewDocURL = "http://3lin9.19code.com/documents/WaveView.html";
    }
}
