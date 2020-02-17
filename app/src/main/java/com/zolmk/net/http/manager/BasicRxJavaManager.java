package com.zolmk.net.http.manager;

import com.zolmk.net.http.request.FileRequest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * 基本RxJava管理类
 * 用来简化代码
 * 既然是RxJvaManager那么Adapter就已经这这里添加了
 */
public abstract class BasicRxJavaManager{

    protected static Retrofit retrofit;
    protected static volatile FileRequest request = null;
    protected OkHttpClient.Builder okHttpBuilder = null;
    protected Retrofit.Builder retrofitBuilder = null;
    public void init(){
        okHttpBuilder = new OkHttpClient.Builder();     // 新建OkHttp Builder
        okHttpBuilder = initOkHttpBuilder(okHttpBuilder);   // 调用子类接口初始化OkHttp Builder
        retrofitBuilder = new Retrofit.Builder();   // 新建Retrofit Builder
        retrofitBuilder = initRetrofitBuilder(retrofitBuilder);     // 调用子类接口初始化Retrofit Builder
        retrofitBuilder.client(okHttpBuilder.build())   // 添加client
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()); //添加RxJava Adapter
        retrofit = retrofitBuilder.build();
    }
    abstract OkHttpClient.Builder initOkHttpBuilder(OkHttpClient.Builder builder);
    abstract Retrofit.Builder initRetrofitBuilder(Retrofit.Builder builder);
}
