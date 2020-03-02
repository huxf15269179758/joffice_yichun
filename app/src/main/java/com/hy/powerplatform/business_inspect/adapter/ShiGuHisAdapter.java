package com.hy.powerplatform.business_inspect.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.activity.ShiGuCheckActivity;
import com.hy.powerplatform.business_inspect.bean.ShiGuHis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/6/15.
 */

public class ShiGuHisAdapter extends RecyclerView.Adapter<ShiGuHisAdapter.ViewHolder> {
    private Context context;
    List<ShiGuHis.ResultBean> beanList = new ArrayList<>();
    public ShiGuHisAdapter(Context context, List<ShiGuHis.ResultBean> hisList) {
        this.context = context;
        this.beanList = hisList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_shigu_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvDirve.setText(beanList.get(position).getDriverName());
        holder.tvTime.setText(beanList.get(position).getAtAtDate());
        holder.tvAddress.setText(beanList.get(position).getAtPlace());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShiGuCheckActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("content",beanList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTime,tvAddress,tvDirve,tvCheck;
        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvAddress = (TextView) itemView.findViewById(R.id.tvAddress);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvDirve = (TextView) itemView.findViewById(R.id.tvDirve);
            tvCheck = (TextView) itemView.findViewById(R.id.tvCheck);
        }
    }
}
