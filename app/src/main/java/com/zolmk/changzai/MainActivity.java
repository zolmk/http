package com.zolmk.changzai;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zolmk.changzai.Activity.BaseActivity;
import com.zolmk.changzai.Adapter.MainPagerAdaper;
import com.zolmk.changzai.Fragment.Chat;
import com.zolmk.changzai.Fragment.Find;
import com.zolmk.changzai.Fragment.Home;
import com.zolmk.changzai.Fragment.Me;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager viewPager;
    private TextView tvHome;
    private TextView tvFind;
    private TextView tvChat;
    private TextView tvMe;
    private CardView cvHome;
    private CardView cvFind;
    private CardView cvChat;
    private CardView cvMe;
    private int unSelectedColor;
    private int selectedColor;
    private int currentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();
    }
    private void init(){
        viewPager = (ViewPager)findViewById(R.id.v_parentViewPager);
        Home home = Home.getInstance();
        home.setParentPager(this.viewPager);
        Chat chat = Chat.getInstance();
        Me me = Me.getInstance();
        Find find = Find.getInstance();
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(home);
        list.add(find);
        list.add(chat);
        list.add(me);
        viewPager.setAdapter(new MainPagerAdaper(this.getSupportFragmentManager(),list));
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
        unSelectedColor = Color.parseColor("#555555");
        selectedColor = Color.parseColor("#7db3e0");
        currentPage = 0;
    }
    private void initView(){
        tvChat = findViewById(R.id.text_chat);
        tvFind = findViewById(R.id.text_find);
        tvHome = findViewById(R.id.text_home);
        tvMe = findViewById(R.id.text_user);
        cvChat = findViewById(R.id.v_chat);
        cvChat.setOnClickListener(this);
        cvFind = findViewById(R.id.v_find);
        cvFind.setOnClickListener(this);
        cvHome = findViewById(R.id.v_home);
        cvHome.setOnClickListener(this);
        cvMe = findViewById(R.id.v_user);
        cvMe.setOnClickListener(this);
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (currentPage){
            case 0:{
                tvHome.setTextColor(unSelectedColor);
            }break;
            case 1:{
                tvFind.setTextColor(unSelectedColor);
            }break;
            case 2:{
                tvChat.setTextColor(unSelectedColor);
            }break;
            case 3:{
                tvMe.setTextColor(unSelectedColor);
            }break;
        }
        switch (position){
            case 0:{
                tvHome.setTextColor(selectedColor);
            }break;
            case 1:{
                tvFind.setTextColor(selectedColor);
            }break;
            case 2:{
                tvChat.setTextColor(selectedColor);
            }break;
            case 3:{
                tvMe.setTextColor(selectedColor);
            }break;
        }
        currentPage = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.v_home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.v_find:
                viewPager.setCurrentItem(1);
                break;
            case R.id.v_chat:
                viewPager.setCurrentItem(2);
                break;
            case R.id.v_user:
                viewPager.setCurrentItem(3);
                break;
        }
    }
}
