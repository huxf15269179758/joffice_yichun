package com.hy.powerplatform.login.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.hy.powerplatform.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/5/17.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    List<String> listDepartment = new ArrayList<>();
    String str;
    Context context;
    private String[] generalsTypes;
    private String[][] generals;

    public ExpandableListAdapter (List<String> listDepartment,String str,Context context){
        this.listDepartment = listDepartment;
        this.str = str;
        this.context = context;
        int size = listDepartment.size();
        generalsTypes = (String[]) listDepartment.toArray(new String[size]);
    }

    public ExpandableListAdapter() {
    }

    //重写ExpandableListAdapter中的各个方法
    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return generalsTypes.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        return generalsTypes[groupPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        return generals[groupPosition].length;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return generals[groupPosition][childPosition];
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_item, null);
        }
        TextView text = (TextView) convertView.findViewById(R.id.parent_title);
        text.setText(getGroup(groupPosition).toString());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_item, null);
        }
        TextView tvPhone = (TextView) convertView.findViewById(R.id.tvPhone);
        tvPhone.setText(getChild(groupPosition, childPosition)
                .toString());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition,
                                     int childPosition) {
        // TODO Auto-generated method stub
        return true;
    }

    public void refresh(){
        handler.sendMessage(new Message());
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            notifyDataSetChanged();
        }
    };
}
