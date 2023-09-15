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
  * @description 涂鸦页面
  * @author: zhaowh
  * @date: 2023/9/15 9:47
  */
public class PictureGraffitiFragment extends BaseFragment {


    public PictureGraffitiFragment() {
        // Required empty public constructor
    }


    public static PictureGraffitiFragment newInstance() {
        PictureGraffitiFragment fragment = new PictureGraffitiFragment();
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
        return inflater.inflate(R.layout.fragment_picture_graffiti, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}