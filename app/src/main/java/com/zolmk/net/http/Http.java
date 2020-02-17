package com.zolmk.net.http;

import android.content.Context;

import com.zolmk.net.http.helper.Helper;
import com.zolmk.net.http.utils.FileUtil;

public class Http {
    public static void init(Context context){
        Helper.init();
        FileUtil.init(context);
    }
}
