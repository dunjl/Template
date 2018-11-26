package com.example.qiujinlun.template.Component.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.qiujinlun.template.Component.Adapter.CommonAdapter;
import com.example.qiujinlun.template.Presenter.MoviePresenter;
import com.example.qiujinlun.template.R;
import com.example.qiujinlun.template.BR;
import com.example.qiujinlun.template.View.MovieView;
import com.example.qiujinlun.template.model.Event.TitleEvent;
import com.example.qiujinlun.template.model.bo.Movie;
import com.example.qiujinlun.template.model.bo.Subjects;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieView {
    private List<Subjects> mSubjects;
    private RecyclerView mRecyclerView;
    private MoviePresenter moviePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview);

        init();

        //Eventbus注册,单例模式
        EventBus.getDefault().register(this);
    }

    private void init() {
        moviePresenter=new MoviePresenter(this);
        moviePresenter.getMovieMsg(0,12);
    }

    @Override
    public void showMovieMsg(Movie data) {
        mSubjects=data.getSubjects();
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        mRecyclerView.setLayoutManager(layoutManager);
        CommonAdapter<Subjects> adapter = new CommonAdapter<Subjects>(mSubjects,R.layout.item_movie,BR.subjects,this);
        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void post(View view) {
        String title=mSubjects.get((Integer)view.getTag()).getTitle();
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //解除注册
        if(EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }

    }

    /**
     * @Subscribe,消费事件的标识，
     * @param titleEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getTitle(TitleEvent titleEvent){
        Toast.makeText(this,titleEvent.getMessage(),Toast.LENGTH_LONG).show();
        moviePresenter.getMovieMsg(20,12);

    }

}
