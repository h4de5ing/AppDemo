package com.code19.spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AllCarPopupWindow mAllCarPopupWindow;
    private AllColorPopupWindow mAllColorPopupWindow;
    private AllAreaPopupWindow mAllAreaPopupWindow;
    private int mScreenHeight;
    private LinearLayout container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        mScreenHeight = outMetrics.heightPixels;
        container = (LinearLayout) findViewById(R.id.spinner_contanier);
        TextView all_car = (TextView) findViewById(R.id.all_car);
        TextView all_color = (TextView) findViewById(R.id.all_color);
        TextView all_area = (TextView) findViewById(R.id.all_area);
        all_car.setOnClickListener(this);
        all_color.setOnClickListener(this);
        all_area.setOnClickListener(this);
        initPopupWindow();
    }

    private void initPopupWindow() {
        mAllCarPopupWindow = new AllCarPopupWindow(LayoutInflater.from(this).inflate(R.layout.all_car, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mAllColorPopupWindow = new AllColorPopupWindow(LayoutInflater.from(this).inflate(R.layout.all_car, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mAllAreaPopupWindow = new AllAreaPopupWindow(LayoutInflater.from(this).inflate(R.layout.all_car, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.all_car:
                open_all_car();
                break;
            case R.id.all_color:
                open_all_color();
                break;
            case R.id.all_area:
                open_all_area();
                break;
        }
    }

    private void open_all_car() {
       /* mAllCarPopupWindow = new AllCarPopupWindow(LayoutInflater.from(this).inflate(R.layout.all_car, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mAllCarPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
            }
        });*/
        //mAllCarPopupWindow.setAnimationStyle();
        mAllCarPopupWindow.setTitl("全部车型");
        if (mAllColorPopupWindow.isShowing()) {
            mAllColorPopupWindow.dismiss();
        }
        if (mAllAreaPopupWindow.isShowing()) {
            mAllAreaPopupWindow.dismiss();
        }
        if (mAllCarPopupWindow.isShowing()) {
            mAllCarPopupWindow.dismiss();
        } else {
            mAllCarPopupWindow.showAsDropDown(container, 0, 0);
        }
    }

    private void open_all_color() {
        //mAllColorPopupWindow = new AllColorPopupWindow(LayoutInflater.from(this).inflate(R.layout.all_car, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mAllColorPopupWindow.setTitl("全部颜色");
        if (mAllCarPopupWindow.isShowing()) {
            mAllCarPopupWindow.dismiss();
        }
        if (mAllAreaPopupWindow.isShowing()) {
            mAllAreaPopupWindow.dismiss();
        }
        if (mAllColorPopupWindow.isShowing()) {
            mAllColorPopupWindow.dismiss();
        } else {
            mAllColorPopupWindow.showAsDropDown(container, 0, 0);
        }

    }

    private void open_all_area() {
        //mAllAreaPopupWindow = new AllAreaPopupWindow(LayoutInflater.from(this).inflate(R.layout.all_car, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mAllAreaPopupWindow.setTitl("全部区域");
        if (mAllCarPopupWindow.isShowing()) {
            mAllCarPopupWindow.dismiss();
        }
        if (mAllColorPopupWindow.isShowing()) {
            mAllColorPopupWindow.dismiss();
        }
        if (mAllAreaPopupWindow.isShowing()) {
            mAllAreaPopupWindow.dismiss();
        } else {
            mAllAreaPopupWindow.showAsDropDown(container, 0, 0);
        }
    }

}
