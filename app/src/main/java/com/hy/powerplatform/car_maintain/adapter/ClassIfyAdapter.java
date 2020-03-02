package com.hy.powerplatform.car_maintain.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.car_maintain.activity.ClassIfySmallActivity;
import com.hy.powerplatform.car_maintain.bean.ClassIfy;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2018/11/21.
 */

public class ClassIfyAdapter extends RecyclerView.Adapter<ClassIfyAdapter.ViewHolder> {
    Context context;
    List<ClassIfy.ResultBean> dataList = new ArrayList<>();
//    public static CallBackPosition callBackPosition;


//    public interface CallBackPosition{
//         void  myTextViewClient(int position);
//    }
//    public void selectTextViewPosition (CallBackPosition callBackPosition){
//        this.callBackPosition = callBackPosition;
//        getInf();
//    }

//    public static CallBackPosition getInf() {
//        return callBackPosition;
//    }

    public ClassIfyAdapter(Context context, List<ClassIfy.ResultBean> dataList) {
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
        holder.textView.setText(dataList.get(position).getTypeName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ClassIfySmallActivity.class);
                intent.putExtra("Id",String.valueOf(dataList.get(position).getProTypeId()));
                context.startActivity(intent);
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
