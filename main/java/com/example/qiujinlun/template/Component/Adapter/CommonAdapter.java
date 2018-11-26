package com.example.qiujinlun.template.Component.Adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.example.qiujinlun.template.View.MovieView;


import java.util.List;

/**
 * Databinding 绑定RecyclerView
 * 通用Adapter
 * @param <T>
 */

public class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {
    private List<T> mDatas;

    private int layoutId;

    private int brId;

    private MovieView movieView;

    public CommonAdapter(List<T> mDatas, int layoutId, int brId,MovieView view) {
        this.mDatas = mDatas;
        this.layoutId = layoutId;
        this.brId = brId;
        this.movieView=view;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        ViewHolder viewHolder = new ViewHolder(binding.getRoot());
        viewHolder.setBinding(binding);
        viewHolder.itemView.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getBinding().setVariable(brId,mDatas.get(position));
        holder.getBinding().executePendingBindings();
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public void onClick(View v) {
        movieView.post(v);
    }
}
