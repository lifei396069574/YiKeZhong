package com.mvp.model.http;

import android.util.ArrayMap;

import com.mvp.base.BaseBean;
import com.mvp.model.bean.LoginBean;
import com.mvp.model.bean.RegisterBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

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

    @Multipart
    @POST()
    Observable<ResponseBody> uploadFiles(
            @Url String url,
            @PartMap() Map<String, RequestBody> maps);

    @Multipart
    @POST
    Observable<ResponseBody> uploadFileWithPartMap(
            @Url() String url,
            @PartMap() Map<String, RequestBody> partMap,
            @Part  MultipartBody.Part file);


    @FormUrlEncoded
    @POST("picture/picchaUpload")
    Observable<LoginBean> upLoad(@Body RequestBody Body);
}
