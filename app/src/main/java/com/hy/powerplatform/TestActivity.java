package com.hy.powerplatform;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hy.powerplatform.my_utils.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends BaseActivity {

    Context context;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        context = this;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_test;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @OnClick(R.id.ll)
    public void onViewClicked() {
        if (ll1.getVisibility() == View.VISIBLE) {
            ll1.setVisibility(View.GONE);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.daoshanjiao));
        } else {
            ll1.setVisibility(View.VISIBLE);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.shanjiao));
        }
    }
}
