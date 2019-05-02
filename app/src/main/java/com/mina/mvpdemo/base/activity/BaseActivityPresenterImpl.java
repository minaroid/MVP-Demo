package com.mina.mvpdemo.base.activity;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.mina.mvpdemo.base.BaseView;
import timber.log.Timber;

import java.lang.ref.SoftReference;


public class BaseActivityPresenterImpl<V extends BaseView> implements BaseActivityPresenter<V>, LifecycleObserver {

    private SoftReference<V> viewReference;

    @Override
    public void attachView(V view) {
        viewReference = new SoftReference<>(view);
        onViewAttached();
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

    public V getView() {
        return viewReference == null ? null : viewReference.get();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected void onActivityCreate() {
        Timber.tag("Mina-George").d("Lifecycle presenter: ON_CREATE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onActivityStart() {
        Timber.tag("Mina-George").d("Lifecycle presenter: ON_START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected void onActivityResume() {
        Timber.tag("Mina-George").d("Lifecycle presenter: ON_RESUME");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected void onActivityPause() {
        Timber.tag("Mina-George").d("Lifecycle presenter: ON_PAUSE");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onActivityStop() {
        Timber.tag("Mina-George").d("Lifecycle presenter: ON_STOP");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected void onActivityDestroy() {
        Timber.tag("Mina-George").d("Lifecycle presenter: ON_DESTROY");
        if (viewReference != null) {
            viewReference.clear();
            viewReference = null;
        }
    }


}
