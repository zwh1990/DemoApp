package com.zwh.demoapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zwh.demoapp.R;
import com.zwh.demoapp.base.BaseFragment;
import com.zwh.demoapp.utils.ZipUtils;

import butterknife.OnClick;

/**
 * @description 压缩
 * @author: zhaowh
 * @date: 2023/9/15 9:10
 */
public class ZipFragment extends BaseFragment {

    private static final String TAG = ZipFragment.class.getSimpleName();
    private String temp;

    public ZipFragment() {
        // Required empty public constructor
    }


    public static ZipFragment newInstance() {
        ZipFragment fragment = new ZipFragment();
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
        return inflater.inflate(R.layout.fragment_zip, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick({R.id.bt_zip,R.id.bt_unzip})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.bt_zip:
                String content = "jsafljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看看safljsdoeiuoksjdfpwrp3oiruewoifrjewflk我的得到喀喀喀 看看看看看看看看  ";
                Log.w(TAG, "原字符串=" + content);
                Log.w(TAG, "原长=" + content.length());
                temp = ZipUtils.compress(content);
                Log.w(TAG, "压缩后的字符串=" + temp);
                Log.w(TAG, "压缩后的长=" + temp.length());
                break;
            case R.id.bt_unzip:
                Log.w(TAG, "解压后的字符串=" + ZipUtils.uncompress(temp));
                break;
            default:
                break;
        }
    }

}