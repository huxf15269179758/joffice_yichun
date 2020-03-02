package com.hy.powerplatform.business_inspect.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.adapter.ShiGuHisAdapter;
import com.hy.powerplatform.business_inspect.bean.ShiGuHis;
import com.hy.powerplatform.business_inspect.presenter.HisPresenter;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.HttpURLConnectionCallBackListener;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.Util;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShiGuListActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.imageView)
    LinearLayout imageView;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.ivCheck)
    ImageView ivCheck;
    @BindView(R.id.header)
    Header header;

    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    HisPresenter hisPresenter;
    List<ShiGuHis.ResultBean> hisList = new ArrayList<>();
    ShiGuHisAdapter adapter;
    private View view;
    String userCode;
    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        SharedPreferencesHelper helper = new SharedPreferencesHelper(this, "login");
        userCode = helper.getData(this, "userName", "");
        initDatePicker();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_shi_gu_list;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, -7);
        Date d = c.getTime();
        String day = format.format(d);
        tvStartTime.setText(day);
        System.out.println("过去七天：" + day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        tvEndTime.setText(now.split(" ")[0]);
        getHttpData();

        customDatePicker1 = new CustomDatePickerDay(ShiGuListActivity.this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvStartTime.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(ShiGuListActivity.this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvEndTime.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(false); // 显示时和分
        customDatePicker2.setIsLoop(false); // 允许循环滚动
    }

    @OnClick({R.id.tvStartTime, R.id.tvEndTime, R.id.ivCheck})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvStartTime:
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.tvEndTime:
                customDatePicker2.show(tvStartTime.getText().toString());
                break;
            case R.id.ivCheck:
                getHttpData();
                break;
        }
    }

    /**
     * 获取网络数据
     */
    private void getHttpData() {
        hisList = new ArrayList<>();
        Date startTime = null, endTime = null;
        if (tvStartTime.getText().toString().isEmpty() || tvStartTime.getText().toString().isEmpty()) {
            Toast.makeText(ShiGuListActivity.this, "起止时间不能为空", Toast.LENGTH_SHORT).show();
        } else {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                startTime = sdf1.parse(tvStartTime.getText().toString());
                endTime = sdf1.parse(tvEndTime.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (startTime.getTime() > endTime.getTime()) {
            Toast.makeText(ShiGuListActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
        } else {
            String url = BASE_URL + "busmanager/listMobileAcciAccidentBasicInformation.do" +
                    "?beginDate=" + tvStartTime.getText().toString() +
                    "&endDate=" + tvEndTime.getText().toString() + "&operCode=" + userCode + "";
            ProgressDialogUtil.startLoad(ShiGuListActivity.this, Constant.GETDATA);
            Util.getDataByHttpUrlConnection(url, new HttpURLConnectionCallBackListener() {
                @Override
                public void onSuccess(String s) {
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        JSONArray jsonArray = jsonObject.getJSONArray("result");
                        int num = jsonArray.length();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            ShiGuHis.ResultBean bean = new ShiGuHis.ResultBean();
                            JSONObject jsonObjectBean = jsonArray.getJSONObject(i);
                            bean.setAtId(jsonObjectBean.getString("atId"));
                            bean.setAtCode(jsonObjectBean.getString("atCode"));
                            bean.setCarNo(jsonObjectBean.getString("carNo"));
                            bean.setBusCode(jsonObjectBean.getString("busCode"));
                            bean.setAtAtDate(jsonObjectBean.getString("atAtDate"));
                            bean.setAtTime(jsonObjectBean.getString("atTime"));
                            bean.setDriverName(jsonObjectBean.getString("driverName"));
                            bean.setDriverCode(jsonObjectBean.getString("driverCode"));
                            bean.setAtReason(jsonObjectBean.getString("atReason"));
                            bean.setAtPlace(jsonObjectBean.getString("atPlace"));
                            bean.setLineCode(jsonObjectBean.getString("lineCode"));
                            bean.setAtType(jsonObjectBean.getString("atType"));
                            bean.setAtLiability(jsonObjectBean.getString("atLiability"));
                            bean.setAtEmptysMile(jsonObjectBean.getString("atEmptysMile"));
                            bean.setDepId(jsonObjectBean.getString("depId"));
                            bean.setDepName(jsonObjectBean.getString("depName"));
                            bean.setAcNature(jsonObjectBean.getString("acNature"));
                            bean.setAcSecurityAward(jsonObjectBean.getString("acSecurityAward"));
                            bean.setAcBuckleFacilitiesAward(jsonObjectBean.getString("acBuckleFacilitiesAward"));
                            bean.setDriverIdCard(jsonObjectBean.getString("driverIdCard"));
                            bean.setSideName(jsonObjectBean.getString("sideName"));
                            bean.setSideContact(jsonObjectBean.getString("sideContact"));
                            bean.setSideCarPlate(jsonObjectBean.getString("sideCarPlate"));
                            bean.setSideLicenseNum(jsonObjectBean.getString("sideLicenseNum"));
                            bean.setAtOperCode(jsonObjectBean.getString("atOperCode"));
//                            bean.setAtOperName(jsonObjectBean.getString("atOperName"));
                            bean.setAtOtherPay(jsonObjectBean.getString("atOtherPay"));
                            bean.setAtPersonPay(jsonObjectBean.getString("atPersonPay"));
                            bean.setPartyId(jsonObjectBean.getString("partyId"));
                            bean.setAtTreatmentId(jsonObjectBean.getString("atTreatmentId"));
                            hisList.add(bean);
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
                    Looper.prepare();
                    ProgressDialogUtil.stopLoad();
                    Looper.loop();
                }
            });
        }
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (hisList.size() == 0) {
                imageView.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                ProgressDialogUtil.stopLoad();
            } else {
                adapter = new ShiGuHisAdapter(ShiGuListActivity.this, hisList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                recyclerView.setVisibility(View.VISIBLE);
                ProgressDialogUtil.stopLoad();
            }
        }
    };
}
