package com.hy.powerplatform.oa_flow.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.leon.lfilepickerlibrary.LFilePicker;
import com.leon.lfilepickerlibrary.utils.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

public class FragmentCarSafeData extends Fragment {

    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.etPerson)
    EditText etPerson;
    @BindView(R.id.etDpartment)
    EditText etDpartment;
    @BindView(R.id.etLeader)
    TextView etLeader;
    @BindView(R.id.etLeader1)
    TextView etLeader1;
    @BindView(R.id.etLeader2)
    TextView etLeader2;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.etOutCarNo1)
    EditText etOutCarNo1;
    @BindView(R.id.etOutCarNo2)
    EditText etOutCarNo2;
    @BindView(R.id.etOutCarNo3)
    EditText etOutCarNo3;
    @BindView(R.id.etOutCarNo4)
    EditText etOutCarNo4;
    @BindView(R.id.etOutCarNo5)
    EditText etOutCarNo5;
    @BindView(R.id.etSafeSepart1)
    EditText etSafeSepart1;
    @BindView(R.id.etSafeSepart2)
    EditText etSafeSepart2;
    @BindView(R.id.etSafeSepart3)
    EditText etSafeSepart3;
    @BindView(R.id.etSafeSepart4)
    EditText etSafeSepart4;
    @BindView(R.id.etSafeSepart5)
    EditText etSafeSepart5;
    @BindView(R.id.etSafeType1)
    EditText etSafeType1;
    @BindView(R.id.etSafeType2)
    EditText etSafeType2;
    @BindView(R.id.etSafeType3)
    EditText etSafeType3;
    @BindView(R.id.etSafeType4)
    EditText etSafeType4;
    @BindView(R.id.etSafeType5)
    EditText etSafeType5;
    @BindView(R.id.etSafeMoney1)
    EditText etSafeMoney1;
    @BindView(R.id.etSafeMoney2)
    EditText etSafeMoney2;
    @BindView(R.id.etSafeMoney3)
    EditText etSafeMoney3;
    @BindView(R.id.etSafeMoney5)
    EditText etSafeMoney5;
    @BindView(R.id.etSafeMoney4)
    EditText etSafeMoney4;
    @BindView(R.id.tvData)
    TextView tvData;
    Unbinder unbinder;
    @BindView(R.id.tvAllMoney)
    TextView tvAllMoney;
    @BindView(R.id.tvSafeDate1)
    TextView tvSafeDate1;
    @BindView(R.id.tvSafeDate2)
    TextView tvSafeDate2;
    @BindView(R.id.tvSafeDate3)
    TextView tvSafeDate3;
    @BindView(R.id.tvSafeDate4)
    TextView tvSafeDate4;
    @BindView(R.id.tvSafeDate5)
    TextView tvSafeDate5;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvLeaderW)
    TextView tvLeaderW;
    @BindView(R.id.tvLeader1W)
    TextView tvLeader1W;
    @BindView(R.id.tvLeader2W)
    TextView tvLeader2W;
    private CustomDatePickerDay customDatePicker1;
    String data1, res, liushuihao;
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
    double AllMoney = 0.0, AllMoney1 = 0.0, AllMoney2 = 0.0, AllMoney3 = 0.0, AllMoney4 = 0.0, AllMoney5 = 0.0;
    String tag = "0";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_carsafe_data, container, false);
        unbinder = ButterKnife.bind(this, view);
        initDatePicker();
        userId = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userCode", "");
        userName = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userStatus", "");
        String department = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "depName", "");
        etPerson.setText(userName);
        etDpartment.setText(department);
        etSafeMoney1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    AllMoney1 = (Double.valueOf(s.toString()));
                    tvAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5));
                } else {
                    AllMoney1 = 0.0;
                    tvAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5));
                }
            }
        });
        etSafeMoney2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    AllMoney2 = (Double.valueOf(s.toString()));
                    tvAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5));
                } else {
                    AllMoney2 = 0.0;
                    tvAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5));
                }
            }
        });
        etSafeMoney3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    AllMoney3 = (Double.valueOf(s.toString()));
                    tvAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5));
                } else {
                    AllMoney3 = 0.0;
                    tvAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5));
                }
            }
        });
        etSafeMoney4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    AllMoney4 = (Double.valueOf(s.toString()));
                    tvAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5));
                } else {
                    AllMoney4 = 0.0;
                    tvAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5));
                }
            }
        });
        etSafeMoney5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    AllMoney5 = (Double.valueOf(s.toString()));
                    tvAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5));
                } else {
                    AllMoney5 = 0.0;
                    tvAllMoney.setText(String.valueOf(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5));
                }
            }
        });
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
                data1 = dbA.OAQingJiaMor(url, com.hy.powerplatform.my_utils.base.Constant.CARSAFEDIFID);
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
                res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.CARSAFEDIFID, data);
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
        tvSafeDate1.setText(now.split(" ")[0]);
        customDatePicker1 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                if (tag.equals("1")) {
                    tvSafeDate1.setText(time.split(" ")[0]);
                } else if (tag.equals("2")) {
                    tvSafeDate2.setText(time.split(" ")[0]);
                } else if (tag.equals("3")) {
                    tvSafeDate3.setText(time.split(" ")[0]);
                } else if (tag.equals("4")) {
                    tvSafeDate4.setText(time.split(" ")[0]);
                } else if (tag.equals("5")) {
                    tvSafeDate5.setText(time.split(" ")[0]);
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

    @OnClick({R.id.tvData, R.id.btnUp, R.id.tvSafeDate1, R.id.tvSafeDate2, R.id.tvSafeDate3
            , R.id.tvSafeDate4, R.id.tvSafeDate5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvSafeDate1:
                tag = "1";
                customDatePicker1.show(tvSafeDate1.getText().toString());
                break;
            case R.id.tvSafeDate2:
                tag = "2";
                customDatePicker1.show(tvSafeDate1.getText().toString());
                break;
            case R.id.tvSafeDate3:
                tag = "3";
                customDatePicker1.show(tvSafeDate1.getText().toString());
                break;
            case R.id.tvSafeDate4:
                tag = "4";
                customDatePicker1.show(tvSafeDate1.getText().toString());
                break;
            case R.id.tvSafeDate5:
                tag = "5";
                customDatePicker1.show(tvSafeDate1.getText().toString());
                break;
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
            case R.id.btnUp:
                final String time = tvTime.getText().toString().trim();
                final String person = etPerson.getText().toString().trim();
                final String department = etDpartment.getText().toString().trim();
                final String carNo = etOutCarNo1.getText().toString().trim();
                final String comp = etSafeSepart1.getText().toString().trim();
                final String type = etSafeType1.getText().toString().trim();
                final String money = etSafeMoney1.getText().toString().trim();
                final String date = tvSafeDate1.getText().toString().trim();
                if (time.equals("")) {
                    Toast.makeText(getActivity(), "填单日期不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (person.equals("")) {
                    Toast.makeText(getActivity(), "发起人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (department.equals("")) {
                    Toast.makeText(getActivity(), "部门不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (carNo.equals("")) {
                    Toast.makeText(getActivity(), "车牌号不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (comp.equals("")) {
                    Toast.makeText(getActivity(), "公司不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (type.equals("")) {
                    Toast.makeText(getActivity(), "类型不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (money.equals("")) {
                    Toast.makeText(getActivity(), "金额不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (date.equals("")) {
                    Toast.makeText(getActivity(), "起保日期不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                ProgressDialogUtil.startLoad(getActivity(), "数据上传中");
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
                final String time = tvTime.getText().toString();
                final String person = etPerson.getText().toString();
                final String department = etDpartment.getText().toString();
                final String carNo1 = etOutCarNo1.getText().toString() + "";
                final String carNo2 = etOutCarNo2.getText().toString() + "";
                final String carNo3 = etOutCarNo3.getText().toString() + "";
                final String carNo4 = etOutCarNo4.getText().toString() + "";
                final String carNo5 = etOutCarNo5.getText().toString() + "";

                final String comp1 = etSafeSepart1.getText().toString() + "";
                final String comp2 = etSafeSepart2.getText().toString() + "";
                final String comp3 = etSafeSepart3.getText().toString() + "";
                final String comp4 = etSafeSepart4.getText().toString() + "";
                final String comp5 = etSafeSepart5.getText().toString() + "";

                final String type1 = etSafeType1.getText().toString() + "";
                final String type2 = etSafeType2.getText().toString() + "";
                final String type3 = etSafeType3.getText().toString() + "";
                final String type4 = etSafeType4.getText().toString() + "";
                final String type5 = etSafeType5.getText().toString() + "";

                final String money1 = etSafeMoney1.getText().toString() + "";
                final String money2 = etSafeMoney2.getText().toString() + "";
                final String money3 = etSafeMoney3.getText().toString() + "";
                final String money4 = etSafeMoney4.getText().toString() + "";
                final String money5 = etSafeMoney5.getText().toString() + "";

                final String date1 = tvSafeDate1.getText().toString() + "";
                final String date2 = tvSafeDate2.getText().toString() + "";
                final String date3 = tvSafeDate3.getText().toString() + "";
                final String date4 = tvSafeDate4.getText().toString() + "";
                final String date5 = tvSafeDate5.getText().toString() + "";
                final String myAllMoney = tvAllMoney.getText().toString();

                String res = dbA.OACarSafeUp(turl, userDepart, uId, time, person, department, carNo1,
                        carNo2, carNo3, carNo4, carNo5, comp1, comp2, comp3, comp4, comp5, type1, type2, type3,
                        type4, type5, money1, money2, money3, money4, money5, date1, date2, date3, date4, date5
                        , userId, myAllMoney);
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
                                        res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.CARSAFEDIFID, namelist.get(0));
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
                                                res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.CARSAFEDIFID, data);
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
