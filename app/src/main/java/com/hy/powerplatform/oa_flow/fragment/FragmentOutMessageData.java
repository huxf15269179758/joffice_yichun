package com.hy.powerplatform.oa_flow.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
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
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.oa_flow.bean.Name;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class FragmentOutMessageData extends Fragment {


    @BindView(R.id.etTitle)
    EditText etTitle;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.etZhuSong)
    EditText etZhuSong;
    @BindView(R.id.etChaoBao)
    EditText etChaoBao;
    @BindView(R.id.etChaoSong)
    EditText etChaoSong;
    @BindView(R.id.etNiGao)
    EditText etNiGao;
    @BindView(R.id.etHeGao)
    TextView etHeGao;
    @BindView(R.id.etShenHe)
    EditText etShenHe;
    @BindView(R.id.etQianFa)
    EditText etQianFa;
    @BindView(R.id.etNum)
    EditText etNum;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.et1)
    TextView et1;
    @BindView(R.id.et2)
    TextView et2;
    @BindView(R.id.et3)
    TextView et3;
    @BindView(R.id.btnUp)
    Button btnUp;
    Unbinder unbinder;
    @BindView(R.id.tvLeaderW)
    TextView tvLeaderW;
    @BindView(R.id.tvLeader1W)
    TextView tvLeader1W;
    @BindView(R.id.tvShenHe)
    TextView tvShenHe;
    @BindView(R.id.tvLeader2W)
    TextView tvLeader2W;
    @BindView(R.id.tvLeader4W)
    TextView tvLeader4W;
    @BindView(R.id.etTextNum)
    EditText etTextNum;
    @BindView(R.id.tvQianFa)
    TextView tvQianFa;
    @BindView(R.id.tvStartTime1)
    TextView tvStartTime1;
    private CustomDatePickerDay customDatePicker1;
    List<String> namelist = new ArrayList<>();
    List<Name.DataBean> datalist = new ArrayList<>();
    List<Name.DataBean> backlist = new ArrayList<>();
    String data1, res;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_outmessage_data, container, false);
        unbinder = ButterKnife.bind(this, view);
        initDatePicker();
        userId = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userCode", "");
        userName = new SharedPreferencesHelper(getActivity(), "login").getData(getActivity(), "userStatus", "");
        etNiGao.setText(userName);
        tvLeaderW.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader1W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader2W.setTextColor(getResources().getColor(R.color.order_stop_black));
        tvLeader4W.setTextColor(getResources().getColor(R.color.order_stop_black));
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
                data1 = dbA.OAQingJiaMor(url, Constant.OUTMESSAGEDIFID);
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
                res = dbA.OAQingJiaMorNext(url, Constant.OUTMESSAGEDIFID, data);
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
        tvStartTime.setText(now.split(" ")[0]);

        customDatePicker1 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvStartTime.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker1.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker1.setIsLoop(false);
    }

    @OnClick({R.id.tvData, R.id.tvStartTime, R.id.btnUp})
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
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.btnUp:
                final String title = etTitle.getText().toString().trim();
                final String zhuSong = etZhuSong.getText().toString().trim();
                final String chaoBao = etChaoBao.getText().toString().trim();
                final String chaoSong = etChaoSong.getText().toString().trim();
                final String niGao = etNiGao.getText().toString().trim();
                final String heGao = etHeGao.getText().toString().trim();
                final String num = etNum.getText().toString().trim();
                final String textNum = etTextNum.getText().toString().trim();

                final String wenHao = et1.getText().toString();
                final String riQi = et2.getText().toString();
                final String xuHao = et3.getText().toString();
                if (title.equals("")) {
                    Toast.makeText(getActivity(), "标题不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
//                if (zhuSong.equals("")) {
//                    Toast.makeText(getActivity(), "主送人不能为空", Toast.LENGTH_SHORT).show();
//                    break;
//                }
//                if (chaoBao.equals("")) {
//                    Toast.makeText(getActivity(), "抄报人不能为空", Toast.LENGTH_SHORT).show();
//                    break;
//                }
                if (chaoSong.equals("")) {
                    Toast.makeText(getActivity(), "抄送人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (niGao.equals("")) {
                    Toast.makeText(getActivity(), "拟稿人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (num.equals("")) {
                    Toast.makeText(getActivity(), "印刷份数不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (textNum.equals("")) {
                    Toast.makeText(getActivity(), "文号1不能为空", Toast.LENGTH_SHORT).show();
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
                final String title = etTitle.getText().toString();
                final String zhuSong = etZhuSong.getText().toString();
                final String chaoBao = etChaoBao.getText().toString();
                final String chaoSong = etChaoSong.getText().toString();
                final String niGao = etNiGao.getText().toString();
                final String heGao = etHeGao.getText().toString();
                final String num = etNum.getText().toString();

                final String wenHao = etTextNum.getText().toString();
                final String riQi = et2.getText().toString();
                final String xuHao = et3.getText().toString();
                final String time = tvStartTime.getText().toString();
                String res = dbA.OAOutMessageUp(turl, userDepart, uId, title, zhuSong, chaoBao,
                        chaoSong, niGao, heGao, num, wenHao, riQi, xuHao, userId, userName, time);
                if (res.equals("")) {
                    handler.sendEmptyMessage(TAG_THERE);
                } else {
                    handler.sendEmptyMessage(TAG_TWO);
                }
            }
        }).start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
                                        String url = Constant.BASE_URL2 + Constant.NOENDPERSON;
                                        DBHandler dbA = new DBHandler();
                                        res = dbA.OAQingJiaMorNext(url, Constant.OUTMESSAGEDIFID, namelist.get(0));
                                        userDepart = namelist.get(0);
                                        if (res.equals("保存失败") || res.equals("")) {
                                            handler.sendEmptyMessage(TAG_TWO);
                                        } else {
                                            handler.sendEmptyMessage(TAG_FOUR);
                                        }
                                    }
                                }).start();
                            } else {
//                                new AlertDialogUtil(getActivity()).showPictureOnlyDialog(namelist, new ItemCallBack() {
//                                    @Override
//                                    public void ItemPosition(final int position) {
//                                        new Thread(new Runnable() {
//                                            @Override
//                                            public void run() {
//                                                String url = com.hy.powerplatform.my_utils.base.Constant.BASE_URL2+"flow/mobileUsersProcessActivity.do";
//                                                DBHandler dbA = new DBHandler();
//                                                res = dbA.OAQingJiaMorNext(url, "10135", namelist.get(position));
//                                                if (res.equals("保存失败") || res.equals("")) {
//                                                    handler.sendEmptyMessage(TAG_TWO);
//                                                } else {
//                                                    handler.sendEmptyMessage(TAG_FOUR);
//                                                }
//                                            }
//                                        }).start();
//                                    }
//                                });
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
                                                res = dbA.OAQingJiaMorNext(url, Constant.OUTMESSAGEDIFID, data);
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
}
