package com.code19.drawer.utils;


import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

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
        File file = new File(context.getExternalFilesDir("/log_" + System.currentTimeMillis() + ".log").getAbsolutePath());
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

    /**
     * Created by Administrator on 2016/79.
     */

    public static class Doc_Config {
        public static String WaverViewDocURL = "http://3lin9.19code.com/documents/WaveView.html";
    }
}
