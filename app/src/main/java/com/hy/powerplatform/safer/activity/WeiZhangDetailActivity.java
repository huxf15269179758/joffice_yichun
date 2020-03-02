package com.hy.powerplatform.safer.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.safer.bean.WeiZhangList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeiZhangDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvLine)
    TextView tvLine;
    @BindView(R.id.tvBusCode)
    TextView tvBusCode;
    @BindView(R.id.tvCarNo)
    TextView tvCarNo;
    @BindView(R.id.tvvnMark)
    TextView tvvnMark;
    @BindView(R.id.tvvnFine)
    TextView tvvnFine;
    @BindView(R.id.tvDriverName)
    TextView tvDriverName;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.tvAdress)
    TextView tvAdress;
    @BindView(R.id.tvProject)
    TextView tvProject;
    @BindView(R.id.tvCLJG)
    TextView tvCLJG;
    @BindView(R.id.tvMemo)
    TextView tvMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        WeiZhangList.ResultBean bean = (WeiZhangList.ResultBean) getIntent().getSerializableExtra("bean");
        tvLine.setText(bean.getLineCode());
        tvBusCode.setText(bean.getBusCode());
        tvCarNo.setText(bean.getCarNo());
        tvvnMark.setText(bean.getVnMark());
        tvDriverName.setText(bean.getDriverName());
        tvDate.setText(bean.getVnDate());
        tvAdress.setText(bean.getVnPlace());
        tvProject.setText(bean.getVnProject());
        tvCLJG.setText(bean.getPenaltyStatus());
        tvMemo.setText(bean.getVnMemo());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_wei_zhang_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
