package com.hy.powerplatform.business_inspect.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.bean.YeWuList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/6/15.
 */

public class YeWuHisAdapter extends RecyclerView.Adapter<YeWuHisAdapter.ViewHolder> {
    private Context context;
    List<YeWuList.ResultBean> beanList = new ArrayList<>();
    public YeWuHisAdapter(Context context, List<YeWuList.ResultBean> hisList) {
        this.context = context;
        this.beanList = hisList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_yewuhis_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvCarNo.setText(beanList.get(position).getCarNo());
        holder.tvJSR.setText(beanList.get(position).getJcr());
        holder.tvDate.setText(beanList.get(position).getJcDate());
        holder.tvXCG.setText(beanList.get(position).getXcgName());
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCarNo,tvJSR,tvDate,tvXCG;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCarNo = (TextView) itemView.findViewById(R.id.tvCarNo);
            tvJSR = (TextView) itemView.findViewById(R.id.tvJSR);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvXCG = (TextView) itemView.findViewById(R.id.tvXCG);
        }
    }
}
