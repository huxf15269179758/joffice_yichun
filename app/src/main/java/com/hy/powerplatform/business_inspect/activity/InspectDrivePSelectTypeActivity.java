package com.hy.powerplatform.business_inspect.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
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
import com.hy.powerplatform.business_inspect.bean.DriverP;
import com.hy.powerplatform.business_inspect.utils.BaseRequestAssessLisenter;
import com.hy.powerplatform.business_inspect.utils.GetDataThread;
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
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InspectDrivePSelectTypeActivity extends BaseActivity {

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

    String etText;
    int position;
    SQLiteDatabase db;
    Cursor cursor;
    MyDatabaseHelper helper;
    AlertDialogUtil alertDialogUtil;
    List<DriverP.DataBean> listInspectDrive = new ArrayList<>();
    private List<ContactSortModel> SourceDateList;
    private static HashMap<String, String> CookieContiner = new HashMap<String, String>();
    List<String> selectList = new ArrayList<>();
    String sql;
    SortAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
//        alertDialogUtil = new AlertDialogUtil(this);
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        Intent intent = getIntent();
        etText = intent.getStringExtra("condition");
//        ProgressDialogUtil.startLoad(this, Constant.GETDATA);
        //查询数据
        getAssessData();
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
        SourceDateList = filledData(listInspectDrive);
        Collections.sort(SourceDateList, new PinyinComparator());
        adapter = new SortAdapter(this, SourceDateList);
        lvContact.setAdapter(adapter);
        adapter.setOnClientMyTextView(new SortAdapter.CallBackPosition() {
            @Override
            public void myTextViewClient(String name, String profileId,String userCode, String sex) {
                Intent intent = new Intent();
                intent.putExtra("bianId", profileId);
                intent.putExtra("bianName",name);
                intent.putExtra("bianDriver", sex);
                setResult(Constant.TAG_FIVE, intent);
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

    private List<ContactSortModel> filledData(List<DriverP.DataBean> date) {
        List<ContactSortModel> mSortList = new ArrayList<>();
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i < date.size(); i++) {
            ContactSortModel sortModel = new ContactSortModel();
            sortModel.setName(date.get(i).getFullname());
            sortModel.setProfileId(date.get(i).getProfileId());
            sortModel.setSex(date.get(i).getSex());
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

    private void getAssessData() {
        if (etText.isEmpty()) {
            sql = "select * from inspectDriveP";
        } else {
            sql = "select * from inspectDriveP where fullname like '%" + etText + "%'";
        }
        cursor = DbManager.queryBySQL(db, sql, null);
        listInspectDrive = DbManager.cursorToInspectDriveP(cursor);
        GetDataThread.getInspectDrivePData(etText, cursor, db, listInspectDrive, new BaseRequestAssessLisenter() {
            @Override
            public void success(Object o, Object o2) {

            }

            @Override
            public void fail(String message) {

            }

            @Override
            public void success(List listCarCodeFromdb1) {
                if (listCarCodeFromdb1.size() == 0) {
                    Message message = new Message();
                    message.what = Constant.TAG_ONE;
                    handler.sendMessage(message);
                } else {
                    listInspectDrive = listCarCodeFromdb1;
                    Message message = new Message();
                    message.what = Constant.TAG_TWO;
                    handler.sendMessage(message);
                }
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_selectline;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
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
                    break;
                case Constant.TAG_TWO:
                    LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
                    recyclerView.setLayoutManager(manager);
//                    adapter = new SelectInspectDrivePAdapter(listInspectDrive);
//                    recyclerView.setAdapter(adapter);
//                    ProgressDialogUtil.stopLoad();
//                    adapter.setOnClientMyTextView(new SelectInspectDrivePAdapter.CallBackPosition() {
//                        @Override
//                        public void myTextViewClient(int position) {
//                            Intent i = new Intent();
//                            i.putExtra("bian", listInspectDrive.get(position).getFullname());
//                            i.putExtra("bianId", listInspectDrive.get(position).getProfileId());
//                            i.putExtra("bianSex", listInspectDrive.get(position).getSex());
//                            i.putExtra("bianDriver", listInspectDrive.get(position).getSex());
//                            setResult(Constant.TAG_FIVE, i);
//                            finish();
//                        }
//                    });
            }
        }
    };
}
