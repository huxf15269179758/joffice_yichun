package com.hy.powerplatform.oa_flow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.refreshview.CustomRefreshView;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.oa_flow.adapter.MyWillDoAdapter;
import com.hy.powerplatform.oa_flow.bean.MyWillDo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class MyWillDoActivity extends BaseActivity implements MyWillDoAdapter.OnGetAdapterPositionListener {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    CustomRefreshView recyclerView;
    MyWillDoAdapter adapter;
    List<MyWillDo.ResultBean> beanList = new ArrayList<>();
    int limit = 20;
    int start = 0;
    String res = "";
    String tag = "";
    String tagType = "";
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.etTitle)
    EditText etTitle;
    @BindView(R.id.tvStartTime1)
    TextView tvStartTime1;
    @BindView(R.id.tvEndTime1)
    TextView tvEndTime1;

    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
        Intent intent = getIntent();
        tagType = intent.getStringExtra("type");
        recyclerView.setRefreshEnable(false);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.getRecyclerView().setLayoutManager(manager);
        adapter = new MyWillDoAdapter(this, beanList);
        adapter.sendOnGetAdapterPositionListener(this);
        recyclerView.setAdapter(adapter);
        ProgressDialogUtil.startLoad(this, "获取数据中");
        getData(start, limit, tvStartTime1.getText().toString()
                , tvEndTime1.getText().toString(), etTitle.getText().toString());
        setClient();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        beanList.clear();
        adapter.notifyDataSetChanged();
        ProgressDialogUtil.startLoad(this, "获取数据中");
        getData(0, 20, tvStartTime1.getText().toString()
                , tvEndTime1.getText().toString(), etTitle.getText().toString());
        setClient();
    }

    /**
     * 获取数据
     *
     * @param start
     * @param limit
     */
    private void getData(final int start, final int limit, final String startTine, final String endTime, final String title) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.MYWILLDOLIST + start + "&limit=" + limit
                        + "&proTypeId=" + tagType + "&Q_createtime_D_GE="
                        + startTine+ "&Q_createtime_D_LE=" + endTime + "&Q_subject_S_LK=" + title;
