package com.hy.powerplatform.car_maintain.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.car_maintain.adapter.ClassIfyAdapter;
import com.hy.powerplatform.car_maintain.bean.ClassIfy;
import com.hy.powerplatform.car_maintain.presenter.ClassIfyPresenter;
import com.hy.powerplatform.car_maintain.presenter.presenterimpl.ClassIfyPresenterImpl;
import com.hy.powerplatform.car_maintain.view.ClassIfyView;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassIfyActivity extends BaseActivity implements ClassIfyView {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    ClassIfyPresenter presenter;
    List<ClassIfy.ResultBean> dataList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        presenter = new ClassIfyPresenterImpl(this,this);
        presenter.getClassIfyPresenter();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_class_ify;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void getClassIfyView(ClassIfy classIfy) {
        for (int i = 0;i<classIfy.getResult().size();i++){
            dataList.add(classIfy.getResult().get(i));
        }
        ClassIfyAdapter adapter = new ClassIfyAdapter(this,dataList);
        recyclerView.setAdapter(adapter);
    }
}
