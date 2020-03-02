package com.hy.powerplatform.car_maintain.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/11/21.
 */

public class JianChaRenAdapter extends RecyclerView.Adapter<JianChaRenAdapter.ViewHolder> {
    Context context;
    List<String> dataList = new ArrayList<>();
    public static CallBackPosition callBackPosition;


    public interface CallBackPosition{
         void  myTextViewClient(int position);
    }
    public void selectTextViewPosition (CallBackPosition callBackPosition){
        this.callBackPosition = callBackPosition;
        getInf();
    }

    public static CallBackPosition getInf() {
        return callBackPosition;
    }

    public JianChaRenAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_selectdata,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(dataList.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBackPosition.myTextViewClient(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
