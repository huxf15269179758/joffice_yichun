package com.hy.powerplatform.human.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.human.bean.YingPinList;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YingPinDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvSxe)
    TextView tvSxe;
    @BindView(R.id.tvAge)
    TextView tvAge;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvWork)
    TextView tvWork;
    @BindView(R.id.tvType)
    TextView tvType;
    @BindView(R.id.tvZT)
    TextView tvZT;
    @BindView(R.id.tvPhone)
    TextView tvPhone;
    @BindView(R.id.tvIdCard)
    TextView tvIdCard;
    @BindView(R.id.tvDJR)
    TextView tvDJR;
    @BindView(R.id.tvTine)
    TextView tvTine;
    @BindView(R.id.tvMZ)
    TextView tvMZ;
    @BindView(R.id.tvZZMM)
    TextView tvZZMM;
    @BindView(R.id.tvAddress)
    TextView tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        YingPinList.ResultBean bean = (YingPinList.ResultBean) intent.getSerializableExtra("bean");
        tvSxe.setText(bean.getSex());
        tvAge.setText(bean.getAge() + "");
        tvName.setText(bean.getFullname());
        tvWork.setText(bean.getPosition());
        tvType.setText(bean.getVehicleClass());
        tvZT.setText(bean.getStatus());
        tvPhone.setText(bean.getMobile());
        tvIdCard.setText(bean.getIdNo());
        tvDJR.setText(bean.getRegistor());
        tvTine.setText(bean.getRegTime());
        tvMZ.setText(bean.getRace());
        tvZZMM.setText(bean.getParty());
        tvAddress.setText(bean.getAddress());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_yingpin_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
