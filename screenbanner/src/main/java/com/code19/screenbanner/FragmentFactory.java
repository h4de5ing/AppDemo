package com.code19.screenbanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseArray;

import com.code19.screenbanner.fragments.ImageFragment;
import com.code19.screenbanner.fragments.TextFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gh0st on 2016/12/4.
 */

class FragmentFactory {

    static List<Fragment> getFragments() {
        List<Fragment> list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            ImageFragment imageFragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", "Image_title......" + i);
            imageFragment.setArguments(bundle);
            list.add(imageFragment);
            TextFragment textFragment = new TextFragment();
            Bundle b = new Bundle();
            b.putString("title", "Text_title_______" + i);
            textFragment.setArguments(b);
            list.add(textFragment);
        }
        /**
         * viewpager个数低于4的时候有一个bug
         */
        if (list.size() < 4) {
            for (int i = 0; i < 1; i++) {
                ImageFragment imageFragment = new ImageFragment();
                Bundle bundle = new Bundle();
                bundle.putString("title", "Image_title......" + i);
                imageFragment.setArguments(bundle);
                list.add(imageFragment);
                TextFragment textFragment = new TextFragment();
                Bundle b = new Bundle();
                b.putString("title", "Text_title_______" + i);
                textFragment.setArguments(b);
                list.add(textFragment);
            }
        }
        return list;
    }
}
