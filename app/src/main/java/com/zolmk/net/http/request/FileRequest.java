package com.zolmk.net.http.request;

import com.zolmk.net.http.beans.BasicBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

public interface FileRequest {
    // 文件请求的服务器地址
    String HOST = "http://39.96.40.243/";
    String IMG_DIR = "imgs";

    /**
     * 服务器文件目录
     */
    enum SERVER_DIR{
        IMG("imgs"),FILE("files");
        private String value;
        SERVER_DIR(String value1){
            this.value = value1;
        }
        public String getValue(){
            return value;
        }
    }

    /**
     * 下载文件的接口函数
     * @param dir   文件目录
     * @param fileName  文件名
     * @return Observable<ResponseBody>
     */
    @Streaming
    @GET("{dir}/{filename}")
    Observable<ResponseBody> downloadImgByFileName(@Path("dir") String dir,@Path("filename") String fileName);

    /**
     * 上传文件
     * @param params Map类型参数
     * @return  Observable<BasicBean>
     */
    @Multipart
    @POST("{url}")
    Observable<BasicBean> uploadFiles(@PartMap Map<String, RequestBody> params);


}
