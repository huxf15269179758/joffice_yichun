package com.hy.powerplatform.car_maintain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.car_maintain.adapter.BaoXiuTypeAdapter;
import com.hy.powerplatform.car_maintain.bean.BaoXiuType;
import com.hy.powerplatform.car_maintain.presenter.BaoXiuTypePresenter;
import com.hy.powerplatform.car_maintain.presenter.presenterimpl.BaoXiuTypePresenterImpl;
import com.hy.powerplatform.car_maintain.view.BaoXiuTypeView;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/11/22.
 */

public class BaoxiuTypeActivity extends BaseActivity implements BaoXiuTypeView,BaoXiuTypeAdapter.CallBackPosition {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    BaoXiuTypePresenter baoXiuTypePresenter;
    List<String> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        baoXiuTypePresenter = new BaoXiuTypePresenterImpl(this, this);
        baoXiuTypePresenter.getBaoXiuTypePresenter();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_select_data;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void getBaoXiuTypeView(BaoXiuType baoXiuType) {
        for (int i = 0; i < baoXiuType.getData().size(); i++) {
            dataList.add(baoXiuType.getData().get(i).getItemValue());
        }
        //实现排序方法  
        Collections.sort(dataList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null || o2 == null) {
                    return -1;
                }
                if (o1.length() > o2.length()) {
                    return 1;
                }
                if (o1.length() < o2.length()) {
                    return -1;
                }
                if (o1.compareTo(o2) > 0) {
                    return 1;
                }
                if (o1.compareTo(o2) < 0) {
                    return -1;
                }
                if (o1.compareTo(o2) == 0) {
                    return 0;
                }
                return 0;
            }
        });
        BaoXiuTypeAdapter adapter = new BaoXiuTypeAdapter(BaoxiuTypeActivity.this, dataList);
        recyclerView.setAdapter(adapter);
        adapter.selectTextViewPosition(this);
    }

    @Override
    public void myTextViewClient(int position) {
        Intent i = new Intent();
        i.putExtra("baoXiuType", dataList.get(position));
        setResult(Constant.TAG_NINE, i);
        finish();
    }

}