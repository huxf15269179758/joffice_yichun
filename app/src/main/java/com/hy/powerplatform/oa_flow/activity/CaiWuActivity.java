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

public class CaiWuActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.llBill)
    LinearLayout llBill;
    @BindView(R.id.tvBill)
    TextView tvBill;
    @BindView(R.id.llFuKuanLiuCheng)
    LinearLayout llFuKuanLiuCheng;
    @BindView(R.id.tvFuKuanLiuCheng)
    TextView tvFuKuanLiuCheng;
    @BindView(R.id.llContractPay)
    LinearLayout llContractPay;
    @BindView(R.id.tvContractPay)
    TextView tvContractPay;
    Intent intent;
    List<MyNum.ResultBean> beanList = new ArrayList<>();
    String rolues;
    List<String> dataList = new ArrayList<>();
    @BindView(R.id.inNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.flBill)
    FrameLayout flBill;
    @BindView(R.id.flFuKuanLiuCheng)
    FrameLayout flFuKuanLiuCheng;
    @BindView(R.id.flContractPay)
    FrameLayout flContractPay;
    @BindView(R.id.tvContractSign)
    TextView tvContractSign;
    @BindView(R.id.tvGoodsPurchase)
    TextView tvGoodsPurchase;
    @BindView(R.id.tvGHPay)
    TextView tvGHPay;
    @BindView(R.id.llGHPay)
    LinearLayout llGHPay;
//    @BindView(R.id.flGHPay)
//    FrameLayout flGHPay;
    @BindView(R.id.llGHSingle)
    LinearLayout llGHSingle;
    @BindView(R.id.flGHSingle)
    FrameLayout flGHSingle;
    @BindView(R.id.llzgs)
    LinearLayout llzgs;
    @BindView(R.id.flZgs)
    FrameLayout flZgs;

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

            if (!dataList.contains(Constant.BILLNAME)
                    && !dataList.contains(Constant.PAYFLOWNAME)
                    && !dataList.contains(Constant.CONTRACEPAYNAME)) {
                llNoContent.setVisibility(View.VISIBLE);
            } else {
                if (!dataList.contains(Constant.BILLNAME)) {
                    flBill.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.PAYFLOWNAME)) {
                    flFuKuanLiuCheng.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.CONTRACEPAYNAME)) {
                    flContractPay.setVisibility(View.GONE);
                }
//                if (!dataList.contains(Constant.GHPAYFLOWNAME)) {
//                    flGHPay.setVisibility(View.GONE);
//                }
                for (int i = 0; i < dataList.size(); i++) {
                    if (!dataList.get(i).equals(Constant.ZGSPAYNAME)) {
                        flZgs.setVisibility(View.GONE);
                    } else {
                        flZgs.setVisibility(View.VISIBLE);
                        break;
                    }
                }
                if (!dataList.contains(Constant.GHCONTRACTSIGNNAME)) {
                    flGHSingle.setVisibility(View.GONE);
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
        return R.layout.activity_cai_wu;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.llBill, R.id.llFuKuanLiuCheng, R.id.llContractPay, R.id.llGHPay, R.id.llGHSingle, R.id.llzgs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llzgs:
                intent = new Intent(this, FlowZgsActivity.class);
                startActivity(intent);
                break;
            case R.id.llBill:
                intent = new Intent(this, FlowBillActivity.class);
                startActivity(intent);
                break;
            case R.id.llFuKuanLiuCheng:
                intent = new Intent(this, FlowFuKuanLiuChengActivity.class);
                startActivity(intent);
                break;
            case R.id.llContractPay:
                intent = new Intent(this, FlowContractPayActivity.class);
                startActivity(intent);
                break;
            case R.id.llGHPay:
                intent = new Intent(this, FlowGHPayActivity.class);
                startActivity(intent);
                break;
            case R.id.llGHSingle:
                intent = new Intent(this, FlowGHContractSignActivity.class);
                startActivity(intent);
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            beanList.clear();
            tvFuKuanLiuCheng.setVisibility(View.GONE);
            tvFuKuanLiuCheng.setText("");
            tvContractPay.setVisibility(View.GONE);
            tvContractPay.setText("");
            tvBill.setVisibility(View.GONE);
            tvBill.setText("");
            String data = String.valueOf(msg.getData().get("data"));
            MyNum bean = new Gson().fromJson(data, MyNum.class);
            if (!bean.isSuccess()) {
                Toast.makeText(CaiWuActivity.this, "获取我的待办数据失败", Toast.LENGTH_SHORT).show();
            } else {
                for (int i = 0; i < bean.getTotalCounts(); i++) {
                    beanList.add(bean.getResult().get(i));
                }
                if (beanList.size() != 0) {
                    for (int i = 0; i < beanList.size(); i++) {
                        if (beanList.get(i).getFormDefId().equals(Constant.PAYFLOW)) {
                            tvFuKuanLiuCheng.setVisibility(View.VISIBLE);
                            tvFuKuanLiuCheng.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.CONTRACEPAY)) {
                            tvContractPay.setVisibility(View.VISIBLE);
                            tvContractPay.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.BILL)) {
                            tvBill.setVisibility(View.VISIBLE);
                            tvBill.setText(beanList.get(i).getSl());
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
