package com.hy.powerplatform.oa_flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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

public class XingZengActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.llEMaintain)
    LinearLayout llEMaintain;
    @BindView(R.id.tvEMaintain)
    TextView tvEMaintain;
    @BindView(R.id.llCarVideo)
    LinearLayout llCarVideo;
    @BindView(R.id.tvCarVideo)
    TextView tvCarVideo;
    @BindView(R.id.llDorm)
    LinearLayout llDorm;
    @BindView(R.id.tvDorm)
    TextView tvDorm;
    @BindView(R.id.llNewGC)
    LinearLayout llNewGC;
    @BindView(R.id.tvNewGC)
    TextView tvNewGC;
    @BindView(R.id.llGCCheck)
    LinearLayout llGCCheck;
    @BindView(R.id.tvGCCheck)
    TextView tvGCCheck;
    @BindView(R.id.llCompliain)
    LinearLayout llCompliain;
    @BindView(R.id.tvCompliain)
    TextView tvCompliain;
    @BindView(R.id.llJZGC)
    LinearLayout llJZGC;
    @BindView(R.id.tvJZGC)
    TextView tvJZGC;
    @BindView(R.id.llInstall)
    LinearLayout llInstall;
    @BindView(R.id.tvInstall)
    TextView tvInstall;
    @BindView(R.id.llReceiveDinner)
    LinearLayout llReceiveDinner;
    @BindView(R.id.tvReceiveDinner)
    TextView tvReceiveDinner;
    @BindView(R.id.llContractSign)
    LinearLayout llContractSign;
    @BindView(R.id.tvContractSign)
    TextView tvContractSign;
    @BindView(R.id.llAppeal)
    LinearLayout llAppeal;
    @BindView(R.id.tvAppeal)
    TextView tvAppeal;
    @BindView(R.id.llCarSafe)
    LinearLayout llCarSafe;
    @BindView(R.id.tvCarSafe)
    TextView tvCarSafe;
    @BindView(R.id.llSaferS)
    LinearLayout llSaferS;
    @BindView(R.id.tvSaferS)
    TextView tvSaferS;
    @BindView(R.id.llSaferY)
    LinearLayout llSaferY;
    @BindView(R.id.tvSaferY)
    TextView tvSaferY;
    @BindView(R.id.llCar)
    LinearLayout llCar;
    @BindView(R.id.tvCar)
    TextView tvCar;
    Intent intent;

    List<MyNum.ResultBean> beanList = new ArrayList<>();
    String rolues;
    List<String> dataList = new ArrayList<>();
    @BindView(R.id.inNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.imageView10)
    ImageView imageView10;
    @BindView(R.id.flEMaintain)
    FrameLayout flEMaintain;
    @BindView(R.id.flCarVideo)
    FrameLayout flCarVideo;
    @BindView(R.id.flDorm)
    FrameLayout flDorm;
    @BindView(R.id.flNewGC)
    FrameLayout flNewGC;
    @BindView(R.id.flGCCheck)
    FrameLayout flGCCheck;
    @BindView(R.id.flCompliain)
    FrameLayout flCompliain;
    @BindView(R.id.flJZGC)
    FrameLayout flJZGC;
    @BindView(R.id.flInstall)
    FrameLayout flInstall;
    @BindView(R.id.flReceiveDinner)
    FrameLayout flReceiveDinner;
    @BindView(R.id.flContractSign)
    FrameLayout flContractSign;
    @BindView(R.id.flAppeal)
    FrameLayout flAppeal;
    @BindView(R.id.flCarSafe)
    FrameLayout flCarSafe;
    @BindView(R.id.flSaferS)
    FrameLayout flSaferS;
    @BindView(R.id.flSaferY)
    FrameLayout flSaferY;
    @BindView(R.id.flCar)
    FrameLayout flCar;
    @BindView(R.id.tvHuiQian)
    TextView tvHuiQian;
    @BindView(R.id.llHuiQian)
    LinearLayout llHuiQian;
    @BindView(R.id.flHuiQian)
    FrameLayout flHuiQian;
    @BindView(R.id.tvGHSingle)
    TextView tvGHSingle;
    @BindView(R.id.llGHSingle)
    LinearLayout llGHSingle;
    @BindView(R.id.flGHSingle)
    FrameLayout flGHSingle;
    @BindView(R.id.tvCompMessage)
    TextView tvCompMessage;
    @BindView(R.id.llCompMessage)
    LinearLayout llCompMessage;
    @BindView(R.id.ycFrameLayout)
    FrameLayout ycFrameLayout;
    @BindView(R.id.llRepair)
    LinearLayout llRepair;

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
                    && !dataList.contains(Constant.REPAIRNAME)) {
                llNoContent.setVisibility(View.VISIBLE);
            } else {
                if (!dataList.contains(Constant.EMAINTAINNAME)) {
                    flEMaintain.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.CARVIDEONAME)) {
                    flCarVideo.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.DORMNAME)) {
                    flDorm.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.GCADDNAME)) {
                    flNewGC.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.GCCHECKNAME)) {
                    flGCCheck.setVisibility(View.GONE);
                }

                if (!dataList.contains(Constant.COMPLAINNAME)) {
                    flCompliain.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.JSGCNAME)) {
                    flJZGC.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.INSTALLNNAME)) {
                    flInstall.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.DINNERNAME)) {
                    flReceiveDinner.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.CONTRACTSIGNNAME)) {
                    flContractSign.setVisibility(View.GONE);
                }

                if (!dataList.contains(Constant.APPEALNAME)) {
                    flAppeal.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.CARSAFENAME)) {
                    flCarSafe.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.SAFERNAMES)) {
                    flSaferS.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.SAFERNAMEY)) {
                    flSaferY.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.USERCARNAME)) {
                    flCar.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.HUIQIANNAME)) {
                    flHuiQian.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.GHCONTRACTSIGNNAME)) {
                    flGHSingle.setVisibility(View.GONE);
                }
                if (!dataList.contains(Constant.REPAIRNAME)) {
                    llRepair.setVisibility(View.GONE);
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
        return R.layout.activity_xing_zeng;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.llEMaintain, R.id.llCarVideo, R.id.llDorm, R.id.llNewGC, R.id.llGCCheck
            , R.id.llCompliain, R.id.llJZGC, R.id.llInstall, R.id.llReceiveDinner
            , R.id.llContractSign, R.id.llAppeal, R.id.llCarSafe, R.id.llSaferS, R.id.llSaferY
            , R.id.llCar, R.id.llHuiQian, R.id.llGHSingle, R.id.llCompMessage,R.id.llRepair})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llRepair:
                intent = new Intent(this, FlowRepairActivity.class);
                startActivity(intent);
                break;
            case R.id.llEMaintain:
                intent = new Intent(this, FlowEMainTainActivity.class);
                startActivity(intent);
                break;
            case R.id.llCompMessage:
                Intent intent1 = new Intent(this, FlowCompMessageActivity.class);
                startActivity(intent1);
                break;
            case R.id.llCarVideo:
                intent = new Intent(this, FlowCarVideoActivity.class);
                startActivity(intent);
                break;
            case R.id.llDorm:
                intent = new Intent(this, FlowDormActivity.class);
                startActivity(intent);
                break;
            case R.id.llNewGC:
                intent = new Intent(this, FlowNewGCActivity.class);
                intent.putExtra("tag", "1");
                startActivity(intent);
                break;
            case R.id.llGCCheck:
                intent = new Intent(this, FlowNewGCActivity.class);
                intent.putExtra("tag", "2");
                startActivity(intent);
                break;
            case R.id.llCompliain:
                intent = new Intent(this, FlowComplainActivity.class);
                startActivity(intent);
                break;
            case R.id.llJZGC:
                intent = new Intent(this, FlowJSGCActivity.class);
                startActivity(intent);
                break;
            case R.id.llInstall:
                intent = new Intent(this, FlowInstallActivity.class);
                startActivity(intent);
                break;
            case R.id.llReceiveDinner:
                intent = new Intent(this, FlowReceiveDinnerActivity.class);
                startActivity(intent);
                break;
            case R.id.llContractSign:
                intent = new Intent(this, FlowContractSignActivity.class);
                startActivity(intent);
                break;
            case R.id.llAppeal:
                intent = new Intent(this, FlowAppealActivity.class);
                startActivity(intent);
                break;
            case R.id.llCarSafe:
                intent = new Intent(this, FlowCarSafeActivity.class);
                startActivity(intent);
                break;
            case R.id.llSaferS:
                intent = new Intent(this, FlowSaferActivity.class);
                intent.putExtra("tag", "1");
                startActivity(intent);
                break;
            case R.id.llSaferY:
                intent = new Intent(this, FlowSaferActivity.class);
                intent.putExtra("tag", "2");
                startActivity(intent);
                break;
            case R.id.llCar:
                intent = new Intent(this, FlowCarActivity.class);
                startActivity(intent);
                break;
            case R.id.llHuiQian:
                intent = new Intent(this, FlowHuiQianActivity.class);
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
            tvContractSign.setVisibility(View.GONE);
            tvContractSign.setText("");
            tvNewGC.setVisibility(View.GONE);
            tvNewGC.setText("");
            tvGCCheck.setVisibility(View.GONE);
            tvGCCheck.setText("");
            tvCarSafe.setVisibility(View.GONE);
            tvCarSafe.setText("");
            tvCarVideo.setVisibility(View.GONE);
            tvCarVideo.setText("");
            tvCar.setVisibility(View.GONE);
            tvCar.setText("");
            tvReceiveDinner.setVisibility(View.GONE);
            tvReceiveDinner.setText("");
            tvCompliain.setVisibility(View.GONE);
            tvCompliain.setText("");
            tvInstall.setVisibility(View.GONE);
            tvInstall.setText("");
            tvJZGC.setVisibility(View.GONE);
            tvJZGC.setText("");
            tvEMaintain.setVisibility(View.GONE);
            tvEMaintain.setText("");
            tvDorm.setVisibility(View.GONE);
            tvDorm.setText("");
            tvAppeal.setVisibility(View.GONE);
            tvAppeal.setText("");
            tvSaferS.setVisibility(View.GONE);
            tvSaferS.setText("");
            tvSaferY.setVisibility(View.GONE);
            tvSaferY.setText("");
            tvHuiQian.setVisibility(View.GONE);
            tvHuiQian.setText("");
            tvGHSingle.setVisibility(View.GONE);
            tvGHSingle.setText("");
            String data = String.valueOf(msg.getData().get("data"));
            Log.e("XXX", data);
            MyNum bean = new Gson().fromJson(data, MyNum.class);
            if (!bean.isSuccess()) {
                Toast.makeText(XingZengActivity.this, "获取我的待办数据失败", Toast.LENGTH_SHORT).show();
            } else {
                for (int i = 0; i < bean.getTotalCounts(); i++) {
                    beanList.add(bean.getResult().get(i));
                }
                if (beanList.size() != 0) {
                    for (int i = 0; i < beanList.size(); i++) {
                        if (beanList.get(i).getFormDefId().equals(Constant.CONTRACTSIGN)) {
                            tvContractSign.setVisibility(View.VISIBLE);
                            tvContractSign.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.GCADD)) {
                            tvNewGC.setVisibility(View.VISIBLE);
                            tvNewGC.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.GCCHECK)) {
                            tvGCCheck.setVisibility(View.VISIBLE);
                            tvGCCheck.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.CARSAFE)) {
                            tvCarSafe.setVisibility(View.VISIBLE);
                            tvCarSafe.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.CARVIDEO)) {
                            tvCarVideo.setVisibility(View.VISIBLE);
                            tvCarVideo.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.USERCAR)) {
                            tvCar.setVisibility(View.VISIBLE);
                            tvCar.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.DINNER)) {
                            tvReceiveDinner.setVisibility(View.VISIBLE);
                            tvReceiveDinner.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.COMPLAIN)) {
                            tvCompliain.setVisibility(View.VISIBLE);
                            tvCompliain.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.INSTALL)) {
                            tvInstall.setVisibility(View.VISIBLE);
                            tvInstall.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.GCQD)) {
                            tvJZGC.setVisibility(View.VISIBLE);
                            tvJZGC.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.EMAINTAIN)) {
                            tvEMaintain.setVisibility(View.VISIBLE);
                            tvEMaintain.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.DORM)) {
                            tvDorm.setVisibility(View.VISIBLE);
                            tvDorm.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.APPEAL)) {
                            tvAppeal.setVisibility(View.VISIBLE);
                            tvAppeal.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.SAFER1)) {
                            tvSaferS.setVisibility(View.VISIBLE);
                            tvSaferS.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.SAFER2)) {
                            tvSaferY.setVisibility(View.VISIBLE);
                            tvSaferY.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.HUIQIAN)) {
                            tvHuiQian.setVisibility(View.VISIBLE);
                            tvHuiQian.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.GHSINGLE)) {
                            tvGHSingle.setVisibility(View.VISIBLE);
                            tvGHSingle.setText(beanList.get(i).getSl());
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