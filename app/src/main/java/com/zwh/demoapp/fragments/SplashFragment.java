package com.zwh.demoapp.fragments;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Setting;
import com.zwh.demoapp.R;
import com.zwh.demoapp.acts.MainActivity;
import com.zwh.demoapp.base.BaseFragment;
import com.zwh.demoapp.utils.LOGUtils;
import com.zwh.demoapp.utils.RuntimeRationale;

import java.util.List;

import com.yanzhenjie.permission.Action;

/**
 * @description 启动页
 * @author: zhaowh
 * @date: 2023/10/19 9:09
 */
public class SplashFragment extends BaseFragment {

    private static final String TAG = SplashFragment.class.getSimpleName();
    private static final int REQUEST_CODE_PERMISSION_SD = 100;
    private static final int REQUEST_CODE_SETTING = 200;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public SplashFragment() {
        // Required empty public constructor
    }

    public static SplashFragment newInstance() {
        SplashFragment fragment = new SplashFragment();
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
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        getPermission();
    }

    private void getPermission() {
        AndPermission.with(this)
                .runtime()
                .permission(Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                )
                .rationale(new RuntimeRationale())
                .onGranted(new Action<List<String>>() {

                    @Override
                    public void onAction(List<String> permissions) {
                        LOGUtils.w(TAG, "size1--->" + permissions.toString());
                        LOGUtils.initLog();
                        singleSignOn();
                    }
                })
                .onDenied(new Action<List<String>>() {
                    @Override
                    public void onAction(@NonNull List<String> permissions) {
                        LOGUtils.w(TAG, "size2--->" + permissions.toString());
                        if (AndPermission.hasAlwaysDeniedPermission(getContext(), permissions)) {
                            showSettingDialog(getContext(), permissions);
                        }
                    }
                })
                .start();

    }

    private void singleSignOn() {
        mHandler.postDelayed((Runnable) () -> skipActivity(), 1000L);
    }

    private void skipActivity() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }

    private void showSettingDialog(Context context, final List<String> permissions) {
        List<String> permissionNames = Permission.transformText(context, permissions);
        String message = context.getString(R.string.message_permission_always_failed, TextUtils.join("\n", permissionNames));

        new AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle(R.string.permissions_dialog)
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setPermission();
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }

    /**
     * Set permissions.
     */
    private void setPermission() {
        AndPermission.with(this)
                .runtime()
                .setting()
                .onComeback(new Setting.Action() {
                    @Override
                    public void onAction() {
                    }
                })
                .start();
    }
}