package com.example.qiujinlun.template.model;

import com.example.qiujinlun.template.model.bo.Movie;
import com.example.qiujinlun.template.model.Net.RetrofitFactory;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 管理业务逻辑
 */

public class DataManager {
    private static DataManager manager;

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (manager == null) {
            manager = new DataManager();
        }
        return manager;
    }

    /*获取数据*/
    public Flowable<Movie> getMsg(int start,int count){
        return RetrofitFactory.getIApiService()
                .getMsg(start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}

