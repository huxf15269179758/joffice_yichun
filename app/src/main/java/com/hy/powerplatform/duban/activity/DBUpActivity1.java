package com.hy.powerplatform.duban.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.bean.CheckPerson;
import com.hy.powerplatform.business_inspect.bean.Person;
import com.hy.powerplatform.business_inspect.newactivity.CheckPersonActivity;
import com.hy.powerplatform.business_inspect.newactivity.CheckPersonActivity1;
import com.hy.powerplatform.business_inspect.presenter.CheckPersonPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CheckPersonPresenterimpl;
import com.hy.powerplatform.business_inspect.view.CheckPersonView;
import com.hy.powerplatform.duban.bean.DBGuanLi;
import com.hy.powerplatform.duban.bean.DBUp;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SIX;

public class DBUpActivity1 extends BaseActivity implements CheckPersonView {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.spinnerType)
    Spinner spinnerType;
    @BindView(R.id.etRW)
    EditText etRW;
    @BindView(R.id.tvJHWCSJ)
    TextView tvJHWCSJ;
    @BindView(R.id.etContent)
    EditText etContent;
    @BindView(R.id.tvDBR)
    TextView tvDBR;
    @BindView(R.id.tvZXR)
    TextView tvZXR;
    @BindView(R.id.tvFBSJ)
    TextView tvFBSJ;
    @BindView(R.id.tvLXR)
    TextView tvLXR;
    @BindView(R.id.tvFJ)
    TextView tvFJ;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tvType)
    TextView tvType;

    String data = "";
    String WorkId = "";
    String rights, userStatus;
    String userName = "", userCode = "";
    String ZXName = "", ZXCode = "";
    String lxrName = "", lxrCode = "";
    private OkHttpUtil httpUtil;
    AlertDialogUtil alertDialogUtil;
    List<String> listType = new ArrayList<String>();
    CheckPersonPresenter checkPersonPresenter;
    SharedPreferencesHelper sharedPreferencesHelper;
    private List<Person> morenDatas = new ArrayList<>();
    List<CheckPerson.DataBean> checkList = new ArrayList<>();
