package com.hy.powerplatform.oa_flow.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputFilter;
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
import com.hy.powerplatform.my_utils.myViews.MoneyTextWatcher;
import com.hy.powerplatform.my_utils.myViews.MoneyValueFilter;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.MoneyFormat;
import com.hy.powerplatform.my_utils.utils.PhoneSession;
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
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class FragmentBillData extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.etZDPerson)
    EditText etZDPerson;
    @BindView(R.id.tvZDTime)
    TextView tvZDTime;
    @BindView(R.id.etDepartment)
    EditText etDepartment;
    @BindView(R.id.etJKPerson)
    EditText etJKPerson;
    @BindView(R.id.etDriver)
    EditText etDriver;
    @BindView(R.id.etCarNo)
    EditText etCarNo;
    @BindView(R.id.etAddress)
    EditText etAddress;
    @BindView(R.id.etUse)
    EditText etUse;
    @BindView(R.id.etOtherPerson)
    EditText etOtherPerson;
    @BindView(R.id.etOtherPhone)
    EditText etOtherPhone;
    @BindView(R.id.etReason)
    EditText etReason;
    @BindView(R.id.etSmallMoney)
    EditText etSmallMoney;
    @BindView(R.id.etType)
    EditText etType;
    @BindView(R.id.etBlame)
    EditText etBlame;
    @BindView(R.id.etNum)
    EditText etNum;
    @BindView(R.id.etMoney)
    EditText etMoney;
    @BindView(R.id.etAllMoneyM)
    EditText etAllMoneyM;
    @BindView(R.id.etAllMoneyY)
    EditText etAllMoneyY;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.tvLeader2)
    TextView tvLeader2;
    @BindView(R.id.btnUp)
    Button btnUp;

    String tag = "";
    List<String> list = new ArrayList<String>();
    String data1, res;
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
    String liushuihao;
    @BindView(R.id.etBigMoney)
    TextView etBigMoney;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.tvLeaderW)
    TextView tvLeaderW;
    @BindView(R.id.tvLeader1W)
    TextView tvLeader1W;
    @BindView(R.id.tvLeader2W)
    TextView tvLeader2W;
    private CustomDatePickerDay customDatePicker1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bill_data1, container, false);
        unbinder = ButterKnife.bind(this, view);
        //TextWatcher方式
        etSmallMoney.addTextChangedListener(new MoneyTextWatcher(etSmallMoney).setDigits(2));
        //setFilters方式
        etSmallMoney.setFilters(new InputFilter[]{new MoneyValueFilter().setDigits(2)});
        initDatePicker();
        userId = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userCode", "");
        userName = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userStatus", "");
        String department = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "depName", "");
        etZDPerson.setText(userName);
        etJKPerson.setText(userName);
        etDriver.setText(userName);
        etDepartment.setText(department);
        etSmallMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    BigDecimal numOfMoney = new BigDecimal(s.toString());
                    etBigMoney.setText(MoneyFormat.toChineseCharI1(numOfMoney));
                }
            }
        });
        ProgressDialogUtil.startLoad(getActivity(), "获取流水号中");
        getLIuSuiHao();
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
                data1 = dbA.OAQingJiaMor(url, com.hy.powerplatform.my_utils.base.Constant.BILLDIFID);
                if (data1.equals("保存失败") || data1.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_ONE);
                }
            }
        }).start();
    }

    /**
     * 获取流水号
     */
    private void getLIuSuiHao() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + "system/genNumberSerialNumber.do?alias=hetongqiandingshenpi";
                DBHandler dbA = new DBHandler();
                liushuihao = dbA.OAContractPayLiuSHui(url, "hetongqiandingshenpi");
                if (liushuihao.equals("保存失败") || liushuihao.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_FIVE);
                }
            }
        }).start();
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        String now = sdf.format(new Date());
        tvZDTime.setText(now);
        customDatePicker1 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                String now = sdf.format(new Date());
                String[] temp = null;
                temp = now.split(":");
                tvZDTime.setText(time + ":" + temp[2]);
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

    @OnClick({R.id.tvZDTime, R.id.btnUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvZDTime:
                customDatePicker1.show(tvZDTime.getText().toString());
                break;
            case R.id.btnUp:
                final String zdPerson = etZDPerson.getText().toString();
                final String zdTime = tvZDTime.getText().toString();
                final String department = etDepartment.getText().toString().trim();
                final String JKPerson = etJKPerson.getText().toString().trim();
                final String driver = etDriver.getText().toString().trim();
                final String carNo = etCarNo.getText().toString().trim();
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                Date curDate = new Date(System.currentTimeMillis());
                String str = formatter.format(curDate);
                final String address = etAddress.getText().toString().trim();
                final String use = etUse.getText().toString().trim();
                final String otherPerson = etOtherPerson.getText().toString().trim();
                final String otherPhone = etOtherPhone.getText().toString().trim();
                final String reason = etReason.getText().toString().trim();
                final String smallMoney = etSmallMoney.getText().toString().trim();
                final String bigMoney = etBigMoney.getText().toString().trim();
                final String type = etType.getText().toString().trim();
                final String blame = etBlame.getText().toString().trim();

                final String num = etNum.getText().toString().trim();
                final String money = etMoney.getText().toString();
                final String allMoneyM = etAllMoneyM.getText().toString().trim();
                final String allmoneyY = etAllMoneyY.getText().toString().trim();
                if (carNo.equals("")) {
                    Toast.makeText(getActivity(), "车号不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (address.equals("")) {
                    Toast.makeText(getActivity(), "地点不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (use.equals("")) {
                    Toast.makeText(getActivity(), "用途不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (otherPerson.equals("")) {
                    Toast.makeText(getActivity(), "受伤人数不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (otherPhone.equals("")) {
                    Toast.makeText(getActivity(), "三者电话不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (reason.equals("")) {
                    Toast.makeText(getActivity(), "事故原因不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (bigMoney.equals("")) {
                    Toast.makeText(getActivity(), "借款金额不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (type.equals("")) {
                    Toast.makeText(getActivity(), "险种不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (blame.equals("")) {
                    Toast.makeText(getActivity(), "事故责任不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (zdPerson.equals("")) {
                    Toast.makeText(getActivity(), "制单人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (department.equals("")) {
                    Toast.makeText(getActivity(), "部门不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }

                if (smallMoney.equals("")) {
                    Toast.makeText(getActivity(), "金额不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }

                if (!PhoneSession.isPhoneNumber(otherPhone)) {
                    Toast.makeText(getActivity(), "手机号格式错误", Toast.LENGTH_SHORT).show();
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
                final String zdPerson = etZDPerson.getText().toString();
                final String zdTime = tvZDTime.getText().toString();
                final String department = etDepartment.getText().toString();
                final String JKPerson = etJKPerson.getText().toString();
                final String driver = etDriver.getText().toString();
                final String carNo = etCarNo.getText().toString();
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
                Date curDate = new Date(System.currentTimeMillis());
                String str = formatter.format(curDate);
                final String address = etAddress.getText().toString();
                final String use = etUse.getText().toString();
                final String otherPerson = etOtherPerson.getText().toString();
                final String otherPhone = etOtherPhone.getText().toString();
                final String reason = etReason.getText().toString();
                final String smallMoney = etSmallMoney.getText().toString();
                final String bigMoney = etBigMoney.getText().toString();
                final String type = etType.getText().toString();
                final String blame = etBlame.getText().toString();

                final String num = etNum.getText().toString();
                final String money = etMoney.getText().toString();
                final String allMoneyM = etAllMoneyM.getText().toString();
                final String allmoneyY = etAllMoneyY.getText().toString();
                String res = dbA.OABillUp(turl, userDepart, uId, zdPerson, zdTime,
                        department, JKPerson, driver, carNo, str, address, use, otherPerson, otherPhone,
                        reason, smallMoney, bigMoney, type, blame, num, money, allMoneyM, allmoneyY,
                        userId, userName, liushuihao, reason);
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
                                        res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.BILLDIFID, namelist.get(0));
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
                                                res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.BILLDIFID, data);
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
                case TAG_FIVE:
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };


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
                etZDPerson.setText(userName);
            }
        }
    }

    @OnClick(R.id.tvPerson)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), PersonListActivity.class);
        startActivityForResult(intent, com.hy.powerplatform.my_utils.base.Constant.TAG_TWO);
    }
}
