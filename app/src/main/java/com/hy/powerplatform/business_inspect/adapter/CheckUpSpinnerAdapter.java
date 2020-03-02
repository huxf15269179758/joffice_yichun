package com.hy.powerplatform.business_inspect.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.bean.Matter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2018/6/7.
 */

public class CheckUpSpinnerAdapter extends RecyclerView.Adapter<CheckUpSpinnerAdapter.ViewHolder> {

    List<Matter.ResultBean> beanList = new ArrayList<>();
    public GetItemTextViewPosition getItemTextViewPosition;
    Context mContext;

    public interface GetItemTextViewPosition {
        void getItemPosition(int position, String tag);
    }

    public void setItemPosition(GetItemTextViewPosition getItemTextViewPosition) {
        this.getItemTextViewPosition = getItemTextViewPosition;
    }

    public CheckUpSpinnerAdapter(Context context, List<Matter.ResultBean> matterList) {
        this.mContext = context;
        this.beanList = matterList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_spinner,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mTextView.setText(beanList.get(position).getProjectName());
        holder.position =position;
        holder.tvUpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItemTextViewPosition.getItemPosition(position,"photo");
            }
        });
        holder.rbY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.ivNoPass.setImageResource(R.drawable.nocheck);
                holder.ivPass.setImageResource(R.drawable.check);
                getItemTextViewPosition.getItemPosition(position,"pass");
            }
        });

        holder.rbN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.ivNoPass.setImageResource(R.drawable.check);
                holder.ivPass.setImageResource(R.drawable.nocheck);
                getItemTextViewPosition.getItemPosition(position,"nopass");
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView, tvUpImageView;
        LinearLayout rbY, rbN;
        ImageView imageView1, imageView2,ivPass,ivNoPass;
        int position;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tvName);
            tvUpImageView = (TextView) itemView.findViewById(R.id.tvUpImageView);
            rbY = (LinearLayout) itemView.findViewById(R.id.rbY);
            rbN = (LinearLayout) itemView.findViewById(R.id.rbN);
            imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);
            imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);
            ivPass = (ImageView) itemView.findViewById(R.id.ivPass);
            ivNoPass = (ImageView) itemView.findViewById(R.id.ivNoPass);
        }
    }
}
