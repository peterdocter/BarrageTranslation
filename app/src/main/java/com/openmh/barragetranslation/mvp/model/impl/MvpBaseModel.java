package com.openmh.barragetranslation.mvp.model.impl;

import android.content.Context;

import com.openmh.barragetranslation.mvp.model.MvpModel;

/**
 * Created by zengmianhui on 2017/2/6.
 */

public class MvpBaseModel implements MvpModel {
    private Context context;
    public MvpBaseModel(Context context) {
        this.context = context;
    }
}
