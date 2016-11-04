package com.code19.gallerydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.baoyz.actionsheet.ActionSheet;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.PauseOnScrollListener;
import cn.finalteam.galleryfinal.ThemeConfig;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import cn.finalteam.galleryfinal.widget.HorizontalListView;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE_CAMERA = 1000;
    private final int REQUEST_CODE_GALLERY = 1001;

    @Bind(R.id.btn_open_gallery)
    Button mBtnOpenGallery;
    @Bind(R.id.lv_photo)
    HorizontalListView mLvPhoto;
    @Bind(R.id.cb_show_camera)
    CheckBox mCbShowCamera;
    @Bind(R.id.cb_preview)
    CheckBox mCbPreview;
    @Bind(R.id.cb_no_animation)
    CheckBox mCbNoAnimation;

    private List<PhotoInfo> mPhotoList;
    private ChoosePhotoListAdapter mChoosePhotoListAdapter;
    private Button mOpenGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mLvPhoto = (HorizontalListView) findViewById(R.id.lv_photo);
        mPhotoList = new ArrayList<>();
        mChoosePhotoListAdapter = new ChoosePhotoListAdapter(this, mPhotoList);
        mLvPhoto.setAdapter(mChoosePhotoListAdapter);
        mOpenGallery = (Button) findViewById(R.id.btn_open_gallery);
        mOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //公共配置都可以在application中配置，这里只是为了代码演示而写在此处
                ThemeConfig themeConfig = ThemeConfig.DARK;
                FunctionConfig.Builder functionConfigBuilder = new FunctionConfig.Builder();
                ImageLoader imageLoader = new GlideImageLoader();
                PauseOnScrollListener pauseOnScrollListener = new GlidePauseOnScrollListener(false, true);
                final boolean mutiSelect = true;//多选
                functionConfigBuilder.setMutiSelectMaxSize(8);//最大数量  默认8
                functionConfigBuilder.setEnableEdit(false);//不可编辑
                functionConfigBuilder.setEnableRotate(false);//旋转
                functionConfigBuilder.setRotateReplaceSource(false);//旋转后是否替换原始
                functionConfigBuilder.setEnableCrop(false);//裁剪
                //functionConfigBuilder.setCropWidth(width);
                //functionConfigBuilder.setCropHeight(height);
                functionConfigBuilder.setCropSquare(true);//裁剪正方形
                functionConfigBuilder.setCropReplaceSource(true);//裁剪后是否替换
                functionConfigBuilder.setForceCrop(true);
                functionConfigBuilder.setForceCropEdit(true);
                functionConfigBuilder.setEnableCamera(true);
                functionConfigBuilder.setEnablePreview(true);
                functionConfigBuilder.setSelected(mPhotoList);//添加过滤集合
                final FunctionConfig functionConfig = functionConfigBuilder.build();
                CoreConfig coreConfig = new CoreConfig.Builder(MainActivity.this, imageLoader, themeConfig)
                        .setFunctionConfig(functionConfig)
                        .setPauseOnScrollListener(pauseOnScrollListener)
                        .setNoAnimcation(mCbNoAnimation.isChecked())
                        .build();
                GalleryFinal.init(coreConfig);

                ActionSheet.createBuilder(MainActivity.this, getSupportFragmentManager())
                        .setCancelButtonTitle("取消(Cancel)")
                        .setOtherButtonTitles("打开相册(Open Gallery)", "拍照(Camera)")
                        .setCancelableOnTouchOutside(true)
                        .setListener(new ActionSheet.ActionSheetListener() {
                            @Override
                            public void onDismiss(ActionSheet actionSheet, boolean isCancel) {

                            }

                            @Override
                            public void onOtherButtonClick(ActionSheet actionSheet, int index) {
                                String path = "/sdcard/pk1-2.jpg";
                                switch (index) {
                                    case 0:
                                        if (mutiSelect) {
                                            GalleryFinal.openGalleryMuti(REQUEST_CODE_GALLERY, functionConfig, mOnHanlderResultCallback);
                                        } else {
                                            GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, functionConfig, mOnHanlderResultCallback);
                                        }
                                        break;
                                    case 1:
                                        GalleryFinal.openCamera(REQUEST_CODE_CAMERA, functionConfig, mOnHanlderResultCallback);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }).show();
            }
        });
    }

    private GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback = new GalleryFinal.OnHanlderResultCallback() {
        @Override
        public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
            if (resultList != null) {
                mPhotoList.addAll(resultList);
                mChoosePhotoListAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onHanlderFailure(int requestCode, String errorMsg) {
            Toast.makeText(MainActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
        }
    };

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == GalleryFinal.GALLERY_REQUEST_CODE) {
//            if (resultCode == GalleryFinal.GALLERY_RESULT_SUCCESS) {
//                List<PhotoInfo> photoInfoList = (List<PhotoInfo>) data.getSerializableExtra(GalleryFinal.GALLERY_RESULT_LIST_DATA);
//                if (photoInfoList != null) {
//                    mPhotoList.addAll(photoInfoList);
//                    mChoosePhotoListAdapter.notifyDataSetChanged();
//                }
//            }
//        }
//    }

}
