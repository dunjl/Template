package com.example.qiujinlun.template.View;

import android.view.View;

import com.example.qiujinlun.template.model.bo.Movie;


public interface MovieView {
    public void showMovieMsg(Movie data);

    public void showError(String message);

    public void post(View view);
}
