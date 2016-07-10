package com.code19.drawer;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.code19.drawer.fragment.CustomViewFragment;
import com.code19.drawer.fragment.MaterialFragment;
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
            case R.id.custom_view:
                fragment = new CustomViewFragment();
                break;
            case R.id.material_design:
                fragment = new MaterialFragment();
                break;
            case R.id.solution:
                fragment = new SolutionFragment();
                break;
            default:
                break;
        }
        map.put(MenuItemId, fragment);
        return fragment;
    }
}
