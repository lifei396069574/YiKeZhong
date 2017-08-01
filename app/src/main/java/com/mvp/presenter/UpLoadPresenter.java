package com.mvp.presenter;

import com.mvp.base.BasePresenter;
import com.mvp.view.iview.UpLoadView;

/**
 * 作者：李飞 on 2017/8/1 10:39
 * 类的用途：
 */

public class UpLoadPresenter extends BasePresenter<UpLoadView> {

    public void upLoadIv(String iconToString){

//        //构建body
//        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
//                .addFormDataPart("dictionaryValue", 2)
//                .addFormDataPart("description", psd)
//                .addFormDataPart("userId", psd)
//                .addFormDataPart("content", file.getName(), RequestBody.create(MediaType.parse("image/*"), file))
//                .build();
//
//       //  执行请求  upLoad(description, body)
//        Api.loadDataFromNet(Api.getServer().upLoad(requestBody), new HttpObserver<LoginBean>() {
//            @Override
//            public void onSuccess(LoginBean loginBean) {
//                if (loginBean.getCode().equals(200)){
//                    mView.onSucceed("上传成功");
//                }else {
//                    mView.onFail("上传失败");
//                }
//            }
//            @Override
//            public void onFiled(String t) {
//                mView.onFail(t);
//            }
//        });

        //修改


    }
}
