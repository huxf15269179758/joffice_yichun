package com.hy.powerplatform.oa_flow.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.adapter.FlowMessageAdapter;
import com.hy.powerplatform.oa_flow.bean.Filed;
import com.hy.powerplatform.oa_flow.bean.FlowMessage1;
import com.hy.powerplatform.oa_flow.bean.MyWorkPurchase;
import com.hy.powerplatform.oa_flow.util.AlertDialogEditText;
import com.hy.powerplatform.oa_flow.util.MyStringSpilt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_NINE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SIX;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class FlowWorkPruchaseDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.etClass)
    TextView etClass;
    @BindView(R.id.etShenQingRen)
    TextView etShenQingRen;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.etName1)
    TextView etName1;
    @BindView(R.id.etName2)
    TextView etName2;
    @BindView(R.id.etName3)
    TextView etName3;
    @BindView(R.id.etName4)
    TextView etName4;
    @BindView(R.id.etNum1)
    TextView etNum1;
    @BindView(R.id.etNum2)
    TextView etNum2;
    @BindView(R.id.etNum3)
    TextView etNum3;
    @BindView(R.id.etNum4)
    TextView etNum4;
    @BindView(R.id.etMoney1)
    TextView etMoney1;
    @BindView(R.id.etMoney2)
    TextView etMoney2;
    @BindView(R.id.etMoney3)
    TextView etMoney3;
    @BindView(R.id.etMoney4)
    TextView etMoney4;
    @BindView(R.id.etAllMoney1)
    TextView etAllMoney1;
    @BindView(R.id.etAllMoney2)
    TextView etAllMoney2;
    @BindView(R.id.etAllMoney3)
    TextView etAllMoney3;
    @BindView(R.id.etAllMoney4)
    TextView etAllMoney4;
    @BindView(R.id.etApplication)
    TextView etApplication;
    @BindView(R.id.etLeader1)
    TextView etLeader1;
    @BindView(R.id.etLeader2)
    TextView etLeader2;
    @BindView(R.id.etLeader3)
    TextView etLeader3;
    @BindView(R.id.etLeader4)
    TextView etLeader4;
    @BindView(R.id.etLeader5)
    TextView etLeader5;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.etName5)
    TextView etName5;
    @BindView(R.id.etNum5)
    TextView etNum5;
    @BindView(R.id.etMoney5)
    TextView etMoney5;
    @BindView(R.id.etAllMoney5)
    TextView etAllMoney5;
    @BindView(R.id.etLeader6)
    TextView etLeader6;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.tvDepartment1)
    TextView tvDepartment1;
    @BindView(R.id.tvDepartment2)
    TextView tvDepartment2;
    @BindView(R.id.tvDepartment3)
    TextView tvDepartment3;
    @BindView(R.id.tvDepartment4)
    TextView tvDepartment4;
    @BindView(R.id.tvDepartment5)
    TextView tvDepartment5;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.tvAllNum)
    TextView tvAllNum;
    @BindView(R.id.tvAllMoney)
    TextView tvAllMoney;
    @BindView(R.id.tvOther)
    TextView tvOther;
    @BindView(R.id.btnHistory)
    Button btnHistory;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.llData)
    LinearLayout llData;
    @BindView(R.id.tvLeaderW)
    TextView tvLeaderW;
    @BindView(R.id.tvLeader1W)
    TextView tvLeader1W;
    @BindView(R.id.tvLeader2W)
    TextView tvLeader2W;
    @BindView(R.id.tvLeader3W)
    TextView tvLeader3W;
    @BindView(R.id.tvLeader4W)
    TextView tvLeader4W;
    @BindView(R.id.tvLeader5W)
    TextView tvLeader5W;
    private String res;
    String xiangguanfujian = "";
    String runID = "";
    String flowMessage = "";
    String downloadData = "";
    FlowMessageAdapter adapter;
    List<FlowMessage1.DataBean> flowList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        tvLeaderW.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader1W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader2W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader3W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader4W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader5W.setTextColor(getResources().getColor(R.color.order_stop_black));
        header.setTvRight("追回");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        btnUp.setVisibility(View.GONE);
        ll1.setVisibility(View.GONE);
        ll2.setVisibility(View.GONE);
        ll3.setVisibility(View.GONE);
        view1.setVisibility(View.GONE);
        view2.setVisibility(View.GONE);
        view3.setVisibility(View.GONE);
        Intent intent = getIntent();
        final String runId = intent.getStringExtra("bean");
        ProgressDialogUtil.startLoad(this, "获取数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.MYLISTDETAIL + runId;
                DBHandler dbA = new DBHandler();
                res = dbA.OAQingJiaMyDetail(url);
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
        return R.layout.activity_workpurchase_data;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        new AlertDialogEditText().showDialog(this, runID, new BaseRequestBackLisenter() {
            @Override
            public void success(Object o) {
                Message message = new Message();
                message.what = TAG_FIVE;
                Bundle bundle = new Bundle();
                bundle.putString("msg", o.toString());
                message.setData(bundle);
                handler.sendMessage(message);
                finish();
            }

            @Override
            public void fail(String message) {
                Message message1 = new Message();
                message1.what = TAG_SIX;
                handler.sendMessage(message1);
            }
        });
    }

    @OnClick({R.id.tvData, R.id.btnHistory})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHistory:
                recyclerView.setVisibility(View.VISIBLE);
                ProgressDialogUtil.startLoad(FlowWorkPruchaseDetailActivity.this, "获取数据中");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //String name =URLDecoder.decode(待转值,"utf-8");
                        String url = Constant.BASE_URL2 + Constant.FLOWMESSAGE;
                        DBHandler dbA = new DBHandler();
                        flowMessage = dbA.OAFlowMessage(url, runID);
                        if (flowMessage.equals("获取数据失败") || flowMessage.equals("")) {
                            handler.sendEmptyMessage(TAG_TWO);
                        } else {
                            handler.sendEmptyMessage(111);
                        }
                    }
                }).start();
                btnHistory.setEnabled(false);
                break;
            case R.id.tvData:
                List<String> dataList = new ArrayList<>();
                if (!xiangguanfujian.equals("")) {
                    dataList = new MyStringSpilt().stringSpiltList(xiangguanfujian);
                    if (dataList.size() == 1) {
                        String id = new MyStringSpilt().stringSpilt(dataList.get(0));
                        final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                DBHandler dbA = new DBHandler();
                                downloadData = dbA.OAQingJiaMyDetail(url);
                                if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                                    handler.sendEmptyMessage(TAG_TWO);
                                } else {
                                    handler.sendEmptyMessage(TAG_NINE);
                                }
                            }
                        }).start();
                    } else if (dataList.size() > 1) {
                        MyAlertDialog.MyListAlertDialog(this, dataList, new AlertDialogCallBackP() {
                            @Override
                            public void oneselect(final String data1) {
                                String id = new MyStringSpilt().stringSpilt(data1);
                                final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        DBHandler dbA = new DBHandler();
                                        downloadData = dbA.OAQingJiaMyDetail(url);
                                        if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                                            handler.sendEmptyMessage(TAG_TWO);
                                        } else {
                                            handler.sendEmptyMessage(TAG_NINE);
                                        }
                                    }
                                }).start();
                            }

                            @Override
                            public void select(List<String> list) {

                            }

                            @Override
                            public void confirm() {

                            }

                            @Override
                            public void cancel() {

                            }
                        });
                    }
                }
                break;
        }
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 111:
                    Gson gsonF = new Gson();
                    FlowMessage1 beanF = gsonF.fromJson(flowMessage, FlowMessage1.class);
                    for (int i = 0; i < beanF.getData().size(); i++) {
                        flowList.add(beanF.getData().get(i));
                    }
                    adapter = new FlowMessageAdapter(FlowWorkPruchaseDetailActivity.this, flowList);
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(FlowWorkPruchaseDetailActivity.this, "查询成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_ONE:
                    Gson gson = new Gson();
                    MyWorkPurchase bean = gson.fromJson(res, MyWorkPurchase.class);
                    String department = bean.getMainform().get(0).getBm();
                    String person = bean.getMainform().get(0).getSqr();
                    String time = bean.getMainform().get(0).getSqrq();
                    String type = bean.getMainform().get(0).getCaigouleixing();

                    xiangguanfujian = bean.getMainform().get(0).getXiangguanfujian();
                    if (xiangguanfujian.equals("")) {
                        llData.setVisibility(View.GONE);
                    } else {
                        tvData.setText(xiangguanfujian);
                    }
                    tvData.setText(xiangguanfujian);

                    tvAllMoney.setText(bean.getMainform().get(0).getHejije());
                    tvAllNum.setText(bean.getMainform().get(0).getHejisl());
                    tvOther.setText(bean.getMainform().get(0).getQiTa());
                    etName1.setText(bean.getMainform().get(0).getChanpinmingcheng1());
                    etName2.setText(bean.getMainform().get(0).getChanpinmingcheng2());
                    etName3.setText(bean.getMainform().get(0).getChanpinmingcheng3());
                    etName4.setText(bean.getMainform().get(0).getChanpinmingcheng4());
                    etName5.setText(bean.getMainform().get(0).getChanpinmingcheng5());

                    etNum1.setText(bean.getMainform().get(0).getShuliang1());
                    etNum2.setText(bean.getMainform().get(0).getShuliang2());
                    etNum3.setText(bean.getMainform().get(0).getShuliang3());
                    etNum4.setText(bean.getMainform().get(0).getShuliang4());
                    etNum5.setText(bean.getMainform().get(0).getShuliang5());

                    etMoney1.setText(bean.getMainform().get(0).getDanjia1());
                    etMoney2.setText(bean.getMainform().get(0).getDanjia2());
                    etMoney3.setText(bean.getMainform().get(0).getDanjia3());
                    etMoney4.setText(bean.getMainform().get(0).getDanjia4());
                    etMoney5.setText(bean.getMainform().get(0).getDanjia5());


                    etAllMoney1.setText(bean.getMainform().get(0).getJine1());
                    etAllMoney2.setText(bean.getMainform().get(0).getJine2());
                    etAllMoney3.setText(bean.getMainform().get(0).getJine3());
                    etAllMoney4.setText(bean.getMainform().get(0).getJine4());
                    etAllMoney5.setText(bean.getMainform().get(0).getJine5());

                    tvDepartment1.setText(bean.getMainform().get(0).getDanwei1());
                    tvDepartment2.setText(bean.getMainform().get(0).getDanwei2());
                    tvDepartment3.setText(bean.getMainform().get(0).getDanwei3());
                    tvDepartment4.setText(bean.getMainform().get(0).getDanwei4());
                    tvDepartment5.setText(bean.getMainform().get(0).getDanwei5());
                    runID = bean.getMainform().get(0).getRunId();
                    if (type.equals("计划内")) {
                        rb1.setEnabled(true);
                        rb1.setChecked(true);
                    }
                    if (type.equals("计划外")) {
                        rb2.setEnabled(true);
                        rb2.setChecked(true);
                    }

                    String bmfzr = bean.getMainform().get(0).getBmfzryj();
                    //String zcgkbmyj = bean.getMainform().get(0).getZcgkbmyj();
                    String fgfzr = bean.getMainform().get(0).getFgldyj();
//                    String jbldyj = bean.getMainform().get(0).getBmfzryj();
//                    String cwzjyj = bean.getMainform().get(0).getCwzjyj();
                    String zjl = bean.getMainform().get(0).getZjlyj();

                    etClass.setText(department);
                    etShenQingRen.setText(person);
                    tvTime.setText(time);
                    if (!bmfzr.equals("")) {
                        etLeader1.setText(getJSONData(bmfzr));
                    }
//                    if (!zcgkbmyj.equals("")) {
//                        etLeader2.setText(getJSONData(fgfzr));
//                    }
                    if (!fgfzr.equals("")) {
                        etLeader3.setText(getJSONData(fgfzr));
                    }
                    if (!zjl.equals("")) {
                        etLeader6.setText(getJSONData(zjl));
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(FlowWorkPruchaseDetailActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_NINE:
                    Gson gson2 = new Gson();
                    Filed filed = gson2.fromJson(downloadData, Filed.class);
                    String filePath = filed.getData().getFilePath();
                    String url = Constant.FIELDETAIL + filePath;
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    break;
                case TAG_FIVE:
                    Toast.makeText(FlowWorkPruchaseDetailActivity.this, msg.getData().getString("msg"), Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case TAG_SIX:
                    Toast.makeText(FlowWorkPruchaseDetailActivity.this, "提交数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

    private String getJSONData(String data) {
        String yijian = "";
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject = jsonArray.getJSONObject(jsonArray.length() - 1);
            yijian = jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return yijian;
    }

}
