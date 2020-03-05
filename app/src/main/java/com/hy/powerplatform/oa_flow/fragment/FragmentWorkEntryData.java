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
import com.hy.powerplatform.my_utils.utils.PhoneSession;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.activity.EntryPersonActivity;
import com.hy.powerplatform.oa_flow.bean.Name;
import com.hy.powerplatform.oa_flow.phone.PhoneDepartmentActivity;
import com.leon.lfilepickerlibrary.LFilePicker;
import com.leon.lfilepickerlibrary.utils.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class FragmentWorkEntryData extends Fragment {

    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.etSex)
    EditText etSex;
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etIdNum)
    EditText etIdNum;
    @BindView(R.id.spinnerCarType)
    Spinner spinnerCarType;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.spinnerYY)
    Spinner spinnerYY;
    @BindView(R.id.spinnerRZ)
    Spinner spinnerRZ;
    @BindView(R.id.btnUp)
    Button btnUp;
    Unbinder unbinder;

    List<String> listCarType = new ArrayList<String>();
    List<String> listYY = new ArrayList<String>();
    List<String> listRZ = new ArrayList<String>();

    ArrayAdapter<String> sexAdapter;
    ArrayAdapter<String> carTypedAapter;
    ArrayAdapter<String> YYAdapter;
    ArrayAdapter<String> RZAdapter;

    List<String> namelist = new ArrayList<>();
    List<Name.DataBean> datalist = new ArrayList<>();
    List<Name.DataBean> backlist = new ArrayList<>();

    String zjcx1 = "", zjcx2 = "", zjcx3 = "", zjcx4 = "";
    String data1, res;

    String userId = "";
    String role = "";
    String userCode = "";
    String userName = "";
    String[] nametemp = null;
    String[] codetemp = null;
    String departName = "";
    String departId = "";
    List<String> codeList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    List<String> namelist1 = new ArrayList<>();
    String userDepart = "";
    String isShow = "flase";
    @BindView(R.id.spinnerCarType1)
    Spinner spinnerCarType1;
    @BindView(R.id.spinnerCarType2)
    Spinner spinnerCarType2;

    String liushuihao = "";
    @BindView(R.id.etCarType)
    EditText etCarType;
    @BindView(R.id.tvLeader3)
    TextView tvLeader3;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.tvLeader2)
    TextView tvLeader2;
    @BindView(R.id.tvLeaderW)
    TextView tvLeaderW;
    @BindView(R.id.tvLeader1W)
    TextView tvLeader1W;
    @BindView(R.id.tvLeader2W)
    TextView tvLeader2W;
    @BindView(R.id.tvLeader3W)
    TextView tvLeader3W;
    @BindView(R.id.tvLeaderNum)
    TextView tvLeaderNum;
    @BindView(R.id.tvLeaderNumW)
    TextView tvLeaderNumW;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workentry_data, container, false);
        unbinder = ButterKnife.bind(this, view);

        listCarType.add("A1");
        listCarType.add("A3");
        listCarType.add("B1");
        listCarType.add("B3");

        listYY.add("公司1");
        listYY.add("公司2");

        listRZ.add("签订合同");
        listRZ.add("领取服装");
        listRZ.add("开介绍信到公司");

        carTypedAapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listCarType);
        carTypedAapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCarType.setAdapter(carTypedAapter);

        carTypedAapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listCarType);
        carTypedAapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCarType1.setAdapter(carTypedAapter);

        carTypedAapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listCarType);
        carTypedAapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCarType2.setAdapter(carTypedAapter);

        YYAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listYY);
        YYAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYY.setAdapter(YYAdapter);

        RZAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listRZ);
        RZAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRZ.setAdapter(RZAdapter);

        userId = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userCode", "");
        userName = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userStatus", "");
