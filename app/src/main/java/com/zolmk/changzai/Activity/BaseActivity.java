package com.zolmk.changzai.Activity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zolmk.changzai.Utils.StatusBarUtil;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置标题栏透明和字体图标暗色
        StatusBarUtil.setTranslucentStatus(this);
        StatusBarUtil.setStatusText(this,true);
    }
}
