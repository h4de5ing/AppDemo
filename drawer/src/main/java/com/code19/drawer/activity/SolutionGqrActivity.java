package com.code19.drawer.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.code19.drawer.R;

import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.zxing.QRCodeDecoder;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

public class SolutionGqrActivity extends BaseActivity {
    private ImageView mChineseIv;
    private ImageView mEnglishIv;
    private ImageView mChineseLogoIv;
    private ImageView mEnglishLogoIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution_gqr_scanner);
        initView();
        initActionBar(true, getResources().getString(R.string.scan_gqr));
        createQRCode();
    }

    private void initView() {
        mChineseIv = (ImageView) findViewById(R.id.iv_chinese);
        mChineseLogoIv = (ImageView) findViewById(R.id.iv_chinese_logo);
        mEnglishIv = (ImageView) findViewById(R.id.iv_english);
        mEnglishLogoIv = (ImageView) findViewById(R.id.iv_english_logo);
    }

    private void createQRCode() {
        createChineseQRCode();
        createEnglishQRCode();
        createChineseQRCodeWithLogo();
        createEnglishQRCodeWithLogo();
    }

    private void createChineseQRCode() {
        QRCodeEncoder.encodeQRCode("安卓", BGAQRCodeUtil.dp2px(SolutionGqrActivity.this, 150), new QRCodeEncoder.Delegate() {
            @Override
            public void onEncodeQRCodeSuccess(Bitmap bitmap) {
                mChineseIv.setImageBitmap(bitmap);
            }

            @Override
            public void onEncodeQRCodeFailure() {
                Toast.makeText(SolutionGqrActivity.this, "生成中文二维码失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createEnglishQRCode() {
        QRCodeEncoder.encodeQRCode("createEnglishQRCode", BGAQRCodeUtil.dp2px(SolutionGqrActivity.this, 150), Color.parseColor("#ff0000"), new QRCodeEncoder.Delegate() {
            @Override
            public void onEncodeQRCodeSuccess(Bitmap bitmap) {
                mEnglishIv.setImageBitmap(bitmap);
            }

            @Override
            public void onEncodeQRCodeFailure() {
                Toast.makeText(SolutionGqrActivity.this, "生成英文二维码失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createChineseQRCodeWithLogo() {
        QRCodeEncoder.encodeQRCode("安卓", BGAQRCodeUtil.dp2px(SolutionGqrActivity.this, 150), Color.parseColor("#795dbf"), BitmapFactory.decodeResource(SolutionGqrActivity.this.getResources(), R.drawable.user_avatar), new QRCodeEncoder.Delegate() {
            @Override
            public void onEncodeQRCodeSuccess(Bitmap bitmap) {
                mChineseLogoIv.setImageBitmap(bitmap);
            }

            @Override
            public void onEncodeQRCodeFailure() {
                Toast.makeText(SolutionGqrActivity.this, "生成带logo的中文二维码失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createEnglishQRCodeWithLogo() {
        QRCodeEncoder.encodeQRCode("createEnglishQRCodeWithLogo", BGAQRCodeUtil.dp2px(SolutionGqrActivity.this, 150), Color.parseColor("#0000ff"), BitmapFactory.decodeResource(SolutionGqrActivity.this.getResources(), R.drawable.user_avatar), new QRCodeEncoder.Delegate() {
            @Override
            public void onEncodeQRCodeSuccess(Bitmap bitmap) {
                mEnglishLogoIv.setImageBitmap(bitmap);
            }

            @Override
            public void onEncodeQRCodeFailure() {
                Toast.makeText(SolutionGqrActivity.this, "生成带logo的英文二维码失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void decodeChinese(View v) {
        mChineseIv.setDrawingCacheEnabled(true);
        Bitmap bitmap = mChineseIv.getDrawingCache();
        decode(bitmap, "解析中文二维码失败");
    }

    public void decodeEnglish(View v) {
        mEnglishIv.setDrawingCacheEnabled(true);
        Bitmap bitmap = mEnglishIv.getDrawingCache();
        decode(bitmap, "解析英文二维码失败");
    }

    public void decodeChineseWithLogo(View v) {
        mChineseLogoIv.setDrawingCacheEnabled(true);
        Bitmap bitmap = mChineseLogoIv.getDrawingCache();
        decode(bitmap, "解析带logo的中文二维码失败");
    }

    public void decodeEnglishWithLogo(View v) {
        mEnglishLogoIv.setDrawingCacheEnabled(true);
        Bitmap bitmap = mEnglishLogoIv.getDrawingCache();
        decode(bitmap, "解析带logo的英文二维码失败");
    }

    public void decodeIsbn(View v) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test_isbn);
        decode(bitmap, "解析ISBN失败");
    }

    private void decode(Bitmap bitmap, final String errorTip) {
        QRCodeDecoder.decodeQRCode(bitmap, new QRCodeDecoder.Delegate() {
            @Override
            public void onDecodeQRCodeSuccess(String result) {
                Toast.makeText(SolutionGqrActivity.this, result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDecodeQRCodeFailure() {
                Toast.makeText(SolutionGqrActivity.this, errorTip, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
