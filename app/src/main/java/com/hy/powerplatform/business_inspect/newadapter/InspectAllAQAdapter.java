package com.hy.powerplatform.business_inspect.newadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hy.powerplatform.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */

public class InspectAllAQAdapter extends RecyclerView.Adapter<InspectAllAQAdapter.ViewHolder> {

    Context context;
    List<String> beanList = new ArrayList<>();
    public GetItemPosition getItemPosition;

    public interface GetItemPosition {
        void getPosition(int position, String tag);
    }

    public void setOnInnerItemOnClickListener(GetItemPosition getItemPosition){
        this.getItemPosition=getItemPosition;
    }

    public InspectAllAQAdapter(Context context, List<String> anquanList) {
        this.context = context;
        beanList = anquanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_inspectstarte, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvName.setText(beanList.get(position));
        holder.position =position;
        holder.tvGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItemPosition.getPosition(position,"photo");
            }
        });
        holder.llPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.ivNoPass.setImageResource(R.drawable.nocheck);
                holder.ivPass.setImageResource(R.drawable.check);
               getItemPosition.getPosition(position,"pass");
            }
        });

        holder.llNoPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.ivNoPass.setImageResource(R.drawable.check);
                holder.ivPass.setImageResource(R.drawable.nocheck);
                getItemPosition.getPosition(position,"nopass");
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        LinearLayout llPass,llNoPass;
        ImageView ivPass,ivNoPass,imageView;
        public Button tvGet;
        int position;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            llPass = (LinearLayout) itemView.findViewById(R.id.llPass);
            llNoPass = (LinearLayout) itemView.findViewById(R.id.llNoPass);
            ivPass = (ImageView) itemView.findViewById(R.id.ivPass);
            ivNoPass = (ImageView) itemView.findViewById(R.id.ivNoPass);
            tvGet = (Button) itemView.findViewById(R.id.tvGet);
            imageView = (ImageView) itemView.findViewById(R.id.imaheView);
        }
    }
}
