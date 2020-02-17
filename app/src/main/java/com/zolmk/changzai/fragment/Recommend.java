package com.zolmk.changzai.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zolmk.changzai.R;
import com.zolmk.changzai.adapter.RecommendListAdapter;
import com.zolmk.changzai.beans.UserDynamicBean;
import com.zolmk.changzai.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Recommend extends Fragment implements OnRefreshListener {
    private Activity parentActivity;
    private RecyclerView recyclerView;
    private static Recommend mRecommend = null;
    private List<UserDynamicBean> mData;
    private RecommendListAdapter adapter;
    // 用来刷新的layout
    private RefreshLayout refreshLayout;

    @Override
    public void onAttach(Context context) {
        parentActivity = (Activity)context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recommend,container,false);
        initData();
        initView(root);
        init();
        return root;
    }
    public static Recommend getInstance(){
        return Recommend.Inner.Recommend;
    }


    private static class Inner{
        private static final Recommend Recommend = new Recommend();
    }

    private void init(){
        adapter = new RecommendListAdapter(getContext(),mData);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(adapter);
        // 设置刷新监听
        refreshLayout.setOnRefreshListener(this);

    }
    private void initView(View root) {
        recyclerView = root.findViewById(R.id.rv_recommend);
        refreshLayout = root.findViewById(R.id.refreshLayout_fragment_recommend);
    }
    private void initData(){
        mData = new ArrayList<>();
        for(int i=0;i<10;i++){
            UserDynamicBean bean = new UserDynamicBean();
            mData.add(bean);
        }
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
