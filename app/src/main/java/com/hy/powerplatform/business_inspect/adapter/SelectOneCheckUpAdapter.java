package com.hy.powerplatform.business_inspect.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.bean.CheckUp;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dell on 2018/2/27.
 */

public class SelectOneCheckUpAdapter extends RecyclerView.Adapter<SelectOneCheckUpAdapter.ViewHolder> {

    private List<CheckUp.DataBean> beanList = new ArrayList<>();
    private CallBackPosition callBackPosition;
    List<String> carList = new ArrayList<>();
    String selectCar;
    Context context;

    public SelectOneCheckUpAdapter(Context context, List<CheckUp.DataBean> listCarCodeFromdb) {
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

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvNam = (TextView) itemView.findViewById(R.id.tvName);
        }
    }

    public SelectOneCheckUpAdapter(List<CheckUp.DataBean> showMDeptList) {
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
                int position = holder.getAdapterPosition();
                callBackPosition.myTextViewClient(position);
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
        holder.tvNam.setText(beanList.get(position).getFullname());
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
}