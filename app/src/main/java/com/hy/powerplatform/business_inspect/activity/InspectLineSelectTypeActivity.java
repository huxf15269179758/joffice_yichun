package com.hy.powerplatform.business_inspect.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.adapter.SelectInspectLineAdapter;
import com.hy.powerplatform.business_inspect.bean.InspectLine;
import com.hy.powerplatform.business_inspect.bean.ShowLine;
import com.hy.powerplatform.business_inspect.presenter.InspectLinePresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.InspectLinePresenterimpl;
import com.hy.powerplatform.business_inspect.utils.GetDataThread;
import com.hy.powerplatform.business_inspect.view.InspectLineView;
import com.hy.powerplatform.database.DbManager;
import com.hy.powerplatform.database.MyDatabaseHelper;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBack;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.EditTextChange;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InspectLineSelectTypeActivity extends BaseActivity implements InspectLineView {

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
    SelectInspectLineAdapter adapter;
    @BindView(R.id.etSelectLine)
    EditText etSelectLine;
    @BindView(R.id.imLineSelect)
    ImageView imLineSelect;
    InspectLinePresenter inspectLinePresenter;
    //获取线路数据库数据
    List<ShowLine> listInspectLine = new ArrayList<>();
    List<InspectLine.DataBean> listInspectLine1 = new ArrayList<>();
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.llimageView)
    LinearLayout llimageView;
    @BindView(R.id.activity_inspectlineselecttype)
    LinearLayout activityInspectlineselecttype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        inspectLinePresenter = new InspectLinePresenterimpl(this, this);
        alertDialogUtil = new AlertDialogUtil(this);
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        Intent intent = getIntent();
        etText = intent.getStringExtra("condition");
        new EditTextChange(etSelectLine).changeText();
        //判断数据库是否有线路信息
        decideDbForInspectLineData();
        new EditTextChange(editText).changeText();
    }

    /**
     * 判断数据库是否有线路信息
     */
    private void decideDbForInspectLineData() {
        //查询数据
        Cursor cursor;
        String sqlR = "select * from inspectLine";// order by random() limit 100
        cursor = DbManager.queryBySQL(db, sqlR, null);
        listInspectLine = DbManager.cursorToInspectLine(cursor);
        if (listInspectLine.size() != 0) {
            LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
            recyclerView.setLayoutManager(manager);
            adapter = new SelectInspectLineAdapter(listInspectLine);
            recyclerView.setAdapter(adapter);
            adapter.setOnClientMyTextView(new SelectInspectLineAdapter.CallBackPosition() {
                @Override
                public void myTextViewClient(int position) {
                    Intent i = new Intent();
                    i.putExtra("bianId", listInspectLine.get(position).getDepId());
                    i.putExtra("bianName", listInspectLine.get(position).getDepName());
                    i.putExtra("bianCode", listInspectLine.get(position).getLineCode());
                    Log.i("XXX", listInspectLine.get(position).getLineCode());
                    setResult(Constant.TAG_FOUR, i);
                    finish();
                }
            });
        } else {
            inspectLinePresenter.getInspectLinePresenterData();
        }
        new EditTextChange(editText).changeText();
    }

//    private void getAssessData() {
//        if (etText.isEmpty()) {
//            sql = "select * from inspectLine";
//        } else {
//            sql = "select * from inspectLine where depId like '" + etText + "%'";
//        }
//        cursor = DbManager.queryBySQL(db, sql, null);
//        listInspectLine = DbManager.cursorToInspectLine(cursor);
//        GetDataThread.getInspectLineData(etText, cursor, db, listInspectLine, new BaseRequestAssessLisenter() {
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
//                    listInspectLine = listCarCodeFromdb1;
//                    Message message = new Message();
//                    message.what = Constant.TAG_TWO;
//                    handler.sendMessage(message);
//                }
//            }
//        });
//    }
//    private void getAssessData1() {
//        String etText1 = etSelectLine.getText().toString();
//        if (etSelectLine.getText().toString().isEmpty()) {
//            sql = "select * from inspectLine";
//        } else {
//            sql = "select * from inspectLine where depId like '" + etText1 + "%'";
//        }
//        cursor = DbManager.queryBySQL(db, sql, null);
//        listInspectLine = DbManager.cursorToInspectLine(cursor);
//        GetDataThread.getInspectLineData(etText1, cursor, db, listInspectLine, new BaseRequestAssessLisenter() {
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
//                    listInspectLine = listCarCodeFromdb1;
//                    Message message = new Message();
//                    message.what = Constant.TAG_TWO;
//                    handler.sendMessage(message);
//                }
//            }
//        });
//    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_inspectlineselecttype;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }


    @Override
    public void getInspectLineViewData(InspectLine inspectLine) {
        if (inspectLine.getData().size() != 0) {
            for (int i = 0; i < inspectLine.getData().size(); i++) {
                listInspectLine1.add(inspectLine.getData().get(i));
                String depID = inspectLine.getData().get(i).getDepId();
                String lineCode = inspectLine.getData().get(i).getLineCode();
                String depName = inspectLine.getData().get(i).getDepName();
                ShowLine resultBean = new ShowLine(lineCode,depID,depName);
                listInspectLine.add(resultBean);
            }
            GetDataThread.saveInspectLineData(inspectLine, db, helper, listInspectLine1);
            LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
            recyclerView.setLayoutManager(manager);
            adapter = new SelectInspectLineAdapter(listInspectLine);
            recyclerView.setAdapter(adapter);
            adapter.setOnClientMyTextView(new SelectInspectLineAdapter.CallBackPosition() {
                @Override
                public void myTextViewClient(int position) {
                    Intent i = new Intent();
                    i.putExtra("bianId", listInspectLine.get(position).getDepId());
                    i.putExtra("bianName", listInspectLine.get(position).getDepName());
                    i.putExtra("bianCode", listInspectLine.get(position).getLineCode());
                    Log.i("XXX", listInspectLine.get(position).getLineCode());
                    setResult(Constant.TAG_FOUR, i);
                    finish();
                }
            });
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

    @OnClick(R.id.imageView)
    public void onViewClicked() {
        String tag = editText.getText().toString();
        listInspectLine = new ArrayList<>();
        if (!tag.isEmpty()) {
            String sql = "select * from inspectLine where lineCode like '%" + tag + "%'";
            cursor = DbManager.queryBySQL(db, sql, null);
            listInspectLine = DbManager.cursorToInspectLine(cursor);
            if (listInspectLine.size()!=0){
                adapter = new SelectInspectLineAdapter(listInspectLine);
                recyclerView.setAdapter(adapter);
                adapter.setOnClientMyTextView(new SelectInspectLineAdapter.CallBackPosition() {
                    @Override
                    public void myTextViewClient(int position) {
                        Intent i = new Intent();
                        i.putExtra("bianId", listInspectLine.get(position).getDepId());
                        i.putExtra("bianName", listInspectLine.get(position).getDepName());
                        i.putExtra("bianCode", listInspectLine.get(position).getLineCode());
                        Log.i("XXX", listInspectLine.get(position).getLineCode());
                        setResult(Constant.TAG_FOUR, i);
                        finish();
                    }
                });
                adapter.notifyDataSetChanged();
            }else {
                recyclerView.setVisibility(View.GONE);
                llimageView.setVisibility(View.VISIBLE);
            }
        } else {
            Toast.makeText(this, "请输入关键字", Toast.LENGTH_SHORT).show();
        }
    }
}
