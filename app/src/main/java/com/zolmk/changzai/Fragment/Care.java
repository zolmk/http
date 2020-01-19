package com.zolmk.changzai.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zolmk.changzai.Adapter.CareListAdapter;
import com.zolmk.changzai.Beans.ThinkBean;
import com.zolmk.changzai.R;

import java.util.ArrayList;
import java.util.List;

public class Care extends Fragment{
    private Activity parentActivity;
    private static Care mCare = null;

    private RecyclerView recyclerView;
    private CareListAdapter careListAdapter;

    @Override
    public void onAttach(Context context) {
        parentActivity = (Activity)context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_care,container,false);
        init();
        initView(root);
        return root;
    }
    public static Care getInstance(){
        return Care.Inner.Care;
    }
    private static class Inner{
        private static final Care Care = new Care();
    }

    private void init(){

    }
    private void initView(View root){

        recyclerView = root.findViewById(R.id.rv_care);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        List<ThinkBean> beans = new ArrayList<>();
        ThinkBean thinkBean1 = new ThinkBean();
        thinkBean1.setImgNumber(1);
        ThinkBean thinkBean2 = new ThinkBean();
        thinkBean2.setImgNumber(3);
        ThinkBean thinkBean3 = new ThinkBean();
        thinkBean3.setImgNumber(4);
        ThinkBean thinkBean4 = new ThinkBean();
        thinkBean4.setImgNumber(0);
        ThinkBean thinkBean5 = new ThinkBean();
        thinkBean5.setImgNumber(2);
        ThinkBean thinkBean6 = new ThinkBean();
        thinkBean6.setImgNumber(4);

        beans.add(thinkBean1);
        beans.add(thinkBean2);
        beans.add(thinkBean3);
        beans.add(thinkBean4);
        beans.add(thinkBean5);
        beans.add(thinkBean6);
        careListAdapter = new CareListAdapter(getContext(),beans);
        recyclerView.setAdapter(careListAdapter);
        recyclerView.setItemViewCacheSize(4);
    }


}
