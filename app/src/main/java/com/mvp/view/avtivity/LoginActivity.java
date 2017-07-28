package com.mvp.view.avtivity;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mvp.R;
import com.mvp.base.BaseActivity;
import com.mvp.model.utils.ToastUtils;
import com.mvp.presenter.LoginPresenter;
import com.mvp.view.iview.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者：李飞 on 2017/7/24 11:39
 * 类的用途：
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.ivLeft)
    ImageView mIvLeft;
    @BindView(R.id.tvTitle)
    TextView mTvTitle;
    @BindView(R.id.tvRight)
    TextView mTvRight;
    @BindView(R.id.etUsername)
    EditText mEtUsername;
    @BindView(R.id.etPassword)
    EditText mEtPassword;
    @BindView(R.id.btnLogin)
    Button mBtnLogin;
    @BindView(R.id.tvForgetPwd)
    TextView mTvForgetPwd;
    @BindView(R.id.ivQQ)
    ImageView mIvQQ;
    @BindView(R.id.ivSina)
    ImageView mIvSina;
    @BindView(R.id.ivWeixin)
    ImageView mIvWeixin;
    private ArrayMap<String, String> mMap;

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onSucceed(Object object) {

    }

    @Override
    public void onFail(String str) {
        ToastUtils.showToast(this,str);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void createPresenter() {
        mPresenter = new LoginPresenter();
    }

    @Override
    protected void initDatas() {

    }


    @OnClick({R.id.ivLeft, R.id.tvTitle, R.id.tvRight, R.id.btnLogin, R.id.tvForgetPwd, R.id.ivQQ, R.id.ivSina, R.id.ivWeixin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivLeft:
                finish();
                break;
            case R.id.tvTitle:
                break;
            case R.id.tvRight:
                //注册
               startActivity(RegisterActivity.class);
                break;
            case R.id.btnLogin:
                //登陆
                getEtData();
                break;
            case R.id.tvForgetPwd:
                break;
            case R.id.ivQQ:
                break;
            case R.id.ivSina:
                break;
            case R.id.ivWeixin:
                break;
        }
    }

    public void getEtData(){
        mMap = new ArrayMap<>();
        mMap.put("userPhone",mEtUsername.getText().toString());
        mMap.put("userPassword",mEtPassword.getText().toString());
        mPresenter.login(mMap);
    }
}
