package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.EncodeQrCodeFragment;

public class EncodeQrCodeActivity extends BaseActivity{

    @Override
    protected Fragment createFragment() {
        setToolbarTitle("二维码编码");
        return EncodeQrCodeFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }
}