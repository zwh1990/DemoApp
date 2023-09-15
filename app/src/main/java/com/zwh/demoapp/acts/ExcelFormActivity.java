package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.ExcelFormFragment;

/**
 * 表格页面
 */
public class ExcelFormActivity extends BaseActivity {

    @Override
    protected Fragment createFragment() {
        setToolbarTitle("表格页面");
        return ExcelFormFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }


}