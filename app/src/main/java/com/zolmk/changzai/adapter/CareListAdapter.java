package com.zolmk.changzai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zolmk.changzai.beans.UserDynamicBean;
import com.zolmk.changzai.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 关注页RecyclerView的Adapter
 *
 */
public class CareListAdapter extends RecyclerView.Adapter<CareListAdapter.MyTVHolder> {
    private final LayoutInflater mLayoutInflater;
    private List<UserDynamicBean> mData;
    private final Context mContext;

    public CareListAdapter(Context context, List<UserDynamicBean> mData){
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mData = mData;
        //为搜索框留位置
        UserDynamicBean bean = new UserDynamicBean();
        bean.setImgNumber(UserDynamicBean.SEARCH);
        this.mData.add(0,bean);
    }
    public void addThinkUpdate(ArrayList<UserDynamicBean> beans){
        for(UserDynamicBean bean : beans){
            this.mData.add(1,bean);
        }
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CareListAdapter.MyTVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        // 根据type不同所显示view也不同
        switch (viewType){
            case UserDynamicBean.SEARCH:{
                view = mLayoutInflater.inflate(R.layout.item_search_home,parent,false);
            }break;
            case UserDynamicBean.ZERO_PICTURE:{
                view = mLayoutInflater.inflate(R.layout.item_think_zero,parent,false);
            }break;
            case UserDynamicBean.ONT_PICTURE:{
                view = mLayoutInflater.inflate(R.layout.item_think_one,parent,false);
            }break;
            case UserDynamicBean.FOUR_PICTURE:{
                view = mLayoutInflater.inflate(R.layout.item_think_four,parent,false);
            }break;
            case UserDynamicBean.TWO_PICTURE:{
                view = mLayoutInflater.inflate(R.layout.item_think_two,parent,false);
            }
        }
        return new CareListAdapter.MyTVHolder(view,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTVHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0) return -1;
        return mData.get(position).getImgNumber();
    }

    class MyTVHolder extends RecyclerView.ViewHolder{
        ImageView head;
        TextView name;
        ImageView add;
        ArrayList<ImageView> imgList;
        TextView pastTime;
        TextView text;
        TextView like;
        TextView comment;
        public MyTVHolder(@NonNull View itemView,int type) {
            super(itemView);
            switch (type){
                case UserDynamicBean.SEARCH:{

                }break;
                case UserDynamicBean.ZERO_PICTURE:{
                    head = itemView.findViewById(R.id.v_think_zero_head);
                    name = itemView.findViewById(R.id.tv_think_zero_name);
                    add = itemView.findViewById(R.id.iv_think_zero_add);
                    imgList = new ArrayList<>();
                    pastTime = itemView.findViewById(R.id.tv_think_zero_pasttime);
                    text = itemView.findViewById(R.id.tv_think_zero_text);
                    like = itemView.findViewById(R.id.tv_zero_like);
                    comment = itemView.findViewById(R.id.tv_zero_comment);
                }break;
                case UserDynamicBean.ONT_PICTURE:{
                    head = itemView.findViewById(R.id.v_think_one_head);
                    name = itemView.findViewById(R.id.tv_think_one_name);
                    add = itemView.findViewById(R.id.iv_think_one_add);
                    imgList = new ArrayList<>();
                    imgList.add((ImageView)itemView.findViewById(R.id.iv_think_one_img));
                    pastTime = itemView.findViewById(R.id.tv_think_one_pasttime);
                    text = itemView.findViewById(R.id.tv_think_one_text);
                    like = itemView.findViewById(R.id.tv_one_like);
                    comment = itemView.findViewById(R.id.tv_one_comment);
                }break;
                case UserDynamicBean.FOUR_PICTURE:{
                    head = itemView.findViewById(R.id.v_think_four_head);
                    name = itemView.findViewById(R.id.tv_think_four_name);
                    add = itemView.findViewById(R.id.iv_think_four_add);
                    imgList = new ArrayList<>();
                    imgList.add((ImageView)itemView.findViewById(R.id.iv_think_four_img1));
                    imgList.add((ImageView)itemView.findViewById(R.id.iv_think_four_img2));
                    imgList.add((ImageView)itemView.findViewById(R.id.iv_think_four_img3));
                    imgList.add((ImageView)itemView.findViewById(R.id.iv_think_four_img4));
                    pastTime = itemView.findViewById(R.id.tv_think_four_pasttime);
                    text = itemView.findViewById(R.id.tv_think_four_text);
                    like = itemView.findViewById(R.id.tv_four_like);
                    comment = itemView.findViewById(R.id.tv_four_comment);
                }break;
                case UserDynamicBean.TWO_PICTURE:{
                    head = itemView.findViewById(R.id.v_think_two_head);
                    name = itemView.findViewById(R.id.tv_think_two_name);
                    add = itemView.findViewById(R.id.iv_think_two_add);
                    imgList = new ArrayList<>();
                    imgList.add((ImageView)itemView.findViewById(R.id.iv_think_two_img1));
                    imgList.add((ImageView)itemView.findViewById(R.id.iv_think_two_img2));
                    pastTime = itemView.findViewById(R.id.tv_think_two_pasttime);
                    text = itemView.findViewById(R.id.tv_think_two_text);
                    like = itemView.findViewById(R.id.tv_two_like);
                    comment = itemView.findViewById(R.id.tv_two_comment);
                }break;
            }
        }
    }
}
