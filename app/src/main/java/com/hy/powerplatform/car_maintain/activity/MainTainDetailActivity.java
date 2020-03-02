package com.hy.powerplatform.car_maintain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hy.powerplatform.R;
import com.hy.powerplatform.car_maintain.bean.MainTainList;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainTainDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvList)
    TextView tvList;
    @BindView(R.id.tvDanHao)
    TextView tvDanHao;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvZiBianHao)
    TextView tvZiBianHao;
    @BindView(R.id.tvCarNo)
    TextView tvCarNo;
    @BindView(R.id.tvLine)
    TextView tvLine;
    @BindView(R.id.tvDriver)
    TextView tvDriver;
    @BindView(R.id.tvBaoXiuRen)
    TextView tvBaoXiuRen;
    @BindView(R.id.tvJianChaRen)
    TextView tvJianChaRen;
    @BindView(R.id.tvBaoXiuType)
    TextView tvBaoXiuType;
    @BindView(R.id.tvDongliType)
    TextView tvDongliType;
    @BindView(R.id.tvCheXing)
    TextView tvCheXing;
    @BindView(R.id.tvLiCheng)
    TextView tvLiCheng;
    @BindView(R.id.tvChangShang)
    TextView tvChangShang;
    @BindView(R.id.tvDepart)
    TextView tvDepart;
    @BindView(R.id.etReasion)
    EditText etReasion;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.imageView2)
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        MainTainList.ResultBean bean = (MainTainList.ResultBean) intent.getSerializableExtra("bean");
        tvDanHao.setText(bean.getMeasureBusNo());
        tvTime.setText(bean.getCreateDate());
        tvZiBianHao.setText(bean.getBusCode());
        tvCarNo.setText(bean.getCarNo());
        tvLine.setText(bean.getLineCode());
        tvDriver.setText(bean.getDriverName());
        tvBaoXiuRen.setText(bean.getInputPersonName());
        tvJianChaRen.setText(bean.getWorkerName());
        tvBaoXiuType.setText(bean.getRepairCategory());
        tvDongliType.setText(bean.getMaterialType());
        tvCheXing.setText("");
        tvLiCheng.setText("");
        tvChangShang.setText(bean.getMeasurePlace());
        tvDepart.setText(bean.getDepName());
        etReasion.setText(bean.getMemo());
        String[] temp;
        if(bean.getRepatrPrePhoto().length() != 0) {
            temp = bean.getRepatrPrePhoto().split(",");
            Glide.with(this).load(Constant.BASE_URL1+temp[0]).into(imageView1);
        }
        if(bean.getRepatrPrePhoto().length() > 1) {
            temp = bean.getRepatrPrePhoto().split(",");
            if (temp.length>1){
                Glide.with(this).load(Constant.BASE_URL1+temp[0]).into(imageView1);
                Glide.with(this).load(Constant.BASE_URL1+temp[1]).into(imageView1);
            }else {
                Glide.with(this).load(Constant.BASE_URL1+temp[0]).into(imageView1);
            }
        }
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main_tain_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
