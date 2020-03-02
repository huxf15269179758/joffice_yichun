package com.hy.powerplatform.oa_flow.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.oa_flow.bean.Back;
import com.hy.powerplatform.oa_flow.bean.FlowList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/9.
 */

public class FlowContractPayListAdapter1 extends RecyclerView.Adapter<FlowContractPayListAdapter1.ViewHolder> {
    public OnGetAdapterPositionListener onGetAdapterPositionListener;
    List<FlowList.DataBean.ContentBean> beanList = new ArrayList<>();
    List<Back.ResultBean> beanList1 = new ArrayList<>();
    Context context;
    public FlowContractPayListAdapter1(FragmentActivity activity, List<Back.ResultBean> beanList) {
        this.beanList1 = beanList;
        this.context = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_flowlist1,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(beanList1.get(position).getSubject());
        String status = beanList1.get(position).getStatus();
        if (status.equals("0")){
            holder.tvNum.setText("未确认");
        }else if (status.equals("1")){
            holder.tvNum.setText("确认中");
        }else if (status.equals("2")||status.equals("3")){
            holder.tvNum.setText("已确认");
        }
        holder.mPosition = position;
    }

    @Override
    public int getItemCount() {
        return beanList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView,tvNum;
        View itemView;
        int mPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            textView = (TextView) itemView.findViewById(R.id.textView);
            tvNum = (TextView) itemView.findViewById(R.id.tvNum);
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
