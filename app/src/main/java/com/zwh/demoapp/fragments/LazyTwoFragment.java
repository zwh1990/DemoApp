package com.zwh.demoapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zwh.demoapp.R;
import com.zwh.demoapp.utils.LOGUtils;
import com.zwh.demoapp.vp.LazyFragmentPagerAdapter;


public class LazyTwoFragment extends Fragment implements LazyFragmentPagerAdapter.Laziable{


    private static final String TAG = LazyTwoFragment.class.getSimpleName();

    public LazyTwoFragment() {
        // Required empty public constructor
    }


    public static LazyTwoFragment newInstance() {
        LazyTwoFragment fragment = new LazyTwoFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            LOGUtils.w(TAG,"onCreate --->");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lazy_two, container, false);
    }
}