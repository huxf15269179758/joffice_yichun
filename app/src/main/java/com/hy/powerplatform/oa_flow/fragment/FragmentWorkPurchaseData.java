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
import android.widget.LinearLayout;
import android.widget.RadioButton;
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
public class FragmentWorkPurchaseData extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.etClass)
    EditText etClass;
    @BindView(R.id.etPerson)
    EditText etPerson;
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
    @BindView(R.id.etLeader1)
    TextView etLeader1;
    @BindView(R.id.etLeader2)
    TextView etLeader2;
    @BindView(R.id.etLeader3)
    TextView etLeader3;
    @BindView(R.id.etLeader4)
    TextView etLeader4;
    @BindView(R.id.etLeader5)
    TextView etLeader5;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.etLeader6)
    TextView etLeader6;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.etDepartment1)
    EditText etDepartment1;
    @BindView(R.id.etDepartment2)
    EditText etDepartment2;
    @BindView(R.id.etDepartment3)
    EditText etDepartment3;
    @BindView(R.id.etDepartment4)
    EditText etDepartment4;

    String data1, res;
    List<String> namelist = new ArrayList<>();
    List<Name.DataBean> datalist = new ArrayList<>();
    List<Name.DataBean> backlist = new ArrayList<>();
    String name1, name2, name3, name4, name5 = "";
    String department1 = "", department2 = "", department3 = "", department4 = "", department5 = "";
    String num1, num2, num3, num4, num5 = "";
    String money1, money2, money3, money4, money5 = "";
    String allMoney1, allMoney2, allMoney3, allMoney4, allMoney5 = "";
    int hejidj, hejije;
    @BindView(R.id.tvDepartment5)
    TextView tvDepartment5;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.etName5)
    EditText etName5;
    @BindView(R.id.etDepartment5)
    EditText etDepartment5;
    @BindView(R.id.etNum5)
    EditText etNum5;
    @BindView(R.id.etMoney5)
    EditText etMoney5;
    @BindView(R.id.etAllMoney5)
    TextView etAllMoney5;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvAllNum)
    TextView tvAllNum;
    @BindView(R.id.tvAllMoney)
    TextView tvAllMoney;
    @BindView(R.id.tvOther)
    TextView tvOther;
    @BindView(R.id.etApplication1)
    EditText etApplication1;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.tvLeaderW)
    TextView tvLeaderW;
    @BindView(R.id.tvLeader1W)
    TextView tvLeader1W;
    @BindView(R.id.tvLeader2W)
    TextView tvLeader2W;
    private CustomDatePickerDay customDatePicker1;

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
    double AllMoney1 = 0.0, AllMoney2 = 0.0, AllMoney3 = 0.0, AllMoney4 = 0.0, AllMoney5 = 0.0;
    double allNum1 = 0.0, allNum2 = 0.0, allNum3 = 0.0, allNum4 = 0.0, allNum5 = 0.0;
    double moneyS1 = 0.0, moneyS2 = 0.0, moneyS3 = 0.0, moneyS4 = 0.0, moneyS5 = 0.0;
    double allMoney;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_purchasesign_data, container, false);
        unbinder = ButterKnife.bind(this, view);
        initDatePicker();
        userId = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userCode", "");
        userName = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userStatus", "");
        String department = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "depName", "");
        etPerson.setText(userName);
        etClass.setText(department);

        etAllMoney1.addTextChangedListener(new TextWatcher() {
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
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
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
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
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
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
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
                String editStr = s.toString().trim();
                int posDot = editStr.indexOf(".");
                //不允许输入3位小数,超过三位就删掉
                if (posDot > 0) {
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("")) {
                    AllMoney4 = (Double.valueOf(s.toString()));
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                } else {
                    AllMoney4 = 0.0;
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                }
            }
        });
        etAllMoney5.addTextChangedListener(new TextWatcher() {
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
                    if (editStr.length() - posDot - 1 > 2) {
                        s.delete(posDot + 2, posDot + 3);
                    } else {
                        //TODO...在这里写逻辑
                    }
                }
                if (!s.toString().equals("")) {
                    AllMoney5 = (Double.valueOf(s.toString()));
                    tvAllMoney.setText(new BigDecimal(AllMoney1 + AllMoney2 + AllMoney3 + AllMoney4 + AllMoney5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                } else {
                    AllMoney5 = 0.0;
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
                    allNum1 = (Double.valueOf(s.toString()));
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney1.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum1));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney1.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney1.getText().toString().equals("")) {
                            etAllMoney1.setText(new BigDecimal(allNum1 * Double.valueOf(etMoney1.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney1.setText(String.valueOf(0 * allNum1));
                        }
                    }
                } else {
                    allNum1 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5));
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
                    allNum2 = (Double.valueOf(s.toString()));
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney2.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum2));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney2.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney2.getText().toString().equals("")) {
                            etAllMoney2.setText(new BigDecimal(allNum2 * Double.valueOf(etMoney2.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney2.setText(String.valueOf(0 * allNum2));
                        }
                    }
                } else {
                    allNum2 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5));
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
                    allNum3 = (Double.valueOf(s.toString()));
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney3.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum3));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney3.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney3.getText().toString().equals("")) {
                            etAllMoney3.setText(new BigDecimal(allNum3 * Double.valueOf(etMoney3.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney3.setText(String.valueOf(0 * allNum3));
                        }
                    }
                } else {
                    allNum3 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5));
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
                    allNum4 = (Double.valueOf(s.toString()));
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney4.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum4));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney4.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney4.getText().toString().equals("")) {
                            etAllMoney4.setText(new BigDecimal(allNum4 * Double.valueOf(etMoney4.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney4.setText(String.valueOf(0 * allNum4));
                        }
                    }
                } else {
                    allNum4 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5));
                    etAllMoney4.setText(String.valueOf(0 * moneyS4));
                }
            }
        });
        etNum5.addTextChangedListener(new TextWatcher() {
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
                    allNum5 = (Double.valueOf(s.toString()));
                    tvAllNum.setText(new BigDecimal(allNum1 + allNum2 + allNum3 + allNum4 + allNum5).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                    if (!etMoney5.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(allNum5));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etMoney5.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etMoney5.getText().toString().equals("")) {
                            etAllMoney5.setText(new BigDecimal(allNum5 * Double.valueOf(etMoney5.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney5.setText(String.valueOf(0 * allNum5));
                        }
                    }
                } else {
                    allNum5 = 0.0;
                    tvAllNum.setText(String.valueOf(allNum1 + allNum2 + allNum3 + allNum4 + allNum5));
                    etAllMoney5.setText(String.valueOf(0 * moneyS5));
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
        etMoney5.addTextChangedListener(new TextWatcher() {
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
                    moneyS5 = (Double.valueOf(s.toString()));
                    if (!etNum5.getText().toString().equals("")) {
                        BigDecimal b1 = new BigDecimal(Double.toString(moneyS5));
                        BigDecimal b2 = new BigDecimal(Double.toString(Double.valueOf(etNum5.getText().toString())));
                        String s1 = new BigDecimal(b1.multiply(b2).doubleValue()).toString();
                        if (!etNum5.getText().toString().equals("")) {
                            etAllMoney5.setText(new BigDecimal(moneyS5 * Double.valueOf(etNum5.getText().toString())).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                        } else {
                            etAllMoney5.setText(String.valueOf(0 * moneyS5));
                        }
                    }
                } else {
                    etAllMoney5.setText(String.valueOf(0 * moneyS5));
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
                data1 = dbA.OAQingJiaMor(url, com.hy.powerplatform.my_utils.base.Constant.WORKPUECHASEDIFID);
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
                if (etName1.getText().toString().trim().equals("") || etNum1.getText().toString().trim().equals("") || etAllMoney1.getText().toString().trim().equals("")) {
                    Toast.makeText(getActivity(), "采购信息不能为空", Toast.LENGTH_SHORT).show();
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
                String department = etClass.getText().toString();
                String person = etPerson.getText().toString();
                String time = tvTime.getText().toString();
                String other = tvOther.getText().toString();
                allMoney1 = etAllMoney1.getText().toString() + "";
                allMoney2 = etAllMoney2.getText().toString() + "";
                allMoney3 = etAllMoney3.getText().toString() + "";
                allMoney4 = etAllMoney4.getText().toString() + "";
                allMoney5 = etAllMoney5.getText().toString() + "";
                String type = null;
                if (rb1.isChecked()) {
                    type = "计划内";
                }
                if (rb2.isChecked()) {
                    type = "计划外";
                }
//                if (allMoney1 != null && !allMoney1.equals("")) {
//                    hejije += Integer.parseInt(allMoney1);
//                }
//                if (allMoney2 != null && !allMoney2.equals("")) {
//                    hejije += Integer.parseInt(allMoney2);
//                }
//                if (allMoney3 != null && !allMoney3.equals("")) {
//                    hejije = Integer.parseInt(allMoney3);
//                }
//                if (allMoney4 != null && !allMoney4.equals("")) {
//                    hejije = Integer.parseInt(allMoney4);
//                }
//                if (allMoney5 != null && !allMoney5.equals("")) {
//                    hejije = Integer.parseInt(allMoney5);
//                }
                name1 = etName1.getText().toString() + "";
                name2 = etName2.getText().toString() + "";
                name3 = etName3.getText().toString() + "";
                name4 = etName4.getText().toString() + "";
                name5 = etName5.getText().toString() + "";

                num1 = etNum1.getText().toString() + "";
                num2 = etNum2.getText().toString() + "";
                num3 = etNum3.getText().toString() + "";
                num4 = etNum4.getText().toString() + "";
                num5 = etNum5.getText().toString() + "";

                money1 = etMoney1.getText().toString() + "";
                money2 = etMoney2.getText().toString() + "";
                money3 = etMoney3.getText().toString() + "";
                money4 = etMoney4.getText().toString() + "";
                money5 = etMoney5.getText().toString() + "";

                department1 = etDepartment1.getText().toString();
                department2 = etDepartment2.getText().toString();
                department3 = etDepartment3.getText().toString();
                department4 = etDepartment4.getText().toString();
                department5 = etDepartment5.getText().toString();

                final String userCode = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userCode", "");
                res = dbA.OAWorkPurchaseUp(turl, department, person, time, "", name1, name2, name3, name4, name5
                        , num1, num2, num3, num4, num5, money1, money2, money3, money4, money5, allMoney1, allMoney2, allMoney3
                        , allMoney4, allMoney5, userCode, userDepart, uId, tvAllNum.getText().toString(), String.valueOf(hejidj)
                        , tvAllMoney.getText().toString(), department1, department2, department3, department4, department5, other, type);
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
                                        res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.WORKPUECHASEDIFID, namelist.get(0));
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
                                                String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2 + com.hy.powerplatform.my_utils.base.Constant.NOENDPERSON;
                                                DBHandler dbA = new DBHandler();
                                                userDepart = data;
                                                res = dbA.OAQingJiaMorNext(url, com.hy.powerplatform.my_utils.base.Constant.WORKPUECHASEDIFID, data);
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
