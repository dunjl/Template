package com.example.qiujinlun.template.Utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.qiujinlun.template.R;

public class BindingUtil {

    /**
     * * 1.加载图片,无需手动调用此方法
     * *2.使用@BindingAdapter注解设置自定义属性的名称，imageUrl就是属性的名称，
     * * 当ImageView中使用imageUrl属性时，会自动调用loadImage方法，
     * *
     * * @param imageView ImageView
     * * @param url 图片地址
     * */

    @BindingAdapter({"imageUrl"})
    public static void loadIamge(ImageView imageView,String url)
    {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView);
    }


}
