package com.hy.powerplatform.operation.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.operation.bean.LineSearch;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LineSearchDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvLineCode)
    TextView tvLineCode;
    @BindView(R.id.tvLineName)
    TextView tvLineName;
    @BindView(R.id.tvLineStatus)
    TextView tvLineStatus;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.tvStation)
    TextView tvStation;
    @BindView(R.id.tvSmz)
    TextView tvSmz;
    @BindView(R.id.tvDDCode)
    TextView tvDDCode;
    @BindView(R.id.tvMoney)
    TextView tvMoney;
    @BindView(R.id.tvMile)
    TextView tvMile;
    @BindView(R.id.tvYYCar)
    TextView tvYYCar;
    @BindView(R.id.tvMemo)
    TextView tvMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        header.setTvTitle(getResources().getString(R.string.oaflow_operation_rb2));
        LineSearch.ResultBean bean = (LineSearch.ResultBean) getIntent().getSerializableExtra("bean");
        tvLineCode.setText(bean.getLineCode());
        tvLineName.setText(bean.getLineName()+"");
        if (bean.getLineStatus()!=null&&bean.getLineStatus().equals("0")){
            tvLineStatus.setText("上下行");
        }
        if (bean.getLineStatus()!=null&&bean.getLineStatus().equals("1")){
            tvLineStatus.setText("环形");
        }
        tvDepartment.setText(bean.getDepartment().getDepName()+"");
        tvStartTime.setText(bean.getBeginDate()+"");
        if (bean.getEndDate()==null){
            tvEndTime.setText("");
        }else {
            tvEndTime.setText(bean.getEndDate()+"");
        }

        if (bean.getType()!=null&&bean.getType().equals("0")){
            tvStation.setText("使用中");
        }
        if (bean.getType()!=null&&bean.getType().equals("1")){
            tvStation.setText("已结束");
        }
        if (bean.getType()!=null&&bean.getType().equals("2")){
            tvStation.setText("测试");
        }
        tvSmz.setText(bean.getSmz()+"");
        tvDDCode.setText(bean.getDdNo()+"");
        tvMoney.setText(bean.getLineMoney()+"");
        tvMile.setText(bean.getLineMile()+"");
        tvYYCar.setText(bean.getYyCar()+"");
        tvMemo.setText(bean.getMemo()+"");
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_line_search_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
