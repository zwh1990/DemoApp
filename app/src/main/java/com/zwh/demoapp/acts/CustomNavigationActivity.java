package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.CustomNavigationFragment;

/**
  * @description 自定义底部导航栏控件
  * @author: zhaowh
  * @date: 2023/11/3 10:11
  */
public class CustomNavigationActivity extends BaseActivity {


    @Override
    protected Fragment createFragment() {
        setToolbarTitle("自定义底部导航栏");
        return CustomNavigationFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }

}