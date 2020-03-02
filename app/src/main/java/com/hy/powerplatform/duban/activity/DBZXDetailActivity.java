package com.hy.powerplatform.duban.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.duban.bean.DBFile;
import com.hy.powerplatform.duban.bean.DBTJRCO;
import com.hy.powerplatform.duban.bean.DBUp1;
import com.hy.powerplatform.duban.bean.DBXG;
import com.hy.powerplatform.duban.bean.DBZXList;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.bean.Filed;

import java.io.IOException;
import java.text.ParseException;
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
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SEVEN;

public class DBZXDetailActivity extends BaseActivity {

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
    @BindView(R.id.btnJS)
    Button btnJS;
    @BindView(R.id.btnCL)
    Button btnCL;
    @BindView(R.id.etTitle)
    EditText etTitle;
    @BindView(R.id.llTitle)
    LinearLayout llTitle;
    @BindView(R.id.etContent)
    EditText etContent;
    @BindView(R.id.llContent)
    LinearLayout llContent;
    @BindView(R.id.etMemo)
    EditText etMemo;
    @BindView(R.id.llMemo)
    LinearLayout llMemo;
    @BindView(R.id.btnXG)
    Button btnXG;
    @BindView(R.id.btnCB)
    Button btnCB;
    @BindView(R.id.btnTJRC)
    Button btnTJRC;
    @BindView(R.id.btnBack)
    Button btnBack;

    String operTime;
    DBFile beanfj = null;
    String fileName = "";
    String data = "";
    String operId = "";
    String contactsId = "";
    String num = "";
    String downloadData = "";
    String operStation = "";
    String upDateType = "";
    String workId = "";
    String status = "";
    Bundle b1 = new Bundle();
    Gson gsonF = new Gson();
    DBUp1 bean = new DBUp1();
    DBXG bean2 = new DBXG();
    private OkHttpUtil httpUtil;
    AlertDialogUtil alertDialogUtil;
    HashMap<String, String> map = new HashMap();
    List<DBFile.DataBean.SuperWorkTaskFilesBean> dataList = new ArrayList<>();
    List<String> dataListName = new ArrayList<>();
    String path_url = Constant.BASE_URL1 + Constant.DBDEL;
    String path_url1 = Constant.BASE_URL1 + Constant.DBCHANGETYPE;
    String path_url2 = Constant.BASE_URL1 + Constant.DBCHULI;
    String path_url3 = Constant.BASE_URL1 + Constant.DBXG;
    String path_url4 = Constant.BASE_URL1 + Constant.DBCB;
    String path_url5 = Constant.BASE_URL1 + Constant.DBBACK;
    String path_url6 = Constant.BASE_URL1 + Constant.DBTJRCO;
    String path_urlfj = Constant.BASE_URL1 + Constant.DBXQFJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        alertDialogUtil = new AlertDialogUtil(this);
        httpUtil = OkHttpUtil.getInstance(this);
        Intent intent = getIntent();
        DBZXList.ResultBean bean = (DBZXList.ResultBean) intent.getSerializableExtra("bean");
        status = String.valueOf(bean.getTaskStatus());
        operTime = bean.getOperTime();
        tvType.setText(bean.getTaskType());
        tvRW.setText(bean.getTaskName());
        tvJHWCSJ.setText(bean.getPlanFinishTime() + "");
        tvContent.setText(bean.getTaskContext());
        tvDBR.setText(bean.getSupervisorNames());
        tvZXR.setText(bean.getOperatorNames());
        tvFBSJ.setText(bean.getApproveTime());
        tvLXR.setText(bean.getApproverName());
        upDateType = bean.getUpdateType();
        num = bean.getNum();
        if (upDateType==null){
            upDateType = "";
        }
        if (num==null){
            num = "";
        }
        contactsId = bean.getContactsId();
        operStation = String.valueOf(bean.getOperStatus());
//        tvFJ.setText(bean.getFileNames() + "");
        workId = String.valueOf(bean.getWorkId());
        operId = String.valueOf(bean.getOperId());
        if (operStation.equals("1")) {
            btn.setVisibility(View.GONE);
            setChangeType("2");
        }

