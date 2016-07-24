package com.code19.drawer.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.code19.drawer.R;
import com.code19.drawer.activity.GqrActivity;
import com.code19.drawer.activity.LoginActivity;
import com.code19.drawer.activity.QrScannerActivity;


/**
 * Created by Gh0st on 2016/7/10.
 * 19:57
 */
public class SolutionFragment extends android.support.v4.app.Fragment implements View.OnClickListener {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_solution, null);
        Button solfloatmenu = (Button) view.findViewById(R.id.sol_float_menu);
        Button solgqrscan = (Button) view.findViewById(R.id.sol_gqr_scan);
        Button solqrscan = (Button) view.findViewById(R.id.sol_qr_scan);
        Button solalipayscan = (Button) view.findViewById(R.id.sol_alipay_scan);
        Button solwechatscan = (Button) view.findViewById(R.id.sol_wechat_scan);
        Button solchecklogin = (Button) view.findViewById(R.id.sol_check_login);
        solfloatmenu.setOnClickListener(this);
        solgqrscan.setOnClickListener(this);
        solqrscan.setOnClickListener(this);
        solalipayscan.setOnClickListener(this);
        solwechatscan.setOnClickListener(this);
        solchecklogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sol_check_login:
                this.startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.sol_qr_scan:
                startActivity(new Intent(getActivity(), QrScannerActivity.class));
                break;
            case R.id.sol_gqr_scan:
                this.startActivity(new Intent(getActivity(), GqrActivity.class));
                break;
            case R.id.sol_wechat_scan:
                toWeChatScan();
                break;
            case R.id.sol_alipay_scan:
                toAliPayScan();
                break;
            case R.id.sol_float_menu:
                break;
        }
    }

    private void toWeChatScan() {
        try {
            Uri uri = Uri.parse("weixin://dl/scan");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getActivity(), "无法跳转到微信，请检查您是否安装了微信！", Toast.LENGTH_SHORT).show();
        }
    }

    private void toAliPayScan() {
        try {
            Uri uri = Uri.parse("alipayqr://platformapi/startapp?saId=10000007");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(getActivity(), "无法跳转到支付宝，请检查您是否安装了支付宝！", Toast.LENGTH_SHORT).show();
        }
    }
}
