package com.hy.powerplatform.weekly;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
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

public class WeeklyListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.tvAll)
    TextView tvAll;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    String msg = "";
    String backData = "";
    WeeklyListAdapter adapter;
    List<WeeklyList> beanList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        initDatePicker();
        getData();
    }

    private void getData() {
        final String startDate = tvStartTime.getText().toString();
        final String endDate = tvEndTime.getText().toString();
        showLoading(Constant.GETDATA);
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    String url1 = Constant.BASE_URL2 + "system/listAppDiary.do" + "?startDate=" + startDate + "&endDate=" + endDate;
                    URL url = new URL(url1);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setReadTimeout(200000);
                    connection.setConnectTimeout(200000);
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    int responseCode = connection.getResponseCode();
                    if (200 == responseCode) {
                        while ((line = reader.readLine()) != null) {
                            builder.append(line);
                        }
                        JSONObject jsonObject = new JSONObject(builder.toString());
                        if (jsonObject.get("success").equals(true)) {
                            backData = jsonObject.toString();
                            Message message = new Message();
                            message.what = Constant.TAG_ONE;
                            handler.sendMessage(message);
                        } else {
                            msg = jsonObject.getString("msg");
                            Message message = new Message();
                            message.what = Constant.TAG_TWO;
                            handler.sendMessage(message);
                        }
                    }
                } catch (MalformedURLException e) {
                    Log.i("XXX", e.toString());
                } catch (IOException e) {
                    Log.i("XXX", e.toString());
                    msg = e.toString();
                    Message message = new Message();
                    message.what = Constant.TAG_TWO;
                    handler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_weekly_list;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        beanList.clear();
        getData();
        adapter.notifyDataSetChanged();
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, -8);
        Date d = c.getTime();
        String day = format.format(d);
        tvStartTime.setText(day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        tvEndTime.setText(now.split(" ")[0]);

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                // 回调接口，获得选中的时间
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date dt1;
                Date dt2;
                try {
                    dt1 = df.parse(time.split(" ")[0]);
                    dt2 = df.parse(tvEndTime.getText().toString());
                    if (dt1.getTime() > dt2.getTime()) {
                        Toast.makeText(WeeklyListActivity.this, "请选择正确的时间", Toast.LENGTH_SHORT).show();
                    } else if (dt1.getTime() <= dt2.getTime()) {
                        tvStartTime.setText(time.split(" ")[0]);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                // 回调接口，获得选中的时间
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date dt1;
                Date dt2;
                try {
                    dt1 = df.parse(tvStartTime.getText().toString());
                    dt2 = df.parse(time.split(" ")[0]);
                    if (dt1.getTime() > dt2.getTime()) {
                        Toast.makeText(WeeklyListActivity.this, "请选择正确的时间", Toast.LENGTH_SHORT).show();
                    } else if (dt1.getTime() <= dt2.getTime()) {
                        tvEndTime.setText(time.split(" ")[0]);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(false); // 显示时和分
        customDatePicker2.setIsLoop(false); // 允许循环滚动
    }

    private boolean sendHttpContent() {
        Date startTime = null, endTime = null;
        if (tvStartTime.getText().toString().isEmpty() || tvStartTime.getText().toString().isEmpty()) {
            Toast.makeText(this, "起止时间不能为空", Toast.LENGTH_SHORT).show();
        } else {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                startTime = sdf1.parse(tvStartTime.getText().toString());
                endTime = sdf1.parse(tvEndTime.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (startTime.getTime() > endTime.getTime()) {
            Toast.makeText(this, "请选择正确时间", Toast.LENGTH_SHORT).show();
            return false;
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

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg1) {
            super.handleMessage(msg1);
            switch (msg1.what){
                case Constant.TAG_ONE:
                    try {
                        JSONObject jsonObject = new JSONObject(backData);
                        JSONArray jsonArray = jsonObject.getJSONArray("result");
                        for (int i = 0;i<jsonArray.length();i++){
                            JSONObject jsonOnjectData = jsonArray.getJSONObject(i);
                            WeeklyList bean = new WeeklyList();
                            bean.setContent(jsonOnjectData.getString("content"));
                            bean.setTitleName(jsonOnjectData.getString("titleName"));
                            bean.setFileId(jsonOnjectData.getString("fileId"));
                            bean.setFileName(jsonOnjectData.getString("fileName"));
                            bean.setDayTime(jsonOnjectData.getString("dayTime"));
                            bean.setStartDate(jsonOnjectData.getString("startDate"));
                            bean.setEndDate(jsonOnjectData.getString("endDate"));
                            bean.setUserName(jsonOnjectData.getString("userName"));
                            bean.setDepName(jsonOnjectData.getString("deptName"));
                            beanList.add(bean);
                        }
                        adapter = new WeeklyListAdapter(WeeklyListActivity.this,beanList);
                        recyclerView.setAdapter(adapter);
                        hideLoading();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case Constant.TAG_TWO:
                    Toast.makeText(WeeklyListActivity.this, msg, Toast.LENGTH_SHORT).show();
                    hideLoading();
                    break;
            }
        }
    };
}
