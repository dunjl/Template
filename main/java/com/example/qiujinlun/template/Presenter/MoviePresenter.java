package com.example.qiujinlun.template.Presenter;

import com.example.qiujinlun.template.model.bo.Movie;
import com.example.qiujinlun.template.model.DataManager;
import com.example.qiujinlun.template.View.MovieView;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MoviePresenter {
    private MovieView movieView;
    private CompositeDisposable compositeDisposable;

    public MoviePresenter(MovieView view){
        this.movieView=view;
    }

    /*往线程管理添加线程*/
    public void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    /*停止线程管理中的所有线程*/
    public void disposeAll() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
            compositeDisposable = null;
        }
    }

    public void getMovieMsg(int start,int count){
        Disposable disposable = DataManager.getInstance()
                .getMsg(start,count)
                .subscribe(new Consumer<Movie>() {//请求成功
                    @Override
                    public void accept(@NonNull Movie data) throws Exception {
                        movieView.showMovieMsg(data);
                    }
                },new Consumer<Throwable>() {//请求失败

                    @Override
                    public void accept(@NonNull Throwable e) throws Exception {
                        movieView.showError(e.getMessage());
                    }
                });
        addDisposable(disposable);
    }

}
