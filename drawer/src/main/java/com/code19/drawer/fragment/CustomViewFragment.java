package com.code19.drawer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.code19.drawer.R;
import com.code19.drawer.activity.DocActivity;
import com.code19.drawer.activity.WaveViewActivity;

/**
 * Created by Administrator on 2016/7/9.
 */

public class CustomViewFragment extends Fragment implements View.OnClickListener {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom, null);
        Button waveviewdoc = (Button) view.findViewById(R.id.waveviewdoc);
        Button waveview = (Button) view.findViewById(R.id.waveview);
        waveview.setOnClickListener(this);
        waveviewdoc.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.waveview:
                intent = new Intent(getActivity(), WaveViewActivity.class);
                break;
            case R.id.waveviewdoc:
                intent = new Intent(getActivity(), DocActivity.class);
                break;
        }
        startActivity(intent);
    }
}
