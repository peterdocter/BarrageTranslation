package com.openmh.barragetranslation.mvp.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.openmh.barragetranslation.mvp.presenter.impl.MvpBasePresenter;
import com.openmh.barragetranslation.mvp.view.MvpView;

/**
 * Created by zengmianhui on 2017/2/6.
 */

public abstract class MvpFragment<P extends MvpBasePresenter,V extends MvpView> extends Fragment {
    private P presenter;

    public P getPresenter() {
        return presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=bindPresenter();
        if (presenter!=null)
            presenter.attachView(bindView());
    }
    /**
     * 绑定View
     * @return
     */
    protected abstract V bindView();
    /**
     * 绑定Presenter
     * @return
     */
    protected abstract P bindPresenter();
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter=bindPresenter();//初始化P
        if (presenter!=null){
            presenter.detachView();//解除绑定
        }
    }
}
