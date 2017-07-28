package com.mvp.view.fragment;

import android.content.Context;

import com.mvp.R;
import com.mvp.base.BaseFragment;
import com.mvp.presenter.FollowPresenter;
import com.mvp.view.iview.FollowView;

/**
 * 作者：李飞 on 2017/7/21 11:53
 * 类的用途：
 */

public class FollowFragment extends BaseFragment<FollowPresenter> implements FollowView {
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
            mPresenter = new FollowPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_follow;
    }

    @Override
    protected void initData() {

    }
}
