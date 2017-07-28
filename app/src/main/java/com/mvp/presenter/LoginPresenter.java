package com.mvp.presenter;

import android.util.ArrayMap;

import com.mvp.base.BasePresenter;
import com.mvp.model.bean.LoginBean;
import com.mvp.model.http.Api;
import com.mvp.view.iview.LoginView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：李飞 on 2017/7/24 11:41
 * 类的用途：
 */

public class LoginPresenter extends BasePresenter<LoginView>{

    public void login(ArrayMap<String,String> map){

        //判空
        isEmpty(map);


        Api.getServer().postLogin(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                            if (loginBean.getError_code().equals(200)){
                                    mView.onSucceed(loginBean.getUser());
                            }else {
                                mView.onFail("失败");
                            }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                               mView.onFail(throwable.toString());
                    }
                });
    }
}
