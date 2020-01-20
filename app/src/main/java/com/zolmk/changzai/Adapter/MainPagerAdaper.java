package com.zolmk.changzai.Adapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MainPagerAdaper extends FragmentPagerAdapter {

    private List<Fragment> list;

    public MainPagerAdaper(FragmentManager fm, List<Fragment> lists){
        super(fm);
        list = lists;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}