package com.zolmk.changzai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zolmk.changzai.R;
import com.zolmk.changzai.beans.UserDynamicBean;
import com.zolmk.changzai.customView.UserInfoDynamicPictures;

import java.util.List;

public class UserInfoDynamicListAdapter extends RecyclerView.Adapter<UserInfoDynamicListAdapter.MyTVHolder> {
    private final static int TYPE_LEFT = 0;
    private final static int TYPE_RIGHT = 1;
    private List<UserDynamicBean> mData;
    private final LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;
    private Context baseContext;

    public UserInfoDynamicListAdapter(Context context, List<UserDynamicBean> mData) {
        layoutInflater = LayoutInflater.from(context);
        this.baseContext = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyTVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case TYPE_RIGHT:{
                view = layoutInflater.inflate(R.layout.item_user_info_dynamic_right,parent,false);
            }break;
            case TYPE_LEFT:{
                view = layoutInflater.inflate(R.layout.item_user_info_dynamic_left,parent,false);
            }break;

        }
        return new MyTVHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTVHolder holder, final int position) {

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null){
                    onItemClickListener.onClick(position);
                }
            }
        });
        // 消除数据混乱
        if(holder.pictures!=null) {
            holder.pictures.removeAllViews();
            holder.pictures.addPicture(mData.get(position).getPicPath());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position){
        return (position + 1) % 2 != 0 ? TYPE_LEFT : TYPE_RIGHT;
    }

    class MyTVHolder extends RecyclerView.ViewHolder{

        View rootView;
        UserInfoDynamicPictures pictures;
        TextView text;
        TextView time;
        private MyTVHolder(@NonNull View itemView,int type) {
            super(itemView);
            rootView = itemView;
            if(type==TYPE_LEFT){
                text = itemView.findViewById(R.id.item_user_info_dynamic_text_left);
                pictures = itemView.findViewById(R.id.user_info_dynamic_picture_left);
                time = itemView.findViewById(R.id.item_user_info_dynamic_left_time);
            }else if(type==TYPE_RIGHT){
                pictures = itemView.findViewById(R.id.user_info_dynamic_picture_right);
                pictures = itemView.findViewById(R.id.user_info_dynamic_picture_right);
                time = itemView.findViewById(R.id.item_user_info_dynamic_right_time);
            }
        }
    }
    public void setItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }
    // item点击接口
    public interface OnItemClickListener{
        void onClick(int position);
    }
}
