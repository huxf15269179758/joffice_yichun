package com.hy.powerplatform.comper;

import android.content.Context;

import com.hy.powerplatform.R;
import com.hy.powerplatform.comper.bean.ShengChanYYList;
import com.hy.powerplatform.comper.view.CommonAdapter;
import com.hy.powerplatform.comper.view.CommonViewHolder;

import java.util.List;

/**
 * Created by chawei on 2018/4/29.
 */

public class CoinAdapter extends CommonAdapter<ShengChanYYList.ResultBean> {

    private CommonViewHolder.onItemCommonClickListener commonClickListener;

    public CoinAdapter(Context context, List<ShengChanYYList.ResultBean> dataList, int layoutId, CommonViewHolder.onItemCommonClickListener listener) {
        super(context, dataList, layoutId);
        commonClickListener = listener;
    }

    @Override
    public void bindData(CommonViewHolder holder, ShengChanYYList.ResultBean data, int position) {

        holder.setColorWhite(R.id.id_name)
                .setColorWhite(R.id.tvDQ)
                .setColorWhite(R.id.tvSY)
                .setColorWhite(R.id.tvTB)
                .setColorWhite(R.id.tvQNTQ)
                .setColorWhite(R.id.tvHB)
                .setColorWhite(R.id.tvNDLJ);
//                    .setCommonClickListener(commonClickListener);

        if (position % 2 == 0) {
            holder.setColor(R.id.id_name)
                    .setColor(R.id.tvDQ)
                    .setColor(R.id.tvSY)
                    .setColor(R.id.tvTB)
                    .setColor(R.id.tvQNTQ)
                    .setColor(R.id.tvHB)
                    .setColor(R.id.tvNDLJ);
        }
        //                .setCommonClickListener(commonClickListener);
        holder.setText(R.id.id_name, data.getName())
                .setText(R.id.tvDQ, data.getBqnum())
                .setText(R.id.tvSY, data.getSqnum())
                .setText(R.id.tvTB, data.getTb())
                .setText(R.id.tvQNTQ, data.getTqnum())
                .setText(R.id.tvHB, data.getHb())
                .setText(R.id.tvNDLJ, data.getYearCount());
        if (data.getTb()!=null&&!data.getTb().equals("")&&data.getTb().contains("%")){
            if (Double.valueOf(data.getTb().substring(0, data.getTb().indexOf("%")))>0){
                holder.setTextColorRed(R.id.tvTB);
            }else if (Double.valueOf(data.getTb().substring(0, data.getTb().indexOf("%")))<0){
                holder.setTextColorGra(R.id.tvTB);
            }else {
                holder.setTextColorBlack(R.id.tvTB);
            }
        }
    }
}
