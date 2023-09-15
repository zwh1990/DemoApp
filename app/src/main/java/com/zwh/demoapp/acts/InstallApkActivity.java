package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.InstallApkFragment;

public class InstallApkActivity extends BaseActivity {

    private static final String TAG = InstallApkActivity.class.getSimpleName();


    @Override
    protected Fragment createFragment() {
        setToolbarTitle("安装apk");
        return InstallApkFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }
}