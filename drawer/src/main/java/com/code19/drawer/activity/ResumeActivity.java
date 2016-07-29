package com.code19.drawer.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.code19.drawer.R;
import com.code19.library.ImageUtils;

import java.io.File;

import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

public class ResumeActivity extends BaseActivity {

    private ImageView mResume;
    private Bitmap mBitmap;
    private AlertDialog.Builder mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);
        initActionBar(true, "我的简历");
        initDialog();
        mResume = (ImageView) findViewById(R.id.resume);
        QRCodeEncoder.encodeQRCode("http://19code.com/android.html", BGAQRCodeUtil.dp2px(ResumeActivity.this, 300), Color.parseColor("#0000ff"), BitmapFactory.decodeResource(ResumeActivity.this.getResources(), R.drawable.user_avatar), new QRCodeEncoder.Delegate() {
            @Override
            public void onEncodeQRCodeSuccess(Bitmap bitmap) {
                mResume.setImageBitmap(bitmap);
                mBitmap = bitmap;
            }

            @Override
            public void onEncodeQRCodeFailure() {
                Toast.makeText(ResumeActivity.this, "简历生成错误", Toast.LENGTH_SHORT).show();
            }
        });
        mResume.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mDialog.show();
                return true;
            }
        });
    }

    private void initDialog() {
        mDialog = new AlertDialog.Builder(this);
        mDialog.setTitle("是否保存二维码?");
        mDialog.setMessage("保存二维码,就是将Bitmap转换成Png...");
        mDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ImageUtils.bitmap2File(mBitmap, new File("/sdcard/resume.jpg"));
            }
        });
        mDialog.setNegativeButton("取消", null);
    }
}
