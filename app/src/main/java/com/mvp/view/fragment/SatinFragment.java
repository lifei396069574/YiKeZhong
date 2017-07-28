package com.mvp.view.fragment;

import android.content.Context;

import com.mvp.R;
import com.mvp.base.BaseFragment;
import com.mvp.presenter.SatinPresenter;
import com.mvp.view.iview.SatinView;

/**
 * 作者：李飞 on 2017/7/21 09:10
 * 类的用途：
 */

public class SatinFragment extends BaseFragment<SatinPresenter> implements SatinView{
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
            mPresenter=new SatinPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_satin;
    }

    @Override
    protected void initData() {

    }
}
