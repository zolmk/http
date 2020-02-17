package com.zolmk.changzai.fragment;

import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zolmk.changzai.adapter.ChatListAdapter;
import com.zolmk.changzai.beans.ChatUsersBean;
import com.zolmk.changzai.R;
import com.zolmk.changzai.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Chat extends FullFragment implements OnRefreshListener {
    private static Chat mChat = null;
    private RecyclerView recyclerView;
    private List<ChatUsersBean> mdata;
    private ChatListAdapter chatListAdapter;
    private EditText search;
    private ImageView sort;
    private SmartRefreshLayout refreshLayout;

    @Override
    protected void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        chatListAdapter = new ChatListAdapter(getContext(),mdata);
        recyclerView.setAdapter(chatListAdapter);
        refreshLayout.setOnRefreshListener(this);
    }
    // 初始化数据
    protected void initData(){
        mdata = new ArrayList<>();
        mdata.add(new ChatUsersBean());
        mdata.add(new ChatUsersBean());
    }
    protected void initView(){
        recyclerView = baseView.findViewById(R.id.v_chat_main_rc);
        search = baseView.findViewById(R.id.v_edit_search_chat);
        sort = baseView.findViewById(R.id.v_chat_main_sort);
        refreshLayout = baseView.findViewById(R.id.refreshLayout_fragment_chat);

    }

    @Override
    public int getPlaceViewId() {
        return R.id.chat_place_view;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_chat;
    }

    public static Chat getInstance(){
        return Chat.Inner.Chat;
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

    private static class Inner{
        private static final Chat Chat = new Chat();
    }
}
