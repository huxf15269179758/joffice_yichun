package com.hy.powerplatform.operation.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.operation.bean.CarDAN;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CarDANDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvCarCode)
    TextView tvCarCode;
    @BindView(R.id.tvCarNo)
    TextView tvCarNo;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.tvFaDongJiCode)
    TextView tvFaDongJiCode;
    @BindView(R.id.tvZSH)
    TextView tvZSH;
    @BindView(R.id.tvCJH)
    TextView tvCJH;
    @BindView(R.id.tvSCCJ)
    TextView tvSCCJ;
    @BindView(R.id.tvCLXH)
    TextView tvCLXH;
    @BindView(R.id.tvFDJXH)
    TextView tvFDJXH;
    @BindView(R.id.tvCLLX)
    TextView tvCLLX;
    @BindView(R.id.tvCLPP)
    TextView tvCLPP;
    @BindView(R.id.tvSYNX)
    TextView tvSYNX;
    @BindView(R.id.tvDQZT)
    TextView tvDQZT;
    @BindView(R.id.tvSYXZ)
    TextView tvSYXZ;
    @BindView(R.id.tvSSDW)
    TextView tvSSDW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        CarDAN.ResultBean bean = (CarDAN.ResultBean) getIntent().getSerializableExtra("bean");
        tvCarCode.setText(bean.getBusCode());
        tvCarNo.setText(bean.getCarNo());
        tvDate.setText(bean.getBusRegDate());
        tvFaDongJiCode.setText(bean.getEngineCode());
        tvZSH.setText(bean.getBusRegId());
        tvCJH.setText(bean.getBusFrameId());
        tvSCCJ.setText(bean.getBusMaker());
        tvCLXH.setText(bean.getCarType());
        tvFDJXH.setText(bean.getEngineNo());
        tvCLLX.setText(bean.getVehicleType());
        tvCLPP.setText(bean.getBusTypeName());
        tvSYNX.setText(bean.getUsedYears());
        if (bean.getStatus()==1){
            tvDQZT.setText("可用");
        }
        if (bean.getStatus()==0){
            tvDQZT.setText("已报废3");
        }

        tvSYXZ.setText(bean.getBusUseNature());
        tvSSDW.setText(bean.getDepName());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_car_dandetail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
