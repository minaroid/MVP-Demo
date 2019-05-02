package com.mina.mvpdemo.samplefragment;

import com.mina.mvpdemo.base.fragment.BaseFragmentPresenterImpl;

public class SampleFragmentPresenterImpl extends BaseFragmentPresenterImpl<SampleFragmentView>
        implements SampleFragmentPresenter {

    @Override
    protected void onViewCreated() {
        getView().showMessage("SampleFragment created");
        super.onViewCreated();
    }

    @Override
    protected void onDestroyView() {
        getView().showMessage("SampleFragment onDestroy");
        super.onDestroyView();
    }
}
