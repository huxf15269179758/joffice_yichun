package com.hy.powerplatform.business_inspect.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hy.powerplatform.Fragment_Adapter;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.fragment.StarteNoPassFragment;
import com.hy.powerplatform.business_inspect.fragment.StartePassFragment;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.news.myview.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InspectStarteActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    // , InspectStarteAdapter.MyClickListener
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.rbPhoto)
    RadioButton rbPhoto;
    @BindView(R.id.rbContent)
    RadioButton rbContent;
    @BindView(R.id.radionGroup)
    RadioGroup radionGroup;
    @BindView(R.id.customViewPage)
    CustomViewPager customViewPage;
    public Fragment fragmentPass, fragmentNoPass;
    List<Fragment> list = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        fragmentPass = new StartePassFragment();
        fragmentNoPass = new StarteNoPassFragment();
        list.add(fragmentPass);
        list.add(fragmentNoPass);
        radionGroup.setOnCheckedChangeListener(this);
        customViewPage.setAdapter(new Fragment_Adapter(getSupportFragmentManager(), list));
        customViewPage.setCurrentItem(0, false);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_inspectstarte;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbPhoto:
                customViewPage.setCurrentItem(0, false);
                break;
            case R.id.rbContent:
                customViewPage.setCurrentItem(1, false);
                break;
        }
    }
}
