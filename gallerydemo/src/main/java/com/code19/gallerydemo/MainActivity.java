package com.code19.gallerydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.model.PhotoInfo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final int REQUEST_CODE_GALLERY = 1001;
    private ImageView mIv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnopen = (Button) findViewById(R.id.btn_open);
        mIv_image = (ImageView) findViewById(R.id.iv_image);
        btnopen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_open:
                FunctionConfig config = new FunctionConfig.Builder()
                            .setMutiSelectMaxSize(8)
                        .build();
                GalleryFinal.openGalleryMuti(REQUEST_CODE_GALLERY, config, new GalleryFinal.OnHanlderResultCallback() {
                    @Override
                    public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
                        //mIv_image.setImageResource(resultList.get(0).getPhotoPath());
                    }

                    @Override
                    public void onHanlderFailure(int requestCode, String errorMsg) {

                    }
                });
                break;
        }
    }
}
