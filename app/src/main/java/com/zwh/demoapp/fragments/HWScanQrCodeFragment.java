package com.zwh.demoapp.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.huawei.hms.hmsscankit.OnResultCallback;
import com.huawei.hms.hmsscankit.RemoteView;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.zwh.demoapp.R;
import com.zwh.demoapp.base.BaseFragment;
import com.zwh.demoapp.utils.LOGUtils;

import java.io.IOException;

import butterknife.Action;
import butterknife.BindView;

/**
 * 华为扫码页面
 */
public class HWScanQrCodeFragment extends BaseFragment implements View.OnClickListener {


    private static final String TAG = HWScanQrCodeFragment.class.getSimpleName();
    public static final String SCAN_RESULT = "scanResult";
    public static final int REQUEST_CODE_PHOTO = 0X1113;
    //The width and height of scan_view_finder is both 240 dp.
    final int SCAN_FRAME_SIZE = 240;

    @BindView(R.id.rim)
    FrameLayout rim;
    @BindView(R.id.imv_back)
    ImageView imvBack;
    @BindView(R.id.img_btn)
    ImageView imgBtn;
    private RemoteView remoteView;
    private int mScreenWidth;
    private int mScreenHeight;

    public HWScanQrCodeFragment() {
        // Required empty public constructor
    }


    public static HWScanQrCodeFragment newInstance() {
        HWScanQrCodeFragment fragment = new HWScanQrCodeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1. Obtain the screen density to calculate the viewfinder's rectangle.
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float density = dm.density;
        //2. Obtain the screen size.
        mScreenWidth = getResources().getDisplayMetrics().widthPixels;
        mScreenHeight = getResources().getDisplayMetrics().heightPixels;

        int scanFrameSize = (int) (SCAN_FRAME_SIZE * density);

        //3. Calculate the viewfinder's rectangle, which in the middle of the layout.
        //Set the scanning area. (Optional. Rect can be null. If no settings are specified, it will be located in the middle of the layout.)
        Rect rect = new Rect();
        rect.left = mScreenWidth / 2 - scanFrameSize / 2;
        rect.right = mScreenWidth / 2 + scanFrameSize / 2;
        rect.top = mScreenHeight / 2 - scanFrameSize / 2;
        rect.bottom = mScreenHeight / 2 + scanFrameSize / 2;


        //Initialize the RemoteView instance, and set callback for the scanning result.
        remoteView = new RemoteView.Builder().setContext(getActivity()).setBoundingBox(rect).setFormat(HmsScan.ALL_SCAN_TYPE).build();
        // When the light is dim, this API is called back to display the flashlight switch.
        // Load the customized view to the activity.
        remoteView.onCreate(savedInstanceState);
        // Subscribe to the scanning result callback event.
        remoteView.setOnResultCallback(new OnResultCallback() {
            @Override
            public void onResult(HmsScan[] result) {
                if (result != null && result.length > 0 && result[0] != null && !TextUtils.isEmpty(result[0].getOriginalValue())) {
                    LOGUtils.w(TAG, "value--->" + result[0].getOriginalValue());
                    Intent intent = new Intent();
                    intent.putExtra(SCAN_RESULT, result[0].getOriginalValue());
                    getActivity().setResult(Activity.RESULT_OK, intent);
                    getActivity().finish();
                }
            }
        });
    }

    @Override
    protected View inflateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.fragment_hw_scan_qr_code, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        imvBack.setOnClickListener(this);
        imgBtn.setOnClickListener(this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        rim.addView(remoteView, params);
    }

    /**
     * Call the lifecycle management method of the remoteView activity.
     */
    @Override
    public void onStart() {
        super.onStart();
        remoteView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        remoteView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        remoteView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        remoteView.onDestroy();
    }

    @Override
    public void onStop() {
        super.onStop();
        remoteView.onStop();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imv_back:
                getActivity().finish();
                break;
            case R.id.img_btn:
                Intent pickIntent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(pickIntent, REQUEST_CODE_PHOTO);
                break;
            default:
                break;
        }
    }

    /**
     * Handle the return results from the album.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_PHOTO) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
                HmsScan[] hmsScans = ScanUtil.decodeWithBitmap(getActivity(), bitmap, new HmsScanAnalyzerOptions.Creator().setPhotoMode(true).create());
                if (hmsScans != null && hmsScans.length > 0 && hmsScans[0] != null && !TextUtils.isEmpty(hmsScans[0].getOriginalValue())) {
                    LOGUtils.w(TAG, "value--->" + hmsScans[0].getOriginalValue());
                    Intent intent = new Intent();
                    intent.putExtra(SCAN_RESULT, hmsScans[0].getOriginalValue());
                    getActivity().setResult(Activity.RESULT_OK, intent);
                    getActivity().finish();
                }
            } catch (IOException exception) {
                LOGUtils.w(TAG, "message--->" + exception.getMessage());
            }
        }
    }
}