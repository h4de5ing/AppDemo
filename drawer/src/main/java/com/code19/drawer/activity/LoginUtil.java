package com.code19.drawer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.code19.drawer.AccountMgr;

/**
 * https://gold.xitu.io/entry/5781db3ac4c9710066da1ca9
 */
public class LoginUtil extends AppCompatActivity {
    private int REQUSET_CODE_LOGIN = 1;
    static LoginCallback mCallback;

    public interface LoginCallback {
        void onLogin();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, LoginActivity.class);//跳转到登陆页面
        startActivityForResult(intent, REQUSET_CODE_LOGIN);
    }

    public static void checkLogin(Context context, LoginCallback callback) {
        boolean login = AccountMgr.get().isLogin(context);//获取登陆状态
        if (login) {
            callback.onLogin();
        } else {
            mCallback = callback;
           /* Intent intent = new Intent(context, LoginUtil.class);
            context.startActivity(intent);*/
        }
    }

    public static void checkLogin(Context context, LoginCallback logged, LoginCallback callback) {
        boolean login = AccountMgr.get().isLogin(context);//获取登陆状态
        if (login) {
            logged.onLogin();
        } else {
            mCallback = callback;
            Intent intent = new Intent(context, LoginUtil.class);
            context.startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        finish();
        if (requestCode == REQUSET_CODE_LOGIN && resultCode == RESULT_OK && mCallback != null) {
            mCallback.onLogin();
        }
        mCallback = null;
    }
}
