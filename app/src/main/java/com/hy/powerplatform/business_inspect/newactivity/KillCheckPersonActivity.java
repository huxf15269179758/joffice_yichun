package com.hy.powerplatform.business_inspect.newactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.bean.CheckPerson;
import com.hy.powerplatform.business_inspect.newadapter.CheckPersonAdapter;
import com.hy.powerplatform.business_inspect.presenter.CheckPersonPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.KillCheckPersonPresenterimpl;
import com.hy.powerplatform.business_inspect.view.CheckPersonView;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KillCheckPersonActivity extends BaseActivity implements CheckPersonView,CheckPersonAdapter.CallBackPosition{

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    CheckPersonAdapter adapter;
    String name = "";
    String userCode = "";
    private List<String> datas = new ArrayList<>();
    private List<String> selectDatas = new ArrayList<>();
    CheckPersonPresenter checkPersonPresenter;
    List<CheckPerson.DataBean> checkList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        checkPersonPresenter = new KillCheckPersonPresenterimpl(this,this);
        checkPersonPresenter.getCheckPersonPresenterData();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_check_person;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        if (datas.size()!=0){
            for (int i = 0;i<datas.size();i++){
                if (i!=datas.size()-1){
                    name = name+datas.get(i)+",";
                }else {
                    name = name+datas.get(i);
                }
            }
        }
        if (selectDatas.size()!=0){
            for (int i = 0;i<selectDatas.size();i++){
                if (i!=selectDatas.size()-1){
                    userCode = userCode+selectDatas.get(i)+",";
                }else {
                    userCode = userCode+selectDatas.get(i);
                }
            }
        }
        Intent i = new Intent();
        i.putExtra("name", name);
        i.putExtra("userCode", userCode);
        setResult(Constant.TAG_SIX, i);
        finish();
    }

    @Override
    public void getCheckPersonViewData(CheckPerson checkPerson) {
        for (int i = 0;i<checkPerson.getData().size();i++){
            checkList.add(checkPerson.getData().get(i));
        }
        adapter = new CheckPersonAdapter(this,checkList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemLitener(this);
    }

    @Override
    public void onItemClick( int position) {
        if (datas.contains(checkList.get(position).getName())){
            datas.remove(checkList.get(position).getName());
        }else {
            datas.add(checkList.get(position).getName());
        }
        if (selectDatas.contains(checkList.get(position).getUserCode())){
            selectDatas.remove(checkList.get(position).getUserCode());
        }else {
            selectDatas.add(checkList.get(position).getUserCode());
        }
    }
}
