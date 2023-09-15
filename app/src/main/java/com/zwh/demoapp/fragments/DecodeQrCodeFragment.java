package com.zwh.demoapp.fragments;

import static com.zwh.demoapp.fragments.HWScanQrCodeFragment.SCAN_RESULT;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.zwh.demoapp.R;
import com.zwh.demoapp.acts.HWScanQrCodeActivity;
import com.zwh.demoapp.base.BaseFragment;
import com.zwh.demoapp.utils.LOGUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @description 解二维码页面
 * @author: zhaowh
 * @date: 2023/9/14 15:06
 */
public class DecodeQrCodeFragment extends BaseFragment {

    private static final int REQUEST_CODE = 0X200;
    private static final String TAG = DecodeQrCodeFragment.class.getSimpleName();

    @BindView(R.id.tv_content)
    TextView tvContent;

    public DecodeQrCodeFragment() {
        // Required empty public constructor
    }


    public static DecodeQrCodeFragment newInstance() {
        DecodeQrCodeFragment fragment = new DecodeQrCodeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    protected View inflateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.fragment_decode_qr_code, container, false);
    }

    @OnClick({R.id.bt_decode_code})
    public void onClick(View view) {
        HWScanQrCodeActivity.launchedSelf(this, REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            String result = data.getStringExtra(SCAN_RESULT);
            LOGUtils.w(TAG, "result--->" + result);
            tvContent.setText(result);
        }
    }
}