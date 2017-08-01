package com.mvp.view.avtivity;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.mvp.R;
import com.mvp.base.BaseActivity;
import com.mvp.model.utils.LogUtils;
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
    @BindView(R.id.tvTitle)
    TextView mTvTitle;
    @BindView(R.id.userName)
    EditText mUserName;
    @BindView(R.id.userPassword)
    EditText mUserPassword;
    @BindView(R.id.userPhone)
    EditText mUserPhone;
    @BindView(R.id.bt_regiest)
    Button mBtRegiest;
    @BindView(R.id.rb_reg_m)
    RadioButton mRbRegM;
    @BindView(R.id.rb_reg_w)
    RadioButton mRbRegW;
    private ArrayMap<String, String> mMap;

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onSucceed(Object object) {
        LogUtils.a(object);
        ToastUtils.showToast(this, (String) object);
        finish();
    }

    @Override
    public void onFail(String str) {
        ToastUtils.showToast(this, str);
        LogUtils.a(str);
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

    public void getEtData() {

        mMap = new ArrayMap<>();
        mMap.put("userName", mUserName.getText().toString().trim());
        mMap.put("userPassword", mUserPassword.getText().toString().trim());
        mMap.put("userPhone", mUserPhone.getText().toString().trim());
        if (mRbRegM.isChecked()){
            mMap.put("userSex", "男");
        }else {
            mMap.put("userSex", "女");
        }

        mPresenter.register(mMap);
    }



}
