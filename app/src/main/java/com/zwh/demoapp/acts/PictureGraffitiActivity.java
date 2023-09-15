package com.zwh.demoapp.acts;

import androidx.fragment.app.Fragment;

import com.zwh.demoapp.base.BaseActivity;
import com.zwh.demoapp.fragments.PictureGraffitiFragment;

/**
  * @description 图片涂鸦
  * @author: zhaowh
  * @date: 2023/9/12 13:47
  */
public class PictureGraffitiActivity extends BaseActivity {

    private static final String TAG = PictureGraffitiActivity.class.getSimpleName();

    @Override
    protected Fragment createFragment() {
        setToolbarTitle("涂鸦页面");
        return PictureGraffitiFragment.newInstance();
    }

    @Override
    protected boolean useBackPressed() {
        return true;
    }

}