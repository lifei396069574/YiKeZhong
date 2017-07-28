package com.mvp.model.http;

import android.util.ArrayMap;

import com.mvp.base.BaseBean;
import com.mvp.model.bean.LoginBean;
import com.mvp.model.bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * 作者：李飞 on 2017/6/21 21:36
 * 类的用途：
 */

public interface ApiService {

    @GET()
    Observable<BaseBean<String>> getData(@QueryMap ArrayMap<String, String> map);

    @FormUrlEncoded
    @POST("user/addLogin")
    Observable<LoginBean>  postLogin(@FieldMap ArrayMap<String, String> map);


    @FormUrlEncoded
    @POST("user/addUser")
    Observable<RegisterBean>  postResiest(@FieldMap ArrayMap<String, String> map);

}
