package com.zolmk.changzai.ViewPager;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class ChildViewPager extends ViewPager {
    private ViewPager mPager;
    private int abc = 1;
    private float mLastMotionX;
    public ChildViewPager(@NonNull Context context) {
        super(context);
    }
    public ChildViewPager(@NonNull Context context, AttributeSet attrs){
        super(context,attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (mPager != null) {
            final float x = ev.getX();
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mPager.requestDisallowInterceptTouchEvent(true);
                    abc = 1;
                    mLastMotionX = x;
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (abc == 1) {
                        if (x - mLastMotionX > 5 && getCurrentItem() == 0) {
                            abc = 0;
                            mPager.requestDisallowInterceptTouchEvent(false);
                        }


                        if (x - mLastMotionX < -5 && getCurrentItem() == getAdapter().getCount() - 1) {
                            abc = 0;
                            mPager.requestDisallowInterceptTouchEvent(false);
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    mPager.requestDisallowInterceptTouchEvent(false);
                    break;
            }
        }
        return super.dispatchTouchEvent(ev);
    }
    public void setParentPager(ViewPager viewPager){
        this.mPager = viewPager;
    }
}
