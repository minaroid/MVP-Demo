package com.mina.mvpdemo.sampleactivity;

import com.mina.mvpdemo.base.activity.BaseActivityPresenterImpl;

public class SampleActivityPresenterImpl extends BaseActivityPresenterImpl<SampleActivityView>
        implements SampleActivityPresenter {

    @Override
    protected void onActivityCreate() {
        super.onActivityCreate();
        getView().showMessage("SampleActivity onCreate");
    }


    @Override
    protected void onActivityResume() {
        super.onActivityResume();
        getView().showMessage("SampleActivity onResume");
    }

    @Override
    protected void onActivityStart() {
        super.onActivityStart();
        getView().showMessage("SampleActivity onStart");
    }

    @Override
    protected void onActivityDestroy() {
        getView().showMessage("SampleActivity onDestroy");
        super.onActivityDestroy();
    }
}
