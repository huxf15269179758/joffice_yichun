package com.hy.powerplatform.duban.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.duban.bean.DBFile;
import com.hy.powerplatform.duban.bean.DBGuanLi;
import com.hy.powerplatform.duban.bean.DBUp1;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.bean.Filed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_EIGHT;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_SEVEN;

public class DBDetailGLActivity extends BaseActivity {

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
    @BindView(R.id.btnDJ)
    Button btnDJ;
    @BindView(R.id.btnQY)
    Button btnQY;
    @BindView(R.id.btnCK)
    Button btnCK;

    DBFile beanfj = null;
    String fileName = "";
    String downloadData = "";
    String data = "";
    String workId = "";
    String status = "";
    String taskName = "";
    String userName = "";
    String createName = "";
    String operatorId = "";
    String contactsName = "";
    String approveTime = "";
    String supervisorNames = "";
    Bundle b1;
    Gson gsonF;
    DBUp1 bean;
    DBGuanLi.ResultBean detaBean;
    private OkHttpUtil httpUtil;
    final HashMap<String, String> map = new HashMap();
    List<String> dataListName = new ArrayList<>();
    List<DBFile.DataBean.SuperWorkTaskFilesBean> dataList = new ArrayList<>();
    SharedPreferencesHelper sharedPreferencesHelper;
    String path_url = Constant.BASE_URL1 + Constant.DBDJ;
    String path_url1 = Constant.BASE_URL1 + Constant.DBQY;
    String path_urlfj = Constant.BASE_URL1 + Constant.DBXQFJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        detaBean = (DBGuanLi.ResultBean) intent.getSerializableExtra("bean");
        status = String.valueOf(detaBean.getTaskStatus());
        tvType.setText(detaBean.getTaskType());
        tvRW.setText(detaBean.getTaskName());
        tvJHWCSJ.setText(detaBean.getPlanFinishTime());
        tvContent.setText(detaBean.getTaskContext());
        tvDBR.setText(detaBean.getSupervisorNames());
        tvZXR.setText(detaBean.getOperatorNames());
        tvFBSJ.setText(detaBean.getApproveTime());
        tvLXR.setText(detaBean.getContactsName());
        tvFJ.setText(detaBean.getFileNames() + "");
        workId = String.valueOf(detaBean.getWorkId());
        contactsName = detaBean.getContactsName();
        createName = detaBean.getCreaterName();
        operatorId = detaBean.getOperatorIds();
        approveTime = detaBean.getApproveTime();
        taskName = detaBean.getTaskName();
        supervisorNames = detaBean.getSupervisorNames();

        httpUtil = OkHttpUtil.getInstance(this);
        sharedPreferencesHelper = new SharedPreferencesHelper(this,"login");
        userName = sharedPreferencesHelper.getData(this,"userStatus","");
        if (detaBean.getSupervisorNames().contains(userName)||detaBean.getContactsName().equals(userName)){
            if (detaBean.getTaskStatus()>2&&detaBean.getTaskStatus()<5){
                btnDJ.setVisibility(View.VISIBLE);
            }
        }
        if (detaBean.getTaskStatus()==7){
            btnQY.setVisibility(View.VISIBLE);
        }
        if (detaBean.getTaskStatus()>2){
            btnCK.setVisibility(View.VISIBLE);
        }
        getFile();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_dngldetail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

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


    @OnClick({R.id.btnDJ, R.id.btnQY, R.id.btnCK, R.id.tvFJ})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnCK:
                onChaKan();
                break;
            case R.id.btnDJ:
                onDongJie();
                break;
            case R.id.btnQY:
                onQiYong();
                break;
            case R.id.tvFJ:
                onLookFile();
                break;
        }
    }

    /**
     * 查看
     */
    private void onChaKan() {
        Intent intent = new Intent(this,DBChaKanActivity.class);
        intent.putExtra("workId",workId);
        intent.putExtra("taskName",taskName);
        intent.putExtra("approveTime",approveTime);
        intent.putExtra("createName",createName);
        intent.putExtra("operatorId",operatorId);
        intent.putExtra("supervisorNames",supervisorNames);
        intent.putExtra("contactsName",contactsName);
        startActivity(intent);
    }

    /**
     * 冻结
     */
    private void onDongJie() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        map.clear();
        map.put("workId", workId);
        httpUtil.postForm(path_url, map, new OkHttpUtil.ResultCallback() {
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
                message.what = Constant.TAG_TWO;
                handler.sendMessage(message);
            }
        });
    }

    /**
     * 启用
     */
    private void onQiYong() {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        map.clear();
        map.put("workId", workId);
        httpUtil.postForm(path_url1, map, new OkHttpUtil.ResultCallback() {
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
                message.what = Constant.TAG_THERE;
                handler.sendMessage(message);
            }
        });
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
                    Toast.makeText(DBDetailGLActivity.this, error, Toast.LENGTH_SHORT).show();
                    break;
                case Constant.TAG_TWO:
                    b1 = msg.getData();
                    String data = b1.getString("data");
                    gsonF = new Gson();
                    bean = gsonF.fromJson(data, DBUp1.class);
                    if (bean.isSuccess()){
                        Toast.makeText(DBDetailGLActivity.this, "冻结成功", Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    finish();
                    break;
                case Constant.TAG_THERE:
                    b1 = msg.getData();
                    String data1 = b1.getString("data");
                    gsonF = new Gson();
                    bean = gsonF.fromJson(data1, DBUp1.class);
                    if (bean.isSuccess()){
                        Toast.makeText(DBDetailGLActivity.this, "启用成功", Toast.LENGTH_SHORT).show();
                    }
                    ProgressDialogUtil.stopLoad();
                    finish();
                    Intent intent = new Intent(DBDetailGLActivity.this,DBUpActivity1.class);
                    intent.putExtra("bean",detaBean);
                    startActivity(intent);
                    finish();
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
                    Toast.makeText(DBDetailGLActivity.this, "操作数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_EIGHT:
                    Gson gson2 = new Gson();
                    Filed filed = gson2.fromJson(downloadData, Filed.class);
                    String filePath = filed.getData().getFilePath();
                    String url = Constant.FIELDETAIL + filePath;
                    Intent intent1 = new Intent(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse(url));
                    startActivity(intent1);
                    break;
            }
        }
    };
}
