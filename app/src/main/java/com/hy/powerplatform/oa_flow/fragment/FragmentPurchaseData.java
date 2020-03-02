package com.hy.powerplatform.oa_flow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.oa_flow.activity.PersonListActivity;
import com.hy.powerplatform.oa_flow.bean.Name;

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

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

/**
 * 采购审批
 */
public class FragmentPurchaseData extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.etClass)
    EditText etClass;
    @BindView(R.id.etPerson)
    EditText etPerson;
    @BindView(R.id.spinnerType)
    Spinner spinnerType;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.etName1)
    EditText etName1;
    @BindView(R.id.etName2)
    EditText etName2;
    @BindView(R.id.etName3)
    EditText etName3;
    @BindView(R.id.etName4)
    EditText etName4;
    @BindView(R.id.etNum1)
    EditText etNum1;
    @BindView(R.id.etNum2)
    EditText etNum2;
    @BindView(R.id.etNum3)
    EditText etNum3;
    @BindView(R.id.etNum4)
    EditText etNum4;
    @BindView(R.id.etMoney1)
    EditText etMoney1;
    @BindView(R.id.etMoney2)
    EditText etMoney2;
    @BindView(R.id.etMoney3)
    EditText etMoney3;
    @BindView(R.id.etMoney4)
    EditText etMoney4;
    @BindView(R.id.etAllMoney1)
    TextView etAllMoney1;
    @BindView(R.id.etAllMoney2)
    TextView etAllMoney2;
    @BindView(R.id.etAllMoney3)
    TextView etAllMoney3;
    @BindView(R.id.etAllMoney4)
    TextView etAllMoney4;
    @BindView(R.id.etLeader)
    TextView etLeader;
    @BindView(R.id.etLeader1)
    TextView etLeader1;
    @BindView(R.id.etLeader3)
    TextView etLeader3;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.etUse)
    EditText etUse;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvAllNum)
    TextView tvAllNum;
    @BindView(R.id.tvAllMoney)
    TextView tvAllMoney;
    @BindView(R.id.spinnerzc)
    Spinner spinnerzc;
    @BindView(R.id.spinnertype)
    Spinner spinnertype;
    @BindView(R.id.etLeaderJG)
    EditText etLeaderJG;
    @BindView(R.id.tvLeaderJG)
    TextView tvLeaderJG;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.tvLeader3)
    TextView tvLeader3;
    @BindView(R.id.etLeader4)
    EditText etLeader4;
    @BindView(R.id.tvLeader4)
    TextView tvLeader4;
    @BindView(R.id.etDepartment1)
    EditText etDepartment1;
    @BindView(R.id.etDepartment2)
    EditText etDepartment2;
    @BindView(R.id.etDepartment3)
    EditText etDepartment3;
    @BindView(R.id.etDepartment4)
    EditText etDepartment4;
    @BindView(R.id.tvDepartment5)
    TextView tvDepartment5;
    @BindView(R.id.etBZ1)
    EditText etBZ1;
    @BindView(R.id.etBZ2)
    EditText etBZ2;
    @BindView(R.id.etBZ3)
    EditText etBZ3;
    @BindView(R.id.etBZ4)
    EditText etBZ4;
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
    @BindView(R.id.tvLeader6W)
    TextView tvLeader6W;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.tvLeaderGYB)
    TextView tvLeaderGYB;
    @BindView(R.id.etOtherName)
    EditText etOtherName;
    @BindView(R.id.etOtherMoney)
    EditText etOtherMoney;
    @BindView(R.id.etOtherMemo)
    EditText etOtherMemo;

    private CustomDatePickerDay customDatePicker1;
    List<String> dataList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    String data1, res;
    List<String> namelist = new ArrayList<>();
    List<Name.DataBean> datalist = new ArrayList<>();
    List<Name.DataBean> backlist = new ArrayList<>();
    String name1, name2, name3, name4, name5 = "";
    String num1, num2, num3, num4, num5 = "";
    String money1, money2, money3, money4, money5 = "";
    String allMoney1, allMoney2, allMoney3, allMoney4, allMoney5 = "";
    int hejidj, hejije, hejisl;

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
    List<String> listZC = new ArrayList<String>();
    List<String> listType = new ArrayList<String>();
    String userDepart = "";
    String isShow = "true";
    String aboutData, aboutDep = "";
    double AllMoney1 = 0.0, AllMoney2 = 0.0, AllMoney3 = 0.0, AllMoney4 = 0.0, AllMoney5 = 0.0, OtherMoney = 0.0;
    double numS1 = 0, numS2 = 0, numS3 = 0, numS4 = 0, numS5 = 0;
    double moneyS1 = 0.0, moneyS2 = 0.0, moneyS3 = 0.0, moneyS4 = 0.0, moneyS5 = 0.0;
    String department1 = "", department2 = "", department3 = "", department4 = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_purchase_data, container, false);
        unbinder = ButterKnife.bind(this, view);
        initDatePicker();
        dataList.add("计划内");
        dataList.add("计划外");
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, dataList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapter);
        userId = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userCode", "");
        userName = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userStatus", "");
        String department = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "depName", "");
        etPerson.setText(userName);
        etClass.setText(department);

        etOtherMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("")) {
                    OtherMoney = (Double.valueOf(s.toString()));
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5+OtherMoney).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                } else {
                    OtherMoney = 0.0;
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5+OtherMoney).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                }
            }
        });

        etAllMoney1.addTextChangedListener(new TextWatcher() {
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
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                } else {
                    AllMoney1 = 0.0;
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                }
            }
        });
        etAllMoney2.addTextChangedListener(new TextWatcher() {
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
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                } else {
                    AllMoney2 = 0.0;
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                }
            }
        });
        etAllMoney3.addTextChangedListener(new TextWatcher() {
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
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                } else {
                    AllMoney3 = 0.0;
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                }
            }
        });
        etAllMoney4.addTextChangedListener(new TextWatcher() {
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
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                } else {
                    AllMoney4 = 0.0;
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                }
            }
        });

        etNum1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    numS1 = (Double.valueOf(s.toString()));
                    tvAllNum.setText(new BigDecimal(numS1 + numS2 + numS3 + numS4 + numS5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney1.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(numS1));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney1.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney1.getText().toString().equals("")) {
                            etAllMoney1.setText(new BigDecimal(numS1 * Double.valueOf(etMoney1.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney1.setText(String.valueOf(0 * numS1));
                        }
                    }
                } else {
                    numS1 = 0;
                    tvAllNum.setText(String.valueOf(numS1 + numS2 + numS3 + numS4 + numS5));
                    etAllMoney1.setText(String.valueOf(0 * moneyS1));
                }
            }
        });
        etNum2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    numS2 = (Double.valueOf(s.toString()));
                    tvAllNum.setText(new BigDecimal(numS1 + numS2 + numS3 + numS4 + numS5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney2.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(numS2));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney2.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney2.getText().toString().equals("")) {
                            etAllMoney2.setText(new BigDecimal(numS2 * Double.valueOf(etMoney2.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney2.setText(String.valueOf(0 * numS2));
                        }
                    }
                } else {
                    numS2 = 0;
                    tvAllNum.setText(String.valueOf(numS1 + numS2 + numS3 + numS4 + numS5));
                    etAllMoney2.setText(String.valueOf(0 * moneyS2));
                }
            }
        });
        etNum3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    numS3 = (Double.valueOf(s.toString()));
                    tvAllNum.setText(new BigDecimal(numS1 + numS2 + numS3 + numS4 + numS5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney3.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(numS3));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney3.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney3.getText().toString().equals("")) {
                            etAllMoney3.setText(new BigDecimal(numS3 * Double.valueOf(etMoney3.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney3.setText(String.valueOf(0 * numS3));
                        }
                    }
                } else {
                    numS3 = 0;
                    tvAllNum.setText(String.valueOf(numS1 + numS2 + numS3 + numS4 + numS5));
                    etAllMoney3.setText(String.valueOf(0 * moneyS3));
                }
            }
        });
        etNum4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    numS4 = (Double.valueOf(s.toString()));
                    tvAllNum.setText(new BigDecimal(numS1 + numS2 + numS3 + numS4 + numS5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney4.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(numS4));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney4.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney4.getText().toString().equals("")) {
                            etAllMoney4.setText(new BigDecimal(numS4 * Double.valueOf(etMoney4.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney4.setText(String.valueOf(0 * numS4));
                        }
                    }
                } else {
                    numS4 = 0;
                    tvAllNum.setText(String.valueOf(numS1 + numS2 + numS3 + numS4 + numS5));
                    etAllMoney4.setText(String.valueOf(0 * moneyS4));
                }
            }
        });

        etMoney1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }

                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS1 = (Double.valueOf(s.toString()));
                    if (!etNum1.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS1));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum1.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum1.getText().toString().equals("")) {
//                            etAllMoney1.setText(s1);
                            etAllMoney1.setText(new BigDecimal(moneyS1 * Double.valueOf(etNum1.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney1.setText(String.valueOf(0 * moneyS1));
                        }
                    }
                } else {
                    etAllMoney1.setText(String.valueOf(0 * moneyS1));
                }
            }
        });
        etMoney2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS2 = (Double.valueOf(s.toString()));
                    if (!etNum2.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS2));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum2.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum2.getText().toString().equals("")) {
                            etAllMoney2.setText(new BigDecimal(moneyS2 * Double.valueOf(etNum2.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney2.setText(String.valueOf(0 * moneyS2));
                        }
                    }
                } else {
                    etAllMoney2.setText(String.valueOf(0 * moneyS2));
                }
            }
        });
        etMoney3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS3 = (Double.valueOf(s.toString()));
                    if (!etNum3.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS3));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum3.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum3.getText().toString().equals("")) {
                            etAllMoney3.setText(new BigDecimal(moneyS3 * Double.valueOf(etNum3.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney3.setText(String.valueOf(0 * moneyS3));
                        }
                    }
                } else {
                    etAllMoney3.setText(String.valueOf(0 * moneyS3));
                }
            }
        });
        etMoney4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 1) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("") && !s.toString().equals(".")) {
                    moneyS4 = (Double.valueOf(s.toString()));
                    if (!etNum4.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS4));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum4.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum4.getText().toString().equals("")) {
                            etAllMoney4.setText(new BigDecimal(moneyS4 * Double.valueOf(etNum4.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney4.setText(String.valueOf(0 * moneyS4));
                        }
                    }
                } else {
                    etAllMoney4.setText(String.valueOf(0 * moneyS4));
                }
            }
        });

        listZC.add("资产类");
        listZC.add("非资产类");
        listType.add("");
        listType.add("办公家具");
        listType.add("电子设备");
        listType.add("交通设备");
        listType.add("房屋及建筑物");
        listType.add("修理设备");
        listType.add("材料配件");
        listType.add("投币机、零钞兑换机");
        listType.add("消防、安防设备");
        ArrayAdapter adapterZC = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listZC);
        adapterZC.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerzc.setAdapter(adapterZC);
        spinnerzc.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (arg2 == 1) {
                    ll.setVisibility(View.GONE);
                    listType.clear();
                    listType.add("");
                } else {
                    ll.setVisibility(View.VISIBLE);
                    listType.clear();
                    listType.add("");
                    listType.add("办公家具");
                    listType.add("电子设备");
                    listType.add("交通设备");
                    listType.add("房屋及建筑物");
                    listType.add("修理设备");
                    listType.add("材料配件");
                    listType.add("投币机、零钞兑换机");
                    listType.add("消防、安防设备");
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        ArrayAdapter adapterType = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listType);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertype.setAdapter(adapterType);
        spinnertype.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if (arg2 != 0) {
                    final String data = (String) spinnertype.getItemAtPosition(arg2);//从spinner中获取被选择的数据
//                    Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String url = Constant.BASE_URL2 + "admin/getAssetsByTypeAssetsManage.do?type=" + data;
                            DBHandler dbA = new DBHandler();
                            aboutData = dbA.GoodsPurchaseAboutDep(url);
                            if (aboutData.equals("保存失败") || aboutData.equals("")) {
                                handler.sendEmptyMessage(111);
                            } else {
                                handler.sendEmptyMessage(222);
                            }
                        }
                    }).start();
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        tvLeaderW.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeaderGYB.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader1W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader2W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader3W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader4W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader5W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader6W.setTextColor(getResources().getColor(R.color.order_stop_black));
        return view;
    }

    /**
     * 获取第一审批人
     */
    private void getSenPiPersonOne() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + "flow/startTransProcessActivity.do";
                DBHandler dbA = new DBHandler();
                data1 = dbA.OAQingJiaMor(url, Constant.PUECHASEFLOWDIFID);
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
                String url = Constant.BASE_URL2 + "flow/mobileUsersProcessActivity.do";
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tvData, R.id.tvTime, R.id.btnUp})
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
            case R.id.tvTime:
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.btnUp:
                final String department = etClass.getText().toString().trim();
                final String person = etPerson.getText().toString().trim();
                final String time = tvTime.getText().toString().trim();
                final String use = etUse.getText().toString().trim();
                String type = spinnertype.getSelectedItem().toString();
                if (department.equals("")) {
                    Toast.makeText(getActivity(), "部门不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (person.equals("")) {
                    Toast.makeText(getActivity(), "申请人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (time.equals("")) {
                    Toast.makeText(getActivity(), "填单日期不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (spinnerzc.getSelectedItem().toString().equals("资产类")) {
                    if (spinnertype.getSelectedItem().toString().equals("")) {
                        Toast.makeText(getActivity(), "物品类型不能为空", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                if (etName1.getText().toString().trim().equals("") || etNum1.getText().toString().trim().equals("") || etAllMoney1.getText().toString().trim().equals("")) {
                    Toast.makeText(getActivity(), "采购信息不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (use.equals("")) {
                    Toast.makeText(getActivity(), "用途不能为空", Toast.LENGTH_SHORT).show();
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
                String turl = Constant.BASE_URL2 + Constant.UPDATAU;
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
                String department = etClass.getText().toString();
                String person = etPerson.getText().toString();
                String time = tvTime.getText().toString();
                String use = etUse.getText().toString();
                String allNum = tvAllNum.getText().toString();
                String allMoney = tvAllMoney.getText().toString();
                String other = etOtherName.getText().toString();
                if (num1 != null && !equals("")) {
                    hejisl += Integer.parseInt(num1);
                }
                if (num2 != null && !equals("")) {
                    hejisl += Integer.parseInt(num2);
                }
                if (num3 != null && !equals("")) {
                    hejisl = Integer.parseInt(num3);
                }
                if (num4 != null && !equals("")) {
                    hejisl = Integer.parseInt(num4);
                }

                if (allMoney1 != null && !equals("")) {
                    hejije += Integer.parseInt(allMoney1);
                }
                if (allMoney2 != null && !equals("")) {
                    hejije += Integer.parseInt(allMoney2);
                }
                if (allMoney3 != null && !equals("")) {
                    hejije = Integer.parseInt(allMoney3);
                }
                if (allMoney4 != null && !equals("")) {
                    hejije = Integer.parseInt(allMoney4);
                }
                name1 = etName1.getText().toString() + "";
                name2 = etName2.getText().toString() + "";
                name3 = etName3.getText().toString() + "";
                name4 = etName4.getText().toString() + "";

                num1 = etNum1.getText().toString() + "";
                num2 = etNum2.getText().toString() + "";
                num3 = etNum3.getText().toString() + "";
                num4 = etNum4.getText().toString() + "";

                money1 = etMoney1.getText().toString() + "";
                money2 = etMoney2.getText().toString() + "";
                money3 = etMoney3.getText().toString() + "";
                money4 = etMoney4.getText().toString() + "";

                department1 = etDepartment1.getText().toString();
                department2 = etDepartment2.getText().toString();
                department3 = etDepartment3.getText().toString();
                department4 = etDepartment4.getText().toString();

                allMoney1 = etAllMoney1.getText().toString() + "";
                allMoney2 = etAllMoney2.getText().toString() + "";
                allMoney3 = etAllMoney3.getText().toString() + "";
                allMoney4 = etAllMoney4.getText().toString() + "";

                String type = "";
                if (spinnertype.getSelectedItem() == null) {
                    type = "";
                } else {
                    type = spinnertype.getSelectedItem().toString();
                }
                final String userCode = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userCode", "");
                res = dbA.OAPurchaseUp(turl, department, person, time, name1, name2, name3, name4, name5
                        , num1, num2, num3, num4, num5, money1, money2, money3, money4, money5, allMoney1, allMoney2, allMoney3
                        , allMoney4, allMoney5, userCode, userDepart, uId, tvAllNum.getText().toString(), String.valueOf(hejidj),
                        tvAllMoney.getText().toString(), use, other, spinnerzc.getSelectedItem().toString()
                        , type, aboutDep, department1, department2
                        , department3, department4, etBZ1.getText().toString(), etBZ2.getText().toString()
                        , etBZ3.getText().toString(), etBZ4.getText().toString(),etOtherMoney.getText().toString(),etOtherMemo.getText().toString());
                if (res.equals("")) {
                    handler.sendEmptyMessage(TAG_THERE);
                } else {
                    handler.sendEmptyMessage(TAG_TWO);
                }
            }
        }).start();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 111:
                    Toast.makeText(getActivity(), "关联部门失败", Toast.LENGTH_SHORT).show();
                    break;
                case 222:
                    try {
                        JSONObject jsonObject = new JSONObject(aboutData);
                        aboutDep = jsonObject.getString("msg");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
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
                                        String url = Constant.BASE_URL2 + Constant.NOENDPERSON;
                                        DBHandler dbA = new DBHandler();
                                        res = dbA.OAQingJiaMorNext(url, Constant.PUECHASEFLOWDIFID, namelist.get(0));
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
                                        ProgressDialogUtil.startLoad(getActivity(), "获取数据中");
                                        new Thread(new Runnable() {
                                            @Override
                                            public void run() {
                                                String url = Constant.BASE_URL2 + Constant.NOENDPERSON;
                                                DBHandler dbA = new DBHandler();
                                                userDepart = data;
                                                res = dbA.OAQingJiaMorNext(url, Constant.PUECHASEFLOWDIFID, data);
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
        startActivityForResult(intent, Constant.TAG_TWO);
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
        if (requestCode == Constant.TAG_TWO) {
            if (data != null) {
                userCode = data.getStringExtra("userCode");
                userName = data.getStringExtra("userName");
                etPerson.setText(userName);
            }
        }
    }
}
