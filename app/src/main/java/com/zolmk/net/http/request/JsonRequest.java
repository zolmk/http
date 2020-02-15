package com.zolmk.net.http.request;

import com.zolmk.net.http.beans.BasicBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 从服务器获取JSON数据的Request
 */
public interface JsonRequest {
    // JSON请求的服务器地址
    String HOST = "http://39.96.40.243/";
    @FormUrlEncoded
    @POST("login.php")
    Observable<BasicBean> login(@FieldMap Map<String,String> map); // 登录
}
