package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.GetSensorDataFragment;

public class GetSensorDataActivity extends BaseActivity {


    @Override
    protected Fragment createFragment() {
        setToolbarTitle("获取传感器数据");
        return GetSensorDataFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }
}