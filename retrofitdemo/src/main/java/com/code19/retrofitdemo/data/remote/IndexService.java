package com.code19.retrofitdemo.data.remote;

import com.code19.retrofitdemo.data.remote.model.Index;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gh0st on 2016/12/27.
 */

public interface IndexService {
    @GET("/index/index")
    Call<List<Index.DataBean>> getIndex();
}
