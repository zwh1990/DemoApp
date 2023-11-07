package com.zwh.demoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.zwh.demoapp.R;
import com.zwh.demoapp.adapter.ViewPagerAdapter;
import com.zwh.demoapp.base.BaseFragment;
import com.zwh.demoapp.listeners.OnSelectListener;
import com.zwh.demoapp.utils.LOGUtils;
import com.zwh.demoapp.widgets.CustomBottomNavigationView;

import butterknife.BindView;

/**
 * @description 自定义底部导航栏控件
 * @author: zhaowh
 * @date: 2023/11/3 10:13
 */
public class CustomNavigationFragment extends BaseFragment {

    private static final String TAG = CustomNavigationFragment.class.getSimpleName();
    @BindView(R.id.cbnv)
    CustomBottomNavigationView cbnvView;

    @BindView(R.id.vp)
    ViewPager mPager;
    /**
     * viewPager 适配器
     */
    private ViewPagerAdapter adapter;

    public CustomNavigationFragment() {
        // Required empty public constructor
    }


    public static CustomNavigationFragment newInstance() {
        CustomNavigationFragment fragment = new CustomNavigationFragment();
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
        return inflater.inflate(R.layout.fragment_custom_navigation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(LazyOneFragment.newInstance());
        adapter.addFragment(LazyTwoFragment.newInstance());
        adapter.addFragment(LazyThreeFragment.newInstance());
        adapter.addFragment(LazyFourFragment.newInstance());
        mPager.setAdapter(adapter);
        mPager.setOffscreenPageLimit(3);

        cbnvView.setOnChangeListener(new OnSelectListener() {
            @Override
            public void onSelectPos(int pos) {
                LOGUtils.w(TAG, "pos--->" + pos);
                mPager.setCurrentItem(pos);
            }
        });
    }

}