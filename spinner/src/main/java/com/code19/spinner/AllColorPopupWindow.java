package com.code19.spinner;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Gh0st on 2016/8/21.
 * 12:05
 */
public class AllColorPopupWindow extends BasePopupWindowForListView<String> {


    private TextView mTitl;

    public AllColorPopupWindow(View contentView, int width, int height, boolean focusable) {
        super(contentView, width, height, focusable);
    }

    @Override
    protected void beforeInitWeNeedSomeParams(Object... params) {

    }

    @Override
    public void initViews() {
        mTitl = (TextView) findViewById(R.id.pop_title);
        Button close = (Button) findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllColorPopupWindow.this.dismiss();
            }
        });
    }

    @Override
    public void initEvents() {

    }

    @Override
    public void init() {

    }

    public void setTitl(String title) {
        mTitl.setText(title);
    }
}
