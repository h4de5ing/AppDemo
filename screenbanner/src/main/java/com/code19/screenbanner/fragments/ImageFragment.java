package com.code19.screenbanner.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.code19.screenbanner.R;

/**
 * Created by gh0st on 2016/12/4.
 */

public class ImageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_fragment, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_image_title);
        tv.setText("图片Fragment" + getArguments().getString("title"));
        return view;
    }
}
