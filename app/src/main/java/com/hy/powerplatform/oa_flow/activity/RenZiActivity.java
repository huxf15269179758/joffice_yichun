package com.hy.powerplatform.oa_flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.bean.MyNum;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RenZiActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.llDriverAssess)
    LinearLayout llDriverAssess;
    @BindView(R.id.tvDriverAssess)
    TextView tvDriverAssess;
    @BindView(R.id.llChuCai)
    LinearLayout llChuCai;
    @BindView(R.id.tvChuCai)
    TextView tvChuCai;
    @BindView(R.id.llLeave)
    LinearLayout llLeave;
    @BindView(R.id.tvLeave)
    TextView tvLeave;
    @BindView(R.id.llEntry)
    LinearLayout llEntry;
    @BindView(R.id.tvEntry)
    TextView tvEntry;
    List<MyNum.ResultBean> beanList = new ArrayList<>();
    Intent intent;
    @BindView(R.id.flDriverAssess)
    FrameLayout flDriverAssess;
    @BindView(R.id.flChuCai)
    FrameLayout flChuCai;
    @BindView(R.id.flLeave)
    FrameLayout flLeave;
    @BindView(R.id.flEntry)
    FrameLayout flEntry;

    String rolues;
    List<String> dataList = new ArrayList<>();
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.llwoekEnter)
    LinearLayout llwoekEnter;
    @BindView(R.id.flwoekEnter)
    FrameLayout flwoekEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        rolues = new SharedPreferencesHelper(this, "login").getData(this, "rolues", "");
        String userName = new SharedPreferencesHelper(this, "login").getData(this, "userStatus", "");

        if (userName.equals("超级管理员")) {
            getData();
        } else {
            getJsonData();
        }
    }

    private void getData() {
        ProgressDialogUtil.startLoad(this, "获取数据中...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String turl = Constant.BASE_URL2 + Constant.NUMDAIBAN;
                DBHandler dbA = new DBHandler();
                String res = dbA.getNumDaiBan(turl);
                Message message = new Message();
                message.what = Constant.TAG_ONE;
                Bundle bundle = new Bundle();
                // 将服务器返回的订单号传到Bundle中，，再通过handler传出
                bundle.putString("data", res);
                message.setData(bundle);
                handler.sendMessage(message);
            }
        }).start();
    }

    private void getJsonData() {
        try {
            JSONArray jsonArray = new JSONArray(rolues);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                dataList.add(jsonObject.getString("name"));
            }

            //&& !dataList.contains(Constant.ASSESSNAME)
            if (!dataList.contains(Constant.DRIVERASSESSNAME)
                    && !dataList.contains(Constant.CHUCAINAME)
                    && !dataList.contains(Constant.LEAVERNAME)
                    && !dataList.contains(Constant.ENTRYNAMENAME)
                    && !dataList.contains(Constant.OVERTINENAME)) {
                llNoContent.setVisibility(View.VISIBLE);
            } else {
                if (!dataList.contains(Constant.DRIVERASSESSNAME)) {
                    flDriverAssess.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.ASSESSNAME)) {
                    flwoekEnter.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.CHUCAINAME)) {
                    flChuCai.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.LEAVERNAME)) {
                    flLeave.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.ENTRYNAMENAME)) {
                    flEntry.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.ENTRYNAMENAME)) {
                    flEntry.setVisibility(View.GONE);
                }
//                getData();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        getData();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_ren_zi;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.llDriverAssess, R.id.llChuCai, R.id.llLeave, R.id.llEntry,R.id.llwoekEnter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llDriverAssess:
                intent = new Intent(this, FlowDriverAssessActivity.class);
                startActivity(intent);
                break;
            case R.id.llwoekEnter:
                intent = new Intent(this, FlowAssessActivity.class);
                startActivity(intent);
                break;
            case R.id.llChuCai:
                intent = new Intent(this, FlowChuCaiActivity.class);
                startActivity(intent);
                break;
            case R.id.llLeave:
                intent = new Intent(this, FlowLeaveActivity.class);
                startActivity(intent);
                break;
            case R.id.llEntry:
                intent = new Intent(this, FlowEntryActivity.class);
                startActivity(intent);
                break;
//            case R.id.llOverTime:
//                intent = new Intent(this, FlowOverTimeActivity.class);
//                startActivity(intent);
//                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tvLeave.setVisibility(View.GONE);
            tvLeave.setText("");
            tvEntry.setVisibility(View.GONE);
            tvEntry.setText("");
            tvChuCai.setVisibility(View.GONE);
            tvChuCai.setText("");
            tvDriverAssess.setVisibility(View.GONE);
            tvDriverAssess.setText("");
            String data = String.valueOf(msg.getData().get("data"));
            MyNum bean = new Gson().fromJson(data, MyNum.class);
            if (!bean.isSuccess()) {
                Toast.makeText(RenZiActivity.this, "获取我的待办数据失败", Toast.LENGTH_SHORT).show();
            } else {
                for (int i = 0; i < bean.getTotalCounts(); i++) {
                    beanList.add(bean.getResult().get(i));
                }
                if (beanList.size() != 0) {
                    for (int i = 0; i < beanList.size(); i++) {
                        if (beanList.get(i).getFormDefId().equals(Constant.LEAVER)) {
                            tvLeave.setVisibility(View.VISIBLE);
                            tvLeave.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.ENTRY)) {
                            tvEntry.setVisibility(View.VISIBLE);
                            tvEntry.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.CHUCAI)) {
                            tvChuCai.setVisibility(View.VISIBLE);
                            tvChuCai.setText(beanList.get(i).getSl());
                        }
//                        if (beanList.get(i).getFormDefId().equals(Constant.OVERTIME)) {
//                            tvOverTime.setVisibility(View.VISIBLE);
//                            tvOverTime.setText(beanList.get(i).getSl());
//                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.DRIVERASSESS)) {
                            tvDriverAssess.setVisibility(View.VISIBLE);
                            tvDriverAssess.setText(beanList.get(i).getSl());
                        }
                    }
                    ProgressDialogUtil.stopLoad();
                } else {
                    ProgressDialogUtil.stopLoad();
                }
            }
        }
    };

}
