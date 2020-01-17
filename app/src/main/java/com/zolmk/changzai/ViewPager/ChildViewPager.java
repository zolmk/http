package com.zolmk.changzai.ViewPager;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class ChildViewPager extends ViewPager {
    private ViewPager mPager;
    private int flag = 1;
    private float start_X = 0;
    public ChildViewPager(@NonNull Context context) {
        super(context);
    }
    public ChildViewPager(@NonNull Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(mPager == null){
            return super.dispatchTouchEvent(ev);
        }
        final float X = ev.getX();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:{
                start_X = X;
            }break;
            case MotionEvent.ACTION_MOVE:{
                //左滑且flag = 1时截断操作
                if(flag == 1 && X < start_X){
                    mPager.requestDisallowInterceptTouchEvent(true);
                    flag = 2;
                }else if(flag == 2 && X < start_X){
                    mPager.requestDisallowInterceptTouchEvent(false);
                }else if(flag == 2 && X > start_X){
                    flag = 1;
                    mPager.requestDisallowInterceptTouchEvent(true);
                }else if(flag == 1 && X > start_X){
                    mPager.requestDisallowInterceptTouchEvent(false);
                }
            }break;
        }
        return super.dispatchTouchEvent(ev);
    }
    public void setParentPager(ViewPager viewPager){
        this.mPager = viewPager;
    }
}
