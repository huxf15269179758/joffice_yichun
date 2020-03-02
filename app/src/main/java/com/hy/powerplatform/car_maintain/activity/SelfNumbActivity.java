package com.hy.powerplatform.car_maintain.activity;

import android.os.Bundle;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;

public class SelfNumbActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_self_numb;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
