package com.zwh.demoapp.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zwh.demoapp.utils.LOGUtils;

/**
 * 底部样式控件
 *
 * @author: zhaowh
 * @date: 2023/10/9
 */
public class BottomStyleView extends View {

    private static final String TAG = BottomStyleView.class.getSimpleName();
    private Paint mLinePaint;
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private Context mCxt;

    public BottomStyleView(Context context) {
        this(context, null);
    }

    public BottomStyleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomStyleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mCxt = context;
        initView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        LOGUtils.w(TAG, "widthMeasureSpec--->" + widthMeasureSpec);
        LOGUtils.w(TAG, "heightMeasureSpec--->" + heightMeasureSpec);
        // 获取宽度的测量模式和大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        // 获取高度的测量模式和大小
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        LOGUtils.w(TAG,"heightSize--->" + heightSize);

        // 根据测量模式设置控件的宽高
        if (widthMode == MeasureSpec.EXACTLY) {
            // 如果宽度是精确模式，则直接使用测量的大小
            mWidth = widthSize;
        } else {
            // 如果宽度是包裹内容模式，则根据内容计算宽度
            mWidth = calculateScreenWidth();
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            // 如果高度是精确模式，则直接使用测量的大小
            mHeight = heightSize;
        } else {
            // 如果高度是包裹内容模式，根据内容计算高度
            mHeight = calculateHeight();
        }

        // 设置控件的测量宽高
        setMeasuredDimension(mWidth, mHeight);
    }

    private int calculateHeight() {
        return 360;
    }

    private int calculateScreenWidth() {
        return mCxt.getResources().getDisplayMetrics().widthPixels;
    }

    private void initView() {
        setBackgroundColor(Color.GRAY);
        mLinePaint = new Paint();
        mLinePaint.setColor(Color.BLACK);
        mLinePaint.setStrokeWidth(2f);
        mLinePaint.setStyle(Paint.Style.STROKE);

        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(2f);
        mPaint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, 100, calculateScreenWidth() / 2 - 100, 100, mLinePaint);
        canvas.drawArc(calculateScreenWidth() / 2 - 141,59,
                calculateScreenWidth() / 2 + 141,341,-135,90,false,mLinePaint);
        canvas.drawLine(calculateScreenWidth() / 2 + 100, 100, calculateScreenWidth(), 100, mLinePaint);

        canvas.drawCircle(calculateScreenWidth() / 2,200,120,mPaint);
    }
}
