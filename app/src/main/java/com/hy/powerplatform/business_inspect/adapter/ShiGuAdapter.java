package com.hy.powerplatform.business_inspect.adapter;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hy.powerplatform.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */

public class ShiGuAdapter extends RecyclerView.Adapter <ShiGuAdapter.ViewHolder> {
    public Context context;
    public List<Uri> beanList = new ArrayList<>();
    public ShiGuAdapter(Context context, List<Uri> mResults) {
        this.context = context;
        this.beanList = mResults;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptershigu_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            holder.imageView.setImageBitmap(MediaStore.Images.Media.getBitmap(context.getContentResolver(), beanList.get(position)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
