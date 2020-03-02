package com.hy.powerplatform.car_maintain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.car_maintain.adapter.SelectDataAdapter;
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

public class ZiBianHaoActivity extends BaseActivity implements ZiBianHaoView,SelectDataAdapter.CallBackPosition{

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    ZiBianHaoPresenter ziBianHaoPresenter;
    List<LocalZhiBianHao> dataList1 = new ArrayList<>();
    List<String> dataList2 = new ArrayList<>();
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
                dataList2.add(dataList1.get(i).getZhibianhao());
            }
            //实现排序方法  
            Collections.sort(dataList2,new Comparator<String>() {
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
            SelectDataAdapter adapter = new SelectDataAdapter(ZiBianHaoActivity.this, dataList2);
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
    public void getZiBianHaoView(zhibianhao ziBianHao1) {
        for (int i = 0;i<ziBianHao1.getData().size();i++){
            dataList2.add(ziBianHao1.getData().get(i).getBusCode());
            LocalZhiBianHao zhibian = new LocalZhiBianHao();
            zhibian.setZhibianhao(ziBianHao1.getData().get(i).getBusCode());
            zhibian.setCarno(ziBianHao1.getData().get(i).getCarNo());
            zhibian.save();
        }
        //实现排序方法  
        Collections.sort(dataList2,new Comparator<String>() {
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
        SelectDataAdapter adapter = new SelectDataAdapter(ZiBianHaoActivity.this, dataList2);
        recyclerView.setAdapter(adapter);
        adapter.selectTextViewPosition(this);
    }

    @Override
    public void myTextViewClient(int position) {
        Intent i = new Intent();
        i.putExtra("ziBianHao", dataList2.get(position));
        setResult(Constant.TAG_TWO, i);
        finish();
    }
}
