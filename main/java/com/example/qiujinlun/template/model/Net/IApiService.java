package com.example.qiujinlun.template.model.Net;

import com.example.qiujinlun.template.model.bo.Movie;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 网络调用的接口
 */
public interface IApiService {
    /**
     * 获取豆瓣信息
     *
     * @param start
     * @param count
     * @return
     */
    @GET("top250")
    Flowable<Movie> getMsg(@Query("start") int start,@Query("count") int count);
}
