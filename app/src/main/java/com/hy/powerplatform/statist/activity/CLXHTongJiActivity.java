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
import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.BaseRecyclerAdapterPosition;
import com.hy.powerplatform.my_utils.utils.BaseViewHolderPosition;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerMonth;
import com.hy.powerplatform.statist.bean.CLXHTongJi;

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

public class CLXHTongJiActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.spread_line_chart)
    BarChart mBarChart;
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
    List<CLXHTongJi> beanList = new ArrayList<>();
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
        header.setRightTv(false);
        tvName.setText("类型");
        tvValue.setText("金额(元)");
        mBarChart.setDescription(null);
        initDatePicker();
        header.setTvTitle(getResources().getString(R.string.oaflow_statist_rb6));
        httpUtil = OkHttpUtil.getInstance(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        mBarChart.getXAxis().setDrawLabels(false);
        //设置单个点击事件
        mBarChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                Toast.makeText(CLXHTongJiActivity.this, entry.getVal() + "", Toast.LENGTH_LONG).show();
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

    /**
     * 获取数据
     */
    private void getData() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.CLXHTJ;
        map.clear();
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM", Locale.CHINA);
        String now = sdf.format(new Date());
        tvDate.setText(now);

        customDatePicker1 = new CustomDatePickerMonth(this, new CustomDatePickerMonth.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                String date = time.split(" ")[0];
                String date1 = date.split("-")[0] + "-" + date.split("-")[1];
                tvDate.setText(date1);
                entries.clear();
                labels.clear();
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
                    Toast.makeText(CLXHTongJiActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    try {
                        JSONArray jsonArray = new JSONArray(data);
                        CLXHTongJi bean1 = new CLXHTongJi();
                        bean1.setTypeName("合计");
                        double month = 0.0;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            month = month+Double.parseDouble(jsonObject.getString("je"));
                        }
                        bean1.setJe(month);
                        beanList.add(bean1);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            CLXHTongJi bean = new CLXHTongJi();
                            bean.setTypeName(jsonObject.getString("typeName"));
                            bean.setJe(Double.parseDouble(jsonObject.getString("je")));
                            beanList.add(bean);

                            float value = Float.parseFloat((jsonObject.getString("je")));
                            entries.add(new BarEntry(value, i));
                            labels.add(jsonObject.getString("typeName"));
                            dataset = new BarDataSet(entries, getResources().getString(R.string.oaflow_statist_rb6));
                            dataset.setColors(ColorTemplate.COLORFUL_COLORS);
                            dataSets.add(dataset);
                        }
                        if (beanList.size() == 0) {
                            recyclerView.setVisibility(View.GONE);
                            llNoContent.setVisibility(View.VISIBLE);
                            ProgressDialogUtil.stopLoad();
                        } else {
                            BarData dataNum = new BarData(labels, dataset);
                            dataNum.setValueFormatter(new CustomerValueFormatter());
                            mBarChart.setData(dataNum);
                            //通知BarData更新
                            mBarChart.getBarData().notifyDataChanged();
                            //通知BarChart更新
                            mBarChart.notifyDataSetChanged();
                            //使图表更新生效
                            mBarChart.invalidate();
                            recyclerView.setVisibility(View.VISIBLE);
                            llNoContent.setVisibility(View.GONE);
                            mAdapter = new BaseRecyclerAdapterPosition<CLXHTongJi>(CLXHTongJiActivity.this, R.layout.adapter_data_item, beanList) {
                                @Override
                                public void convert(BaseViewHolderPosition holder, final CLXHTongJi itemBean, int position) {
                                    holder.setText(R.id.tvName, itemBean.getTypeName());
                                    holder.setText(R.id.tvData, String.valueOf(itemBean.getJe()));
                                    if (position % 2 != 0) {
                                        holder.setColor(R.id.ll);
                                    }
                                }
                            };
                            recyclerView.setAdapter(mAdapter);
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
            mFormat = new DecimalFormat("0.0");
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return mFormat.format(value);//数据前或者后可根据自己想要显示的方式添加
        }
    }
}
