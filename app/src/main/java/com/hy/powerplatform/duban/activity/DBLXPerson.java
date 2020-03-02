package com.hy.powerplatform.duban.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/12/17.
 */

public class DBLXPerson extends BaseActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    @Override
    protected int provideContentViewId() {
        return android.R.layout.activity_list_item;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