        if (operStation.equals("2")) {
            btnJS.setVisibility(View.VISIBLE);
            btnBack.setVisibility(View.VISIBLE);
        }
        if (operStation.equals("3")) {
            btnJS.setVisibility(View.GONE);
            btnCL.setVisibility(View.VISIBLE);
            btnTJRC.setVisibility(View.VISIBLE);
            llTitle.setVisibility(View.VISIBLE);
            llContent.setVisibility(View.VISIBLE);
            llMemo.setVisibility(View.VISIBLE);
        }

        if (operStation.equals("5")) {
            btnCB.setVisibility(View.VISIBLE);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("y-M-d");
        //获取当前时间
        Date date = new Date();// 获取当前时间
        Date date2 = null;
        Date currentDate = null;
        String currentTime = null;
        try {
            date2 = dateFormat.parse(tvJHWCSJ.getText().toString());//结束时间
            currentTime = dateFormat.format(new Date());//结束时间
            SimpleDateFormat format=new SimpleDateFormat("y-M-d");
            currentDate = format.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (operStation.equals("5") && !upDateType.equals("1") && !num.equals("1") && currentDate.getTime() <= date2.getTime()) {
            btnXG.setVisibility(View.VISIBLE);
        }

        getFile();
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
                message.what = Constant.TAG_NINE;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 查看  接收
     */
    private void setChangeType(final String type) {
        HashMap<String, String> map = new HashMap();
        map.put("operId", operId);
        map.put("operStatus", type);
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.up_data));
        httpUtil.postForm(path_url1, map, new OkHttpUtil.ResultCallback() {
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
                if (type.equals("2")) {
                    message.what = Constant.TAG_TWO;
                    handler.sendMessage(message);
                } else if (type.equals("3")) {
                    message.what = Constant.TAG_THERE;
                    handler.sendMessage(message);
                }
            }
        });
    }

    /**
     * 处理
     */
    private void setChuLi(String type) {
        map.put("superTaskOper.operId", operId);
        map.put("superTaskOper.workId", workId);
        map.put("superTaskOper.superWorkTask.taskName", tvRW.getText().toString());
        map.put("superTaskOper.operatorName", tvZXR.getText().toString());
        map.put("superTaskOper.operStatus", type);
        map.put("superTaskOper.operTime", tvFBSJ.getText().toString());
        map.put("superTaskOper.submitTitle", etTitle.getText().toString());
        map.put("superTaskOper.submitContext", etContent.getText().toString());
        map.put("superTaskOper.memo", etMemo.getText().toString());
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
                message.what = Constant.TAG_FOUR;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 添加日程
     */
    private void setTianJiaRiCheng() {
        map.clear();
        map.put("Q_operId_L_EQ", operId);
        map.put("assignerStatus", "1");
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.up_data));
        httpUtil.postForm(path_url6, map, new OkHttpUtil.ResultCallback() {
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
                message.what = TAG_EIGHT;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 催办
     */
    private void setCuiBan() {
        map.clear();
        map.put("operTime", operTime);
        map.put("taskName", tvRW.getText().toString());
        map.put("contactsId", contactsId);
        map.put("operId", operId);
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.up_data));
        httpUtil.postForm(path_url4, map, new OkHttpUtil.ResultCallback() {
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

    /**
     * 修改
     */
    private void setXiuGai() {
        map.clear();
        map.put("operId", operId);
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.up_data));
        httpUtil.postForm(path_url3, map, new OkHttpUtil.ResultCallback() {
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
                message.what = Constant.TAG_FIVE;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 退回
     */
    private void setTuiHui() {
        map.clear();
        map.put("operId", operId);
        map.put("operStatus", "4");
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.up_data));
        httpUtil.postForm(path_url5, map, new OkHttpUtil.ResultCallback() {
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
                data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = TAG_SEVEN;
                handler.sendMessage(message);
            }
        });
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
                        handler.sendEmptyMessage(111);
                    } else {
                        handler.sendEmptyMessage(222);
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
                                handler.sendEmptyMessage(111);
                            } else {
                                handler.sendEmptyMessage(222);
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
    protected int provideContentViewId() {
        return R.layout.activity_dnzxdetail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.tvFJ, R.id.btn, R.id.btnJS, R.id.btnCL, R.id.btnXG, R.id.btnCB, R.id.btnTJRC,R.id.btnBack})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnJS:
                setChangeType("3");
                break;
            case R.id.btnCL:
                if (etTitle.getText().toString().equals("")) {
                    Toast.makeText(this, "标题不能为空", Toast.LENGTH_SHORT).show();
                } else if (etContent.getText().toString().equals("")) {
                    Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    setChuLi("3");
                }
                break;
            case R.id.btnTJRC:
                setTianJiaRiCheng();
                break;
            case R.id.btnCB:
                setCuiBan();
                break;
            case R.id.btnXG:
                setXiuGai();
                break;
            case R.id.btnBack:
                setTuiHui();
                break;
            case R.id.tvFJ:
                onLookFile();
                break;
            case R.id.btn:
                map.clear();
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
                        message.what = Constant.TAG_TWO;
                        handler.sendMessage(message);
                    }
                });
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
                    Toast.makeText(DBZXDetailActivity.this, error, Toast.LENGTH_SHORT).show();
                    break;
                case Constant.TAG_TWO:
                    b1 = msg.getData();
                    data = b1.getString("data");
                    gsonF = new Gson();
                    bean = gsonF.fromJson(data, DBUp1.class);
                    if (bean.isSuccess()) {
                        Toast.makeText(DBZXDetailActivity.this, "查看成功", Toast.LENGTH_SHORT).show();
                    }
                    btnJS.setVisibility(View.VISIBLE);
                    btnBack.setVisibility(View.VISIBLE);
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_THERE:
                    b1 = msg.getData();
                    data = b1.getString("data");
                    gsonF = new Gson();
                    bean = gsonF.fromJson(data, DBUp1.class);
                    if (bean.isSuccess()) {
                        Toast.makeText(DBZXDetailActivity.this, "接收成功", Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case Constant.TAG_FOUR:
                    b1 = msg.getData();
                    data = b1.getString("data");
                    gsonF = new Gson();
                    bean = gsonF.fromJson(data, DBUp1.class);
                    if (bean.isSuccess()) {
                        Toast.makeText(DBZXDetailActivity.this, "处理成功", Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case Constant.TAG_FIVE:
                    b1 = msg.getData();
                    data = b1.getString("data");
                    gsonF = new Gson();
                    bean2 = gsonF.fromJson(data, DBXG.class);
                    if (bean2.isSuccess()) {
                        Toast.makeText(DBZXDetailActivity.this, "操作成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DBZXDetailActivity.this, bean2.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case Constant.TAG_SIX:
                    b1 = msg.getData();
                    data = b1.getString("data");
                    gsonF = new Gson();
                    bean2 = gsonF.fromJson(data, DBXG.class);
                    if (bean2.isSuccess()) {
                        Toast.makeText(DBZXDetailActivity.this, bean2.getMsg(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DBZXDetailActivity.this, bean2.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case TAG_SEVEN:
                    b1 = msg.getData();
                    data = b1.getString("data");
                    gsonF = new Gson();
                    bean = gsonF.fromJson(data, DBUp1.class);
                    if (bean2.isSuccess()) {
                        Toast.makeText(DBZXDetailActivity.this, "退回成功", Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case TAG_EIGHT:
                    b1 = msg.getData();
                    data = b1.getString("data");
                    gsonF = new Gson();
                    DBTJRCO beanO = gsonF.fromJson(data, DBTJRCO.class);
                    if (beanO.isSuccess()) {
                        if (beanO.getTotalCounts()>=1){
                            alertDialogUtil.showSmallDialog("已添加到日程");
                        }else {
                            Intent intent = new Intent(DBZXDetailActivity.this,DBTJRCActivity.class);
                            intent.putExtra("operId",operId);
                            intent.putExtra("summary",tvRW.getText().toString());
                            intent.putExtra("content",tvContent.getText().toString());
                            startActivity(intent);
                        }
                    }
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_NINE:
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
                case 111:
                    Toast.makeText(DBZXDetailActivity.this, "操作数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case 222:
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
