package com.hy.powerplatform.my_utils.utils;

/**
 * Created by Administrator on 2019/4/12.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2019/4/12.
 * 普通类型的适配器
 */

public abstract class BaseRecyclerAdapterPosition<T> extends RecyclerView.Adapter<BaseViewHolderPosition> {
    private Context mContext;
    private int mLayoutId;
    private List<T> mData;


    public BaseRecyclerAdapterPosition(Context mContext, int mLayoutId, List<T> mData) {
        this.mContext = mContext;
        this.mLayoutId = mLayoutId;
        this.mData = mData;
    }

    @Override
    public BaseViewHolderPosition onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolderPosition viewHolder = BaseViewHolderPosition.getRecyclerHolder(mContext, parent, mLayoutId);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolderPosition holder, int position) {
        convert(holder, mData.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * 对外提供的方法
     */
    public abstract void convert(BaseViewHolderPosition holder, T t,int i);

}
