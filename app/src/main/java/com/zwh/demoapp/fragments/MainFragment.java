package com.zwh.demoapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zwh.demoapp.R;
import com.zwh.demoapp.acts.CustomCanvasViewActivity;
import com.zwh.demoapp.acts.DecodeQrCodeActivity;
import com.zwh.demoapp.acts.EchartActivity;
import com.zwh.demoapp.acts.EncodeQrCodeActivity;
import com.zwh.demoapp.acts.ExcelFormActivity;
import com.zwh.demoapp.acts.FloatActivity;
import com.zwh.demoapp.acts.GetSensorDataActivity;
import com.zwh.demoapp.acts.InstallApkActivity;
import com.zwh.demoapp.acts.LazyPageActivity;
import com.zwh.demoapp.acts.PictureGraffitiActivity;
import com.zwh.demoapp.acts.ZipActivity;
import com.zwh.demoapp.base.BaseFragment;
import com.zwh.demoapp.utils.LOGUtils;

import butterknife.OnClick;

/**
 * @description 主页面
 * @author: zhaowh
 * @date: 2023/9/14 9:23
 */
public class MainFragment extends BaseFragment {

    private static final String TAG = MainFragment.class.getSimpleName();

    public MainFragment() {
        // Required empty public constructor
    }


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @OnClick({
            R.id.bt_to_down,
            R.id.bt_install_apk,
            R.id.bt_encode_qr_code,
            R.id.bt_decode_qr_code,
            R.id.bt_zip,
            R.id.bt_send_broadcast,
            R.id.bt_lazy_page,
            R.id.bt_excel_form,
            R.id.bt_picture_graffiti,
            R.id.bt_get_sensor_data,
            R.id.bt_echart,
            R.id.bt_custom_view,
            R.id.bt_float,
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_to_down:
                Log.w(TAG, "bt_to_down--->");
                dialog();
                break;
            case R.id.bt_install_apk:
                startActivity(new Intent(getContext(), InstallApkActivity.class));
                break;
            case R.id.bt_encode_qr_code:
                startActivity(new Intent(getContext(), EncodeQrCodeActivity.class));
                break;
            case R.id.bt_decode_qr_code:
                startActivity(new Intent(getContext(), DecodeQrCodeActivity.class));
                break;
            case R.id.bt_zip:
                startActivity(new Intent(getContext(), ZipActivity.class));
                break;
            case R.id.bt_send_broadcast:
                getActivity().sendBroadcast(new Intent("cybertech.pstore.intent.action.EXIT"));
                break;
            case R.id.bt_lazy_page:
                startActivity(new Intent(getContext(), LazyPageActivity.class));
                break;
            case R.id.bt_excel_form:
                startActivity(new Intent(getContext(), ExcelFormActivity.class));
                break;
            case R.id.bt_picture_graffiti:
                startActivity(new Intent(getContext(), PictureGraffitiActivity.class));
                break;
            case R.id.bt_get_sensor_data:
                startActivity(new Intent(getContext(), GetSensorDataActivity.class));
                break;
            case R.id.bt_echart:
                startActivity(new Intent(getContext(), EchartActivity.class));
                break;
            case R.id.bt_custom_view:
                startActivity(new Intent(getContext(), CustomCanvasViewActivity.class));
                break;
            case R.id.bt_float:
                startActivity(new Intent(getContext(), FloatActivity.class));
                break;
            default:
                break;
        }
    }


    private void dialog() {
        new MaterialDialog.Builder(getContext())
                .title("签收")
                .titleColorRes(R.color.colorAccent)
                .content("您确定要签收吗?")
                .positiveText("确定")
                .negativeText("取消")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        LOGUtils.w(TAG, "onClick --->");
                    }
                })
                .show();
    }
}