package com.hy.powerplatform.oa_flow.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.oa_flow.bean.FlowMessage1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/9.
 */

public class FlowMessageAdapter extends RecyclerView.Adapter<FlowMessageAdapter.ViewHolder> {
    List<FlowMessage1.DataBean> beanList = new ArrayList<>();
    Context context;
    public FlowMessageAdapter(FragmentActivity context, List<FlowMessage1.DataBean> beanList) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_flowmessage,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvTask.setText(beanList.get(position).getActivityName());
        holder.tvPerson.setText(beanList.get(position).getCreatorName());
        holder.tvStartTime.setText(beanList.get(position).getCreatetime());
        holder.tvEndTime.setText(beanList.get(position).getEndtime());
        holder.tvTime.setText(beanList.get(position).getUsetimes());
        String status = beanList.get(position).getStatus();
        if (status!=null&&status.equals("1")){
            holder.tvType.setText("审批通过");
        }else if (status!=null&&status.equals("-1")){
            holder.tvType.setText("驳回");
        }else if (status!=null&&status.equals("2")){
            holder.tvType.setText("申请提交");
        }else if (status!=null&&status.equals("0")){
            holder.tvType.setText("未审批");
        }else if (status!=null&&status.equals("3")){
            holder.tvType.setText("作废");
        }
        if (beanList.get(position).getComments()!=null){
            holder.tvAggre.setText(beanList.get(position).getComments());
        }
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTask,tvPerson,tvStartTime,tvEndTime,tvTime,tvType,tvAggre;
        View itemView;
        int mPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvTask = (TextView) itemView.findViewById(R.id.tvTaskName);
            tvPerson = (TextView) itemView.findViewById(R.id.tvPerson);
            tvStartTime = (TextView) itemView.findViewById(R.id.tvStartTime);
            tvEndTime = (TextView) itemView.findViewById(R.id.tvEndTime);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvType = (TextView) itemView.findViewById(R.id.tvType);
            tvAggre = (TextView) itemView.findViewById(R.id.tvAgree);
        }
    }
}
