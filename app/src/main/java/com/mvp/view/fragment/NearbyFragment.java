package com.mvp.view.fragment;

import android.content.Context;

import com.mvp.R;
import com.mvp.base.BaseFragment;
import com.mvp.presenter.NearbyPresenter;
import com.mvp.view.iview.NearbyView;

/**
 * 作者：李飞 on 2017/7/24 09:44
 * 类的用途：
 */

public class NearbyFragment extends BaseFragment<NearbyPresenter> implements NearbyView{
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
            mPresenter = new NearbyPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nearby;
    }

    @Override
    protected void initData() {

    }
}
