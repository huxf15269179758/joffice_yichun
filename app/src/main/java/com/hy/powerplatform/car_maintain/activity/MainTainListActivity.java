package com.hy.powerplatform.car_maintain.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.car_maintain.adapter.MainTainListAdapter;
import com.hy.powerplatform.car_maintain.bean.MainTainList;
import com.hy.powerplatform.car_maintain.presenter.MainTainListPresenter;
import com.hy.powerplatform.car_maintain.presenter.presenterimpl.MainTainListPresenterImpl;
import com.hy.powerplatform.car_maintain.view.MainTainListView;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainTainListActivity extends BaseActivity implements MainTainListView {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.tvType)
    TextView tvType;
    @BindView(R.id.ivFound)
    ImageView ivFound;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Intent intent;
    @BindView(R.id.linearLayout1)
    LinearLayout linearLayout1;
    @BindView(R.id.linearLayout2)
    LinearLayout linearLayout2;
    String Q_busCode_S_EQ = "";

    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    MainTainListPresenter presenter;
    List<MainTainList.ResultBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
        presenter = new MainTainListPresenterImpl(this, this);
        if (tvType.getText().equals("全部")){
            presenter.getMainTainListPresenter(tvStartTime.getText().toString(), tvEndTime.getText().toString(),Q_busCode_S_EQ);
        }else {
            presenter.getMainTainListPresenter(tvStartTime.getText().toString(), tvEndTime.getText().toString(),tvType.getText().toString());
        }
        LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main_tain_list2;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        Intent intent = new Intent(this, AddMainTainActivity1.class);
        startActivity(intent);
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        //过去一月
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        tvStartTime.setText(mon.split(" ")[0]);
        tvEndTime.setText(now.split(" ")[0]);

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
        customDatePicker2.showSpecificTime(false); // 不显示时和分
        customDatePicker2.setIsLoop(false); // 不允许循环滚动
    }

    @OnClick({R.id.tvStartTime, R.id.tvEndTime, R.id.tvType, R.id.ivFound})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvStartTime:
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.tvEndTime:
                customDatePicker2.show(tvEndTime.getText().toString());
                break;
            case R.id.tvType:
                intent = new Intent(this, ZiBianHaoActivity.class);
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.ivFound:
                beanList.clear();
                if (tvType.getText().equals("全部")){
                    presenter.getMainTainListPresenter(tvStartTime.getText().toString(), tvEndTime.getText().toString(),Q_busCode_S_EQ);
                }else {
                    presenter.getMainTainListPresenter(tvStartTime.getText().toString(), tvEndTime.getText().toString(),tvType.getText().toString());
                }
                break;
        }
    }

    //数据回调
    @Override
    public void getMainTainListView(MainTainList mainTainList) {
        for (int i = 0; i < mainTainList.getResult().size(); i++) {
            beanList.add(mainTainList.getResult().get(i));
        }
        if (beanList.size() ==0){
            linearLayout1.setVisibility(View.GONE);
            linearLayout2.setVisibility(View.VISIBLE);
        }else {
            linearLayout1.setVisibility(View.VISIBLE);
            linearLayout2.setVisibility(View.GONE);
        }
        MainTainListAdapter adapter = new MainTainListAdapter(MainTainListActivity.this, beanList);
        recyclerView.setAdapter(adapter);
    }

    //数据回调
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constant.TAG_TWO:
                if (requestCode == Constant.TAG_TWO){
                    if (data!=null){
                        String ZiBianHao = data.getStringExtra("ziBianHao");
                        tvType.setText(ZiBianHao);
                    }
                }
                break;
        }
    }
}
