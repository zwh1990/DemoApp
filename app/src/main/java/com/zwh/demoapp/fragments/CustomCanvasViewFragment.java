package com.zwh.demoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zwh.demoapp.R;
import com.zwh.demoapp.base.BaseFragment;

/**
  * @description 自定义画布控件
  * @author: zhaowh
  * @date: 2023/10/9 13:31
  */
public class CustomCanvasViewFragment extends BaseFragment {


    public CustomCanvasViewFragment() {
        // Required empty public constructor
    }


    public static CustomCanvasViewFragment newInstance() {
        CustomCanvasViewFragment fragment = new CustomCanvasViewFragment();
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
        return inflater.inflate(R.layout.fragment_custom_canvas_view, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}