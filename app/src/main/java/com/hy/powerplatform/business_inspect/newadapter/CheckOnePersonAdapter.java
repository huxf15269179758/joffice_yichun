package com.hy.powerplatform.business_inspect.newadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.bean.CheckPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class CheckOnePersonAdapter extends RecyclerView.Adapter<CheckOnePersonAdapter.ViewHolder> {
    Context context;
    private CallBackPosition callBackPosition;
    List<CheckPerson.DataBean> beanList = new ArrayList<>();

    public CheckOnePersonAdapter(Context context, List<CheckPerson.DataBean> checkList) {
        this.context = context;
        this.beanList = checkList;
    }

    public interface CallBackPosition {
        void onItemClick(int position);
    }

    public void setOnItemLitener(CallBackPosition callBackPosition) {
        this.callBackPosition = callBackPosition;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_checkoneperson, parent, false);
        ViewHolder viewHolser = new ViewHolder(view);
        return viewHolser;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvName.setText(beanList.get(position).getFullname());
        holder.position = position;
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBackPosition.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        int position;
        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}
