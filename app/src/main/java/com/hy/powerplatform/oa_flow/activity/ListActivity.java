package com.hy.powerplatform.oa_flow.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.oa_flow.adapter.ListAdapter;
import com.hy.powerplatform.oa_flow.bean.MyNum;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<MyNum.ResultBean> beanList = new ArrayList<>();
    List<String> numList = new LinkedList<>();
    ListAdapter adapter;

    String rolues;
    List<String> dataList = new ArrayList<>();
    List<String> roluesList = new ArrayList<>();
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        rolues = new SharedPreferencesHelper(this, "login").getData(this, "rolues", "");
        String userName = new SharedPreferencesHelper(this, "login").getData(this, "userStatus", "");
//        ProgressDialogUtil.startLoad(this, "获取数据中...");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String turl = Constant.BASE_URL2 + Constant.NUMDAIBAN;
//                DBHandler dbA = new DBHandler();
//                String res = dbA.getNumDaiBan(turl);
//                Message message = new Message();
//                message.what = Constant.TAG_ONE;
//                Bundle bundle = new Bundle();
//                // 将服务器返回的订单号传到Bundle中，，再通过handler传出
//                bundle.putString("data", res);
//                message.setData(bundle);
//                handler.sendMessage(message);
//            }
//        }).start();
        roluesList.add("行政管理");
        roluesList.add("人资管理");
        roluesList.add("财务管理");
        roluesList.add("采购管理");
        roluesList.add("发文管理");

        numList.add("N");
        numList.add("N");
        numList.add("N");
        numList.add("N");
        numList.add("N");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        if (userName.equals("超级管理员")) {
            adapter = new ListAdapter(ListActivity.this, roluesList);
            recyclerView.setAdapter(adapter);
        } else {
            getJsonData();
        }
    }

    private void getJsonData() {
        try {
            JSONArray jsonArray = new JSONArray(rolues);
            if (jsonArray.length() == 0) {
                recyclerView.setVisibility(View.GONE);
                llNoContent.setVisibility(View.VISIBLE);
            }
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                dataList.add(jsonObject.getString("name"));
            }

            if (!dataList.contains(Constant.OUTMESSAGENAME)) {
                roluesList.remove(4);
                numList.remove(4);
            }
            if (!dataList.contains(Constant.PUECHASEFLOWNAME)
                    && !dataList.contains(Constant.GOODSPUECHASENAME)
                    && !dataList.contains(Constant.WORKPUECHASENAME)
                    && !dataList.contains(Constant.CCTPUECHASENAME)
                    && !dataList.contains(Constant.GHPUECHASENAME)
                    && !dataList.contains(Constant.ZGSPAYNAME)) {
                roluesList.remove(3);
                numList.remove(3);
            }
            if (!dataList.contains(Constant.BILLNAME)
                    && !dataList.contains(Constant.PAYFLOWNAME)
                    && !dataList.contains(Constant.CONTRACEPAYNAME)
                    && !dataList.contains(Constant.GHPAYFLOWNAME)) {
                roluesList.remove(2);
                numList.remove(2);
            }
            if (!dataList.contains(Constant.DRIVERASSESSNAME)
                    && !dataList.contains(Constant.ASSESSNAME)
                    && !dataList.contains(Constant.CHUCAINAME)
                    && !dataList.contains(Constant.LEAVERNAME)
                    && !dataList.contains(Constant.ENTRYNAMENAME)
                    && !dataList.contains(Constant.OVERTINENAME)) {
                roluesList.remove(1);
                numList.remove(1);
            }
            if (!dataList.contains(Constant.EMAINTAINNAME)
                    && !dataList.contains(Constant.CARVIDEONAME)
                    && !dataList.contains(Constant.DORMNAME)
                    && !dataList.contains(Constant.GCADDNAME)
                    && !dataList.contains(Constant.GCCHECKNAME)
                    && !dataList.contains(Constant.COMPLAINNAME)
                    && !dataList.contains(Constant.JSGCNAME)
                    && !dataList.contains(Constant.INSTALLNNAME)
                    && !dataList.contains(Constant.DINNERNAME)
                    && !dataList.contains(Constant.CONTRACTSIGNNAME)
                    && !dataList.contains(Constant.APPEALNAME)
                    && !dataList.contains(Constant.CARSAFENAME)
                    && !dataList.contains(Constant.SAFERNAMES)
                    && !dataList.contains(Constant.SAFERNAMEY)
                    && !dataList.contains(Constant.USERCARNAME)
                    && !dataList.contains(Constant.HUIQIANNAME)
                    && !dataList.contains(Constant.GHCONTRACTSIGNNAME)
                    && !dataList.contains(Constant.COMPMESSAGENAME)
                    &&!dataList.contains(Constant.REPAIRNAME)) {
                roluesList.remove(0);
                numList.remove(0);
            }
            adapter = new ListAdapter(ListActivity.this, roluesList);
            recyclerView.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        ProgressDialogUtil.startLoad(this, "获取数据中...");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String turl = Constant.BASE_URL2 + Constant.NUMDAIBAN;
//                DBHandler dbA = new DBHandler();
//                String res = dbA.getNumDaiBan(turl);
//                Message message = new Message();
//                message.what = Constant.TAG_ONE;
//                Bundle bundle = new Bundle();
//                // 将服务器返回的订单号传到Bundle中，，再通过handler传出
//                bundle.putString("data", res);
//                message.setData(bundle);
//                handler.sendMessage(message);
//            }
//        }).start();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_list1;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            beanList.clear();
//            numList.clear();
//            numList.add("N");
//            numList.add("N");
//            numList.add("N");
//            numList.add("N");
//            numList.add("N");
//            String data = String.valueOf(msg.getData().get("data"));
//            MyNum bean = new Gson().fromJson(data, MyNum.class);
//            if (!bean.isSuccess()) {
//                Toast.makeText(ListActivity.this, "获取我的待办数据失败", Toast.LENGTH_SHORT).show();
//            } else {
//                for (int i = 0; i < bean.getTotalCounts(); i++) {
//                    beanList.add(bean.getResult().get(i));
//                }
//                if (beanList.size() != 0) {
//                    for (int i = 0; i < beanList.size(); i++) {
//                        if (beanList.get(i).getFormDefId().equals(Constant.EMAINTAIN)
//                                || beanList.get(i).getFormDefId().equals(Constant.CARVIDEO)
//                                || beanList.get(i).getFormDefId().equals(Constant.DORM)
//                                || beanList.get(i).getFormDefId().equals(Constant.GCADD)
//                                || beanList.get(i).getFormDefId().equals(Constant.COMPLAIN)
//                                || beanList.get(i).getFormDefId().equals(Constant.GCCHECK)
//                                || beanList.get(i).getFormDefId().equals(Constant.GCQD)
//                                || beanList.get(i).getFormDefId().equals(Constant.DINNER)
//                                || beanList.get(i).getFormDefId().equals(Constant.CONTRACTSIGN)
//                                || beanList.get(i).getFormDefId().equals(Constant.APPEAL)
//                                || beanList.get(i).getFormDefId().equals(Constant.CARSAFE)
//                                || beanList.get(i).getFormDefId().equals(Constant.SAFER1)
//                                || beanList.get(i).getFormDefId().equals(Constant.SAFER2)
//                                || beanList.get(i).getFormDefId().equals(Constant.USERCAR)
//                                || beanList.get(i).getFormDefId().equals(Constant.INSTALL)) {
//                            numList.remove(0);
//                            numList.add(0, "Y");
//                        }else if (beanList.get(i).getFormDefId().equals(Constant.DRIVERASSESS)
//                                || beanList.get(i).getFormDefId().equals(Constant.CHUCAI)
//                                ||beanList.get(i).getFormDefId().equals(Constant.LEAVER)
//                                ||beanList.get(i).getFormDefId().equals(Constant.ENTRY)
//                                ||beanList.get(i).getFormDefId().equals(Constant.OVERTIME)) {
//                            numList.remove(1);
//                            numList.add(1, "Y");
//                        }else if (beanList.get(i).getFormDefId().equals(Constant.BILL)
//                                || beanList.get(i).getFormDefId().equals(Constant.PAYFLOW)
//                                ||beanList.get(i).getFormDefId().equals(Constant.CONTRACEPAY)) {
//                            numList.remove(2);
//                            numList.add(2, "Y");
//                        }else  if (beanList.get(i).getFormDefId().equals(Constant.REPAIR)
//                                || beanList.get(i).getFormDefId().equals(Constant.PUECHASEFLOW)
//                                ||beanList.get(i).getFormDefId().equals(Constant.GOODSPUECHASE)
//                                ||beanList.get(i).getFormDefId().equals(Constant.WORKPUECHASE)) {
//                            numList.remove(3);
//                            numList.add(3, "Y");
//                        }else if (beanList.get(i).getFormDefId().equals(Constant.OUTMESSAGE)) {
//                            numList.remove(4);
//                            numList.add(4, "Y");
//                        }
//                    }
//                    adapter = new ListAdapter(ListActivity.this, dataList,numList);
//                    recyclerView.setAdapter(adapter);
//                    ProgressDialogUtil.stopLoad();
//                } else {
//                    adapter = new ListAdapter(ListActivity.this, dataList,numList);
//                    recyclerView.setAdapter(adapter);
//                    ProgressDialogUtil.stopLoad();
//                }
//            }
//        }
//    };
}
