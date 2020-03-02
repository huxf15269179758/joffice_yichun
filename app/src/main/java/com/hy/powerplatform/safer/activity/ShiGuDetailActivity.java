package com.hy.powerplatform.safer.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.safer.bean.ShiGuList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShiGuDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvatCode)
    TextView tvatCode;
    @BindView(R.id.tvLine)
    TextView tvLine;
    @BindView(R.id.tvCarNo)
    TextView tvCarNo;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvDriverName)
    TextView tvDriverName;
    @BindView(R.id.tvReason)
    TextView tvReason;
    @BindView(R.id.tvAdress)
    TextView tvAdress;
    @BindView(R.id.tvType)
    TextView tvType;
    @BindView(R.id.tvLiability)
    TextView tvLiability;
    @BindView(R.id.tvCategory)
    TextView tvCategory;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.tvNature)
    TextView tvNature;
    @BindView(R.id.tvShry)
    TextView tvShry;
    @BindView(R.id.tvShsj)
    TextView tvShsj;
    @BindView(R.id.tvShzt)
    TextView tvShzt;
    @BindView(R.id.tvDeductionMile)
    TextView tvDeductionMile;
    @BindView(R.id.tvInsurePerson)
    TextView tvInsurePerson;
    @BindView(R.id.tvOtherPay)
    TextView tvOtherPay;
    @BindView(R.id.tvPersonPay)
    TextView tvPersonPay;
    @BindView(R.id.tvTotalCose)
    TextView tvTotalCose;
    @BindView(R.id.tvSecurityAwardPenalties)
    TextView tvSecurityAwardPenalties;
    @BindView(R.id.tvProcessingState)
    TextView tvProcessingState;
    @BindView(R.id.tvBXState)
    TextView tvBXState;
    @BindView(R.id.tvAddBond)
    TextView tvAddBond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        ShiGuList.ResultBean bean = (ShiGuList.ResultBean) getIntent().getSerializableExtra("bean");
        tvatCode.setText(bean.getAtCode());
        tvLine.setText(bean.getLineCode());
        tvCarNo.setText(bean.getCarNo());
        tvDate.setText(bean.getAtAtDate());
        tvTime.setText(bean.getAtTime());
        tvDriverName.setText(bean.getDriverName());
        tvReason.setText(bean.getAtReason());
        tvAdress.setText(bean.getAtPlace());
        tvType.setText(bean.getAtType());
        tvLiability.setText(bean.getAtLiability());
        tvDepartment.setText(bean.getDepName());
        tvNature.setText(bean.getAcNature());
        tvShry.setText(bean.getShry());
        tvShsj.setText(bean.getShsj());
        if (bean.getShzt().equals("1")){
            tvShzt.setText("已审核");
        }else if (bean.getShzt().equals("0")){
            tvShzt.setText("未审核");
        }
        tvDeductionMile.setText(bean.getAcDeductionMile()+"");
        tvInsurePerson.setText(bean.getAtInsurePerson());
        tvOtherPay.setText(bean.getAtOtherPay());
        tvPersonPay.setText(bean.getAtPersonPay());
        tvTotalCose.setText(bean.getAtTotalCose());
        tvSecurityAwardPenalties.setText(bean.getAtSecurityAwardPenalties());
        tvProcessingState.setText(bean.getAtProcessingState());
        if (bean.getShzt().equals("1")){
            tvShzt.setText("已审核");
        }else {
            tvShzt.setText("未审核");
        }
        tvAddBond.setText(bean.getAtAddBond());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_shi_gu_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
