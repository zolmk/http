package com.zolmk.changzai.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.zolmk.changzai.beans.ChatUsersBean;
import com.zolmk.changzai.R;

import java.util.List;

/**
 * MainActivity中聊天页面中的RecyclerView的Adapter
 *
 */
public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.MyTVHolder> {
    private List<ChatUsersBean> mData;
    private Context baseContext;
    private final LayoutInflater layoutInflater;
    private ItemListener itemListener = null;
    public ChatListAdapter(Context context, List<ChatUsersBean> data){
        this.mData = data;
        this.baseContext = context;
        this.layoutInflater = LayoutInflater.from(context);
        Log.d("tip",""+data.size());
    }
    // item监听接口
    public interface ItemListener{
        void onClick(View view,int position);
        void onLongClick(View view,int position);
    }
    // 设置item监听接口
    public void setItemListener(ItemListener listener){
        this.itemListener = listener;
    }


    @NonNull
    @Override
    public ChatListAdapter.MyTVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_main_chat,parent,false);
        return new MyTVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTVHolder holder, final int position) {
        if(itemListener!=null) {
            // 添加item监听
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.onClick(v, position);
                }
            });
            holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    itemListener.onLongClick(v, position);
                    return false;
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }
    class MyTVHolder extends RecyclerView.ViewHolder{
        ConstraintLayout layout;
        ImageView headImage;
        TextView userName;
        TextView message;
        TextView clock;
        public MyTVHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.v_chat_main_layout);
            headImage = itemView.findViewById(R.id.v_chat_item_head);
            userName = itemView.findViewById(R.id.v_chat_item_username);
            message = itemView.findViewById(R.id.v_chat_item_message);
            clock = itemView.findViewById(R.id.v_chat_item_clock);
        }
    }
}
