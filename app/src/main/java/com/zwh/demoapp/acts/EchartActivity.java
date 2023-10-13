package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.EchartFragment;

public class EchartActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        setToolbarTitle("Echart表格");
        return EchartFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }
}