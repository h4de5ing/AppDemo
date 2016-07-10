package com.code19.drawer;


import android.content.Context;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Administrator on 2016/7/11.
 */

public class Utils {
    public static void share(Context context) {
        ShareSDK.initSDK(context);
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.setText("分享标题");
        onekeyShare.setTitleUrl("http://19code.com");
        onekeyShare.setText("这里是我在测试的分享文本");
        onekeyShare.setUrl("http://3lin9.19code.com");
        onekeyShare.show(context);
    }
}
