package com.code19.spinner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

public class PopupActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mRoot;
    private int[] mRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        mRoot = (LinearLayout) findViewById(R.id.activity_popup);
        Button text02 = (Button) findViewById(R.id.text02);
        Button text01 = (Button) findViewById(R.id.text01);
        text01.setOnClickListener(this);
        text02.setOnClickListener(this);
        mRes = new int[]{R.drawable.guide_release, R.drawable.guide_find_car, R.drawable.guide_msg, R.drawable.guide_4s, R.drawable.guide_money};
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text01:
                PopupUtils.showPopup(this, mRoot, mRes);
                break;
            case R.id.text02:
                PopupUtils.showPopup(this, mRoot, new int[]{R.drawable.guide_forrow, R.drawable.guide_send_msg, R.drawable.guide_weidian});
                break;
        }
    }
}
