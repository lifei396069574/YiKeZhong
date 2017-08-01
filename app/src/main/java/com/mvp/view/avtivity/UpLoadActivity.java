package com.mvp.view.avtivity;

import android.view.KeyEvent;

import com.mvp.R;
import com.mvp.base.BaseOrdinaryActivity;
import com.mvp.model.event.UpLoadEvent;
import com.mvp.view.fragment.UpLoadFragment;
import com.mvp.view.fragment.UpLoadTextFragment;
import com.mvp.view.fragment.UpLoadVideoFragment;

import org.greenrobot.eventbus.EventBus;

/**
 * 作者：李飞 on 2017/8/1 10:38
 * 类的用途：
 */

public class UpLoadActivity extends BaseOrdinaryActivity {


    private UpLoadFragment mUpLoadFragment;
    private UpLoadVideoFragment mUpLoadVideoFragment;
    private UpLoadTextFragment mUpLoadTextFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_upload;
    }

    @Override
    protected void initDatas() {

        EventBus.getDefault().register(this);
        mUpLoadFragment = new UpLoadFragment();

        showFragment(mUpLoadFragment, R.id.up_framelayout);

    }

    @Override
    public void onEventMainThread(Object obj) {
        super.onEventMainThread(obj);
        UpLoadEvent obj1 = (UpLoadEvent) obj;
        switch (obj1.getCode()){
            case 1:
                if (mUpLoadVideoFragment==null){
                    mUpLoadVideoFragment = new UpLoadVideoFragment();
                }
                showFragment(mUpLoadVideoFragment,R.id.up_framelayout);
                break;
            case 2:
                if (mUpLoadTextFragment==null) {
                    mUpLoadTextFragment = new UpLoadTextFragment();
                }
                showFragment(mUpLoadTextFragment,R.id.up_framelayout);
                break;
            case 3:
                showFragment(mUpLoadFragment,R.id.up_framelayout);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                if (mFragment==mUpLoadFragment){
                    return super.onKeyDown(keyCode, event);
                }else {
                    showFragment(mUpLoadFragment, R.id.up_framelayout);
                    return true;
                }
        }
        return super.onKeyDown(keyCode, event);
    }
}
