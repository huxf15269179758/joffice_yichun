package com.hy.powerplatform.signin.fragment;

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
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.signin.adapter.SignHisAdapter;
import com.hy.powerplatform.signin.bean.SignHis;
import com.hy.powerplatform.signin.presenter.SignInHisPresenter;
import com.hy.powerplatform.signin.presenter.signinpresenterimpl.SignInHisPresenterimpl;
import com.hy.powerplatform.signin.view.SignInHisView;

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

public class SignHisFragment extends Fragment implements SignInHisView{
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.llHeard)
    LinearLayout llHeard;
    @BindView(R.id.imageView)
    LinearLayout imageView;

    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    SignInHisPresenter signInHisPresenter;
    List<SignHis.ResultBean> hisList = new ArrayList<>();
    SignHisAdapter adapter;
    String userCode;
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
        signInHisPresenter = new SignInHisPresenterimpl(this,getActivity());
        SharedPreferencesHelper helper = new SharedPreferencesHelper(getActivity(),"login");
        userCode = helper.getData(getActivity(), "userName", "");
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
//                etETime.setText(time.split(" ")[0]);
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
//                customDatePicker2.show(tv.getText().toString());
//                break;
//            case R.id.btnChart:
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//                Date startTime = null, endTime = null;
//                try {
//                    startTime = sdf.parse(etSTime.getText().toString());
//                    endTime = sdf.parse(etETime.getText().toString());
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                if (etSTime.getText().toString().isEmpty() || etETime.getText().toString().isEmpty()) {
//                    Toast.makeText(getActivity(), "起止时间不能为空", Toast.LENGTH_SHORT).show();
//                } else if (startTime.getTime() > endTime.getTime()) {
//                    Toast.makeText(getActivity(), "请选择正确时间", Toast.LENGTH_SHORT).show();
//                } else {
////                    hisPresenter.getHisPresenterData(etSTime.getText().toString(), etETime.getText().toString(), userCode);
////                    recyclerView.setVisibility(View.VISIBLE);
////                    llHeard.setVisibility(View.GONE)
//                    signInHisPresenter.getSignInHisPresenterData(etSTime.getText().toString(),
//                                    etETime.getText().toString(),
//                                    userCode);
//                }
//                break;
//        }
//    }

    @Override
    public void getSignInHisData(SignHis signHis) {
        for (int i = 0;i<signHis.getResult().size();i++){
            hisList.add(signHis.getResult().get(i));
        }
        if (hisList.size() == 0){
            imageView.setVisibility(View.VISIBLE);
            llHeard.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
        }else {
            adapter = new SignHisAdapter(getActivity(),hisList);
            recyclerView.setAdapter(adapter);
            llHeard.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            ProgressDialogUtil.stopLoad();
        }
    }
}

