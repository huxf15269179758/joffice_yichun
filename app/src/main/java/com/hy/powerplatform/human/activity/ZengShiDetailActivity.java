package com.hy.powerplatform.human.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.human.bean.ZengShiList;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZengShiDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvSex)
    TextView tvSex;
    @BindView(R.id.tvAge)
    TextView tvAge;
    @BindView(R.id.tvZJM)
    TextView tvZJM;
    @BindView(R.id.tvYGBH)
    TextView tvYGBH;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvZZMM)
    TextView tvZZMM;
    @BindView(R.id.tvSFZZ)
    TextView tvSFZZ;
    @BindView(R.id.tvWork)
    TextView tvWork;
    @BindView(R.id.tvDep)
    TextView tvDep;
    @BindView(R.id.tvRZTime)
    TextView tvRZTime;
    @BindView(R.id.tvPhone)
    TextView tvPhone;
    @BindView(R.id.tvIdCard)
    TextView tvIdCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        ZengShiList.ResultBean bean = (ZengShiList.ResultBean) getIntent().getSerializableExtra("bean");
        tvSex.setText(bean.getSex());
        tvAge.setText(bean.getAge());
        tvZJM.setText(bean.getMnemonicCard());
        tvYGBH.setText(bean.getECard());
        tvName.setText(bean.getFullname());

        tvZZMM.setText(bean.getParty());
        String sfzz = bean.getIsWork();
        if(sfzz.equals("0")){
            tvSFZZ.setText("试用");
        }else if(sfzz.equals("1")){
            tvSFZZ.setText("在职");
        }else if(sfzz.equals("2")){
            tvSFZZ.setText("离职");
        }else if(sfzz.equals("3")){
            tvSFZZ.setText("退休");
        }else if(sfzz.equals("4")){
            tvSFZZ.setText("离休");
        }else if(sfzz.equals("5")){
            tvSFZZ.setText("死亡");
        }else if(sfzz.equals("6")){
            tvSFZZ.setText("待岗");
        }
        tvWork.setText(bean.getPosition());
        tvDep.setText(bean.getDepName());
        String date = bean.getNowWorkDate();
        if (date!=null&&!date.equals("")){
            tvRZTime.setText(bean.getNowWorkDate().split(" ")[0]);
        }
        tvPhone.setText(bean.getMobile());
        tvIdCard.setText(bean.getIdCard());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_zeng_shi_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
