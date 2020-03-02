package com.hy.powerplatform.news.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.RichTextView;
import com.hy.powerplatform.news.activity.NewsDetailActivity;
import com.hy.powerplatform.news.bean.ShowNews;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


/**
 * Created by dell on 2018/2/27.
 */

public class NewsAndNoticeAdapter extends RecyclerView.Adapter<NewsAndNoticeAdapter.ViewHolder> {
    List<ShowNews> showMDeptList = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvTime, tvDepartment;
        private RichTextView tvContent;
        View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvContent = (RichTextView) itemView.findViewById(R.id.tvContent);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            tvDepartment = (TextView) itemView.findViewById(R.id.tvDepartment);
        }
    }

    public NewsAndNoticeAdapter(List<ShowNews> showMDeptList){
        this.showMDeptList=showMDeptList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_newandnotice,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        //recyclerView监听事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(MyApplication.getContextObject(), NewsDetailActivity.class);
                intent.putExtra("heard",MyApplication.getContextObject().
                        getResources().getString(R.string.news_notice));
                intent.putExtra("title",showMDeptList.get(position).title);
                intent.putExtra("content",showMDeptList.get(position).content);
                intent.putExtra("time",showMDeptList.get(position).time);
                intent.putExtra("section",showMDeptList.get(position).section);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContextObject().startActivity(intent);
            }
        });
        holder.tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(MyApplication.getContextObject(), NewsDetailActivity.class);
                intent.putExtra("heard",MyApplication.getContextObject().
                        getResources().getString(R.string.news_notice));
                intent.putExtra("title",showMDeptList.get(position).title);
                intent.putExtra("content",showMDeptList.get(position).content);
                intent.putExtra("time",showMDeptList.get(position).time);
                intent.putExtra("section",showMDeptList.get(position).section);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContextObject().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvTitle.setText(showMDeptList.get(position).title);
        holder.tvContent.setHtml(showMDeptList.get(position).content,500);
        holder.tvTime.setText(showMDeptList.get(position).time);
        holder.tvDepartment.setText(showMDeptList.get(position).section);
    }

    @Override
    public int getItemCount() {
//        return showMDeptList.size();
        return showMDeptList.size();
    }
}