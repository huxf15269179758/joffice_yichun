package com.hy.powerplatform.login.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.login.bean.Version;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBack;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class SecondActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.mIvBanner)
    ImageView mIvBanner;
    @BindView(R.id.llOa)
    LinearLayout llOa;
    @BindView(R.id.tvLeave)
    TextView tvLeave;
    @BindView(R.id.llPersonal)
    LinearLayout llPersonal;
    Intent intent;
    String versiondata = "";
    AlertDialogUtil alertDialogUtil;
    private static boolean isExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        alertDialogUtil = new AlertDialogUtil(this);
        getVersion();
    }

    private void getVersion() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = Constant.BASE_URL2 + Constant.VERSIONNO;
                DBHandler dbA = new DBHandler();
                versiondata = dbA.getAPKVerson(url);
                Message message = new Message();
                if (versiondata.equals("")) {
                    handler.sendEmptyMessage(TAG_TWO);
                } else {
                    handler.sendEmptyMessage(TAG_FOUR);
                }
//                message.what = TAG_FOUR;
//                handler.sendMessage(message);
            }
        }).start();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_second;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.llOa, R.id.llPersonal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llOa:
                intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.llPersonal:
                intent = new Intent(SecondActivity.this, MyPersonalActivity.class);
                startActivity(intent);
                break;
        }
    }

    //推出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            alertDialogUtil.showDialog1("您确定要退出程序吗", new AlertDialogCallBack() {
                @Override
                public void select(String data) {

                }

                @Override
                public void confirm() {
                    finish();
                }

                @Override
                public void cancel() {

                }
            });
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_TWO:
                    Toast.makeText(SecondActivity.this, "请求数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_FOUR:
                    ProgressDialogUtil.stopLoad();
                    Gson gson = new Gson();
                    Version version = gson.fromJson(versiondata, Version.class);
                    if (version!=null&&version.getData() != null) {
                        String nnm = version.getData().getVersionNo();
                        String versionName = "";
                        int versionCode = 0;
                        try {
                            // ---get the package info---
                            PackageManager pm = SecondActivity.this.getPackageManager();
                            PackageInfo pi = pm.getPackageInfo(SecondActivity.this.getPackageName(), 0);
                            versionName = pi.versionName;
                            versionCode = pi.versionCode;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (versionName == null || versionName.length() <= 0) {
                            versionName = "";
                        }

                        if (!nnm.equals(versionName)&&Double.valueOf(nnm)>Double.valueOf(versionName)){
//                        if (!nnm.equals("2")) {
                            final String url = Constant.BASE_URL2 + "attachFiles/" + version.getData().getDownurl();
                            String data1 = version.getData().getSubstance();
                            new AlertDialogUtil(SecondActivity.this).showDialog2("检测到服务器上有新的版本，是否立即更新。\n"+data1, new AlertDialogCallBack() {
                                @Override
                                public void select(String data) {

                                }

                                @Override
                                public void confirm() {
                                    Intent intent = new Intent(Intent.ACTION_VIEW);
                                    Uri content_url = Uri.parse(url);
                                    intent.setData(content_url);
                                    startActivity(intent);
                                }

                                @Override
                                public void cancel() {
                                    finish();
                                }
                            });
                        }
                    }
                    break;
            }
        }
    };
    //推出程序
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

}
