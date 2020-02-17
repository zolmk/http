package com.zolmk.net.http.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
    protected static Context baseContext;
    public static String APP_INTRO_BASE_DIR;
    public static final String IMG_DIR = "/img/";
    public static String PHONE_DCIM;

    /**
     * 在Application中初始化
     * @param context App上下文
     */
    public static void init(Context context){
        baseContext = context;
        APP_INTRO_BASE_DIR = context.getCacheDir().getAbsolutePath();
        PHONE_DCIM = getPhoneDCIM();
    }

    private static String getPhoneDCIM(){
        String path;
        if (Build.BRAND.equals("xiaomi")) { // 小米手机
            path = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/";
        }else if (Build.BRAND.equals("Huawei")){
            path = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/";
        } else {  // Meizu 、Oppo
            path = Environment.getExternalStorageDirectory().getPath() + "/DCIM/";
        }
        return path;
    }

    /**
     * 储存文件到指定路径
     * @param inputStream 输入流
     * @param path 路径
     * @param fileName 文件名
     * @return 文件操作符
     * @throws IOException e
     */
    public static File saveFile(InputStream inputStream, String path, String fileName) throws IOException {
        Log.d("info","saveFile start");
        // 如果inputStream为空，则抛出异常
        if(inputStream == null)
            throw new IOException();

        byte[] buf = new byte[2048];
        int len;
        FileOutputStream fos = null;
        try{
            File dir = new File(path);
            if(!dir.exists()){
                dir.mkdir();
            }
            File file = new File(dir,fileName);
            if(file.exists()){
                file.delete();
            }
            fos = new FileOutputStream(file);
            while((len = inputStream.read(buf))!= -1){
                fos.write(buf,0,len);
            }
            fos.flush();
            Log.d("into","图片已储存"+path);
            return file;
        }finally {
            inputStream.close();
            if(fos!=null)
                fos.close();
        }
    }

}
