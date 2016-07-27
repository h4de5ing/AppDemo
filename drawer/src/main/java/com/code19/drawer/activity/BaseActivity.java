package com.code19.drawer.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.code19.library.SystemUtils;

public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initActionBar(boolean homeButtonEnable, String title) {
        getSupportActionBar().setHomeButtonEnabled(homeButtonEnable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeButtonEnable);
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (SystemUtils.isBackground(this)) {
            Toast.makeText(this, "app进入后台运行", Toast.LENGTH_SHORT).show();
        }
    }
}
