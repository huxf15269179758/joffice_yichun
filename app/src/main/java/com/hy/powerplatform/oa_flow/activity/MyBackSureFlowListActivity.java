package com.hy.powerplatform.oa_flow.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBack;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.adapter.FlowContractPayListAdapter1;
import com.hy.powerplatform.oa_flow.bean.Back;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class MyBackSureFlowListActivity extends BaseActivity implements FlowContractPayListAdapter1.OnGetAdapterPositionListener {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    FlowContractPayListAdapter1 adapter;
    List<Back.ResultBean> beanList = new ArrayList<>();
//    int limit = 20;
//    int start = 0;
    String res = "";
    String tag = "";
    @BindView(R.id.liContent1)
    LinearLayout llNoContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new FlowContractPayListAdapter1(this, beanList);
        adapter.sendOnGetAdapterPositionListener(this);
        recyclerView.setAdapter(adapter);
        ProgressDialogUtil.startLoad(this, "获取数据中");
//        getData(start, limit);
        getData();
//        setClient();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        beanList.clear();
//        adapter.notifyDataSetChanged();
//        ProgressDialogUtil.startLoad(this, "获取数据中");
//        getData(0, 20);
//        setClient();
    }

    /**
     * 获取数据
     *
     */
    //final int start, final int limit
    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                String url = Constant.BASE_URL2 +  Constant.BACKFLOWLIST+start+"&limit="+limit;
                String url = Constant.BASE_URL2 +  Constant.BACKFLOWSURELIST;
                DBHandler dbA = new DBHandler();
                res = dbA.BackFlowList(url);
                if (res.equals("获取数据失败") || res.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_ONE);
                }
            }
        }).start();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_my_back_do;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void getAdapterPosition(final int position) {
//        Intent intent = null;
//        if (beanList.get(position).getFormDefId().equals(Constant.EMAINTAIN)) {
//            intent = new Intent(this, FlowEMaintainDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.CARVIDEO)) {
//            intent = new Intent(this, FlowCarVideoDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.DORM)) {
//            intent = new Intent(this, FlowDormDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.GCADD)) {
//            intent = new Intent(this, FlowGCAddDetailActivity.class);
//            intent.putExtra("tag", "1");
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.GCCHECKNAME)) {
//            intent = new Intent(this, FlowGCAddDetailActivity.class);
//            intent.putExtra("tag", "2");
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.COMPLAIN)) {
//            intent = new Intent(this, FlowComplainDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.GCQD)) {
//            intent = new Intent(this, FlowJSGCDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.INSTALL)) {
//            intent = new Intent(this, FlowInstallDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.DINNER)) {
//            intent = new Intent(this, FlowDinnerDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.CONTRACTSIGN)) {
//            intent = new Intent(this, FlowContractSignDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.APPEAL)) {
//            intent = new Intent(this, FlowAppealDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.CARSAFE)) {
//            intent = new Intent(this, FlowCarSafeDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.SAFERNAMES)) {
//            intent = new Intent(this, FlowSaferllDetailActivity.class);
//            intent.putExtra("tag", "1");
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.SAFERNAMEY)) {
//            intent = new Intent(this, FlowSaferllDetailActivity.class);
//            intent.putExtra("tag", "2");
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.USERCAR)) {
//            intent = new Intent(this, FlowUseCarDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//
//
//        if (beanList.get(position).getFormDefId().equals(Constant.ENTRY)) {
//            intent = new Intent(this, FlowEntryDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.LEAVER)) {
//            intent = new Intent(this, FlowLeaveDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.CHUCAI)) {
//            intent = new Intent(this, FlowChuCaiDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.DRIVERASSESS)) {
//            intent = new Intent(this, FlowDriverAssessDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.OVERTIME)) {
//            intent = new Intent(this, FlowOverTimeDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//
//
//        if (beanList.get(position).getFormDefId().equals(Constant.BILL)) {
//            intent = new Intent(this, FlowBillDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.CONTRACEPAY)) {
//            intent = new Intent(this, FlowContractPayDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.PAYFLOW)) {
//            intent = new Intent(this, FlowFuKuanLiuChengDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//
//
//        if (beanList.get(position).getFormDefId().equals(Constant.WORKPUECHASE)) {
//            intent = new Intent(this, FlowWorkPruchaseDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.GOODSPUECHASE)) {
//            intent = new Intent(this, FlowGoodsPruchaseDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.PUECHASEFLOW)) {
//            intent = new Intent(this, FlowPruchaseDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.REPAIR)) {
//            intent = new Intent(this, FlowRepairDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//
//
//        if (beanList.get(position).getFormDefId().equals(Constant.OUTMESSAGE)) {
//            intent = new Intent(this, FlowOutMessageDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//
//        if (beanList.get(position).getFormDefId().equals(Constant.HUIQIAN)) {
//            intent = new Intent(this, FlowHuiQianDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.COMPMESSAGE)) {
//            intent = new Intent(this, FlowCompMessageDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.CCTPUECHASE)) {
//            intent = new Intent(this, FlowCCTPruchaseDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.GHPUECHASE)) {
//            intent = new Intent(this, FlowGHPruchaseDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.GHPAYFLOW)) {
//            intent = new Intent(this, FlowGHPayDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
//        if (beanList.get(position).getFormDefId().equals(Constant.GHCONTRACTSINGLE)) {
//            intent = new Intent(this, FlowGHContractSignDetailActivity.class);
//            intent.putExtra("bean", beanList.get(position).getRunId());
//            startActivity(intent);
//        }
        new AlertDialogUtil(MyBackSureFlowListActivity.this).showDialog(beanList.get(position).getRevokeReason(), new AlertDialogCallBack() {
            @Override
            public void select(String data) {
            }
            @Override
            public void confirm() {
                final String runId = beanList.get(position).getId();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url = Constant.BASE_URL2 +  Constant.BACKFLOWSURE+"?id="+runId;
                        DBHandler dbA = new DBHandler();
                        res = dbA.BackFlowList(url);
                        if (res.equals("获取数据失败") || res.equals("")) {
                            handler.sendEmptyMessage(TAG_TWO);
                        } else {
                            Message message = new Message();
                            message.what = TAG_FOUR;
                            Bundle bundle = new Bundle();
                            try {
                                JSONObject jsonObject = new JSONObject(res);
                                bundle.putString("tag",jsonObject.getString("msg"));
                                message.setData(bundle);
                                handler.sendMessage(message);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }

            @Override
            public void cancel() {

            }
        });
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    beanList.clear();
                    Gson gson = new Gson();
                    Back bean = gson.fromJson(res,Back.class);
                    for (int i = 0;i<bean.getResult().size();i++){
                        beanList.add(bean.getResult().get(i));
                    }

                    if (bean.getResult().size() == 0&&beanList.size()==0){
                        if (recyclerView != null) {
                            recyclerView.setVisibility(View.GONE);
                            llNoContent.setVisibility(View.VISIBLE);
                        }
                        ProgressDialogUtil.stopLoad();
                        break;
                    }else {
                        if (recyclerView != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(MyBackSureFlowListActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_THERE:
                    Toast.makeText(MyBackSureFlowListActivity.this, "解析失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_FOUR:
                    String msg1 = msg.getData().getString("tag");
                    Toast.makeText(MyBackSureFlowListActivity.this, msg1, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    beanList.clear();
                    ProgressDialogUtil.startLoad(MyBackSureFlowListActivity.this, "获取数据中");
                    getData();
                    break;
            }
        }
    };
}
