package com.hy.powerplatform.my_utils.utils;

import android.content.Context;
import android.graphics.Color;
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

/**
 * Created by Administrator on 2019/4/12.
 * 通用adapter的viewholder
 */

public class BaseViewHolderPosition extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews; //用来存储控件
    private View mConvertView;
    private Context mContext;

    public BaseViewHolderPosition(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        mConvertView = itemView;
        mViews = new SparseArray<View>();
    }

    /**
     * 提供一个获取ViewHolder的方法
     */
    public static BaseViewHolderPosition getRecyclerHolder(Context context, ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        BaseViewHolderPosition viewHolder = new BaseViewHolderPosition(context, itemView);
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
    public BaseViewHolderPosition setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 给TextView设置
     */
    public BaseViewHolderPosition setVisitiom(int viewId) {
        TextView tv = getView(viewId);
        tv.setVisibility(View.GONE);
        return this;
    }
    /**
     * 给Button设置
     */
    public BaseViewHolderPosition setVisitiomBtn(int viewId) {
        Button tv = getView(viewId);
        tv.setVisibility(View.VISIBLE);
        return this;
    }
    /**
     * 给Linearlayout设置
     */
    public BaseViewHolderPosition setVisitiomLL(int viewId) {
        LinearLayout tv = getView(viewId);
        tv.setVisibility(View.GONE);
        return this;
    }

    /**
     * 给LinnerLayout设置颜色
     */
    public BaseViewHolderPosition setColor(int viewId) {
        LinearLayout linearLayout = getView(viewId);
        linearLayout.setBackgroundColor(Color.parseColor("#F2F2F2"));
        return this;
    }

    /**
     * 给ImageView设置setImageResource方法
     */
    public BaseViewHolderPosition setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    /**
     * 给Radionbutton设置隐藏控件方法
     */
    public BaseViewHolderPosition setGone(int viewId) {
        RadioButton rb = getView(viewId);
        rb.setVisibility(View.GONE);
        return this;
    }

    /**
     * 给TextView设置隐藏控件方法
     */
    public BaseViewHolderPosition setGoneLL(int viewId) {
        LinearLayout rb = getView(viewId);
        rb.setVisibility(View.GONE);
        return this;
    }


    /**
     * 给Radionbutton设置cgeck方法
     */
    public BaseViewHolderPosition setCheck(int viewId) {
        RadioButton rb = getView(viewId);
        rb.setChecked(true);
        return this;
    }

    /**
     * 添加点击事件
     */
    public BaseViewHolderPosition setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }
}
