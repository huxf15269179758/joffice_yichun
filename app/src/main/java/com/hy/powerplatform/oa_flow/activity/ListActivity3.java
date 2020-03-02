package com.hy.powerplatform.oa_flow.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.oa_flow.adapter.ListAdapter3;
import com.hy.powerplatform.oa_flow.bean.MyNum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity3 extends BaseActivity {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<MyNum.ResultBean> beanList = new ArrayList<>();
    List<String> numList = new LinkedList<>();
    ListAdapter3 adapter;

    String rolues;
    List<String> dataList = new ArrayList<>();
    List<String> roluesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        rolues = new SharedPreferencesHelper(this,"login").getData(this,"rolues","");
        String userName = new SharedPreferencesHelper(this,"login").getData(this,"userStatus","");
        roluesList.add("行政管理");
        roluesList.add("人资管理");
        roluesList.add("财务管理");
        roluesList.add("采购管理");
        roluesList.add("发文管理");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new ListAdapter3(this, roluesList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_list1;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
