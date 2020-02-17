package com.zolmk.net.http.manager;


import com.zolmk.net.http.request.FileRequest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class FileManager extends BasicRxJavaManager {
    /**
     *单例模式
     */
    private static class Inner{
        private final static FileManager manager = new FileManager();
    }
    public static FileManager getInstance() {
        return Inner.manager;
    }

    /**
     * 初始化OkHttpBuilder
     * @param builder
     * @return builder
     */
    @Override
    OkHttpClient.Builder initOkHttpBuilder(OkHttpClient.Builder builder) {
        return builder;
    }

    /**
     * 初始化RetrofitBuilder
     * @param builder
     * @return builder
     */
    @Override
    Retrofit.Builder initRetrofitBuilder(Retrofit.Builder builder) {
        return builder.baseUrl(FileRequest.HOST);
    }

    /**
     * 获取FileRequest
     * @return FileRequest
     */
    public static FileRequest getRequest(){
        if(request == null){
            synchronized (FileRequest.class){
                request = retrofit.create(FileRequest.class);
            }
        }
        return request;
    }
}
