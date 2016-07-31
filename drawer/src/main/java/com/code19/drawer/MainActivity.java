package com.code19.drawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.code19.drawer.activity.BaseActivity;
import com.code19.drawer.activity.SearchActivity;
import com.code19.drawer.activity.SettingsActivity;
import com.code19.drawer.utils.FragmentFactory;
import com.code19.drawer.utils.Utils;


public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, FragmentFactory.getFragment(R.id.nav_custom_view)).commit();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.setDrawerListener(toggle);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //按2次返回键退出应用
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //2秒之内按返回键就会退出应用
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                //System.exit(0);//正常退出应用
            }
            return true;
        } /*else if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //长按返回键
            Toast.makeText(this, "长按返回键", Toast.LENGTH_SHORT).show();
        } else if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 2) {
            //event.getRepeatCount() 为0时代表单击了一次，当次数>=1时就代表长按了,值越大，说明按的时间越长。
            //System.exit(0);
        }*/
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                navigateToSearch(MainActivity.this);
                break;
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                Utils.left2right(this);
                break;
            case R.id.action_opensource:
                Utils.openAssetsDoc(this, "other/OpenSource.html");
                break;
            case R.id.action_about:
                Utils.openAssetsDoc(this, "other/About.html");
                break;
        }
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        String title = getString(R.string.app_name);
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_custom_view:
                title = getString(R.string.nav_custom_view);
                break;
            case R.id.nav_material_design:
                title = getString(R.string.nav_materialdesign);
                break;
            case R.id.nav_solution:
                title = getString(R.string.nav_solution);
                break;
            case R.id.nav_blog:
                title = getString(R.string.nav_blog);
                break;
            case R.id.nav_opensource:
                Utils.openURLDoc(this, Utils.Doc_Config.OpenSourceURL);
                break;
            case R.id.nav_exitapp:
                finish();
                break;
        }
        getSupportActionBar().setTitle(title);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, FragmentFactory.getFragment(id)).commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static void navigateToSearch(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.setAction("navigate_search");
        context.startActivity(intent);
    }
}
