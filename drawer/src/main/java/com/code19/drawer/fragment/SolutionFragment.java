package com.code19.drawer.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.code19.drawer.MainActivity;
import com.code19.drawer.R;
import com.code19.drawer.activity.SolutionGqrActivity;
import com.code19.drawer.activity.SolutionLoginActivity;
import com.code19.drawer.activity.SolutionQrScannerActivity;
import com.code19.drawer.utils.Utils;
import com.code19.library.SystemUtils;


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
        Button solonekeylockscreen = (Button) view.findViewById(R.id.sol_onekey_lockscreen);
        Button solalipaypaycode = (Button) view.findViewById(R.id.sol_alipay_paycode);
        Button solcreateshortcut = (Button) view.findViewById(R.id.sol_create_shortcut);
        Button solfloatmenu = (Button) view.findViewById(R.id.sol_float_menu);
        Button solgqrscan = (Button) view.findViewById(R.id.sol_gqr_scan);
        Button solqrscan = (Button) view.findViewById(R.id.sol_qr_scan);
        Button solalipayscan = (Button) view.findViewById(R.id.sol_alipay_scan);
        Button solwechatscan = (Button) view.findViewById(R.id.sol_wechat_scan);
        Button solchecklogin = (Button) view.findViewById(R.id.sol_check_login);
        solcreateshortcut.setOnClickListener(this);
        solfloatmenu.setOnClickListener(this);
        solgqrscan.setOnClickListener(this);
        solqrscan.setOnClickListener(this);
        solalipaypaycode.setOnClickListener(this);
        solalipayscan.setOnClickListener(this);
        solwechatscan.setOnClickListener(this);
        solchecklogin.setOnClickListener(this);
        solonekeylockscreen.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sol_check_login:
                this.startActivity(new Intent(getActivity(), SolutionLoginActivity.class));
                break;
            case R.id.sol_qr_scan:
                startActivity(new Intent(getActivity(), SolutionQrScannerActivity.class));
                break;
            case R.id.sol_gqr_scan:
                this.startActivity(new Intent(getActivity(), SolutionGqrActivity.class));
                break;
            case R.id.sol_wechat_scan:
                SystemUtils.toWeChatScan(getActivity());
                break;
            case R.id.sol_alipay_scan:
                SystemUtils.toAliPayScan(getActivity());
                break;
            case R.id.sol_alipay_paycode:
                SystemUtils.toAliPayPayCode(getActivity());
                break;
            case R.id.sol_create_shortcut:
                Utils.createShotCut(getActivity(), "Text", R.drawable.user_avatar, MainActivity.class);
                break;
            case R.id.sol_onekey_lockscreen:
                downloadUrl();
                break;
            case R.id.sol_float_menu:
                break;
        }
    }

    /**
     * 1 通过浏览器下载
     */
    private void downloadUrl() {
        String url = "http://3lin9.19code.com/app.apk";
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        startActivity(intent);
    }

    /**
     * 2 后台静默下载
     * TODO 3 服务下载  4 下载管理器下载 5 应用市场下载
     */
    private void downloadInBack() {
        String url = "http://3lin9.19code.com/app.apk";

    }
}
