package com.code19.updialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Gh0st on 2016/8/27.
 * 15:18
 */
public class UpDialog extends Dialog implements View.OnClickListener {


    private Context mContext;
    private boolean oneButton;
    private DialogListener listener;
    private String mTips, mTitle, mConfirm, mCancle;
    private LinearLayout mUpdatetwobutton;
    private TextView mUpdateok2;
    private TextView mUpdatecancel;
    private TextView mUpdateok;
    private TextView mUpdatetips;
    private TextView mUpdatetitle;


    public UpDialog(Context context, @NonNull String tips) {
        this(context, tips, null, null, null, false);
    }

    public UpDialog(Context context, @NonNull String tips, boolean oneButton) {
        this(context, tips, null, null, null, oneButton);
    }

    public UpDialog(Context context, @NonNull String tips, String title, String confirmText, String cancleText, boolean oneButton) {
        super(context, R.style.DialogStyle);
        this.mContext = context;
        this.mTips = tips;
        this.mTitle = title;
        this.mConfirm = confirmText;
        this.mCancle = confirmText;
        this.oneButton = oneButton;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_updata, null);
        mUpdatetwobutton = (LinearLayout) view.findViewById(R.id.update_two_button);
        mUpdateok2 = (TextView) view.findViewById(R.id.update_ok2);
        mUpdatecancel = (TextView) view.findViewById(R.id.update_cancel);
        mUpdateok = (TextView) view.findViewById(R.id.update_ok);
        mUpdatetips = (TextView) view.findViewById(R.id.update_tips);
        mUpdatetitle = (TextView) view.findViewById(R.id.update_title);
        setContentView(view);
        this.setCanceledOnTouchOutside(true);
        mUpdateok.setOnClickListener(this);
        mUpdateok2.setOnClickListener(this);
        mUpdatecancel.setOnClickListener(this);
        if (!TextUtils.isEmpty(mTitle)) {
            mUpdatetitle.setText(mTitle);
        }
        if (!TextUtils.isEmpty(mTips)) {
            mUpdatetips.setText(mTips);
        }
        if (!TextUtils.isEmpty(mConfirm)) {
            mUpdateok.setText(mConfirm);
            mUpdateok2.setText(mConfirm);
        }
        if (!TextUtils.isEmpty(mCancle)) {
            mUpdatecancel.setText(mCancle);
        }
        if (oneButton) {
            mUpdatetwobutton.setVisibility(View.GONE);
            mUpdateok.setVisibility(View.VISIBLE);
        } else {
            mUpdatetwobutton.setVisibility(View.VISIBLE);
            mUpdateok.setVisibility(View.GONE);
        }
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = (int) metrics.widthPixels * 3 / 4;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_ok:
                if (listener != null) {
                    listener.onConfirm();
                }
                break;
            case R.id.update_cancel:
                if (listener != null) {
                    listener.onConfirm();
                }
                break;
            case R.id.update_ok2:
                if (listener != null) {
                    listener.onCancle();
                }
                break;
        }
    }

    public void setOnDialogListener(DialogListener listener) {
        this.listener = listener;
    }


    public interface DialogListener {
        void onCancle();

        void onConfirm();
    }
}
