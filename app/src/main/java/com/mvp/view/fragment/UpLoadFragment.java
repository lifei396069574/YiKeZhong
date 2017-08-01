package com.mvp.view.fragment;

import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mvp.R;
import com.mvp.base.BaseOrdinaryFragment;
import com.mvp.model.event.UpLoadEvent;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：李飞 on 2017/8/1 11:38
 * 类的用途：
 */

public class UpLoadFragment extends BaseOrdinaryFragment {

    @BindView(R.id.circleimageview1)
    SimpleDraweeView mCircleimageview1;
    @BindView(R.id.circleimageview2)
    SimpleDraweeView mCircleimageview2;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_up;
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.circleimageview1, R.id.circleimageview2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.circleimageview1:
                sendEvent(new UpLoadEvent(1));
                break;
            case R.id.circleimageview2:
                sendEvent(new UpLoadEvent(2));
                break;
        }
    }


}
