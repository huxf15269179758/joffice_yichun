package com.hy.powerplatform.oa_flow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.oa_flow.bean.FlowMessage;

import java.util.List;

/**
 * Created by CaoJiangtao on 2017/2/8.
 *  列表适配器
 */

public class TestAdapter extends BaseAdapter {

    private Context mContext ;
    private List<FlowMessage> mDataLists ;
    private int mColumnNum = 0 ;
    private int mRowNum = 0 ;

    public TestAdapter() {
    }

    /**
     *  构造函数
     * @param mContext
     * @param mDataLists
     */
    public TestAdapter(Context mContext, List<FlowMessage> mDataLists ) {
        this.mContext = mContext;
        this.mDataLists = mDataLists;
//        this.mColumnNum = columnNum ;
    }

    @Override
    public int getCount() {
        return mDataLists.size();
    }

    @Override
    public FlowMessage getItem(int i) {
        return mDataLists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(mContext).inflate(R.layout.list_row_layout,null);

        LinearLayout row = (LinearLayout) view.findViewById(R.id.listViewRow);  // 行布局
        if(row != null) row.removeAllViews(); // 清空行
        for (int i = 0; i < mDataLists.size() ; i++) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.adapter_flow_message,null);
            TextView tvNum = (TextView) itemView.findViewById(R.id.tvNum);
            TextView tvTask = (TextView) itemView.findViewById(R.id.tvTask);
            TextView tvPerson = (TextView) itemView.findViewById(R.id.tvPerson);
            TextView tvStartTime = (TextView) itemView.findViewById(R.id.tvStartTime);
            TextView tvEndTime = (TextView) itemView.findViewById(R.id.tvEndTime);
            TextView tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            TextView tvAggre = (TextView) itemView.findViewById(R.id.tvAggre);

            FlowMessage itemBean = mDataLists.get(i); // 获取对应的实体类
            if(itemBean != null){
                tvNum.setText(mDataLists.get(i).getNum());
                tvTask.setText(mDataLists.get(i).getTaskName());
                tvPerson.setText(mDataLists.get(i).getPerson());
                tvStartTime.setText(mDataLists.get(i).getStartTime());
                tvEndTime.setText(mDataLists.get(i).getEndTime());
                tvTime.setText(mDataLists.get(i).getTime());
                tvAggre.setText(mDataLists.get(i).getAggre());
                // 添加到行布局中去
                row.addView(itemView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
            }
        }
        return view;  // 返回加载好了内容的行布局
    }
}
