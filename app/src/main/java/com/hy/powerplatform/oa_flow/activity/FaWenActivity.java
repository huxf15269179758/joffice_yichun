package com.hy.powerplatform.oa_flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
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

public class FaWenActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.llOutMessage)
    LinearLayout llOutMessage;
    @BindView(R.id.tvOutMessage)
    TextView tvOutMessage;
    List<MyNum.ResultBean> beanList = new ArrayList<>();
    List<String> dataList = new ArrayList<>();
    String rolues;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.tvCompMessage)
    TextView tvCompMessage;
    @BindView(R.id.llCompMessage)
    LinearLayout llCompMessage;

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

            if (!dataList.contains(Constant.OUTMESSAGENAME)) {
                llNoContent.setVisibility(View.VISIBLE);
            } else {
                getData();
            }

//            getData();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getData();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_fa_wen;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.llOutMessage,R.id.llCompMessage})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.llOutMessage:
                Intent intent = new Intent(this, FlowOutMessageActivity.class);
                startActivity(intent);
                break;
            case R.id.llCompMessage:
                Intent intent1 = new Intent(this, FlowCompMessageActivity.class);
                startActivity(intent1);
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            beanList.clear();
            tvOutMessage.setVisibility(View.GONE);
            tvOutMessage.setText("");
            String data = String.valueOf(msg.getData().get("data"));
            MyNum bean = new Gson().fromJson(data, MyNum.class);
            if (!bean.isSuccess()) {
                Toast.makeText(FaWenActivity.this, "获取我的待办数据失败", Toast.LENGTH_SHORT).show();
            } else {
                for (int i = 0; i < bean.getTotalCounts(); i++) {
                    beanList.add(bean.getResult().get(i));
                }
                if (beanList.size() != 0) {
                    for (int i = 0; i < beanList.size(); i++) {
                        if (beanList.get(i).getFormDefId().equals(Constant.OUTMESSAGE)) {
                            tvOutMessage.setVisibility(View.VISIBLE);
                            tvOutMessage.setText(beanList.get(i).getSl());
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