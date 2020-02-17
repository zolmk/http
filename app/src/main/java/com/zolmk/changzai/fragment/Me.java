package com.zolmk.changzai.fragment;


import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zolmk.changzai.MainActivity;
import com.zolmk.changzai.activity.UserInfoActivity;
import com.zolmk.changzai.adapter.MeListAdapter;
import com.zolmk.changzai.beans.MeBean;
import com.zolmk.changzai.itemDecoration.MeItemDecoration;
import com.zolmk.changzai.R;

import java.util.ArrayList;
import java.util.List;

public class Me extends FullFragment {
    private static Me mMe = null;
    private RecyclerView recyclerView;
    private List<MeBean> mData;
    private MeListAdapter meListAdapter;
    private final static int[] picId = {R.drawable.me_userinfo,R.drawable.me_camera,R.drawable.me_collection,R.drawable.me_wallet,
                                R.drawable.me_card,R.drawable.me_setting,R.drawable.me_quit_login};
    private final static String[] name = {"个人信息","相册","收藏","钱包","卡券包","设置","退出登录"};

    @Override
    protected void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        meListAdapter = new MeListAdapter(getContext(),this.mData);
        // 设置item点击事件
        meListAdapter.setClickListener(new MeListAdapter.OnClickListener() {
            @Override
            public void click(int id, int type, int position) {
                if(position==0){

                }else {
                    switch (position){
                        case 1:{
                            Intent intent = new Intent(getActivity(),UserInfoActivity.class);
                            startActivity(intent);
                        }break;
                    }
                }
            }
        });

        recyclerView.setAdapter(meListAdapter);
        recyclerView.addItemDecoration(new MeItemDecoration(getContext()));
    }

    @Override
    protected void initView() {
        recyclerView = baseView.findViewById(R.id.me_rc);
    }

    protected void initData(){
        mData = new ArrayList<>();
        // 初始化Item0 在这里判断用户是否登录
        MeBean item0 = new MeBean();
        item0.setType(MeBean.LOGIN);
        mData.add(item0);


        // 初始化Item
        for(int i=0;i<picId.length;i++){
            MeBean item = new MeBean();
            item.setType(MeBean.DEFAULT);
            item.setName(name[i]);
            item.setRId(picId[i]);
            mData.add(item);
        }
    }

    @Override
    public int getPlaceViewId() {
        return R.id.v_me_place;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user;
    }

    public static Me getInstance(){
        return Me.Inner.Me;
    }
    private static class Inner{
        private static final Me Me = new Me();
    }
}
