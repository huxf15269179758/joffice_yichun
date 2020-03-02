package com.hy.powerplatform.login.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ActivityCollector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyPersonalActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvmyName)
    TextView tvmyName;
    @BindView(R.id.myinform)
    LinearLayout myinform;
    @BindView(R.id.tvMyStatus)
    TextView tvMyStatus;
    @BindView(R.id.studyArchives)
    LinearLayout studyArchives;
    @BindView(R.id.btnQuit)
    Button btnQuit;
    @BindView(R.id.activity_my_person)
    LinearLayout activityMyPerson;

    SharedPreferencesHelper sharedPreferencesHelper;
    @BindView(R.id.tvVersion)
    TextView tvVersion;

    String versionName;
    int versionCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        ActivityCollector.addActivity(this);
        sharedPreferencesHelper = new SharedPreferencesHelper(this, "login");
        String name = sharedPreferencesHelper.getData(this, "userName", "");
        String status = sharedPreferencesHelper.getData(this, "depName", "");
        tvmyName.setText(name);
        tvMyStatus.setText(status);
        PackageManager pm = this.getPackageManager();
        PackageInfo pi = null;
        try {
            pi = pm.getPackageInfo(this.getPackageName(), 0);
            versionName = pi.versionName;
            versionCode = pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        tvVersion.setText(versionName);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_my_person;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //当返回按键被按下
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return false;
    }

    @OnClick({R.id.btnQuit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnQuit:
                sharedPreferencesHelper.removeData(this);
                //       sharedPreferencesHelper.saveData(this,"Address","");
                finish();
                //ActivityCollector.finidhAll();
                break;
        }
    }

}
