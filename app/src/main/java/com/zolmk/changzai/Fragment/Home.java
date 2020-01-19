package com.zolmk.changzai.Fragment;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.zolmk.changzai.Adapter.HomePagerAdapter;
import com.zolmk.changzai.R;
import com.zolmk.changzai.ViewPager.ChildViewPager;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener, View.OnFocusChangeListener {
    private Activity parentActivity;
    private ViewPager parentPager;
    private TextView tv_care;
    private TextView tv_recommend;
    private ImageView iv_care;
    private ImageView iv_recommend;
    private CardView cv_care;
    private CardView cv_recommend;
    private ChildViewPager childViewPager;
    private EditText et_search;
    // 默认搜索词
    private String search_text = "大家都在搜：常在APP";

    @Override
    public void onAttach(Context context) {
        parentActivity = (Activity)context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home,container,false);
        init(root);
        return root;
    }

    public static Home getInstance(){
        return Inner.home;
    }


    private static class Inner{
        private static final Home home = new Home();
    }
    // 初始化Home页面
    private void init(View root){
        initPager(root);
        initView(root);
    }
    private void initPager(View root){
        childViewPager = (ChildViewPager)root.findViewById(R.id.v_childviewpager);
        childViewPager.setParentPager(this.parentPager);
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(Care.getInstance());
        list.add(Recommend.getInstance());
        childViewPager.setAdapter(new HomePagerAdapter(getChildFragmentManager(),list));
        childViewPager.setCurrentItem(0);
        childViewPager.addOnPageChangeListener(this);
    }
    private void initView(View root){
        tv_care = root.findViewById(R.id.v_text_care);
        tv_recommend = root.findViewById(R.id.v_text_recommend);
        iv_care = root.findViewById(R.id.v_img_care);
        iv_recommend = root.findViewById(R.id.v_img_recommend);
        iv_recommend.setVisibility(View.INVISIBLE);
        tv_care.setTextSize(22);
        tv_recommend.setTextSize(19);
        cv_care = root.findViewById(R.id.v_card_care);
        cv_care.setOnClickListener(this);
        cv_recommend = root.findViewById(R.id.v_card_recommend);
        cv_recommend.setOnClickListener(this);
        et_search = root.findViewById(R.id.v_edit_search);
        et_search.setOnFocusChangeListener(this);
    }
    public void setParentPager(ViewPager viewPager){
        this.parentPager = viewPager;
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if(position==0){
            tv_care.setTextSize(23);
            tv_recommend.setTextSize(20);
            tv_care.setTextColor(Color.parseColor("#000000"));
            tv_recommend.setTextColor(Color.parseColor("#555555"));
            iv_recommend.setVisibility(View.INVISIBLE);
            iv_care.setVisibility(View.VISIBLE);
        }else{
            tv_recommend.setTextSize(23);
            tv_care.setTextSize(20);
            tv_recommend.setTextColor(Color.parseColor("#000000"));
            tv_care.setTextColor(Color.parseColor("#555555"));
            iv_care.setVisibility(View.INVISIBLE);
            iv_recommend.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.v_card_care:
                childViewPager.setCurrentItem(0);
                break;
            case R.id.v_card_recommend:
                childViewPager.setCurrentItem(1);
                break;
        }
    }
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(!hasFocus){
            et_search.setText(search_text);
        }
    }
}
