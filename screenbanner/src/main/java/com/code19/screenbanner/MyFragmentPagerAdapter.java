package com.code19.screenbanner;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by gh0st on 2016/12/4.
 */

class MyFragmentPagerAdapter extends FragmentPagerAdapter  {
    private List<Fragment> mFragmentList;

    MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        mFragmentList = list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position = position % mFragmentList.size();
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        position = position % mFragmentList.size();
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position % mFragmentList.size());
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
}
