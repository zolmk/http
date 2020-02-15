package com.zolmk.net.http.utils;

public class Toast {
    public static void show(String str){
        android.widget.Toast.makeText(FileUtil.baseContext,str,android.widget.Toast.LENGTH_SHORT).show();
    }
}
