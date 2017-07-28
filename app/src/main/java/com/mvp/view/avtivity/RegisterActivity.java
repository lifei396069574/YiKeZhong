package com.mvp.view.avtivity;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.mvp.R;
import com.mvp.base.BaseActivity;
import com.mvp.model.utils.ToastUtils;
import com.mvp.presenter.RegisterPresenter;
import com.mvp.view.iview.RegisterView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：李飞 on 2017/7/24 14:12
 * 类的用途：
 */

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterView {
    @BindView(R.id.iv_Left)
    ImageView mIvLeft;
    @BindView(R.id.userHead)
    EditText mUserHead;
    @BindView(R.id.userName)
    EditText mUserName;
    @BindView(R.id.userPassword)
    EditText mUserPassword;
    @BindView(R.id.userPhone)
    EditText mUserPhone;
    @BindView(R.id.userSex)
    EditText mUserSex;
    @BindView(R.id.bt_regiest)
    Button mBtnRegiest;
    private ArrayMap<String, String> mMap;

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onSucceed(Object object) {
        ToastUtils.showToast(this,(String)object);
        finish();
    }

    @Override
    public void onFail(String str) {
        ToastUtils.showToast(this,str);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_regiest;
    }

    @Override
    protected void createPresenter() {
        mPresenter = new RegisterPresenter();
    }

    @Override
    protected void initDatas() {

    }


    @OnClick({R.id.iv_Left, R.id.bt_regiest})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_Left:
                finish();
                break;
            case R.id.bt_regiest:
                getEtData();
                break;
        }
    }

    public void getEtData(){

        mMap = new ArrayMap<>();
        mMap.put("userHead",mUserHead.getText().toString());
        mMap.put("userName",mUserName.getText().toString());
        mMap.put("userPassword",mUserPassword.getText().toString());
        mMap.put("userPhone",mUserPhone.getText().toString());
        mMap.put("userSex",mUserSex.getText().toString());

        mPresenter.register(mMap);
    }
}
