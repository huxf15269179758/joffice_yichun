package com.hy.powerplatform.car_maintain.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.car_maintain.activity.LingLiaoItemDetailActivity;
import com.hy.powerplatform.car_maintain.bean.LingLiaoItem;
import com.hy.powerplatform.my_utils.base.MyApplication;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

/**
 * Created by Administrator on 2018/11/20.
 */

public class LingLiaoListItemAdapter extends RecyclerView.Adapter<LingLiaoListItemAdapter.ViewHolder> {
    public Context context;
    List<LingLiaoItem.DataBean.StockBean> beanList = new ArrayList<>();

    public LingLiaoListItemAdapter(Context context, List<LingLiaoItem.DataBean.StockBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_lingliaoitem, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(context, LingLiaoItemDetailActivity.class);
                intent.putExtra("bean", beanList.get(position));
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContextObject().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvNo.setText(beanList.get(position).getApplyNo());
        holder.tvZNo.setText(beanList.get(position).getMaterialCode());
        holder.tvKNum.setText(beanList.get(position).getNum()+"");
        holder.tvHome.setText(beanList.get(position).getHouseName());
        holder.tvName.setText(beanList.get(position).getMaterialTypeName());
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNo, tvZNo, tvHome, tvKNum, tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNo = (TextView) itemView.findViewById(R.id.tvNo);
            tvZNo = (TextView) itemView.findViewById(R.id.tvZNo);
            tvHome = (TextView) itemView.findViewById(R.id.tvHome);
            tvKNum = (TextView) itemView.findViewById(R.id.tvKNum);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}
