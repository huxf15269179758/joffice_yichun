package com.hy.powerplatform.comper.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.comper.bean.YingYunList;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapter;
import com.hy.powerplatform.my_utils.utils.BaseViewHolder;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerMonth;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class YingYunZBActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    int limit = 50;
    int start = 0;
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapter baseAdapter;
    final HashMap<String, String> map = new HashMap();
    List<YingYunList.ResultBean> beanList = new ArrayList<>();
    private CustomDatePickerMonth customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();

        httpUtil = OkHttpUtil.getInstance(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        baseAdapter = new BaseRecyclerAdapter<YingYunList.ResultBean>(this, R.layout.adapter_zhibiao_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final YingYunList.ResultBean resultBean) {
                holder.setText(R.id.tvTitle, resultBean.getDepName());
                holder.setText(R.id.tv1, resultBean.getDepName());
                holder.setText(R.id.tv2, resultBean.getZlc());
                holder.setText(R.id.tv3, resultBean.getYycz());
                holder.setText(R.id.tv4, resultBean.getXjsr());
                holder.setText(R.id.tv5, resultBean.getIcsr());
                holder.setText(R.id.tv6, resultBean.getFlaxk());
                holder.setText(R.id.tvXH1, resultBean.getRyxh());
                holder.setText(R.id.tvXH2, resultBean.getCngxh());
                holder.setText(R.id.tvXH3, resultBean.getLngxh());
                holder.setText(R.id.tvXH4, resultBean.getCdxh());
                holder.setText(R.id.tvZC1, resultBean.getRy());
                holder.setText(R.id.tvZC2, resultBean.getCng());
                holder.setText(R.id.tvZC3, resultBean.getLng());
                holder.setText(R.id.tvZC4, resultBean.getCd());
                holder.setText(R.id.tvBGLXH1, resultBean.getBglqh());
                holder.setText(R.id.tvBGLXH2, resultBean.getBgldh());
                holder.setText(R.id.tvBGLXH3, resultBean.getBglyh());
                holder.setText(R.id.tvBGLSY1, resultBean.getBglsy());
            }
        };
        recyclerView.setAdapter(baseAdapter);
        baseAdapter.notifyDataSetChanged();
        httpUtil = OkHttpUtil.getInstance(this);
        getData(start, limit);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_yingyun_zb;
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

    private void getData(final int start, final int limit) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.YINGYUNZHIBIAO + "?start=" + start + "&limit=" + limit;
        map.clear();
        map.put("beginMonth", tvStartTime.getText().toString());
        map.put("endMonth", tvEndTime.getText().toString());
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
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM", Locale.CHINA);
        String now = sdf.format(new Date());
        tvStartTime.setText(now);
        tvEndTime.setText(now);

        customDatePicker1 = new CustomDatePickerMonth(this, new CustomDatePickerMonth.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                String date = time.split(" ")[0];
                String date1 = date.split("-")[0] + "-" + date.split("-")[1];
                tvStartTime.setText(date1);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动
        customDatePicker1.showSpecificDay(false);

        customDatePicker2 = new CustomDatePickerMonth(this, new CustomDatePickerMonth.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                String date = time.split(" ")[0];
                String date1 = date.split("-")[0] + "-" + date.split("-")[1];
                tvEndTime.setText(date1);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(false); // 显示时和分
        customDatePicker2.setIsLoop(false); // 允许循环滚动
        customDatePicker2.showSpecificDay(false);
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
                case TAG_ONE:
                    String message = msg.getData().getString("error");
                    Toast.makeText(YingYunZBActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    YingYunList bean = new Gson().fromJson(data, YingYunList.class);
                    if (bean.getTotalCounts() != 0) {
                        recyclerView.setVisibility(View.VISIBLE);
                        llNoContent.setVisibility(View.GONE);
                        for (int i = 0; i < bean.getResult().size(); i++) {
                            beanList.add(bean.getResult().get(i));
                        }
                        baseAdapter.notifyDataSetChanged();
                    } else {
                        recyclerView.setVisibility(View.GONE);
                        llNoContent.setVisibility(View.VISIBLE);
                        baseAdapter.notifyDataSetChanged();
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
