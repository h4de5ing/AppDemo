package com.code19.drawer;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 * Activity管理类,如果activity实例结束掉了,而没有从sActivityList移除,会造成内存泄漏
 */

public class ActivityContainer {
    private static ActivityContainer mContainer;
    private static List<Activity> sActivityList;

    private ActivityContainer() {
        sActivityList = new ArrayList<Activity>();
    }

    public static ActivityContainer getInstace() {
        if (mContainer == null) {
            mContainer = new ActivityContainer();
        }
        return mContainer;
    }

    public void addActivity(Activity activity) {
        sActivityList.add(activity);
    }

    public void removeActivity(Activity activity) {
        sActivityList.remove(activity);
    }

    public void finishAllActivity() {
        for (int i = 0; i < sActivityList.size(); i++) {
            if (sActivityList.get(i) != null) {
                sActivityList.get(i).finish();
            }
        }
        sActivityList.clear();
    }
}
