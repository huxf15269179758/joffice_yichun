package com.hy.powerplatform.human.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.human.bean.ShiYongList;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShiYongDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvWork)
    TextView tvWork;
    @BindView(R.id.tvDep)
    TextView tvDep;
    @BindView(R.id.tvRZTime)
    TextView tvRZTime;
    @BindView(R.id.tvOverTime)
    TextView tvOverTime;
    @BindView(R.id.tvIdCard)
    TextView tvIdCard;
    @BindView(R.id.tvDABH)
    TextView tvDABH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        ShiYongList.ResultBean bean = (ShiYongList.ResultBean) getIntent().getSerializableExtra("bean");
        tvName.setText(bean.getFullname());
        tvWork.setText(bean.getPosition());
        tvDep.setText(bean.getDepName());
        tvRZTime.setText(bean.getNowWorkDate());
        tvOverTime.setText(bean.getExpireDate());
        tvIdCard.setText(bean.getIdCard());
        tvDABH.setText(bean.getProfileNo());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_shi_yong_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