//    String path_url = Constant.BASE_URL1 + Constant.DBQRBJ;
//    String path_url1 = Constant.BASE_URL1 + Constant.DBQRTJ;
    String path_url2 = Constant.BASE_URL1 + Constant.DBQRFB+"?ident=0";
    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        rights = new SharedPreferencesHelper(this, "login").getData(this, "rights", "");
        userStatus = new SharedPreferencesHelper(this, "login").getData(this, "userStatus", "");
        Intent intent = getIntent();
        DBGuanLi.ResultBean detaBean = (DBGuanLi.ResultBean) intent.getSerializableExtra("bean");
        alertDialogUtil = new AlertDialogUtil(this);
        listType.add("公司任务");
        listType.add("部门任务");
        ArrayAdapter adapterType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listType);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapterType);

        sharedPreferencesHelper = new SharedPreferencesHelper(this, "login");
        lxrName = sharedPreferencesHelper.getData(DBUpActivity1.this, "roleName", "");
        lxrCode = sharedPreferencesHelper.getData(DBUpActivity1.this, "userId", "");
        tvLXR.setText(lxrName);
        initDatePicker();

        httpUtil = OkHttpUtil.getInstance(this);
        checkPersonPresenter = new CheckPersonPresenterimpl(this, this);
        Person person = new Person();
        person.setUserCode("9386");
        person.setUserName("王少云");
        morenDatas.add(person);

        Person person1 = new Person();
        person1.setUserCode("9387");
        person1.setUserName("唐根六");
        morenDatas.add(person1);

        Person person3 = new Person();
        person3.setUserCode("9398");
        person3.setUserName("晏慧锋");
        morenDatas.add(person3);
        if (morenDatas.size() != 0) {
            for (int i = 0; i < morenDatas.size(); i++) {
                if (i != morenDatas.size() - 1) {
                    userName = userName + morenDatas.get(i).getUserName() + ",";
                    userCode = userCode + morenDatas.get(i).getUserCode() + ",";
                } else {
                    userName = userName + morenDatas.get(i).getUserName();
                    userCode = userCode + morenDatas.get(i).getUserCode();
                }
            }
        }
        tvDBR.setText(userName);
        sharedPreferencesHelper = new SharedPreferencesHelper(this, "login");

        tvType.setText(detaBean.getTaskType());
        etRW.setText(detaBean.getTaskName());
        if (detaBean.getApproveTime() != null && !detaBean.getApproveTime().equals("")) {
            tvJHWCSJ.setText(detaBean.getApproveTime().split(" ")[0]);
        }
        etContent.setText(detaBean.getTaskContext());
        tvDBR.setText(detaBean.getSupervisorNames());
        tvZXR.setText(detaBean.getOperatorNames());
        tvFBSJ.setText(detaBean.getCreateTime());
        tvLXR.setText(detaBean.getContactsName());
        WorkId = String.valueOf(detaBean.getWorkId());
        ZXCode = detaBean.getOperatorIds();
        ZXName = detaBean.getOperatorNames();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_dbup1;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, +1);
        Date d = c.getTime();
        String day = format.format(d);
        tvJHWCSJ.setText(day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        tvFBSJ.setText(now.split(" ")[0]);

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvJHWCSJ.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvFBSJ.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(false); // 显示时和分
        customDatePicker2.setIsLoop(false); // 允许循环滚动
    }

    @Override
    public void getCheckPersonViewData(CheckPerson checkPerson) {
        for (int i = 0; i < checkPerson.getData().size(); i++) {
            checkList.add(checkPerson.getData().get(i));
        }
        for (int k = 0; k < checkList.size(); k++) {
            if (checkList.get(k).getFullname().equals("王少云") || checkList.get(k).getFullname().equals("唐根六")
                    || checkList.get(k).getFullname().equals("晏慧锋")) {
                Person person = new Person();
                person.setUserCode(checkList.get(k).getProfileId());
                person.setUserName(checkList.get(k).getFullname());
                morenDatas.add(person);
            }
        }
        String roleName1 = sharedPreferencesHelper.getData(this, "roleName", "");
        String userCode1 = sharedPreferencesHelper.getData(this, "userCode", "");
        Person person = new Person();
        person.setUserCode(userCode1);
        person.setUserName(roleName1);
        morenDatas.add(person);
        if (morenDatas.size() != 0) {
            for (int i = 0; i < morenDatas.size(); i++) {
                if (i != morenDatas.size() - 1) {
                    userName = userName + morenDatas.get(i).getUserName() + ",";
                    userCode = userCode + morenDatas.get(i).getUserCode() + ",";
                } else {
                    userName = userName + morenDatas.get(i).getUserName();
                    userCode = userCode + morenDatas.get(i).getUserCode();
                }
            }
        }
        tvDBR.setText(userName);
    }

    @OnClick({R.id.tvJHWCSJ, R.id.tvDBR, R.id.tvZXR, R.id.tvFBSJ, R.id.btn,R.id.tvType})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvType:
                tvType.setVisibility(View.GONE);
                spinnerType.setVisibility(View.VISIBLE);
                spinnerType.performClick();
                break;
            case R.id.tvJHWCSJ:
                customDatePicker1.show(tvJHWCSJ.getText().toString());
                break;
            case R.id.tvDBR:
                Intent intent = new Intent(this, CheckPersonActivity.class);
                startActivityForResult(intent, TAG_FIVE);
                break;
            case R.id.tvZXR:
                Intent intent1 = new Intent(this, CheckPersonActivity1.class);
                startActivityForResult(intent1, TAG_SIX);
                break;
            case R.id.tvFBSJ:
                customDatePicker1.show(tvFBSJ.getText().toString());
                break;
            case R.id.btn:
                if (etRW.getText().toString().equals("")) {
                    Toast.makeText(this, "督办任务不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etContent.getText().toString().equals("")) {
                    Toast.makeText(this, "督办内容不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvDBR.getText().toString().equals("")) {
                    Toast.makeText(this, "督办任务不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvZXR.getText().toString().equals("")) {
                    Toast.makeText(this, "执行人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvLXR.getText().toString().equals("")) {
                    Toast.makeText(this, "联系人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                HashMap<String, String> map = new HashMap();
                map.put("superWorkTask.taskType", spinnerType.getSelectedItem().toString().trim());
                map.put("superWorkTask.taskName", etRW.getText().toString().trim());
                map.put("superWorkTask.planFinishTime", tvJHWCSJ.toString());
                map.put("superWorkTask.taskContext", etContent.getText().toString().trim());
                map.put("superWorkTask.supervisorIds", userCode);
                map.put("superWorkTask.supervisorNames", userName);
                map.put("superWorkTask.operatorIds", ZXCode);
                map.put("superWorkTask.operatorNames", ZXName);
                map.put("superWorkTask.contactsName", lxrName);
                map.put("superWorkTask.contactsId", lxrCode);
                map.put("superWorkTask.taskStatus", "1");
                map.put("superWorkTask.workId", WorkId);
                ProgressDialogUtil.startLoad(this, getResources().getString(R.string.up_data));
                httpUtil.postForm(path_url2, map, new OkHttpUtil.ResultCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
//                Log.i("main", "response:" + e.toString());
                        Message message = new Message();
                        Bundle b = new Bundle();
                        b.putString("error", e.toString());
                        message.setData(b);
                        message.what = Constant.TAG_ONE;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
//                      Log.i("main", "response:" + response.body().string());
                        data = response.body().string();
                        Message message = new Message();
                        Bundle b = new Bundle();
                        b.putString("data", data);
                        message.setData(b);
                        message.what = Constant.TAG_TWO;
                        handler.sendMessage(message);
                    }
                });
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constant.TAG_FIVE:
                if (resultCode == Constant.TAG_SIX) {
                    userName = data.getStringExtra("name");
                    userCode = data.getStringExtra("userCode");
                    tvDBR.setText(userName);
                    Log.e("userName", userName);
                }
                break;
            case Constant.TAG_SIX:
                if (resultCode == Constant.TAG_SEVEN) {
                    ZXName = data.getStringExtra("name");
                    ZXCode = data.getStringExtra("userCode");
                    tvZXR.setText(ZXName);
                    Log.e("ZXName", ZXName);
                }
                break;
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Bundle b = msg.getData();
                    String error = b.getString("error");
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(DBUpActivity1.this, error, Toast.LENGTH_SHORT).show();
                    break;
                case Constant.TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    Gson gsonF = new Gson();
                    final DBUp bean = gsonF.fromJson(data, DBUp.class);
                    WorkId = bean.getWorkId();
                    if (bean.isSuccess()) {
                        ProgressDialogUtil.stopLoad();
                        Toast.makeText(DBUpActivity1.this, "确认发布成功", Toast.LENGTH_SHORT).show();
                        finish();
//                        alertDialogUtil.showDialog1("您确定要提交数据吗", new AlertDialogCallBack() {
//                            @Override
//                            public void select(String data) {
//
//                            }
//
//                            @Override
//                            public void confirm() {
//                                HashMap<String, String> map = new HashMap();
//                                map.put("workId", WorkId);
//                                map.put("superWorkTask.workId", bean.getWorkId());
//                                map.put("superWorkTask.taskType", spinnerType.getSelectedItem().toString().trim());
//                                map.put("superWorkTask.taskName", etRW.getText().toString().trim());
//                                map.put("superWorkTask.planFinishTime", tvJHWCSJ.toString());
//                                map.put("superWorkTask.taskContext", etContent.getText().toString().trim());
//                                map.put("superWorkTask.supervisorIds", userCode);
//                                map.put("superWorkTask.supervisorNames", userName);
//                                map.put("superWorkTask.operatorIds", ZXCode);
//                                map.put("superWorkTask.operatorNames", ZXName);
//                                map.put("superWorkTask.contactsName", lxrName);
//                                map.put("superWorkTask.contactsId", lxrCode);
//                                httpUtil.postForm(path_url1, map, new OkHttpUtil.ResultCallback() {
//                                    @Override
//                                    public void onError(Request request, Exception e) {
//                                        Message message = new Message();
//                                        Bundle b = new Bundle();
//                                        b.putString("error", e.toString());
//                                        message.setData(b);
//                                        message.what = Constant.TAG_ONE;
//                                        handler.sendMessage(message);
//                                    }
//
//                                    @Override
//                                    public void onResponse(Response response) throws IOException {
//                                        String dataTJ = response.body().string();
//                                        Message message = new Message();
//                                        Bundle b = new Bundle();
//                                        b.putString("dataTJ", dataTJ);
//                                        message.setData(b);
//                                        message.what = Constant.TAG_THERE;
//                                        handler.sendMessage(message);
//                                    }
//                                });
//                            }
//
//                            @Override
//                            public void cancel() {
//                                ProgressDialogUtil.stopLoad();
//                                finish();
//                            }
//                        });
                    }
                    break;
//                case Constant.TAG_THERE:
//                    Bundle b2 = msg.getData();
//                    String data2 = b2.getString("dataTJ");
//                    Gson gsonT = new Gson();
//                    DBUp1 bean1 = gsonT.fromJson(data2, DBUp1.class);
//                    if (bean1.isSuccess()) {
//                        Toast.makeText(DBUpActivity1.this, "提交成功", Toast.LENGTH_SHORT).show();
//                        alertDialogUtil.showDialog1("您确定要发布数据吗", new AlertDialogCallBack() {
//                            @Override
//                            public void select(String data) {
//
//                            }
//
//                            @Override
//                            public void confirm() {
//                                HashMap<String, String> map = new HashMap();
//                                map.put("ids", WorkId);
//                                httpUtil.postForm(path_url2, map, new OkHttpUtil.ResultCallback() {
//                                    @Override
//                                    public void onError(Request request, Exception e) {
//                                        Message message = new Message();
//                                        Bundle b = new Bundle();
//                                        b.putString("error", e.toString());
//                                        message.setData(b);
//                                        message.what = Constant.TAG_ONE;
//                                        handler.sendMessage(message);
//                                    }
//
//                                    @Override
//                                    public void onResponse(Response response) throws IOException {
//                                        String dataFB = response.body().string();
//                                        Message message = new Message();
//                                        Bundle b = new Bundle();
//                                        b.putString("dataFB", dataFB);
//                                        message.setData(b);
//                                        message.what = Constant.TAG_FOUR;
//                                        handler.sendMessage(message);
//                                    }
//                                });
//                            }
//
//                            @Override
//                            public void cancel() {
//                                ProgressDialogUtil.stopLoad();
//                                finish();
//                            }
//                        });
//                    }
//                    break;
//                case Constant.TAG_FOUR:
//                    Bundle b3 = msg.getData();
//                    String data3 = b3.getString("dataFB");
//                    Gson gsonFB = new Gson();
//                    DBUp1 bean2 = gsonFB.fromJson(data3, DBUp1.class);
//                    if (bean2.isSuccess()) {
//                        ProgressDialogUtil.stopLoad();
//                        Toast.makeText(DBUpActivity1.this, "提交成功", Toast.LENGTH_SHORT).show();
//                    }
//                    finish();
//                    break;
            }
        }
    };
}
