package com.zolmk.changzai.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

/**
 * 改变控件布局辅助类
 *
 */
public class ConstraintLayoutUtil extends ConstraintSet {
    private ConstraintLayout constraintLayout;
    public ConstraintLayoutUtil(ConstraintLayout layout){
        this.constraintLayout = layout;
        this.clone(layout);
    }
    // 改变view顶部距离
    public ConstraintLayoutUtil setViewTop(int viewId,int value){
        this.setMargin(viewId,ConstraintLayoutUtil.TOP,value);
        return this;
    }
    // 改变view底部距离
    public ConstraintLayoutUtil setViewBottom(int viewId,int value){
        this.setMargin(viewId,ConstraintLayoutUtil.BOTTOM,value);
        return this;
    }
    // 改变view左部距离
    public ConstraintLayoutUtil setViewLeft(int viewId,int value){
        this.setMargin(viewId,ConstraintLayoutUtil.LEFT,value);
        return this;
    }
    // 改变view右部距离
    public ConstraintLayoutUtil setViewRight(int viewId,int value){
        this.setMargin(viewId,ConstraintLayoutUtil.RIGHT,value);
        return this;
    }
    public void commit(){
        this.applyTo(this.constraintLayout);
    }
}
