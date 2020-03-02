package com.hy.powerplatform.weekly;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hy.powerplatform.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/5/17.
 */

public class WeeklyListAdapter extends RecyclerView.Adapter<WeeklyListAdapter.ViewHolder> {
    List<WeeklyList> beanList = new ArrayList<>();
    Context context;

    public WeeklyListAdapter(Context context, List<WeeklyList> mainDataList) {
        this.context = context;
        this.beanList = mainDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_smart, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvName.setText(beanList.get(position).getUserName());
        holder.tvDepart.setText(beanList.get(position).getDepName());
        holder.tvDate.setText(beanList.get(position).getDayTime());
        holder.tv2.setText("部门：");
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeeklyList bean = beanList.get(position);
                Intent intent = new Intent(context,WeekDetailActivity.class);
                intent.putExtra("bean",bean);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName,tvDepart,tvDate,tv2;
        public LinearLayout ll;
        int mPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDepart = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDate = (TextView) itemView.findViewById(R.id.tvTime);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
            ll = (LinearLayout) itemView.findViewById(R.id.ll);
        }
    }
}
