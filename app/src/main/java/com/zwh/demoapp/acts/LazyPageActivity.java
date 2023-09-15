package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.LazyPageFragment;

public class LazyPageActivity extends BaseActivity {


    @Override
    protected Fragment createFragment() {
        setToolbarTitle("懒加载页面");
        return LazyPageFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }

}