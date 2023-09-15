package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.DecodeQrCodeFragment;

public class DecodeQrCodeActivity extends BaseActivity {

    private static final int REQUEST_CODE = 0x100;
    private static final String TAG = DecodeQrCodeActivity.class.getSimpleName();

    @Override
    protected Fragment createFragment() {
        setToolbarTitle("解码");
        return DecodeQrCodeFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }

}