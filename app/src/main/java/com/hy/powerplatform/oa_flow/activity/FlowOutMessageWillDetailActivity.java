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
import android.util.Log;
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
import com.hy.powerplatform.oa_flow.bean.FlowMessage1;
import com.hy.powerplatform.oa_flow.bean.FlowOutMessage;
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

public class FlowOutMessageWillDetailActivity extends BaseActivity {
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.tvZhuSong)
    TextView tvZhuSong;
    @BindView(R.id.tvChaoBao)
    TextView tvChaoBao;
    @BindView(R.id.tvChaoSong)
    TextView tvChaoSong;
    @BindView(R.id.tvNiGao)
    TextView tvNiGao;
    @BindView(R.id.tvHeGao)
    TextView tvHeGao;
    @BindView(R.id.tvNum)
    TextView tvNum;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
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
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.etLeader)
    EditText etLeader;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.etLeader1)
    EditText etLeader1;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.cb7)
    CheckBox cb7;
    @BindView(R.id.cb8)
    CheckBox cb8;
    @BindView(R.id.cb9)
    CheckBox cb9;
    @BindView(R.id.ll5)
    LinearLayout ll5;
    @BindView(R.id.tvHeGao1)
    TextView etHeGao;
    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.et2)
    EditText et2;
    @BindView(R.id.et3)
    EditText et3;
    @BindView(R.id.tvStartTime1)
    TextView tvStartTime1;
    @BindView(R.id.tv31)
    TextView tv31;
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
    @BindView(R.id.tvLeader4W)
    TextView tvLeader4W;
    @BindView(R.id.tvLeader5W)
    TextView tvLeader5W;
    @BindView(R.id.tvTextNum)
    TextView tvTextNum;
    @BindView(R.id.tvspr)
    TextView tvspr;
    @BindView(R.id.llShenPiRen)
    LinearLayout llShenPiRen;
    @BindView(R.id.llShenPiRenList)
    LinearLayout llShenPiRenList;
    private String name, taskId, res, fullnameUId, fullname, fgldyj, zjl = "";
    private String mainId, signaName, destName, destType, checkTask, qianzhiData = "";
    String leader = "";
    String leaderCode = "";
    String leaderName = "";
    boolean assigned;
    String tag = "noEnd";
    String comment = "";
    String fgreout, zjlreout, hgreout, yffsreout, fwwhreout, fwxhreout, whrqreout, flowAssignld, serialNumber = "";

    String[] bigNametemp = null;
    String[] bigCodetemp = null;
    List<String> resultList = new ArrayList<>();
    List<String> resultList1 = new ArrayList<>();
    List<String> bigResultList = new ArrayList<>();
    List<String> bigResultList1 = new ArrayList<>();

    String role = "";
    String url;
    String userCode = "";
    String userName = "";
    String upData = "";
    String[] nametemp = null;
    String[] codetemp = null;
    List<String> namelist = new ArrayList<>();
    List<FlowOutMessage.TransBean> beanList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    String xiangguanfujian = "";
    String heGao;
    String num;
    String time;
    String xuHao;
    String date;
    String date1;
    String wenHao;
    private CustomDatePickerDay customDatePicker1;
    String tagT = "N";
    String btnTTag = "N";
    String flowMessage = "";
    String runID = "";
    String piId = "";
    String downloadData = "";
    FlowMessageAdapter adapter;
    List<FlowMessage1.DataBean> flowList = new ArrayList<>();
    String tagData = "";
    private String executionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        userName = new SharedPreferencesHelper(this, "login").getData(this, "userStatus", "");
        Intent intent = getIntent();
        name = intent.getStringExtra("activityName");
        taskId = intent.getStringExtra("taskId");
        piId = intent.getStringExtra("piId");
        executionId = intent.getStringExtra("executionId");
        getData(name, taskId);
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvStartTime.setText(now.split(" ")[0]);
        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
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

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_outmessage;
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
                    Toast.makeText(FlowOutMessageWillDetailActivity.this, getResources().getString(R.string.nullify_reason), Toast.LENGTH_SHORT).show();
                } else {
                    dialog.dismiss();
                    ProgressDialogUtil.startLoad(FlowOutMessageWillDetailActivity.this, getResources().getString(R.string.get_data));
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
     * 获取数据
     *
     * @param Name
     * @param taskId
     */
    private void getData(final String Name, final String taskId) {
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
                cb1.setChecked(true);
                cb1.setText(bigNametemp[0]);
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

    @OnClick({R.id.btnUp, R.id.tvData, R.id.btnT, R.id.btnHistory, R.id.llShenPiRen})
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
            case R.id.btnHistory:
                recyclerView.setVisibility(View.VISIBLE);
                ProgressDialogUtil.startLoad(FlowOutMessageWillDetailActivity.this, "获取数据中");
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
                        ProgressDialogUtil.startLoad(FlowOutMessageWillDetailActivity.this, "获取数据中");
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
                        MyAlertDialog.MyListAlertDialog(FlowOutMessageWillDetailActivity.this, namelist, new AlertDialogCallBackP() {
                            @Override
                            public void oneselect(final String data) {
                                ProgressDialogUtil.startLoad(FlowOutMessageWillDetailActivity.this, "获取数据中");
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
                    Toast.makeText(FlowOutMessageWillDetailActivity.this, "审批人为空", Toast.LENGTH_SHORT).show();
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
                Gson gson = new Gson();
                FlowOutMessage bean = gson.fromJson(res, FlowOutMessage.class);
                heGao = bean.getMainform().get(0).getHeGaoRen();
                num = bean.getMainform().get(0).getYinFaFenShu();
                time = bean.getMainform().get(0).getYinFaFenShu();
                xuHao = bean.getMainform().get(0).getFaWenXuHao();
                date = bean.getMainform().get(0).getWenHaoRiQi();
                date1 = bean.getMainform().get(0).getYinFaRiQi();
                wenHao = bean.getMainform().get(0).getFaWenWenHao();
                fgldyj = bean.getMainform().get(0).getFgldyj();
                zjl = bean.getMainform().get(0).getZjlyj();
                userName = new SharedPreferencesHelper(FlowOutMessageWillDetailActivity.this,
                        "login").getData(FlowOutMessageWillDetailActivity.this, "userStatus", "");
                userCode = new SharedPreferencesHelper(FlowOutMessageWillDetailActivity.this,
                        "login").getData(FlowOutMessageWillDetailActivity.this, "userId", "");
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date curDate = new Date(System.currentTimeMillis());
                String str = formatter.format(curDate);
                if (etLeader.getVisibility() == View.VISIBLE) {
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
                    if (fgldyj.equals("")) {
                        fgldyj = jsonArray.toString();
                    } else {
                        fgldyj = fgldyj + "," + jsonArray.toString();
                        fgldyj = fgldyj.toString().replace("],[", ",");
                    }
                }
                if (etLeader1.getVisibility() == View.VISIBLE) {
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
                    if (zjl.equals("")) {
                        zjl = jsonArray.toString();
                    } else {
                        zjl = zjl + "," + jsonArray.toString();
                        zjl = zjl.toString().replace("],[", ",");
                    }
                }
                if (etHeGao.getVisibility() == View.VISIBLE) {
                    comment = etHeGao.getText().toString();
                    heGao = etHeGao.getText().toString();
                }
                if (et1.getVisibility() == View.VISIBLE) {
                    comment = et1.getText().toString();
                    wenHao = et1.getText().toString();
                }
                if (et2.getVisibility() == View.VISIBLE) {
                    comment = et2.getText().toString();
                    xuHao = et2.getText().toString();
                }
                if (et3.getVisibility() == View.VISIBLE) {
                    comment = et3.getText().toString();
                    date1 = et3.getText().toString();
                }
                if (comment.equals("")) {
                    if (et2.getVisibility() == View.VISIBLE) {
                        if (et2.getText().toString().equals("")) {
                            Toast.makeText(this, "请填写文号", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                    if (et3.getVisibility() == View.VISIBLE) {
                        if (et3.getText().toString().equals("")) {
                            Toast.makeText(this, "请填写文号", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }

                    if (!("2").equals(fgreout) && !("2").equals(zjlreout)) {
                        comment = "";
                        personSession();
                    } else if (!etLeader1.getText().toString().equals("") && !fgldyj.equals("")) {
                        comment = "";
                        personSession();
                    } else {
                        Toast.makeText(this, "请签字", Toast.LENGTH_SHORT).show();
                        break;
                    }
                } else {
                    personSession();
                }
                break;
        }
    }

    private void personSession() {
        if (bigResultList.size() != 0) {
            sendData();
        } else {
            if (btnT.getVisibility() == View.VISIBLE) {
                if (btnTTag.equals("N")) {
                    Gson gson = new Gson();
                    FlowOutMessage bean = gson.fromJson(tagData, FlowOutMessage.class);
//                taskId = bean.getTaskId();
                    String title = bean.getMainform().get(0).getFaWenBiaoTi();
                    String zhuSong = bean.getMainform().get(0).getZhuSongRen();
                    String chaoBao = bean.getMainform().get(0).getChaoBaoRen();
                    String chaoSong = bean.getMainform().get(0).getChaoSongRen();
                    String niGao = bean.getMainform().get(0).getNiGaoRen();
                    xiangguanfujian = bean.getMainform().get(0).getFaWenFuJian();
                    tvData.setText(xiangguanfujian);
                    heGao = bean.getMainform().get(0).getHeGaoRen();
                    num = bean.getMainform().get(0).getYinFaFenShu();
                    time = bean.getMainform().get(0).getYinFaFenShu();
                    xuHao = bean.getMainform().get(0).getFaWenXuHao();
                    date = bean.getMainform().get(0).getWenHaoRiQi();
                    date1 = bean.getMainform().get(0).getYinFaRiQi();
                    wenHao = bean.getMainform().get(0).getFaWenWenHao();
                    fgldyj = bean.getMainform().get(0).getFgldyj();
                    zjl = bean.getMainform().get(0).getZjlyj();
                    Toast.makeText(this, "请点击加号选择路径", Toast.LENGTH_SHORT).show();
                } else {
                    sendData();
                }
            } else {
                sendData();
            }
        }
    }

    public void getAppRovePerson() {
        ProgressDialogUtil.startLoad(FlowOutMessageWillDetailActivity.this, "获取数据中");
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
        ProgressDialogUtil.startLoad(FlowOutMessageWillDetailActivity.this, "提交数据中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String title = tvTitle.getText().toString();
                String zhuSong = tvZhuSong.getText().toString();
                String chaoBao = tvChaoBao.getText().toString();
                String chaoSong = tvChaoSong.getText().toString();
                String niGao = tvNiGao.getText().toString();
                String time = tvStartTime.getText().toString();
                final String userCode = new SharedPreferencesHelper(FlowOutMessageWillDetailActivity.this,
                        "login").getData(FlowOutMessageWillDetailActivity.this, "userCode", "");
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
                    Toast.makeText(FlowOutMessageWillDetailActivity.this, "请选择审批人", Toast.LENGTH_SHORT).show();
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
                upData = dbA.OAOutMessageLeader(url, title, zhuSong, chaoBao, chaoSong, niGao, heGao,
                        num, wenHao, date1, xuHao, userCode, destName, taskId, flowAssignld, mainId,
                        fgldyj, zjl, serialNumber, comment, signaName, userName, time);
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
                    Toast.makeText(FlowOutMessageWillDetailActivity.this, getResources().getString(R.string.c_success), Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                case 444:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(FlowOutMessageWillDetailActivity.this, getResources().getString(R.string.c_false), Toast.LENGTH_SHORT).show();
                    break;
                case 111:
                    Gson gsonF = new Gson();
                    FlowMessage1 beanF = gsonF.fromJson(flowMessage, FlowMessage1.class);
                    for (int i = 0; i < beanF.getData().size(); i++) {
                        flowList.add(beanF.getData().get(i));
                    }
                    adapter = new FlowMessageAdapter(FlowOutMessageWillDetailActivity.this, flowList);
                    recyclerView.setAdapter(adapter);
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_ONE:
                    Gson gson = new Gson();
                    FlowOutMessage bean = gson.fromJson(res, FlowOutMessage.class);
                    taskId = bean.getTaskId();
                    String title = bean.getMainform().get(0).getFaWenBiaoTi();
                    String zhuSong = bean.getMainform().get(0).getZhuSongRen();
                    String chaoBao = bean.getMainform().get(0).getChaoBaoRen();
                    String chaoSong = bean.getMainform().get(0).getChaoSongRen();
                    String niGao = bean.getMainform().get(0).getNiGaoRen();
                    xiangguanfujian = bean.getMainform().get(0).getFaWenFuJian();
                    if (xiangguanfujian.equals("")) {
                        llData.setVisibility(View.GONE);
                    } else {
                        tvData.setText(xiangguanfujian);
                    }
                    runID = bean.getMainform().get(0).getRunId();
                    tvData.setText(xiangguanfujian);
                    heGao = bean.getMainform().get(0).getHeGaoRen();
                    num = bean.getMainform().get(0).getYinFaFenShu();
//                    time = bean.getMainform().get(0).getYinFaFenShu();
                    xuHao = bean.getMainform().get(0).getFaWenXuHao();
                    date = bean.getMainform().get(0).getWenHaoRiQi();
                    date1 = bean.getMainform().get(0).getYinFaRiQi();
                    wenHao = bean.getMainform().get(0).getFaWenWenHao();
                    fgldyj = bean.getMainform().get(0).getFgldyj();
                    zjl = bean.getMainform().get(0).getZjlyj();
                    mainId = String.valueOf(bean.getMainform().get(0).getMainId());
                    for (int i = 0; i < bean.getTrans().size(); i++) {
                        beanList.add(bean.getTrans().get(i));
                    }
                    String formRights = bean.getFormRights();
                    try {
                        JSONObject jsonObject = new JSONObject(formRights);
                        fgreout = jsonObject.getString("fgldyj").toString();
                        zjlreout = jsonObject.getString("zjlyj").toString();
                        hgreout = jsonObject.getString("HeGaoRen").toString();
                        yffsreout = jsonObject.getString("YinFaFenShu").toString();
                        fwwhreout = jsonObject.getString("FaWenWenHao").toString();
                        fwxhreout = jsonObject.getString("FaWenXuHao").toString();
                        whrqreout = jsonObject.getString("WenHaoRiQi").toString();

                        tvTitle.setText(title);
                        tvZhuSong.setText(zhuSong);
                        tvChaoBao.setText(chaoBao);
                        tvChaoSong.setText(chaoSong);
                        tvNiGao.setText(niGao);
                        tvHeGao.setText(heGao);
                        tvNum.setText(num);
                        if (date1 != null && !date1.equals("")) {
                            tvStartTime.setText(date1);
                            tvStartTime.setVisibility(View.VISIBLE);
                            tvStartTime1.setVisibility(View.GONE);
                        }
                        tvTextNum.setText(wenHao);
                        tv2.setText(xuHao);
                        if (date != null && !date.equals("")) {
                            tv3.setText(date);
                            tv3.setVisibility(View.VISIBLE);
                            tv31.setVisibility(View.GONE);
                        }

                        if (whrqreout.equals("2")) {
                            tv3.setVisibility(View.GONE);
                            tv31.setVisibility(View.GONE);
                        } else {
//                            tv3.setVisibility(View.VISIBLE);
//                            et3.setVisibility(View.GONE);
                        }

                        if (fwxhreout.equals("2")) {
                            tv2.setVisibility(View.GONE);
                            et2.setVisibility(View.VISIBLE);
                        } else {
                            tv2.setVisibility(View.VISIBLE);
                            et2.setVisibility(View.GONE);
                        }

                        if (fwwhreout.equals("2")) {
                            tv1.setVisibility(View.GONE);
                            et1.setVisibility(View.GONE);
                        } else {
                            tv1.setVisibility(View.GONE);
                            et1.setVisibility(View.GONE);
                            tvLeader5W.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }

                        if (yffsreout.equals("2")) {
                            et3.setVisibility(View.VISIBLE);
                            tvStartTime.setVisibility(View.VISIBLE);
                            tvStartTime1.setVisibility(View.GONE);
                            initDatePicker();
                        } else {
                            tvNum.setVisibility(View.VISIBLE);
                            tvLeader4W.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }

                        if (hgreout.equals("2")) {
                            tvHeGao.setVisibility(View.GONE);
                            etHeGao.setVisibility(View.VISIBLE);
                            if (heGao != null && !heGao.equals("")) {
                                etHeGao.setText(heGao);
                            } else {
                                etHeGao.setText(userName);
                            }
                        } else {
                            tvHeGao.setVisibility(View.VISIBLE);
                            etHeGao.setVisibility(View.GONE);
                            tvLeaderW.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }

                        if (fgreout.equals("2")) {
                            tvLeader.setVisibility(View.GONE);
                            etLeader.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader.setVisibility(View.VISIBLE);
                            etLeader.setVisibility(View.GONE);
                            tvLeader1W.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }
                        if (zjlreout.equals("2")) {
                            tvLeader1.setVisibility(View.GONE);
                            etLeader1.setVisibility(View.VISIBLE);
                        } else {
                            tvLeader1.setVisibility(View.VISIBLE);
                            etLeader1.setVisibility(View.GONE);
                            tvLeader2W.setTextColor(getResources().getColor(R.color.order_stop_black));
                        }
                        if (fgreout.equals("1") && zjlreout.equals("1") && hgreout.equals("1")
                                && yffsreout.equals("1") && fwwhreout.equals("1") && fwxhreout.equals("1")
                                && whrqreout.equals("1")) {
                            Toast.makeText(FlowOutMessageWillDetailActivity.this, "您对当前流程只有读取权限", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    String word6 = "";
                    if (zjl != null && !zjl.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(zjl);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word6 = word6 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader1.getVisibility() == View.VISIBLE) {
                            tvLeader1.setText(word6);
                        } else {
                            etLeader1.setHint(word6);
                        }
                    }
                    String word5 = "";
                    if (fgldyj != null && !fgldyj.equals("")) {
                        try {
                            JSONArray jsonArray = new JSONArray(fgldyj);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                if (!jsonObject.getString("v").toString().equals("")) {
                                    word5 = word5 + jsonObject.getString("v") + "\u3000" + jsonObject.getString("un") + ":" + jsonObject.getString("c") + "\n";
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (tvLeader.getVisibility() == View.VISIBLE) {
                            tvLeader.setText(word5);
                        } else {
                            etLeader.setHint(word5);
                        }
                    }
                    if (heGao != null && !heGao.equals("")) {
                        if (tvHeGao.getVisibility() == View.VISIBLE) {
                            tvHeGao.setText(heGao);
                        }
                    }
                    if (num != null && !num.equals("")) {
                        if (tvNum.getVisibility() == View.VISIBLE) {
                            tvNum.setText(num);
                        }
                    }
                    if (wenHao != null && !wenHao.equals("")) {
                        if (tv1.getVisibility() == View.VISIBLE) {
                            tv1.setText(wenHao);
                        }
                    }
                    if (xuHao != null && !xuHao.equals("")) {
                        if (tv2.getVisibility() == View.VISIBLE) {
                            tv2.setText(xuHao);
                        }
                    }
                    if (date != null && !date.equals("")) {
                        if (tv3.getVisibility() == View.VISIBLE) {
                            tv3.setText(date);
                        }
                    }
                    if (bean.isRevoke()) {
                        Toast.makeText(FlowOutMessageWillDetailActivity.this, "当前流程已被追回", Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    if (beanList.size() == 1) {
                        btnT.setVisibility(View.GONE);
                        tvText.setVisibility(View.GONE);
                        ProgressDialogUtil.startLoad(FlowOutMessageWillDetailActivity.this, "获取审核人");
                        getAppRovePerson();
                    }
                    break;
                case TAG_TWO:
                    Toast.makeText(FlowOutMessageWillDetailActivity.this, "操作数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_THERE:
                    Toast.makeText(FlowOutMessageWillDetailActivity.this, "提交数据成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case TAG_FOUR:
                    Toast.makeText(FlowOutMessageWillDetailActivity.this, upData, Toast.LENGTH_SHORT).show();
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
                    Log.e("XXXXH", qianzhiData);
                    FlowContractPerson bean1 = gson1.fromJson(qianzhiData, FlowContractPerson.class);
                    if (bean1.getData() != null) {
                        if (bean1.getData().size() > 1) {
                            role = bean1.getData().get(1).getRole();
                            userCode = bean1.getData().get(1).getUserNames();
                            userName = bean1.getData().get(1).getUserCodes();
                            nametemp = null;
                            codetemp = null;
                            nametemp = userName.split(",");
                            codetemp = userCode.split(",");
                        }
                        bigNametemp = null;
                        bigCodetemp = null;
                        leader = bean1.getData().get(0).getRole();
                        leaderCode = bean1.getData().get(0).getUserNames();
                        leaderName = bean1.getData().get(0).getUserCodes();
                        bigNametemp = leaderName.split(",");
                        bigCodetemp = leaderCode.split(",");
                    }
                    setCbRbVer();
                    break;
                case TAG_EIGHT:
                    Toast.makeText(FlowOutMessageWillDetailActivity.this, "流程已到最后一步，请提交", Toast.LENGTH_SHORT).show();
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
