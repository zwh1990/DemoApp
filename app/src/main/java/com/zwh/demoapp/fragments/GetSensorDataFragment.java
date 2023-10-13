package com.zwh.demoapp.fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.zwh.demoapp.R;
import com.zwh.demoapp.base.BaseFragment;
import com.zwh.demoapp.utils.LOGUtils;

import java.util.List;

import butterknife.OnClick;

/**
 * @description 获取传感器数据页面
 * @author: zhaowh
 * @date: 2023/9/15 16:03
 */
public class GetSensorDataFragment extends BaseFragment {


    private static final String TAG = GetSensorDataFragment.class.getSimpleName();

    public GetSensorDataFragment() {
        // Required empty public constructor
    }


    public static GetSensorDataFragment newInstance() {
        GetSensorDataFragment fragment = new GetSensorDataFragment();
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
        return inflater.inflate(R.layout.fragment_get_sensor_data, container, false);
    }

    @OnClick({R.id.tv_network_speed})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.tv_network_speed:
                ConnectivityManager connectivityManager =
                        (ConnectivityManager) getActivity().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                int type = networkInfo.getType();
                LOGUtils.w(TAG,"type--->" + type);
                if(type == ConnectivityManager.TYPE_WIFI){
                    networkInfo.getState();
                }

                SensorManager sensorManager = (SensorManager) getActivity().getApplicationContext().getSystemService(Context.SENSOR_SERVICE);
                List<Sensor> sensors =  sensorManager.getSensorList(Sensor.TYPE_ALL);
                LOGUtils.w(TAG,"size--->" + sensors.size());
                for (Sensor sensor:sensors) {
                    int type1 = sensor.getType();
                    LOGUtils.w(TAG,"name--->" + sensor.getName());
                    LOGUtils.w(TAG,"type1--->" + type1);
                }
                break;
            default:
                break;
        }
    }

}