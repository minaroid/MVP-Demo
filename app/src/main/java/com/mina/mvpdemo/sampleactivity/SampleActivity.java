package com.mina.mvpdemo.sampleactivity;

import com.mina.mvpdemo.R;
import com.mina.mvpdemo.base.activity.BaseActivity;
import com.mina.mvpdemo.samplefragment.SampleFragment;

public class SampleActivity extends BaseActivity<SampleActivityView, SampleActivityPresenter>
        implements SampleActivityView {

    @Override
    protected SampleActivityPresenter createPresenter() {
        return new SampleActivityPresenterImpl();
    }

    @Override
    protected void onCreateActivityComponent() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new SampleFragment(), SampleFragment.class.getSimpleName())
                .addToBackStack(SampleFragment.class.getSimpleName())
                .commit();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_sample;
    }
}
