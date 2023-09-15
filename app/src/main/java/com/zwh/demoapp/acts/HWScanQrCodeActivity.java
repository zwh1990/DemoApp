package com.zwh.demoapp.acts;

import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.HWScanQrCodeFragment;

public class HWScanQrCodeActivity extends BaseActivity {

    public static void launchedSelf(Fragment mCxt,int requestCode) {
        Intent intent = new Intent(mCxt.getContext(), HWScanQrCodeActivity.class);
        mCxt.startActivityForResult(intent,requestCode);
    }

    @Override
    protected Fragment createFragment() {
        setToolbarTitleGone();
        return HWScanQrCodeFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }
}