package com.hy.powerplatform.oa_flow;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.ApiAddress;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.duban.activity.DBActivity;
import com.hy.powerplatform.login.adapter.MainDataAdapter;
import com.hy.powerplatform.login.bean.MainData;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.activity.HistoryListActivity;
import com.hy.powerplatform.oa_flow.activity.InboxActivity;
import com.hy.powerplatform.oa_flow.activity.ListActivity;
import com.hy.powerplatform.oa_flow.activity.ListActivity1;
import com.hy.powerplatform.oa_flow.activity.ListActivity2;
import com.hy.powerplatform.oa_flow.activity.ListActivity3;
import com.hy.powerplatform.oa_flow.activity.MyBackFlowListActivity;
import com.hy.powerplatform.oa_flow.activity.MyBackSureFlowListActivity;
import com.hy.powerplatform.oa_flow.bean.MyWillDo;
import com.hy.powerplatform.qrcode.zxing.activity.CaptureActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class OAListActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<MainData.DataBean> mainDataList = new ArrayList<>();
    List<Integer> imageList = new ArrayList<>();
    AlertDialogUtil alertDialogUtil;
    MainDataAdapter mainDataAdapter;
    Intent intent;

    String versiondata = "";
    String versionName;
    int versionCode;

    MainData bean;
    int limit = 200;
    int start = 0;
    String res = "";
    String tag = "N";
    List<MyWillDo.ResultBean> beanList = new ArrayList<>();
    SharedPreferencesHelper sharedPreferencesHelper;
    String userName;
    String superRoleName;
    String data = "";
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        userName = sharedPreferencesHelper.getData(this, "userName", "");
        superRoleName = sharedPreferencesHelper.getData(this, "superRoleName", "");
        PackageManager pm = this.getPackageManager();
        PackageInfo pi = null;
        try {
            pi = pm.getPackageInfo(this.getPackageName(), 0);
            versionName = pi.versionName;
            versionCode = pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        SharedPreferencesHelper helper = new SharedPreferencesHelper(this, "login");
        String address = helper.getData(this, "Address", "");
        alertDialogUtil = new AlertDialogUtil(this);
        imageList.add(R.drawable.signin);
        imageList.add(R.drawable.sign_in);
        imageList.add(R.drawable.my_information);
        imageList.add(R.drawable.technological_process);
        imageList.add(R.drawable.business_inspection);
        imageList.add(R.drawable.data_analysis);
        imageList.add(R.drawable.staff_work);
        imageList.add(R.drawable.phonelist);
        imageList.add(R.drawable.mycenter);
        imageList.add(R.drawable.mycenter);
        imageList.add(R.drawable.mycenter);
        imageList.add(R.drawable.mycenter);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(this, "login");
        String userName = sharedPreferencesHelper.getData(this, "userName", "");
        String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(), "Found", "");
        String BASE_URL = ApiAddress.api;
        final String Url = BASE_URL + "system/getStatusModuleManagement.do" + "?userName=" + userName;
        final Message message = new Message();
        ProgressDialogUtil.startLoad(this,"获取数据中");
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(Url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                message.what = TAG_TWO;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                message.what = TAG_ONE;
                message.obj = response.body().toString();
//                Log.d("XXX", "onResponse: " + response.body().string());
                data = response.body().string();
                handler.sendMessage(message);
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_oalist;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    /**
     * 获取数据
     * @param start
     * @param limit
     */
    private void getData(final int start, final int limit) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.MYWILLDOLIST + start + "&limit=" + limit;
                DBHandler dbA = new DBHandler();
                res = dbA.OAQingJiaWillDo(url);
                if (res.equals("获取数据失败") || res.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_FIVE);
                }
            }
        }).start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    mainDataList.clear();
