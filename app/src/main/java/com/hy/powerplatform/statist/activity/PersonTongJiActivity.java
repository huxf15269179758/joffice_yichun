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
import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapterPosition;
import com.hy.powerplatform.my_utils.utils.BaseViewHolderPosition;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerMonth;
import com.hy.powerplatform.statist.bean.Department;
import com.hy.powerplatform.statist.bean.PersonTongJi;

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

public class PersonTongJiActivity extends BaseActivity {

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
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvValue)
    TextView tvValue;

    private OkHttpUtil httpUtil;
    BaseRecyclerAdapterPosition mAdapter;
    private CustomDatePickerMonth customDatePicker1;
    final HashMap<String, String> map = new HashMap();
    List<Department.DataBean.ChildrenBeanX.ChildrenBean> departmentList = new ArrayList<>();
    List<String> departNameList = new ArrayList<>();
    List<PersonTongJi.ResultBean> beanList = new ArrayList<>();

    PieDataSet pieDataSet;
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
        spreadLineChart.setDescription(null);
        header.setRightTv(false);
        header.setTvTitle(getResources().getString(R.string.oaflow_statist_rb1));
        tvName.setText("岗位");
        tvValue.setText("人数(人)");
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
        initDatePicker();
        httpUtil = OkHttpUtil.getInstance(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        mAdapter = new BaseRecyclerAdapterPosition<PersonTongJi.ResultBean>(this, R.layout.adapter_data_item, beanList) {
            @Override
            public void convert(BaseViewHolderPosition holder, final PersonTongJi.ResultBean itemBean, int position) {
                holder.setText(R.id.tvName, itemBean.getPosition());
                holder.setText(R.id.tvData, itemBean.getTotal());
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
        final String path_url = Constant.BASE_URL2 + Constant.PERSONTJ;
        map.clear();
        map.put("type", "1");
        map.put("month", tvDate.getText().toString());
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

    /**
     * 设置样式
     */
    private void showChart(PieChart pieChart, PieData pieData) {
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
        pieChart.setDrawSliceText(false);//设置隐藏饼图上文字，只显示百分比
        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
//      mChart.setOnChartValueSelectedListener(this);
        // mChart.setTouchEnabled(false);

//      mChart.setOnAnimationListener(this);
        //饼状图中间的文字
        pieChart.setCenterText(getResources().getString(R.string.oaflow_statist_rb1));
        //设置数据
        pieChart.setData(pieData);
        // undo all highlights
//      pieChart.highlightValues(null);
//      pieChart.invalidate();
        Legend mLegend = pieChart.getLegend();  //设置比例图
        //色卡显示位置
        mLegend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
//      mLegend.setForm(LegendForm.LINE);  //设置比例图的形状，默认是方形
        mLegend.setWordWrapEnabled(true);
        mLegend.setXEntrySpace(7f);
        mLegend.setYEntrySpace(5f);

        pieChart.animateXY(1000, 1000);  //设置动画
        // mChart.spin(2000, 0, 360);
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
                    Toast.makeText(PersonTongJiActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    PersonTongJi bean = new Gson().fromJson(data, PersonTongJi.class);
                    if (bean.getTotalCounts() != 0) {
                        recyclerView.setVisibility(View.VISIBLE);
                        llNoContent.setVisibility(View.GONE);
                        PersonTongJi.ResultBean resultBean = new PersonTongJi.ResultBean();
                        double month = 0;
                        resultBean.setPosition("合计");
                        for (int i = 0; i < bean.getResult().size(); i++) {
                            month = month + Double.valueOf(bean.getResult().get(i).getTotal());
                        }
                        month = (double) Math.round(month * 100) / 100;
                        resultBean.setTotal(String.valueOf(month));
                        beanList.add(resultBean);
                        for (int i = 0; i < bean.getResult().size(); i++) {
                            beanList.add(bean.getResult().get(i));
                            if (bean.getResult().get(i).getPosition().equals("广告/出租/乐途/春城通")) {
                                xValues.add("广告");
                            } else if (bean.getResult().get(i).getPosition().equals("营运分公司及修理厂工作人员")) {
                                xValues.add("工作人员");
                            } else {
                                xValues.add(bean.getResult().get(i).getPosition());
                            }
                            yValues.add(new Entry(Float.valueOf(bean.getResult().get(i).getTotal()), i));
                        }
                        //y轴的集合
                        pieDataSet = new PieDataSet(yValues, ""/*显示在比例图上*/);
                        //设置个饼状图之间的距离
                        pieDataSet.setSliceSpace(0f);
                        pieDataSet.setColors(colors);
                        pieDataSet.setSliceSpace(0f);
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
            return mFormat.format(value + "%");//数据前或者后可根据自己想要显示的方式添加
        }
    }
}
