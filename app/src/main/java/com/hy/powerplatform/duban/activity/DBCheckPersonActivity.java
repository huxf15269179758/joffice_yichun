package com.hy.powerplatform.duban.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.bean.Person;
import com.hy.powerplatform.duban.bean.DBCheckPerson;
import com.hy.powerplatform.duban.newadapter.DBCheckPersonAdapter;
import com.hy.powerplatform.duban.presenter.DBCheckPersonPresenter;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Request;
import okhttp3.Response;

public class DBCheckPersonActivity extends BaseActivity implements DBCheckPersonAdapter.CallBackPosition {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    DBCheckPersonAdapter adapter;
    String data;
    String name = "";
    String userCode = "";
    private OkHttpUtil httpUtil;
    AlertDialogUtil alertDialogUtil;
    private List<Person> datas = new ArrayList<>();
    private List<Person> morenDatas = new ArrayList<>();
    DBCheckPersonPresenter checkPersonPresenter;
    SharedPreferencesHelper sharedPreferencesHelper;
    String path_url = Constant.BASE_URL1 + Constant.DBPERSON+"?start=0&limit=10000";
    List<DBCheckPerson.ResultBean> checkList = new ArrayList<>();
    List<DBCheckPerson.ResultBean> checkList1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        alertDialogUtil = new AlertDialogUtil(this);
        httpUtil = OkHttpUtil.getInstance(this);
        getPersonData();
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
                if (s != null) {
                    String text = s.toString();
                    for (int i = 0; i < checkList.size(); i++) {
                        if (checkList.get(i).getFullname().contains(text)) {
                            checkList1.add(checkList.get(i));
                        }
                    }
                }
                adapter = new DBCheckPersonAdapter(DBCheckPersonActivity.this, checkList1);
                LinearLayoutManager manager = new LinearLayoutManager(DBCheckPersonActivity.this);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapter);
                adapter.setOnItemLitener(DBCheckPersonActivity.this);
            }
        });
    }

    /**
     * 获取检查人
     */
    private void getPersonData() {
        httpUtil.getAsynHttp(path_url, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
//                Log.i("main", "response:" + e.toString());
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
//                      Log.i("main", "response:" + response.body().string());
                data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = Constant.TAG_TWO;
                handler.sendMessage(message);
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
//        for (int k = 0; k < checkList.size(); k++) {
//            if (checkList.get(k).getFullname().equals("王少云") || checkList.get(k).getFullname().equals("唐根六")
//                    || checkList.get(k).getFullname().equals("晏慧锋")) {
//                Person person = new Person();
//                person.setUserCode(checkList.get(k).getUserId());
//                person.setUserName(checkList.get(k).getFullname());
//                morenDatas.add(person);
//            }
//        }
        Person person1 = new Person();
        person1.setUserCode("9386");
        person1.setUserName("王少云");
        morenDatas.add(person1);

        Person person2 = new Person();
        person2.setUserCode("9387");
        person2.setUserName("唐根六");
        morenDatas.add(person2);

        Person person3 = new Person();
        person3.setUserCode("9398");
        person3.setUserName("晏慧锋");
        morenDatas.add(person3);

        String roleName = sharedPreferencesHelper.getData(this, "userStatus", "");
        String userCode = sharedPreferencesHelper.getData(this, "userId", "");
        Person person = new Person();
        person.setUserCode(userCode);
        person.setUserName(roleName);
        if (!roleName.equals("晏慧锋")) {
            morenDatas.add(person);
        }
        morenDatas.addAll(datas);
        if (morenDatas.size() != 0) {
            for (int i = 0; i < morenDatas.size(); i++) {
                if (i != morenDatas.size() - 1) {
                    name = name + morenDatas.get(i).getUserName() + ",";
                    userCode += "," + morenDatas.get(i).getUserCode() + ",";
                } else {
                    name = name + morenDatas.get(i).getUserName();
                    userCode += "," + morenDatas.get(i).getUserCode();
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
    public void onItemClick(int position, String tag) {
        Person person = new Person();
//        if (datas.contains(checkList.get(position).getFullname())) {
////            datas.remove(checkList.get(position).getFullname());
//            if (tag.equals("2")){
//                person.setUserName(checkList.get(position).getFullname());
//                person.setUserCode(checkList.get(position).getUserId());
//                datas.remove(person);
//            }
//        } else {
        if (tag.equals("1")) {
            if (!datas.contains(checkList.get(position).getFullname())) {
                person.setUserName(checkList.get(position).getFullname());
                person.setUserCode(checkList.get(position).getUserId());
                datas.add(person);
            }
        } else if (tag.equals("2")) {
            person.setUserName(checkList.get(position).getFullname());
            person.setUserCode(checkList.get(position).getUserId());
            Iterator<Person> it = datas.iterator();
            while (it.hasNext()) {
                Person str = (Person) it.next();
                if (checkList.get(position).getFullname().equals(str.getUserName())) {
                    it.remove();
                }
            }
        }
//        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Bundle b = msg.getData();
                    String error = b.getString("error");
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(DBCheckPersonActivity.this, error, Toast.LENGTH_SHORT).show();
                    break;
                case Constant.TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    Gson gsonF = new Gson();
                    final DBCheckPerson checkPerson = gsonF.fromJson(data, DBCheckPerson.class);
                    for (int i = 0; i < checkPerson.getResult().size(); i++) {
                        checkList.add(checkPerson.getResult().get(i));
                    }
                    adapter = new DBCheckPersonAdapter(DBCheckPersonActivity.this, checkList);
                    LinearLayoutManager manager = new LinearLayoutManager(DBCheckPersonActivity.this);
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                    adapter.setOnItemLitener(DBCheckPersonActivity.this);
                    break;
            }
        }
    };
}
