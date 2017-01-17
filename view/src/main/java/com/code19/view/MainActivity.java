package com.code19.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.code19.library.AppUtils;
import com.code19.library.DateUtils;
import com.code19.library.FileUtils;
import com.code19.library.L;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mResult;
    private RecyclerView mApp_list;
    private AppRecyAdapter mRecyAdapter;
    private List<AppModel> mListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        mListData = getAppData();
        Button get = (Button) findViewById(R.id.btn_test);
        mResult = (TextView) findViewById(R.id.tv_result);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String runScript = Utils.runScript("getprop");
                mResult.setText(runScript);
            }
        });

        mApp_list = (RecyclerView) findViewById(R.id.app_list);
        mApp_list.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyAdapter = new AppRecyAdapter(this, mListData);
        mRecyAdapter.setOnClickListener(new AppRecyAdapter.OnClickListener() {
            @Override
            public void onItemClick(int position) {
                //Toast.makeText(MainActivity.this, "启动" + position, Toast.LENGTH_SHORT).show();
                //L.i("file:", mListData.get(position).getAppApk());
                FileUtils.shareFile(MainActivity.this, "分享Apk", mListData.get(position).getAppApk());
            }
        });
        mApp_list.setAdapter(mRecyAdapter);
    }

    private List<AppModel> getAppData() {
        List<AppModel> appDatas = new ArrayList<AppModel>();
        PackageManager pm = getPackageManager();
        List<PackageInfo> infoList = pm.getInstalledPackages(0);
        for (PackageInfo info : infoList) {
            AppModel appModel = new AppModel();
            String appName = AppUtils.getAppName(this, info.packageName);
            Drawable appIcon = AppUtils.getAppIcon(this, info.packageName);
            String appDate = DateUtils.formatDate(AppUtils.getAppDate(this, info.packageName));
            String appSize = FileUtils.formatFileSize(this, AppUtils.getAppSize(this, info.packageName));
            appModel.setAppName(appName);
            appModel.setAppIcon(appIcon);
            appModel.setAppDate(appDate);
            appModel.setAppSize(appSize);
            appModel.setAppPack(info.packageName);
            appModel.setAppApk(getAppApk(this, info.packageName));
            if (!TextUtils.isEmpty(appName) && !TextUtils.isEmpty(appDate) && !TextUtils.isEmpty(appSize)) {
                appDatas.add(appModel);
            }
        }
        return appDatas;
    }

    public static String getAppApk(Context context, String packageName) {
        String sourceDir = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(packageName, 0);
            sourceDir = applicationInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return sourceDir;
    }
}
