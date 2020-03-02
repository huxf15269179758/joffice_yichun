package com.hy.powerplatform.business_inspect.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.adapter.SelectInspectDriveAdapter;
import com.hy.powerplatform.business_inspect.bean.NewDriver;
import com.hy.powerplatform.business_inspect.presenter.InspectDrivePresenter;
import com.hy.powerplatform.database.DbManager;
import com.hy.powerplatform.database.MyDatabaseHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.EditTextChange;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.HttpURLConnectionCallBackListener;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InspectDriveSelectTypeActivity extends BaseActivity  {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    String etText;
    SQLiteDatabase db;
    Cursor cursor;
    MyDatabaseHelper helper;
    AlertDialogUtil alertDialogUtil;
    SelectInspectDriveAdapter adapter;
    List<NewDriver.DataBean> listInspectDrive = new ArrayList<>();
    List<NewDriver.DataBean> listInspectDrive1 = new ArrayList<>();
    InspectDrivePresenter inspectDrivePresenter;
    String sql;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.etSelectLine)
    EditText etSelectLine;
    @BindView(R.id.imLineSelect)
    ImageView imLineSelect;
    @BindView(R.id.llimageView)
    LinearLayout llimageView;
    @BindView(R.id.activity_inspectlineselecttype)
    LinearLayout activityInspectlineselecttype;

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
        //判断数据库是否有驾驶员信息
        decideDbForInspectDriveData();
        new EditTextChange(editText).changeText();
    }

    /**
     * 判断数据库是否有驾驶员信息
     */
    private void decideDbForInspectDriveData() {
        //查询数据
        Cursor cursor;
        String sqlR = "select * from inspectDriveP";// order by random() limit 100
        cursor = DbManager.queryBySQL(db, sqlR, null);
        listInspectDrive = DbManager.cursorToInspectDrive(cursor);
        if (listInspectDrive.size() != 0) {
            LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
            recyclerView.setLayoutManager(manager);
            adapter = new SelectInspectDriveAdapter(listInspectDrive);
            recyclerView.setAdapter(adapter);
            ProgressDialogUtil.stopLoad();
            adapter.setOnClientMyTextView(new SelectInspectDriveAdapter.CallBackPosition() {
                @Override
                public void myTextViewClient(int position) {
                    Intent i = new Intent();
                    i.putExtra("bian", listInspectDrive.get(position).getFullname());
                    i.putExtra("bianId", listInspectDrive.get(position).getProfileId());
                    i.putExtra("bianName", listInspectDrive.get(position).getFullname());
                    setResult(Constant.TAG_FIVE, i);
                    finish();
                }
            });
        } else {
            SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
            String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
            String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";
            String url = BASE_URL+"hrm/profileByPosEmpProfile.do";
            Util.getDataByHttpUrlConnection(url, new HttpURLConnectionCallBackListener() {
                @Override
                public void onSuccess(String s) {
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0;i<jsonArray.length();i++){
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            String name = jsonObject1.getString("fullname");
                            String profileId = jsonObject1.getString("profileId");
                            String sex = jsonObject1.getString("sex");
                            String userCode = jsonObject1.getString("userCode");
                            ContentValues values = new ContentValues();
                            values.put(com.hy.powerplatform.database.Constant.DRIVERNAME, name);
                            values.put(com.hy.powerplatform.database.Constant.DRIVERID, profileId);
                            values.put(com.hy.powerplatform.database.Constant.SEX, sex);
                            values.put(com.hy.powerplatform.database.Constant.USERCODE, userCode);
                            db.insert(com.hy.powerplatform.database.Constant.TABBLE_INSPECT_DRIVE_P, null, values);
                            values.clear();
                            NewDriver.DataBean bean = new NewDriver.DataBean(name,profileId,sex,userCode);
                            listInspectDrive1.add(bean);
                        }
                        Message message = new Message();
                        message.what = Constant.TAG_ONE;
                        handler.sendMessage(message);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFaile(Exception e) {

                }
            });
            //inspectDrivePresenter.getInspectDrivePresenterData();
        }
    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
            recyclerView.setLayoutManager(manager);
            adapter = new SelectInspectDriveAdapter(listInspectDrive1);
            recyclerView.setAdapter(adapter);
            ProgressDialogUtil.stopLoad();
            adapter.setOnClientMyTextView(new SelectInspectDriveAdapter.CallBackPosition() {
                @Override
                public void myTextViewClient(int position) {
                    Intent i = new Intent();
                    i.putExtra("bian", listInspectDrive1.get(position).getFullname());
                    i.putExtra("bianId", listInspectDrive1.get(position).getProfileId());
                    i.putExtra("bianName", listInspectDrive1.get(position).getFullname());
                    setResult(Constant.TAG_FIVE, i);
                    finish();
                }
            });
        }
    };

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_inspectdriverselecttype;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

