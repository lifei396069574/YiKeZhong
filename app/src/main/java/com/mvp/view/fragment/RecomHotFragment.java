package com.mvp.view.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mvp.R;
import com.mvp.base.BaseFragment;
import com.mvp.presenter.RecomHotPresenter;
import com.mvp.view.iview.RecomHotView;

import butterknife.BindView;

/**
 * 作者：李飞 on 2017/7/21 11:44
 * 类的用途：
 */

public class RecomHotFragment extends BaseFragment<RecomHotPresenter> implements RecomHotView {
    @BindView(R.id.rlc)
    RecyclerView mRlc;


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
        mPresenter = new RecomHotPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recom_hot;
    }

    @Override
    protected void initData() {

        mRlc.setLayoutManager(new LinearLayoutManager(mContext));

    }

}
