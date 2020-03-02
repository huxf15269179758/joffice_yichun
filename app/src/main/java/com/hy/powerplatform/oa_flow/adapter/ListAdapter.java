package com.hy.powerplatform.oa_flow.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.oa_flow.activity.CaiGouActivity;
import com.hy.powerplatform.oa_flow.activity.CaiWuActivity;
import com.hy.powerplatform.oa_flow.activity.FaWenActivity;
import com.hy.powerplatform.oa_flow.activity.RenZiActivity;
import com.hy.powerplatform.oa_flow.activity.XingZengActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/15.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    List<String> beanList = new ArrayList<>();
    Context context;
    public ListAdapter(FragmentActivity context, List<String> beanList) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_flowlist,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(beanList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (position == 0){
                    intent = new Intent(context, XingZengActivity.class);
                    context.startActivity(intent);
                }
                if (position == 1){
                    intent = new Intent(context, RenZiActivity.class);
                    context.startActivity(intent);
                }
                if (position == 2){
                    intent = new Intent(context, CaiWuActivity.class);
                    context.startActivity(intent);
                }
                if (position == 3){
                    intent = new Intent(context, CaiGouActivity.class);
                    context.startActivity(intent);
                }
                if (position == 4){
                    intent = new Intent(context, FaWenActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView tvNum;
        View itemView;
        int mPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            textView = (TextView) itemView.findViewById(R.id.textView);
            tvNum = (TextView) itemView.findViewById(R.id.tvNum);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onGetAdapterPositionListener.getAdapterPosition(mPosition);
//                }
//            });
        }
    }
}
