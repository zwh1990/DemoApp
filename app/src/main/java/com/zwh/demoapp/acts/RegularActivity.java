package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.RegularFragment;

public class RegularActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        setToolbarTitle("正则判断页面");
        return RegularFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }
}