package com.code19.badge;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * 购物车点击的监听。
     */
    private static final int DELETE_WHAT = 0X01;
    /**
     * 其它按钮。
     */
    private static final int PIC_WHAT = 0X02;
    /**
     * Toolbar菜单中的购物车按钮。
     */
    private BadgeActionProvider mDeleteBadgeActionProvider;
    /**
     * Toolbar菜单中的其它按钮。
     */
    private BadgeActionProvider mPicBadgeActionProvider;

    private int cartGoodsCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.add_single).setOnClickListener(onBtnClickListener);
        findViewById(R.id.add_double).setOnClickListener(onBtnClickListener);
    }

    /**
     * 按钮点击监听。
     */
    private View.OnClickListener onBtnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.add_single) {
                cartGoodsCount++;
                mDeleteBadgeActionProvider.setBadge(cartGoodsCount);
            } else if (view.getId() == R.id.add_double) {
                mPicBadgeActionProvider.setText("99");
            }
        }
    };

    /**
     * Toolbar自定义菜单，点击监听。
     */
    private BadgeActionProvider.OnClickListener onClickListener = new BadgeActionProvider.OnClickListener() {
        @Override
        public void onClick(int what) {
            if (what == DELETE_WHAT) {
                Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();
            } else if (what == PIC_WHAT) {
                Toast.makeText(MainActivity.this, "图片", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // 购物车。
        MenuItem menuItem = menu.findItem(R.id.menu_delete);
        mDeleteBadgeActionProvider = (BadgeActionProvider) MenuItemCompat.getActionProvider(menuItem);
        mDeleteBadgeActionProvider.setOnClickListener(DELETE_WHAT, onClickListener);

        // 其它。
        MenuItem menuItemOther = menu.findItem(R.id.menu_pic);
        mPicBadgeActionProvider = (BadgeActionProvider) MenuItemCompat.getActionProvider(menuItemOther);
        mPicBadgeActionProvider.setOnClickListener(PIC_WHAT, onClickListener);
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mDeleteBadgeActionProvider.setIcon(R.mipmap.ic_action_delete_small);
        mPicBadgeActionProvider.setIcon(R.mipmap.ic_action_picture);
    }
}
