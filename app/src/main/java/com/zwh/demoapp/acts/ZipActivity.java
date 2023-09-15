package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.ZipFragment;

public class ZipActivity extends BaseActivity {

    private static final String TAG = ZipActivity.class.getSimpleName();

    @Override
    protected Fragment createFragment() {
        setToolbarTitle("压缩页面");
        return ZipFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }


}