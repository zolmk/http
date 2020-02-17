package com.zolmk.changzai.utils;


import android.content.Context;
import android.widget.Toast;

public class Utils {
    private static Context applicationContext;
    public static void init(Context context){
        applicationContext = context;
    }
    public static int dp2px(float dipValue) {
        final float scale = applicationContext.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
    public static void Toast(String str){
        Toast.makeText(applicationContext,str,Toast.LENGTH_LONG).show();
    }
}
