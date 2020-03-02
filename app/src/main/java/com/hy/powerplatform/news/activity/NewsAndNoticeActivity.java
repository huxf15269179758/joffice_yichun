package com.hy.powerplatform.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hy.powerplatform.Fragment_Adapter;
import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.news.fragment.NewsFragment;
import com.hy.powerplatform.news.fragment.NoticeFragment;
import com.hy.powerplatform.news.myview.CustomViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsAndNoticeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

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

    public Fragment fragmentNews, fragmentNotice;
    List<Fragment> list = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        fragmentNews = new NewsFragment();
        fragmentNotice = new NoticeFragment();
        list.add(fragmentNews);
        list.add(fragmentNotice);
        radionGroup.setOnCheckedChangeListener(this);
        customViewPage.setAdapter(new Fragment_Adapter(getSupportFragmentManager(), list));
        String tag = intent.getStringExtra("tag");
        if (tag!=null&&tag.equals("notice")){
            customViewPage.setCurrentItem(1,false);
            rbContent.setChecked(true);
        }else {
            customViewPage.setCurrentItem(0,false);
        }
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_newsandnotice;
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
