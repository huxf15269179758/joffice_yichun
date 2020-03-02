package com.hy.powerplatform.oa_flow.activity;

import android.content.Intent;
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
import com.hy.powerplatform.oa_flow.fragment.FragmentSaferData;
import com.hy.powerplatform.oa_flow.fragment.FragmentSaferList;
import com.hy.powerplatform.oa_flow.fragment.FragmentTestList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlowSaferActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

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

    public Fragment fragment01,fragment011, fragment02,fragment022, fragment03;
    List<Fragment> list = new ArrayList<Fragment>();
    @BindView(R.id.rbWillDo)
    RadioButton rbWillDo;

    String tag = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        tag = intent.getStringExtra("tag");
        if (tag.equals("1")){
            header.setTvTitle("保险费借款单商业险");
        }else {
            header.setTvTitle("保险费借款单意外险");
        }
        fragment01 = new FragmentSaferData();
        fragment02 = new FragmentSaferList();
        fragment011 = new FragmentTestList();
        list.add(fragment01);
        list.add(fragment011);
        list.add(fragment02);
        radionGroup.setOnCheckedChangeListener(this);
        noScrollViewPager.setAdapter(new Fragment_Adapter(getSupportFragmentManager(), list));
        noScrollViewPager.setCurrentItem(0, false);
    }
    public final String getTag(){
        return tag;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_flow_list;
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
                noScrollViewPager.setCurrentItem(2, false);
                break;
        }
    }
}

