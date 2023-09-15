package com.zwh.demoapp.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zwh.demoapp.R;
import com.zwh.demoapp.base.BaseFragment;
import com.zwh.demoapp.utils.LOGUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @description 安装apk页面
 * @author: zhaowh
 * @date: 2023/9/14 14:24
 */
public class InstallApkFragment extends BaseFragment {

    private static final String TAG = InstallApkFragment.class.getSimpleName();
    private static final int REQUESTCODE = 0X100;
    @BindView(R.id.bt_install)
    Button btInstall;

    public InstallApkFragment() {
        // Required empty public constructor
    }

    public static InstallApkFragment newInstance() {
        InstallApkFragment fragment = new InstallApkFragment();
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
        return inflater.inflate(R.layout.fragment_install_apk, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick({R.id.bt_install})
    public void onClick(View view) {
        installAPK();
    }

    private void installAPK() {
        File apkFile =
                new File(Environment.getExternalStorageDirectory(), "a.apk");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Log.w(TAG, "--->" + apkFile.getName());
            Uri apkUri = FileProvider.getUriForFile(getContext(), getActivity().getPackageName() + ".fileprovider", apkFile);
            Log.w(TAG, "--->" + apkUri.getAuthority());
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        }
        startActivityForResult(intent,REQUESTCODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        LOGUtils.w(TAG,"requestCode--->" + requestCode);
        LOGUtils.w(TAG,"resultCode--->" + resultCode);
        if(resultCode == Activity.RESULT_OK && requestCode == REQUESTCODE){
            btInstall.setText("安装成功");
        }
    }

}