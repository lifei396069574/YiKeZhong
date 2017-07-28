package com.mvp.presenter;

import android.util.ArrayMap;

import com.mvp.base.BasePresenter;
import com.mvp.model.bean.RegisterBean;
import com.mvp.model.http.Api;
import com.mvp.view.iview.RegisterView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：李飞 on 2017/7/24 14:13
 * 类的用途：
 */

public class RegisterPresenter extends BasePresenter<RegisterView> {

    public void register(ArrayMap<String ,String> map){

        //判空
        isEmpty(map);

        Api.getServer().postResiest(map)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Consumer<RegisterBean>() {
                   @Override
                   public void accept(RegisterBean bean) throws Exception {
                       if (bean.getCode()==200){
                           mView.onSucceed("成功");
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
