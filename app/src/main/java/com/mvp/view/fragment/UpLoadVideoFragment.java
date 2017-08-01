package com.mvp.view.fragment;

import android.content.Context;

import com.mvp.R;
import com.mvp.base.BaseFragment;
import com.mvp.presenter.UpLoadPresenter;
import com.mvp.view.iview.UpLoadView;

/**
 * 作者：李飞 on 2017/8/1 11:43
 * 类的用途：
 */

public class UpLoadVideoFragment extends BaseFragment<UpLoadPresenter> implements UpLoadView{
    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void onSucceed(Object object) {

    }

    @Override
    public void onFail(String str) {

    }

    @Override
    protected void createPresenter() {
            mPresenter = new UpLoadPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_upvideo;
    }

    @Override
    protected void initData() {

    }
}
