package com.zolmk.changzai.itemDecoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MeItemDecoration extends RecyclerView.ItemDecoration {
    //分割线
    Drawable mDivider;

    public static final int[] ATRRS = new int[]{
            android.R.attr.listDivider
    };

    public MeItemDecoration(Context context) {
        TypedArray ta = context.obtainStyledAttributes(ATRRS);
        mDivider = ta.getDrawable(0);
        ta.recycle();
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int pos = parent.getChildLayoutPosition(view); // 得到当前view位置
        if(pos != parent.getAdapter().getItemCount() -1){ // 如果不是最后一个 那么留出空间
            outRect.set(0,0,0,mDivider.getIntrinsicHeight());
        }
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        //设置分隔线的left和right
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < parent.getChildCount(); i++) {
            View view = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
            //分隔线的top和bottom
            int top = view.getBottom()+params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            //分隔线的绘制区域
            mDivider.setBounds(left,top,right,bottom);
            //把分隔线绘制到canvas
            mDivider.draw(c);
        }
    }
}
