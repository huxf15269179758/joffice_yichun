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

public class CaiGouActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.llPurchase)
    LinearLayout llPurchase;
    @BindView(R.id.tvPurchase)
    TextView tvPurchase;
    @BindView(R.id.llGoodsPurchase)
    LinearLayout llGoodsPurchase;
    @BindView(R.id.tvGoodsPurchase)
    TextView tvGoodsPurchase;
    @BindView(R.id.llWorkPurchase)
    LinearLayout llWorkPurchase;
    @BindView(R.id.tvWorkPurchase)
    TextView tvWorkPurchase;
    Intent intent;
    List<MyNum.ResultBean> beanList = new ArrayList<>();
    @BindView(R.id.inNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.flPurchase)
    FrameLayout flPurchase;
    @BindView(R.id.flGoodsPurchase)
    FrameLayout flGoodsPurchase;
    @BindView(R.id.flWorkPurchase)
    FrameLayout flWorkPurchase;
    String rolues;
    List<String> dataList = new ArrayList<>();
    @BindView(R.id.tvCCTPurchase)
    TextView tvCCTPurchase;
    @BindView(R.id.llflCCTPurchase)
    LinearLayout llflCCTPurchase;
    @BindView(R.id.flCCTPurchase)
    FrameLayout flCCTPurchase;
    @BindView(R.id.tvGHPurchase)
    TextView tvGHPurchase;
    @BindView(R.id.llGHPurchase)
    LinearLayout llGHPurchase;
    @BindView(R.id.flGHPurchase)
    FrameLayout flGHPurchase;

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
            if (!dataList.contains(Constant.PUECHASEFLOWNAME)
                    && !dataList.contains(Constant.GOODSPUECHASENAME)
                    && !dataList.contains(Constant.WORKPUECHASENAME)
                    && !dataList.contains(Constant.CCTPUECHASENAME)
                    && !dataList.contains(Constant.GHPUECHASENAME)) {
                llNoContent.setVisibility(View.VISIBLE);
            } else {
                if (!dataList.contains(Constant.PUECHASEFLOWNAME)) {
                    flPurchase.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.GOODSPUECHASENAME)) {
                    flGoodsPurchase.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.WORKPUECHASENAME)) {
                    flWorkPurchase.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.CCTPUECHASENAME)) {
                    flCCTPurchase.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.GHPUECHASENAME)) {
                    flGHPurchase.setVisibility(View.GONE);
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
        return R.layout.activity_cai_gou;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.llPurchase, R.id.llGoodsPurchase, R.id.llWorkPurchase
            , R.id.llflCCTPurchase, R.id.llGHPurchase})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llPurchase:
                intent = new Intent(this, FlowPurchaseActivity.class);
                startActivity(intent);
                break;
            case R.id.llGoodsPurchase:
                intent = new Intent(this, FlowGoodsPurchaseActivity.class);
                startActivity(intent);
                break;
            case R.id.llWorkPurchase:
                intent = new Intent(this, FlowWorkPurchaseActivity.class);
                startActivity(intent);
                break;
            case R.id.llflCCTPurchase:
                intent = new Intent(this, FlowCCTTPurchaseActivity.class);
                startActivity(intent);
                break;
            case R.id.llGHPurchase:
                intent = new Intent(this, FlowGHPurchaseActivity.class);
                startActivity(intent);
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            beanList.clear();
            tvGoodsPurchase.setVisibility(View.GONE);
            tvGoodsPurchase.setText("");
            tvPurchase.setVisibility(View.GONE);
            tvPurchase.setText("");
            tvWorkPurchase.setVisibility(View.GONE);
            tvWorkPurchase.setText("");
            String data = String.valueOf(msg.getData().get("data"));
            MyNum bean = new Gson().fromJson(data, MyNum.class);
            if (!bean.isSuccess()) {
                Toast.makeText(CaiGouActivity.this, "获取我的待办数据失败", Toast.LENGTH_SHORT).show();
            } else {
                for (int i = 0; i < bean.getTotalCounts(); i++) {
                    beanList.add(bean.getResult().get(i));
                }
                if (beanList.size() != 0) {
                    for (int i = 0; i < beanList.size(); i++) {
                        if (beanList.get(i).getFormDefId().equals(Constant.GOODSPUECHASE)) {
                            tvGoodsPurchase.setVisibility(View.VISIBLE);
                            tvGoodsPurchase.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.PUECHASEFLOW)) {
                            tvPurchase.setVisibility(View.VISIBLE);
                            tvPurchase.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.WORKPUECHASE)) {
                            tvWorkPurchase.setVisibility(View.VISIBLE);
                            tvWorkPurchase.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.CCTPUECHASE)) {
                            tvCCTPurchase.setVisibility(View.VISIBLE);
                            tvCCTPurchase.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.GHPUECHASE)) {
                            tvGHPurchase.setVisibility(View.VISIBLE);
                            tvGHPurchase.setText(beanList.get(i).getSl());
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
