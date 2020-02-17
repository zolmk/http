package com.zolmk.changzai.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.zolmk.changzai.R;
import com.zolmk.changzai.utils.Utils;

/**
 * 首页关注推荐字下面切换的view
 *
 */
public class SwitchView extends View {
    private Context baseContext;
    private int height;
    private int width;
    private int count;
    private int current;
    private Paint paint;
    private RectF rectF;
    private float itemWidth;
    private int rx;
    private int ry;
    private int recfStart;
    private int recfEnd;
    private int maxEnd;
    private int minStart;
    private final int SPEED = 4;
    public SwitchView(Context context) {
        this(context,null);
    }

    public SwitchView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public SwitchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context,attrs,defStyleAttr,0);
    }

    public SwitchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        baseContext = context;
        current = 1;
        count = 1;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SwitchView,0,0);
        for(int i=0;i<ta.getIndexCount();i++){
            int attr = ta.getIndex(i);
            if(attr==R.styleable.SwitchView_switch_count){
                count = ta.getInteger(attr,1);
            }
        }
        width = ta.getLayoutDimension(R.styleable.SwitchView_android_layout_width,0);
        height = ta.getLayoutDimension(R.styleable.SwitchView_android_layout_height,0);

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(getResources().getColor(R.color.color_home_text_line));
        rectF = new RectF();

        init();
    }
    private void init(){

        itemWidth = width/(count*3);
        updateRectF();
        rx = Utils.dp2px(2);
        ry = Utils.dp2px(2);
        minStart = (int)itemWidth;
        maxEnd = (int)(width - itemWidth);
    }
    private void updateRectF(){
        recfStart = current==1 ? (int)itemWidth : (int)(itemWidth+itemWidth*3*(current-1));
        recfEnd = (int)(recfStart + itemWidth);
        rectF.left = recfStart;
        rectF.right = recfEnd;
        rectF.top = 0;
        rectF.bottom = height;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(rectF,rx,ry,paint);
    }

    public void leftMove(int x){
        rectF.left = recfStart;
        if(recfEnd + x/SPEED < maxEnd) {
            rectF.right = recfEnd + x / SPEED;
        }else{
            rectF.right = maxEnd;
        }
        invalidate();
    }
    public void rightMove(int x){
        rectF.right = recfEnd;
        if(recfStart - x/SPEED > minStart) {
            rectF.left = recfStart - x / SPEED;
        }else {
            rectF.left = minStart;
        }
        invalidate();
    }

    public void setCurrentTab(int selected){
        this.current = selected;
        // tab大于等于3重新计算maxEnd和minStart
        if(count>=3) {
            maxEnd = (int) (itemWidth * 3 * selected + 2 * itemWidth);
            minStart = (int) (itemWidth * 3 * (selected - 2) + itemWidth);
        }
        updateRectF();
        invalidate();
    }

}
