package com.hy.powerplatform.car_maintain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.car_maintain.adapter.CarNoAdapter;
import com.hy.powerplatform.car_maintain.bean.LocalZhiBianHao;
import com.hy.powerplatform.car_maintain.bean.zhibianhao;
import com.hy.powerplatform.car_maintain.presenter.ZiBianHaoPresenter;
import com.hy.powerplatform.car_maintain.presenter.presenterimpl.ZiBianHaoPresenterImpl;
import com.hy.powerplatform.car_maintain.view.ZiBianHaoView;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/11/22.
 */

public class CarNoActivity extends BaseActivity implements ZiBianHaoView,CarNoAdapter.CallBackPosition {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    ZiBianHaoPresenter ziBianHaoPresenter;
    List<String> dataList = new ArrayList<>();
    List<LocalZhiBianHao> dataList1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        dataList1 = DataSupport.findAll(LocalZhiBianHao.class);
        if (dataList1.size() ==0){
            ziBianHaoPresenter = new ZiBianHaoPresenterImpl(this,this);
            ziBianHaoPresenter.getZiBianHaoPresenter();
        }else {
            for (int i = 0;i<dataList1.size();i++){
                dataList.add(dataList1.get(i).getCarno());
            }
            //实现排序方法  
            Collections.sort(dataList,new Comparator<String>() {
                @Override
                public int compare(String  o1, String  o2) {
                    if(o1 == null || o2 == null){
                        return -1;
                    }
                    if(o1.length() > o2.length()){
                        return 1;
                    }
                    if(o1.length() < o2.length()){
                        return -1;
                    }
                    if(o1.compareTo(o2) > 0){
                        return 1;
                    }
                    if(o1.compareTo(o2) < 0){
                        return -1;
                    }
                    if(o1.compareTo(o2) == 0){
                        return 0;
                    }
                    return 0;
                }
            });
            CarNoAdapter adapter = new CarNoAdapter(CarNoActivity.this, dataList);
            recyclerView.setAdapter(adapter);
            adapter.selectTextViewPosition(this);
        }
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
    public void myTextViewClient(int position) {
        Intent i = new Intent();
        i.putExtra("carNo", dataList.get(position));
        setResult(Constant.TAG_THERE, i);
        finish();
    }

    @Override
    public void getZiBianHaoView(zhibianhao ziBianHao) {
        for (int i = 0; i < ziBianHao.getData().size(); i++) {
            dataList.add(ziBianHao.getData().get(i).getCarNo());
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
        CarNoAdapter adapter = new CarNoAdapter(CarNoActivity.this, dataList);
        recyclerView.setAdapter(adapter);
        adapter.selectTextViewPosition(this);
    }
}