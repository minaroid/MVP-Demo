package com.mina.mvpdemo.base.activity;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.mina.mvpdemo.base.BaseView;
import timber.log.Timber;

public abstract class BaseActivity<V extends BaseView, P extends BaseActivityPresenter>
        extends AppCompatActivity implements BaseView, LifecycleOwner {

    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    protected P presenter;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        if (presenter == null) {
            presenter = createPresenter();
            presenter.attachView(this);
        }

        lifecycleRegistry.markState(Lifecycle.State.CREATED);
        Timber.tag("Mina-George").d("Lifecycle activity: CREATED");
        onCreateActivityComponent();
    }


    @Override
    public void onStart() {
        super.onStart();
        lifecycleRegistry.markState(Lifecycle.State.STARTED);
        Timber.tag("Mina-George").d("Lifecycle activity: STARTED");
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifecycleRegistry.markState(Lifecycle.State.RESUMED);
        Timber.tag("Mina-George").d("Lifecycle activity: RESUMED");
    }

    @Override
    protected void onDestroy() {
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED);
        Timber.tag("Mina-George").d("Lifecycle activity: DESTROYED");
        super.onDestroy();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }

    protected abstract P createPresenter();

    protected abstract void onCreateActivityComponent();

    @LayoutRes
    protected abstract int getLayout();
}
