package com.openmh.barragetranslation.project.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openmh.barragetranslation.mvp.view.impl.MvpFragment;
import com.openmh.barragetranslation.project.base.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * Fragment基类
 * Created by zengmianhui on 2017/2/6.
 */

public abstract class BaseFragment<P extends BasePresenter,V extends BaseView> extends MvpFragment<P,V> {
    private View contentView;
    public View getContentView() {return contentView;}


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (contentView==null){
            contentView=inflater.inflate(bindLayoutId(),container,false);
            ButterKnife.bind(this,contentView);
            initEventAndData(contentView);
        }
        //判断在onCreateView返回contentView之前，是否有被嵌套在一个ViewGroup中
        //防止报错
        ViewGroup parent = (ViewGroup) contentView.getParent();
        if (parent!=null){
            parent.removeView(contentView);
        }
        return contentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //事件和数据处理
    protected abstract void initEventAndData(View contentView);

    //当前fragment的布局ID
    protected abstract int bindLayoutId();
}
