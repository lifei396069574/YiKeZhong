package com.mvp.view.fragment;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.widget.FrameLayout;

import com.king.base.util.ToastUtils;
import com.mvp.R;
import com.mvp.base.BaseFragment;
import com.mvp.presenter.VideoPresenter;
import com.mvp.view.iview.VideoView;

import butterknife.BindView;

/**
 * 作者：李飞 on 2017/7/21 09:10
 * 类的用途：
 */

public class VideoFragment extends BaseFragment<VideoPresenter> implements VideoView {

    @BindView(R.id.tab_video)
    TabLayout mTabVideo;
    @BindView(R.id.framelayout_video)
    FrameLayout mFramelayoutVideo;

    private VideoHotFragment mVideoHotFragment;
    private NearbyFragment mNearbyFragment;

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
        mPresenter = new VideoPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initData() {


        mTabVideo.addTab(mTabVideo.newTab().setText("热门"));

        mTabVideo.addTab(mTabVideo.newTab().setText("附近"));

        showFragment(new VideoHotFragment(),R.id.framelayout_video);

        mTabVideo.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //
                if ("热门".equals(tab.getText())){
                    ToastUtils.showToast(mContext , tab.getText());
                    if (mVideoHotFragment == null){
                        mVideoHotFragment = new VideoHotFragment();
                    }
                    showFragment(mVideoHotFragment,R.id.framelayout_video);
                }else {
                    ToastUtils.showToast(mContext , tab.getText());
                    if (mNearbyFragment == null){
                        mNearbyFragment = new NearbyFragment();
                    }
                    showFragment(mNearbyFragment,R.id.framelayout_video);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }




}
