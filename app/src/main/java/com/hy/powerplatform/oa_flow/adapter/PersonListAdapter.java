package com.hy.powerplatform.oa_flow.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.oa_flow.bean.PersonList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/15.
 */

public class PersonListAdapter extends RecyclerView.Adapter<PersonListAdapter.ViewHolder> {
    public OnGetAdapterPositionListener onGetAdapterPositionListener;
    List<PersonList> beanList = new ArrayList<>();
    Context context;

    public interface OnGetAdapterPositionListener  {
        void getAdapterPosition(String userName, String userCode, String ProfileId);
    }
    public void sendOnGetAdapterPositionListener(OnGetAdapterPositionListener onGetAdapterPositionListener){
        this.onGetAdapterPositionListener = onGetAdapterPositionListener;
    }

    public PersonListAdapter(FragmentActivity context, List<PersonList> beanList) {
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
        holder.textView.setText(beanList.get(position).getFullname());
        if (onGetAdapterPositionListener!=null) {
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onGetAdapterPositionListener.getAdapterPosition(beanList.get(position).getFullname()
                            ,beanList.get(position).getUserCode(),beanList.get(position).getProfileId());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        View itemView;
        int mPosition;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    public int getPositionForSection(int section) {
        for (int i = 0; i < getItemCount(); i++) {
            String sortStr = beanList.get(i).getLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == section) {
                return i;
            }
        }
        return -1;
    }
}
