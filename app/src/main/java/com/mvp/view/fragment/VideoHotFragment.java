package com.mvp.view.fragment;

import android.content.Context;

import com.mvp.R;
import com.mvp.base.BaseFragment;
import com.mvp.presenter.VideoHotPresenter;
import com.mvp.view.iview.VideoHotView;

/**
 * 作者：李飞 on 2017/7/21 11:44
 * 类的用途：
 */

public class VideoHotFragment extends BaseFragment<VideoHotPresenter> implements VideoHotView {
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
            mPresenter = new VideoHotPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_hot;
    }

    @Override
    protected void initData() {

    }
}
