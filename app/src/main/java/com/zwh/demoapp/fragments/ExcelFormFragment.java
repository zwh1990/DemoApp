package com.zwh.demoapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kelin.scrollablepanel.library.ScrollablePanel;
import com.zwh.demoapp.R;
import com.zwh.demoapp.adapter.ExcelFormAdapter;
import com.zwh.demoapp.base.BaseFragment;
import com.zwh.demoapp.bean.ExcelFormContentBean;
import com.zwh.demoapp.bean.ExcelFormOrderBean;
import com.zwh.demoapp.bean.ExcelFormTitleBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
  * @description 表格页面
  * @author: zhaowh
  * @date: 2023/9/15 9:38
  */
public class ExcelFormFragment extends BaseFragment {

    @BindView(R.id.sp_excel_form)
    ScrollablePanel spExcelForm;
    private ExcelFormAdapter mAdapter;

    private List<ExcelFormTitleBean> titleList = new ArrayList<>();
    private List<ExcelFormOrderBean> orderList = new ArrayList<>();
    private List<List<ExcelFormContentBean>> contentLists = new ArrayList<>();

    public ExcelFormFragment() {
        // Required empty public constructor
    }


    public static ExcelFormFragment newInstance() {
        ExcelFormFragment fragment = new ExcelFormFragment();
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
        return inflater.inflate(R.layout.fragment_excel_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
    }

    private void initView() {
        mAdapter = new ExcelFormAdapter(getContext(),titleList,orderList,contentLists);
        spExcelForm.setPanelAdapter(mAdapter);
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            ExcelFormOrderBean orderBean = new ExcelFormOrderBean();
            orderBean.setDepName("单位 " + i);
            orderList.add(orderBean);
        }

        for (int i = 0; i < 10; i++) {
            ExcelFormTitleBean orderBean = new ExcelFormTitleBean();
            orderBean.setTitle("标题 " + i);
            orderBean.setBeforeYear("2020年");
            orderBean.setAfterYear("2022年");
            titleList.add(orderBean);
        }

        for (int i = 0; i < 20; i++) {
            List<ExcelFormContentBean> contentList  = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                ExcelFormContentBean  contentBean = new ExcelFormContentBean();
                contentBean.setValue(i + " " + j);
                contentList.add(contentBean);
            }
            contentLists.add(contentList);
        }
    }


}