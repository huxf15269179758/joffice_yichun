package com.hy.powerplatform.statist.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapterPosition;
import com.hy.powerplatform.my_utils.utils.BaseViewHolderPosition;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerYear;
import com.hy.powerplatform.statist.bean.MileYear;

import java.io.IOException;
import java.text.DecimalFormat;
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

public class MileYearActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.spread_line_chart)
    BarChart mBarChart;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvValue)
    TextView tvValue;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private OkHttpUtil httpUtil;
    BaseRecyclerAdapterPosition mAdapter;
    private CustomDatePickerYear customDatePicker1;
    final HashMap<String, String> map = new HashMap();
    List<MileYear.ResultBean> beanList = new ArrayList<>();
    //数据的集合
    public BarDataSet dataset;
    //保存数据的实体（下面定义了两组数据集合）
    public ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
    //表格下方的文字
    public ArrayList<String> labels = new ArrayList<String>();
    ArrayList<IBarDataSet> dataSets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mBarChart.setDescription(null);
        tvName.setText("月份");
        tvValue.setText("里程(万公里)");
        header.setRightTv(false);
        header.setTvTitle(getResources().getString(R.string.oaflow_statist_rb3));
        initDatePicker();
        httpUtil = OkHttpUtil.getInstance(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        mAdapter = new BaseRecyclerAdapterPosition<MileYear.ResultBean>(this, R.layout.adapter_data_item, beanList) {
            @Override
            public void convert(BaseViewHolderPosition holder, final MileYear.ResultBean itemBean, int position) {
                holder.setText(R.id.tvName, itemBean.getMonthRq());
                holder.setText(R.id.tvData, itemBean.getFactMile());
                if (position % 2 != 0) {
                    holder.setColor(R.id.ll);
                }
            }
        };
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        //设置单个点击事件
        mBarChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                Toast.makeText(MileYearActivity.this, entry.getVal() + "", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
        //设置显示动画效果
        mBarChart.animateY(2000);
        mBarChart.setMaxVisibleValueCount(60);
        getData();

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_tongji_zhu;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy", Locale.CHINA);
        String now = sdf.format(new Date());
        tvDate.setText(now);

        customDatePicker1 = new CustomDatePickerYear(this, new CustomDatePickerYear.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                String date = time.split(" ")[0];
                String date1 = date.split("-")[0];
                tvDate.setText(date1);
                entries.clear();
                labels.clear();
                beanList.clear();
                getData();
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动
        customDatePicker1.showSpecificMonth(false); // 不允许循环滚动
    }

    /**
     * 获取数据
     */
    private void getData() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.YEARMILE;
        map.clear();
        map.put("year", tvDate.getText().toString());
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

    @OnClick(R.id.tvDate)
    public void onViewClicked() {
        customDatePicker1.show(tvDate.getText().toString());
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    String message = msg.getData().getString("error");
                    Toast.makeText(MileYearActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    MileYear bean = new Gson().fromJson(data, MileYear.class);
                    if (bean.getTotalCounts() != 0) {
                        recyclerView.setVisibility(View.VISIBLE);
                        llNoContent.setVisibility(View.GONE);
                        MileYear.ResultBean resultBean = new MileYear.ResultBean();
                        double month = 0.0;
                        resultBean.setMonthRq("合计");
                        for (int i = 0; i < bean.getResult().size(); i++) {
                            if (!bean.getResult().get(i).getFactMile().equals("0.0")){
                                month = month+Double.valueOf(bean.getResult().get(i).getFactMile());
                            }
                        }
                        resultBean.setFactMile(String.valueOf(month));
                        beanList.add(resultBean);
                        for (int i = 0; i < bean.getResult().size(); i++) {
                            beanList.add(bean.getResult().get(i));
                            float value = Float.parseFloat(bean.getResult().get(i).getFactMile());
                            entries.add(new BarEntry(value, i));
                            labels.add(bean.getResult().get(i).getMonthRq());
                            dataset = new BarDataSet(entries, getResources().getString(R.string.oaflow_statist_rb3));
                            dataset.setColors(ColorTemplate.COLORFUL_COLORS);
                            dataSets.add(dataset);
                        }
                        BarData dataNum = new BarData(labels, dataset);
                        dataNum.setValueFormatter(new CustomerValueFormatter());
                        mBarChart.setData(dataNum);
                        //通知BarData更新
                        mBarChart.getBarData().notifyDataChanged();
                        //通知BarChart更新
                        mBarChart.notifyDataSetChanged();
                        //使图表更新生效
                        mBarChart.invalidate();
                    } else {
                        recyclerView.setVisibility(View.GONE);
                        llNoContent.setVisibility(View.VISIBLE);
                    }
                    mAdapter.notifyDataSetChanged();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

    public class CustomerValueFormatter implements ValueFormatter {
        private DecimalFormat mFormat;

        public CustomerValueFormatter() {
            //此处是显示数据的方式，显示整型或者小数后面小数位数自己随意确定
            mFormat = new DecimalFormat("0.00");
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return mFormat.format(value);//数据前或者后可根据自己想要显示的方式添加
        }
    }
}
