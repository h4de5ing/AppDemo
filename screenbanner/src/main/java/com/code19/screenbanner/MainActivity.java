package com.code19.screenbanner;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;

import com.ToxicBakery.viewpager.transforms.ABaseTransformer;
import com.ToxicBakery.viewpager.transforms.AccordionTransformer;
import com.ToxicBakery.viewpager.transforms.BackgroundToForegroundTransformer;
import com.ToxicBakery.viewpager.transforms.CubeInTransformer;
import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.ToxicBakery.viewpager.transforms.FlipVerticalTransformer;
import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;
import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.ToxicBakery.viewpager.transforms.ScaleInOutTransformer;
import com.ToxicBakery.viewpager.transforms.StackTransformer;
import com.ToxicBakery.viewpager.transforms.TabletTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomInTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutSlideTransformer;
import com.ToxicBakery.viewpager.transforms.ZoomOutTranformer;
import com.code19.screenbanner.animi.ZoomOutPageTransformer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ViewPager mPager;
    private List<Fragment> fragmentList;
    private List<ViewPager.PageTransformer> animaiList;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        fragmentList = FragmentFactory.getFragments();
        animaiList = new ArrayList<>();
        animaiList.add(new DepthPageTransformer());
        animaiList.add(new ZoomOutPageTransformer());
        animaiList.add(new AccordionTransformer());
        animaiList.add(new BackgroundToForegroundTransformer());
        animaiList.add(new CubeInTransformer());
        animaiList.add(new CubeOutTransformer());
        animaiList.add(new DepthPageTransformer());
        animaiList.add(new FlipHorizontalTransformer());
        animaiList.add(new FlipVerticalTransformer());
        animaiList.add(new ForegroundToBackgroundTransformer());
        animaiList.add(new RotateDownTransformer());
        animaiList.add(new RotateUpTransformer());
        animaiList.add(new ScaleInOutTransformer());
        animaiList.add(new StackTransformer());
        animaiList.add(new TabletTransformer());
        animaiList.add(new ZoomInTransformer());
        animaiList.add(new ZoomOutSlideTransformer());
        animaiList.add(new ZoomOutTranformer());
        mPager = (ViewPager) findViewById(R.id.vp_list);
        mPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fragmentList));
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mPager.setPageTransformer(true, animaiList.get((int) Math.round(Math.random() * (animaiList.size() - 1))));
                fragmentList.get(position % fragmentList.size());
                //mPager.setCurrentItem(position % fragmentList.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        try {
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(mPager.getContext(), new AccelerateInterpolator());
            field.set(mPager, scroller);
            scroller.setmDuration(800);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MyTask task = new MyTask();
        task.start();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        finish();
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        finish();
        return super.dispatchTouchEvent(ev);
    }

    public class MyTask implements Runnable {
        void start() {
            mHandler.removeCallbacksAndMessages(null);
            mHandler.postDelayed(this, 2000);
        }

        @Override
        public void run() {
            mPager.setCurrentItem(mPager.getCurrentItem()+1);
            mHandler.postDelayed(this, 2000);
        }
    }
}