package com.code19.spinner;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by gh0st on 2016/9/8.
 */

public class PopupUtils {


    public static void showPopup(Context context, View root, final int[] ResIds) {
        final PopupWindow popupWindow = new PopupWindow();
        View view = View.inflate(context, R.layout.item_pop, null);
        popupWindow.setContentView(view);
        popupWindow.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        final ImageView iv = (ImageView) view.findViewById(R.id.iv_source);
        TextView tv = (TextView) view.findViewById(R.id.tv_click);
        tv.setOnClickListener(new View.OnClickListener() {
            int times = 0;

            @Override
            public void onClick(View v) {
                if (times < ResIds.length) {
                    iv.setBackgroundResource(ResIds[times]);
                } else {
                    popupWindow.dismiss();
                }
                times++;
            }
        });
        popupWindow.showAtLocation(root, Gravity.CENTER, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
    }
}
