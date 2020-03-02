package com.hy.powerplatform.business_inspect.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.adapter.YeWuHisAdapter;
import com.hy.powerplatform.business_inspect.bean.YeWuList;
import com.hy.powerplatform.business_inspect.presenter.YeWuListPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.YeWuListPresenterimpl;
import com.hy.powerplatform.business_inspect.view.YeWuListView;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InspectYeWuListActivity extends BaseActivity implements YeWuListView {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.ivCheck)
    ImageView ivCheck;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.imageView)
    LinearLayout imageView;
    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    YeWuListPresenter yeWuListPresenter;
    List<YeWuList.ResultBean> hisList = new ArrayList<>();
    YeWuHisAdapter adapter;
    String userCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        yeWuListPresenter = new YeWuListPresenterimpl(this, this);
        SharedPreferencesHelper helper = new SharedPreferencesHelper(this, "login");
        userCode = helper.getData(this, "userName", "");
        initDatePicker();
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, -7);
        Date d = c.getTime();
        String day = format.format(d);
        tvStartTime.setText(day);
        System.out.println("过去七天：" + day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        tvEndTime.setText(now.split(" ")[0]);
        sendHttpContent();

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvStartTime.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvEndTime.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(false); // 显示时和分
        customDatePicker2.setIsLoop(false); // 允许循环滚动
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_sign_his;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.tvStartTime, R.id.tvEndTime, R.id.ivCheck})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvStartTime:
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.tvEndTime:
                customDatePicker2.show(tvEndTime.getText().toString());
                break;
            case R.id.ivCheck:
                sendHttpContent();
                break;
        }
    }

    private void sendHttpContent() {
        hisList = new ArrayList<>();
        Date startTime = null, endTime = null;
        if (tvStartTime.getText().toString().isEmpty() || tvStartTime.getText().toString().isEmpty()) {
            Toast.makeText(this, "起止时间不能为空", Toast.LENGTH_SHORT).show();
        } else {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                startTime = sdf1.parse(tvStartTime.getText().toString());
                endTime = sdf1.parse(tvEndTime.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (startTime.getTime() > endTime.getTime()) {
            Toast.makeText(this, "请选择正确时间", Toast.LENGTH_SHORT).show();
        } else {
            yeWuListPresenter.getYeWuListPresenterData(tvStartTime.getText().toString(),
                    tvEndTime.getText().toString(),
                    userCode);
        }
    }

    @Override
    public void getYeWuListViewData(YeWuList yeWuList) {
        for (int i = 0; i < yeWuList.getResult().size(); i++) {
            hisList.add(yeWuList.getResult().get(i));
        }
        if (hisList.size() == 0) {
            imageView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            adapter = new YeWuHisAdapter(this, hisList);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            recyclerView.setVisibility(View.VISIBLE);
            ProgressDialogUtil.stopLoad();
        }
    }
}
