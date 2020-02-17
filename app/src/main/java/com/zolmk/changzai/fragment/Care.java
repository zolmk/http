package com.zolmk.changzai.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zolmk.changzai.adapter.CareListAdapter;
import com.zolmk.changzai.beans.UserDynamicBean;
import com.zolmk.changzai.R;
import com.zolmk.changzai.beans.UserDynamicBean;
import com.zolmk.changzai.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Care extends Fragment implements OnRefreshListener {
    private static Care mCare = null;

    private RecyclerView recyclerView;
    private CareListAdapter careListAdapter;
    private List<UserDynamicBean> beans;
    private SmartRefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_care,container,false);
        initData();
        initView(root);
        init();
        return root;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static Care getInstance(){
        return Care.Inner.Care;
    }
    private static class Inner{
        private static final Care Care = new Care();
    }

    private void init(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        careListAdapter = new CareListAdapter(getContext(),beans);
        recyclerView.setAdapter(careListAdapter);
        refreshLayout.setOnRefreshListener(this);
    }
    private void initView(View root){
        refreshLayout = root.findViewById(R.id.refreshLayout_fragment_care);
        recyclerView = root.findViewById(R.id.rv_care);
    }
    private void initData(){
        beans = new ArrayList<>();
        UserDynamicBean UserDynamicBean1 = new UserDynamicBean();
        UserDynamicBean1.setImgNumber(UserDynamicBean.ONT_PICTURE);
        UserDynamicBean UserDynamicBean2 = new UserDynamicBean();
        UserDynamicBean2.setImgNumber(UserDynamicBean.FOUR_PICTURE);

        beans.add(UserDynamicBean1);
        beans.add(UserDynamicBean2);
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
