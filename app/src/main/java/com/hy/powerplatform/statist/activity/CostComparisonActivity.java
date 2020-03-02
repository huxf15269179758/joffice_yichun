package com.hy.powerplatform.statist.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapterPosition;
import com.hy.powerplatform.my_utils.utils.BaseViewHolderPosition;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerYear;
import com.hy.powerplatform.statist.bean.CostComparison;

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

/**
 * 百公里营收成本对比
 */
public class CostComparisonActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.spread_line_chart)
    LineChart spreadLineChart;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.llDate)
    LinearLayout llDate;

    private OkHttpUtil httpUtil;
    public LineData lineData = null;
    BaseRecyclerAdapterPosition mAdapter;
    private CustomDatePickerYear customDatePicker1;
    final HashMap<String, String> map = new HashMap();
    public List<String> xList = new ArrayList<String>();
    public List<Entry> yList = new ArrayList<Entry>();
    public List<Entry> yList1 = new ArrayList<Entry>();
    public List<ILineDataSet> lineDataSets = new ArrayList<ILineDataSet>();
    List<CostComparison> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        spreadLineChart.setDescription(null);
        header.setRightTv(false);
        initDatePicker();
        header.setTvTitle(getResources().getString(R.string.oaflow_statist_rb4));
        httpUtil = OkHttpUtil.getInstance(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        mAdapter = new BaseRecyclerAdapterPosition<CostComparison>(this, R.layout.adapter_loginperson, beanList) {
            @Override
            public void convert(BaseViewHolderPosition holder, final CostComparison itemBean, int position) {
                holder.setText(R.id.tvNum, itemBean.getKsType());
                holder.setText(R.id.tvUserName, itemBean.getSr());
                holder.setText(R.id.tvLoginNum, itemBean.getCb());
                if (position % 2 != 0) {
                    holder.setColor(R.id.ll);
                }
            }
        };
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        getData();

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_person_tong_ji;
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
                lineDataSets.clear();
                xList.clear();
                yList.clear();
                yList1.clear();
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
        final String path_url = Constant.BASE_URL2 + Constant.COSTCOMPARISON;
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

    /**
     * 初始化数据
     * count 表示坐标点个数，range表示等下y值生成的范围
     */
    public LineData getLineData() {
        for (int i = 0; i < beanList.size(); i++) {  //X轴显示的数据
            xList.add("");
        }
        for (int i = 1; i < beanList.size(); i++) {//y轴的数据
            float result = Float.parseFloat(beanList.get(i).getSr());
            float result1 = Float.parseFloat(beanList.get(i).getCb());
            yList.add(new Entry(result, i));
            yList1.add(new Entry(result1, i));
        }
        LineDataSet lineDataSet = new LineDataSet(yList, getResources().getString(R.string.oaflow_statist_rb41));//y轴数据集合
        lineDataSet.setLineWidth(1f);//线宽
        lineDataSet.setCircleSize(Color.BLUE);//圆形颜色
        lineDataSet.setCircleSize(2f);//现实圆形大小
        lineDataSet.setColor(Color.RED);//现实颜色
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setHighLightColor(Color.BLACK);//高度线的颜色

        LineDataSet lineDataSet1 = new LineDataSet(yList1, getResources().getString(R.string.oaflow_statist_rb42));//y轴数据集合
        lineDataSet1.setLineWidth(1f);//线宽
        lineDataSet1.setCircleSize(Color.BLUE);//圆形颜色
        lineDataSet1.setCircleSize(2f);//现实圆形大小
        lineDataSet1.setColor(Color.GREEN);//现实颜色
        lineDataSet1.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet1.setHighLightColor(Color.BLACK);//高度线的颜色
        lineDataSets.add(lineDataSet);
        lineDataSets.add(lineDataSet1);

        lineData = new LineData(xList, lineDataSets);
        lineData.setValueFormatter(new CustomerValueFormatter());
        return lineData;
    }

    /**
     * 设置样式
     */
    public void showChart() {
        spreadLineChart.setDrawBorders(false);//是否添加边框
        spreadLineChart.setDescription("");//数据描述
        spreadLineChart.setNoDataTextDescription("");//没数据显示
        spreadLineChart.setDrawGridBackground(true);//是否显示表格颜色
        spreadLineChart.setBackgroundColor(Color.WHITE);//背景颜色
        spreadLineChart.setData(lineData);//设置数据
        Legend legend = spreadLineChart.getLegend();//设置比例图片标示，就是那一组Y的value
        legend.setForm(Legend.LegendForm.SQUARE);//样式
        legend.setFormSize(10f);//字体
        legend.setTextColor(Color.BLUE);//设置颜色
        spreadLineChart.animateX(2000);//X轴的动画
        //刷新
        spreadLineChart.invalidate();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    String message = msg.getData().getString("error");
                    Toast.makeText(CostComparisonActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    try {
                        JSONArray jsonArray = new JSONArray(data);
                        CostComparison resultBean = new CostComparison();
                        double month = 0;
                        double month1 = 0;
                        resultBean.setKsType("合计");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            month = month+Double.valueOf(jsonObject.getString("sr"));
                            month1 = month1+Double.valueOf(jsonObject.getString("cb"));
                        }
                        DecimalFormat df = new DecimalFormat("#.00");
                        resultBean.setSr(String.valueOf(df.format(month)));
                        resultBean.setCb(String.valueOf(df.format(month1)));
                        beanList.add(resultBean);
                        for (int i = 0;i<jsonArray.length();i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            CostComparison bean = new CostComparison();
                            bean.setCb(jsonObject.getString("cb"));
                            bean.setSr(jsonObject.getString("sr"));
                            bean.setKsType(jsonObject.getString("ksType"));
                            beanList.add(bean);
                        }
                        if (beanList.size() == 0) {
                            recyclerView.setVisibility(View.GONE);
                            llNoContent.setVisibility(View.VISIBLE);
                            ProgressDialogUtil.stopLoad();
                        } else {
                            recyclerView.setVisibility(View.VISIBLE);
                            llNoContent.setVisibility(View.GONE);
                            mAdapter.notifyDataSetChanged();
                            ProgressDialogUtil.stopLoad();
                            getLineData();
                            showChart();
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
            return mFormat.format(value);//数据前或者后可根据自己想要显示的方式添加
        }
    }
}
