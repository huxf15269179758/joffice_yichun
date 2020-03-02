package com.hy.powerplatform.duban.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.refreshview.CustomRefreshView;
import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.duban.bean.DBZXList;
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

public class DBZXListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    CustomRefreshView recyclerView;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.spinnerType)
    Spinner spinnerType;

    String data = "";
    int limit = 20;
    int start = 0;
    String userName = "";
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapter baseAdapter;
    List<String> listType = new ArrayList<String>();
    List<DBZXList.ResultBean>beanList = new ArrayList<>();
    String path_url;
    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        userName = new SharedPreferencesHelper(this,"login").getData(this,"userName","");
        listType.add("");
        listType.add("未查看");
        listType.add("已查看");
        listType.add("已接收");
        listType.add("已退回");
        listType.add("已提交");
        listType.add("已撤回");
        listType.add("已完成");
        listType.add("已冻结");
        listType.add("逾期完成");
        listType.add("未完成");
        ArrayAdapter adapterType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listType);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapterType);

        initDatePicker();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.getRecyclerView().setLayoutManager(manager);
        baseAdapter = new BaseRecyclerAdapter<DBZXList.ResultBean>(this, R.layout.adapter_dbzxlist_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final DBZXList.ResultBean resultBean) {
                holder.setText(R.id.tvTaskName, resultBean.getTaskName());
                holder.setText(R.id.tvContent, resultBean.getTaskContext());
                holder.setText(R.id.tvTime, resultBean.getCreateTime());
                String pizhu = resultBean.getAnnotation();
                if (pizhu==null||pizhu.equals("")){
                    holder.setGoneLL(R.id.llPZ);
                }else {
                    holder.setText(R.id.tvPiZhu, resultBean.getAnnotation());
                }
                if (resultBean.getOperStatus()==1){
                    holder.setText(R.id.tvStaue, "未查看");
                    holder.setColor(R.id.tvStaue, "1");
                    holder.setColor(R.id.tvSeeStaue, "1");
                }else if (resultBean.getOperStatus()==2){
                    holder.setText(R.id.tvStaue, "已查看");
                    holder.setColor(R.id.tvStaue, "2");
                    holder.setColor(R.id.tvSeeStaue, "2");
                }else if (resultBean.getOperStatus()==3){
                    holder.setText(R.id.tvStaue, "已接收");
                    holder.setColor(R.id.tvStaue, "3");
                    holder.setColor(R.id.tvSeeStaue, "3");
                }else if (resultBean.getOperStatus()==4){
                    holder.setText(R.id.tvStaue, "已退回");
                    holder.setColor(R.id.tvStaue, "4");
                    holder.setColor(R.id.tvSeeStaue, "4");
                }else if (resultBean.getOperStatus()==5){
                    holder.setText(R.id.tvStaue, "已提交");
                    holder.setColor(R.id.tvStaue, "5");
                    holder.setColor(R.id.tvSeeStaue, "5");
                }else if (resultBean.getOperStatus()==6){
                    holder.setText(R.id.tvStaue, "已撤回");
                    holder.setColor(R.id.tvStaue, "6");
                    holder.setColor(R.id.tvSeeStaue, "6");
                }else if (resultBean.getOperStatus()==7){
                    holder.setText(R.id.tvStaue, "已完成");
                    holder.setColor(R.id.tvStaue, "7");
                    holder.setColor(R.id.tvSeeStaue, "7");
                }else if (resultBean.getOperStatus()==8){
                    holder.setText(R.id.tvStaue, "已冻结");
                    holder.setColor(R.id.tvStaue, "8");
                    holder.setColor(R.id.tvSeeStaue, "8");
                }else if (resultBean.getOperStatus()==9){
                    holder.setText(R.id.tvStaue, "逾期完成");
                    holder.setColor(R.id.tvStaue, "9");
                    holder.setColor(R.id.tvSeeStaue, "9");
                }else if (resultBean.getOperStatus()==10){
                    holder.setText(R.id.tvStaue, "未完成");
                    holder.setColor(R.id.tvStaue, "10");
                    holder.setColor(R.id.tvSeeStaue, "10");
                }
                holder.setOnClickListener(R.id.ll, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DBZXListActivity.this,DBZXDetailActivity.class);
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
    protected void onRestart() {
        super.onRestart();
        beanList.clear();
        limit = 20;
        start = 0;
        getData(start,limit);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_dbzxlist;
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

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, -365);
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
                } else {
                    Toast.makeText(DBZXListActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(DBZXListActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
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

    public void getData(final int start, final int limit) {
        path_url = Constant.BASE_URL1 + Constant.DBZXLIST+"?start="+start+"&limit="+limit;
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final HashMap<String, String> map = new HashMap();
//        map.put("Q_createTime_D_GE", tvStartTime.getText().toString().trim());
//        map.put("Q_createTime_D_LE", tvEndTime.getText().toString().trim());
//        map.put("Q_operatorName_L_EQ", "");
        String zt = "";
        if (spinnerType.getSelectedItem().toString().trim().equals("未查看")){
            zt = "1";
        }else if (spinnerType.getSelectedItem().toString().trim().equals("已查看")){
            zt = "2";
        }else if (spinnerType.getSelectedItem().toString().trim().equals("已接收")){
            zt = "3";
        }else if (spinnerType.getSelectedItem().toString().trim().equals("已退回")){
            zt = "4";
        }else if (spinnerType.getSelectedItem().toString().trim().equals("已提交")){
            zt = "5";
        }else if (spinnerType.getSelectedItem().toString().trim().equals("已撤回")){
            zt = "6";
        }else if (spinnerType.getSelectedItem().toString().trim().equals("已完成")){
            zt = "7";
        }else if (spinnerType.getSelectedItem().toString().trim().equals("已冻结")){
            zt = "8";
        }else if (spinnerType.getSelectedItem().toString().trim().equals("逾期完成")){
            zt = "9";
        }else if (spinnerType.getSelectedItem().toString().trim().equals("未完成")){
            zt = "10";
        }
//        if (zt.equals("")){
//            map.put("Q_operStatus_N_EQ", "1,2,3");
//        }else {
            map.put("Q_operStatus_N_EQ", zt);
//        }
        map.put("searchAll", "false");
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

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Bundle b = msg.getData();
                    String error = b.getString("error");
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(DBZXListActivity.this, error, Toast.LENGTH_SHORT).show();
                    break;
                case Constant.TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    Gson gsonF = new Gson();
                    DBZXList bean = gsonF.fromJson(data, DBZXList.class);
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
                        baseAdapter.notifyDataSetChanged();
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
