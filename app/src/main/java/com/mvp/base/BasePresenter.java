package com.mvp.base;

import android.content.Context;
import android.text.TextUtils;

import com.mvp.app.MyApplication;

import java.util.Map;

/**
 * 作者：李飞 on 2017/6/21 20:21
 * 类的用途：
 */

public class BasePresenter<T extends BaseView> {

    protected T mView;

    public T getView() {
        return mView;
    }

    public void attachView(T t) {
        this.mView = t;
    }

    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }

    public Context context(){
        if (mView!=null){
            return mView.context();
        }
       return MyApplication.getInstance();
    }

    public void isEmpty(Map<String ,String> map){
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getValue())){
                mView.onFail(entry.getKey()+"为空");
                return;
            }
        }
    }

}
