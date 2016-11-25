package com.code19.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Button get = (Button) findViewById(R.id.btn_test);
        mResult = (TextView) findViewById(R.id.tv_result);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String runScript = Utils.runScript("getprop");
                mResult.setText(runScript);
            }
        });
    }
}
