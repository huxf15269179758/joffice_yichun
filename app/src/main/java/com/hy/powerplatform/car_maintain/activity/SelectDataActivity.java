package com.hy.powerplatform.car_maintain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.car_maintain.adapter.SelectDataAdapter;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.BaseRequestBackTLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.base.MyHttpURLConnection;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectDataActivity extends BaseActivity implements SelectDataAdapter.CallBackPosition {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<String> dataList = new ArrayList<>();
    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(), "login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(), "Found", "");
    String BASE_URL = "http://" + sharedPreferencesHelper.getData(MyApplication.getContextObject(), "Ip", "")
            + ":" + sharedPreferencesHelper.getData(MyApplication.getContextObject(), "Socket", "") + "/" + found + "/";
    SelectDataAdapter.CallBackPosition callBackPosition ;
    String headerT;
    SelectDataAdapter adapter;
    String Url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        Intent intent = getIntent();
        headerT = intent.getStringExtra("tag");
        header.setTvTitle(headerT);
        //获取数据
        setUrl();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_select_data;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    public void setUrl() {
        if (headerT.equals("自编号")) {
            Url = BASE_URL + "admin/getBusBydepCar.do";
        } else if (headerT.equals("车牌号")) {
            Url = BASE_URL + "admin/getBusBydepCar.do";
        } else if (headerT.equals("线路")) {
            Url = BASE_URL + "system/getLineStoreAllLineInfo.do";
        } else if (headerT.equals("驾驶员")) {
            Url = BASE_URL + "hrm/selectJSYEmpProfile.do";
        } else if (headerT.equals("报修人")) {
            Url = BASE_URL + "hrm/selectJSYEmpProfile.do";
        } else if (headerT.equals("检查人")) {
            Url = BASE_URL + "system/comboItemDictionary.do?nodeKey=weixiujianyanren";
        } else if (headerT.equals("维修厂")) {
            Url = BASE_URL + "system/comboItemDictionary.do?nodeKey=weixiuchang";
        } else if (headerT.equals("维修类型")) {
            Url = BASE_URL + "system/comboItemDictionary.do?nodeKey=baoxiuleixing";
        }
        getListData();
    }

    private void getListData() {
        ProgressDialogUtil.startLoad(this, "获取数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyHttpURLConnection.getData(Url, new BaseRequestBackTLisenter() {
                    @Override
                    public void success(Object o) {
                        String data = (String) o;
                        if (headerT.equals("自编号")) {
                            dataList.clear();
                            try {
                                JSONArray jsonArray = new JSONArray(data);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    if (jsonObject.getString("busCode") != "E01572") {
                                        String carNo = jsonObject.getString("busCode");
                                        dataList.add(carNo);
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else if (headerT.equals("车牌号")) {
                            dataList.clear();
                            try {
                                JSONArray jsonArray = new JSONArray(data);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    if (jsonObject.getString("busNo") != "E01572") {
                                        String carNo = jsonObject.getString("busNo");
                                        dataList.add(carNo);
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else if (headerT.equals("线路")) {
                            dataList.clear();
                            try {
                                JSONObject jsonObject = new JSONObject(data);
                                JSONArray jsonArray = jsonObject.getJSONArray("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                    String lineCode = jsonObject1.getString("lineCode");
                                    dataList.add(lineCode);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else if (headerT.equals("驾驶员")) {
                            dataList.clear();
                            try {
                                JSONObject jsonObject = new JSONObject(data);
                                JSONArray jsonArray = jsonObject.getJSONArray("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                    String driverName = jsonObject1.getString("fullname");
                                    dataList.add(driverName);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else if (headerT.equals("报修人")) {
                            dataList.clear();
                            try {
                                JSONObject jsonObject = new JSONObject(data);
                                JSONArray jsonArray = jsonObject.getJSONArray("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                    String baoxiuren = jsonObject1.getString("fullname");
                                    dataList.add(baoxiuren);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else if (headerT.equals("检查人")) {
                            dataList.clear();
                            try {
                                JSONObject jsonObject = new JSONObject(data);
                                JSONArray jsonArray = jsonObject.getJSONArray("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                    String jiancharen = jsonObject1.getString("itemValue");
                                    dataList.add(jiancharen);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else if (headerT.equals("维修厂")) {
                            dataList.clear();
                            try {
                                JSONObject jsonObject = new JSONObject(data);
                                JSONArray jsonArray = jsonObject.getJSONArray("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                    String weixiuchang = jsonObject1.getString("itemValue");
                                    dataList.add(weixiuchang);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else if (headerT.equals("维修类型")) {
                            dataList.clear();
                            try {
                                JSONObject jsonObject = new JSONObject(data);
                                JSONArray jsonArray = jsonObject.getJSONArray("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                    String baoxiuleixing = jsonObject1.getString("itemValue");
                                    dataList.add(baoxiuleixing);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        //实现排序方法  
                        Collections.sort(dataList,new Comparator<String>() {
                            @Override
                            public int compare(String  o1, String  o2) {
                                if(o1 == null || o2 == null){
                                    return -1;
                                }
                                if(o1.length() > o2.length()){
                                    return 1;
                                }
                                if(o1.length() < o2.length()){
                                    return -1;
                                }
                                if(o1.compareTo(o2) > 0){
                                    return 1;
                                }
                                if(o1.compareTo(o2) < 0){
                                    return -1;
                                }
                                if(o1.compareTo(o2) == 0){
                                    return 0;
                                }
                                return 0;
                            }
                        });
                        Message message = new Message();
                        message.what = Constant.TAG_ONE;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void fail(String msg) {
                        Message message = new Message();
                        message.what = Constant.TAG_ONE;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void failF(String msg) {
                        Message message = new Message();
                        message.what = Constant.TAG_ONE;
                        handler.sendMessage(message);
                    }
                });
            }
        }).start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    adapter = new SelectDataAdapter(SelectDataActivity.this, dataList);
                    recyclerView.setAdapter(adapter);
                    adapter.selectTextViewPosition(SelectDataAdapter.getInf());
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_TWO:
                    Toast.makeText(SelectDataActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_THERE:
                    Toast.makeText(SelectDataActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;

            }
        }
    };

    @Override
    public void myTextViewClient(int position) {
        Toast.makeText(this, dataList.get(position), Toast.LENGTH_SHORT).show();
    }
}
