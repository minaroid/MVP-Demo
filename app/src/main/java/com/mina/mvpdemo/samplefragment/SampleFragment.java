package com.mina.mvpdemo.samplefragment;

import com.mina.mvpdemo.R;
import com.mina.mvpdemo.base.fragment.BaseFragment;

public class SampleFragment extends BaseFragment<SampleFragmentView,SampleFragmentPresenter> implements SampleFragmentView{

    @Override
    protected SampleFragmentPresenter createPresenter() {
        return new SampleFragmentPresenterImpl();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_sample;
    }

    @Override
    protected void onCreateActivityComponent() {

    }
}
