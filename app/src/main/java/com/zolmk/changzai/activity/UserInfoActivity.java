package com.zolmk.changzai.activity;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zolmk.changzai.R;
import com.zolmk.changzai.adapter.UserInfoDynamicListAdapter;
import com.zolmk.changzai.beans.UserDynamicBean;
import com.zolmk.changzai.customView.UserInfoHeadViewGroup;
import com.zolmk.changzai.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class UserInfoActivity extends BaseActivity implements View.OnTouchListener, OnRefreshListener {
    private UserInfoHeadViewGroup headViewGroup;
    private RecyclerView dynamicRv;
    private List<UserDynamicBean> mData;
    private UserInfoDynamicListAdapter adapter;
    private ViewGroup rootLayout;
    private SmartRefreshLayout refreshLayout;

    // 判断是否需要复原 headView
    private boolean isReset = false;
    // 按下时的纵坐标
    private float firstY = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initView();
        initData();
        init();
    }
    protected void initView(){
        headViewGroup = findViewById(R.id.userInfoHeadViewGroup);
        dynamicRv = findViewById(R.id.user_info_dynamic_rv);
        rootLayout = findViewById(R.id.user_info_layoutroot);
        refreshLayout = findViewById(R.id.refreshLayout_fragment_user_info);
    }
    private void init(){
        dynamicRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new UserInfoDynamicListAdapter(getApplicationContext(),mData);

        adapter.setItemClickListener(new UserInfoDynamicListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Utils.Toast("Current Click: "+position);
            }
        });

        dynamicRv.setAdapter(adapter);
        headViewGroup.setOnTouchListener(this);
        refreshLayout.setOnRefreshListener(this);

    }
    private void initData(){
        mData = new ArrayList<>();
        for(int i=0;i<10;i++){
            UserDynamicBean bean = new UserDynamicBean();
            bean.setPicPath(new String[i%5]);
            mData.add(bean);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                firstY = event.getY();
            }break;
            case MotionEvent.ACTION_MOVE:{
                boolean isUp = firstY > event.getY();
                if(isUp&&!isReset){
                    TransitionManager.beginDelayedTransition(rootLayout);
                    headViewGroup.setScalePer(0.8f);
                    isReset = true;
                }else if(!isUp&&isReset){
                    TransitionManager.beginDelayedTransition(rootLayout);
                    headViewGroup.reset();
                    isReset = false;
                }
            }break;
        }
        return false;
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        // 这里添加刷新数据的代码
        boolean isSuccess = true;


        refreshLayout.finishRefresh(1000,isSuccess,true);
        if(isSuccess)
            Utils.Toast("刷新完成");
        else
            Utils.Toast("刷新失败，请检查网络");
    }
}