//        etPerson.setText(userName);
        ProgressDialogUtil.startLoad(getActivity(), "获取流水号");
        getLIuSuiHao();
        tvLeaderW.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader1W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader2W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader3W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeaderNum.setTextColor(getResources().getColor(R.color.order_stop_black));
        return view;
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
     * 获取第一审批人
     */
    private void getSenPiPersonOne() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + "flow/startTransProcessActivity.do";
                DBHandler dbA = new DBHandler();
                data1 = dbA.OAQingJiaMor(url, com.hy.powerplatform.my_utils.base.Constant.WORKENTRYDIFID);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tvData, R.id.btnUp, R.id.tvPerson,R.id.tvDepartment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvPerson:
                Intent intent = new Intent(getActivity(), EntryPersonActivity.class);
                startActivityForResult(intent, TAG_ONE);
                break;
            case R.id.tvDepartment:
                Intent intent1 = new Intent(getActivity(), PhoneDepartmentActivity.class);
                startActivityForResult(intent1, TAG_TWO);
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
                final String person = tvPerson.getText().toString().trim();
                final String phone = etPhone.getText().toString().trim();
                final String idCard = etIdNum.getText().toString().trim();
                final String sex = etSex.getText().toString();
                final String carType = etCarType.getText().toString().trim();
                final String department = tvDepartment.getText().toString().trim();
                zjcx1 = carType;
                if (person.equals("")) {
                    Toast.makeText(getActivity(), "入职人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (phone.equals("")) {
                    Toast.makeText(getActivity(), "联系电话不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (idCard.equals("")) {
                    Toast.makeText(getActivity(), "身份证号不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (!PhoneSession.isPhoneNumber(phone)) {
                    Toast.makeText(getActivity(), "手机号的格式错误", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (carType.equals("")) {
                    Toast.makeText(getActivity(), "准驾车型不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (department.equals("")) {
                    Toast.makeText(getActivity(), "分配部门不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
//                try {
//                    if (!IDCardSession.IDCardValidate(idCard)) {
//                        Toast.makeText(getActivity(), "身份证号格式错误", Toast.LENGTH_SHORT).show();
//                        break;
//                    }
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
                ProgressDialogUtil.startLoad(getActivity(), "获取数据中");
                getSenPiPersonOne();
//                ProgressDialogUtil.startLoad(getActivity(), "上传数据中");
//                UpContractData();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_ONE:
                if (resultCode == TAG_ONE) {
                    tvPerson.setText(data.getStringExtra("fullname"));
                    etPhone.setText(data.getStringExtra("mobile"));
                    etIdNum.setText(data.getStringExtra("idNo"));
                    etSex.setText(data.getStringExtra("sex"));
                    etCarType.setText(data.getStringExtra("vehicleClass"));
                }
                break;
            case TAG_TWO:
                if (resultCode == com.hy.powerplatform.my_utils.base.Constant.TAG_THERE) {
                    departName = data.getStringExtra("name");
                    departId = data.getStringExtra("id");
                    tvDepartment.setText(departName);
                }
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
                final String person = tvPerson.getText().toString();
                final String phone = etPhone.getText().toString();
                final String idCard = etIdNum.getText().toString();
                final String carType = etCarType.getText().toString();
                final String sex = etSex.getText().toString();
                String res = dbA.OAWorkEntryUp(turl, userDepart, uId, person, phone, idCard,
                        sex, carType, liushuihao,departId,departName);
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
                                        res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.WORKENTRYDIFID, namelist.get(0));
                                        userDepart = namelist.get(0);
                                        if (res.equals("保存失败") || res.equals("")) {
                                            handler.sendEmptyMessage(TAG_TWO);
                                        } else {
                                            handler.sendEmptyMessage(TAG_FOUR);
                                        }
                                    }
                                }).start();
                            } else {
                                ProgressDialogUtil.stopLoad();
                                MyAlertDialog.MyListAlertDialog(getActivity(), namelist, new AlertDialogCallBackP() {
                                    @Override
                                    public void oneselect(final String data) {
                                        ProgressDialogUtil.startLoad(getActivity(), "获取数据中");
                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + com.hy.powerplatform.my_utils.base.Constant.NOENDPERSON;
                                                DBHandler dbA = new DBHandler();
                                                userDepart = data;
                                                res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.WORKENTRYDIFID, data);
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
}
