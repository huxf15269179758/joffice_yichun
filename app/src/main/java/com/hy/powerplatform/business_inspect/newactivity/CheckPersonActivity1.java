package com.hy.powerplatform.business_inspect.newactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.bean.CheckPerson;
import com.hy.powerplatform.business_inspect.bean.Person;
import com.hy.powerplatform.business_inspect.newadapter.CheckPersonAdapter;
import com.hy.powerplatform.business_inspect.presenter.CheckPersonPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CheckPersonPresenterimpl;
import com.hy.powerplatform.business_inspect.view.CheckPersonView;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckPersonActivity1 extends BaseActivity implements CheckPersonView, CheckPersonAdapter.CallBackPosition {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    CheckPersonAdapter adapter;
    String name = "";
    String userCode = "";
    @BindView(R.id.etSearch)
    EditText etSearch;
    private List<Person> datas = new ArrayList<>();
    CheckPersonPresenter checkPersonPresenter;
    SharedPreferencesHelper sharedPreferencesHelper;
    List<CheckPerson.DataBean> checkList = new ArrayList<>();
    List<CheckPerson.DataBean> checkList1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        checkPersonPresenter = new CheckPersonPresenterimpl(this, this);
        checkPersonPresenter.getCheckPersonPresenterData();
        sharedPreferencesHelper = new SharedPreferencesHelper(this, "login");
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                checkList1.clear();
                if (s!=null){
                    String text = s.toString();
                    for (int i = 0;i<checkList.size();i++){
                        if (checkList.get(i).getFullname().contains(text)){
                            checkList1.add(checkList.get(i));
                        }
                    }
                }
                adapter = new CheckPersonAdapter(CheckPersonActivity1.this, checkList1);
                LinearLayoutManager manager = new LinearLayoutManager(CheckPersonActivity1.this);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
                adapter.setOnItemLitener(CheckPersonActivity1.this);
            }
        });
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
        if (datas.size() != 0) {
            for (int i = 0; i < datas.size(); i++) {
                if (i != datas.size() - 1) {
                    name = name + datas.get(i).getUserName() + ",";
                    userCode = userCode + datas.get(i).getUserCode() + ",";
                } else {
                    name = name + datas.get(i).getUserName();
                    userCode = userCode + datas.get(i).getUserCode();
                }
            }
        }
        Intent i = new Intent();
        i.putExtra("name", name);
        i.putExtra("userCode", userCode);
        setResult(Constant.TAG_SEVEN, i);
        finish();
    }

    @Override
    public void getCheckPersonViewData(CheckPerson checkPerson) {
        for (int i = 0; i < checkPerson.getData().size(); i++) {
            checkList.add(checkPerson.getData().get(i));
        }
        adapter = new CheckPersonAdapter(this, checkList);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemLitener(this);
    }

    @Override
    public void onItemClick(int position) {
        Person person = new Person();
        if (checkList1.size()==0){
            if (datas.contains(checkList.get(position).getFullname())) {
//            datas.remove(checkList.get(position).getFullname());
                person.setUserName(checkList.get(position).getFullname());
                person.setUserCode(checkList.get(position).getProfileId());
                datas.remove(person);
            } else {
                person.setUserName(checkList.get(position).getFullname());
                person.setUserCode(checkList.get(position).getProfileId());
                datas.add(person);
            }
        }else {
            if (datas.contains(checkList1.get(position).getFullname())) {
//            datas.remove(checkList.get(position).getFullname());
                person.setUserName(checkList1.get(position).getFullname());
                person.setUserCode(checkList1.get(position).getProfileId());
                datas.remove(person);
            } else {
                person.setUserName(checkList1.get(position).getFullname());
                person.setUserCode(checkList1.get(position).getProfileId());
                datas.add(person);
            }
        }

    }
}
