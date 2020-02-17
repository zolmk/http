package com.zolmk.changzai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zolmk.changzai.beans.MeBean;
import com.zolmk.changzai.R;

import java.util.List;

public class MeListAdapter extends RecyclerView.Adapter<MeListAdapter.MyTVHolder> {
    private Context baseContext;
    private final LayoutInflater layoutInflater;
    private List<MeBean> mData;
    private OnClickListener clickListener = null;
    public MeListAdapter(Context context, List<MeBean> data){
        layoutInflater = LayoutInflater.from(context);
        mData = data;
        baseContext = context;
    }
    @NonNull
    @Override
    public MeListAdapter.MyTVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case MeBean.LOGIN:{
                view = layoutInflater.inflate(R.layout.item_me_info,parent,false);
            }break;
            case MeBean.DEFAULT:{
                view = layoutInflater.inflate(R.layout.item_me,parent,false);
            }break;
            case MeBean.UN_LOGIN:{
                // 未登录页面暂时没做
                view = null;
            }break;
        }
        return new MyTVHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTVHolder holder, final int position) {
        final int type = mData.get(position).getType();
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickListener!=null){
                    clickListener.click(v.getId(),type,position);
                }
            }
        };
        switch (mData.get(position).getType()){
            case MeBean.LOGIN:{
                holder.alertInfo.setOnClickListener(onClickListener);
                holder.headImg.setOnClickListener(onClickListener);
            }break;
            case MeBean.DEFAULT:{
                holder.item.setOnClickListener(onClickListener);
                holder.pic.setImageResource(mData.get(position).getRId());
                holder.name.setText(mData.get(position).getName());
            }break;
            case MeBean.UN_LOGIN:{

            }break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    class MyTVHolder extends RecyclerView.ViewHolder{
        // 已登录Item0
        ImageView headImg = null;
        ImageView alertInfo = null;
        TextView userName = null;
        View textLine = null;

        // Default Item
        View item = null;
        ImageView pic = null;
        TextView name = null;

        public MyTVHolder(@NonNull View itemView,int type) {
            super(itemView);
            switch (type){
                case MeBean.LOGIN:{
                    headImg = itemView.findViewById(R.id.v_me_headimg);
                    alertInfo = itemView.findViewById(R.id.v_me_pencil);
                    userName = itemView.findViewById(R.id.v_me_username);
                    textLine = itemView.findViewById(R.id.v_me_textline);
                }break;
                case MeBean.DEFAULT:{
                    item = itemView.findViewById(R.id.v_me_item_layout);
                    name = itemView.findViewById(R.id.v_me_item_text);
                    pic = itemView.findViewById(R.id.v_me_item_pic);
                }break;
                case MeBean.UN_LOGIN:{

                }break;
            }
        }
    }
    // 设置item点击接口
    public interface OnClickListener{
        void click(int id,int type,int position);
    }
    public void setClickListener(OnClickListener onClickListener){
        this.clickListener = onClickListener;
    }
}
