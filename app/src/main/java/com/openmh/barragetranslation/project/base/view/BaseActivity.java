package com.openmh.barragetranslation.project.base.view;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.openmh.barragetranslation.mvp.view.impl.MvpActivity;
import com.openmh.barragetranslation.project.app.App;
import com.openmh.barragetranslation.project.base.presenter.BasePresenter;

import butterknife.ButterKnife;

/**
 * Activity基类
 * Created by zengmianhui on 2017/2/6.
 */

public abstract class BaseActivity<P extends BasePresenter,V extends BaseView> extends MvpActivity<P,V> {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        ButterKnife.bind(this);
        App.getInstance().addActivity(this);//统一管理Activity
        initEventAndData();
    }



    @Override
    public void onDestroy() {
        App.getInstance().removeActivity(this);
        super.onDestroy();
    }
    /**
     * 设置当前返回键
     */
    protected void setReturnButton() {
        ActionBar actionBar =  getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }
    //事件和数据处理
    protected abstract void initEventAndData();

    //绑定布局
    protected abstract int bindLayoutId();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onPause() {
        super.onPause();
    }


    /**
     * 用于给训练模块的适配器返回当前viewpager的position
     * @return
     */
    public int getCurrentPagerPosition() {
        return -1;
    }
}
