package com.hy.powerplatform.business_inspect.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.bean.CarCode;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dell on 2018/2/27.
 */

public class SelectOneCarAdapter extends RecyclerView.Adapter<SelectOneCarAdapter.ViewHolder> {

    private List<CarCode.DataBean> beanList = new ArrayList<>();
    private CallBackPosition callBackPosition;
    List<String> carList = new ArrayList<>();
    String selectCar;
    Context context;

    public SelectOneCarAdapter(Context context, List<CarCode.DataBean> listCarCodeFromdb) {
        this.context = context;
        this.beanList = listCarCodeFromdb;

    }

    /**
     * 自定义回调接口
     */
    public interface CallBackPosition {
        public void myTextViewClient(int position);
    }

    public void setOnClientMyTextView(CallBackPosition callBackPosition) {
        this.callBackPosition = callBackPosition;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNam;
        View itemView;
        int position;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvNam = (TextView) itemView.findViewById(R.id.tvName);
        }
    }

    public SelectOneCarAdapter(List<CarCode.DataBean> showMDeptList) {
        this.beanList = showMDeptList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_selectonecar, parent, false);
        final ViewHolder holder = new ViewHolder(view);
//        //recyclerView监听事件
        holder.tvNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.position;
                callBackPosition.myTextViewClient(pos);
//                Intent i=new Intent();
//                i.putExtra("bian", beanList.get(position).carName);
//                MyApplication.getContextObject().setResult(4,i);
//                MyApplication.getContextObject().finish();
            }
        });
        return holder;
    }

    public String getSelectCar() {
        return selectCar;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvNam.setText(beanList.get(position).getName());
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
}