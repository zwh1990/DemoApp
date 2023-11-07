package com.zwh.demoapp.acts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment createFragment() {
        setToolbarTitle("首页");
        return MainFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return false;
    }
}
