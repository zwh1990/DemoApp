package com.zwh.demoapp.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zwh.demoapp.R;
import com.zwh.demoapp.listeners.OnSelectListener;

/**
 * @author: zhaowh
 * @date: 2023/11/3
 */
public class CustomBottomNavigationView extends LinearLayout implements View.OnClickListener {

    private Context mCxt;

    private LinearLayout llContainer;
    private CustomBottomSingleView cbsvAj;
    private CustomBottomSingleView cbsvRw;
    private CustomBottomSingleView cbsvSh;
    private CustomBottomSingleView cbsvBgc;
    private CustomBottomSingleView cbsvTj;
    private CustomBottomSingleView cbsvMine;

    private OnSelectListener onChangeListener;
    /**
     * 记录扫黑和兵工厂是否显示
     */
    private int count;


    public CustomBottomNavigationView(Context context) {
        this(context, null);
    }

    public CustomBottomNavigationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mCxt = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(mCxt).inflate(R.layout.layout_custom_bottom_navigation, this, true);
        llContainer = findViewById(R.id.ll_container);
        cbsvAj = findViewById(R.id.cbsv_aj);
        cbsvRw = findViewById(R.id.cbsv_rw);
        cbsvSh = findViewById(R.id.cbsv_sh);
        cbsvBgc = findViewById(R.id.cbsv_bgc);
        cbsvTj = findViewById(R.id.cbsv_tj);
        cbsvMine = findViewById(R.id.cbsv_mine);

        cbsvAj.setOnClickListener(this);
        cbsvRw.setOnClickListener(this);
        cbsvSh.setOnClickListener(this);
        cbsvBgc.setOnClickListener(this);
        cbsvTj.setOnClickListener(this);
        cbsvMine.setOnClickListener(this);

        selectAj();
    }

    public void setOnChangeListener(OnSelectListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }

    public void setShVisible() {
        count++;
        cbsvSh.setVisibility(VISIBLE);
    }

    public void setBgcVisible() {
        count++;
        cbsvBgc.setVisibility(VISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cbsv_aj:
                onChangeListener.onSelectPos(0);
                selectAj();
                break;
            case R.id.cbsv_rw:
                onChangeListener.onSelectPos(1);
                selectRw();
                break;
            case R.id.cbsv_sh:
                onChangeListener.onSelectPos(2);
                selectSh();
                break;
            case R.id.cbsv_bgc:
                if(cbsvSh.getVisibility() == VISIBLE){
                    onChangeListener.onSelectPos(3);
                }
                selectBgc();
                break;
            case R.id.cbsv_tj:
                onChangeListener.onSelectPos(2 + count);
                selectTj();
                break;
            case R.id.cbsv_mine:
                onChangeListener.onSelectPos(3 + count);
                selectMine();
                break;
            default:
                break;
        }
    }

    public void selectAj() {
        cbsvAj.setSelected(mCxt.getDrawable(R.drawable.ic_zh_shenp_selected));
        cbsvRw.clearSelected(mCxt.getDrawable(R.drawable.ic_tab_spy));
        cbsvSh.clearSelected(mCxt.getDrawable(R.drawable.ic_clear_evil));
        cbsvBgc.clearSelected(mCxt.getDrawable(R.drawable.ic_armory));
        cbsvTj.clearSelected(mCxt.getDrawable(R.drawable.ic_statistics));
        cbsvMine.clearSelected(mCxt.getDrawable(R.drawable.ic_tab_mine));
    }

    public void selectRw() {
        cbsvAj.clearSelected(mCxt.getDrawable(R.drawable.ic_zh_shenp));
        cbsvRw.setSelected(mCxt.getDrawable(R.drawable.ic_tab_spy_selected));
        cbsvSh.clearSelected(mCxt.getDrawable(R.drawable.ic_clear_evil));
        cbsvBgc.clearSelected(mCxt.getDrawable(R.drawable.ic_armory));
        cbsvTj.clearSelected(mCxt.getDrawable(R.drawable.ic_statistics));
        cbsvMine.clearSelected(mCxt.getDrawable(R.drawable.ic_tab_mine));
    }

    public void selectSh() {
        cbsvAj.clearSelected(mCxt.getDrawable(R.drawable.ic_zh_shenp));
        cbsvRw.clearSelected(mCxt.getDrawable(R.drawable.ic_tab_spy));
        cbsvSh.setSelected(mCxt.getDrawable(R.drawable.ic_clear_evil_selected));
        cbsvBgc.clearSelected(mCxt.getDrawable(R.drawable.ic_armory));
        cbsvTj.clearSelected(mCxt.getDrawable(R.drawable.ic_statistics));
        cbsvMine.clearSelected(mCxt.getDrawable(R.drawable.ic_tab_mine));
    }

    public void selectBgc() {
        cbsvAj.clearSelected(mCxt.getDrawable(R.drawable.ic_zh_shenp));
        cbsvRw.clearSelected(mCxt.getDrawable(R.drawable.ic_tab_spy));
        cbsvSh.clearSelected(mCxt.getDrawable(R.drawable.ic_clear_evil));
        cbsvBgc.setSelected(mCxt.getDrawable(R.drawable.ic_armory_selected));
        cbsvTj.clearSelected(mCxt.getDrawable(R.drawable.ic_statistics));
        cbsvMine.clearSelected(mCxt.getDrawable(R.drawable.ic_tab_mine));
    }

    public void selectTj() {
        cbsvAj.clearSelected(mCxt.getDrawable(R.drawable.ic_zh_shenp));
        cbsvRw.clearSelected(mCxt.getDrawable(R.drawable.ic_tab_spy));
        cbsvSh.clearSelected(mCxt.getDrawable(R.drawable.ic_clear_evil));
        cbsvBgc.clearSelected(mCxt.getDrawable(R.drawable.ic_armory));
        cbsvTj.setSelected(mCxt.getDrawable(R.drawable.ic_statistics_selected));
        cbsvMine.clearSelected(mCxt.getDrawable(R.drawable.ic_tab_mine));
    }

    public void selectMine() {
        cbsvAj.clearSelected(mCxt.getDrawable(R.drawable.ic_zh_shenp));
        cbsvRw.clearSelected(mCxt.getDrawable(R.drawable.ic_tab_spy));
        cbsvSh.clearSelected(mCxt.getDrawable(R.drawable.ic_clear_evil));
        cbsvBgc.clearSelected(mCxt.getDrawable(R.drawable.ic_armory));
        cbsvTj.clearSelected(mCxt.getDrawable(R.drawable.ic_statistics));
        cbsvMine.setSelected(mCxt.getDrawable(R.drawable.ic_tab_mine_selected));
    }

}

