package com.mina.mvpdemo.base.fragment;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.mina.mvpdemo.base.activity.BaseActivityPresenter;
import com.mina.mvpdemo.base.BaseView;
import timber.log.Timber;

public abstract class BaseFragment<V extends BaseView, P extends BaseFragmentPresenter> extends Fragment
        implements BaseView {

    protected P presenter;
    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), container, false);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (presenter == null) {
            presenter = createPresenter();
            presenter.attachView(this);
        }
        lifecycleRegistry.markState(Lifecycle.State.CREATED);
        Timber.tag("Mina-George").d("Lifecycle fragment: CREATED");
        onCreateActivityComponent();
    }

    protected abstract P createPresenter();

    @LayoutRes
    public abstract int getLayout();

    protected abstract void onCreateActivityComponent();

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }

    @Override
    public void onDestroyView() {
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED);
        Timber.tag("Mina-George").d("Lifecycle fragment: DESTROYED");
        super.onDestroyView();
    }
}
