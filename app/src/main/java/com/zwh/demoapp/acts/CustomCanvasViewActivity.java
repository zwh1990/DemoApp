package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.CustomCanvasViewFragment;

public class CustomCanvasViewActivity extends BaseActivity {


    @Override
    protected Fragment createFragment() {
        setToolbarTitle("Canvas自定义控件");
        return CustomCanvasViewFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }
}