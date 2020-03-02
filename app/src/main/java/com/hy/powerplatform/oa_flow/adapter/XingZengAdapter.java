package com.hy.powerplatform.oa_flow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.oa_flow.bean.MyNum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/5.
 */

public class XingZengAdapter extends RecyclerView.Adapter<XingZengAdapter.ViewHolder> {
    Context context;
    List<Integer> imageList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<MyNum.ResultBean> numList = new ArrayList<>();

    public GetAdapterPositin getAdapterPositin;

    public interface GetAdapterPositin{
        void getAdapterPositionV(int position);
    }
    public void sendOnGetAdapterPositionListener(GetAdapterPositin getAdapterPositin){
        this.getAdapterPositin = getAdapterPositin;
    }

    public XingZengAdapter(Context context, List<String> nameList, List<Integer> imageList, List<MyNum.ResultBean> numList){
        this.context = context;
        this.imageList = imageList;
        this.nameList = nameList;
        this.numList = numList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_flowitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(nameList.get(position));
        holder.imageView.setImageDrawable(context.getResources().getDrawable(imageList.get(position)));
        for (int i = 0;i<numList.size();i++){
            if (numList.get(i).getProcessName().equals(nameList.get(position))){
                holder.tvNum.setVisibility(View.VISIBLE);
                holder.tvNum.setText(numList.get(i).getSl());
            }else {
                holder.tvNum.setVisibility(View.GONE);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAdapterPositin.getAdapterPositionV(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView,tvNum;
        View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            tvNum = (TextView) itemView.findViewById(R.id.tvNum);
            this.itemView = itemView;
        }
    }
}
