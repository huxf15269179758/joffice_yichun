package com.hy.powerplatform.statist.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapterPosition;
import com.hy.powerplatform.my_utils.utils.BaseViewHolderPosition;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerMonth;
import com.hy.powerplatform.statist.bean.YueDuWGCS;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class YueDuWGCSActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.spread_line_chart)
    PieChart spreadLineChart;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;

    PieDataSet pieDataSet;
    @BindView(R.id.llDate)
    LinearLayout llDate;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvValue)
    TextView tvValue;
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapterPosition mAdapter;
    private CustomDatePickerMonth customDatePicker1;
    final HashMap<String, String> map = new HashMap();
    List<YueDuWGCS> beanList = new ArrayList<>();
    //并内显示文字
    ArrayList<String> xValues = new ArrayList<String>();
    //yVals用来表示封装每个饼块的实际数据
    ArrayList<Entry> yValues = new ArrayList<Entry>();
    //颜色集合
    ArrayList<Integer> colors = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        tvName.setText("类型");
        tvValue.setText("次数（次）");
        spreadLineChart.setDescription(null);
        header.setRightTv(false);
        colors.add(Color.rgb(193, 46, 52));
        colors.add(Color.rgb(75, 0, 130));
        colors.add(Color.rgb(0, 94, 170));
        colors.add(Color.rgb(51, 156, 168));
        colors.add(Color.rgb(205, 168, 25));
        colors.add(Color.rgb(50, 164, 135));
        colors.add(Color.rgb(220, 20, 60));
        colors.add(Color.rgb(0, 128, 0));
        colors.add(Color.rgb(43, 130, 29));
        colors.add(Color.rgb(128, 128, 0));
        colors.add(Color.rgb(255, 215, 0));
        colors.add(Color.rgb(255, 99, 71));
        colors.add(Color.rgb(255, 218, 185));
        colors.add(Color.rgb(230, 182, 0));
        colors.add(Color.rgb(255, 215, 0));
        colors.add(Color.rgb(106, 90, 205));
        header.setTvTitle(getResources().getString(R.string.oaflow_statist_rb10));
        initDatePicker();
        httpUtil = OkHttpUtil.getInstance(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        mAdapter = new BaseRecyclerAdapterPosition<YueDuWGCS>(this, R.layout.adapter_data_item, beanList) {
            @Override
            public void convert(BaseViewHolderPosition holder, final YueDuWGCS itemBean, int position) {
                holder.setText(R.id.tvName, itemBean.getIrregularities());
                holder.setText(R.id.tvData, itemBean.getSl());
                if (position % 2 != 0) {
                    holder.setColor(R.id.ll);
                }
            }
        };
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        getData();
    }

    /**
     * 获取数据
     */
    private void getData() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.YUEDUWGCS;
        map.clear();
        map.put("ksType", tvDate.getText().toString().split("-")[0] + tvDate.getText().toString().split("-")[1]);
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

    private void showChart(PieChart pieChart, PieData pieData) {
//        pieChart.setHoleColorTransparent(true);
        pieChart.setHoleRadius(56f);  //半径
        pieChart.setTransparentCircleRadius(60f); // 半透明圈
        //pieChart.setHoleRadius(0)  //实心圆
//        pieChart.setDescription("测试饼状图");
        // mChart.setDrawYValues(true);
        pieChart.setDrawCenterText(true);  //饼状图中间可以添加文字
        pieChart.setDrawHoleEnabled(true);
        pieChart.setRotationAngle(90); // 初始旋转角度
        // draws the corresponding description value into the slice
        // mChart.setDrawXValues(true);
        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true); // 可以手动旋转
        // display percentage values
        pieChart.setUsePercentValues(true);  //显示成百分比
        pieChart.setDrawSliceText(false);
        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
//      mChart.setOnChartValueSelectedListener(this);
        // mChart.setTouchEnabled(false);

//      mChart.setOnAnimationListener(this);
        //饼状图中间的文字
        pieChart.setCenterText(getResources().getString(R.string.oaflow_statist_rb10));
        //设置数据
        pieChart.setData(pieData);
        // undo all highlights
//      pieChart.highlightValues(null);
//      pieChart.invalidate();
        Legend mLegend = pieChart.getLegend();  //设置比例图
        //色卡显示位置
        mLegend.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
//      mLegend.setForm(LegendForm.LINE);  //设置比例图的形状，默认是方形
        mLegend.setWordWrapEnabled(true);
        mLegend.setXEntrySpace(7f);
        mLegend.setYEntrySpace(5f);

        pieChart.animateXY(1000, 1000);  //设置动画
        // mChart.spin(2000, 0, 360);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_tongji_bing;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM", Locale.CHINA);
        String now = sdf.format(new Date());
        tvDate.setText(now);

        customDatePicker1 = new CustomDatePickerMonth(this, new CustomDatePickerMonth.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                String date = time.split(" ")[0];
                String date1 = date.split("-")[0] + "-" + date.split("-")[1];
                tvDate.setText(date1);
                xValues.clear();
                yValues.clear();
                beanList.clear();
                getData();
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动
        customDatePicker1.showSpecificDay(false); // 不允许循环滚动
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
                    Toast.makeText(YueDuWGCSActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    try {
                        JSONArray jsonArray = new JSONArray(data);
                        YueDuWGCS resultBean = new YueDuWGCS();
                        float month = 0;
                        resultBean.setIrregularities("合计");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            month = month+Float.valueOf(jsonObject.getString("sl"));
                        }
                        resultBean.setSl(String.valueOf(month));
                        beanList.add(resultBean);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            YueDuWGCS bean = new YueDuWGCS();
                            bean.setIrregularities(jsonObject.getString("irregularities"));
                            bean.setSl(jsonObject.getString("sl"));
                            beanList.add(bean);
                            xValues.add(jsonObject.getString("irregularities"));
                            yValues.add(new Entry(Float.valueOf(jsonObject.getString("sl")), i));
                        }
                        //y轴的集合
                        pieDataSet = new PieDataSet(yValues, ""/*显示在比例图上*/);
                        //设置个饼状图之间的距离
                        pieDataSet.setSliceSpace(0f);
                        pieDataSet.setColors(colors);
                        pieDataSet.setSliceSpace(0f);
                        pieDataSet.setSelectionShift(5f);
                        pieDataSet.setSelectionShift(15f);
                        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
                        pieDataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
                        DisplayMetrics metrics = getResources().getDisplayMetrics();
                        float px = 5 * (metrics.densityDpi / 160f);
                        pieDataSet.setSelectionShift(px); // 选中态多出的长度
                        PieData pieData = new PieData(xValues, pieDataSet);
                        pieData.setValueFormatter(new CustomerValueFormatter());
                        pieData.setValueFormatter(new PercentFormatter());//是否显示百分号
                        showChart(spreadLineChart, pieData);
                        if (beanList.size() == 0) {
                            recyclerView.setVisibility(View.GONE);
                            llNoContent.setVisibility(View.VISIBLE);
                            ProgressDialogUtil.stopLoad();
                        } else {
                            recyclerView.setVisibility(View.VISIBLE);
                            llNoContent.setVisibility(View.GONE);
                            mAdapter.notifyDataSetChanged();
                            ProgressDialogUtil.stopLoad();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
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
            return mFormat.format(value+"%");//数据前或者后可根据自己想要显示的方式添加
        }
    }
}
