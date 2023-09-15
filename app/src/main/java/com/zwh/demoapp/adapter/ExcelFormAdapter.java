package com.zwh.demoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zwh.demoapp.R;
import com.zwh.demoapp.bean.ExcelFormContentBean;
import com.zwh.demoapp.bean.ExcelFormOrderBean;
import com.zwh.demoapp.bean.ExcelFormTitleBean;
import com.zwh.demoapp.utils.LOGUtils;
import com.kelin.scrollablepanel.library.PanelAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhaowh
 * @date: 2023/8/30
 */
public class ExcelFormAdapter extends PanelAdapter {
    private static final int TITLE = 0;
    private static final int CONTENT_TYPE = 1;
    private static final int TITLE_TYPE = 2;
    private static final int ORDER_TYPE = 3;
    private static final String TAG = ExcelFormAdapter.class.getSimpleName();

    private Context mCxt;
    private List<ExcelFormTitleBean> titleList = new ArrayList<>();
    private List<ExcelFormOrderBean> orderList = new ArrayList<>();
    private List<List<ExcelFormContentBean>> contentList = new ArrayList<>();


    public ExcelFormAdapter(Context mCxt, List<ExcelFormTitleBean> titleList,
                            List<ExcelFormOrderBean> orderList,
                            List<List<ExcelFormContentBean>> contentList) {
        this.mCxt = mCxt;
        this.titleList = titleList;
        this.orderList = orderList;
        this.contentList = contentList;
    }

    @Override
    public int getRowCount() {
        return orderList.size() + 1;
    }

    @Override
    public int getColumnCount() {
        return titleList.size() + 1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int row, int column) {
        LOGUtils.w(TAG, "row--->" + row);
        LOGUtils.w(TAG, "column--->" + column);
        int viewType = getItemViewType(row, column);
        switch (viewType) {
            case TITLE_TYPE:
                ExcelFormTitleBean excelFormTitleBean = titleList.get(column - 1);
                TitleTypeViewHolder typeViewHolder = (TitleTypeViewHolder) viewHolder;
                typeViewHolder.setTvTitle(excelFormTitleBean.getTitle());
                typeViewHolder.setTvBeforeYear(excelFormTitleBean.getBeforeYear());
                typeViewHolder.setTvAfterYear(excelFormTitleBean.getAfterYear());
                break;
            case CONTENT_TYPE:

                break;
            case ORDER_TYPE:
                ExcelFormOrderBean orderBean = orderList.get(row - 1);
                OrderViewHolder orderViewHolder = (OrderViewHolder) viewHolder;
                orderViewHolder.setTvTitle(orderBean.getDepName());
                break;
            case TITLE:
                break;
            default:
                break;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TITLE_TYPE:
                return new TitleTypeViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_crime_case_title_type, parent, false));
            case CONTENT_TYPE:
                return new ContentViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_crime_case_content, parent, false));
            case ORDER_TYPE:
                return new OrderViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_crime_case_dep, parent, false));
            case TITLE:
                return new TitleViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_crime_case_title, parent, false));
            default:
                break;
        }
        return null;
    }

    public int getItemViewType(int row, int column) {
        if (column == 0 && row == 0) {
            return TITLE;
        }
        if (column == 0) {
            return ORDER_TYPE;
        }
        if (row == 0) {
            return TITLE_TYPE;
        }
        return CONTENT_TYPE;
    }

    /**
     * 标题栏
     */
    class TitleTypeViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvBeforeYear;
        private TextView tvAfterYear;

        public TitleTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvBeforeYear = itemView.findViewById(R.id.tv_before_year);
            tvAfterYear = itemView.findViewById(R.id.tv_after_year);
        }

        public void setTvTitle(String title) {
            this.tvTitle.setText(title);
        }

        public void setTvBeforeYear(String beforeYear) {
            tvBeforeYear.setText(beforeYear);
        }

        public void setTvAfterYear(String afterYear) {
            tvAfterYear.setText(afterYear);
        }
    }

    /**
     * 内容栏
     */
    class ContentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvContent;

        public ContentViewHolder(@NonNull View itemView) {
            super(itemView);
//            tvContent = itemView.findViewById(R.id.tv_content);
        }
    }

    /**
     * 标题
     */
    class TitleViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }


    /**
     * 名称
     */
    class OrderViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }

        public void setTvTitle(String title) {
            tvTitle.setText(title);
        }
    }


}
