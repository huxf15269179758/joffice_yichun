package com.hy.powerplatform.business_inspect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hy.powerplatform.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/5/9.
 */

public class SpinnerAdapter extends BaseAdapter {
    Context context;
    private LayoutInflater mInflater;
    List<String> beanList = new ArrayList<>();
    public SpinnerAdapter(Context context, List<String> listType) {
        this.context = context;
        this.beanList = listType;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return beanList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=mInflater.inflate(R.layout.adapter_spinneritem,null);
            viewHolder.tvContent= (TextView) convertView.findViewById(R.id.tvContent);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tvContent.setText(beanList.get(position));
        return convertView;
    }
    class ViewHolder{
        public TextView  tvContent;
    }
}
