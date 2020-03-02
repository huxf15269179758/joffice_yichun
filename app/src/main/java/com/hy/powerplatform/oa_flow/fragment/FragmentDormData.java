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
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.IDCardSession;
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
import java.text.ParseException;
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


/**
 * Created by dell on 2017/8/1.
 */

public class FragmentDormData extends Fragment {


    View view;
    Unbinder unbinder;
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
    @BindView(R.id.etPerson)
    EditText etPerson;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.spinnerSex)
    Spinner spinnerSex;
    @BindView(R.id.etAge)
    EditText etAge;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.etIdCard)
    EditText etIdCard;
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etAddress)
    EditText etAddress;
    @BindView(R.id.etLeader)
    TextView etLeader;
    @BindView(R.id.etLeader1)
    TextView etLeader1;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvHome)
    TextView tvHome;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.tvChuangHao)
    TextView tvChuangHao;
    @BindView(R.id.etLeader2)
    TextView etLeader2;
    @BindView(R.id.spinnerMoney)
    Spinner spinnerMoney;
    @BindView(R.id.tvLeader3)
    TextView tvLeader3;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.etReason)
    EditText etReason;

    ArrayAdapter<String> adapter;
    List<String> listSex = new ArrayList<>();
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.etSex)
    EditText etSex;
    @BindView(R.id.tvLeaderW)
    TextView tvLeaderW;
    @BindView(R.id.tvLeader1W)
    TextView tvLeader1W;
    @BindView(R.id.tvLeader2W)
    TextView tvLeader2W;
    @BindView(R.id.tvLeader3W)
    TextView tvLeader3W;
    @BindView(R.id.tvLeader4W)
    TextView tvLeader4W;
    @BindView(R.id.tvLeader5W)
    TextView tvLeader5W;
    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    SharedPreferencesHelper sharedPreferencesHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_dorm_data, container, false);
        unbinder = ButterKnife.bind(this, view);

        listSex.add("男");
        listSex.add("女");
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listSex);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSex.setAdapter(adapter);

        initDatePicker();
        userId = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userCode", "");
        userName = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userStatus", "");
        etPerson.setText(userName);

        sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(), "login");
        String myAge = sharedPreferencesHelper.getData(getActivity(), "myAge", "");
        String mySex = sharedPreferencesHelper.getData(getActivity(), "mySex", "");
        String myMobile = sharedPreferencesHelper.getData(getActivity(), "myMobile", "");
        String myIcCard = sharedPreferencesHelper.getData(getActivity(), "myIcCard", "");
        String myAddress = sharedPreferencesHelper.getData(getActivity(), "myAddress", "");

        etAge.setText(myAge);
        etSex.setText(mySex);
        etPhone.setText(myMobile);
        etIdCard.setText(myIcCard);
        etAddress.setText(myAddress);

        ProgressDialogUtil.startLoad(getActivity(), "获取流水号");
        getLIuSuiHao();
        tvLeaderW.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader1W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader2W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader3W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader4W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader5W.setTextColor(getResources().getColor(R.color.order_stop_black));
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
                data1 = dbA.OAQingJiaMor(url, com.hy.powerplatform.my_utils.base.Constant.DORMDIFID);
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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvTime.setText(now.split(" ")[0]);
        customDatePicker1 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvTime.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker1.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker1.setIsLoop(false);
    }

    @OnClick({R.id.btnUp, R.id.tvData, R.id.tvTime})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTime:
                customDatePicker1.show(tvTime.getText().toString());
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
                final String person = etPerson.getText().toString().trim();
                final String time = tvTime.getText().toString().trim();
                final String sex = String.valueOf(spinnerSex.getSelectedItem());
                final String age = etAge.getText().toString().trim();
                final String idCard = etIdCard.getText().toString().trim();
                final String phone = etPhone.getText().toString().trim();
                final String address = etAddress.getText().toString().trim();
                final String reason = etReason.getText().toString().trim();
                if (person.equals("")) {
                    Toast.makeText(getActivity(), "姓名不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (age.equals("")) {
                    Toast.makeText(getActivity(), "年龄不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (idCard.equals("")) {
                    Toast.makeText(getActivity(), "身份证号不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                try {
                    if (!IDCardSession.IDCardValidate(idCard)) {
                        Toast.makeText(getActivity(), "身份证号格式错误", Toast.LENGTH_SHORT).show();
                        break;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (phone.equals("")) {
                    Toast.makeText(getActivity(), "电话不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (address.equals("")) {
                    Toast.makeText(getActivity(), "户籍所在地不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (reason.equals("")) {
                    Toast.makeText(getActivity(), "申请理由不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (!PhoneSession.isPhoneNumber(phone)) {
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
                final String person = etPerson.getText().toString();
                final String time = tvTime.getText().toString();
                final String sex = etSex.getText().toString();
                final String age = etAge.getText().toString();
                final String idCard = etIdCard.getText().toString();
                final String phone = etPhone.getText().toString();
                final String address = etAddress.getText().toString();
                final String reason = etReason.getText().toString();
                String res = dbA.OADormUp(turl, userDepart, uId, person, time,
                        sex, age, idCard, phone, address, userId, userName, liushuihao, reason);
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
                                        res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.DORMDIFID, namelist.get(0));
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
                                                res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.DORMDIFID, data);
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

    @OnClick(R.id.tvPerson)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), PersonListActivity.class);
        startActivityForResult(intent, com.hy.powerplatform.my_utils.base.Constant.TAG_TWO);
    }

}
