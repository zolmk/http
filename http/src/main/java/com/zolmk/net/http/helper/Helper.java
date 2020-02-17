package com.zolmk.net.http.helper;

import com.zolmk.net.http.manager.FileManager;
import com.zolmk.net.http.manager.JsonManager;
import com.zolmk.net.http.protocol.FileType;
import com.zolmk.net.http.protocol.ImageTAG;
import com.zolmk.net.http.protocol.Protocol;

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
     * 下载用户头像
     * @param fileName 用户头像名
     * @param toRename 重命名
     * @param listener 回调
     * @return
     */
    public static Disposable downloadHeadImg(String fileName,String toRename,BasicListener listener){
        return HttpHelper.newInstance()
                .with(listener)
                .downloadFile(fileName,
                        ImageTAG.HEAD,
                        Protocol.IMG_AND_VIDEO_SAVE_PATH,
                        toRename);
    }

    /**
     * 下载用户动态中的图片
     * @param fileName 文件名
     * @param toRename 重命名
     * @param listener 回调
     * @return
     */
    public static Disposable downloadDynamicImg(String fileName,String toRename,BasicListener listener){
        return HttpHelper.newInstance()
                .with(listener)
                .downloadFile(fileName,
                        ImageTAG.DYNAMIC,
                        Protocol.IMG_AND_VIDEO_SAVE_PATH,
                        toRename);
    }

    /**
     * 下载用户相册中的图片
     * @param fileName 文件名
     * @param toRename 重命名
     * @param listener 回调
     * @return
     */
    public static Disposable downloadAlbumImg(String fileName,String toRename,BasicListener listener){
        return HttpHelper.newInstance()
                .with(listener)
                .downloadFile(fileName,
                        ImageTAG.ALBUM,
                        Protocol.IMG_AND_VIDEO_SAVE_PATH,
                        toRename);
    }
    /**
     * 上传用户头像
     * @param fileName 文件名
     * @param toRename 重命名
     * @param listener 回调
     * @return
     */
    public static Disposable uploadHeadImg(String fileName,String toRename,BasicListener listener){
        return  HttpHelper.newInstance()
                .with(listener)
                .uploadFiles(
                    new File[]{new File(fileName)},
                    new String[]{toRename},
                    FileType.IMAGE,
                    ImageTAG.HEAD);
    }
    /**
     * 上传用户动态中的图片
     * @param files 图片文件
     * @param listener 回调
     * @return Disposable对象
     */
    public static Disposable uploadDynamic(File[] files,String[] toRename,BasicListener listener){
        return HttpHelper.newInstance()
                .with(listener)
                .uploadFiles(files,
                        toRename,
                        FileType.IMAGE,
                        ImageTAG.DYNAMIC);
    }

    /**
     * 上传到用户相册
     * @param files 图片文件
     * @param toRename 重命名
     * @param listener 回调
     * @return
     */
    public static Disposable uploadAlbumImg(File[] files,String[] toRename,BasicListener listener){
        return HttpHelper.newInstance()
                .with(listener)
                .uploadFiles(files,
                        toRename,
                        FileType.IMAGE,
                        ImageTAG.ALBUM);
    }

}