//    @Override
//    public void getInspectDriveViewData(InspectDrive inspectDrive) {
//        if (inspectDrive.getData().size() != 0) {
//            for (int i = 0; i < inspectDrive.getData().size(); i++) {
//                listInspectDrive.add(inspectDrive.getData().get(i));
//            }
//            GetDataThread.saveInspectDriveData(inspectDrive, db, helper, listInspectDrive);
//            LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
//            recyclerView.setLayoutManager(manager);
//            adapter = new SelectInspectDriveAdapter(listInspectDrive);
//            recyclerView.setAdapter(adapter);
//            adapter.setOnClientMyTextView(new SelectInspectDriveAdapter.CallBackPosition() {
//                @Override
//                public void myTextViewClient(int position) {
//                    Intent i = new Intent();
//                    i.putExtra("bian", listInspectDrive.get(position).getFullname());
//                    i.putExtra("bianId", listInspectDrive.get(position).getProfileId());
//                    i.putExtra("bianName", listInspectDrive.get(position).getFullname());
//                    i.putExtra("bianDriver", listInspectDrive.get(position).getUserCode());
//                    setResult(Constant.TAG_FIVE, i);
//                    finish();
//                }
//            });
//        } else {
//            alertDialogUtil.showDialog(getResources().getString(R.string.no_search_phone)
//                    , new AlertDialogCallBack() {
//                        @Override
//                        public void confirm() {
//                            finish();
//                        }
//
//                        @Override
//                        public void cancel() {
//                            finish();
//                        }
//                    });
//        }
//    }

    @OnClick(R.id.imageView)
    public void onViewClicked() {
        String tag = editText.getText().toString();
        listInspectDrive = new ArrayList<>();
        if (!tag.isEmpty()) {
            String sql = "select * from inspectDriveP where fullname like '%" + tag + "%'";
            cursor = DbManager.queryBySQL(db, sql, null);
            listInspectDrive = DbManager.cursorToInspectDrive(cursor);
            if (listInspectDrive.size()!=0){
                recyclerView.setVisibility(View.VISIBLE);
                llimageView.setVisibility(View.GONE);
                adapter = new SelectInspectDriveAdapter(listInspectDrive);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                adapter.setOnClientMyTextView(new SelectInspectDriveAdapter.CallBackPosition() {
                    @Override
                    public void myTextViewClient(int position) {
                        Intent i = new Intent();
                        i.putExtra("bian", listInspectDrive.get(position).getFullname());
                        i.putExtra("bianId", listInspectDrive.get(position).getProfileId());
                        i.putExtra("bianName", listInspectDrive.get(position).getFullname());
                        setResult(Constant.TAG_FIVE, i);
                        finish();
                    }
                });
            }else {
                recyclerView.setVisibility(View.GONE);
                llimageView.setVisibility(View.VISIBLE);
            }
        } else {
            Toast.makeText(this, "请输入关键字", Toast.LENGTH_SHORT).show();
        }
    }
}
