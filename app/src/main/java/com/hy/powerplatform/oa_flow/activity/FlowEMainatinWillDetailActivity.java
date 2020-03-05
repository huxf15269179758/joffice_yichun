package com.hy.powerplatform.oa_flow.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.oa_flow.adapter.FlowMessageAdapter;
import com.hy.powerplatform.oa_flow.bean.Filed;
import com.hy.powerplatform.oa_flow.bean.FlowContractPerson;
import com.hy.powerplatform.oa_flow.bean.FlowEMaintainWillDetail;
import com.hy.powerplatform.oa_flow.bean.FlowMessage1;
import com.hy.powerplatform.oa_flow.util.MyStringSpilt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_EIGHT;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_NINE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SEVEN;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SIX;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class FlowEMainatinWillDetailActivity extends BaseActivity {


    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvDpartment)
    TextView tvDpartment;
    @BindView(R.id.tvShiXiang)
    TextView tvShiXiang;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.cb1)
    CheckBox cb1;
    @BindView(R.id.cb2)
    CheckBox cb2;
    @BindView(R.id.cb3)
    CheckBox cb3;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.cb4)
    CheckBox cb4;
    @BindView(R.id.cb5)
    CheckBox cb5;
    @BindView(R.id.cb6)
    CheckBox cb6;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.cb7)
    CheckBox cb7;
    @BindView(R.id.cb8)
    CheckBox cb8;
    @BindView(R.id.cb9)
    CheckBox cb9;
    @BindView(R.id.ll5)
    LinearLayout ll5;
    @BindView(R.id.rb1)
    CheckBox rb1;
    @BindView(R.id.rb2)
    CheckBox rb2;
    @BindView(R.id.rb3)
    CheckBox rb3;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.rb4)
    CheckBox rb4;
    @BindView(R.id.rb5)
    CheckBox rb5;
    @BindView(R.id.rb6)
    CheckBox rb6;
    @BindView(R.id.ll4)
    LinearLayout ll4;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.etLeader)
    EditText etLeader;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.etLeader1)
    EditText etLeader1;
    @BindView(R.id.tvLeader2)
    TextView tvLeader2;
    @BindView(R.id.tvDate1)
    TextView tvDate1;
    @BindView(R.id.etLeader2)
    EditText etLeader2;
    @BindView(R.id.tvLeader3)
    TextView tvLeader3;
    @BindView(R.id.etLeader3)
    EditText etLeader3;
    @BindView(R.id.tvLeader4)
    TextView tvLeader4;
    @BindView(R.id.etLeader4)
    EditText etLeader4;
    @BindView(R.id.tvLeader5)
    TextView tvLeader5;
    @BindView(R.id.etLeader5)
    EditText etLeader5;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.btnT)
    FloatingActionButton btnT;
    @BindView(R.id.tvText)
    TextView tvText;
    @BindView(R.id.btnHistory)
    Button btnHistory;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.llData)
    LinearLayout llData;
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
    @BindView(R.id.llShenPiRen)
    LinearLayout llShenPiRen;
    @BindView(R.id.llShenPiRenList)
    LinearLayout llShenPiRenList;
    @BindView(R.id.tvspr)
    TextView tvspr;
    private String name, taskId, res, bxbmyj, wxbmyj, wxryyj, wxqkyj, sbsyryj, wxfkyj = "";
    private String mainId, signaName, destName, destType, checkTask, qianzhiData = "";
    String leader = "";
    String leaderCode = "";
    String leaderName = "";
    boolean assigned;
    String tag = "noEnd";
    String comment = "";
    String comment1 = "";
    String comment2 = "";
    String bxbmreout, wxbmreout, wxryreout, wxqkreout, sbsyrreout, wxfkreout, flowAssignld, serialNumber = "";

    String[] bigNametemp = null;
    String[] bigCodetemp = null;
    List<String> resultList = new ArrayList<>();
    List<String> resultList1 = new ArrayList<>();
    List<String> bigResultList = new ArrayList<>();
    List<String> bigResultList1 = new ArrayList<>();
    String tag1;

    String role = "";
    String url;
    String userCode = "";
    String userName = "";
    String upData = "";
    String liushuihao = "";
    String[] nametemp = null;
    String[] codetemp = null;
    List<String> namelist = new ArrayList<>();
    List<FlowEMaintainWillDetail.TransBean> beanList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();

    private CustomDatePickerDay customDatePicker1;
    String xiangguanfujian;
    String btnTTag = "N";
    String flowMessage = "";
    String runID = "";
    String piId = "";
    String downloadData = "";
    FlowMessageAdapter adapter;
    List<FlowMessage1.DataBean> flowList = new ArrayList<>();
    private String executionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        Intent intent = getIntent();
        initDatePicker();
        name = intent.getStringExtra("activityName");
        taskId = intent.getStringExtra("taskId");
        tag1 = intent.getStringExtra("tag");
        piId = intent.getStringExtra("piId");
        executionId = intent.getStringExtra("executionId");
        getData(name, taskId, piId);
        btnUp.setVisibility(View.VISIBLE);
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvDate1.setText(now.split(" ")[0]);

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvDate1.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker1.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker1.setIsLoop(false);
    }

    /**
     * 获取数据
     *
     * @param Name
     * @param taskId
     */
    private void getData(final String Name, final String taskId, final String piId) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        new Thread(new Runnable() {
            @Override
            public void run() {
                //String name =URLDecoder.decode(待转值,"utf-8");
                String url = Constant.BASE_URL2 + Constant.DETAILWILL + Name + "&taskId=" + taskId + "&piId=" + piId;
                //                DBHandler dbA = new DBHandler();
//                res = dbA.OAQingJiaWillDoDex(url);
                OkHttpClient okHttpClient = new OkHttpClient();
                String Session = new SharedPreferencesHelper(MyApplication.getContext(), "login").getData(MyApplication.getContext(), "session", "");
                final Request request = new Request.Builder()
                        .url(url)
                        .addHeader("Cookie", Session)
                        .get()//默认就是GET请求，可以不写
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        handler.sendEmptyMessage(TAG_TWO);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        res = response.body().string();
                        handler.sendEmptyMessage(TAG_ONE);
                    }
                });
            }
        }).start();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_emaintain_data;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setView(LayoutInflater.from(this).inflate(R.layout.dialog_with_edittext, null));
        dialog.show();
        dialog.getWindow().setContentView(R.layout.dialog_with_edittext);
        final EditText etContent = (EditText) dialog.findViewById(R.id.etContent);
        TextView tv_yes = (TextView) dialog.findViewById(R.id.yes);
        TextView tv_no = (TextView) dialog.findViewById(R.id.no);
        tv_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                final String str = etContent.getText().toString();
                if (str.equals("")) {
                    Toast.makeText(FlowEMainatinWillDetailActivity.this, getResources().getString(R.string.nullify_reason), Toast.LENGTH_SHORT).show();
                } else {
                    dialog.dismiss();
                    ProgressDialogUtil.startLoad(FlowEMainatinWillDetailActivity.this, getResources().getString(R.string.get_data));
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            DBHandler dbHandler = new DBHandler();
                            String url = Constant.BASE_URL2 + Constant.NULLIFY;
                            boolean nullifyData = dbHandler.OAFlowNullify(url, taskId, str, executionId);
                            if (nullifyData) {
                                handler.sendEmptyMessage(333);
                            } else {
                                handler.sendEmptyMessage(444);
                            }
                        }
                    }).start();
                }
            }
        });
        tv_no.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
            }
        });
    }

    /**
     * 请求第一个处理人  之后不再让别人处理
     */
    private void getLastPerson() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.LASTPERSON;
                DBHandler dbA = new DBHandler();
                checkTask = dbA.OAQingJiaLast(url, taskId);
                if (checkTask.equals("保存失败") || checkTask.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_EIGHT);
                }
            }
        }).start();
    }

    /**
     * 获取destType  最后不是end的下一级审核人
     */
    private void getNoEndPerson() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.NOENDPERSON;
                DBHandler dbA = new DBHandler();
                qianzhiData = dbA.OAQingJiaFornt1(url, taskId, destName);
                if (qianzhiData.equals("保存失败") || qianzhiData.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_SEVEN);
                }
            }
        }).start();
    }

    //
    private void getNextPerson() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.NESTPERSON;
                DBHandler dbA = new DBHandler();
                qianzhiData = dbA.OAQingJiaFornt1(url, taskId, destName);
                if (qianzhiData.equals("保存失败") || qianzhiData.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_SEVEN);
                }
            }
        }).start();
    }

    /**
     * 设置多选框显示
     */
    private void setCbRbVer() {
        resultList.clear();
        bigResultList.clear();
        ll1.setVisibility(View.GONE);
        ll2.setVisibility(View.GONE);
        ll3.setVisibility(View.GONE);
        ll4.setVisibility(View.GONE);
        ll5.setVisibility(View.GONE);
        rb1.setChecked(false);
        rb2.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);
        rb5.setChecked(false);
        rb6.setChecked(false);
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);
        cb5.setChecked(false);
        cb6.setChecked(false);
        cb7.setChecked(false);
        cb8.setChecked(false);
        cb9.setChecked(false);
        if (nametemp != null) {
            if (nametemp.length == 1) {
                rb1.setText(nametemp[0]);
                rb1.setChecked(true);
                ll3.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.INVISIBLE);
                rb3.setVisibility(View.INVISIBLE);
            }
            if (nametemp.length == 2) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                rb1.setChecked(true);
                rb2.setChecked(true);
                ll3.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.INVISIBLE);
            }
            if (nametemp.length == 3) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                rb3.setText(nametemp[2]);
                rb1.setChecked(true);
                rb2.setChecked(true);
                rb3.setChecked(true);
                ll3.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.VISIBLE);
            }
            if (nametemp.length == 4) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                rb3.setText(nametemp[2]);
                rb4.setText(nametemp[3]);
                rb1.setChecked(true);
                rb2.setChecked(true);
                rb3.setChecked(true);
                rb4.setChecked(true);
                ll3.setVisibility(View.VISIBLE);
                ll4.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.VISIBLE);
                rb4.setVisibility(View.VISIBLE);
                rb5.setVisibility(View.INVISIBLE);
                rb6.setVisibility(View.INVISIBLE);
            }
            if (nametemp.length == 5) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                rb3.setText(nametemp[2]);
                rb4.setText(nametemp[3]);
                rb5.setText(nametemp[4]);
                rb1.setChecked(true);
                rb2.setChecked(true);
                rb3.setChecked(true);
                rb4.setChecked(true);
                rb5.setChecked(true);
                ll3.setVisibility(View.VISIBLE);
                ll4.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.VISIBLE);
                rb4.setVisibility(View.VISIBLE);
                rb5.setVisibility(View.VISIBLE);
                rb6.setVisibility(View.INVISIBLE);
            }
            if (nametemp.length >= 6) {
                rb1.setText(nametemp[0]);
                rb2.setText(nametemp[1]);
                rb3.setText(nametemp[2]);
                rb4.setText(nametemp[3]);
                rb5.setText(nametemp[4]);
                rb6.setText(nametemp[5]);
                rb1.setChecked(true);
                rb2.setChecked(true);
                rb3.setChecked(true);
                rb4.setChecked(true);
                rb5.setChecked(true);
                rb6.setChecked(true);
                ll3.setVisibility(View.VISIBLE);
                ll4.setVisibility(View.VISIBLE);
                rb1.setVisibility(View.VISIBLE);
                rb2.setVisibility(View.VISIBLE);
                rb3.setVisibility(View.VISIBLE);
                rb4.setVisibility(View.VISIBLE);
                rb5.setVisibility(View.VISIBLE);
                rb6.setVisibility(View.VISIBLE);
            }
        }


        if (bigNametemp != null) {
            if (bigNametemp.length == 1) {
                cb1.setText(bigNametemp[0]);
                cb1.setChecked(true);
                ll1.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.INVISIBLE);
                cb3.setVisibility(View.INVISIBLE);
            }
            if (bigNametemp.length == 2) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb1.setChecked(true);
                cb2.setChecked(true);
                ll1.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.INVISIBLE);
            }
            if (bigNametemp.length == 3) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                ll1.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 4) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.INVISIBLE);
                cb6.setVisibility(View.INVISIBLE);
            }
            if (bigNametemp.length == 5) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.INVISIBLE);
            }
            if (bigNametemp.length == 6) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                cb6.setChecked(true);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 7) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                cb6.setChecked(true);
                cb7.setChecked(true);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length == 8) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                cb6.setChecked(true);
                cb7.setChecked(true);
                cb8.setChecked(true);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
            }
            if (bigNametemp.length >= 9) {
                cb1.setText(bigNametemp[0]);
                cb2.setText(bigNametemp[1]);
                cb3.setText(bigNametemp[2]);
                cb4.setText(bigNametemp[3]);
                cb5.setText(bigNametemp[4]);
                cb6.setText(bigNametemp[5]);
                cb7.setText(bigNametemp[6]);
                cb8.setText(bigNametemp[7]);
                cb9.setText(bigNametemp[8]);
                cb1.setChecked(true);
                cb2.setChecked(true);
                cb3.setChecked(true);
                cb4.setChecked(true);
                cb5.setChecked(true);
                cb6.setChecked(true);
                cb7.setChecked(true);
                cb8.setChecked(true);
                cb9.setChecked(true);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                ll5.setVisibility(View.VISIBLE);
                cb1.setVisibility(View.VISIBLE);
                cb2.setVisibility(View.VISIBLE);
                cb3.setVisibility(View.VISIBLE);
                cb4.setVisibility(View.VISIBLE);
                cb5.setVisibility(View.VISIBLE);
                cb6.setVisibility(View.VISIBLE);
                cb7.setVisibility(View.VISIBLE);
                cb8.setVisibility(View.VISIBLE);
                cb9.setVisibility(View.VISIBLE);
            }
        }
        ProgressDialogUtil.stopLoad();
    }

    @OnClick({R.id.btnUp, R.id.tvDate1, R.id.tvData, R.id.btnT, R.id.btnHistory, R.id.llShenPiRen, R.id.llShenPiRenList})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llShenPiRen:
                if (btnT.getVisibility() == View.VISIBLE) {
                    if (btnTTag.equals("N")) {
                        Toast.makeText(this, "请点击加号选择路径", Toast.LENGTH_SHORT).show();
                    } else {
                        if (llShenPiRenList.getVisibility() == View.VISIBLE) {
                            llShenPiRenList.setVisibility(View.GONE);
                        } else {
                            llShenPiRenList.setVisibility(View.VISIBLE);
                        }
                    }
                } else {
                    if (llShenPiRenList.getVisibility() == View.VISIBLE) {
                        llShenPiRenList.setVisibility(View.GONE);
                    } else {
                        llShenPiRenList.setVisibility(View.VISIBLE);
                    }
                }

                break;
            case R.id.llShenPiRenList:
                break;
            case R.id.btnHistory:
                recyclerView.setVisibility(View.VISIBLE);
                ProgressDialogUtil.startLoad(FlowEMainatinWillDetailActivity.this, "获取数据中");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //String name =URLDecoder.decode(待转值,"utf-8");
                        String url = Constant.BASE_URL2 + Constant.FLOWMESSAGE;
                        DBHandler dbA = new DBHandler();
                        flowMessage = dbA.OAFlowMessage(url, runID);
                        if (flowMessage.equals("获取数据失败") || flowMessage.equals("")) {
                            handler.sendEmptyMessage(TAG_TWO);
                        } else {
                            handler.sendEmptyMessage(111);
                        }
                    }
                }).start();
                btnHistory.setEnabled(false);
                break;
            case R.id.btnT:
                btnTTag = "Y";
                llShenPiRenList.setVisibility(View.VISIBLE);
                if (beanList.size() != 0) {
                    if (beanList.size() == 1) {
                        ProgressDialogUtil.startLoad(FlowEMainatinWillDetailActivity.this, "获取数据中");
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                DBHandler dbA = new DBHandler();
                                destType = beanList.get(0).getDestType();
                                if (destType.equals("decision") || destType.equals("fork") || destType.equals("join")) {
                                    handler.sendEmptyMessage(TAG_SIX);
                                } else if (destType.indexOf("end") == -1) {
                                    handler.sendEmptyMessage(TAG_FIVE);
                                } else {
                                    getLastPerson();
                                }
                                signaName = beanList.get(0).getName();
                                destName = beanList.get(0).getDestination();
                            }
                        }).start();
                    } else {
                        namelist.clear();
                        for (int i = 0; i < beanList.size(); i++) {
                            namelist.add(beanList.get(i).getDestination());
                        }
                        MyAlertDialog.MyListAlertDialog(FlowEMainatinWillDetailActivity.this, namelist, new AlertDialogCallBackP() {
                            @Override
                            public void oneselect(final String data) {
                                ProgressDialogUtil.startLoad(FlowEMainatinWillDetailActivity.this, "获取数据中");
                                destName = data;
                                tvspr.setText(destName);
                                for (int i = 0; i < beanList.size(); i++) {
                                    if (destName.equals(beanList.get(i).getDestination())) {
                                        signaName = beanList.get(i).getName();
                                        destType = beanList.get(i).getDestType();
                                    }
                                }
                                if (destType.equals("decision") || destType.equals("fork") || destType.equals("join")) {
                                    handler.sendEmptyMessage(TAG_SIX);
                                } else if (destType.indexOf("end") == -1) {
                                    handler.sendEmptyMessage(TAG_FIVE);
                                } else {
                                    getLastPerson();
                                }

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
                    Toast.makeText(FlowEMainatinWillDetailActivity.this, "审批人为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvData:
                List<String> dataList = new ArrayList<>();
                if (!xiangguanfujian.equals("")) {
                    dataList = new MyStringSpilt().stringSpiltList(xiangguanfujian);
                    if (dataList.size() == 1) {
                        String id = new MyStringSpilt().stringSpilt(dataList.get(0));
                        final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                DBHandler dbA = new DBHandler();
                                downloadData = dbA.OAQingJiaMyDetail(url);
                                if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                                    handler.sendEmptyMessage(TAG_TWO);
                                } else {
                                    handler.sendEmptyMessage(TAG_NINE);
                                }
                            }
                        }).start();
                    } else if (dataList.size() > 1) {
                        MyAlertDialog.MyListAlertDialog(this, dataList, new AlertDialogCallBackP() {
                            @Override
                            public void oneselect(final String data1) {
                                String id = new MyStringSpilt().stringSpilt(data1);
                                final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        DBHandler dbA = new DBHandler();
                                        downloadData = dbA.OAQingJiaMyDetail(url);
                                        if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                                            handler.sendEmptyMessage(TAG_TWO);
                                        } else {
                                            handler.sendEmptyMessage(TAG_NINE);
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
                }
                break;
            case R.id.btnUp:
                userName = new SharedPreferencesHelper(FlowEMainatinWillDetailActivity.this,
                        "login").getData(FlowEMainatinWillDetailActivity.this, "userStatus", "");
                userCode = new SharedPreferencesHelper(FlowEMainatinWillDetailActivity.this,
                        "login").getData(FlowEMainatinWillDetailActivity.this, "userCode", "");
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date curDate = new Date(System.currentTimeMillis());
                String str = formatter.format(curDate);
                if (etLeader.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (bxbmyj.equals("")) {
                        bxbmyj = jsonArray.toString();
                    } else {
                        bxbmyj = bxbmyj + "," + jsonArray.toString();
                        bxbmyj = bxbmyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader1.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader1.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader1.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (wxbmyj.equals("")) {
                        wxbmyj = jsonArray.toString();
                    } else {
                        wxbmyj = wxbmyj + "," + jsonArray.toString();
                        wxbmyj = wxbmyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader2.getVisibility() == View.VISIBLE) {
                    comment1 = "";
                    comment1 = etLeader2.getText().toString();
                    wxryyj = etLeader2.getText().toString();
//            try {
//                jsonObject.put("ui", userCode);
//                jsonObject.put("un", userName);
//                jsonObject.put("c", str);
//                jsonObject.put("v", etLeader2.getText().toString());
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            jsonArray.put(jsonObject);
//            if (jsbmyj.equals("")) {
//                jsbmyj = jsonArray.toString();
//            } else {
//                jsbmyj = jsbmyj + "," + jsonArray.toString();
//                jsbmyj = jsbmyj.toString().replace("],[", ",");
//            }
                }
                if (etLeader3.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader3.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader3.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (wxqkyj.equals("")) {
                        wxqkyj = jsonArray.toString();
                    } else {
                        wxqkyj = wxqkyj + "," + jsonArray.toString();
                        wxqkyj = wxqkyj.toString().replace("],[", ",");
                    }
//                    comment = etLeader3.getText().toString();
//                    wxqkyj = etLeader3.getText().toString();
                }
                if (etLeader4.getVisibility() == View.VISIBLE) {
                    comment2 = "";
                    comment2 = etLeader4.getText().toString();
                    sbsyryj = etLeader4.getText().toString();
                }
                if (etLeader5.getVisibility() == View.VISIBLE) {
                    comment = "";
                    comment = etLeader5.getText().toString();
                    try {
                        jsonObject.put("ui", userCode);
                        jsonObject.put("un", userName);
                        jsonObject.put("c", str);
                        jsonObject.put("v", etLeader5.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonArray.put(jsonObject);
                    if (wxfkyj.equals("")) {
                        wxfkyj = jsonArray.toString();
                    } else {
                        wxfkyj = wxfkyj + "," + jsonArray.toString();
                        wxfkyj = wxfkyj.toString().replace("],[", ",");
                    }
                }

                if (comment.equals("")) {
                    if (!bxbmreout.equals("2") && !wxbmreout.equals("2") && !wxryreout.equals("2") && !wxqkreout.equals("2")
                            && !sbsyrreout.equals("2") && !wxfkreout.equals("2")) {
                        comment = "";
                        personSession();
                    } else if (!bxbmyj.equals("") && !wxbmyj.equals("") && !wxryyj.equals("")
                            && !wxqkyj.equals("") && !sbsyryj.equals("") && !wxfkyj.equals("")) {
                        comment = "";
                        personSession();
                    } else {
                        Toast.makeText(this, "请签字", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (etLeader2.getVisibility() == View.VISIBLE) {
                        if (comment1.equals("")) {
                            Toast.makeText(this, "请签字", Toast.LENGTH_SHORT).show();
                        } else {
                            personSession();
                        }
                    } else if (etLeader4.getVisibility() == View.VISIBLE) {
                        if (comment2.equals("")) {
                            Toast.makeText(this, "请签字", Toast.LENGTH_SHORT).show();
                        } else {
                            personSession();
                        }
                    } else {
                        personSession();
                    }
                }
                break;
            case R.id.tvDate1:
                customDatePicker1.show(tvDate1.getText().toString());
                break;
        }
    }

    private void personSession() {
        if (bigResultList.size() != 0) {
            sendData();
        } else {
            if (btnT.getVisibility() == View.VISIBLE) {
                if (btnTTag.equals("N")) {
                    Toast.makeText(this, "请点击加号选择路径", Toast.LENGTH_SHORT).show();
                    Gson gson = new Gson();
                    FlowEMaintainWillDetail bean = gson.fromJson(res, FlowEMaintainWillDetail.class);
                    bxbmyj = bean.getMainform().get(0).getBmfzryj();
                    wxbmyj = bean.getMainform().get(0).getXxjsbyj();
                    wxryyj = bean.getMainform().get(0).getWeiXiuRenYuanQianZi();
                    wxqkyj = bean.getMainform().get(0).getBjap();
                    sbsyryj = bean.getMainform().get(0).getSheBeiShiYongRenQianZi();
                    wxfkyj = bean.getMainform().get(0).getBjpj();
                } else {
                    sendData();
                }
            } else {
                sendData();
            }
        }
    }

    public void getAppRovePerson() {
        ProgressDialogUtil.startLoad(FlowEMainatinWillDetailActivity.this, "获取数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBHandler dbA = new DBHandler();
                destType = beanList.get(0).getDestType();
                if (destType.equals("decision") || destType.equals("fork") || destType.equals("join")) {
                    handler.sendEmptyMessage(TAG_SIX);
                } else if (destType.indexOf("end") == -1) {
                    handler.sendEmptyMessage(TAG_FIVE);
                } else {
                    getLastPerson();
                }
                signaName = beanList.get(0).getName();
                destName = beanList.get(0).getDestination();
            }
        }).start();
        ProgressDialogUtil.stopLoad();
    }

    private void sendData() {
        ProgressDialogUtil.startLoad(FlowEMainatinWillDetailActivity.this, "提交数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String department = tvDpartment.getText().toString();
                String time = tvTime.getText().toString();
                String data = tvShiXiang.getText().toString();
                final String date = tvDate1.getText().toString();
                final String userCode = new SharedPreferencesHelper(FlowEMainatinWillDetailActivity.this,
                        "login").getData(FlowEMainatinWillDetailActivity.this, "userCode", "");

                if (codetemp != null) {
                    for (String s : codetemp) {
                        resultList.add(s);
                    }
                }
                if (bigCodetemp != null) {
                    for (String s : bigCodetemp) {
                        bigResultList.add(s);
                        bigResultList1.add(s);
                    }
                }

                if (!rb6.isChecked()) {
                    if (resultList.size() >= 6) {
                        resultList.remove(5);
                    }
                }
                if (!rb5.isChecked()) {
                    if (resultList.size() >= 5) {
                        resultList.remove(4);
                    }
                }
                if (!rb4.isChecked()) {
                    if (resultList.size() >= 4) {
                        resultList.remove(3);
                    }
                }
                if (!rb3.isChecked()) {
                    if (resultList.size() >= 3) {
                        resultList.remove(2);
                    }
                }
                if (!rb2.isChecked()) {
                    if (resultList.size() >= 2) {
                        resultList.remove(1);
                    }
                }
                if (!rb1.isChecked()) {
                    if (resultList.size() >= 1) {
                        resultList.remove(0);
                    }
                }

                if (!cb9.isChecked()) {
                    if (bigResultList.size() >= 9) {
                        bigResultList.remove(8);
                    }
                }
                if (!cb8.isChecked()) {
                    if (bigResultList.size() >= 8) {
                        bigResultList.remove(7);
                    }
                }
                if (!cb7.isChecked()) {
                    if (bigResultList.size() >= 7) {
                        bigResultList.remove(6);
                    }
                }
                if (!cb6.isChecked()) {
                    if (bigResultList.size() >= 6) {
                        bigResultList.remove(5);
                    }
                }
                if (!cb5.isChecked()) {
                    if (bigResultList.size() >= 5) {
                        bigResultList.remove(4);
                    }
                }
                if (!cb4.isChecked()) {
                    if (bigResultList.size() >= 4) {
                        bigResultList.remove(3);
                    }
                }
                if (!cb3.isChecked()) {
                    if (bigResultList.size() >= 3) {
                        bigResultList.remove(2);
                    }
                }
                if (!cb2.isChecked()) {
                    if (bigResultList.size() >= 2) {
                        bigResultList.remove(1);
                    }
                }
                if (!cb1.isChecked()) {
                    if (bigResultList.size() >= 1) {
                        bigResultList.remove(0);
                    }
                }


                String userCodes = "";
                if (resultList.size() == 0) {
                    userCodes = resultList1.toString();
                    userCodes = userCodes.toString().replace("[", "");
                    userCodes = userCodes.toString().replace("]", "");
                } else {
                    userCodes = resultList.toString();
                    userCodes = userCodes.toString().replace("[", "");
                    userCodes = userCodes.toString().replace("]", "");
                }

                if (bigResultList.size() == 0 && bigResultList1.size() != 0) {
                    Looper.prepare();
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(FlowEMainatinWillDetailActivity.this, "请选择审批人", Toast.LENGTH_SHORT).show();
                    Looper.loop();
                } else {
                    String bigUserCodes = bigResultList.toString();
                    bigUserCodes = bigUserCodes.toString().replace("[", "");
                    bigUserCodes = bigUserCodes.toString().replace("]", "");

                    if (!bigUserCodes.equals("") && !userCodes.equals("")) {
                        flowAssignld = leader + ":" + role + "|" + bigUserCodes + ":" + userCodes;
                        flowAssignld = flowAssignld.replace(" ", "");
                        flowAssignld = flowAssignld.replace(":|", "|");
                    } else if (!bigUserCodes.equals("") && userCodes.equals("")) {
                        flowAssignld = leader + ":" + role + "|" + bigUserCodes;
                        flowAssignld = flowAssignld.replace(" ", "");
                        flowAssignld = flowAssignld.replace(":|", "|");
                    } else {
                        flowAssignld = destName + "|" + userCodes;
                        flowAssignld = flowAssignld.replace(" ", "");
                        flowAssignld = flowAssignld.replace(":|", "|");
                        flowAssignld = flowAssignld.replace(":", "");
                    }
                }

                String url = Constant.BASE_URL2 + Constant.EXAMINEDATA;
                DBHandler dbA = new DBHandler();
                if (wxryreout.equals("2") && !date.equals("")) {
                    upData = dbA.OAEMaintainder1(url, department, time, data, userCode, destName, taskId, flowAssignld, mainId,
                            bxbmyj, wxbmyj, wxryyj, wxqkyj, sbsyryj, wxfkyj, serialNumber, comment, date, signaName);
                } else {
                    upData = dbA.OAEMaintainder(url, department, time, data, userCode, destName, taskId, flowAssignld, mainId,
                            bxbmyj, wxbmyj, wxryyj, wxqkyj, sbsyryj, wxfkyj, serialNumber, comment, signaName);
                }
                if (upData.equals("")) {
                    handler.sendEmptyMessage(TAG_THERE);
                } else {
                    handler.sendEmptyMessage(TAG_FOUR);
                }
            }
        }).start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 333:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(FlowEMainatinWillDetailActivity.this, getResources().getString(R.string.c_success), Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case 444:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(FlowEMainatinWillDetailActivity.this, getResources().getString(R.string.c_false), Toast.LENGTH_SHORT).show();
                    break;
                case 111:
                    Gson gsonF = new Gson();
                    FlowMessage1 beanF = gsonF.fromJson(flowMessage, FlowMessage1.class);
                    for (int i = 0; i < beanF.getData().size(); i++) {
                        flowList.add(beanF.getData().get(i));
                    }
                    adapter = new FlowMessageAdapter(FlowEMainatinWillDetailActivity.this, flowList);
                    recyclerView.setAdapter(adapter);
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_ONE:
                    Gson gson = new Gson();
                    FlowEMaintainWillDetail bean = gson.fromJson(res, FlowEMaintainWillDetail.class);
                    if (bean.isRevoke()) {
                        Toast.makeText(FlowEMainatinWillDetailActivity.this, "当前流程已被追回", Toast.LENGTH_SHORT).show();
                    }
                    taskId = bean.getTaskId();
                    final String date = bean.getMainform().get(0).getBaoXiuShiJian();
                    final String department = bean.getMainform().get(0).getBaoXiuBuMen();
                    final String data = bean.getMainform().get(0).getGuZhangQingKuang();
                    xiangguanfujian = bean.getMainform().get(0).getXiangGuanFuJian();
                    if (xiangguanfujian.equals("")) {
                        llData.setVisibility(View.GONE);
                    } else {
                        tvData.setText(xiangguanfujian);
                    }
                    runID = bean.getMainform().get(0).getRunId();
                    tvTime.setText(date);
                    tvShiXiang.setText(data);
                    tvDpartment.setText(department);
                    tvData.setText(xiangguanfujian);

                    bxbmyj = bean.getMainform().get(0).getBmfzryj();
                    wxbmyj = bean.getMainform().get(0).getXxjsbyj();
                    wxryyj = bean.getMainform().get(0).getWeiXiuRenYuanQianZi();
                    wxqkyj = bean.getMainform().get(0).getBjap();
                    sbsyryj = bean.getMainform().get(0).getSheBeiShiYongRenQianZi();
                    wxfkyj = bean.getMainform().get(0).getBjpj();
                    final String data1 = bean.getMainform().get(0).getWeiXiuShiJian();

                    mainId = String.valueOf(bean.getMainform().get(0).getMainId());
                    for (int i = 0; i < bean.getTrans().size(); i++) {
                        beanList.add(bean.getTrans().get(i));
                    }
                    String formRights = bean.getFormRights();
                    try {
                        JSONObject jsonObject = new JSONObject(formRights);
                        bxbmreout = jsonObject.getString("bmfzryj");
                        wxbmreout = jsonObject.getString("xxjsbyj");
                        wxryreout = jsonObject.getString("WeiXiuRenYuanQianZi");
                        wxqkreout = jsonObject.getString("bjap");
                        sbsyrreout = jsonObject.getString("SheBeiShiYongRenQianZi");
                        wxfkreout = jsonObject.getString("bjpj");
                        if (bxbmreout.equals("2")) {
                            tvLeader.setVisibility(View.GONE);
                            etLeader.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader.setVisibility(View.VISIBLE);
                            etLeader.setVisibility(View.GONE);
                            tvLeaderW.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }
                        if (wxbmreout.equals("2")) {
                            tvLeader1.setVisibility(View.GONE);
                            etLeader1.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader1.setVisibility(View.VISIBLE);
                            etLeader1.setVisibility(View.GONE);
                            tvLeader1W.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }
                        if (wxryreout.equals("2")) {
                            tvLeader2.setVisibility(View.GONE);
                            etLeader2.setVisibility(View.VISIBLE);
//                            tvDate1.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader2.setVisibility(View.VISIBLE);
                            etLeader2.setVisibility(View.GONE);
                            tvLeader2W.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }
                        if (wxqkreout.equals("2")) {
                            tvLeader3.setVisibility(View.GONE);
                            etLeader3.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader3.setVisibility(View.VISIBLE);
                            etLeader3.setVisibility(View.GONE);
                            tvLeader3W.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }
                        if (sbsyrreout.equals("2")) {
                            tvLeader4.setVisibility(View.GONE);
                            etLeader4.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader4.setVisibility(View.VISIBLE);
                            etLeader4.setVisibility(View.GONE);
                            tvLeader4W.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }
                        if (wxfkreout.equals("2")) {
                            tvLeader5.setVisibility(View.GONE);
                            etLeader5.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader5.setVisibility(View.VISIBLE);
                            etLeader5.setVisibility(View.GONE);
                            tvLeader5W.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }
                        bxbmreout = jsonObject.getString("bmfzryj");
                        wxbmreout = jsonObject.getString("xxjsbyj");
                        wxryreout = jsonObject.getString("WeiXiuRenYuanQianZi");
                        wxqkreout = jsonObject.getString("bjap");
                        sbsyrreout = jsonObject.getString("SheBeiShiYongRenQianZi");
                        wxfkreout = jsonObject.getString("bjpj");
                        if (bxbmreout.equals("1") && wxbmreout.equals("1") && wxryreout.equals("1")
                                && wxqkreout.equals("1") && sbsyrreout.equals("1") && wxfkreout.equals("1")) {
                            Toast.makeText(FlowEMainatinWillDetailActivity.this, "您对当前流程只有读取权限", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    String word3 = "";
                    if (wxfkyj != null && !wxfkyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(wxfkyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word3 = word3 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader5.getVisibility() == View.VISIBLE) {
                            tvLeader5.setText(word3);
                        } else {
                            etLeader5.setHint(word3);
                        }
                    }

                    if (sbsyryj != null && !sbsyryj.equals("")) {
                        if (tvLeader4.getVisibility() == View.VISIBLE) {
//                            String word3 = "";
//                            try {
//                                JSONArray jsonArray = new JSONArray(sbsyryj);
//                                JSONObject jsonObject = jsonArray.getJSONObject(jsonArray.length() - 1);
//                                word3 = jsonObject.getString("v");
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
                            tvLeader4.setText(sbsyryj);
                        }
                    }

                    String word2 = "";
                    if (wxqkyj != null && !wxqkyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(wxqkyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word2 = word2 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\t";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader3.getVisibility() == View.VISIBLE) {
                            tvLeader3.setText(word2);
                        } else {
                            etLeader3.setHint(word2);
                        }
                    }

                    if (wxryyj != null && !wxryyj.equals("")) {
                        if (tvLeader2.getVisibility() == View.VISIBLE) {
//                            String word1 = "";
//                            try {
//                                JSONArray jsonArray = new JSONArray(wxryyj);
//                                JSONObject jsonObject = jsonArray.getJSONObject(jsonArray.length() - 1);
//                                word1 = jsonObject.getString("v");
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
                            tvLeader2.setText(wxryyj);
                            if (!data1.equals("")) {
                                tvDate1.setText(data1);
//                                tvDate1.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    String word1 = "";
                    if (wxbmyj != null && !wxbmyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(wxbmyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word1 = word1 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\t";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader1.getVisibility() == View.VISIBLE) {
                            tvLeader1.setText(word1);
                        } else {
                            etLeader1.setHint(word1);
                        }
                    }
                    String word = "";
                    if (bxbmyj != null && !bxbmyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(bxbmyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word = word + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\t";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader.getVisibility() == View.VISIBLE) {
                            tvLeader.setText(word);
                        } else {
                            etLeader.setHint(word);
                        }
                    }
                    if (bean.isRevoke()) {
                        Toast.makeText(FlowEMainatinWillDetailActivity.this, "当前流程已被追回", Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    if (beanList.size() == 1) {
                        btnT.setVisibility(View.GONE);
                        tvText.setVisibility(View.GONE);
                        ProgressDialogUtil.startLoad(FlowEMainatinWillDetailActivity.this, "获取审核人");
                        getAppRovePerson();
                    }else {
                        tvspr.setText("请点击“+”选择路径");
                    }
                    break;
                case TAG_TWO:
                    Toast.makeText(FlowEMainatinWillDetailActivity.this, "操作数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_THERE:
                    Toast.makeText(FlowEMainatinWillDetailActivity.this, "提交数据成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case TAG_FOUR:
                    Toast.makeText(FlowEMainatinWillDetailActivity.this, upData, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_FIVE:
                    getNoEndPerson();
                    break;
                case TAG_SIX:
                    getNextPerson();
                    break;
                case TAG_SEVEN:
                    bigNametemp = null;
                    bigCodetemp = null;
                    Gson gson1 = new Gson();
                    FlowContractPerson bean1 = gson1.fromJson(qianzhiData, FlowContractPerson.class);
                    if (bean1.getData() != null) {
                        if (bean1.getData().size() > 1) {
                            role = bean1.getData().get(1).getRole();
                            userCode = bean1.getData().get(1).getUserNames();
                            userName = bean1.getData().get(1).getUserCodes();
                            nametemp = userName.split(",");
                            codetemp = userCode.split(",");
                        }
                        leader = bean1.getData().get(0).getRole();
                        leaderCode = bean1.getData().get(0).getUserNames();
                        leaderName = bean1.getData().get(0).getUserCodes();
                        bigNametemp = leaderName.split(",");
                        bigCodetemp = leaderCode.split(",");
                    }
                    setCbRbVer();
                    break;
                case TAG_EIGHT:
                    Toast.makeText(FlowEMainatinWillDetailActivity.this, "流程已到最后一步，请提交", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_NINE:
                    Gson gson2 = new Gson();
                    Filed filed = gson2.fromJson(downloadData, Filed.class);
                    String filePath = filed.getData().getFilePath();
                    String url = Constant.FIELDETAIL + filePath;
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    break;
            }
        }
    };

}
