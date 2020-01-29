package com.zolmk.changzai.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zolmk.changzai.Beans.ThinkBean;
import com.zolmk.changzai.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CareListAdapter extends RecyclerView.Adapter<CareListAdapter.MyTVHolder> {
    private final LayoutInflater mLayoutInflater;
    private List<ThinkBean> mData;
    private final Context mContext;

    public CareListAdapter(Context context, List<ThinkBean> mData){
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mData = mData;
    }
    public void addThinkUpdate(ArrayList<ThinkBean> beans){
        for(ThinkBean bean : beans){
            this.mData.add(0,bean);
        }
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CareListAdapter.MyTVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        // 根据type不同所显示view也不同
        switch (viewType){
            case -1:{
                view = mLayoutInflater.inflate(R.layout.item_search,parent,false);
            }break;
            case 0:{
                view = mLayoutInflater.inflate(R.layout.item_think_zero,parent,false);
            }break;
            case 1:{
                view = mLayoutInflater.inflate(R.layout.item_think_one,parent,false);
            }break;
            case 4:{
                view = mLayoutInflater.inflate(R.layout.item_think_four,parent,false);
            }break;
            default:{
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
                case 0:{
                    head = itemView.findViewById(R.id.v_think_zero_head);
                    name = itemView.findViewById(R.id.tv_think_zero_name);
                    add = itemView.findViewById(R.id.iv_think_zero_add);
                    imgList = new ArrayList<>();
                    pastTime = itemView.findViewById(R.id.tv_think_zero_pasttime);
                    text = itemView.findViewById(R.id.tv_think_zero_text);
                    like = itemView.findViewById(R.id.tv_zero_like);
                    comment = itemView.findViewById(R.id.tv_zero_comment);
                }break;
                case 1:{
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
                case 4:{
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
                default:{
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
