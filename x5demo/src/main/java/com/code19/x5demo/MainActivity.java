package com.code19.x5demo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private static final String mHomeUrl = "http://www.yichezhen.cn/Home/Groupon/index.html";
    private static final String mShengqingUrl = "http://www.yichezhen.cn/Home/Groupon/enroll.html";
    private static final String TAG = "x5";
    //private static final String mHomeUrl = "http://app.html5.qq.com/navi/index";
    private WebView mWebView;
    ProgressBar mProgressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.webview);
        mProgressbar = (ProgressBar) findViewById(R.id.progressbar);
        initWebView();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView != null && mWebView.canGoBack()) {
                mWebView.goBack();
                return true;
            } else
                return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    private void initWebView() {
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                Log.e("x5", "request.getUrl().toString() is " + request.getUrl().toString());
                return super.shouldInterceptRequest(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (!url.equals(mHomeUrl) && !url.equals(mShengqingUrl)) {//拼伙详情
                    mWebView.evaluateJavascript("getShare();", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String s) {
                            Log.i(TAG, "js返回的内容" + s);
                        }
                    });
                }
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                if (mHomeUrl == null)
                    return;
                Log.d("x5", title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (mProgressbar != null) {
                    if (newProgress != 100) {
                        mProgressbar.setVisibility(View.VISIBLE);
                        mProgressbar.setProgress(newProgress);
                    } else {
                        mProgressbar.setVisibility(View.GONE);
                    }
                }
            }
        });
        mWebView.setDownloadListener(new DownloadListener() {

            @Override
            public void onDownloadStart(String arg0, String arg1, String arg2, String arg3, long arg4) {
                Log.d("x5", "url: " + arg0);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Title...")
                        .setPositiveButton("yes",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(MainActivity.this, "fake message: i'll download...", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "fake message: refuse download...", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnCancelListener(
                                new DialogInterface.OnCancelListener() {

                                    @Override
                                    public void onCancel(DialogInterface dialog) {
                                        Toast.makeText(MainActivity.this, "fake message: refuse download...", Toast.LENGTH_SHORT).show();
                                    }
                                }).show();
            }
        });
        WebSettings webSetting = mWebView.getSettings();
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false);
        //webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        //webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        webSetting.setAppCachePath(this.getDir("appcache", 0).getPath());
        webSetting.setDatabasePath(this.getDir("databases", 0).getPath());
        webSetting.setGeolocationDatabasePath(this.getDir("geolocation", 0).getPath());
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        //webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        // webSetting.setPreFectch(true);
        mWebView.loadUrl(mHomeUrl);
        //CookieSyncManager.createInstance(this);
        //CookieSyncManager.getInstance().sync();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWebView != null) {
            //mWebView.destroy();
            mWebView.getSettings().setBuiltInZoomControls(true);
            mWebView.setVisibility(View.GONE);
            long timeout = ViewConfiguration.getZoomControlsTimeout();//timeout ==3000
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    //mWebView.destroy();
                }
            }, timeout);
        }
    }
}
