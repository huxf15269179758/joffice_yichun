package com.hy.powerplatform.business_inspect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hy.powerplatform.R;

import java.util.List;

/**
 * Created by dell on 2018/5/23.
 */

public class ExpandableStartPassAdapter extends BaseExpandableListAdapter {

    private List<String> gData;
    private List<List<String>> iData;
    private Context mContext;


    public ExpandableStartPassAdapter(Context context, List<String> gData, List<List<String>> iData) {
        this.mContext = context;
        this.gData = gData;
        this.iData = iData;
    }

    @Override
    public int getGroupCount() {
        return gData.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return iData.get(groupPosition).size();
    }

    @Override
    public String getGroup(int groupPosition) {
        return gData.get(groupPosition);
    }

    @Override
    public String getChild(int groupPosition, int childPosition) {
        return iData.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //取得用于显示给定分组的视图. 这个方法仅返回分组的视图对象
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ViewHolderGroup groupHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.adapter_spinneritem, parent, false);
            groupHolder = new ViewHolderGroup();
            groupHolder.tvContent = (TextView) convertView.findViewById(R.id.tvContent);
            convertView.setTag(groupHolder);
        }else{
            groupHolder = (ViewHolderGroup) convertView.getTag();
        }
        groupHolder.tvContent.setText(gData.get(groupPosition));
        return convertView;
    }

    //取得显示给定分组给定子位置的数据用的视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderItem itemHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.adapter_pass_inspectstarte, parent, false);
            itemHolder = new ViewHolderItem();
            itemHolder.tvName= (TextView) convertView.findViewById(R.id.tvName);
//            itemHolder.rbY = (RadioButton) convertView.findViewById(R.id.rbY);
//            itemHolder.rbN = (RadioButton) convertView.findViewById(R.id.rbN);
            itemHolder.tvGet = (Button) convertView.findViewById(R.id.tvGet);
            convertView.setTag(itemHolder);
        }else{
            itemHolder = (ViewHolderItem) convertView.getTag();
        }
        itemHolder.tvName.setText(iData.get(groupPosition).get(childPosition));
//        itemHolder.tvGet.setOnClickListener(this);
//        itemHolder.tvGet.setTag(position);
        return convertView;
    }

    //设置子列表是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class ViewHolderGroup{
        private TextView tvContent;
    }

    private static class ViewHolderItem{
        public TextView  tvName;
        public RadioButton rbY,rbN;
        public Button tvGet;
    }
}
