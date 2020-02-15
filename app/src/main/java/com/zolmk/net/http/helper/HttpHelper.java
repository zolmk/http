package com.zolmk.net.http.helper;
import com.zolmk.net.http.manager.FileManager;
import com.zolmk.net.http.manager.JsonManager;
import com.zolmk.net.http.request.FileRequest;
import com.zolmk.net.http.utils.FileUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class HttpHelper {
    protected static HttpHelper newInstance(){
        return new HttpHelper();
    }
    protected enum FileType{
        IMAGE("image/*"),TEXT("text/*"),AUDIO("audio/*"),VIDEO("video/*"),APPLICATION("application/*"),
        EXTENSION_TOKEN("extension-token/*");
        private String value;
        FileType(String s){
            this.value = s;
        }
        public String getValue() {
            return value;
        }
    }

    /**
     * 数据操作完成后的回调
     */
    private BasicListener listener = null;

    /**
     * 增加数据获取成功后的回调接口
     * @param listener
     * @return
     */
    protected HttpHelper with(BasicListener listener){
        this.listener = listener;
        return this;
    }

    /**
     *下载图片，并通知UI
     */
    protected Disposable getImg(String imgName,String path){
        return FileManager.getRequest().downloadImgByFileName(FileRequest.SERVER_DIR.IMG.getValue(),imgName)
                .subscribeOn(Schedulers.io())
                .map(responseBody -> responseBody.byteStream())
                .map(inputStream -> FileUtil.saveFile(inputStream,path,imgName))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(file -> {if(listener!=null) listener.success(file);}
                    ,throwable -> {if(listener != null) listener.error(throwable.getMessage());});
    }

    /**
     * 核对用户身份
     * @param id 用户id
     * @param passwd 用户密码
     * @return  Disposable接口
     */
    protected Disposable checkLogin(String id,String passwd){
        Map<String,String> map = new HashMap<>();
        map.put("userId",id);
        map.put("password",passwd);
        return JsonManager.getRequest().login(map)
                .subscribeOn(Schedulers.io())
                .map(basicBean -> basicBean.getData())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {if(listener!=null) listener.success(s);}
                    ,throwable -> {if(listener != null) listener.error(throwable.getMessage());});
    }

    /**
     * 上传文件到服务器
     * @param files 文件列表
     * @param type  文件类型
     * @return Disposable接口
     */
    protected Disposable uploadFiles(File[] files,FileType type){
        Map<String, RequestBody> map = new HashMap<>();
        for(File file : files){
            RequestBody requestBody = RequestBody.create(MediaType.parse(type.getValue()),file);
            map.put(type.getValue().substring(0,type.getValue().length()-2),requestBody);
        }
        return FileManager.getRequest().uploadFiles(map)
                .subscribeOn(Schedulers.io())
                .map(basicBean -> basicBean.getData())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {if(listener!=null) listener.success(s);}
                ,throwable -> {if(listener!=null) listener.error(throwable.getMessage());});
    }

}
