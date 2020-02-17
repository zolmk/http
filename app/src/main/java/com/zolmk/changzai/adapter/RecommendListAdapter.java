package com.zolmk.changzai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zolmk.changzai.R;
import com.zolmk.changzai.beans.UserDynamicBean;

import java.util.List;

public class RecommendListAdapter extends RecyclerView.Adapter<RecommendListAdapter.MyTVHolder>{
    private List<UserDynamicBean> mData;
    private ItemOnClickListener itemOnClickListener = null;
    private final LayoutInflater layoutInflater;

    public RecommendListAdapter(Context context, List<UserDynamicBean> mData) {
        layoutInflater = LayoutInflater.from(context);
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyTVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_recommend,parent,false);
        return new MyTVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTVHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData==null ? 0 : mData.size();
    }

    public void setItemOnClickListener(ItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    class MyTVHolder extends RecyclerView.ViewHolder{

        public MyTVHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    // 点击接口
    public interface ItemOnClickListener{
        void onClick(int id,int position);
    }
}
