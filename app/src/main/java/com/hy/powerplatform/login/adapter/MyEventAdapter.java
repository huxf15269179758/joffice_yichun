package com.hy.powerplatform.login.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.news.activity.NewsDetailActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;


/**
 * Created by dell on 2018/2/27.
 */

public class MyEventAdapter extends RecyclerView.Adapter<MyEventAdapter.ViewHolder> {
//    List<ShowNotice> showMDeptList = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle,tvTime;
        View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
           // tvContent = (TextView) itemView.findViewById(tvContent);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
           // tvDepartment = (TextView) itemView.findViewById(tvDepartment);
        }
    }

//    public FlowAndEventAdapter(List<ShowNotice> showMDeptList){
//        this.showMDeptList=showMDeptList;
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_myinform,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        //recyclerView监听事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(MyApplication.getContextObject(), NewsDetailActivity.class);
//                ShowNotice showNotice = showMDeptList.get(position);
                intent.putExtra("heard",MyApplication.getContextObject().
                        getResources().getString(R.string.my_information));
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                MyApplication.getContextObject().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.tvTitle.setText("新闻标题");
//        holder.tvContent.setText("各市煤炭管理部门、各省属煤炭企业:为进一步加强全省煤炭生产事中事后监管，严防超能力生产，经研究，省煤炭局决定自即日起开展全省煤矿按核定能力组织生产专项检查。现将有关事项通知如下 ");
//        holder.tvTime.setText("2018.5.4");
//        holder.tvDepartment.setText("研发部");
//        holder.tvTitle.setText(showMDeptList.get(position).title);
//        holder.tvContent.setText(showMDeptList.get(position).content);
//        holder.tvTime.setText(showMDeptList.get(position).time);
//        holder.tvDepartment.setText(showMDeptList.get(position).name);
    }

    @Override
    public int getItemCount() {
//        return showMDeptList.size();
        return 5;
    }
}