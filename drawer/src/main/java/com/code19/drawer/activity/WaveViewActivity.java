package com.code19.drawer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.code19.drawer.R;
import com.code19.drawer.view.WaveView;

/**
 * Created by Gh0st on 2016/7/9.
 * 4:11
 */
public class WaveViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_view);
        WaveView waveview = (WaveView) findViewById(R.id.waveview);
        waveview.start();
    }
}
