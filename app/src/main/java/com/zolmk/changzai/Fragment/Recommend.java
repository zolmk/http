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

public class Recommend extends Fragment {
    private Activity parentActivity;
    private static Recommend mRecommend = null;

    @Override
    public void onAttach(Context context) {
        parentActivity = (Activity)context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recommend,container,false);

        return root;
    }
    public static Recommend getInstance(){
        return Recommend.Inner.Recommend;
    }
    private static class Inner{
        private static final Recommend Recommend = new Recommend();
    }
}
