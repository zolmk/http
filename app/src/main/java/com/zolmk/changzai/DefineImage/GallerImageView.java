package com.zolmk.changzai.DefineImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class GallerImageView extends AppCompatImageView {

    public GallerImageView(Context context, AttributeSet attr){
        super(context, attr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画圆角
        Paint paint = new Paint();
        //paint.setAlpha(0);
        paint.setColor(Color.TRANSPARENT);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        int height = getHeight();
        int width = getWidth();
        Bitmap outBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(outBitmap);
        mCanvas.drawColor(Color.TRANSPARENT);

        paint.setAlpha(0);
        mCanvas.drawRoundRect(0, 0, width, height, 60, 60, paint);

        canvas.drawBitmap(outBitmap, 0, 0, null);

    }
}