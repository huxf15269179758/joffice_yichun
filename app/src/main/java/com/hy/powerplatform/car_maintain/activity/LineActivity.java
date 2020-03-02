package com.hy.powerplatform.car_maintain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.car_maintain.adapter.LineAdapter;
import com.hy.powerplatform.car_maintain.bean.Line;
import com.hy.powerplatform.car_maintain.presenter.LinePresenter;
import com.hy.powerplatform.car_maintain.presenter.presenterimpl.LinePresenterImpl;
import com.hy.powerplatform.car_maintain.view.LineView;
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

public class LineActivity extends BaseActivity implements LineView,LineAdapter.CallBackPosition {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    LinePresenter linePresenter;
    List<Line.DataBean> dataList = new ArrayList<>();
    List<String> dataList1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        linePresenter = new LinePresenterImpl(this, this);
        linePresenter.getLinePresenter();
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
    public void getLineView(Line line) {
        for (int i = 0; i < line.getData().size(); i++) {
            dataList.add(line.getData().get(i));
            dataList1.add(line.getData().get(i).getLineCode());
        }
        //实现排序方法  
        Collections.sort(dataList1, new Comparator<String>() {
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
        LineAdapter adapter = new LineAdapter(LineActivity.this, dataList1);
        recyclerView.setAdapter(adapter);
        adapter.selectTextViewPosition(this);
    }
    @Override
    public void myTextViewClient(int position) {
        Intent i = new Intent();
        i.putExtra("line", dataList.get(position));
        setResult(Constant.TAG_FOUR, i);
        finish();
    }
}