package com.hy.powerplatform.login.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.login.bean.MainData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/6/5.
 */

public class MainDataAdapter extends RecyclerView.Adapter<MainDataAdapter.ViewHolder> {
    public OnGetAdapterPositionListener onGetAdapterPositionListener;
    List<MainData.DataBean> beanList = new ArrayList<>();
    List<Integer> imageList = new ArrayList<>();
    String tag,num;
    Context context;
    public MainDataAdapter(Context context, List<MainData.DataBean> mainDataList,List<Integer> imageList,String tag,String num) {
        this.context = context;
        this.beanList = mainDataList;
        this.imageList = imageList;
        this.tag = tag;
        this.num = num;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_maindata,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(beanList.get(position).getModuleName());
        holder.imageView.setImageResource(imageList.get(position));
        if (beanList.get(position).getModuleName().equals("待办流程")&&num!=null&&!num.equals("")&&Integer.valueOf(num)!=0){
            holder.tvRolese.setVisibility(View.VISIBLE);
            holder.tvRolese.setText(num);
        }
        holder.mPosition = position;
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public TextView tvRolese;
        int mPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            tvRolese = (TextView) itemView.findViewById(R.id.tvRolese);
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
