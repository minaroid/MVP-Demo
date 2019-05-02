package com.mina.mvpdemo.base;

import android.arch.lifecycle.Lifecycle;

public interface BaseView {

    Lifecycle getLifecycle();

    void showMessage(String message);
}
