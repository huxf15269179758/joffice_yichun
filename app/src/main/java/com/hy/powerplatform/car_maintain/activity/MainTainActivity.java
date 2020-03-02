package com.hy.powerplatform.car_maintain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainTainActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb4)
    RadioButton rb4;
    @BindView(R.id.rb5)
    RadioButton rb5;
    @BindView(R.id.rb6)
    RadioButton rb6;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main_tain_list;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        Intent intent = new Intent(this,AddMainTainActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4, R.id.rb5, R.id.rb6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                intent = new Intent(this,MainTainListActivity.class);
                startActivity(intent);
                break;
            case R.id.rb2:
                intent = new Intent(this,MainPaiDanActivity.class);
                startActivity(intent);
                break;
            case R.id.rb3:
                intent = new Intent(this,MainXiangMuActivity.class);
                startActivity(intent);
                break;
            case R.id.rb4:
                intent = new Intent(this,MainLingLiaoActivity.class);
                startActivity(intent);
                break;
            case R.id.rb5:
                intent = new Intent(this,MainShenYanActivity.class);
                startActivity(intent);
                break;
            case R.id.rb6:
                intent = new Intent(this,MainOverActivity.class);
                startActivity(intent);
                break;
        }
    }
}
