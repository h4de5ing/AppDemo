package com.code19.drawer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;

import com.code19.drawer.R;
import com.code19.drawer.utils.Utils;
import com.code19.drawer.view.WaveView;

/**
 * Created by Gh0st on 2016/7/9.
 * 4:11
 */
public class WaveViewActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave_view);
        initActionBar(true, "水波纹");
        WaveView waveview = (WaveView) findViewById(R.id.waveview);
        waveview.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_doc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_doc) {
            Utils.openURLDoc(this, Utils.Doc_Config.WaverViewDocURL);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
