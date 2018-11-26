package com.example.qiujinlun.template.model.bo;

import android.databinding.BaseObservable;

public class Subjects {
    private String title, year;
    private Images images;

    public Subjects(String title, String year, Images images) {
        this.title = title;
        this.year = year;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public Images getImages() {
        return images;
    }

}
