package com.zwh.demoapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zwh.demoapp.R;
import com.zwh.demoapp.base.BaseFragment;

/**
  * @description 悬浮球效果
  * @author: zhaowh
  * @date: 2023/10/11 9:31
  */
public class FloatFragment extends BaseFragment {


    public FloatFragment() {
        // Required empty public constructor
    }



    public static FloatFragment newInstance() {
        FloatFragment fragment = new FloatFragment();
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
        return inflater.inflate(R.layout.fragment_float, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}