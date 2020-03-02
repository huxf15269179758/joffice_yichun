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
import com.hy.powerplatform.oa_flow.activity.InboxDetailActivity;
import com.hy.powerplatform.oa_flow.bean.Inbox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/15.
 */

public class InboxListAdapter extends RecyclerView.Adapter<InboxListAdapter.ViewHolder> {
    List<Inbox.ResultBean> beanList = new ArrayList<>();
    Context context;
    public InboxListAdapter(FragmentActivity context, List<Inbox.ResultBean> beanList) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_inboxlist,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(beanList.get(position).getMail().getSubject());
        holder.tvPerson.setText(beanList.get(position).getMail().getSender());
        holder.tvTime.setText(beanList.get(position).getMail().getSendTime());
        holder.mPosition = position;
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle,tvPerson,tvTime;
        View itemView;
        int mPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvPerson = (TextView) itemView.findViewById(R.id.tvSendPerson);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, InboxDetailActivity.class);
                    intent.putExtra("content",beanList.get(mPosition).getMail().getContent());
                    intent.putExtra("person",beanList.get(mPosition).getMail().getSender());
                    intent.putExtra("time",beanList.get(mPosition).getSendTime());
                    intent.putExtra("title",beanList.get(mPosition).getMail().getSubject());
                    intent.putExtra("fijian",beanList.get(mPosition).getMail().getFilenames()+"");
                    intent.putExtra("fijianId",beanList.get(mPosition).getMail().getFileIds()+"");
                    context.startActivity(intent);
                }
            });
        }
    }
}
