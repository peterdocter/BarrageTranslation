package com.openmh.barragetranslation.mvp.presenter;

import com.openmh.barragetranslation.mvp.view.MvpView;

/**
 * Created by zengmianhui on 2017/2/6.
 */

public interface MvpPresenter<V extends MvpView> {
    //绑定view
    void attachView(V view);
    //解绑
    void detachView();
}
