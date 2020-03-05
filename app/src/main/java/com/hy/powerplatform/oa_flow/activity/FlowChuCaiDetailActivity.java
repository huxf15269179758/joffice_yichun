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
import com.hy.powerplatform.oa_flow.bean.MyChuChai;
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

public class FlowChuCaiDetailActivity extends BaseActivity {


    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.etAllTime)
    TextView etAllTime;
    @BindView(R.id.etAddress1)
    TextView etAddress1;
    @BindView(R.id.etAddress2)
    TextView etAddress2;
    @BindView(R.id.etAddress3)
    TextView etAddress3;
    @BindView(R.id.tvCar)
    TextView tvCar;
    @BindView(R.id.tvReason)
    TextView tvReason;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.tvYJMoney)
    TextView tvYJMoney;
    @BindView(R.id.tvZJMoney)
    TextView tvZJMoney;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.tvLeader2)
    TextView tvLeader2;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
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
    @BindView(R.id.tvLeaderCWZJ)
    TextView tvLeaderCWZJ;
    private String res;
    String flowMessage = "";
    String xiangguanfujian = "";
    String runID = "";
    String downloadData = "";
    FlowMessageAdapter adapter;
    List<FlowMessage1.DataBean> flowList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        header.setTvRight("追回");
        tvLeaderW.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader1W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader2W.setTextColor(getResources().getColor(R.color.order_stop_black));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
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
        return R.layout.activity_chucai_data;
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
                ProgressDialogUtil.startLoad(FlowChuCaiDetailActivity.this, "获取数据中");
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
                    adapter = new FlowMessageAdapter(FlowChuCaiDetailActivity.this, flowList);
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(FlowChuCaiDetailActivity.this, "查询成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_ONE:
                    Gson gson = new Gson();
                    MyChuChai bean = gson.fromJson(res, MyChuChai.class);
                    final String date = bean.getMainform().get(0).getSqsj();
                    final String person = bean.getMainform().get(0).getChuchairenyuan();
                    final String startTime = bean.getMainform().get(0).getCcrq();
                    final String endTime = bean.getMainform().get(0).getJiezhiriqi();
                    final String days = bean.getMainform().get(0).getCcts();
                    final String address1 = bean.getMainform().get(0).getCcdd();
                    final String address2 = bean.getMainform().get(0).getTujing();
                    final String address3 = bean.getMainform().get(0).getMudidi();
                    final String department = bean.getMainform().get(0).getSbbm();
                    String jtgj1 = bean.getMainform().get(0).getJtgj1();
                    String jtgj2 = bean.getMainform().get(0).getJtgj2();
                    String jtgj3 = bean.getMainform().get(0).getJtgj3();
                    String jtgj4 = bean.getMainform().get(0).getJtgj4();
                    final String reason = bean.getMainform().get(0).getCcsy();
                    final String yjMoney = bean.getMainform().get(0).getYjfy();
                    final String zjMoney = bean.getMainform().get(0).getZjxj();
                    String bmfzryj = bean.getMainform().get(0).getBmfzryj();
                    String fgldyj = bean.getMainform().get(0).getFgldyj();
                    String cwzjyi = bean.getMainform().get(0).getCwzjyj();
                    String zjlyj = bean.getMainform().get(0).getZjlyj();
                    xiangguanfujian = bean.getMainform().get(0).getXiangguanfujian();
                    if (xiangguanfujian.equals("")) {
                        llData.setVisibility(View.GONE);
                    } else {
                        tvData.setText(xiangguanfujian);
                    }
                    runID = bean.getMainform().get(0).getRunId();
                    tvData.setText(xiangguanfujian);
                    tvTime.setText(date);
                    tvPerson.setText(person);
                    tvStartTime.setText(startTime);
                    tvEndTime.setText(endTime);
                    etAllTime.setText(days);
                    etAddress1.setText(address1);
                    etAddress2.setText(address2);
                    etAddress3.setText(address3);
                    tvReason.setText(reason);
                    tvYJMoney.setText(yjMoney);
                    tvZJMoney.setText(zjMoney);
                    tvDepartment.setText(department);
                    String carType = "";
                    if (!jtgj1.equals("")) {
                        carType = carType + "火车 ";
                    }
                    if (!jtgj2.equals("")) {
                        carType = carType + "飞机 ";
                    }
                    if (!jtgj3.equals("")) {
                        carType = carType + "驾车 ";
                    }
                    if (!jtgj4.equals("")) {
                        carType = carType + "其他 ";
                    }
                    tvCar.setText(carType);
                    if (!bmfzryj.equals("")) {
                        tvLeader.setText(getJSONData(bmfzryj));
                    }
                    if (!fgldyj.equals("")) {
                        tvLeader1.setText(getJSONData(fgldyj));
                    }
                    if (!cwzjyi.equals("")) {
                        tvLeaderCWZJ.setText(getJSONData(cwzjyi));
                    }
                    if (!zjlyj.equals("")) {
                        tvLeader2.setText(getJSONData(zjlyj));
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(FlowChuCaiDetailActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(FlowChuCaiDetailActivity.this, msg.getData().getString("msg"), Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case TAG_SIX:
                    Toast.makeText(FlowChuCaiDetailActivity.this, "提交数据失败", Toast.LENGTH_SHORT).show();
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
