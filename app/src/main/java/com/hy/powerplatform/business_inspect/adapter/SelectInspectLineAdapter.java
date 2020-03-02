package com.hy.powerplatform.business_inspect.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.bean.ShowLine;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dell on 2018/2/27.
 */

public class SelectInspectLineAdapter extends RecyclerView.Adapter<SelectInspectLineAdapter.ViewHolder> {

    private List<ShowLine> beanList = new ArrayList<>();
    private CallBackPosition callBackPosition;

    /**
     * 自定义回调接口
     */
    public interface CallBackPosition {
        public void  myTextViewClient(int position);
    }

    public void setOnClientMyTextView(CallBackPosition callBackPosition){
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

    public SelectInspectLineAdapter(List<ShowLine> showMDeptList){
        this.beanList=showMDeptList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_selectonecar,parent,false);
        final ViewHolder holder=new ViewHolder(view);
//        //recyclerView监听事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvNam.setText(beanList.get(position).getLineCode());
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }
}