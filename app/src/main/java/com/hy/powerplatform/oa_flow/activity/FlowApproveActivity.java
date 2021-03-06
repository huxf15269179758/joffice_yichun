package com.hy.powerplatform.oa_flow.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hy.powerplatform.Fragment_Adapter;
import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.NoScrollViewPager;
import com.hy.powerplatform.oa_flow.fragment.FragmentApproveData;
import com.hy.powerplatform.oa_flow.fragment.FragmentGcList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 用车流程
 */
public class FlowApproveActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.rbData)
    RadioButton rbData;
    @BindView(R.id.rbList)
    RadioButton rbList;
    @BindView(R.id.radionGroup)
    RadioGroup radionGroup;
    @BindView(R.id.noScrollViewPager)
    NoScrollViewPager noScrollViewPager;

    public Fragment fragment01, fragment02;
    List<Fragment> list = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        header.setTvTitle("审批单");
        fragment01 = new FragmentApproveData();
        fragment02 = new FragmentGcList();
        list.add(fragment01);
        list.add(fragment02);
        radionGroup.setOnCheckedChangeListener(this);
        noScrollViewPager.setAdapter(new Fragment_Adapter(getSupportFragmentManager(), list));
        noScrollViewPager.setCurrentItem(0, false);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_flow_car;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rbData:
                noScrollViewPager.setCurrentItem(0, false);
                break;
            case R.id.rbList:
                noScrollViewPager.setCurrentItem(1, false);
                break;
        }
    }
}
