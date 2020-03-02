package com.hy.powerplatform.duban.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.duban.bean.DBUp1;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;

public class DBTJRCActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.etGY)
    EditText etGY;
    @BindView(R.id.etContent)
    EditText etContent;
    @BindView(R.id.tvFPR)
    TextView tvFPR;
    @BindView(R.id.rbType1)
    RadioButton rbType1;
    @BindView(R.id.rbType2)
    RadioButton rbType2;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.rbFS1)
    RadioButton rbFS1;
    @BindView(R.id.rbFS2)
    RadioButton rbFS2;
    @BindView(R.id.btnSave)
    Button btnSave;
    String userName = "";
    String profileId = "";
    String operId = "";
    String summary = "";
    String content = "";
    String data = "";
    private OkHttpUtil httpUtil;
    String path_url = Constant.BASE_URL1 + Constant.DBTJRC;
    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        operId = getIntent().getStringExtra("operId");
        summary = getIntent().getStringExtra("summary");
        content = getIntent().getStringExtra("content");
        etGY.setText(summary);
        etContent.setText(content);
        initDatePicker();
        httpUtil = OkHttpUtil.getInstance(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_dbtjrc;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, +1);
        Date d = c.getTime();
        String day = format.format(d);
        tvEndTime.setText(day);
        System.out.println("过去七天：" + day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        tvStartTime.setText(now.split(" ")[0]);

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                if (sendHttpContent(time.split(" ")[0])) {
                    tvStartTime.setText(time.split(" ")[0]);
                } else {
                    Toast.makeText(DBTJRCActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(DBTJRCActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
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

    @OnClick({R.id.tvFPR, R.id.tvStartTime, R.id.tvEndTime, R.id.btnSave})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvFPR:
                Intent intent = new Intent(this, DBCheckPersonActivity1.class);
                startActivityForResult(intent, TAG_ONE);
                break;
            case R.id.tvStartTime:
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.tvEndTime:
                customDatePicker2.show(tvEndTime.getText().toString());
                break;
            case R.id.btnSave:
                if (etGY.getText().toString().equals("")){
                    Toast.makeText(this, "概要不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etContent.getText().toString().equals("")){
                    Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvFPR.getText().toString().equals("")){
                    Toast.makeText(this, "分配人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                String urgent = "";
                if (rb1.isChecked()){
                    urgent = "0";
                }else if (rb2.isChecked()){
                    urgent = "1";
                }else if (rb3.isChecked()){
                    urgent = "2";
                }

                String taskType = "";
                if (rbType1.isChecked()){
                    taskType = "1";
                }else if (rbType2.isChecked()){
                    taskType = "2";
                }

                String showStyle = "";
                if (rbFS1.isChecked()){
                    showStyle = "1";
                }else if (rbFS2.isChecked()){
                    showStyle = "2";
                }
                HashMap<String, String> map = new HashMap();
                map.put("type", "执行任务");
                map.put("operId", operId);
                map.put("calendarPlan.urgent", urgent);
                map.put("calendarPlan.summary", etGY.getText().toString());
                map.put("calendarPlan.content", etContent.getText().toString());
                map.put("calendarPlan.userId", profileId);
                map.put("calendarPlan.fullname", tvFPR.getText().toString());
                map.put("calendarPlan.taskType", taskType);
                map.put("calendarPlan.startTime", tvStartTime.getText().toString());
                map.put("calendarPlan.endTime", tvEndTime.getText().toString());
                map.put("calendarPlan.showStyle", showStyle);
                ProgressDialogUtil.startLoad(this, getResources().getString(R.string.up_data));
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
//                      Log.i("main", "response:" + response.body().string());
                        data = response.body().string();
                        Message message = new Message();
                        Bundle b = new Bundle();
                        b.putString("data", data);
                        message.setData(b);
                        message.what = Constant.TAG_TWO;
                        handler.sendMessage(message);
                    }
                });
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_ONE:
                if (resultCode == Constant.TAG_SEVEN) {
                    userName = data.getStringExtra("name");
                    profileId = data.getStringExtra("profileId");
                    tvFPR.setText(userName);
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
                    Toast.makeText(DBTJRCActivity.this, error, Toast.LENGTH_SHORT).show();
                    break;
                case Constant.TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    Gson gsonF = new Gson();
                    DBUp1 bean = gsonF.fromJson(data, DBUp1.class);
                    if (bean.isSuccess()){
                        Toast.makeText(DBTJRCActivity.this, "添加日程成功", Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
            }
        }
    };
}
