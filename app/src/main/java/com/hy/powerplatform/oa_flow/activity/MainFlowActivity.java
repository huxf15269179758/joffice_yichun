package com.hy.powerplatform.oa_flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.bean.MyNum;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFlowActivity extends BaseActivity {
    @BindView(R.id.llCar)
    LinearLayout llCar;
    @BindView(R.id.llEntry)
    LinearLayout llEntry;
    @BindView(R.id.llOutMessage)
    LinearLayout llOutMessage;
    Intent intent;
    @BindView(R.id.llContractPay)
    LinearLayout llContractPay;
    @BindView(R.id.llPurchase)
    LinearLayout llPurchase;
    @BindView(R.id.llBill)
    LinearLayout llBill;
    @BindView(R.id.llCarVideo)
    LinearLayout llCarVideo;
    @BindView(R.id.llOverTime)
    LinearLayout llOverTime;
    @BindView(R.id.llCarSafe)
    LinearLayout llCarSafe;
    @BindView(R.id.llDriverAssess)
    LinearLayout llDriverAssess;
    @BindView(R.id.llChuCai)
    LinearLayout llChuCai;
    @BindView(R.id.llFuKuanLiuCheng)
    LinearLayout llFuKuanLiuCheng;
    @BindView(R.id.llReceiveDinner)
    LinearLayout llReceiveDinner;
    @BindView(R.id.llJZGC)
    LinearLayout llJZGC;
    @BindView(R.id.llNewGC)
    LinearLayout llNewGC;
    @BindView(R.id.llContractSign)
    LinearLayout llContractSign;
    @BindView(R.id.llGoodsPurchase)
    LinearLayout llGoodsPurchase;
    @BindView(R.id.llWorkPurchase)
    LinearLayout llWorkPurchase;
    @BindView(R.id.llRepair)
    LinearLayout llRepair;

    String tag = "1";
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.llGCCheck)
    LinearLayout llGCCheck;
    @BindView(R.id.llCompliain)
    LinearLayout llCompliain;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.llInstall)
    LinearLayout llInstall;
    @BindView(R.id.llEMaintain)
    LinearLayout llEMaintain;
    @BindView(R.id.llDorm)
    LinearLayout llDorm;
    @BindView(R.id.llAppeal)
    LinearLayout llAppeal;
    @BindView(R.id.llSaferS)
    LinearLayout llSaferS;
    @BindView(R.id.llSaferY)
    LinearLayout llSaferY;
    List<MyNum.ResultBean> beanList = new ArrayList<>();
    @BindView(R.id.llLeave)
    LinearLayout llLeave;
    @BindView(R.id.tvLeave)
    TextView tvLeave;
    @BindView(R.id.tvFuKuanLiuCheng)
    TextView tvFuKuanLiuCheng;
    @BindView(R.id.tvContractPay)
    TextView tvContractPay;
    @BindView(R.id.tvContractSign)
    TextView tvContractSign;
    @BindView(R.id.tvGoodsPurchase)
    TextView tvGoodsPurchase;
    @BindView(R.id.tvWorkPurchase)
    TextView tvWorkPurchase;
    @BindView(R.id.tvPurchase)
    TextView tvPurchase;
    @BindView(R.id.tvEntry)
    TextView tvEntry;
    @BindView(R.id.tvOutMessage)
    TextView tvOutMessage;
    @BindView(R.id.tvRepair)
    TextView tvRepair;
    @BindView(R.id.tvChuCai)
    TextView tvChuCai;
    @BindView(R.id.tvNewGC)
    TextView tvNewGC;
    @BindView(R.id.tvGCCheck)
    TextView tvGCCheck;
    @BindView(R.id.tvOverTime)
    TextView tvOverTime;
    @BindView(R.id.tvCarSafe)
    TextView tvCarSafe;
    @BindView(R.id.tvDriverAssess)
    TextView tvDriverAssess;
    @BindView(R.id.tvCarVideo)
    TextView tvCarVideo;
    @BindView(R.id.tvCar)
    TextView tvCar;
    @BindView(R.id.tvReceiveDinner)
    TextView tvReceiveDinner;
    @BindView(R.id.tvCompliain)
    TextView tvCompliain;
    @BindView(R.id.tvInstall)
    TextView tvInstall;
    @BindView(R.id.tvJZGC)
    TextView tvJZGC;
    @BindView(R.id.tvEMaintain)
    TextView tvEMaintain;
    @BindView(R.id.tvDorm)
    TextView tvDorm;
    @BindView(R.id.tvBill)
    TextView tvBill;
    @BindView(R.id.tvAppeal)
    TextView tvAppeal;
    @BindView(R.id.tvSaferS)
    TextView tvSaferS;
    @BindView(R.id.tvSaferY)
    TextView tvSaferY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
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

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main_flow;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
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

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.llLeave, R.id.llCar, R.id.llEntry, R.id.llOutMessage, R.id.llContractPay
            , R.id.llPurchase, R.id.llBill, R.id.llCarVideo, R.id.llOverTime
            , R.id.llCarSafe, R.id.llDriverAssess, R.id.llChuCai, R.id.llFuKuanLiuCheng
            , R.id.llReceiveDinner, R.id.llJZGC, R.id.llNewGC, R.id.llContractSign
            , R.id.llGoodsPurchase, R.id.llWorkPurchase, R.id.llRepair, R.id.llGCCheck
            , R.id.llCompliain, R.id.llInstall, R.id.llEMaintain, R.id.llDorm, R.id.llAppeal
            , R.id.llSaferS, R.id.llSaferY})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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
            case R.id.llAppeal:
                intent = new Intent(this, FlowAppealActivity.class);
                startActivity(intent);
                break;
            case R.id.llDorm:
                intent = new Intent(this, FlowDormActivity.class);
                startActivity(intent);
                break;
            case R.id.llEMaintain:
                intent = new Intent(this, FlowEMainTainActivity.class);
                startActivity(intent);
                break;
            case R.id.llInstall:
                intent = new Intent(this, FlowInstallActivity.class);
                startActivity(intent);
                break;
            case R.id.llCompliain:
                intent = new Intent(this, FlowComplainActivity.class);
                startActivity(intent);
                break;
            case R.id.llLeave:
                intent = new Intent(this, FlowLeaveActivity.class);
                startActivity(intent);
                break;
            case R.id.llCar:
                intent = new Intent(this, FlowCarActivity.class);
                startActivity(intent);
                break;
            case R.id.llEntry:
                intent = new Intent(this, FlowEntryActivity.class);
                startActivity(intent);
                break;
            case R.id.llOutMessage:
                intent = new Intent(this, FlowOutMessageActivity.class);
                startActivity(intent);
                break;
            case R.id.llContractPay:
                intent = new Intent(this, FlowContractPayActivity.class);
                startActivity(intent);
                break;
            case R.id.llPurchase:
                intent = new Intent(this, FlowPurchaseActivity.class);
                startActivity(intent);
                break;
            case R.id.llBill:
                intent = new Intent(this, FlowBillActivity.class);
                startActivity(intent);
                break;
            case R.id.llCarVideo:
                intent = new Intent(this, FlowCarVideoActivity.class);
                startActivity(intent);
                break;
            case R.id.llOverTime:
                intent = new Intent(this, FlowOverTimeActivity.class);
                startActivity(intent);
                break;
            case R.id.llCarSafe:
                intent = new Intent(this, FlowCarSafeActivity.class);
                startActivity(intent);
                break;
            case R.id.llDriverAssess:
                intent = new Intent(this, FlowDriverAssessActivity.class);
                startActivity(intent);
                break;
            case R.id.llChuCai:
                intent = new Intent(this, FlowChuCaiActivity.class);
                startActivity(intent);
                break;
            case R.id.llFuKuanLiuCheng:
                intent = new Intent(this, FlowFuKuanLiuChengActivity.class);
                startActivity(intent);
                break;
            case R.id.llReceiveDinner:
                intent = new Intent(this, FlowReceiveDinnerActivity.class);
                startActivity(intent);
                break;
            case R.id.llJZGC:
                intent = new Intent(this, FlowJSGCActivity.class);
                startActivity(intent);
                break;
            case R.id.llNewGC:
                intent = new Intent(this, FlowNewGCActivity.class);
                tag = "1";
                intent.putExtra("tag", tag);
                startActivity(intent);
                break;
            case R.id.llGCCheck:
                intent = new Intent(this, FlowNewGCActivity.class);
                tag = "2";
                intent.putExtra("tag", tag);
                startActivity(intent);
                break;
            case R.id.llContractSign:
                intent = new Intent(this, FlowContractSignActivity.class);
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
            case R.id.llRepair:
                intent = new Intent(this, FlowRepairActivity.class);
                startActivity(intent);
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tvLeave.setVisibility(View.GONE);
            tvLeave.setText("");
            tvFuKuanLiuCheng.setVisibility(View.GONE);
            tvFuKuanLiuCheng.setText("");
            tvContractPay.setVisibility(View.GONE);
            tvContractPay.setText("");
            tvContractSign.setVisibility(View.GONE);
            tvContractSign.setText("");
            tvGoodsPurchase.setVisibility(View.GONE);
            tvGoodsPurchase.setText("");
            tvPurchase.setVisibility(View.GONE);
            tvPurchase.setText("");
            tvEntry.setVisibility(View.GONE);
            tvEntry.setText("");
            tvOutMessage.setVisibility(View.GONE);
            tvOutMessage.setText("");
            tvWorkPurchase.setVisibility(View.GONE);
            tvWorkPurchase.setText("");
            tvRepair.setVisibility(View.GONE);
            tvRepair.setText("");
            tvChuCai.setVisibility(View.GONE);
            tvChuCai.setText("");
            tvNewGC.setVisibility(View.GONE);
            tvNewGC.setText("");
            tvGCCheck.setVisibility(View.GONE);
            tvGCCheck.setText("");
            tvOverTime.setVisibility(View.GONE);
            tvOverTime.setText("");
            tvCarSafe.setVisibility(View.GONE);
            tvCarSafe.setText("");
            tvCarVideo.setVisibility(View.GONE);
            tvCarVideo.setText("");
            tvDriverAssess.setVisibility(View.GONE);
            tvDriverAssess.setText("");
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
            tvBill.setVisibility(View.GONE);
            tvBill.setText("");
            tvSaferS.setVisibility(View.GONE);
            tvSaferS.setText("");
            tvSaferY.setVisibility(View.GONE);
            tvSaferY.setText("");
            String data = String.valueOf(msg.getData().get("data"));
            MyNum bean = new Gson().fromJson(data, MyNum.class);
            if (!bean.isSuccess()) {
                Toast.makeText(MainFlowActivity.this, "获取我的待办数据失败", Toast.LENGTH_SHORT).show();
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
                        if (beanList.get(i).getFormDefId().equals(Constant.PAYFLOW)) {
                            tvFuKuanLiuCheng.setVisibility(View.VISIBLE);
                            tvFuKuanLiuCheng.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.CONTRACEPAY)) {
                            tvContractPay.setVisibility(View.VISIBLE);
                            tvContractPay.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.CONTRACTSIGN)) {
                            tvContractSign.setVisibility(View.VISIBLE);
                            tvContractSign.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.GOODSPUECHASE)) {
                            tvGoodsPurchase.setVisibility(View.VISIBLE);
                            tvGoodsPurchase.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.PUECHASEFLOW)) {
                            tvPurchase.setVisibility(View.VISIBLE);
                            tvPurchase.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.ENTRY)) {
                            tvEntry.setVisibility(View.VISIBLE);
                            tvEntry.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.OUTMESSAGE)) {
                            tvOutMessage.setVisibility(View.VISIBLE);
                            tvOutMessage.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.WORKPUECHASE)) {
                            tvWorkPurchase.setVisibility(View.VISIBLE);
                            tvWorkPurchase.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.REPAIR)) {
                            tvRepair.setVisibility(View.VISIBLE);
                            tvRepair.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.CHUCAI)) {
                            tvChuCai.setVisibility(View.VISIBLE);
                            tvChuCai.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.GCADD)) {
                            tvNewGC.setVisibility(View.VISIBLE);
                            tvNewGC.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.GCCHECK)) {
                            tvGCCheck.setVisibility(View.VISIBLE);
                            tvGCCheck.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.OVERTIME)) {
                            tvOverTime.setVisibility(View.VISIBLE);
                            tvOverTime.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.CARSAFE)) {
                            tvCarSafe.setVisibility(View.VISIBLE);
                            tvCarSafe.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.CARVIDEO)) {
                            tvCarVideo.setVisibility(View.VISIBLE);
                            tvCarVideo.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.DRIVERASSESS)) {
                            tvDriverAssess.setVisibility(View.VISIBLE);
                            tvDriverAssess.setText(beanList.get(i).getSl());
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
                        if (beanList.get(i).getFormDefId().equals(Constant.BILL)) {
                            tvBill.setVisibility(View.VISIBLE);
                            tvBill.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.SAFER1)) {
                            tvSaferS.setVisibility(View.VISIBLE);
                            tvSaferS.setText(beanList.get(i).getSl());
                        }
                        if (beanList.get(i).getFormDefId().equals(Constant.SAFER2)) {
                            tvSaferY.setVisibility(View.VISIBLE);
                            tvSaferY.setText(beanList.get(i).getSl());
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
