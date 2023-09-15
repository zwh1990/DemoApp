package com.zwh.demoapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.zwh.demoapp.R;
import com.zwh.demoapp.base.BaseFragment;
import com.zwh.demoapp.vp.LazyFragmentPagerAdapter;
import com.zwh.demoapp.vp.LazyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @description 懒加载页面
 * @author: zhaowh
 * @date: 2023/9/15 9:27
 */
public class LazyPageFragment extends BaseFragment {

    @BindView(R.id.lazyVp)
    LazyViewPager lazyVp;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    private CustomLazyFragmentPagerAdapter adapter;
    private MenuItem menuItem;

    public LazyPageFragment() {
        // Required empty public constructor
    }

    public static LazyPageFragment newInstance() {
        LazyPageFragment fragment = new LazyPageFragment();
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
        return inflater.inflate(R.layout.fragment_lazy_page, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        adapter = new CustomLazyFragmentPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new LazyOneFragment());
        adapter.addFragment(new LazyTwoFragment());
        adapter.addFragment(new LazyThreeFragment());
        lazyVp.addOnPageChangeListener(mPageChangeListener);
        lazyVp.setAdapter(adapter);
    }

    private static class CustomLazyFragmentPagerAdapter extends LazyFragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();

        private CustomLazyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(ViewGroup container, int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.nav_no_visit:
                lazyVp.setCurrentItem(0);
                return true;

            case R.id.nav_need_follow_up:
                lazyVp.setCurrentItem(1);
                return true;

            case R.id.nav_already_visit:
                lazyVp.setCurrentItem(2);
                return true;

            default:
                break;
        }
        return false;
    };

    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (menuItem != null) {
                menuItem.setChecked(false);
            } else {
                navigation.getMenu().getItem(0).setChecked(false);
            }
            menuItem = navigation.getMenu().getItem(position);
            menuItem.setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}