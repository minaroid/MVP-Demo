package com.mina.mvpdemo.base.activity;

import com.mina.mvpdemo.base.BaseView;

public interface BaseActivityPresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();

}
