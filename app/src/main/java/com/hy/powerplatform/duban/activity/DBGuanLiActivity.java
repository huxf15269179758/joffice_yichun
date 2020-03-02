package com.hy.powerplatform.duban.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.refreshview.CustomRefreshView;
import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.duban.bean.DBGuanLi;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapter;
import com.hy.powerplatform.my_utils.utils.BaseViewHolder;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;
import okhttp3.Response;

public class DBGuanLiActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.llTiaoJian)
    LinearLayout llTiaoJian;
    @BindView(R.id.spinnerType)
    Spinner spinnerType;
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etDBPerson)
    EditText etDBPerson;
    @BindView(R.id.etZXPerson)
    EditText etZXPerson;
    @BindView(R.id.tvOverTime)
    TextView tvOverTime;
    @BindView(R.id.tvOverTime1)
    TextView tvOverTime1;
    @BindView(R.id.spinnerZT)
    Spinner spinnerZT;
    @BindView(R.id.recyclerView)
    CustomRefreshView recyclerView;
    @BindView(R.id.llTiaoJian1)
    LinearLayout llTiaoJian1;

    String data = "";
    int limit = 20;
    int start = 0;
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapter baseAdapter;
    List<String> listTag = new ArrayList<String>();
    final HashMap<String, String> map = new HashMap();
    List<String> listType = new ArrayList<String>();
    List<DBGuanLi.ResultBean> beanList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1, customDatePicker2, customDatePicker3;
    String path_url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        listType.add("");
        listType.add("公司任务");
        listType.add("部门任务");

        listTag.add("");
        listTag.add("已编辑未提交");
        listTag.add("已提交未发布");
        listTag.add("已发布待执行");
        listTag.add("已提交待确认");
        listTag.add("执行完成");
        listTag.add("已撤回");
        listTag.add("暂停执行");

        ArrayAdapter adapterType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listType);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapterType);

        ArrayAdapter adapterTag = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTag);
        adapterTag.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerZT.setAdapter(adapterTag);
        initDatePicker();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.getRecyclerView().setLayoutManager(manager);
        baseAdapter = new BaseRecyclerAdapter<DBGuanLi.ResultBean>(this, R.layout.adapter_dblist_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final DBGuanLi.ResultBean resultBean) {
                holder.setText(R.id.tvTaskName, resultBean.getTaskName());
                holder.setText(R.id.tvContent, resultBean.getTaskContext());
                holder.setText(R.id.tvTime, resultBean.getCreateTime());
                holder.setOnClickListener(R.id.ll, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DBGuanLiActivity.this,DBDetailGLActivity.class);
                        intent.putExtra("bean",resultBean);
                        startActivity(intent);
                    }
                });
            }
        };
        recyclerView.setAdapter(baseAdapter);
        baseAdapter.notifyDataSetChanged();

        httpUtil = OkHttpUtil.getInstance(this);
        getData(start, limit);
        setClient();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_dbguan_li;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        beanList.clear();
        limit = 20;
        start = 0;
        getData(start,limit);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        beanList.clear();
        limit = 20;
        start = 0;
        getData(start,limit);
    }

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
        tvOverTime1.setText(now.split(" ")[0]);

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                if (sendHttpContent(time.split(" ")[0])) {
                    tvStartTime.setText(time.split(" ")[0]);
                } else {
                    Toast.makeText(DBGuanLiActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
                }
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvEndTime.setText(time.split(" ")[0]);
                if (sendHttpContent1(time.split(" ")[0])) {
                    tvEndTime.setText(time.split(" ")[0]);
                } else {
                    Toast.makeText(DBGuanLiActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
                }
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(false); // 显示时和分
        customDatePicker2.setIsLoop(false); // 允许循环滚动

        customDatePicker3 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvOverTime.setText(time.split(" ")[0]);
                tvOverTime1.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker3.showSpecificTime(false); // 显示时和分
        customDatePicker3.setIsLoop(false); // 允许循环滚动
    }

    public void getData(final int start, final int limit) {
        path_url = Constant.BASE_URL1 + Constant.DBGLLIST+"?start="+start+"&limit="+limit;
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        map.clear();
        map.put("Q_createTime_D_GE", tvStartTime.getText().toString().trim());
        map.put("Q_createTime_D_LE", tvEndTime.getText().toString().trim());
        map.put("Q_taskType_S_EQ", spinnerType.getSelectedItem().toString());
        map.put("Q_taskName_S_LK", etName.getText().toString().trim());
        map.put("Q_supervisorNames_S_LK", etDBPerson.getText().toString().trim());
        map.put("Q_operatorNames_S_LK", etZXPerson.getText().toString().trim());
        map.put("Q_planFinishTime_D_EQ", tvOverTime.getText().toString().trim());
        map.put("searchAll", "false");

        String zt = "";
        if (spinnerZT.getSelectedItem().toString().trim().equals("已编辑未提交")){
            zt = "1";
        }else if (spinnerZT.getSelectedItem().toString().trim().equals("已提交未发布")){
            zt = "2";
        }else if (spinnerZT.getSelectedItem().toString().trim().equals("已发布待执行")){
            zt = "3";
        }else if (spinnerZT.getSelectedItem().toString().trim().equals("已提交待确认")){
            zt = "4";
        }else if (spinnerZT.getSelectedItem().toString().trim().equals("执行完成")){
            zt = "5";
        }else if (spinnerZT.getSelectedItem().toString().trim().equals("已撤回")){
            zt = "6";
        }else if (spinnerZT.getSelectedItem().toString().trim().equals("暂停执行")){
            zt = "7";
        }
        map.put("Q_taskStatus_N_EQ", zt);
        httpUtil.postForm(path_url, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
//                Log.i("main", "response:" + e.toString());
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = Constant.TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
//                Log.i("main", "response:" + response.body().string());
                data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = Constant.TAG_TWO;
                handler.sendMessage(message);
            }
        });
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

    @OnClick({R.id.tvStartTime, R.id.tvEndTime, R.id.llTiaoJian, R.id.tvOverTime})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvStartTime:
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.tvEndTime:
                customDatePicker2.show(tvEndTime.getText().toString());
                break;
            case R.id.tvOverTime:
                customDatePicker3.show(tvOverTime1.getText().toString());
                break;
            case R.id.llTiaoJian:
                if (llTiaoJian1.getVisibility() == View.VISIBLE) {
                    llTiaoJian1.setVisibility(View.GONE);
                } else {
                    llTiaoJian1.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Bundle b = msg.getData();
                    String error = b.getString("error");
                    ProgressDialogUtil.stopLoad();
//                    tvOverTime.setText("");
                    llTiaoJian1.setVisibility(View.GONE);
                    Toast.makeText(DBGuanLiActivity.this, error, Toast.LENGTH_SHORT).show();
                    break;
                case Constant.TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    Gson gsonF = new Gson();
                    DBGuanLi bean = gsonF.fromJson(data, DBGuanLi.class);
                    if (bean.getTotalCounts() != 0) {
                        for (int i = 0; i < bean.getResult().size(); i++) {
                            beanList.add(bean.getResult().get(i));
                        }
                        if (bean.getResult().size() == 0&&beanList.size()!=0){
                            if (recyclerView != null) {
                                recyclerView.complete();
                                recyclerView.onNoMore();
                                baseAdapter.notifyDataSetChanged();
                            }
                        }else if (bean.getResult().size() != 0&&beanList.size()!=0&&bean.getResult().size()<20){
                            if (recyclerView != null) {
                                recyclerView.complete();
                                recyclerView.onNoMore();
                                baseAdapter.notifyDataSetChanged();
                            }
                        }else {
                            if (recyclerView != null) {
                                recyclerView.complete();
                                baseAdapter.notifyDataSetChanged();
                            }
                        }
                        baseAdapter.notifyDataSetChanged();
                    }else {
                        recyclerView.complete();
                        recyclerView.onNoMore();
                    }
//                    tvOverTime.setText("");
                    llTiaoJian1.setVisibility(View.GONE);
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
