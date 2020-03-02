package com.hy.powerplatform.business_inspect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hy.powerplatform.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/5/9.
 */

public class InspectStarteAdapter extends BaseAdapter implements View.OnClickListener{
    Context context;
    private LayoutInflater mInflater;
    List<String> beanList = new ArrayList<>();
    private MyClickListener mListener1;

    //自定义接口，用于回调按钮点击事件到Activity
    public interface MyClickListener{
        public void clickListener(View v);
    }

    public InspectStarteAdapter(Context context, List<String> listType) {
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
            convertView=mInflater.inflate(R.layout.adapter_inspectstarte,null);
            viewHolder.tvName= (TextView) convertView.findViewById(R.id.tvName);
//            viewHolder.rbY = (RadioButton) convertView.findViewById(R.id.rbY);
//            viewHolder.rbN = (RadioButton) convertView.findViewById(R.id.rbN);
            viewHolder.tvGet = (Button) convertView.findViewById(R.id.tvGet);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tvName.setText(beanList.get(position));
        viewHolder.tvGet.setOnClickListener(this);
        viewHolder.tvGet.setTag(position);
        return convertView;
    }

    class ViewHolder{
        public TextView  tvName;
        public RadioButton rbY,rbN;
        public Button tvGet;
    }

    public void setOnInnerItemOnClickListener1(MyClickListener listener){
        this.mListener1=listener;
    }

//    public void onClick(View v) {
//        mListener.itemClick(v);
//    }

    //响应按钮点击事件,调用子定义接口，并传入View
    @Override
    public void onClick(View v) {
        mListener1.clickListener(v);
    }
}
