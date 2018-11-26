package com.example.qiujinlun.template.model.bo;

public class Images {
    private String small;
    private String large;
    private String medium;

    public Images(String small,String large,String medium){
        this.small=small;
        this.large=large;
        this.medium=medium;
    }

    public String getSmall() {
        return small;
    }

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }
}
