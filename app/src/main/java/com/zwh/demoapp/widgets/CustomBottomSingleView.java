package com.zwh.demoapp.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.zwh.demoapp.R;

/**
 * @author: zhaowh
 * @date: 2023/11/7
 */
public class CustomBottomSingleView extends LinearLayout {

    private Context mCxt;
    private LinearLayout llContainer;
    private ImageView imv;
    private TextView tvTitle;

    private Drawable mIcon;
    private String title;

    public CustomBottomSingleView(Context context) {
        this(context, null);
    }

    public CustomBottomSingleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public CustomBottomSingleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NavigationSingleView);
        title = typedArray.getString(R.styleable.NavigationSingleView_title);
        mIcon = typedArray.getDrawable(R.styleable.NavigationSingleView_singleIcon);
        typedArray.recycle();
        mCxt = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(mCxt).inflate(R.layout.layout_custom_bottom_single_view, this, true);
        llContainer = findViewById(R.id.ll_container);
        imv = findViewById(R.id.imv);
        tvTitle = findViewById(R.id.tv_title);

        tvTitle.setText(title);
        imv.setImageDrawable(mIcon);
    }


    public void setVisibilityGone() {
        llContainer.setVisibility(GONE);
    }

    public void setSelected(Drawable mIcon) {
        imv.setImageDrawable(mIcon);
        tvTitle.setTextColor(mCxt.getColor(R.color.colorAccent));
    }

    public void clearSelected(Drawable mIcon) {
        imv.setImageDrawable(mIcon);
        tvTitle.setTextColor(mCxt.getColor(R.color.black));
    }


}
