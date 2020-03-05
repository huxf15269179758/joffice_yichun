package com.hy.powerplatform.comper.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hy.powerplatform.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chawei on 2018/4/29.
 */

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<T> mDataList;
    private int mLayoutId;
    private int mFixX;
    private ArrayList<View> mMoveViewList = new ArrayList<>();

    public CommonAdapter(Context context, List<T> dataList, int layoutId) {
        mLayoutInflater = LayoutInflater.from(context);
        mDataList = dataList;
        mLayoutId = layoutId;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(mLayoutId, parent, false);
        CommonViewHolder holder = new CommonViewHolder(itemView);
        LinearLayout moveLayout = holder.getView(R.id.id_move_layout);
        moveLayout.scrollTo(mFixX, 0);
        mMoveViewList.add(moveLayout);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
//        if (position%2==0){
//            holder.itemView.setBackgroundColor(MyApplication.getContextObject().getResources().getColor(R.color.shouye));
//        }
        layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        bindData(holder, mDataList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mDataList==null?0:mDataList.size();
    }

    public abstract void bindData(CommonViewHolder holder, T data, int position);

    public ArrayList<View> getMoveViewList(){
        return mMoveViewList;
    }

    public void setFixX(int fixX){
        mFixX=fixX;
    }
}
