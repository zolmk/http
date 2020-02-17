package com.zolmk.changzai.app;

import android.app.Application;

import com.zolmk.changzai.utils.Utils;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(getApplicationContext());
    }
}
