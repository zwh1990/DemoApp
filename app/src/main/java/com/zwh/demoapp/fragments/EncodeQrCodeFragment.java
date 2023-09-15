package com.zwh.demoapp.fragments;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.zwh.demoapp.R;
import com.zwh.demoapp.base.BaseFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @description 编码页面
 * @author: zhaowh
 * @date: 2023/9/14 14:46
 */
public class EncodeQrCodeFragment extends BaseFragment {

    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.imv)
    ImageView imv;

    public EncodeQrCodeFragment() {
        // Required empty public constructor
    }


    public static EncodeQrCodeFragment newInstance() {
        EncodeQrCodeFragment fragment = new EncodeQrCodeFragment();
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
        return inflater.inflate(R.layout.fragment_encode_qr_code, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @OnClick({R.id.bt_encode})
    public void OnClick(View view) {
        String content = etContent.getText().toString();
        if (TextUtils.isEmpty(content)) {
            content = "哈哈哈哈哈哈哈哈";
        }
        Log.w("TAG", "--->" + content.length());
        Bitmap bmp = createQrCode(getContext(), content);
        imv.setImageBitmap(bmp);
    }


    public static Bitmap createQrCode(Context mCxt, String content) {
        int widthPixels = mCxt.getResources().getDisplayMetrics().widthPixels;
        int width = widthPixels * 1 / 2;
        int height = widthPixels * 1 / 2;
        //HashMap设置二维码参数
        Map map = new HashMap();
        //  设置容错率 L>M>Q>H 等级越高扫描时间越长,准确率越高
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        //设置字符集
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //设置外边距
        map.put(EncodeHintType.MARGIN, 1);
        //利用编码器，生成二维码
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        Bitmap bitmap = null;
        try {
            bitmap = barcodeEncoder.encodeBitmap(content, BarcodeFormat.QR_CODE, width, height, map);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return bitmap;
    }


}