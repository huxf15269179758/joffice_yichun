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
import com.hy.powerplatform.comper.bean.ShengChanYYList;
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

public class ShengChanYYListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;

    int limit = 50;
    int start = 0;
    private OkHttpUtil httpUtil;
    BaseRecyclerAdapter baseAdapter;
    final HashMap<String, String> map = new HashMap();
    List<ShengChanYYList.ResultBean> beanList = new ArrayList<>();
    private CustomDatePickerMonth customDatePicker1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
        header.setRightTv(false);
        httpUtil = OkHttpUtil.getInstance(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        baseAdapter = new BaseRecyclerAdapter<ShengChanYYList.ResultBean>(this, R.layout.adapter_yingyun_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final ShengChanYYList.ResultBean resultBean) {
                holder.setText(R.id.tvTitle, resultBean.getName());
                holder.setText(R.id.tvCar1, resultBean.getBqnum());
                holder.setText(R.id.tvCar2, resultBean.getTqnum());
                holder.setText(R.id.tvCar3, resultBean.getSqnum());
                holder.setText(R.id.tvCar4, resultBean.getTb());
                holder.setText(R.id.tvCar5, resultBean.getHb());
                holder.setText(R.id.tvCar6, resultBean.getYearCount());
            }
        };
        recyclerView.setAdapter(baseAdapter);

        getData(start, limit);
    }

    private void getData(final int start, final int limit) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.SHENGCHANYY + "?start=" + start + "&limit=" + limit;
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
        return R.layout.activity_sheng_chan_yylist;
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
                String date1 = date.split("-")[0]+"-"+date.split("-")[1];
                tvDate.setText(date1);
                beanList.clear();
                limit = 20;
                start = 0;
                getData(start, limit);
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
                    Toast.makeText(ShengChanYYListActivity.this, message, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    ShengChanYYList bean = new Gson().fromJson(data, ShengChanYYList.class);
                    if (bean.getTotalCounts() != 0) {
                        for (int i = 0; i < bean.getResult().size(); i++) {
                            beanList.add(bean.getResult().get(i));
                        }
                        baseAdapter.notifyDataSetChanged();
                        ProgressDialogUtil.stopLoad();
                    }else {
                        recyclerView.setVisibility(View.GONE);
                        llNoContent.setVisibility(View.GONE);
                    }
                    break;
            }
        }
    };
}
