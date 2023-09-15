package com.zwh.demoapp.base;

/**
 * Created by admin on 2018/1/29.
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 1,activity与fragment传值交互
 * 2,初始化fragment公共内容
 */
public abstract class BaseFragment extends Fragment {
    protected Unbinder bind;
    protected View contentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflateView(inflater, container);
        bind = ButterKnife.bind(this, contentView);
        return contentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    protected abstract View inflateView(LayoutInflater inflater, @Nullable ViewGroup container);

    public Object getViewModel() {
        return null;
    }
}
