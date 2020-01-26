package com.zolmk.changzai.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zolmk.changzai.R;

public class Find extends FullFragment{
    private static Find mFind = null;


    @Override
    protected void init() {

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
