package com.mvp.view.fragment;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.widget.FrameLayout;

import com.king.base.util.ToastUtils;
import com.mvp.R;
import com.mvp.base.BaseFragment;
import com.mvp.presenter.RecommendPresenter;
import com.mvp.view.iview.RecommendView;

import butterknife.BindView;

/**
 * 作者：李飞 on 2017/7/21 09:09
 * 类的用途：
 */

public class RecommendFragment extends BaseFragment<RecommendPresenter> implements RecommendView {
    @BindView(R.id.tab)
    android.support.design.widget.TabLayout mTabLayout;
    @BindView(R.id.framelayout_recom)
    FrameLayout mFramelayoutRecom;

    private RecomHotFragment mHotFragment;
    private FollowFragment mFollowFragment;


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
        mPresenter = new RecommendPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initData() {
        mTabLayout.addTab(mTabLayout.newTab().setText("热门"));

        mTabLayout.addTab(mTabLayout.newTab().setText("关注"));

        showFragment(new RecomHotFragment(),R.id.framelayout_recom);

        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //
                if ("热门".equals(tab.getText())){
                  ToastUtils.showToast(mContext , tab.getText());
                    if (mHotFragment == null){
                        mHotFragment = new RecomHotFragment();
                    }
                   showFragment(mHotFragment,R.id.framelayout_recom);
                }else {
                    ToastUtils.showToast(mContext , tab.getText());
                    if (mFollowFragment == null){
                        mFollowFragment = new FollowFragment();
                    }
                    showFragment(mFollowFragment,R.id.framelayout_recom);
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
