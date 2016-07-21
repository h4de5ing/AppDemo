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
import com.code19.drawer.activity.ResumeActivity;

/**
 * Created by Gh0st on 2016/7/9.
 * 4:15
 */
public class MaterialFragment extends Fragment implements View.OnClickListener {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_material, null);
        Button materialbadge = (Button) view.findViewById(R.id.material_badge);
        Button materialrecycler = (Button) view.findViewById(R.id.material_recycler);
        materialbadge.setOnClickListener(this);
        materialrecycler.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.material_badge:
                startActivity(new Intent(getActivity(), ResumeActivity.class));
                break;
            case R.id.material_recycler:
                break;
        }
    }
}
