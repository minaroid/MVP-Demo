package com.mina.mvpdemo.base.fragment;

import com.mina.mvpdemo.base.BaseView;

public interface BaseFragmentPresenter<V extends BaseView>  {

    void attachView(V view);
    void detachView();
}
