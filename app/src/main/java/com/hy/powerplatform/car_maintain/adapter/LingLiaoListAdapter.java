package com.hy.powerplatform.car_maintain.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.car_maintain.activity.LingLiaoItemActivity;
import com.hy.powerplatform.car_maintain.bean.LingLiao;
import com.hy.powerplatform.my_utils.base.MyApplication;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by Administrator on 2018/11/20.
 */

public class LingLiaoListAdapter extends RecyclerView.Adapter<LingLiaoListAdapter.ViewHolder> {
    public Context context;
    List<LingLiao.ResultBean> beanList = new ArrayList<>();

    public LingLiaoListAdapter(Context context, List<LingLiao.ResultBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_maintain_list, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(context, LingLiaoItemActivity.class);
                intent.putExtra("bean", beanList.get(position));
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContextObject().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvCode.setText(beanList.get(position).getMeasureBusNo());
        holder.tvCarDode.setText(beanList.get(position).getCarCode());
        holder.tvDriver.setText(beanList.get(position).getDriverName());
//        String type = beanList.get(position).getStatus();
//        if (type.equals("0")){
//            holder.tvType.setVisibility(View.GONE);
//            holder.tvType1.setVisibility(View.VISIBLE);
//            holder.tvType1.setText("未派单");
//        }else {
        holder.tvType.setVisibility(View.VISIBLE);
        holder.tvType1.setVisibility(View.GONE);
        holder.tvType.setText("已派单");
//        }
        holder.tvTime.setText(beanList.get(position).getCheckDate());
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCode, tvCarDode, tvDriver, tvType, tvType1, tvTime;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCode = (TextView) itemView.findViewById(R.id.tvCode);
            tvCarDode = (TextView) itemView.findViewById(R.id.tvcarCode);
            tvDriver = (TextView) itemView.findViewById(R.id.tvDriver);
            tvType = (TextView) itemView.findViewById(R.id.tvType);
            tvType1 = (TextView) itemView.findViewById(R.id.tvType1);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
        }
    }
}
