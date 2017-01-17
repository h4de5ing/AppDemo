package com.code19.retrofitdemo.data.remote;

/**
 * Created by gh0st on 2016/12/27.
 */

public class ApiUtils {
    public static final String BASE_URL = "https://baidu.com";

    public static IndexService getIndexService() {
        return RetrofitClient.getClient(BASE_URL).create(IndexService.class);
    }
}
