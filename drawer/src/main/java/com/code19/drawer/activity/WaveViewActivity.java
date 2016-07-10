package com.code19.drawer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.code19.drawer.Doc_Config;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_doc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_doc) {
            Intent intent = new Intent(this, DocActivity.class);
            intent.putExtra(DocActivity.DOC, Doc_Config.WaverViewDocURL);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
