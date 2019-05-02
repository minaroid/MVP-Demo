package com.mina.mvpdemo.base.fragment;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.mina.mvpdemo.base.BaseView;
import timber.log.Timber;

import java.lang.ref.SoftReference;

public class BaseFragmentPresenterImpl<V extends BaseView> implements BaseFragmentPresenter<V>, LifecycleObserver {

    private SoftReference<V> viewReference;

    @Override
    public void attachView(V view) {
        viewReference = new SoftReference<>(view);
        onViewAttached();
    }

    public V getView() {
        return viewReference == null ? null : viewReference.get();
    }


    @Override
    public void detachView() {
        if (viewReference != null) {
            viewReference.clear();
            viewReference = null;
        }
    }

    public void onViewAttached() {
        viewReference.get().getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onViewCreated() {
        Timber.tag("Mina-George").d("Lifecycle presenter: onViewCreated");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onDestroyView() {
        Timber.tag("Mina-George").d("Lifecycle presenter: onDestroyView");
        if (viewReference != null) {
            viewReference.clear();
            viewReference = null;
        }
    }
}
