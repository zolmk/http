package com.zolmk.changzai.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zolmk.changzai.utils.StatusBarUtil;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置标题栏透明和字体图标暗色
        StatusBarUtil.setTranslucentStatus(this);
        StatusBarUtil.setStatusText(this,true);
        setContentView(getLayoutId());
        init();
        initView();
    }
    protected abstract void init();
    protected abstract void initView();
    protected abstract int getLayoutId();
}
