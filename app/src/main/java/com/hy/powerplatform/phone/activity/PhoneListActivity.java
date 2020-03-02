package com.hy.powerplatform.phone.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.azlistview.ContactSortModel;
import com.hy.powerplatform.my_utils.utils.azlistview.EditTextWithDel;
import com.hy.powerplatform.my_utils.utils.azlistview.PinyinComparator;
import com.hy.powerplatform.my_utils.utils.azlistview.PinyinUtils;
import com.hy.powerplatform.my_utils.utils.azlistview.SideBar;
import com.hy.powerplatform.phone.adapter.SortAdapter;
import com.hy.powerplatform.phone.bean.Phone;
import com.hy.powerplatform.phone.presenter.PhonePresenter;
import com.hy.powerplatform.phone.presenter.phonepresenterimpl.PhonePresenterimpl;
import com.hy.powerplatform.phone.view.PhoneView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhoneListActivity extends BaseActivity implements PhoneView {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.lv_contact)
    ListView lvContact;
    @BindView(R.id.dialog)
    TextView dialog;
    @BindView(R.id.sidrbar)
    SideBar sidrbar;
    @BindView(R.id.et_search)
    EditTextWithDel etSearch;

    PhonePresenter phonePresenter;
    SortAdapter adapter;
    String callPhone;
    public static final String TAG = "PersonListActivity";
    private List<ContactSortModel> SourceDateList;
    SharedPreferencesHelper sharedPreferencesHelper;
    private static HashMap<String, String> CookieContiner = new HashMap<String, String>();
    List<String> selectList = new ArrayList<>();
    List<Phone.ResultBean> phoneList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        sharedPreferencesHelper = new SharedPreferencesHelper(this,"login");
        String userid = sharedPreferencesHelper.getData(this,"userCode","");
        phonePresenter = new PhonePresenterimpl(this, this);
        phonePresenter.getPhonePresenterData(userid);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_phone_list;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        Intent intent = new Intent(this,PhoneAddActivity.class);
        startActivity(intent);
    }

    @Override
    public void getPhoneViewData(Phone phone) {
        for (int i = 0; i < phone.getResult().size(); i++) {
            phoneList.add(phone.getResult().get(i));
        }
        initDatas();
        initEvents();
        setAdapter();
    }

    private void initDatas() {
        sidrbar.setTextView(dialog);
    }

    private void initEvents() {
        //设置右侧触摸监听
        sidrbar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    lvContact.setSelection(position + 1);
                }
            }
        });

        //ListView的点击事件
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                if (ListView.CHOICE_MODE_MULTIPLE == lvContact.getChoiceMode()) {
//                    TextView textView = (TextView) view.findViewById(R.id.tv_city_name);
//                    if (!selectList.contains(textView.getText().toString())){
//                        selectList.add(textView.getText().toString());
//                    }else {
//                        for (int i = 0;i<selectList.size();i++){
//                            if (selectList.get(i).equals(textView.getText().toString())){
//                                selectList.remove(i);
//                            }
//                        }
//                    }
//                }
                callPhone = "tel:" + phoneList.get(position).getMobile();
                if (ContextCompat.checkSelfPermission(PhoneListActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PhoneListActivity.this, new String[]{Manifest.permission.CALL_PHONE}, Constant.TAG_ONE);
                } else {
                    Uri uri = Uri.parse(callPhone);
                    Intent intent = new Intent(Intent.ACTION_CALL, uri);
                    startActivity(intent);
                }
            }
        });

        //根据输入框输入值的改变来过滤搜索
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setAdapter() {
        SourceDateList = filledData(phoneList);
        Collections.sort(SourceDateList, new PinyinComparator());
        adapter = new SortAdapter(this, SourceDateList);
        lvContact.setAdapter(adapter);
    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<ContactSortModel> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)) {
            mSortList = SourceDateList;
        } else {
            mSortList.clear();
            for (ContactSortModel sortModel : SourceDateList) {
                String name = sortModel.getName();
                if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(filterStr.toString().toUpperCase())) {
                    mSortList.add(sortModel);
                }
            }
        }
        // 根据a-z进行排序
        Collections.sort(mSortList, new PinyinComparator());
        adapter.updateListView(mSortList);
    }

    private List<ContactSortModel> filledData(List<Phone.ResultBean> date) {
        List<ContactSortModel> mSortList = new ArrayList<>();
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i < date.size(); i++) {
            ContactSortModel sortModel = new ContactSortModel();
            sortModel.setName(date.get(i).getFullname() + ":  " + date.get(i).getMobile());
            String pinyin = PinyinUtils.getPingYin(date.get(i).getFullname());
            String sortString = pinyin.substring(0, 1).toUpperCase();
            if (sortString.matches("[A-Z]")) {
                sortModel.setSortLetters(sortString.toUpperCase());
                if (!indexString.contains(sortString)) {
                    indexString.add(sortString);
                }
            }
            mSortList.add(sortModel);
        }
        Collections.sort(indexString);
        sidrbar.setIndexText(indexString);
        return mSortList;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case Constant.TAG_ONE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Uri uri = Uri.parse(callPhone);
                    Intent intent = new Intent(Intent.ACTION_CALL, uri);
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    startActivity(intent);
                } else {
                    Toast.makeText(PhoneListActivity.this, "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }
}
