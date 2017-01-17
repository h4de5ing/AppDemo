package com.code19.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.code19.retrofitdemo.data.remote.ApiUtils;
import com.code19.retrofitdemo.data.remote.IndexService;
import com.code19.retrofitdemo.data.remote.model.Index;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private IndexService mIndexService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIndexService = ApiUtils.getIndexService();
        getDataFromNet();
    }

    private void getDataFromNet() {
        mIndexService.getIndex().enqueue(new Callback<List<Index.DataBean>>() {
            @Override
            public void onResponse(Call<List<Index.DataBean>> call, Response<List<Index.DataBean>> response) {
                if (response.code() == 200) {
                    Log.i(TAG, response.code() + "0");
                }
                if (response.isSuccessful()) {
                    Log.i(TAG, response.code() + "1");
                }
            }

            @Override
            public void onFailure(Call<List<Index.DataBean>> call, Throwable t) {

            }
        });
    }
}
