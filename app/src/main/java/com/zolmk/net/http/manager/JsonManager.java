package com.zolmk.net.http.manager;
import com.zolmk.net.http.request.JsonRequest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonManager extends BasicRxJavaManager{
    /**
     *单例模式
     */
    private static class Inner{
        private final static JsonManager manager = new JsonManager();
    }
    public static JsonManager getInstance() {
        return Inner.manager;
    }

    private static volatile JsonRequest request = null;

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
        return builder.baseUrl(JsonRequest.HOST)
                .addConverterFactory(GsonConverterFactory.create());
    }
    /**
     * 获取JsonRequest
     * @return JsonRequest
     */
    public static JsonRequest getRequest(){
        if(request == null){
            synchronized (JsonRequest.class){
                request = retrofit.create(JsonRequest.class);
            }
        }
        return request;
    }
}
