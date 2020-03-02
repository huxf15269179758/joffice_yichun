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
 * Created by dell on 2018/5/31.
 */

public class ShiGuLeiBieAdapter extends BaseAdapter {
    List<String> datas = new ArrayList<>();
    Context mContext;
    public ShiGuLeiBieAdapter(Context context) {
        this.mContext = context;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas==null?0:datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas==null?null:datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler hodler = null;
        if (convertView == null) {
            hodler = new ViewHodler();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_spinneritem, null);
            hodler.mTextView = (TextView) convertView.findViewById(R.id.tvContent);
            convertView.setTag(hodler);
        } else {
            hodler = (ViewHodler) convertView.getTag();
        }

        hodler.mTextView.setText(datas.get(position));

        return convertView;
    }

    private static class ViewHodler{
        TextView mTextView;
    }
}
