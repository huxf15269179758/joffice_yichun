package com.hy.powerplatform.oa_flow.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.oa_flow.activity.PersonListActivity;
import com.hy.powerplatform.oa_flow.bean.Name;
import com.hy.powerplatform.oa_flow.util.CompareDiff;
import com.leon.lfilepickerlibrary.LFilePicker;
import com.leon.lfilepickerlibrary.utils.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class FragmentChuCaiData extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.etPerson)
    EditText etPerson;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.etAllTime)
    TextView etAllTime;
    @BindView(R.id.etAddress1)
    EditText etAddress1;
    @BindView(R.id.etAddress2)
    EditText etAddress2;
    @BindView(R.id.etAddress3)
    EditText etAddress3;
    @BindView(R.id.spinnerCar)
    Spinner spinnerCar;
    @BindView(R.id.etReason)
    EditText etReason;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.etYJMoney)
    EditText etYJMoney;
    @BindView(R.id.etZJMoney)
    EditText etZJMoney;
    @BindView(R.id.etLeader)
    TextView etLeader;
    @BindView(R.id.etLeader1)
    TextView etLeader1;
    @BindView(R.id.etLeader2)
    TextView etLeader2;
    @BindView(R.id.btnUp)
    Button btnUp;
    List<String> dataList = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @BindView(R.id.etDepartment)
    TextView etDepartment;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tvLeaderW)
    TextView tvLeaderW;
    @BindView(R.id.tvLeader1W)
    TextView tvLeader1W;
    @BindView(R.id.tvLeader2W)
    TextView tvLeader2W;
    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    String data1, res;
    String LiuShuiCode;
    List<String> namelist = new ArrayList<>();
    List<Name.DataBean> datalist = new ArrayList<>();
    List<Name.DataBean> backlist = new ArrayList<>();

    String userId = "";
    String role = "";
    String userCode = "";
    String userName = "";
    String[] nametemp = null;
    String[] codetemp = null;
    List<String> codeList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    List<String> namelist1 = new ArrayList<>();
    String userDepart = "";
    String isShow = "true";
    int daynumber;
    String tag = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chucai_data, container, false);
        unbinder = ButterKnife.bind(this, view);
        initDatePicker();
        dataList.add("火车");
        dataList.add("飞机");
        dataList.add("驾车");
        dataList.add("其他");

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, dataList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCar.setAdapter(adapter);

        userId = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userCode", "");
        userName = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userStatus", "");
        String department = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "depName", "");
        etDepartment.setText(department);
        etPerson.setText(userName);
        tvLeaderW.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader1W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader2W.setTextColor(getResources().getColor(R.color.order_stop_black));
        return view;
    }

    /**
     * 获取第一审批人
     */
    private void getSenPiPersonOne() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + "flow/startTransProcessActivity.do";
                DBHandler dbA = new DBHandler();
                data1 = dbA.OAQingJiaMor(url, com.hy.powerplatform.my_utils.base.Constant.CHUCAIDIFID);
                if (data1.equals("保存失败") || data1.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_ONE);
                }
            }
        }).start();
    }

    /**
     * 获取第二审批人
     */
    private void getSenPiPersonTwo(final String data) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + "flow/mobileUsersProcessActivity.do";
                DBHandler dbA = new DBHandler();
                res = dbA.OAQingJiaMorNext(url, "10093", data);
                if (res.equals("保存失败") || res.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_FOUR);
                }
            }
        }).start();
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvTime.setText(now.split(" ")[0]);
        tvStartTime.setText(now.split(" ")[0]);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1); //向前走一天
        tvEndTime.setText(sdf.format(calendar.getTime()).split(" ")[0]);
        etAllTime.setText("2");

        customDatePicker1 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date dt1;
                Date dt2;
                if (tag.equals("st")) {
                    try {
                        dt1 = df.parse(time.split(" ")[0]);
                        dt2 = df.parse(tvEndTime.getText().toString());
                        if (dt1.getTime() > dt2.getTime()) {
                            Toast.makeText(getActivity(), "请选择正确的时间", Toast.LENGTH_SHORT).show();
                        } else if (dt1.getTime() <= dt2.getTime()) {
                            tvStartTime.setText(time.split(" ")[0]);
                            daynumber = (int) new CompareDiff().dateDiff1(tvStartTime.getText().toString()
                                    , tvEndTime.getText().toString(), "yyyy-MM-dd");
                            etAllTime.setText(daynumber + 1 + "");
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else if (tag.equals("ed")) {
                    try {
                        dt1 = df.parse(tvStartTime.getText().toString());
                        dt2 = df.parse(time.split(" ")[0]);
                        if (dt1.getTime() > dt2.getTime()) {
                            Toast.makeText(getActivity(), "请选择正确的时间", Toast.LENGTH_SHORT).show();
                        } else if (dt1.getTime() <= dt2.getTime()) {
                            tvEndTime.setText(time.split(" ")[0]);
                            daynumber = (int) new CompareDiff().dateDiff1(tvStartTime.getText().toString()
                                    , tvEndTime.getText().toString(), "yyyy-MM-dd");
                            etAllTime.setText(daynumber + 1 + "");
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                }
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker1.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker1.setIsLoop(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tvData, R.id.tvStartTime, R.id.tvEndTime, R.id.btnUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvData:
//                if (ContextCompat.checkSelfPermission(getActivity(),
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(getActivity(),
//                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
//                } else {
//                    new LFilePicker().withSupportFragment(this)
//                            .withRequestCode(1)
//                            .withIconStyle(Constant.ICON_STYLE_BLUE)
//                            .withTitle("Open From Fragment")
//                            .start();
//                }
                break;
            case R.id.tvStartTime:
                tag = "st";
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.tvEndTime:
                tag = "ed";
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.btnUp:
                final String date = tvTime.getText().toString().trim();
                final String person = etPerson.getText().toString().trim();
                final String startTime = tvStartTime.getText().toString().trim();
                final String endTime = tvEndTime.getText().toString().trim();
                final String days = etAllTime.getText().toString().trim();
                final String address1 = etAddress1.getText().toString().trim();
                final String address2 = etAddress2.getText().toString().trim();
                final String address3 = etAddress3.getText().toString().trim();
                final String carType = String.valueOf(spinnerCar.getSelectedItem());
                final String reason = etReason.getText().toString().trim();
                final String yjMoney = etYJMoney.getText().toString().trim();
                final String zjMoney = etZJMoney.getText().toString().trim();

                if (person.equals("")) {
                    Toast.makeText(getActivity(), "出差人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (days.equals("")) {
                    Toast.makeText(getActivity(), "出差天数不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (address1.equals("") || address3.equals("")) {
                    Toast.makeText(getActivity(), "地点不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (carType.equals("")) {
                    Toast.makeText(getActivity(), "交通工具不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (reason.equals("")) {
                    Toast.makeText(getActivity(), "出差事由不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (yjMoney.equals("")) {
                    Toast.makeText(getActivity(), "预计费用不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (zjMoney.equals("")) {
                    Toast.makeText(getActivity(), "暂借费用不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                ProgressDialogUtil.startLoad(getActivity(), "上传数据中");
                getSenPiPersonOne();
                break;
        }
    }

    /**
     * 提交数据
     */
    private void UpContractData() {
        ProgressDialogUtil.startLoad(getActivity(), "提交数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String turl = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + com.hy.powerplatform.my_utils.base.Constant.UPDATAU;
                DBHandler dbA = new DBHandler();
                String uName = "";
                String uId = "";
                if (selectList.size() == 1) {
                    //uName = backlist.get(0).getActivityName();
                    uId = selectList.get(0);
                }
                if (selectList.size() > 1) {
                    for (int i = 1; i < selectList.size(); i++) {
                        if (i < selectList.size() - 1) {
                            uId = uId + selectList.get(i) + ",";
                        } else {
                            uId = uId + selectList.get(i);
                        }
                    }
                    uId = selectList.get(0) + "," + uId;
                }
                final String date = tvTime.getText().toString();
                final String person = etPerson.getText().toString();
                final String startTime = tvStartTime.getText().toString();
                final String endTime = tvEndTime.getText().toString();
                final String days = etAllTime.getText().toString();
                final String address1 = etAddress1.getText().toString();
                final String address2 = etAddress2.getText().toString();
                final String address3 = etAddress3.getText().toString();
                final String carType = String.valueOf(spinnerCar.getSelectedItem());
                final String reason = etReason.getText().toString();
                final String yjMoney = etYJMoney.getText().toString();
                final String zjMoney = etZJMoney.getText().toString();
                String department = etDepartment.getText().toString();
                String jtgj1 = "", jtgj2 = "", jtgj3 = "", jtgj4 = "";
                if (carType.equals("火车")) {
                    jtgj1 = "on";
                }
                if (carType.equals("飞机")) {
                    jtgj2 = "on";
                }
                if (carType.equals("驾车")) {
                    jtgj3 = "on";
                }
                if (carType.equals("其他")) {
                    jtgj4 = "on";
                }
                String res = dbA.OAChuCaiup(turl, userDepart, uId, date, person, startTime, endTime,
                        days, address1, address2, address3, carType, reason, yjMoney, zjMoney,
                        userId, userName, jtgj1, jtgj2, jtgj3, jtgj4, department);
                if (res.equals("")) {
                    handler.sendEmptyMessage(TAG_THERE);
                } else {
                    handler.sendEmptyMessage(TAG_TWO);
                }
            }
        }).start();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    new LFilePicker().withSupportFragment(this)
                            .withRequestCode(1)
                            .withIconStyle(Constant.ICON_STYLE_BLUE)
                            .withTitle("Open From Fragment")
                            .start();
                } else {
                    Toast.makeText(getActivity(), "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    try {
                        JSONObject jsonObject = new JSONObject(data1);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        namelist.clear();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObjectName = jsonArray.getJSONObject(i);
                            String name = jsonObjectName.getString("destination");
                            namelist.add(name);
                        }
                        if (namelist.size() != 0) {
                            if (namelist.size() == 1) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + com.hy.powerplatform.my_utils.base.Constant.NOENDPERSON;
                                        DBHandler dbA = new DBHandler();
                                        res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.CHUCAIDIFID, namelist.get(0));
                                        userDepart = namelist.get(0);
                                        if (res.equals("保存失败") || res.equals("")) {
                                            handler.sendEmptyMessage(TAG_TWO);
                                        } else {
                                            handler.sendEmptyMessage(TAG_FOUR);
                                        }
                                    }
                                }).start();
                            } else {
                                MyAlertDialog.MyListAlertDialog(getActivity(), namelist, new AlertDialogCallBackP() {
                                    @Override
                                    public void oneselect(final String data) {
                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + com.hy.powerplatform.my_utils.base.Constant.NOENDPERSON;
                                                DBHandler dbA = new DBHandler();
                                                userDepart = data;
                                                res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.CHUCAIDIFID, data);
                                                if (res.equals("保存失败") || res.equals("")) {
                                                    handler.sendEmptyMessage(TAG_TWO);
                                                } else {
                                                    handler.sendEmptyMessage(TAG_FOUR);
                                                }
                                            }
                                        }).start();

                                    }

                                    @Override
                                    public void select(List<String> list) {

                                    }

                                    @Override
                                    public void confirm() {

                                    }

                                    @Override
                                    public void cancel() {

                                    }
                                });
                            }
                        } else {
                            Toast.makeText(getActivity(), "审批人为空", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                case TAG_TWO:
                    Toast.makeText(getActivity(), "操作失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_THERE:
                    Toast.makeText(getActivity(), "提交成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    getActivity().finish();
                    break;
                case TAG_FOUR:
                    ProgressDialogUtil.stopLoad();
                    try {
                        JSONObject jsonObject = new JSONObject(res);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        datalist.clear();
                        nameList.clear();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            Name.DataBean name = new Name.DataBean();
                            JSONObject jsonObjectName = jsonArray.getJSONObject(i);
                            name.setActivityName(jsonObjectName.getString("userNames"));
                            name.setUName(jsonObjectName.getString("userCodes"));
                            datalist.add(name);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (datalist.size() == 1) {
                        Name.DataBean bean1 = datalist.get(0);
                        userCode = bean1.getActivityName();
                        userName = bean1.getUName();
                        nametemp = userName.split(",");
                        codetemp = userCode.split(",");
                        if (codetemp != null) {
                            for (String s : codetemp) {
                                codeList.add(s);
                            }
                        }
                        if (nametemp != null) {
                            for (String s : nametemp) {
                                nameList.add(s);
                            }
                        }
                        if (codeList.size() == 1) {
                            selectList.add(codeList.get(0));
                            UpContractData();
                        } else {
                            MyAlertDialog.MyListAlertDialog(isShow, codeList, nameList, namelist1, getActivity(), new AlertDialogCallBackP() {

                                @Override
                                public void select(List<String> data) {
                                    selectList = data;
                                    UpContractData();
                                }

                                @Override
                                public void oneselect(String s) {

                                }

                                @Override
                                public void confirm() {

                                }

                                @Override
                                public void cancel() {

                                }
                            });
                        }
                    }
                    //获取流水号
                    break;
            }
        }
    };

    @OnClick(R.id.tvPerson)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), PersonListActivity.class);
        startActivityForResult(intent, com.hy.powerplatform.my_utils.base.Constant.TAG_TWO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            List<String> list = data.getStringArrayListExtra("paths");
            for (String s : list) {
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
                File file = new File(s);
                Toast.makeText(getActivity(), file.getName(), Toast.LENGTH_SHORT).show();
//                    file = file+s;
            }
        }
        if (requestCode == com.hy.powerplatform.my_utils.base.Constant.TAG_TWO) {
            if (data != null) {
                userCode = data.getStringExtra("userCode");
                userName = data.getStringExtra("userName");
                etPerson.setText(userName);
            }
        }
    }
}
