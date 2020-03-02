package com.hy.powerplatform.business_inspect.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.bean.CarCode;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dell on 2018/2/27.
 */

public class SelectCarAdapter extends RecyclerView.Adapter<SelectCarAdapter.ViewHolder> {

    private List<CarCode.DataBean> beanList = new ArrayList<>();
    private CallBackPosition callBackPosition;
    List<String> carList = new ArrayList<>();
    String selectCar = "";
    String selectCarAll;

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
        public CheckBox tvNam;
        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvNam = (CheckBox) itemView.findViewById(R.id.tvName);
        }
    }

    public SelectCarAdapter(List<CarCode.DataBean> showMDeptList) {
        this.beanList = showMDeptList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_selectcar, parent, false);
        final ViewHolder holder = new ViewHolder(view);
//        //recyclerView监听事件
        holder.tvNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                holder.tvNam.setChecked(true);
                carList.add(beanList.get(position).getName());
            }
        });
        return holder;
    }

    public String getSelectCar() {
        for (int i = 0 ;i<carList.size();i++){
            selectCar = selectCar+" "+carList.get(i);
        }
        return selectCar;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvNam.setText(beanList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
}