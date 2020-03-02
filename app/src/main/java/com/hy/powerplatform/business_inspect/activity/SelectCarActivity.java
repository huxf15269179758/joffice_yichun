package com.hy.powerplatform.business_inspect.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.adapter.SelectCarAdapter;
import com.hy.powerplatform.business_inspect.bean.CarCode;
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
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectCarActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    String etText;
    int position;
    SQLiteDatabase db;
    Cursor cursor;
    MyDatabaseHelper helper;
    AlertDialogUtil alertDialogUtil;
    SelectCarAdapter adapter;
    String selectCar;
    List<CarCode.DataBean> listCarCodeFromdb = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        alertDialogUtil = new AlertDialogUtil(this);
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        Intent intent = getIntent();
        etText = intent.getStringExtra("condition");
        ProgressDialogUtil.startLoad(this, Constant.GETDATA);
        //查询数据
        getAssessData();
    }

    private void getAssessData() {
        String sql;
        if (etText.isEmpty()) {
            sql = "select * from carcode";
        } else {
            sql = "select * from carcode where name like '%" + etText + "%'";
        }
        cursor = DbManager.queryBySQL(db, sql, null);
        listCarCodeFromdb = DbManager.cursorToClassCar(cursor);
        GetDataThread.getCarCoodeData(etText, cursor, db, listCarCodeFromdb, new BaseRequestAssessLisenter() {
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
                    listCarCodeFromdb = listCarCodeFromdb1;
                    Message message = new Message();
                    message.what = Constant.TAG_TWO;
                    handler.sendMessage(message);
                }
            }
        });
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
                    adapter = new SelectCarAdapter(listCarCodeFromdb);
                    recyclerView.setAdapter(adapter);
                    ProgressDialogUtil.stopLoad();
            }
        }
    };


    @Override
    protected int provideContentViewId() {
        return R.layout.activity_selectcar;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        selectCar = adapter.getSelectCar();
        Intent i = new Intent();
        i.putExtra("bian", selectCar);
        setResult(Constant.TAG_THERE, i);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
