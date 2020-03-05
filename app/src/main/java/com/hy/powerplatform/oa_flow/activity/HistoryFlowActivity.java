package com.hy.powerplatform.oa_flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.refreshview.CustomRefreshView;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.login.bean.History;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.oa_flow.adapter.FlowHistoryListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class HistoryFlowActivity extends BaseActivity implements FlowHistoryListAdapter.OnGetAdapterPositionListener {

    int limit = 20;
    int start = 0;
    String res = "";
    String tag = "";
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.inNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.tvAnQuan)
    TextView tvAnQuan;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.etData)
    EditText etData;
    @BindView(R.id.etPerson)
    EditText etPerson;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.llTerm)
    LinearLayout llTerm;
    @BindView(R.id.recyclerView)
    CustomRefreshView recyclerView;
    @BindView(R.id.btnFound)
    Button btnFound;
    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    List<History.ResultBean> beanList = new ArrayList<>();
    List<String> typeList = new ArrayList<String>();
    FlowHistoryListAdapter adapter;
    ArrayAdapter<String> typeAdapter;
    String type = "", name = "", person = "", startTime = "", endTime = "";
    String tagType = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        tagType = intent.getStringExtra("type");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.getRecyclerView().setLayoutManager(manager);
        initDatePicker();
        typeList.add("正在运行");
        typeList.add("运行结束");
        typeList.add("未启动");
        typeList.add("废弃");
        typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, typeList);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(typeAdapter);
        adapter = new FlowHistoryListAdapter(this, beanList);
        adapter.sendOnGetAdapterPositionListener(this);
        recyclerView.setAdapter(adapter);
        getData(start, limit);
        setClient();
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvStartTime.setText(now.split(" ")[0]);
        tvEndTime.setText(now.split(" ")[0]);
        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvStartTime.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker1.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker1.setIsLoop(false);

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                tvEndTime.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker2.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker2.setIsLoop(false);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /**
     * 获取数据
     *
     * @param start
     * @param limit
     */
    private void getData(final int start, final int limit) {
        ProgressDialogUtil.startLoad(this, "获取数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.HISTORYLIST + start + "&limit=" + limit;
                DBHandler dbA = new DBHandler();
                res = dbA.OAHistory(url, type, name, person, startTime, endTime,tagType);
                if (res.equals("获取数据失败")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_ONE);
                }
            }
        }).start();
    }
    private void getData1(final int start, final int limit) {
        beanList.clear();
        ProgressDialogUtil.startLoad(this, "获取数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.HISTORYLIST + start + "&limit=" + limit;
                DBHandler dbA = new DBHandler();
                res = dbA.OAHistory(url, type, name, person, startTime, endTime,tagType);
                if (res.equals("获取数据失败")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_ONE);
                }
            }
        }).start();
    }

    /**
     * 滑动监听
     */
    private void setClient() {
        recyclerView.setOnLoadListener(new CustomRefreshView.OnLoadListener() {
            @Override
            public void onRefresh() {
                beanList.clear();
                start = 0;
                limit = 20;
                getData(start, limit);
            }

            @Override
            public void onLoadMore() {
                start = limit;
                limit += 20;
                getData(start, limit);
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_history;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        llNoContent.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        if (ll.getVisibility() == View.VISIBLE) {
            ll.setVisibility(View.GONE);
        } else {
            ll.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getAdapterPosition(int position) {
        Intent intent = null;
        if (beanList.get(position).getFormDefId().equals(Constant.EMAINTAIN)) {
            intent = new Intent(this, FlowEMaintainDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.ZGSFLOW)) {
            intent = new Intent(this, FlowZGSPayDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        }
        if (beanList.get(position).getFormDefId().equals(Constant.CARVIDEO)) {
            intent = new Intent(this, FlowCarVideoDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.DORM)) {
            intent = new Intent(this, FlowDormDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.GCADD)) {
            intent = new Intent(this, FlowGCAddDetailActivity.class);
            intent.putExtra("tag", "1");
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.GCCHECK)) {
            intent = new Intent(this, FlowGCAddDetailActivity.class);
            intent.putExtra("tag", "2");
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.COMPLAIN)) {
            intent = new Intent(this, FlowComplainDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.GCQD)) {
            intent = new Intent(this, FlowJSGCDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.INSTALL)) {
            intent = new Intent(this, FlowInstallDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.DINNER)) {
            intent = new Intent(this, FlowDinnerDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.CONTRACTSIGN)) {
            intent = new Intent(this, FlowContractSignDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.APPEAL)) {
            intent = new Intent(this, FlowAppealDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.CARSAFE)) {
            intent = new Intent(this, FlowCarSafeDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.SAFER1)) {
            intent = new Intent(this, FlowSaferllDetailActivity.class);
            intent.putExtra("tag", "1");
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.SAFER2)) {
            intent = new Intent(this, FlowSaferllDetailActivity.class);
            intent.putExtra("tag", "2");
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.USERCAR)) {
            intent = new Intent(this, FlowUseCarDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.GHCONTRACTSINGLE)) {
            intent = new Intent(this, FlowGHContractSignDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }


        if (beanList.get(position).getFormDefId().equals(Constant.ENTRY)) {
            intent = new Intent(this, FlowEntryDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.LEAVER)) {
            intent = new Intent(this, FlowLeaveDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.CHUCAI)) {
            intent = new Intent(this, FlowChuCaiDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.DRIVERASSESS)) {
            intent = new Intent(this, FlowDriverAssessDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.OVERTIME)) {
            intent = new Intent(this, FlowOverTimeDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }


        if (beanList.get(position).getFormDefId().equals(Constant.BILL)) {
            intent = new Intent(this, FlowBillDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.CONTRACEPAY)) {
            intent = new Intent(this, FlowContractPayDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.PAYFLOW)) {
            intent = new Intent(this, FlowFuKuanLiuChengDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.GHPAYFLOW)) {
            intent = new Intent(this, FlowGHPayDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }


        if (beanList.get(position).getFormDefId().equals(Constant.WORKPUECHASE)) {
            intent = new Intent(this, FlowWorkPruchaseDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.GOODSPUECHASE)) {
            intent = new Intent(this, FlowGoodsPruchaseDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.PUECHASEFLOW)) {
            intent = new Intent(this, FlowPruchaseDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.REPAIR)) {
            intent = new Intent(this, FlowRepairDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.CCTPUECHASE)) {
            intent = new Intent(this, FlowCCTPruchaseDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.GHPUECHASE)) {
            intent = new Intent(this, FlowGHPruchaseDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }


        if (beanList.get(position).getFormDefId().equals(Constant.OUTMESSAGE)) {
            intent = new Intent(this, FlowOutMessageDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }

        if (beanList.get(position).getFormDefId().equals(Constant.HUIQIAN)) {
            intent = new Intent(this, FlowHuiQianDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }
        if (beanList.get(position).getFormDefId().equals(Constant.COMPMESSAGE)) {
            intent = new Intent(this, FlowCompMessageDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
        }

        startActivity(intent);
    }

    @OnClick({R.id.ll, R.id.tvStartTime, R.id.tvEndTime,R.id.btnFound})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnFound:
                beanList.clear();
                adapter.notifyDataSetChanged();
                type = (String) spinner.getSelectedItem();
                if (type.equals("未启动")){
                    type = "0";
                }else if (type.equals("正在运行")){
                    type = "1";
                }else if (type.equals("运行结束")){
                    type = "2";
                }else if (type.equals("废弃")){
                    type = "3";
                }
                name = etData.getText().toString();
                person = etPerson.getText().toString();
                startTime =  tvStartTime.getText().toString()+ " " + "00:00:00";
                final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                String now = sdf.format(new Date());
                endTime = tvEndTime.getText().toString()+" " + now.split(" ")[1];
                getData1(0,20);
                break;
            case R.id.ll:
                if (llTerm.getVisibility() == View.VISIBLE) {
                    llTerm.setVisibility(View.GONE);
                } else {
                    llTerm.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.tvStartTime:
                customDatePicker1.show(tvStartTime.getText().toString().split(" ")[0]);
                break;
            case R.id.tvEndTime:
                customDatePicker2.show(tvEndTime.getText().toString().split(" ")[0]);
                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    try {
                        JSONObject jsonObject = new JSONObject(res);
                        JSONArray jsonArray = jsonObject.getJSONArray("result");
                        if (jsonArray.length() == 0 && beanList.size() == 0) {
                            if (recyclerView != null) {
                                recyclerView.setVisibility(View.GONE);
                                llNoContent.setVisibility(View.VISIBLE);
                                ll.setVisibility(View.GONE);
                            }
                            ProgressDialogUtil.stopLoad();
                            break;
                        } else if (jsonArray.length() == 0 && beanList.size() != 0) {
                            if (recyclerView != null) {
                                recyclerView.complete();
                                recyclerView.onNoMore();
                            }
                        }
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonOnjectData = jsonArray.getJSONObject(i);
                            History.ResultBean bean = new History.ResultBean();
                            bean.setSubject(jsonOnjectData.getString("subject"));
                            bean.setRunId(jsonOnjectData.getString("runId"));
                            bean.setFormDefId(jsonOnjectData.getString("formDefId"));
                            bean.setProcessName(jsonOnjectData.getString("processName"));
                            bean.setCreatetime(jsonOnjectData.getString("createtime"));
                            bean.setCreator(jsonOnjectData.getString("creator"));
                            beanList.add(bean);
                        }
                        if (jsonArray.length() < 20) {
                            if (tag.equals("down")) {
                                if (recyclerView != null) {
                                    adapter.notifyDataSetChanged();
                                    recyclerView.complete();
                                    recyclerView.onNoMore();
                                }
                            } else {
                                if (recyclerView != null) {
                                    adapter.notifyDataSetChanged();
                                    recyclerView.complete();
                                    recyclerView.onNoMore();
                                }
                            }
                        } else {
                            if (recyclerView != null) {
                                adapter.notifyDataSetChanged();
                                recyclerView.complete();
                            }
                        }
                        if (start == 0) {
                            ProgressDialogUtil.stopLoad();
                            if (recyclerView != null) {
                                recyclerView.complete();
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        handler.sendEmptyMessage(TAG_THERE);
                    }
                    ll.setVisibility(View.GONE);
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(HistoryFlowActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_THERE:
                    Toast.makeText(HistoryFlowActivity.this, "解析失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

}
