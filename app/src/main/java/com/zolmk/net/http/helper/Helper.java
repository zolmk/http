package com.zolmk.net.http.helper;

import com.zolmk.net.http.manager.FileManager;
import com.zolmk.net.http.manager.JsonManager;

import java.io.File;

import io.reactivex.disposables.Disposable;

/**
 * 主要提供一个简洁的接口，具体的实现都在HttpHelper中
 */
public class Helper {
    public static void init(){
        FileManager.getInstance().init();
        JsonManager.getInstance().init();
    }

    /**
     * Login check
     * @param userId 用户标识
     * @param passwd 用户密码
     * @param listener 回调
     */
    public static Disposable checkUser(String userId,String passwd,BasicListener listener){
        return HttpHelper.newInstance().with(listener).checkLogin(userId,passwd);
    }

    /**
     * 下载图片
     * @param imgName 图片名称
     * @param listener 回调
     * @return Disposable 对象
     */
    public static Disposable downloadImg(String imgName,String dirPath,BasicListener listener){
        return HttpHelper.newInstance().with(listener).getImg(imgName, dirPath);
    }

    /**
     * 上传图片
     * @param files 图片文件句柄
     * @param listener 回调
     * @return Disposable对象
     */
    public static Disposable uploadImg(File[] files,BasicListener listener){
        return HttpHelper.newInstance().with(listener).uploadFiles(files, HttpHelper.FileType.IMAGE);
    }

    /**
     * 上传text文件 例如.txt .js .html等
     * @param files 文件句柄
     * @param listener 回调
     * @return  Disposable
     */
    public static Disposable uploadText(File[] files,BasicListener listener){
        return HttpHelper.newInstance().with(listener).uploadFiles(files,HttpHelper.FileType.TEXT);
    }

    /**
     * 上传视频
     * @param files 视频文件句柄
     * @param listener 回调
     * @return  Disposable
     */

    public static Disposable uploadVideo(File[] files,BasicListener listener){
        return HttpHelper.newInstance().with(listener).uploadFiles(files,HttpHelper.FileType.VIDEO);
    }

    /**
     * 上传视频
     * @param files 音频文件句柄
     * @param listener 回调
     * @return  Disposable
     */
    public static Disposable uploadAudio(File[] files,BasicListener listener){
        return HttpHelper.newInstance().with(listener).uploadFiles(files,HttpHelper.FileType.AUDIO);
    }
}
