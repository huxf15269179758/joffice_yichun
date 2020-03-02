package com.hy.powerplatform.oa_flow.metting.activity;

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
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapter;
import com.hy.powerplatform.my_utils.utils.BaseViewHolder;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.oa_flow.metting.bean.WillOpenList;

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

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class WillOpenListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.recyclerView)
    CustomRefreshView recyclerView;

    int limit = 20;
    int start = 0;
    @BindView(R.id.etType)
    EditText etType;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvStartTime1)
    TextView tvStartTime1;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.tvEndTime1)
    TextView tvEndTime1;
    @BindView(R.id.ll)
    LinearLayout ll;
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapter baseAdapter;
    final HashMap<String, String> map = new HashMap();
    List<WillOpenList.ResultBean> beanList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
        header.setTvTitle(getResources().getString(R.string.oaflow_metting_rb3));
        httpUtil = OkHttpUtil.getInstance(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.getRecyclerView().setLayoutManager(manager);
        baseAdapter = new BaseRecyclerAdapter<WillOpenList.ResultBean>(this, R.layout.adapter_rzlist_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final WillOpenList.ResultBean resultBean) {
                holder.setText(R.id.tv1, "标题");
                holder.setText(R.id.tvName, resultBean.getConfTopic());
                holder.setText(R.id.tv2, "会议室");
                holder.setText(R.id.tvPhone, resultBean.getRoomName());
                holder.setText(R.id.tv3, "开始时间");
                holder.setText(R.id.tvIdCard, resultBean.getStartTime());
                holder.setOnClickListener(R.id.ll, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(WillOpenListActivity.this, WillOpenDetailActivity.class);
                        intent.putExtra("bean", resultBean);
                        startActivity(intent);
                    }
                });
            }
        };
        recyclerView.setAdapter(baseAdapter);

        getData(start, limit);
        setClient();
    }

    private void getData(final int start, final int limit) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.WILLOPEN + "?start=" + start + "&limit=" + limit;
        map.clear();
        map.put("sort", "confId");
        map.put("dir", "DESC");
        map.put("conference.roomName", etType.getText().toString());
        map.put("conference.startTime",  tvStartTime1.getText().toString());
        map.put("conference.endTime", tvEndTime1.getText().toString());
        httpUtil.postForm(path_url, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
//                Log.i("main", "response:" + e.toString());
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
//                Log.i("main", "response:" + response.body().string());
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = TAG_TWO;
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

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_mywill_open;
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
        getData(start, limit);
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

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                if (sendHttpContent(time.split(" ")[0])) {
                    tvStartTime.setText(time.split(" ")[0]);
                    tvStartTime1.setText(time.split(" ")[0]);
                } else {
                    Toast.makeText(WillOpenListActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(WillOpenListActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
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

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    String message = msg.getData().getString("error");
                    Toast.makeText(WillOpenListActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    WillOpenList bean = new Gson().fromJson(data, WillOpenList.class);
                    if (bean.getTotalCounts() != 0) {
                        for (int i = 0; i < bean.getResult().size(); i++) {
                            beanList.add(bean.getResult().get(i));
                        }
                        if (bean.getResult().size() == 0 && beanList.size() == 0) {
                            recyclerView.setVisibility(View.GONE);
                            llNoContent.setVisibility(View.VISIBLE);
                        } else if (bean.getResult().size() == 0 && beanList.size() != 0) {
                            if (recyclerView != null) {
                                recyclerView.complete();
                                recyclerView.onNoMore();
                                baseAdapter.notifyDataSetChanged();
                            }
                        } else if (bean.getResult().size() != 0 && beanList.size() != 0 && bean.getResult().size() < 20) {
                            if (recyclerView != null) {
                                recyclerView.complete();
                                recyclerView.onNoMore();
                                baseAdapter.notifyDataSetChanged();
                            }
                        } else {
                            if (recyclerView != null) {
                                recyclerView.complete();
                                baseAdapter.notifyDataSetChanged();
                            }
                        }
                        baseAdapter.notifyDataSetChanged();
                    } else {
                        if (bean.getResult().size() == 0 && beanList.size() == 0) {
                            recyclerView.setVisibility(View.GONE);
                            llNoContent.setVisibility(View.VISIBLE);
                        } else {
                            recyclerView.setVisibility(View.VISIBLE);
                            llNoContent.setVisibility(View.GONE);
                            recyclerView.complete();
                            recyclerView.onNoMore();
                            baseAdapter.notifyDataSetChanged();
                        }
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
