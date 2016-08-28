package com.code19.updialog;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Gh0st on 2016/8/27.
 * 13:39
 */
public class UpdataDialog extends DialogFragment implements View.OnClickListener {


    private TextView mUpdatetips;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Window window = getDialog().getWindow();
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_updata, container);
        TextView updateok2 = (TextView) view.findViewById(R.id.update_ok2);
        TextView updatecancel = (TextView) view.findViewById(R.id.update_cancel);
        TextView updateok = (TextView) view.findViewById(R.id.update_ok);
        mUpdatetips = (TextView) view.findViewById(R.id.update_tips);
        updateok.setOnClickListener(this);
        updateok2.setOnClickListener(this);
        updatecancel.setOnClickListener(this);
        return view;
    }

    /**
     * 设置升级内容
     */
    public void setUpdateTips(String str) {
        mUpdatetips.setText(str);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update_ok: //单独的一个升级按钮
                Toast.makeText(getActivity(), "升级中...ok", Toast.LENGTH_SHORT);
                break;
            case R.id.update_cancel:
                Toast.makeText(getActivity(), "取消升级...", Toast.LENGTH_SHORT);
                this.dismiss();
                break;
            case R.id.update_ok2:
                Toast.makeText(getActivity(), "升级中...ok2", Toast.LENGTH_SHORT);
                break;
        }
    }
}
