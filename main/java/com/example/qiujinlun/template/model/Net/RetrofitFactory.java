package com.example.qiujinlun.template.model.Net;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 配置属性
 */
public class RetrofitFactory {
    private static final String BASE_URL = "https://api.douban.com/v2/movie/";
    private static OkHttpClient okHttpClient;
    private static Retrofit retrofit;

    /*配置okHttp客户端*/
    private static OkHttpClient getOkHttpClient(){
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(6, TimeUnit.SECONDS)
                    .readTimeout(40, TimeUnit.SECONDS)
                    .writeTimeout(40, TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }

    /*配置的Retrofit客户端*/
    private static Retrofit retrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }


    private static IApiService iApiService;

    public static IApiService getIApiService(){
        if (iApiService == null) {
            iApiService = retrofit().create(IApiService.class);
        }
        return iApiService;
    }
}
