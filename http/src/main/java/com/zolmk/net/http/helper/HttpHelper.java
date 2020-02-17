package com.zolmk.net.http.helper;

import com.zolmk.net.http.manager.FileManager;
import com.zolmk.net.http.manager.JsonManager;
import com.zolmk.net.http.protocol.BasicTAG;
import com.zolmk.net.http.protocol.FileType;
import com.zolmk.net.http.utils.FileUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class HttpHelper {
    protected static HttpHelper newInstance(){
        return new HttpHelper();
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
     * 从服务器获取文件
     * @param fileName  服务器上的文件名
     * @param tag 文件所属标签：决定从服务器哪个文件夹中获取文件
     * @param toPath 保存文件到本地的路径
     * @param toRename 保存文件的文件名
     * @return
     */
    protected Disposable downloadFile(String fileName, BasicTAG tag, String toPath, String toRename){
        return FileManager.getRequest().downloadFileByFileName(tag.getValue(),fileName)
                .subscribeOn(Schedulers.io())
                .map(responseBody -> responseBody.byteStream())
                .map(inputStream -> FileUtil.saveFile(inputStream,toPath,toRename))
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
     * @param toRename  重命名列表
     * @param type 文件类型
     * @param tag  文件标签：决定文件上传到服务器哪个文件夹
     * @return
     */
    protected Disposable uploadFiles(File[] files, String[] toRename, FileType type, BasicTAG tag){
        Map<String, RequestBody> map = new HashMap<>();
        for(int i=0;i<files.length;i++){
            RequestBody requestBody = RequestBody.create(MediaType.parse(type.getType()),files[i]);
            map.put("file\";filename=\""+tag.getValue()+"_"+toRename[i],requestBody);
        }
        return FileManager.getRequest().uploadFiles(type.getPostPath(),map)
                .subscribeOn(Schedulers.io())
                .map(basicBean -> basicBean.getData())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {if(listener!=null) listener.success(s);}
                ,throwable -> {if(listener!=null) listener.error(throwable.getMessage());});
    }

}