//                    String data = msg.obj.toString();
                    bean = new Gson().fromJson(data, MainData.class);
                    for (int i = 0; i < bean.getData().size(); i++) {
                        if (bean.getData().get(i).getModuleName().equals("公司流程")){
                            if (superRoleName.equals("分管领导")||superRoleName.equals("总经理")
                                    ||superRoleName.equals("副总经理")||superRoleName.equals("董事长")){
                                mainDataList.add(bean.getData().get(i));
                            }
                        }else if (bean.getData().get(i).getModuleName().equals("部门流程")){
                            if (superRoleName.equals("分管领导")||superRoleName.equals("总经理")
                                    ||superRoleName.equals("副总经理")||superRoleName.equals("董事长")){
//                                mainDataList.add(bean.getData().get(i))
                            }else {
                                mainDataList.add(bean.getData().get(i));
                            }
                        }else {
                            mainDataList.add(bean.getData().get(i));
                        }
                    }
                    getData(start, limit);
                    break;
                case TAG_TWO:
                    Toast.makeText(OAListActivity.this, "请求数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_FIVE:
                    try {
                        JSONObject jsonObject = new JSONObject(res);
                        JSONArray jsonArray = jsonObject.getJSONArray("result");
                        String num = "";
                        if (jsonArray.length()!=0){
                            tag = "Y";
                            num = jsonObject.getString("totalCounts");
                        }
                        for (int i = 0;i<jsonArray.length();i++){
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            if (jsonObject1.getString("taskName").contains("会签")){
                                num = String.valueOf(Integer.valueOf(num)-1);
                            }
                        }
                        ProgressDialogUtil.stopLoad();
                        mainDataAdapter = new MainDataAdapter(OAListActivity.this, mainDataList, imageList,tag,num);
                        recyclerView.setAdapter(mainDataAdapter);
                        mainDataAdapter.sendOnGetAdapterPositionListener(new MainDataAdapter.OnGetAdapterPositionListener() {
                            @Override
                            public void getAdapterPosition(int position) {
                                String tag = mainDataList.get(position).getModuleCode();
                               if (mainDataList.get(position).getModuleCode().equals("FQSQ")) {
                                    intent = new Intent(OAListActivity.this, ListActivity.class);
                                    startActivity(intent);
                                }else if (mainDataList.get(position).getModuleCode().equals("DBLC")) {
                                    intent = new Intent(OAListActivity.this, ListActivity1.class);
                                    startActivity(intent);
                                }else if (mainDataList.get(position).getModuleCode().equals("GSLC")) {
                                    intent = new Intent(OAListActivity.this, HistoryListActivity.class);
                                    startActivity(intent);
                                }else if (mainDataList.get(position).getModuleCode().equals("BMLC")) {
                                    intent = new Intent(OAListActivity.this, ListActivity2.class);
                                    startActivity(intent);
                                }else if (mainDataList.get(position).getModuleCode().equals("YBLC")) {
                                    intent = new Intent(OAListActivity.this, ListActivity3.class);
                                    startActivity(intent);
                                }else if (mainDataList.get(position).getModuleCode().equals("SYS")) {
                                    startQrCode();
                                }else if (mainDataList.get(position).getModuleCode().equals("SJX")) {
                                    intent = new Intent(OAListActivity.this, InboxActivity.class);
                                    startActivity(intent);
                                } else if (mainDataList.get(position).getModuleCode().equals("LCZH")) {
                                    intent = new Intent(OAListActivity.this, MyBackFlowListActivity.class);
                                    startActivity(intent);
                                }else if (mainDataList.get(position).getModuleCode().equals("ZHQR")) {
                                    intent = new Intent(OAListActivity.this, MyBackSureFlowListActivity.class);
                                    startActivity(intent);
                                }else if (mainDataList.get(position).getModuleCode().equals("DB")) {
                                    intent = new Intent(OAListActivity.this, DBActivity.class);
                                    startActivity(intent);
                                }
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                        handler.sendEmptyMessage(TAG_THERE);
                    }
                    break;
            }
        }
    };

    // 开始扫码
    private void startQrCode() {
        // 申请相机权限
        if (ActivityCompat.checkSelfPermission(OAListActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // 申请权限
            ActivityCompat.requestPermissions(OAListActivity.this, new String[]{Manifest.permission.CAMERA}, Constant.REQ_PERM_CAMERA);
            return;
        }
        // 申请文件读写权限（部分朋友遇到相册选图需要读写权限的情况，这里一并写一下）
        if (ActivityCompat.checkSelfPermission(OAListActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // 申请权限
            ActivityCompat.requestPermissions(OAListActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, Constant.REQ_PERM_EXTERNAL_STORAGE);
            return;
        }
        // 二维码扫码
        Intent intent = new Intent(OAListActivity.this, CaptureActivity.class);
        startActivityForResult(intent, Constant.REQ_QR_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case Constant.REQ_PERM_CAMERA:
                // 摄像头权限申请
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 获得授权
                    startQrCode();
                } else {
                    // 被禁止授权
                    Toast.makeText(OAListActivity.this, "请至权限中心打开本应用的相机访问权限", Toast.LENGTH_LONG).show();
                }
                break;
            case Constant.REQ_PERM_EXTERNAL_STORAGE:
                // 文件读写权限申请
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 获得授权
                    startQrCode();
                } else {
                    // 被禁止授权
                    Toast.makeText(OAListActivity.this, "请至权限中心打开本应用的文件读写权限", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
