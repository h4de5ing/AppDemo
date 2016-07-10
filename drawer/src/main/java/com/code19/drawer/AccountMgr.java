package com.code19.drawer;

import android.content.Context;

import com.code19.library.SPUtils;

/**
 * Created by Administrator on 2016/7/10.
 */

public class AccountMgr {
    private static String accountfilename = "AccountMgr";
    private static AccountMgr mMgr;

    public static AccountMgr get() {
        if (mMgr == null) {
            mMgr = new AccountMgr();
        }
        return mMgr;
    }

    public boolean isLogin(Context context) {
        return (boolean) SPUtils.getSp(context, "isLogin", false);
    }

    public void Logined(Context context, String user, String password) {
        SPUtils.setSP(context, accountfilename, "isLogin", true);
        SPUtils.setSP(context, accountfilename, "username", user);
        SPUtils.setSP(context, accountfilename, "password", password);
    }

    public void logout(Context context) {
        SPUtils.setSP(context, accountfilename, "isLogin", false);
    }

    public String getUser(Context context) {
        return (String) SPUtils.getSp(context, "username", "null");
    }
}
