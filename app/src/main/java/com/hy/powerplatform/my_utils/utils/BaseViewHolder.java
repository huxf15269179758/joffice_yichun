package com.hy.powerplatform.my_utils.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.RichTextView;

/**
 * Created by Administrator on 2019/4/12.
 * 通用adapter的viewholder
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews; //用来存储控件
    private View mConvertView;
    private Context mContext;

    public BaseViewHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<View>();
    }

    /**
     * 提供一个获取ViewHolder的方法
     */
    public static BaseViewHolder getRecyclerHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        BaseViewHolder viewHolder = new BaseViewHolder(context, itemView);
        return viewHolder;
    }

    /**
     * 获取控件
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 给TextView设置setText方法
     */
    public BaseViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 给TextView设置setText方法
     */
    public BaseViewHolder setColor(int viewId, String text) {
        TextView tv = getView(viewId);
        if (text.equals("1")){
            tv.setTextColor(MyApplication.getContextObject().getResources().getColor(R.color.red));//通过获得资源文件进行设置。
        }else if (text.equals("2")){
            tv.setTextColor(MyApplication.getContextObject().getResources().getColor(R.color.pinchar2));//通过获得资源文件进行设置。
        }
        else if (text.equals("3")){
            tv.setTextColor(MyApplication.getContextObject().getResources().getColor(R.color.pinchar3));//通过获得资源文件进行设置。
        }
        else if (text.equals("4")){
            tv.setTextColor(MyApplication.getContextObject().getResources().getColor(R.color.pinchar4));//通过获得资源文件进行设置。
        }
        else if (text.equals("5")){
            tv.setTextColor(MyApplication.getContextObject().getResources().getColor(R.color.pinchar5));//通过获得资源文件进行设置。
        }
        else if (text.equals("6")){
            tv.setTextColor(MyApplication.getContextObject().getResources().getColor(R.color.pinchar6));//通过获得资源文件进行设置。
        }
        else if (text.equals("7")){
            tv.setTextColor(MyApplication.getContextObject().getResources().getColor(R.color.pinchar9));//通过获得资源文件进行设置。
        }
        else if (text.equals("8")){
            tv.setTextColor(MyApplication.getContextObject().getResources().getColor(R.color.pinchar10));//通过获得资源文件进行设置。
        }
        else if (text.equals("9")){
            tv.setTextColor(MyApplication.getContextObject().getResources().getColor(R.color.pinchar11));//通过获得资源文件进行设置。
        }
        else if (text.equals("10")){
            tv.setTextColor(MyApplication.getContextObject().getResources().getColor(R.color.pinchar12));//通过获得资源文件进行设置。
        }
        return this;
    }

    /**
     * 给TextView设置
     */
    public BaseViewHolder setVisitiom(int viewId) {
        TextView tv = getView(viewId);
        tv.setVisibility(View.GONE);
        return this;
    }

    /**
     * 给TextView设置
     */
    public BaseViewHolder setVisitiomV(int viewId) {
        TextView tv = getView(viewId);
        tv.setVisibility(View.VISIBLE);
        return this;
    }
    /**
     * 给Button设置
     */
    public BaseViewHolder setVisitiomBtn(int viewId) {
        Button tv = getView(viewId);
        tv.setVisibility(View.VISIBLE);
        return this;
    }
    /**
     * 给Linearlayout设置
     */
    public BaseViewHolder setVisitiomLL(int viewId) {
        LinearLayout tv = getView(viewId);
        tv.setVisibility(View.GONE);
        return this;
    }

    /**
     * 给TextView设置setText方法
     */
    public BaseViewHolder setText1(int viewId, String text) {
        RichTextView tv = getView(viewId);
        tv.setHtml(text, 500);
        return this;
    }

    /**
     * 给ImageView设置setImageResource方法
     */
    public BaseViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    /**
     * 给Radionbutton设置隐藏控件方法
     */
    public BaseViewHolder setGone(int viewId) {
        RadioButton rb = getView(viewId);
        rb.setVisibility(View.GONE);
        return this;
    }

    /**
     * 给TextView设置隐藏控件方法
     */
    public BaseViewHolder setGoneLL(int viewId) {
        LinearLayout rb = getView(viewId);
        rb.setVisibility(View.GONE);
        return this;
    }


    /**
     * 给Radionbutton设置cgeck方法
     */
    public BaseViewHolder setCheck(int viewId) {
        RadioButton rb = getView(viewId);
        rb.setChecked(true);
        return this;
    }

    /**
     * 添加点击事件
     */
    public BaseViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }
}
