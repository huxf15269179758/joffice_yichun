package com.hy.powerplatform.oa_flow.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.oa_flow.bean.FlowList;
import com.hy.powerplatform.oa_flow.bean.MyLeave;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/9.
 */

public class MyFlowListAdapter extends RecyclerView.Adapter<MyFlowListAdapter.ViewHolder> {
    public OnGetAdapterPositionListener onGetAdapterPositionListener;
    List<FlowList.DataBean.ContentBean> beanList = new ArrayList<>();
    List<MyLeave.ResultBean> beanList1 = new ArrayList<>();
    Context context;
    public MyFlowListAdapter(FragmentActivity activity, List<MyLeave.ResultBean> beanList) {
        this.beanList1 = beanList;
        this.context = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_smart,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textTitle.setText(beanList1.get(position).getProcessName());
        holder.textName.setText(beanList1.get(position).getCreator());
        holder.textTime.setText(beanList1.get(position).getCreatetime());
        holder.mPosition = position;
    }

    @Override
    public int getItemCount() {
        return beanList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle,textName,textTime;
        View itemView;
        int mPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            textTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            textName = (TextView) itemView.findViewById(R.id.tvName);
            textTime = (TextView) itemView.findViewById(R.id.tvTime);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onGetAdapterPositionListener.getAdapterPosition(mPosition);
                }
            });
        }
    }

    public interface OnGetAdapterPositionListener  {
        void getAdapterPosition(int position);
    }
    public void sendOnGetAdapterPositionListener(OnGetAdapterPositionListener onGetAdapterPositionListener){
        this.onGetAdapterPositionListener = onGetAdapterPositionListener;
    }
}
