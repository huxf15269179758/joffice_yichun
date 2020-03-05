package com.hy.powerplatform.oa_flow.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
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
import com.hy.powerplatform.oa_flow.bean.FlowCarSafe;
import com.hy.powerplatform.oa_flow.bean.FlowMessage1;
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

public class FlowCarSafeDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvDpartment)
    TextView tvDpartment;
    @BindView(R.id.tvOutCarNo1)
    TextView tvOutCarNo1;
    @BindView(R.id.tvOutCarNo2)
    TextView tvOutCarNo2;
    @BindView(R.id.tvOutCarNo3)
    TextView tvOutCarNo3;
    @BindView(R.id.tvOutCarNo4)
    TextView tvOutCarNo4;
    @BindView(R.id.tvOutCarNo5)
    TextView tvOutCarNo5;
    @BindView(R.id.tvSafeSepart1)
    TextView tvSafeSepart1;
    @BindView(R.id.tvSafeSepart2)
    TextView tvSafeSepart2;
    @BindView(R.id.tvSafeSepart3)
    TextView tvSafeSepart3;
    @BindView(R.id.tvSafeSepart4)
    TextView tvSafeSepart4;
    @BindView(R.id.tvSafeSepart5)
    TextView tvSafeSepart5;
    @BindView(R.id.tvSafeType1)
    TextView tvSafeType1;
    @BindView(R.id.tvSafeType2)
    TextView tvSafeType2;
    @BindView(R.id.tvSafeType3)
    TextView tvSafeType3;
    @BindView(R.id.tvSafeType4)
    TextView tvSafeType4;
    @BindView(R.id.tvSafeType5)
    TextView tvSafeType5;
    @BindView(R.id.tvSafeMoney1)
    TextView tvSafeMoney1;
    @BindView(R.id.tvSafeMoney2)
    TextView tvSafeMoney2;
    @BindView(R.id.tvSafeMoney3)
    TextView tvSafeMoney3;
    @BindView(R.id.tvSafeMoney5)
    TextView tvSafeMoney5;
    @BindView(R.id.tvSafeMoney4)
    TextView tvSafeMoney4;
    @BindView(R.id.tvSafeDate1)
    TextView tvSafeDate1;
    @BindView(R.id.tvSafeDate2)
    TextView tvSafeDate2;
    @BindView(R.id.tvSafeDate3)
    TextView tvSafeDate3;
    @BindView(R.id.tvSafeDate4)
    TextView tvSafeDate4;
    @BindView(R.id.tvSafeDate5)
    TextView tvSafeDate5;
    @BindView(R.id.tvAllMoney)
    TextView tvAllMoney;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.etLeader)
    TextView etLeader;
    @BindView(R.id.etLeader1)
    TextView etLeader1;
    @BindView(R.id.etLeader2)
    TextView etLeader2;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.tvLeader2)
    TextView tvLeader2;
    @BindView(R.id.cb1)
    CheckBox cb1;
    @BindView(R.id.cb2)
    CheckBox cb2;
    @BindView(R.id.cb3)
    CheckBox cb3;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.cb4)
    CheckBox cb4;
    @BindView(R.id.cb5)
    CheckBox cb5;
    @BindView(R.id.cb6)
    CheckBox cb6;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.rb1)
    CheckBox rb1;
    @BindView(R.id.rb2)
    CheckBox rb2;
    @BindView(R.id.rb3)
    CheckBox rb3;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.rb4)
    CheckBox rb4;
    @BindView(R.id.rb5)
    CheckBox rb5;
    @BindView(R.id.rb6)
    CheckBox rb6;
    @BindView(R.id.ll4)
    LinearLayout ll4;
    @BindView(R.id.btnT)
    FloatingActionButton btnT;
    @BindView(R.id.tvText)
    TextView tvText;
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
    private String res;

    String xiangguanfujian = "";
    String flowMessage = "";
    String runID = "";
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
        header.setTvRight("追回");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        btnT.setVisibility(View.GONE);
        tvText.setVisibility(View.GONE);
        btnUp.setVisibility(View.GONE);
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
        return R.layout.activity_carsafe_data;
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
                message.what = Constant.TAG_FIVE;
                Bundle bundle = new Bundle();
                bundle.putString("msg", o.toString());
                message.setData(bundle);
                handler.sendMessage(message);
                finish();
            }

            @Override
            public void fail(String message) {
                Message message1 = new Message();
                message1.what = Constant.TAG_SIX;
                handler.sendMessage(message1);
            }
        });
    }

    @OnClick({R.id.tvData, R.id.btnHistory})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHistory:
                recyclerView.setVisibility(View.VISIBLE);
                ProgressDialogUtil.startLoad(FlowCarSafeDetailActivity.this, "获取数据中");
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
                    adapter = new FlowMessageAdapter(FlowCarSafeDetailActivity.this, flowList);
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(FlowCarSafeDetailActivity.this, "查询成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_ONE:
                    Gson gson = new Gson();
                    FlowCarSafe bean = gson.fromJson(res, FlowCarSafe.class);
                    String time = bean.getMainform().get(0).getSqrq();
                    String person = bean.getMainform().get(0).getSqr();
                    String department = bean.getMainform().get(0).getBm();
                    runID = bean.getMainform().get(0).getRunId();
                    xiangguanfujian = bean.getMainform().get(0).getXiangguanfujian();
                    if (xiangguanfujian.equals("")) {
                        llData.setVisibility(View.GONE);
                    } else {
                        tvData.setText(xiangguanfujian);
                    }
                    String carNo1 = bean.getMainform().get(0).getChepaihao1();
                    String carNo2 = bean.getMainform().get(0).getChepaihao2();
                    String carNo3 = bean.getMainform().get(0).getChepaihao3();
                    String carNo4 = bean.getMainform().get(0).getChepaihao4();
                    String carNo5 = bean.getMainform().get(0).getChepaihao5();

                    String comp1 = bean.getMainform().get(0).getBaoxiangongsi1();
                    String comp2 = bean.getMainform().get(0).getBaoxiangongsi2();
                    String comp3 = bean.getMainform().get(0).getBaoxiangongsi3();
                    String comp4 = bean.getMainform().get(0).getBaoxiangongsi4();
                    String comp5 = bean.getMainform().get(0).getBaoxiangongsi5();

                    String type1 = bean.getMainform().get(0).getXianzhong1();
                    String type2 = bean.getMainform().get(0).getXianzhong2();
                    String type3 = bean.getMainform().get(0).getXianzhong3();
                    String type4 = bean.getMainform().get(0).getXianzhong4();
                    String type5 = bean.getMainform().get(0).getXianzhong5();

                    String money1 = bean.getMainform().get(0).getJine1();
                    String money2 = bean.getMainform().get(0).getJine2();
                    String money3 = bean.getMainform().get(0).getJine3();
                    String money4 = bean.getMainform().get(0).getJine4();
                    String money5 = bean.getMainform().get(0).getJine5();

                    String date1 = bean.getMainform().get(0).getQibaoriqi1();
                    String date2 = bean.getMainform().get(0).getQibaoriqi2();
                    String date3 = bean.getMainform().get(0).getQibaoriqi3();
                    String date4 = bean.getMainform().get(0).getQibaoriqi4();
                    String date5 = bean.getMainform().get(0).getQibaoriqi5();

                    String allMonet = bean.getMainform().get(0).getHjje();
                    String bmfzryj = bean.getMainform().get(0).getBmfzryj();
                    String fgldyj = bean.getMainform().get(0).getFgldyj();
                    String zjlyj = bean.getMainform().get(0).getZjlyj();

                    tvTime.setText(time);
                    tvPerson.setText(person);
                    tvDpartment.setText(department);
                    tvOutCarNo1.setText(carNo1);
                    tvOutCarNo2.setText(carNo2);
                    tvOutCarNo3.setText(carNo3);
                    tvOutCarNo4.setText(carNo4);
                    tvOutCarNo5.setText(carNo5);

                    tvSafeSepart1.setText(comp1);
                    tvSafeSepart2.setText(comp2);
                    tvSafeSepart3.setText(comp3);
                    tvSafeSepart4.setText(comp4);
                    tvSafeSepart5.setText(comp5);

                    tvSafeType1.setText(type1);
                    tvSafeType2.setText(type2);
                    tvSafeType3.setText(type3);
                    tvSafeType4.setText(type4);
                    tvSafeType5.setText(type5);

                    tvSafeMoney1.setText(money1);
                    tvSafeMoney2.setText(money2);
                    tvSafeMoney3.setText(money3);
                    tvSafeMoney4.setText(money4);
                    tvSafeMoney5.setText(money5);

                    tvSafeDate1.setText(date1);
                    tvSafeDate2.setText(date2);
                    tvSafeDate3.setText(date3);
                    tvSafeDate4.setText(date4);
                    tvSafeDate5.setText(date5);

                    tvAllMoney.setText(allMonet);


                    if (!bmfzryj.equals("")) {
                        tvLeader.setText(getJSONData(bmfzryj));
                    }
                    if (!fgldyj.equals("")) {
                        tvLeader1.setText(getJSONData(fgldyj));
                    }
                    if (!zjlyj.equals("")) {
                        tvLeader2.setText(getJSONData(zjlyj));
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(FlowCarSafeDetailActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(FlowCarSafeDetailActivity.this, msg.getData().getString("msg"), Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case TAG_SIX:
                    Toast.makeText(FlowCarSafeDetailActivity.this, "提交数据失败", Toast.LENGTH_SHORT).show();
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
