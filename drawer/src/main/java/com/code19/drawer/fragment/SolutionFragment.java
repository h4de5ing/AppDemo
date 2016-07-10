package com.code19.drawer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.code19.drawer.R;
import com.code19.drawer.activity.LoginActivity;

/**
 * Created by Gh0st on 2016/7/10.
 * 19:57
 */
public class SolutionFragment extends android.support.v4.app.Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_solution, null);
        Button checklogin = (Button) view.findViewById(R.id.check_login);
        checklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View iew) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        return view;
    }
}
