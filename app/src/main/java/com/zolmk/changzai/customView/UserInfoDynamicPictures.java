package com.zolmk.changzai.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zolmk.changzai.R;
import com.zolmk.changzai.utils.Utils;

public class UserInfoDynamicPictures extends LinearLayout {
    private Context baseContext;
    private int ONE_PIC_WIDTH;
    private int ONE_PIC_HEIGHT;
    private int PIC_SPLIT;
    public UserInfoDynamicPictures(Context context) {
        this(context,null);
    }

    public UserInfoDynamicPictures(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public UserInfoDynamicPictures(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        baseContext = context;
        PIC_SPLIT = Utils.dp2px(2);
        ONE_PIC_HEIGHT = Utils.dp2px(200);
        ONE_PIC_WIDTH = Utils.dp2px(200);

    }
    public void addPicture(String[] picPath) {
        int num = picPath.length;
        switch (num) {
            case 0: {
                return;
            }
            case 1: {
                this.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView = new ImageView(baseContext);
                // 设置图片
                imageView.setBackgroundResource(R.drawable.test1);

                this.addView(imageView, ONE_PIC_WIDTH, ONE_PIC_HEIGHT);
            }
            break;
            case 2: {
                this.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView1 = new ImageView(baseContext);
                ImageView imageView2 = new ImageView(baseContext);
                // 设置图片
                imageView1.setBackgroundResource(R.drawable.test1);
                imageView2.setBackgroundResource(R.drawable.test1);

                View view = new View(baseContext);
                this.addView(imageView1, (ONE_PIC_WIDTH-PIC_SPLIT)/2,(ONE_PIC_HEIGHT-PIC_SPLIT)/2);
                this.addView(view, PIC_SPLIT, 0);
                this.addView(imageView2,(ONE_PIC_WIDTH-PIC_SPLIT)/2,(ONE_PIC_HEIGHT-PIC_SPLIT)/2);
            }
            break;
            case 3:{
                this.setOrientation(LinearLayout.VERTICAL);

                LinearLayout linearLayout = new LinearLayout(baseContext);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView1 = new ImageView(baseContext);
                ImageView imageView2 = new ImageView(baseContext);
                ImageView imageView3 = new ImageView(baseContext);
                // 设置图片
                imageView1.setBackgroundResource(R.drawable.test1);
                imageView2.setBackgroundResource(R.drawable.test1);
                imageView3.setBackgroundResource(R.drawable.test1);

                View view1 = new View(baseContext);
                View view2 = new View(baseContext);
                linearLayout.addView(imageView1, (ONE_PIC_WIDTH-PIC_SPLIT)/2,(ONE_PIC_HEIGHT-PIC_SPLIT)/2);
                linearLayout.addView(view1, PIC_SPLIT, 0);
                linearLayout.addView(imageView2,(ONE_PIC_WIDTH-PIC_SPLIT)/2,(ONE_PIC_HEIGHT-PIC_SPLIT)/2);
                this.addView(linearLayout,ONE_PIC_WIDTH,(ONE_PIC_HEIGHT-PIC_SPLIT)/2);
                this.addView(view2,0,PIC_SPLIT);
                this.addView(imageView3,ONE_PIC_WIDTH,ONE_PIC_HEIGHT);
            }break;
            case 4:{
                this.setOrientation(LinearLayout.VERTICAL);

                LinearLayout linearLayout1 = new LinearLayout(baseContext);
                linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout linearLayout2 = new LinearLayout(baseContext);
                linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView1 = new ImageView(baseContext);
                ImageView imageView2 = new ImageView(baseContext);
                ImageView imageView3 = new ImageView(baseContext);
                ImageView imageView4 = new ImageView(baseContext);
                // 设置图片
                imageView1.setBackgroundResource(R.drawable.test1);
                imageView2.setBackgroundResource(R.drawable.test1);
                imageView3.setBackgroundResource(R.drawable.test1);
                imageView4.setBackgroundResource(R.drawable.test1);

                View view1 = new View(baseContext);
                linearLayout1.addView(imageView1, (ONE_PIC_WIDTH-PIC_SPLIT)/2,(ONE_PIC_HEIGHT-PIC_SPLIT)/2);
                linearLayout1.addView(view1, PIC_SPLIT, 0);
                linearLayout1.addView(imageView2,(ONE_PIC_WIDTH-PIC_SPLIT)/2,(ONE_PIC_HEIGHT-PIC_SPLIT)/2);

                View view2 = new View(baseContext);
                linearLayout2.addView(imageView3, (ONE_PIC_WIDTH-PIC_SPLIT)/2,(ONE_PIC_HEIGHT-PIC_SPLIT)/2);
                linearLayout2.addView(view2, PIC_SPLIT, 0);
                linearLayout2.addView(imageView4,(ONE_PIC_WIDTH-PIC_SPLIT)/2,(ONE_PIC_HEIGHT-PIC_SPLIT)/2);
                View view3 = new View(baseContext);
                this.addView(linearLayout1,ONE_PIC_WIDTH,(ONE_PIC_HEIGHT-PIC_SPLIT)/2);
                this.addView(view3,0,PIC_SPLIT);
                this.addView(linearLayout2,ONE_PIC_WIDTH,(ONE_PIC_HEIGHT-PIC_SPLIT)/2);

            }break;
        }
    }
}
