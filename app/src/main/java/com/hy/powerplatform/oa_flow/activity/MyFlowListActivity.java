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
import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.oa_flow.adapter.MyFlowListAdapter;
import com.hy.powerplatform.oa_flow.bean.MyLeave;

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

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class MyFlowListActivity extends BaseActivity implements MyFlowListAdapter.OnGetAdapterPositionListener {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    CustomRefreshView recyclerView;
    MyFlowListAdapter adapter;
    List<MyLeave.ResultBean> beanList = new ArrayList<>();
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
        adapter = new MyFlowListAdapter(this, beanList);
        adapter.sendOnGetAdapterPositionListener(this);
        recyclerView.setAdapter(adapter);
        ProgressDialogUtil.startLoad(this, "获取数据中");
        getData(start, limit,tvStartTime.getText().toString()
                ,tvEndTime.getText().toString(),etTitle.getText().toString());
        setClient();
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
     * @param start
     * @param limit
     */
    private void getData(final int start, final int limit, final String startTine, final String endTime, final String title) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.MYLIST + start + "&limit=" + limit
                        + "&proTypeId=" + tagType+"&Q_vo.createtime_D_GE="+startTine
                        +"&Q_vo.Q_vo.createtime_D_LE="+endTime+"&Q_subject_S_LK="+title;
                DBHandler dbA = new DBHandler();
                res = dbA.OAQingJiaWillDo(url);
                if (res.equals("获取数据失败") || res.equals("")) {
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
                adapter.notifyDataSetChanged();
                start = 0;
                limit = 20;
                getData(start, limit,tvStartTime.getText().toString()
                        ,tvEndTime.getText().toString(),etTitle.getText().toString());
            }

            @Override
            public void onLoadMore() {
                start = limit;
                limit += 20;
                getData(start, limit,tvStartTime.getText().toString()
                        ,tvEndTime.getText().toString(),etTitle.getText().toString());
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_my_will_do1;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        beanList.clear();
        ProgressDialogUtil.startLoad(this, "获取数据中");
        getData(start, limit,tvStartTime.getText().toString()
                ,tvEndTime.getText().toString(),etTitle.getText().toString());
    }

    @Override
    public void getAdapterPosition(int position) {
        Intent intent = null;
        if (beanList.get(position).getFormDefId().equals(Constant.EMAINTAIN)) {
            intent = new Intent(this, FlowEMaintainDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.ZGSFLOW)) {
            intent = new Intent(this, FlowZGSPayDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        }else if (beanList.get(position).getFormDefId().equals(Constant.CARVIDEO)) {
            intent = new Intent(this, FlowCarVideoDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.DORM)) {
            intent = new Intent(this, FlowDormDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GCADD)) {
            intent = new Intent(this, FlowGCAddDetailActivity.class);
            intent.putExtra("tag", "1");
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GCCHECK)) {
            intent = new Intent(this, FlowGCAddDetailActivity.class);
            intent.putExtra("tag", "2");
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.COMPLAIN)) {
            intent = new Intent(this, FlowComplainDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GCQD)) {
            intent = new Intent(this, FlowJSGCDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.INSTALL)) {
            intent = new Intent(this, FlowInstallDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.DINNER)) {
            intent = new Intent(this, FlowDinnerDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.CONTRACTSIGN)) {
            intent = new Intent(this, FlowContractSignDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.APPEAL)) {
            intent = new Intent(this, FlowAppealDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.CARSAFE)) {
            intent = new Intent(this, FlowCarSafeDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.SAFER1)) {
            intent = new Intent(this, FlowSaferllDetailActivity.class);
            intent.putExtra("tag", "1");
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.SAFER2)) {
            intent = new Intent(this, FlowSaferllDetailActivity.class);
            intent.putExtra("tag", "2");
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.USERCAR)) {
            intent = new Intent(this, FlowUseCarDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.ENTRY)) {
            intent = new Intent(this, FlowEntryDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        }else if (beanList.get(position).getFormDefId().equals(Constant.WORKENTRY)) {
            intent = new Intent(this, FlowAssessDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.LEAVER)) {
            intent = new Intent(this, FlowLeaveDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.CHUCAI)) {
            intent = new Intent(this, FlowChuCaiDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.DRIVERASSESS)) {
            intent = new Intent(this, FlowDriverAssessDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.OVERTIME)) {
            intent = new Intent(this, FlowOverTimeDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.BILL)) {
            intent = new Intent(this, FlowBillDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.CONTRACEPAY)) {
            intent = new Intent(this, FlowContractPayDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.PAYFLOW)) {
            intent = new Intent(this, FlowFuKuanLiuChengDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.WORKPUECHASE)) {
            intent = new Intent(this, FlowWorkPruchaseDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GOODSPUECHASE)) {
            intent = new Intent(this, FlowGoodsPruchaseDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.PUECHASEFLOW)) {
            intent = new Intent(this, FlowPruchaseDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.REPAIR)) {
            intent = new Intent(this, FlowRepairDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.OUTMESSAGE)) {
            intent = new Intent(this, FlowOutMessageDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.HUIQIAN)) {
            intent = new Intent(this, FlowHuiQianDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.COMPMESSAGE)) {
            intent = new Intent(this, FlowCompMessageDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.CCTPUECHASE)) {
            intent = new Intent(this, FlowCCTPruchaseDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GHPUECHASE)) {
            intent = new Intent(this, FlowGHPruchaseDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GHPAYFLOW)) {
            intent = new Intent(this, FlowGHPayDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
            startActivity(intent);
        } else if (beanList.get(position).getFormDefId().equals(Constant.GHCONTRACTSINGLE)) {
            intent = new Intent(this, FlowGHContractSignDetailActivity.class);
            intent.putExtra("bean", beanList.get(position).getRunId());
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
                    Gson gson = new Gson();
                    MyLeave bean = gson.fromJson(res, MyLeave.class);
                    for (int i = 0; i < bean.getResult().size(); i++) {
                        beanList.add(bean.getResult().get(i));
                    }

                    if (bean.getResult().size() == 0 && beanList.size() == 0) {
                        if (recyclerView != null) {
                            Toast.makeText(MyFlowListActivity.this, "暂无该时间段内数据.", Toast.LENGTH_SHORT).show();
                        }
                        adapter.notifyDataSetChanged();
                        ProgressDialogUtil.stopLoad();
                        break;
                    } else if (bean.getResult().size() == 0 && beanList.size() != 0) {
                        if (recyclerView != null) {
                            recyclerView.complete();
                            recyclerView.onNoMore();
                            adapter.notifyDataSetChanged();
                        }
                    } else if (bean.getResult().size() != 0 && beanList.size() != 0 && bean.getResult().size() < 20) {
                        if (recyclerView != null) {
                            recyclerView.complete();
                            recyclerView.onNoMore();
                            adapter.notifyDataSetChanged();
                        }
                    } else {
                        if (recyclerView != null) {
                            recyclerView.complete();
                            adapter.notifyDataSetChanged();
                        }
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(MyFlowListActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_THERE:
                    Toast.makeText(MyFlowListActivity.this, "解析失败", Toast.LENGTH_SHORT).show();
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
                if (sendHttpContent(time.split(" ")[0])){
                    tvStartTime.setText(time.split(" ")[0]);
                }else {
                    Toast.makeText(MyFlowListActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
                }
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                if (sendHttpContent1(time.split(" ")[0])){
                    tvEndTime.setText(time.split(" ")[0]);
                }else {
                    Toast.makeText(MyFlowListActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.tvStartTime, R.id.tvEndTime})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvStartTime:
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.tvEndTime:
                customDatePicker2.show(tvEndTime.getText().toString());
                break;
        }
    }
}
