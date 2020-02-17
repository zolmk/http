package com.zolmk.net.http.protocol;

import android.os.Build;
import android.os.Environment;

public class Protocol {
    public static String IMG_AND_VIDEO_SAVE_PATH = "";




    public static void init(){
        IMG_AND_VIDEO_SAVE_PATH = getPhoneDCIM();
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
}
