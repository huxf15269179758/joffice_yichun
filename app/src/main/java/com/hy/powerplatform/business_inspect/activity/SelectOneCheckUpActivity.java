package com.hy.powerplatform.business_inspect.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.adapter.SelectOneCarAdapter;
import com.hy.powerplatform.business_inspect.adapter.SelectOneCheckUpAdapter;
import com.hy.powerplatform.business_inspect.bean.CheckUp;
import com.hy.powerplatform.business_inspect.presenter.CheckUpPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CheckUpPresenterimpl;
import com.hy.powerplatform.business_inspect.view.CheckUpView;
import com.hy.powerplatform.database.DbManager;
import com.hy.powerplatform.database.MyDatabaseHelper;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBack;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.azlistview.ContactSortModel;
import com.hy.powerplatform.my_utils.utils.azlistview.EditTextWithDel;
import com.hy.powerplatform.my_utils.utils.azlistview.PinyinComparator;
import com.hy.powerplatform.my_utils.utils.azlistview.PinyinUtils;
import com.hy.powerplatform.my_utils.utils.azlistview.SideBar;
import com.hy.powerplatform.phone.adapter.SortAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectOneCheckUpActivity extends BaseActivity implements SelectOneCarAdapter.CallBackPosition,
             SelectOneCheckUpAdapter.CallBackPosition,CheckUpView {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.et_search)
    EditTextWithDel etSearch;
    @BindView(R.id.lv_contact)
    ListView lvContact;
    @BindView(R.id.dialog)
    TextView dialog;
    @BindView(R.id.sidrbar)
    SideBar sidrbar;
    @BindView(R.id.activity_selectcar)
    LinearLayout activitySelectcar;

    SortAdapter adapter;
    String etText;
    int position;
    SQLiteDatabase db;
    Cursor cursor;
    MyDatabaseHelper helper;
    AlertDialogUtil alertDialogUtil;
    String checkUpName,checkUpId,checkUpSex;
    private List<ContactSortModel> SourceDateList;
    List<String> selectList = new ArrayList<>();
    List<CheckUp.DataBean> dataBeanList = new ArrayList<>();
    CheckUpPresenter checkUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        checkUpPresenter = new CheckUpPresenterimpl(this, this);
        alertDialogUtil = new AlertDialogUtil(this);
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        Intent intent = getIntent();
        etText = intent.getStringExtra("condition");
        //判断数据库是否有洗车人信息
        decideDbForCheckUpData();
    }

    /**
     * 判断数据库是否有检查人信息
     */
    private void decideDbForCheckUpData() {
        //查询数据
        String sqlR = "select * from checkUp";// order by random() limit 100
        cursor = DbManager.queryBySQL(db, sqlR, null);
        dataBeanList = DbManager.cursorToCheckUp(cursor);
        if (dataBeanList.size() != 0) {
            initDatas();
            initEvents();
            setAdapter();
        } else {
            checkUpPresenter.getCheckUpPresenterData();
        }
    }

//    private void getAssessData() {
//        String sql;
//        if (etText.isEmpty()) {
//            sql = "select * from checkUp";
//        } else {
//            sql = "select * from checkUp where fullname like '%" + etText + "%'";
//        }
//        cursor = DbManager.queryBySQL(db, sql, null);
//        listCheckUpFromdb = DbManager.cursorToCheckUp(cursor);
//        GetDataThread.getCheckUpData(etText, cursor, db, listCheckUpFromdb, new BaseRequestAssessLisenter() {
//            @Override
//            public void success(Object o, Object o2) {
//
//            }
//
//            @Override
//            public void fail(String message) {
//
//            }
//
//            @Override
//            public void success(List listCarCodeFromdb1) {
//                if (listCarCodeFromdb1.size() == 0) {
//                    Message message = new Message();
//                    message.what = Constant.TAG_ONE;
//                    handler.sendMessage(message);
//                } else {
//                    listCheckUpFromdb = listCarCodeFromdb1;
//                    Message message = new Message();
//                    message.what = Constant.TAG_TWO;
//                    handler.sendMessage(message);
//                }
//            }
//        });
//    }

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
                if (ListView.CHOICE_MODE_MULTIPLE == lvContact.getChoiceMode()) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_city_name);
                    if (!selectList.contains(textView.getText().toString())){
                        selectList.add(textView.getText().toString());
                    }else {
                        for (int i = 0;i<selectList.size();i++){
                            if (selectList.get(i).equals(textView.getText().toString())){
                                selectList.remove(i);
                            }
                        }
                    }
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
        SourceDateList = filledData(dataBeanList);
        Collections.sort(SourceDateList, new PinyinComparator());
        adapter = new SortAdapter(this, SourceDateList);
        lvContact.setAdapter(adapter);
        adapter.setOnClientMyTextView(new SortAdapter.CallBackPosition() {
            @Override
            public void myTextViewClient(String name, String profileId,String userCode, String sex) {
                Intent i = new Intent();
                i.putExtra("bianName", name);
                i.putExtra("bianId", profileId);
                i.putExtra("bianSex", sex);
                i.putExtra("bianUserCode", userCode);
                setResult(Constant.TAG_FOUR, i);
                finish();
            }

        });
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

    private List<ContactSortModel> filledData(List<CheckUp.DataBean> date) {
        List<ContactSortModel> mSortList = new ArrayList<>();
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i < date.size(); i++) {
            ContactSortModel sortModel = new ContactSortModel();
            sortModel.setName(date.get(i).getFullname());
            sortModel.setProfileId(date.get(i).getProfileId());
            sortModel.setSex(date.get(i).getSex());
            sortModel.setUserCode(date.get(i).getUserCode());
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
    protected int provideContentViewId() {
        return R.layout.activity_selectclean;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void myTextViewClient(int position) {
        checkUpName = dataBeanList.get(position).getFullname();
        checkUpId = dataBeanList.get(position).getProfileId();
        checkUpSex = dataBeanList.get(position).getSex();
        Intent i = new Intent();
        i.putExtra("bianName", checkUpName);
        i.putExtra("bianId", checkUpId);
        i.putExtra("bianSex", checkUpSex);
        setResult(Constant.TAG_FOUR, i);
        finish();
    }

    @Override
    public void getCheckUpViewData(CheckUp checkUp) {
        if (checkUp.getData().size() != 0) {
            for (int i = 0; i < checkUp.getData().size(); i++) {
                dataBeanList.add(checkUp.getData().get(i));
            }
            initDatas();
            initEvents();
            setAdapter();
        } else {
            alertDialogUtil.showDialog(getResources().getString(R.string.no_search_phone)
                    , new AlertDialogCallBack() {
                        @Override
                        public void select(String data) {

                        }

                        @Override
                        public void confirm() {
                            finish();
                        }

                        @Override
                        public void cancel() {
                            finish();
                        }
                    });
        }
    }
}
