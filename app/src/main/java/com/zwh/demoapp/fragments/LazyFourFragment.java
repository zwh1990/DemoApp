package com.zwh.demoapp.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zwh.demoapp.R;
import com.zwh.demoapp.base.BaseFragment;

/**
  * @description 懒加载第四页面
  * @author: zhaowh
  * @date: 2023/11/7 15:32
  */
public class LazyFourFragment extends BaseFragment {


    public LazyFourFragment() {
        // Required empty public constructor
    }


    public static LazyFourFragment newInstance() {
        LazyFourFragment fragment = new LazyFourFragment();
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
        return inflater.inflate(R.layout.fragment_lazy_four, container, false);
    }

}