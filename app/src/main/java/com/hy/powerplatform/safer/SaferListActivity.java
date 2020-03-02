package com.hy.powerplatform.safer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.safer.activity.ShiGuListActivity;
import com.hy.powerplatform.safer.activity.WeiZhangListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SaferListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    Intent intent;
    String rights;
    String userStatus;
    AlertDialogUtil alertDialogUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        alertDialogUtil = new AlertDialogUtil(this);
        userStatus = new SharedPreferencesHelper(this, "login").getData(this, "userStatus", "");
        rights = new SharedPreferencesHelper(this, "login").getData(this, "rights", "");
        if (rights.contains(",ViolationRecordView")) {
            rb1.setVisibility(View.GONE);
        }
        if (rights.contains(",AccidentBasicInformationView")) {
            rb2.setVisibility(View.GONE);
        }
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_safer_list;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.rb1, R.id.rb2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                intent = new Intent(this, WeiZhangListActivity.class);
                startActivity(intent);
                break;
            case R.id.rb2:
                intent = new Intent(this, ShiGuListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
