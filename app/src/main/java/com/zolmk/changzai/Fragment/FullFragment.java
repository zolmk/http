package com.zolmk.changzai.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zolmk.changzai.Utils.StatusBarUtil;

public abstract class FullFragment extends Fragment {
    protected View baseView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        baseView = inflater.inflate(getLayoutId(),container,false);
        setPlaceView();
        init();
        return baseView;
    }
    public void setPlaceView(){
        View placeView = baseView.findViewById(getPlaceViewId());
        ViewGroup.LayoutParams params = placeView.getLayoutParams();
        params.width = 0;
        params.height = StatusBarUtil.getTitleHeight(getContext());
        placeView.setLayoutParams(params);
    }
    protected abstract void init();
    public abstract int getPlaceViewId();
    public abstract int getLayoutId();
}
