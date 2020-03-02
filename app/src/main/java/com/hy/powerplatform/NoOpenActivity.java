package com.hy.powerplatform;

import android.content.Intent;
import android.os.Bundle;

import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoOpenActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String heard = intent.getStringExtra("heard");
        header.setTvTitle(heard);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_no_open;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
