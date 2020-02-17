package com.zolmk.net.http.utils;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;

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

    /**
     * 获取相册绝对目录
     * @return String
     */
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

    /**
     * 跳转到图库，选择图片后会回到调用该函数的Activity中，然后在onActivityForResult中获取选择的图片
     * @param appCompatActivity 需要接收图片的Activity
     * @param requestCode 请求代码，需自定义
     */
    public static void getDCIMForActivity(AppCompatActivity appCompatActivity,int requestCode){
        Intent intent = new Intent(Intent.ACTION_PICK,null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
        appCompatActivity.startActivityForResult(intent,requestCode);
    }

    /**
     * 将文件Uri转换为绝对路径，一般用来获取图片路径
     * @param uri 要转换的Uri对象
     * @return  文件路径
     */
    public static String getRealFilePath(final Uri uri ) {
        if ( null == uri ) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if ( scheme == null )
            data = uri.getPath();
        else if ( ContentResolver.SCHEME_FILE.equals( scheme ) ) {
            data = uri.getPath();
        } else if ( ContentResolver.SCHEME_CONTENT.equals( scheme ) ) {
            Cursor cursor = baseContext.getContentResolver().query( uri, new String[] { MediaStore.Images.ImageColumns.DATA }, null, null, null );
            if ( null != cursor ) {
                if ( cursor.moveToFirst() ) {
                    int index = cursor.getColumnIndex( MediaStore.Images.ImageColumns.DATA );
                    if ( index > -1 ) {
                        data = cursor.getString( index );
                    }
                }
                cursor.close();
            }
        }
        return data;
    }

}
