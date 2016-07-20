package com.code19.drawer.utils;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.code19.drawer.R;
import com.code19.drawer.fragment.BlogFragment;
import com.code19.drawer.fragment.CustomViewFragment;
import com.code19.drawer.fragment.MaterialFragment;
import com.code19.drawer.fragment.OpenProjectFragment;
import com.code19.drawer.fragment.OpenSourceFragment;
import com.code19.drawer.fragment.SolutionFragment;

/**
 * Created by Administrator on 2016/7/9.
 */

public class FragmentFactory {
    private static SparseArray<Fragment> map = new SparseArray<Fragment>();

    public static Fragment getFragment(int MenuItemId) {
        Fragment fragment = null;
        if (map.get(MenuItemId) != null) {
            fragment = map.get(MenuItemId);
        }
        switch (MenuItemId) {
            case R.id.nav_custom_view:
                fragment = new CustomViewFragment();
                break;
            case R.id.nav_material_design:
                fragment = new MaterialFragment();
                break;
            case R.id.nav_solution:
                fragment = new SolutionFragment();
                break;
            case R.id.nav_blog:
                fragment=new BlogFragment();
                break;
            case R.id.nav_opensource:
                fragment=new OpenSourceFragment();
                break;
            case R.id.nav_openproject:
                fragment=new OpenProjectFragment();
                break;
            default:
                fragment=new CustomViewFragment();
                break;
        }
        map.put(MenuItemId, fragment);
        return fragment;
    }
}
