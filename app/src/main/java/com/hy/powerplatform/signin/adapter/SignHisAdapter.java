package com.hy.powerplatform.signin.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.signin.bean.SignHis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/6/15.
 */

public class SignHisAdapter extends RecyclerView.Adapter<SignHisAdapter.ViewHolder> {
    private Context context;
    List<SignHis.ResultBean> beanList = new ArrayList<>();
    public SignHisAdapter(Context context, List<SignHis.ResultBean> hisList) {
        this.context = context;
        this.beanList = hisList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_signhis_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvDate.setText(beanList.get(position).getRq());
        holder.tvTime.setText(beanList.get(position).getSj());
        holder.tvName.setText(beanList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDate,tvTime,tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}
