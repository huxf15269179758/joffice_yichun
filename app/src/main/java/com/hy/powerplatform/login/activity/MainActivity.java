package com.hy.powerplatform.login.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.database.DbManager;
import com.hy.powerplatform.database.MyDatabaseHelper;
import com.hy.powerplatform.login.bean.Version;
import com.hy.powerplatform.login.fragment.Fragment01;
import com.hy.powerplatform.login.fragment.Fragment02;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBack;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.activity_main2)
    LinearLayout activityMain2;
    SQLiteDatabase db;
    MyDatabaseHelper helper;
    private List<Fragment> fragmentList;
    private FragmentTransaction fragmentTransaction;

    String versiondata = "";
    AlertDialogUtil alertDialogUtil;
    private static boolean isExit = false;

    //推出程序
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

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
            Toast.makeText(this, "再点一次退出程序", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getWritableDatabase();
        alertDialogUtil = new AlertDialogUtil(this);
        // 获取片段管理器
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        // 界面显示时 默认按钮1被选择及显示第一个界面
        rb1.setChecked(true);
//        fragmentTransaction.replace(R.id.vp, new Fragment01()).commit();
        // fragmentList用于存放片段 及 将片段添加进集合
        fragmentList = new ArrayList<Fragment>();
        Fragment fragment1 = new Fragment01();
        Fragment fragment2 = new Fragment02();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragmentList, this);
        vp.setAdapter(adapter);

        radioGroup.check(R.id.tv1);
        vp.setCurrentItem(0);

        radioGroup.setOnCheckedChangeListener(this);
        getVersion();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main2;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

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
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb1:
                vp.setCurrentItem(0);
                break;
            case R.id.rb2:
                vp.setCurrentItem(1);
                break;
        }
    }


    public class MyPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> list;
        private Context context;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> list, Context context) {
            super(fm);
            this.list = list;
            this.context = context;
        }


        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_TWO:
                    Toast.makeText(MainActivity.this, "请求数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_FOUR:
//                    ProgressDialogUtil.stopLoad();
                    Gson gson = new Gson();
                    Version version = gson.fromJson(versiondata, Version.class);
                    if (version != null && version.getData() != null) {
                        String nnm = version.getData().getVersionNo();
                        String versionName = "";
                        int versionCode = 0;
                        try {
                            // ---get the package info---
                            PackageManager pm = MainActivity.this.getPackageManager();
                            PackageInfo pi = pm.getPackageInfo(MainActivity.this.getPackageName(), 0);
                            versionName = pi.versionName;
                            versionCode = pi.versionCode;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (versionName == null || versionName.length() <= 0) {
                            versionName = "";
                        }

                        if (!nnm.equals(versionName) && Double.valueOf(nnm) > Double.valueOf(versionName)) {
//                        if (!nnm.equals("2")) {
                            final String url = Constant.BASE_URL2 + "attachFiles/" + version.getData().getDownurl();
                            String data1 = version.getData().getSubstance();
                            db.delete("ycPerson",null,null);
                            new AlertDialogUtil(MainActivity.this).showDialog2("检测到服务器上有新的版本，是否更新。\n" + data1, new AlertDialogCallBack() {
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
}
