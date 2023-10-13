package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.FloatFragment;

public class FloatActivity extends BaseActivity {


    @Override
    protected Fragment createFragment() {
        setToolbarTitle("悬浮球效果");
        return FloatFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }
}