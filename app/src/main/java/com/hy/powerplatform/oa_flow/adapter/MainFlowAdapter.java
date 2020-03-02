package com.hy.powerplatform.oa_flow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.oa_flow.activity.MainFlowActivity;
import com.hy.powerplatform.oa_flow.bean.FlowItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/9.
 */

public class MainFlowAdapter extends RecyclerView.Adapter<MainFlowAdapter.ViewHolder> {
    public OnGetAdapterPositionListener onGetAdapterPositionListener;
    List<FlowItem.DataBean> beanList = new ArrayList<>();
    List<Integer> imageList  = new ArrayList<>();
    Context context;
    public MainFlowAdapter(MainFlowActivity mainFlowActivity, List<FlowItem.DataBean> beanList, List<Integer> imageList) {
        this.beanList = beanList;
        this.context = mainFlowActivity;
        this.imageList = imageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_flowitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(beanList.get(position).getModuleName());
        holder.imageView.setImageResource(imageList.get(position));
        holder.mPosition = position;
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        View itemView;
        int mPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
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
