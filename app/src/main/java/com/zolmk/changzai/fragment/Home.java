package com.zolmk.changzai.fragment;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.zolmk.changzai.adapter.HomePagerAdapter;
import com.zolmk.changzai.customView.SwitchView;
import com.zolmk.changzai.R;
import com.zolmk.changzai.viewPager.ChildViewPager;

import java.util.ArrayList;
import java.util.List;

public class Home extends FullFragment implements ViewPager.OnPageChangeListener, View.OnClickListener{
    private Activity parentActivity;
    private ViewPager parentPager;
    private TextView tv_care;
    private TextView tv_recommend;
    private CardView cv_care;
    private CardView cv_recommend;
    private ChildViewPager childViewPager;
    private SwitchView switchView;
    private int selectedColor = Color.parseColor("#000000");
    private int unSelectedColor = Color.parseColor("#555555");

    @Override
    public void onAttach(Context context) {
        parentActivity = (Activity)context;
        super.onAttach(context);
    }

    @Override
    protected void init() {
        initPager();
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getPlaceViewId() {
        return R.id.v_home_place;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    public static Home getInstance(){
        return Inner.home;
    }


    private static class Inner{
        private static final Home home = new Home();
    }

    private void initPager(){

        childViewPager.setParentPager(this.parentPager);
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(Care.getInstance());
        list.add(Recommend.getInstance());
        childViewPager.setAdapter(new HomePagerAdapter(getChildFragmentManager(),list));
        childViewPager.setCurrentItem(0);
        childViewPager.addOnPageChangeListener(this);

    }
    @Override
    protected void initView(){
        childViewPager = baseView.findViewById(R.id.v_childviewpager);
        tv_care = baseView.findViewById(R.id.v_text_care);
        tv_recommend = baseView.findViewById(R.id.v_text_recommend);
        tv_care.setTextSize(22);
        tv_recommend.setTextSize(19);
        cv_care = baseView.findViewById(R.id.v_card_care);
        cv_care.setOnClickListener(this);
        cv_recommend = baseView.findViewById(R.id.v_card_recommend);
        cv_recommend.setOnClickListener(this);
        switchView = baseView.findViewById(R.id.v_home_switch);

        childViewPager.addListenSwitchView(switchView);
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
            tv_care.setTextColor(selectedColor);
            tv_recommend.setTextColor(unSelectedColor);
        }else{
            tv_recommend.setTextSize(23);
            tv_care.setTextSize(20);
            tv_recommend.setTextColor(selectedColor);
            tv_care.setTextColor(unSelectedColor);
        }
        switchView.setCurrentTab(position+1);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.v_card_care:{
                if(childViewPager.getCurrentItem()!=0){
                    childViewPager.setCurrentItem(0);
                }
            }break;
            case R.id.v_card_recommend:{
                if(childViewPager.getCurrentItem()!=1){
                    childViewPager.setCurrentItem(1);
                }
            }break;
        }
    }

}
