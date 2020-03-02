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

public class CheckPersonActivity extends BaseActivity implements CheckPersonView, CheckPersonAdapter.CallBackPosition {

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
    private List<Person> morenDatas = new ArrayList<>();
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
                adapter = new CheckPersonAdapter(CheckPersonActivity.this, checkList1);
                LinearLayoutManager manager = new LinearLayoutManager(CheckPersonActivity.this);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
                adapter.setOnItemLitener(CheckPersonActivity.this);
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
        for (int k = 0; k < checkList.size(); k++) {
            if (checkList.get(k).getFullname().equals("王少云") || checkList.get(k).getFullname().equals("唐根六")
                    || checkList.get(k).getFullname().equals("晏慧锋")) {
                Person person = new Person();
                person.setUserCode(checkList.get(k).getProfileId());
                person.setUserName(checkList.get(k).getFullname());
                morenDatas.add(person);
            }
        }
        String roleName = sharedPreferencesHelper.getData(this, "roleName", "");
        String userCode = sharedPreferencesHelper.getData(this, "userCode", "");
        Person person = new Person();
        person.setUserCode(userCode);
        person.setUserName(roleName);
        morenDatas.add(person);
        morenDatas.addAll(datas);
        if (morenDatas.size() != 0) {
            for (int i = 0; i < morenDatas.size(); i++) {
                if (i != morenDatas.size() - 1) {
                    name = name + morenDatas.get(i).getUserName() + ",";
                    userCode = userCode + morenDatas.get(i).getUserCode() + ",";
                } else {
                    name = name + morenDatas.get(i).getUserName();
                    userCode = userCode + morenDatas.get(i).getUserCode();
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
    }
}
