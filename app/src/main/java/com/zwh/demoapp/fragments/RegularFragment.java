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
import com.zwh.demoapp.utils.LOGUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description 正则页面
 * @author: zhaowh
 * @date: 2023/10/24 16:40
 */
public class RegularFragment extends BaseFragment {

    private static final String TAG = RegularFragment.class.getSimpleName();

    public RegularFragment() {
        // Required empty public constructor
    }


    public static RegularFragment newInstance() {
        RegularFragment fragment = new RegularFragment();
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
        return inflater.inflate(R.layout.fragment_regular, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        String regex = "[\\W|\\d]*";
//        String regex = "^(20\\d{2}年\\d{1,2}月\\d{1,2}日)+[\\u4e00-\\u9fa5|\\W|\\d]*(侦查民警)+[\\u4e00-\\u9fa5|\\W|\\d]*(警号)+";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher("2023年02月03日，侦查民警郭*光（警号：084519）");

        String regex = "[\\W]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher1 = pattern.matcher("张");
        Matcher matcher2 = pattern.matcher("，");
        Matcher matcher3 = pattern.matcher(",");
        Matcher matcher4 = pattern.matcher("123");
        Matcher matcher5 = pattern.matcher("A");

        LOGUtils.w(TAG,"matcher1--->"+ matcher1.find());
        LOGUtils.w(TAG,"matcher2--->"+ matcher2.find());
        LOGUtils.w(TAG,"matcher3--->"+ matcher3.find());
        LOGUtils.w(TAG,"matcher4--->"+ matcher4.find());
        LOGUtils.w(TAG,"matcher5--->"+ matcher5.find());
    }


}