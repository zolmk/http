package com.zolmk.changzai.customView;


import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.zolmk.changzai.R;
import com.zolmk.changzai.utils.ConstraintLayoutUtil;
import com.zolmk.changzai.utils.Utils;

public class UserInfoHeadViewGroup extends ConstraintLayout {
    private ImageView kingHead;
    private View baseView;
    private ConstraintLayoutUtil constraintLayoutUtil;
    private ConstraintLayout constraintLayout;
    private ImageView alertPencil;      //修改个人信息img
    private TextView addFriend;     // 加好友
    // 需要填充数据的view
    private ImageView head;     // 头像
    private TextView userName;      // 用户名
    private TextView signature;        // 个性签名
    private TextView label1;        // 标签1
    private TextView label2;        // 标签2
    private TextView label3;        // 标签3
    private TextView watchNumber;       // 浏览人数
    private TextView location;      // 位置
    private TextView age;       // 年龄
    private TextView day;       // 开通账号天数
    private TextView dynamicNumber;     // 发布动态个数

    // 需要动态改变的布局的view id
    private final static int[] VIEW_ID_TOP_INIT_16 = {
            R.id.user_info_username,
            R.id.user_info_label_card_3,
            R.id.user_info_location
    };
    private final static int[] VIEW_ID_BOTTOM_INIT_16 = {
            R.id.user_info_label_card_1
    };
    // 用来保存View大小
    private ViewGroup.LayoutParams headParams;
    private ViewGroup.LayoutParams kingHeadParams;
    private int constraintLayoutHeight;
    // 保存刚开始字体大小
    private float userNameParams;
    private float signatureParams;
    private float label1params;
    private float label2params;
    private float label3params;
    // 用来保存布局
    private ConstraintSet firstSet;

    public UserInfoHeadViewGroup(Context context) {
        this(context,null);
    }

    public UserInfoHeadViewGroup(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public UserInfoHeadViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        baseView = (View)View.inflate(context, R.layout.activity_user_info_head,this);
        initView();
        init();
    }
    // 初始化view
    private void initView(){
        head = baseView.findViewById(R.id.user_info_head);
        userName = baseView.findViewById(R.id.user_info_username);
        kingHead = baseView.findViewById(R.id.user_info_kinghead);
        signature = baseView.findViewById(R.id.user_info_signature);
        constraintLayout = baseView.findViewById(R.id.user_info_constraintLayout);
        alertPencil = baseView.findViewById(R.id.user_info_alert);
        addFriend = baseView.findViewById(R.id.user_info_add_friend);
        label1 = baseView.findViewById(R.id.user_info_name_label_1);
        label2 = baseView.findViewById(R.id.user_info_name_label_2);
        label3 = baseView.findViewById(R.id.user_info_name_label_3);
        watchNumber = baseView.findViewById(R.id.user_info_watch_number);
        location = baseView.findViewById(R.id.user_info_location);
        age = baseView.findViewById(R.id.user_info_age);
        day = baseView.findViewById(R.id.user_info_record_day);
        dynamicNumber = baseView.findViewById(R.id.user_info_record_number);
    }
    // 初始化变量
    private void init(){
        firstSet = new ConstraintSet();
        firstSet.clone(constraintLayout);
        // 新建布局更改工具类
        constraintLayoutUtil = new ConstraintLayoutUtil(constraintLayout);
        addFriend.setOnClickListener(new OnClickListener() {    // 转到加好友页面
            @Override
            public void onClick(View v) {
                Utils.Toast("加好友");
            }
        });
        alertPencil.setOnClickListener(new OnClickListener() {  //转到信息更改页面
            @Override
            public void onClick(View v) {
                Utils.Toast("信息修改");
            }
        });
        headParams = head.getLayoutParams();
        kingHeadParams = kingHead.getLayoutParams();
        constraintLayoutHeight = constraintLayout.getLayoutParams().height;
        userNameParams = userName.getTextSize();
        signatureParams = signature.getTextSize();
        label1params = label1.getTextSize();
        label2params = label2.getTextSize();
        label3params = label3.getTextSize();
    }
    public void setScalePer(float scale){
        // 重置布局
        //constraintLayoutUtil.clone(firstSet);
        // 这里必须先改变布局再改变view大小
        changeLayoutSize(VIEW_ID_TOP_INIT_16,ConstraintLayoutUtil.TOP,scale,16);
        changeLayoutSize(VIEW_ID_BOTTOM_INIT_16,ConstraintLayoutUtil.BOTTOM,scale,16);
        // 提交对布局的更改
        constraintLayoutUtil.commit();
        // 改变view大小
        head.setLayoutParams(tempFuntion(head,headParams,scale));
        kingHead.setLayoutParams(tempFuntion(kingHead,kingHeadParams,scale));

        ViewGroup.LayoutParams params1 = constraintLayout.getLayoutParams();
        params1.height = (int) (constraintLayoutHeight * scale);
        constraintLayout.setLayoutParams(params1);

        // 文字只改变大小
        /*
        tempFuntion(userName,userNameParams,scale);
        tempFuntion(signature,signatureParams,scale);
        tempFuntion(label1,label1params,scale);
        tempFuntion(label2,label2params,scale);
        tempFuntion(label3,label3params,scale);
        */

    }
    private ViewGroup.LayoutParams tempFuntion(View view,ViewGroup.LayoutParams params,float scale){
        ViewGroup.LayoutParams params1 = view.getLayoutParams();
        params1.height = (int) (params.height * scale);
        params1.width = (int) (params.width * scale);
        return params1;
    }
    private void tempFuntion(View view,float params,float scale){
        ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_PX,params*0.9f);
    }
    private void changeLayoutSize(int[] ids,int type,float scale,float beforeSize){
        int size = (int)(scale*beforeSize);
        switch (type) {
            case ConstraintLayoutUtil.TOP:{
                for(int i : ids){
                    constraintLayoutUtil.setViewTop(i,size);
                }
            }break;
            case ConstraintLayoutUtil.BOTTOM:{
                for(int i : ids){
                    constraintLayoutUtil.setViewBottom(i,size);
                }
            }break;
        }
    }
    public void reset(){
        userName.setTextSize(TypedValue.COMPLEX_UNIT_PX,userNameParams);
        signature.setTextSize(TypedValue.COMPLEX_UNIT_PX,signatureParams);
        ViewGroup.LayoutParams params1 = constraintLayout.getLayoutParams();
        params1.height = constraintLayoutHeight;
        constraintLayout.setLayoutParams(params1);
        constraintLayoutUtil.clone(firstSet);
        constraintLayoutUtil.commit();
    }


}
