package com.zwh.demoapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zwh.demoapp.R;
import com.zwh.demoapp.base.BaseFragment;

/**
  * @description echart 图表
  * @author: zhaowh
  * @date: 2023/10/7 14:26
  */
public class EchartFragment extends BaseFragment {


    public EchartFragment() {
        // Required empty public constructor
    }


    public static EchartFragment newInstance() {
        EchartFragment fragment = new EchartFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    protected View inflateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.fragment_echart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}