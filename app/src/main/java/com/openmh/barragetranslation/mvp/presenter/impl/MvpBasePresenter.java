package com.openmh.barragetranslation.mvp.presenter.impl;

import android.content.Context;

import com.openmh.barragetranslation.mvp.presenter.MvpPresenter;
import com.openmh.barragetranslation.mvp.view.MvpView;

/**
 * mvpBasePresenter实现view绑定
 * Created by zengmianhui on 2017/2/6.
 */

public abstract class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private Context context;
    private V view;

    public V getView() {
        return view;
    }

    public MvpBasePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void attachView(V view) {
        this.view=view;
    }

    @Override
    public void detachView() {
        view=null;
    }
}
