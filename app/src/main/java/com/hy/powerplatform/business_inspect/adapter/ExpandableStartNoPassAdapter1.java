package com.hy.powerplatform.business_inspect.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.login.bean.Type;
import com.hy.powerplatform.my_utils.base.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/5/23.
 */

public class ExpandableStartNoPassAdapter1 extends BaseExpandableListAdapter {

    private List<String> gData;
    private List<List<Type>> iData;
    private Context mContext;
    private Handler handler;
    List<String> typeList = new ArrayList<>();

    private MyClickListener mListener1;

    //自定义接口，用于回调按钮点击事件到Activity
    public interface MyClickListener{
        public void clickListener(View v);
    }
    public void setOnInnerItemOnClickListener1(MyClickListener listener){
        this.mListener1=listener;
    }

    public ExpandableStartNoPassAdapter1(Context context, List<String> gData, List<List<Type>> iData, Handler handler) {
        this.mContext = context;
        this.gData = gData;
        this.iData = iData;
        this.handler = handler;
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
        return iData.get(groupPosition).get(childPosition).name;
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
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final ViewHolderItem itemHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.adapter_inspectstarte, parent, false);
            itemHolder = new ViewHolderItem();
            itemHolder.tvName= (TextView) convertView.findViewById(R.id.tvName);
            itemHolder.llPass = (LinearLayout) convertView.findViewById(R.id.llPass);
            itemHolder.llNoPass = (LinearLayout) convertView.findViewById(R.id.llNoPass);
            itemHolder.ivPass = (ImageView) convertView.findViewById(R.id.ivPass);
            itemHolder.ivNoPass = (ImageView) convertView.findViewById(R.id.ivNoPass);
            itemHolder.tvGet = (Button) convertView.findViewById(R.id.tvGet);
            convertView.setTag(itemHolder);
        }else{
            itemHolder = (ViewHolderItem) convertView.getTag();
        }
        itemHolder.tvName.setText(iData.get(groupPosition).get(childPosition).name);

        itemHolder.tvGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                itemHolder.tvGet.setTag(childPosition);
//                mListener1.clickListener(v);
                Message message = new Message();
                message.what = Constant.TAG_THERE;
                Bundle bundle = new Bundle();
                bundle.putString("groupPosition", String.valueOf(groupPosition));
                bundle.putString("childPosition", String.valueOf(childPosition));
                message.setData(bundle);
                handler.sendMessage(message);
            }
        });

        itemHolder.llNoPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemHolder.ivNoPass.setImageResource(R.drawable.check);
                itemHolder.ivPass.setImageResource(R.drawable.nocheck);
                itemHolder.llNoPass.setEnabled(false);
                itemHolder.llPass.setEnabled(false);
                Message message = new Message();
                message.what = Constant.TAG_FOUR;
                Bundle bundle = new Bundle();
                bundle.putString("groupPosition", String.valueOf(groupPosition));
                bundle.putString("childPosition", String.valueOf(childPosition));
                message.setData(bundle);
                handler.sendMessage(message);
            }
        });

        return convertView;
    }

    //设置子列表是否可选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private static class ViewHolderGroup{
        private TextView tvContent;
    }

    private static class ViewHolderItem{
        public TextView  tvName;
        LinearLayout llPass,llNoPass;
        ImageView ivPass,ivNoPass;
        public Button tvGet;
    }
}
