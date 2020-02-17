package com.zolmk.changzai.fragment;


import com.zolmk.changzai.R;

public class Find extends FullFragment{
    private static Find mFind = null;


    @Override
    protected void init() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getPlaceViewId() {
        return R.id.v_find_place;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_find;
    }

    public static Find getInstance(){
        return Find.Inner.Find;
    }
    private static class Inner{
        private static final Find Find = new Find();
    }
}
