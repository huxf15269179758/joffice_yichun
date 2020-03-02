package com.hy.powerplatform.business_inspect.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.adapter.ShiGuHisAdapter;
import com.hy.powerplatform.business_inspect.bean.ShiGuHis;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dell on 2018/6/15.
 */

public class YeWuHisFragment extends Fragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.llHeard)
    LinearLayout llHeard;
    @BindView(R.id.imageView)
    LinearLayout imageView;

    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    List<ShiGuHis> hisList = new ArrayList<>();
    ShiGuHisAdapter adapter;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_signhis, container, false);
        ButterKnife.bind(this, view);
        initDatePicker();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        //adapter = new ShiGuHisAdapter(getActivity(),hisList);
        recyclerView.setAdapter(adapter);
        return view;
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
        //etSTime.setText(day);
        System.out.println("过去七天：" + day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        tv.setText(now.split(" ")[0]);

//        customDatePicker1 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
//            @Override
//            public void handle(String time) { // 回调接口，获得选中的时间
//                etSTime.setText(time.split(" ")[0]);
//            }
//        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
//        customDatePicker1.showSpecificTime(false); // 不显示时和分
//        customDatePicker1.setIsLoop(false); // 不允许循环滚动
//
//        customDatePicker2 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
//            @Override
//            public void handle(String time) { // 回调接口，获得选中的时间
//                etETime.setText(time);
//            }
//        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
//        customDatePicker2.showSpecificTime(false); // 显示时和分
//        customDatePicker2.setIsLoop(false); // 允许循环滚动
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

//    @OnClick({R.id.imSTimeSelect, R.id.imETimeSelect, R.id.btnChart})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.imSTimeSelect:
//                customDatePicker1.show(tv.getText().toString());
//                break;
//            case R.id.imETimeSelect:
//                customDatePicker1.show(tv.getText().toString());
//                break;
//            case R.id.btnChart:
//                break;
//        }
//    }
}

