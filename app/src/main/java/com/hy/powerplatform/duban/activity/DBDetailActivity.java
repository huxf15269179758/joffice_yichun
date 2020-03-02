package com.hy.powerplatform.duban.activity;

import android.content.Intent;
import android.net.Uri;
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
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.duban.bean.DBFile;
import com.hy.powerplatform.duban.bean.DBList;
import com.hy.powerplatform.duban.bean.DBList1;
import com.hy.powerplatform.duban.bean.DBUp;
import com.hy.powerplatform.duban.bean.DBUp1;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBack;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerMin;
import com.hy.powerplatform.oa_flow.bean.Filed;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_EIGHT;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SEVEN;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SIX;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class DBDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvType)
    TextView tvType;
    @BindView(R.id.tvRW)
    TextView tvRW;
    @BindView(R.id.tvJHWCSJ)
    TextView tvJHWCSJ;
    @BindView(R.id.tvContent)
    TextView tvContent;
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
    String data = "";
    String status = "";
    @BindView(R.id.btnBJ)
    Button btnBJ;
    @BindView(R.id.btnTJ)
    Button btnTJ;
    @BindView(R.id.btnFB)
    Button btnFB;
    @BindView(R.id.spinnerType)
    Spinner spinnerType;
    @BindView(R.id.etRW)
    EditText etRW;
    @BindView(R.id.etContent)
    EditText etContent;
    private OkHttpUtil httpUtil;
    DBFile beanfj = null;
    String workId = "";
    String fileName = "";
    String downloadData = "";
    String userName = "",userCode = "";
    String ZXName = "",ZXCode = "";
    String lxrName = "",lxrCode = "";
    AlertDialogUtil alertDialogUtil;
    List<String> listType = new ArrayList<String>();
    List<DBFile.DataBean.SuperWorkTaskFilesBean> dataList = new ArrayList<>();
    List<String> dataListName = new ArrayList<>();
    private CustomDatePickerMin customDatePicker1;
    private CustomDatePickerDay customDatePicker2;
    String path_url = Constant.BASE_URL1 + Constant.DBDEL;
    String path_urlbj = Constant.BASE_URL1 + Constant.DBQRBJ;
    String path_urltj = Constant.BASE_URL1 + Constant.DBQRTJ;
    String path_urlfb = Constant.BASE_URL1 + Constant.DBQRFB;
    String path_urlfj = Constant.BASE_URL1 + Constant.DBXQFJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        alertDialogUtil = new AlertDialogUtil(this);
        httpUtil = OkHttpUtil.getInstance(this);
        Intent intent = getIntent();
        DBList1.ResultBean bean = (DBList1.ResultBean) intent.getSerializableExtra("bean");
        status = String.valueOf(bean.getTaskStatus());
        tvType.setText(bean.getTaskType());
        if (status.equals("1")){
            etRW.setVisibility(View.VISIBLE);
            tvRW.setVisibility(View.GONE);
            etRW.setText(bean.getTaskName());
        }else {
            tvRW.setText(bean.getTaskName());
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String planTime = format.format(new Date(bean.getPlanFinishTime().getTime()));
        tvJHWCSJ.setText(planTime);
        if (status.equals("1")){
            etContent.setVisibility(View.VISIBLE);
            tvContent.setVisibility(View.GONE);
            etContent.setText(bean.getTaskContext());
        }else {
            tvContent.setText(bean.getTaskContext());
        }
        lxrName = bean.getContactsName();
        lxrCode = bean.getContactsId();
        tvDBR.setText(bean.getSupervisorNames());
        tvZXR.setText(bean.getOperatorNames());
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String approveTime = format1.format(new Date(bean.getApproveTime().getTime()));
        tvJHWCSJ.setText(planTime);
        tvFBSJ.setText(approveTime);
        tvLXR.setText(bean.getContactsName());
//        tvFJ.setText(bean.getFileNames() + "");
        workId = String.valueOf(bean.getWorkId());
        userName = bean.getSupervisorNames();
        userCode = bean.getSupervisorIds();
        ZXName = bean.getOperatorNames();
        ZXCode = bean.getOperatorIds();
        workId = bean.getWorkId();
        if (status.equals("1")) {
            btnFB.setVisibility(View.GONE);
        } else if (status.equals("2")) {
            btn.setVisibility(View.GONE);
            btnBJ.setVisibility(View.GONE);
            btnTJ.setVisibility(View.GONE);
        } else {
            btn.setVisibility(View.GONE);
            btnBJ.setVisibility(View.GONE);
            btnTJ.setVisibility(View.GONE);
            btnFB.setVisibility(View.GONE);
        }

        initDatePicker();

        listType.add("公司任务");
        listType.add("部门任务");
        ArrayAdapter adapterType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listType);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapterType);
        getFile();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_dndetail;
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
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        Calendar c = Calendar.getInstance();
//        //过去七天
//        c.setTime(new Date());
//        c.add(Calendar.DATE, +1);
//        Date d = c.getTime();
//        String day = format.format(d);
//        tvJHWCSJ.setText(day);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
//        String now = sdf.format(new Date());
//        tvFBSJ.setText(now.split(" ")[0]);

        customDatePicker1 = new CustomDatePickerMin(this, new CustomDatePickerMin.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvJHWCSJ.setText(time);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(true); // 不显示时和分
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

    /**
     * 查看附件
     */
    private void getFile() {
        HashMap<String, String> mapbj = new HashMap();
        mapbj.put("workId", workId);
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.up_data));
        httpUtil.postForm(path_urlfj, mapbj, new OkHttpUtil.ResultCallback() {
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
                message.what = Constant.TAG_SIX;
                handler.sendMessage(message);
            }
        });
    }


    @OnClick({R.id.tvFJ, R.id.btn, R.id.btnBJ, R.id.btnTJ, R.id.btnFB,R.id.tvType
            , R.id.tvJHWCSJ, R.id.tvDBR, R.id.tvZXR, R.id.tvFBSJ})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvFJ:
                onLookFile();
                break;
            case R.id.tvType:
                if (status.equals("1")){
                    tvType.setVisibility(View.GONE);
                    spinnerType.setVisibility(View.VISIBLE);
                    spinnerType.performClick();
                }
                break;
            case R.id.tvJHWCSJ:
                if (status.equals("1")){
                    customDatePicker1.show(tvJHWCSJ.getText().toString().split(":")[0]+":"+tvJHWCSJ.getText().toString().split(":")[1]);
                }
                break;
            case R.id.tvDBR:
                if (status.equals("1")) {
                    Intent intent = new Intent(this, DBCheckPersonActivity.class);
                    startActivityForResult(intent, TAG_FIVE);
                }
                break;
            case R.id.tvZXR:
                if (status.equals("1")) {
                    Intent intent1 = new Intent(this, DBCheckPersonActivity1.class);
                    startActivityForResult(intent1, TAG_SIX);
                }
                break;
            case R.id.tvFBSJ:
                if (status.equals("1")) {
                    customDatePicker2.show(tvFBSJ.getText().toString());
                }
                break;
            case R.id.btnBJ:
                if (etRW.getText().toString().equals("")){
                    Toast.makeText(this, "督办任务不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etContent.getText().toString().equals("")){
                    Toast.makeText(this, "督办内容不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvDBR.getText().toString().equals("")){
                    Toast.makeText(this, "督办任务不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvZXR.getText().toString().equals("")){
                    Toast.makeText(this, "执行人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvLXR.getText().toString().equals("")){
                    Toast.makeText(this, "联系人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                HashMap<String, String> mapbj = new HashMap();
                mapbj.put("superWorkTask.taskType", spinnerType.getSelectedItem().toString().trim());
                mapbj.put("superWorkTask.taskName", etRW.getText().toString().trim());
                mapbj.put("superWorkTask.planFinishTime", tvJHWCSJ.getText().toString().toString()+":00");
                mapbj.put("superWorkTask.taskContext", etContent.getText().toString().trim());
                mapbj.put("superWorkTask.supervisorIds", userCode);
                mapbj.put("superWorkTask.supervisorNames", userName);
                mapbj.put("superWorkTask.operatorIds", ZXCode);
                mapbj.put("superWorkTask.operatorNames", ZXName);
                mapbj.put("superWorkTask.contactsName", lxrName);
                mapbj.put("superWorkTask.contactsId", lxrCode);
                mapbj.put("superWorkTask.workId", workId);
                ProgressDialogUtil.startLoad(this, getResources().getString(R.string.up_data));
                httpUtil.postForm(path_urlbj, mapbj, new OkHttpUtil.ResultCallback() {
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
                        message.what = TAG_THERE;
                        handler.sendMessage(message);
                    }
                });
                break;
            case R.id.btnTJ:
                HashMap<String, String> maptj = new HashMap();
                maptj.put("workId", workId);
                maptj.put("superWorkTask.workId", workId);
                maptj.put("superWorkTask.taskType", spinnerType.getSelectedItem().toString().trim());
                maptj.put("superWorkTask.taskName", etRW.getText().toString().trim());
                maptj.put("superWorkTask.planFinishTime", tvJHWCSJ.toString());
                maptj.put("superWorkTask.taskContext", etContent.getText().toString().trim());
                maptj.put("superWorkTask.supervisorIds", userCode);
                maptj.put("superWorkTask.supervisorNames", userName);
                maptj.put("superWorkTask.operatorIds", ZXCode);
                maptj.put("superWorkTask.operatorNames", ZXName);
                maptj.put("superWorkTask.contactsName", lxrName);
                maptj.put("superWorkTask.contactsId", lxrCode);
                httpUtil.postForm(path_urltj, maptj, new OkHttpUtil.ResultCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Message message = new Message();
                        Bundle b = new Bundle();
                        b.putString("error", e.toString());
                        message.setData(b);
                        message.what = Constant.TAG_ONE;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        String dataTJ = response.body().string();
                        Message message = new Message();
                        Bundle b = new Bundle();
                        b.putString("dataTJ", dataTJ);
                        message.setData(b);
                        message.what = TAG_FOUR;
                        handler.sendMessage(message);
                    }
                });
                break;
            case R.id.btnFB:
                HashMap<String, String> mapfb = new HashMap();
                mapfb.put("ids", workId);
                httpUtil.postForm(path_urlfb, mapfb, new OkHttpUtil.ResultCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Message message = new Message();
                        Bundle b = new Bundle();
                        b.putString("error", e.toString());
                        message.setData(b);
                        message.what = Constant.TAG_ONE;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        String dataFB = response.body().string();
                        Message message = new Message();
                        Bundle b = new Bundle();
                        b.putString("dataFB", dataFB);
                        message.setData(b);
                        message.what = Constant.TAG_FIVE;
                        handler.sendMessage(message);
                    }
                });
                break;
            case R.id.btn:
                HashMap<String, String> map = new HashMap();
                map.put("ids", workId);
                ProgressDialogUtil.startLoad(this, getResources().getString(R.string.up_data));
                httpUtil.postForm(path_url, map, new OkHttpUtil.ResultCallback() {
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
                        message.what = TAG_TWO;
                        handler.sendMessage(message);
                    }
                });
                break;
        }
    }

    /**
     * 查看附件
     */
    private void onLookFile() {
        if (beanfj.getData().getSuperWorkTaskFiles()!=null&&beanfj.getData().getSuperWorkTaskFiles().size() == 1) {
            String id = beanfj.getData().getSuperWorkTaskFiles().get(0).getFileId();
            final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    DBHandler dbA = new DBHandler();
                    downloadData = dbA.OAQingJiaMyDetail(url);
                    if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                        handler.sendEmptyMessage(TAG_SEVEN);
                    } else {
                        handler.sendEmptyMessage(TAG_EIGHT);
                    }
                }
            }).start();
        } else if (beanfj.getData().getSuperWorkTaskFiles()!=null&&beanfj.getData().getSuperWorkTaskFiles().size() > 1) {
            MyAlertDialog.MyListAlertDialog(this, dataListName, new AlertDialogCallBackP() {
                @Override
                public void oneselect(final String data1) {
                    String id = "";
                    for (int i = 0;i<dataList.size();i++){
                        if (dataList.get(i).getFileName().equals(data1)){
                            id = dataList.get(i).getFileId();
                        }
                    }
                    final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            DBHandler dbA = new DBHandler();
                            downloadData = dbA.OAQingJiaMyDetail(url);
                            if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                                handler.sendEmptyMessage(TAG_SEVEN);
                            } else {
                                handler.sendEmptyMessage(TAG_EIGHT);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constant.TAG_FIVE:
                if (resultCode == Constant.TAG_SIX) {
                    userName = data.getStringExtra("name");
                    userCode = data.getStringExtra("userCode");
                    tvDBR.setText(userName);
                    Log.e("userName",userName);
                }
                break;
            case Constant.TAG_SIX:
                if (resultCode == Constant.TAG_SEVEN) {
                    ZXName = data.getStringExtra("name");
                    ZXCode = data.getStringExtra("userCode");
                    tvZXR.setText(ZXName);
                    Log.e("ZXName",ZXName);
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
                    Toast.makeText(DBDetailActivity.this, error, Toast.LENGTH_SHORT).show();
                    break;
                case TAG_TWO:
                    Bundle b1 = msg.getData();
                    String data = b1.getString("data");
                    Gson gsonF = new Gson();
                    DBUp1 bean = gsonF.fromJson(data, DBUp1.class);
                    if (bean.isSuccess()) {
                        Toast.makeText(DBDetailActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case TAG_THERE:
                    Bundle Bundlebj = msg.getData();
                    String databj = Bundlebj.getString("data");
                    Gson gsonbj = new Gson();
                    final DBUp beanbj = gsonbj.fromJson(databj, DBUp.class);
                    workId = beanbj.getWorkId();
                    if (beanbj.isSuccess()){
                        Toast.makeText(DBDetailActivity.this, "确认编辑成功", Toast.LENGTH_SHORT).show();
                        alertDialogUtil.showDialog1("您确定要提交数据吗", new AlertDialogCallBack() {
                            @Override
                            public void select(String data) {

                            }

                            @Override
                            public void confirm() {
                                HashMap<String, String> map = new HashMap();
                                map.put("workId", workId);
                                map.put("superWorkTask.workId", beanbj.getWorkId());
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
                                httpUtil.postForm(path_urltj, map, new OkHttpUtil.ResultCallback() {
                                    @Override
                                    public void onError(Request request, Exception e) {
                                        Message message = new Message();
                                        Bundle b = new Bundle();
                                        b.putString("error", e.toString());
                                        message.setData(b);
                                        message.what = Constant.TAG_ONE;
                                        handler.sendMessage(message);
                                    }

                                    @Override
                                    public void onResponse(Response response) throws IOException {
                                        String dataTJ = response.body().string();
                                        Message message = new Message();
                                        Bundle b = new Bundle();
                                        b.putString("dataTJ", dataTJ);
                                        message.setData(b);
                                        message.what = Constant.TAG_FOUR;
                                        handler.sendMessage(message);
                                    }
                                });
                            }

                            @Override
                            public void cancel() {
                                ProgressDialogUtil.stopLoad();
                                finish();
                            }
                        });
                    }
                    break;
                case TAG_FOUR:
                    Bundle bundletj = msg.getData();
                    String datatj = bundletj.getString("dataTJ");
                    Gson gsontj = new Gson();
                    DBUp1 beantj = gsontj.fromJson(datatj, DBUp1.class);
                    if (beantj.isSuccess()){
                        Toast.makeText(DBDetailActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                        alertDialogUtil.showDialog1("您确定要发布数据吗", new AlertDialogCallBack() {
                            @Override
                            public void select(String data) {

                            }

                            @Override
                            public void confirm() {
                                HashMap<String, String> map = new HashMap();
                                map.put("ids", workId);
                                httpUtil.postForm(path_urlfb, map, new OkHttpUtil.ResultCallback() {
                                    @Override
                                    public void onError(Request request, Exception e) {
                                        Message message = new Message();
                                        Bundle b = new Bundle();
                                        b.putString("error", e.toString());
                                        message.setData(b);
                                        message.what = Constant.TAG_ONE;
                                        handler.sendMessage(message);
                                    }

                                    @Override
                                    public void onResponse(Response response) throws IOException {
                                        String dataFB = response.body().string();
                                        Message message = new Message();
                                        Bundle b = new Bundle();
                                        b.putString("dataFB", dataFB);
                                        message.setData(b);
                                        message.what = TAG_FIVE;
                                        handler.sendMessage(message);
                                    }
                                });
                            }

                            @Override
                            public void cancel() {
                                ProgressDialogUtil.stopLoad();
                                finish();
                            }
                        });
                    }
                    break;
                case Constant.TAG_FIVE:
                    Bundle bundlefb = msg.getData();
                    String datafb = bundlefb.getString("dataFB");
                    Gson gsonfb = new Gson();
                    DBUp1 beanfb = gsonfb.fromJson(datafb, DBUp1.class);
                    if (beanfb.isSuccess()){
                        Toast.makeText(DBDetailActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    break;
                case Constant.TAG_SIX:
                    Bundle bundlefj = msg.getData();
                    String datafj = bundlefj.getString("data");
                    Gson gsonfj = new Gson();
                    beanfj = gsonfj.fromJson(datafj, DBFile.class);
                    if (beanfj.isSuccess()){
                        for (int i = 0;i<beanfj.getData().getSuperWorkTaskFiles().size();i++){
                            if (fileName.equals("")){
                                fileName = beanfj.getData().getSuperWorkTaskFiles().get(i).getFileName();
                            }else {
                                fileName = fileName+"\n"+beanfj.getData().getSuperWorkTaskFiles().get(i).getFileName();
                            }
                            dataList.add(beanfj.getData().getSuperWorkTaskFiles().get(i));
                            dataListName.add(beanfj.getData().getSuperWorkTaskFiles().get(i).getFileName());
                        }
                    }
                    tvFJ.setText(fileName);
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_SEVEN:
                    Toast.makeText(DBDetailActivity.this, "操作数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_EIGHT:
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
