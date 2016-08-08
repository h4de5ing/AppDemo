package com.code19.drawer.utils;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.util.MonthDisplayHelper;
import android.util.StringBuilderPrinter;
import android.util.TimeUtils;
import android.util.TimingLogger;

import com.code19.drawer.R;
import com.code19.drawer.activity.DocActivity;

import java.util.TimeZone;

/**
 * Created by Administrator on 2016/7/11.
 * 分析使用Android.utils中的类
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
        public static String OpenSourceURL = "http://3lin9.19code.com/os.txt";
    }

    /**
     * 分析android.utils包中的类
     */
    //屏幕相关
    public void DisplayMetrics(Context context) {
        //DisplayMetrics metrics = new DisplayMetrics();
        //getWindowManager().getDefaultDisplay().getMetrics(metrics);
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float density = metrics.density; //逻辑分辨率 1.0 2.0 3.0 density=dpi/160
        float scaledDensity = metrics.scaledDensity; //同上
        int densityDpi = metrics.densityDpi;  //dpi  480
        int heightPixels = metrics.heightPixels;//屏幕高 1080
        int widthPixels = metrics.widthPixels; //屏幕宽1776 (1920)
        float xdpi = metrics.xdpi; //准确的物理像素  442.451
        float ydpi = metrics.ydpi; // 443.345
        String s = metrics.toString();
        L.i(densityDpi + "", s);
    }

    //TODO 缓存相关
    public void LruCache() {
    }

    //6行日历网格格式一个月出现的问题
    public void MonthDisplayHelper() {
        MonthDisplayHelper helper = new MonthDisplayHelper(2016, 8);
        //MonthDisplayHelper helper = new MonthDisplayHelper(2016, 8，Calendar.MONDAY);//第三个参数表是一周从那一天开始MONDAY，SUNDAY
        int columnOf = helper.getColumnOf(1); //第一列
        int dayAt = helper.getDayAt(1, 2);//第1行第2列是那一天
        int[] digitsForRow = helper.getDigitsForRow(1);
        int month = helper.getMonth();
        int numberOfDaysInMonth = helper.getNumberOfDaysInMonth();
        int offset = helper.getOffset();
        int rowOf = helper.getRowOf(1);
        int weekStartDay = helper.getWeekStartDay();
        int year = helper.getYear();
        boolean withinCurrentMonth = helper.isWithinCurrentMonth(1, 2);
        //helper.nextMonth(); //下一月
        //helper.previousMonth(); //上一月
    }

    // 键值对容器
    public void Pair() {
        //Pair pair = new Pair("aa", "bbb");
        //Object first = pair.first;
        //Object second = pair.second;
        //boolean a = pair.equals("a");
        //int i = pair.hashCode();
    }

    public void Property() {
    }

    public void StringBBuilderPrinter() {
        StringBuilderPrinter printer = new StringBuilderPrinter(new StringBuilder());
        printer.println("admin");
    }

    //时区工具类
    public void TimeUtils() {
        TimeZone timeZone = TimeUtils.getTimeZone(1, true, System.currentTimeMillis(), "cn");
        TimeUtils.getTimeZoneDatabaseVersion();
    }

    //记录方法调用时间的工具类
    public void TimingLogger() {
        TimingLogger logger = new TimingLogger("TAG", "");
        //方法A
        logger.addSplit("方法A");
        //方法B
        logger.addSplit("方法");
        logger.dumpToLog();

        logger.reset();
        logger.reset("newTAG", "newLable");
    }

    //动态容器,存放Resource中的值
    public void TypedValue() {

    }

}