//                DBHandler dbA = new DBHandler();
//                res = dbA.OAQingJiaWillDo(url);
                OkHttpClient okHttpClient = new OkHttpClient();
                String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
                final Request request = new Request.Builder()
                        .url(url)
                        .addHeader("Cookie",Session)
                        .get()//默认就是GET请求，可以不写
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        handler.sendEmptyMessage(TAG_TWO);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        res = response.body().string();
                        handler.sendEmptyMessage(TAG_ONE);
                    }
                });
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
                getData(start, limit, tvStartTime.getText().toString()
                        , tvEndTime.getText().toString(), etTitle.getText().toString());
            }

            @Override
            public void onLoadMore() {
                start = limit;
                limit += 20;
                getData(start, limit, tvStartTime.getText().toString()
                        , tvEndTime.getText().toString(), etTitle.getText().toString());
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_my_will_do;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        beanList.clear();
        ProgressDialogUtil.startLoad(this, "获取数据中");
        getData(0, 20, tvStartTime1.getText().toString()
                , tvEndTime1.getText().toString(), etTitle.getText().toString());
    }

    @Override
    public void getAdapterPosition(int position) {
        Intent intent = null;
        if (beanList.get(position).getFormDefId().equals(Constant.EMAINTAIN)) {
            intent = new Intent(this, FlowEMainatinWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.CARVIDEO)) {
            intent = new Intent(this, FlowCarVideoWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
                intent.putExtra("piId", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.DORM)) {
            intent = new Intent(this, FlowDormWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GCADD)) {
            intent = new Intent(this, FlowGCAddWillDetailActivity.class);
            intent.putExtra("tag", "1");
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GCCHECK)) {
            intent = new Intent(this, FlowGCAddWillDetailActivity.class);
            intent.putExtra("tag", "2");
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.COMPLAIN)) {
            intent = new Intent(this, FlowComplainWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GCQD)) {
            intent = new Intent(this, FlowJSGCWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.INSTALL)) {
            intent = new Intent(this, FlowInstallWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.DINNER)) {
            intent = new Intent(this, FlowreceiveDinnerWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.CONTRACTSIGN)) {
            intent = new Intent(this, FlowContractSignWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.APPEAL)) {
            intent = new Intent(this, FlowAppealWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.CARSAFE)) {
            intent = new Intent(this, FlowCarSafeWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.SAFER1)) {
            intent = new Intent(this, FlowSaferWillDetailActivity.class);
            intent.putExtra("tag", "1");
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.SAFER2)) {
            intent = new Intent(this, FlowSaferWillDetailActivity.class);
            intent.putExtra("tag", "2");
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.USERCAR)) {
            intent = new Intent(this, FlowUseCarWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.ENTRY)) {
            intent = new Intent(this, FlowEntryWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            String s = beanList.get(position).getPiId();
            intent.putExtra("piId", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        }else if (beanList.get(position).getFormDefId().equals(Constant.WORKENTRY)) {
            intent = new Intent(this, FlowAssessWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            String s = beanList.get(position).getPiId();
            intent.putExtra("piId", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.LEAVER)) {
            intent = new Intent(this, FlowLeaveWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.CHUCAI)) {
            intent = new Intent(this, FlowChuCaiWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.DRIVERASSESS)) {
            intent = new Intent(this, FlowDriverAssessWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.OVERTIME)) {
            intent = new Intent(this, FlowOverTimeWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.BILL)) {
            intent = new Intent(this, FlowBillWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.CONTRACEPAY)) {
            intent = new Intent(this, FlowContracterPayWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.PAYFLOW)) {
            intent = new Intent(this, FlowPayLiuChengWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GHPAYFLOW)) {
            intent = new Intent(this, FlowGHPayWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GHCONTRACTSINGLE)) {
            intent = new Intent(this, FlowGHContractSignWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.WORKPUECHASE)) {
            intent = new Intent(this, FlowWorkPuechaseWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("taskName", beanList.get(position).getTaskName());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GOODSPUECHASE)) {
            intent = new Intent(this, FlowGoodsPuechaseWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("taskName", beanList.get(position).getTaskName());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.PUECHASEFLOW)) {
            intent = new Intent(this, FlowPuechaseWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("taskName", beanList.get(position).getTaskName());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.REPAIR)) {
            intent = new Intent(this, FlowRepairWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.CCTPUECHASE)) {
            intent = new Intent(this, FlowCCTPuechaseWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GHPUECHASE)) {
            intent = new Intent(this, FlowGHPuechaseWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.OUTMESSAGE)) {
            intent = new Intent(this, FlowOutMessageWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.HUIQIAN)) {
            intent = new Intent(this, FlowHuiQianWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.COMPMESSAGE)) {
            intent = new Intent(this, FlowCompMessageWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        }else if (beanList.get(position).getFormDefId().equals(Constant.ZGSFLOW)) {
            intent = new Intent(this, FlowZGSPayWillDetailActivity.class);
            intent.putExtra("activityName", beanList.get(position).getActivityName());
            intent.putExtra("taskId", beanList.get(position).getTaskId());
            intent.putExtra("piId  ", beanList.get(position).getPiId());
            intent.putExtra("executionId", beanList.get(position).getExecutionId());
            startActivity(intent);
        } else {
            Toast.makeText(this, "当前流程已调整，不支持查看", Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(MyWillDoActivity.this, "暂无该时间段内数据.", Toast.LENGTH_SHORT).show();
                            }
                            adapter.notifyDataSetChanged();
                            ProgressDialogUtil.stopLoad();
                            break;
                        } else if (jsonArray.length() == 0 && beanList.size() != 0) {
                            if (recyclerView != null) {
                                recyclerView.complete();
                                recyclerView.onNoMore();
                            }
//                            adapter.notifyDataSetChanged();
                        }
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonOnjectData = jsonArray.getJSONObject(i);
                            MyWillDo.ResultBean bean = new MyWillDo.ResultBean();
                            bean.setTaskName(jsonOnjectData.getString("taskName"));
                            bean.setActivityName(jsonOnjectData.getString("activityName"));
                            if (!jsonOnjectData.isNull("assignee")) {
                                bean.setAssignee(jsonOnjectData.getString("assignee"));
                            }
                            bean.setCreateTime(jsonOnjectData.getString("createTime"));
                            bean.setExecutionId(jsonOnjectData.getString("executionId"));
                            bean.setPiId(jsonOnjectData.getString("piId"));
                            bean.setTaskId(jsonOnjectData.getString("taskId"));
                            bean.setState(jsonOnjectData.getString("state"));
                            bean.setFormDefId(jsonOnjectData.getString("formDefId"));
                            bean.setIsMultipleTask(jsonOnjectData.getString("isMultipleTask"));
                            bean.setCandidateUsers(jsonOnjectData.getString("candidateUsers"));
                            bean.setCandidateRoles(jsonOnjectData.getString("candidateRoles"));
                            bean.setCreator(jsonOnjectData.getString("creator"));
                            bean.setCreateTime(jsonOnjectData.getString("createTime"));
                            bean.setTaskName(jsonOnjectData.getString("taskName"));
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
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(MyWillDoActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_THERE:
                    Toast.makeText(MyWillDoActivity.this, "解析失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, -30);
        Date d = c.getTime();
        String day = format.format(d);
        tvStartTime.setText(day);
        System.out.println("过去七天：" + day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        tvEndTime.setText(now.split(" ")[0]);

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                if (sendHttpContent(time.split(" ")[0])) {
                    tvStartTime.setText(time.split(" ")[0]);
                    tvStartTime1.setText(time.split(" ")[0]);
                } else {
                    Toast.makeText(MyWillDoActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
                }
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                if (sendHttpContent1(time.split(" ")[0])) {
                    tvEndTime.setText(time.split(" ")[0]);
                    tvEndTime1.setText(time.split(" ")[0]);
                } else {
                    Toast.makeText(MyWillDoActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
                }
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(false); // 显示时和分
        customDatePicker2.setIsLoop(false); // 允许循环滚动
    }

    private boolean sendHttpContent(String startTime1) {
        Date startTime = null, endTime = null;
        if (tvStartTime.getText().toString().isEmpty() || tvStartTime.getText().toString().isEmpty()) {
            Toast.makeText(this, "起止时间不能为空", Toast.LENGTH_SHORT).show();
        } else {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                startTime = sdf1.parse(startTime1);
                endTime = sdf1.parse(tvEndTime.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        double s1 = startTime.getTime();
        double s2 = endTime.getTime();
        if (startTime.getTime() > endTime.getTime()) {
            return false;
//            Toast.makeText(this, "请选择正确时间", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private boolean sendHttpContent1(String endTime1) {
        Date startTime = null, endTime = null;
        if (tvStartTime.getText().toString().isEmpty() || tvStartTime.getText().toString().isEmpty()) {
            Toast.makeText(this, "起止时间不能为空", Toast.LENGTH_SHORT).show();
        } else {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                startTime = sdf1.parse(tvStartTime.getText().toString());
                endTime = sdf1.parse(endTime1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        double s1 = startTime.getTime();
        double s2 = endTime.getTime();
        if (startTime.getTime() > endTime.getTime()) {
            return false;
//            Toast.makeText(this, "请选择正确时间", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @OnClick({R.id.tvStartTime1, R.id.tvEndTime1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvStartTime1:
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.tvEndTime1:
                customDatePicker2.show(tvEndTime.getText().toString());
                break;
        }
    }
}
