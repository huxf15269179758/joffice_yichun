package com.hy.powerplatform.comper.view;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.MyApplication;

/**
 * Created by chawei on 2018/4/29.
 */

public class CommonViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {
    private SparseArray<View> viewSparseArray;

    private onItemCommonClickListener commonClickListener;

    public CommonViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        viewSparseArray = new SparseArray<>();
    }

    public <T extends View> T getView(int viewId) {
        View view = viewSparseArray.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            viewSparseArray.put(viewId, view);
        }
        return (T) view;
    }

    public CommonViewHolder setText(int viewId, CharSequence text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public CommonViewHolder setTextColorRed(int viewId) {
        TextView tv = getView(viewId);
        tv.setTextColor(MyApplication.getContext().getResources().getColor(R.color.holo_red_dark));
        return this;
    }

    public CommonViewHolder setTextColorGra(int viewId) {
        TextView tv = getView(viewId);
        tv.setTextColor(MyApplication.getContext().getResources().getColor(R.color.forestgreen));
        return this;
    }

    public CommonViewHolder setTextColorBlack(int viewId) {
        TextView tv = getView(viewId);
        tv.setTextColor(MyApplication.getContext().getResources().getColor(R.color.black));
        return this;
    }

    public CommonViewHolder setColor(int viewId) {
        TextView tv = getView(viewId);
        tv.setBackgroundColor(MyApplication.getContext().getResources().getColor(R.color.shouye));
        return this;
    }

    public CommonViewHolder setColorWhite(int viewId) {
        TextView tv = getView(viewId);
        tv.setBackgroundColor(MyApplication.getContext().getResources().getColor(R.color.white));
        return this;
    }

    public CommonViewHolder setViewVisibility(int viewId, int visibility) {
        getView(viewId).setVisibility(visibility);
        return this;
    }

    public CommonViewHolder setImageResource(int viewId, int resourceId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resourceId);
        return this;
    }

    public interface onItemCommonClickListener {

        void onItemClickListener(int position);

        void onItemLongClickListener(int position);

    }

    public void setCommonClickListener(onItemCommonClickListener commonClickListener) {
        this.commonClickListener = commonClickListener;
    }

    @Override
    public void onClick(View v) {
        if (commonClickListener != null) {
            commonClickListener.onItemClickListener(getAdapterPosition());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (commonClickListener != null) {
            commonClickListener.onItemLongClickListener(getAdapterPosition());
        }
        return false;
    }
}
