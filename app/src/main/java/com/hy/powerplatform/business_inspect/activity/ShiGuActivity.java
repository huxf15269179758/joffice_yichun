package com.hy.powerplatform.business_inspect.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.adapter.ShiGuLeiBieAdapter;
import com.hy.powerplatform.business_inspect.adapter.ShiGuLeiXIngAdapter;
import com.hy.powerplatform.business_inspect.adapter.ShiGuXingZhiAdapter;
import com.hy.powerplatform.business_inspect.adapter.ShiGuZeRenAdapter;
import com.hy.powerplatform.business_inspect.bean.Correlat;
import com.hy.powerplatform.business_inspect.bean.NewDriver;
import com.hy.powerplatform.business_inspect.presenter.CorrelationPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CorrectionPresenterimpl;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.business_inspect.view.CorrelationView;
import com.hy.powerplatform.database.DbManager;
import com.hy.powerplatform.database.MyDatabaseHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.EditTextChange;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.UriTrytoPath;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerMinS;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class ShiGuActivity extends BaseActivity implements CorrelationView {

    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.imTimeSelect)
    ImageView imTimeSelect;
    @BindView(R.id.etSelectLine)
    EditText etSelectLine;
    @BindView(R.id.imLineSelect)
    ImageView imLineSelect;
    @BindView(R.id.etSelectCar)
    EditText etSelectCar;
    @BindView(R.id.imCarSelect)
    ImageView imCarSelect;
    @BindView(R.id.etSelectDriver)
    EditText etSelectDriver;
    @BindView(R.id.imDriverSelect)
    ImageView imDriverSelect;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.spShiGuLeiXing)
    Spinner spShiGuLeiXing;
    @BindView(R.id.spShiGuZeRen)
    Spinner spShiGuZeRen;
    @BindView(R.id.spShiGuXingZhi)
    Spinner spShiGuXingZhi;
    @BindView(R.id.spShiGuLeiBei)
    Spinner spShiGuLeiBei;
    @BindView(R.id.etShiGuDiDian)
    EditText etShiGuDiDian;
    @BindView(R.id.etShiGuYuanYin)
    EditText etShiGuYuanYin;
    @BindView(R.id.spShiGuTianQi)
    Spinner spShiGuTianQi;
    @BindView(R.id.spShiGuDiDian)
    Spinner spShiGuDiDian;
    @BindView(R.id.etShiGuShouShang)
    EditText etShiGuShouShang;
    @BindView(R.id.etShiGuSiWang)
    EditText etShiGuSiWang;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.etOutName)
    EditText etOutName;
    @BindView(R.id.etOutPhone)
    EditText etOutPhone;
    @BindView(R.id.etOutCarNo)
    EditText etOutCarNo;
    @BindView(R.id.etCarId)
    EditText etCarId;
    @BindView(R.id.llOut)
    LinearLayout llOut;
    @BindView(R.id.etDiredP)
    EditText etDiredP;
    @BindView(R.id.etOutP)
    EditText etOutP;
    @BindView(R.id.llPeiC)
    LinearLayout llPeiC;
    @BindView(R.id.etBeiZhu)
    EditText etBeiZhu;
    @BindView(R.id.llOutShow)
    LinearLayout llOutShow;
    @BindView(R.id.llPeiCShow)
    LinearLayout llPeiCShow;
    @BindView(R.id.tvAddress)
    EditText tvAddress;


    SQLiteDatabase db;
    MyDatabaseHelper helper;
    Cursor cursor;
    String carName, carNameId;
    public LocationClient mLocationClient = null;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.llTime)
    LinearLayout llTime;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.imageView6)
    ImageView imageView6;
    @BindView(R.id.imageView7)
    ImageView imageView7;
    @BindView(R.id.imageView8)
    ImageView imageView8;
    @BindView(R.id.activity_shi_gu)
    LinearLayout activityShiGu;
    @BindView(R.id.header)
    com.hy.powerplatform.my_utils.myViews.Header header;
    @BindView(R.id.linearLayout1)
    LinearLayout linearLayout1;
    @BindView(R.id.linearLayout2)
    LinearLayout linearLayout2;
    @BindView(R.id.linearLayout3)
    LinearLayout linearLayout3;
    @BindView(R.id.tv)
    TextView tv;
    private MyLocationListener myListener = new MyLocationListener();
    File tmpDir;
    String dirPath = "temp";
    String profileId, sex, lineCode, addr;
    SharedPreferencesHelper sharecPreferencesHelper;
    private ArrayList<String> mResults = new ArrayList<>();//图片list
    private ArrayList<String> photoPath = new ArrayList<>();//图片地址
    List<NewDriver.DataBean> listInspectDrive = new ArrayList<>();
    private CustomDatePickerMinS customDatePicker1, customDatePicker2;
    private List<String> list_1 = new ArrayList<String>();
    private List<String> list_2 = new ArrayList<String>();
    private List<String> list_3 = new ArrayList<String>();
    private List<String> list_4 = new ArrayList<String>();
    String type_, zeren, xingzhi, liebie, pathName0, pathName1, pathName2, pathName3, pathName4, pathName5, pathName6, pathName7;
    String atPleace, atReason, sideName, sideSex, sideContact, sideCarPlate, sideLicenseNum, atOtherPay, atPersonPay;
    Intent intent;
    String atTime, checkUserCode;
    String driverName, line, userCode, depId, depName;
    CorrelationPresenter correctionPresenter;
    String busCode, carNo, carDrive;
    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(), "login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(), "Found", "");
    String BASE_URL = "http://" + sharedPreferencesHelper.getData(MyApplication.getContextObject(), "Ip", "")
            + ":" + sharedPreferencesHelper.getData(MyApplication.getContextObject(), "Socket", "") + "/" + found + "/";

    boolean tag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        sharecPreferencesHelper = new SharedPreferencesHelper(this, "login");
        helper = DbManager.getInstance(MyApplication.getContextObject());
        userCode = sharecPreferencesHelper.getData(this, "userName", "");
        db = helper.getReadableDatabase();
        correctionPresenter = new CorrectionPresenterimpl(this, this);
        //设置Edittext
        new EditTextChange(etSelectLine).changeText();
        new EditTextChange(etSelectCar).changeText();
        new EditTextChange(etSelectDriver).changeText();
        new EditTextChange(etShiGuDiDian).changeText();
        new EditTextChange(etShiGuYuanYin).changeText();
        new EditTextChange(etShiGuShouShang).changeText();
        new EditTextChange(etShiGuSiWang).changeText();

        new EditTextChange(etOutName).changeText();
        new EditTextChange(etOutPhone).changeText();
        new EditTextChange(etOutCarNo).changeText();
        new EditTextChange(etCarId).changeText();
        new EditTextChange(etDiredP).changeText();
        new EditTextChange(etOutP).changeText();
        new EditTextChange(etBeiZhu).changeText();
        new EditTextChange(tvAddress).changeText();

        ProgressDialogUtil.startLoad(this, Constant.GETDATA);
        //选择时间
        initDatePicker();
        //请求事故类型
        getShiGuType();
        //请求事责任
        getShiGuZeRen();
        //请求事性质
        getShiGuXingZhi();
        //开始定位
        mLocationClient = new LocationClient(getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        mLocationClient.start();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                    TAG_TWO);
        } else {
            //开始定位
            getLatAndLod();
        }
//        //请求类别
//        getShiGuLeiBie();
//        //请求天气
//        getShiGuWeather();
//        //请求类别
//        getShiGuDiDianLieBie();
        spShiGuLeiXing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type_ = spShiGuLeiXing.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spShiGuZeRen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                zeren = spShiGuZeRen.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spShiGuXingZhi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                xingzhi = spShiGuXingZhi.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spShiGuLeiBei.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                liebie = spShiGuLeiBei.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //    private void getShiGuWeather() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String url = Constant.BASE_URL1 + "system/getWeiguiDictionary.do";
//                DBHandler db = new DBHandler();
//                list_5 = db.getValues_5(url, "天气");
//                handler1.sendEmptyMessage(5);
//
//            }
//        }).start();
//    }
//
//    private void getShiGuDiDianLieBie() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String url = Constant.BASE_URL1 + "system/getWeiguiDictionary.do";
//                DBHandler db = new DBHandler();
//                list_6 = db.getValues_5(url, "事故地点类别");
//                handler1.sendEmptyMessage(6);
//
//            }
//        }).start();
//    }
//
//
//    private void getShiGuLeiBie() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String url = Constant.BASE_URL1 + "system/getWeiguiDictionary.do";
//                DBHandler db = new DBHandler();
//                list_4 = db.getValues_5(url, "事故类别");
//                handler1.sendEmptyMessage(4);
//
//            }
//        }).start();
//    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_shi_gu;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        Intent intent = new Intent(this, ShiGuListActivity.class);
        startActivity(intent);
    }

    /**
     * 开始定位
     */
    private void getLatAndLod() {
        LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setCoorType("bd09ll");
        option.setScanSpan(0);
        option.setOpenGps(true);
        option.setLocationNotify(false);
        option.setIgnoreKillProcess(false);
        option.SetIgnoreCacheException(false);
        option.setWifiCacheTimeOut(5 * 60 * 1000);
        option.setEnableSimulateGps(false);
        mLocationClient.setLocOption(option);
    }


    /**
     * 定位回调
     */
    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            float radius = location.getRadius();    //获取定位精度，默认值为0.0f
            addr = location.getAddrStr();    //获取详细地址信息
            String coorType = location.getCoorType();
            int errorCode = location.getLocType();
            if (addr != null) {
                tvAddress.setText(addr);
            }
        }
    }

    private void getShiGuType() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = BASE_URL + "system/getWeiguiDictionary.do";
                DBHandler db = new DBHandler();
                list_1 = db.getValues_5(url, "事故类型");
                handler1.sendEmptyMessage(1);

            }
        }).start();
    }

    private void getShiGuZeRen() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = BASE_URL + "system/getWeiguiDictionary.do";
                DBHandler db = new DBHandler();
                list_2 = db.getValues_5(url, "事故责任");
                handler1.sendEmptyMessage(2);

            }
        }).start();
    }

    private void getShiGuXingZhi() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url = BASE_URL + "system/getWeiguiDictionary.do";
                DBHandler db = new DBHandler();
                list_3 = db.getValues_5(url, "事故性质");
                handler1.sendEmptyMessage(3);

            }
        }).start();
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm", Locale.CHINA);
//        String now = sdf.format(new Date());
//        Date date = new Date(System.currentTimeMillis());
//        SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");
//        final String atTime = simpleDateFormatTime.format(date);
//        tvTime.setText(now.split(" ")[0]+"  "+atTime);
        //currentTime.setText(now);
        final Date date = new Date(System.currentTimeMillis());
        final SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");
        atTime = simpleDateFormatTime.format(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tv.setText(now);
        tvTime.setText(now.split(" ")[0]);
//        tvTime.setText(now);
        tvDate.setText(atTime);

        customDatePicker1 = new CustomDatePickerMinS(this, new CustomDatePickerMinS.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                Date date1 = new Date(System.currentTimeMillis());
                atTime = simpleDateFormatTime.format(date1);
                String [] temp = null;
                temp = atTime.split(":");
                tvTime.setText(time.split(" ")[0]);
                tvDate.setText(time.split(" ")[1]+":"+temp[2]);
            }
        }, "2000-01-01 00:00:00", "2030-01-01 00:00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(true); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerMinS(this, new CustomDatePickerMinS.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvTime.setText(time);
                tvDate.setText(atTime);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(true); // 显示时和分
        customDatePicker2.setIsLoop(true); // 允许循环滚动
    }


    @OnClick({R.id.tvTime, R.id.imLineSelect, R.id.imCarSelect, R.id.imDriverSelect, R.id.btn, R.id.imageView1
            , R.id.llOut, R.id.llPeiC, R.id.llTime})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llOut:
                if (llOutShow.getVisibility() == View.GONE) {
                    llOutShow.setVisibility(View.VISIBLE);
                } else {
                    llOutShow.setVisibility(View.GONE);
                }
                break;
            case R.id.llPeiC:
                if (llPeiCShow.getVisibility() == View.GONE) {
                    llPeiCShow.setVisibility(View.VISIBLE);
                } else {
                    llPeiCShow.setVisibility(View.GONE);
                }
                break;
            case R.id.tvTime:
                customDatePicker1.show(tv.getText().toString());
                break;
            case R.id.llTime:
                customDatePicker1.show(tv.getText().toString());
                break;
            case R.id.imLineSelect:
                String etTextLine = etSelectLine.getText().toString().trim();
                intent = new Intent(this, InspectLineSelectTypeActivity.class);
                intent.putExtra("condition", etTextLine);
                startActivityForResult(intent, Constant.TAG_THERE);
                break;
            case R.id.imCarSelect:
//                String etText = etSelectCar.getText().toString().trim();
//                intent = new Intent(this, SelectOneCarActivity.class);
//                intent.putExtra("condition", etText);
//                startActivityForResult(intent, Constant.TAG_TWO);
                intent = new Intent(this, SelectOneCarActivity.class);
                line = etSelectLine.getText().toString();
                if (line.equals("")) {
                    intent.putExtra("line", "");
                    intent.putExtra("date", tvTime.getText().toString());
                    startActivityForResult(intent, TAG_TWO);
                } else {
                    intent.putExtra("line", line);
                    intent.putExtra("date", tvTime.getText().toString());
                    startActivityForResult(intent, TAG_TWO);
                }
                break;
            case R.id.imDriverSelect:
                String etTextDrive = etSelectDriver.getText().toString().trim();
                intent = new Intent(this, InspectDriveSelectTypeActivity.class);
                intent.putExtra("condition", etTextDrive);
                startActivityForResult(intent, Constant.TAG_FOUR);
                break;
            case R.id.imageView1:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                            TAG_ONE);
                } else {
                    Matisse.from(ShiGuActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(8)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.hy.powerplatform.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .thumbnailScale(0.3f)  //图片缩放比例
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(TAG_ONE);//
                }
                break;
            case R.id.btn:
                sideSex = "";
                if (!etBeiZhu.getText().toString().isEmpty()) {
                    atReason = etBeiZhu.getText().toString();
                } else {
                    atReason = "";
                }
                if (!etOutName.getText().toString().isEmpty()) {
                    sideName = etOutName.getText().toString();
                } else {
                    sideName = "";
                }
                if (!etOutPhone.getText().toString().isEmpty()) {
                    sideContact = etOutPhone.getText().toString();
                } else {
                    sideContact = "";
                }
                if (!etOutCarNo.getText().toString().isEmpty()) {
                    sideCarPlate = etOutCarNo.getText().toString();
                } else {
                    sideCarPlate = "";
                }
                if (!etCarId.getText().toString().isEmpty()) {
                    sideLicenseNum = etCarId.getText().toString();
                } else {
                    sideLicenseNum = "";
                }
                if (!etOutP.getText().toString().isEmpty()) {
                    atOtherPay = etOutP.getText().toString();
                } else {
                    atOtherPay = "";
                }
                if (!etDiredP.getText().toString().isEmpty()) {
                    atPersonPay = etDiredP.getText().toString();
                } else {
                    atPersonPay = "";
                }
                // 保存文字信息
                final String turl = BASE_URL + "busmanager/saveNewAccidentBasicInformation.do";
                final String dateText = tvTime.getText().toString();
                final String atAtDate = tvTime.getText().toString();
                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");
                final String atTime = simpleDateFormatTime.format(date);
                ProgressDialogUtil.startLoad(this, Constant.UPDATA);
//                if (mResults.size() == 1) {
//                    if (imageView1.getDrawable() != null) {
//                        RequestParams params = new RequestParams();
//                        Filed file = new Filed(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu0" + ".png");
//                        String sdpath = Environment.getExternalStorageDirectory()
//                                + "/" + dirPath;// 获取sdcard的根路径
//                        String filepath = "shigu0" + ".png";
//                        try {
//                            params.put("upload", file);
//                            params.put("fullname", filepath);
//                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                        }
//                        // 执行post请求
//                        // 异步的客户端对象
//                        AsyncHttpClient client = new AsyncHttpClient();
//                        client.setTimeout(30000);
//                        String url = Constant.BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
//                        client.post(url, params, new AsyncHttpResponseHandler() {
//                            @Override
//                            public void onSuccess(int arg0, String arg1) {
//                                super.onSuccess(arg0, arg1);
//                                try {
//                                    Log.i("XXX", arg1);
//                                    JSONObject jsonObject = new JSONObject(arg1);
//                                    pathName0 = jsonObject.getString("msg");
//                                    Message message = new Message();
//                                    handlerSend.sendMessage(message);
//
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//
//                            @Override
//                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                                super.onFailure(statusCode, headers, responseBody, error);
//                                Log.i("XXX", "XXXXX");
//                            }
//                        });
//                    }
//
//                } else
                if (tag) {
//                    if (imageView1.getDrawable() != null) {
//                        RequestParams params = new RequestParams();
//                        Filed file = new Filed(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu0" + ".png");
//                        String sdpath = Environment.getExternalStorageDirectory()
//                                + "/" + dirPath;// 获取sdcard的根路径
//                        String filepath = "shigu0" + ".png";
//                        try {
//                            params.put("upload", file);
//                            params.put("fullname", filepath);
//                        } catch (FileNotFoundException e) {
//                            e.printStackTrace();
//                        }
//                        // 执行post请求
//                        // 异步的客户端对象
//                        AsyncHttpClient client = new AsyncHttpClient();
//                        client.setTimeout(30000);
//                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
//                        client.post(url, params, new AsyncHttpResponseHandler() {
//                            @Override
//                            public void onSuccess(int arg0, String arg1) {
//                                super.onSuccess(arg0, arg1);
//                                try {
//                                    Log.i("XXX", "XXX");
//                                    JSONObject jsonObject = new JSONObject(arg1);
//                                    pathName0 = jsonObject.getString("msg");
//                                    Message message = new Message();
//                                    handlerSend.sendMessage(message);
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//
//                            @Override
//                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//                                super.onFailure(statusCode, headers, responseBody, error);
//                                Log.i("XXX", "XXXXX");
//                            }
//                        });
//                    }
                    Message message = new Message();
                    handlerSend.sendMessage(message);
                }
                 if (mResults.size() == 2) {
                    if (imageView1.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu0" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu0" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName0 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView2.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu1" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu1" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName1 = jsonObject.getString("msg");
                                    Message message = new Message();
                                    handlerSend.sendMessage(message);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }

                } else if (mResults.size() == 3) {
                    if (imageView1.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu0" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu0" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName0 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView2.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu1" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu1" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName1 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView3.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu2" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu2" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName2 = jsonObject.getString("msg");
                                    Message message = new Message();
                                    handlerSend.sendMessage(message);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                } else if (mResults.size() == 4) {
                    if (imageView1.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu0" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu0" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName0 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView2.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu1" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu1" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName1 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView3.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu2" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu2" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName2 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView4.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu3" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu3" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName3 = jsonObject.getString("msg");
                                    Message message = new Message();
                                    handlerSend.sendMessage(message);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                } else if (mResults.size() == 5) {
                    if (imageView1.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu0" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu0" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName0 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView2.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu1" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu1" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName1 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView3.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu2" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu2" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName2 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView4.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu3" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu3" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName3 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView5.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu4" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu4" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName4 = jsonObject.getString("msg");
                                    Message message = new Message();
                                    handlerSend.sendMessage(message);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                } else if (mResults.size() == 6) {
                    if (imageView1.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu0" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu0" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName0 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView2.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu1" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu1" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName1 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView3.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu2" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu2" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName2 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView4.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu3" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu3" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName3 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView5.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu4" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu4" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName4 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView6.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu5" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu5" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName5 = jsonObject.getString("msg");
                                    Message message = new Message();
                                    handlerSend.sendMessage(message);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                } else if (mResults.size() == 7) {
                    if (imageView1.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu0" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu0" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName0 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView2.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu1" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu1" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName1 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView3.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu2" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu2" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName2 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView4.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu3" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu3" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName3 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView5.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu4" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu4" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName4 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView6.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu5" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu5" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName5 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView7.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu6" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu6" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName6 = jsonObject.getString("msg");
                                    Message message = new Message();
                                    handlerSend.sendMessage(message);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                } else if (mResults.size() == 8) {
                    if (imageView1.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu0" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu0" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName0 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView2.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu1" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu1" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName1 = jsonObject.getString("msg");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView3.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu2" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu2" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName2 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView4.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu3" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu3" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName3 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView5.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu4" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu4" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName4 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView6.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu5" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu5" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName5 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView7.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu6" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu6" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName6 = jsonObject.getString("msg");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                    if (imageView8.getDrawable() != null) {
                        RequestParams params = new RequestParams();
                        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu7" + ".png");
                        String sdpath = Environment.getExternalStorageDirectory()
                                + "/" + dirPath;// 获取sdcard的根路径
                        String filepath = "shigu7" + ".png";
                        try {
                            params.put("upload", file);
                            params.put("fullname", filepath);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        // 执行post请求
                        // 异步的客户端对象
                        AsyncHttpClient client = new AsyncHttpClient();
                        client.setTimeout(30000);
                        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                try {
                                    Log.i("XXX", "XXX");
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName7 = jsonObject.getString("msg");
                                    Message message = new Message();
                                    handlerSend.sendMessage(message);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                } else if (mResults.size() == 0 &&tag == false){
                    final String line_Code = etSelectLine.getText().toString().trim();
                    final String car_No = etSelectCar.getText().toString().trim();
                    final String driver_Name = etSelectDriver.getText().toString().trim();
                    if (!tvAddress.getText().toString().trim().isEmpty()) {
                        atPleace = tvAddress.getText().toString().trim();
                    }
                    if (dateText.equals("")) {
                        Toast.makeText(this, "事故时间不能为空", Toast.LENGTH_LONG).show();
                    } else if (line_Code.equals("")) {
                        Toast.makeText(this, "线路编号不能为空", Toast.LENGTH_LONG).show();
                    } else if (car_No.equals("")) {
                        Toast.makeText(this, "车牌号码不能为空", Toast.LENGTH_LONG).show();
                    } else if (driver_Name.equals("")) {
                        Toast.makeText(this, "驾驶员不能为空", Toast.LENGTH_LONG).show();
                    } else {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // TODO Auto-generated method stub
                                DBHandler db = new DBHandler();
                                String res = db.accidentCommitValue(turl, atAtDate, atTime, car_No, busCode, depId,
                                        depName, line, profileId, type_, zeren, xingzhi, atPleace,
                                        atReason, "", sideName, sideSex, sideContact, sideCarPlate, sideLicenseNum,
                                        atOtherPay, atPersonPay, userCode);
                                if (res.equals("")) {
                                    handler.sendEmptyMessage(22);
                                } else {
                                    handler.sendEmptyMessage(33);
                                }

                            }
                        }).start();
                    }
                }
                break;

        }
    }

    /**
     * 图片选择权限回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Constant.TAG_ONE:
                if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Matisse.from(ShiGuActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(8)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.hy.powerplatform.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .thumbnailScale(0.3f)  //图片缩放比例
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(TAG_ONE);//
                } else {
                    Toast.makeText(this, "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                break;
            case Constant.TAG_TWO:
                if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLatAndLod();
                } else {
                    Toast.makeText(this, "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constant.TAG_ONE:
                List<Uri> result = new ArrayList<>();
                /** 调用原生文件管理器，根据返回选择的文件，来进行操作 **/
                if (resultCode == Activity.RESULT_OK) {
                    result = Matisse.obtainResult(data);
                }
                for (int i = 0; i < result.size(); i++) {
                    if (result.size() != 1) {
                        String path = UriTrytoPath.getImageAbsolutePath(this, result.get(i));
                        mResults.add(path);
                    } else {
                        BitmapFactory.Options opts = new BitmapFactory.Options();//获取缩略图显示到屏幕上
                        opts.inSampleSize = 4;
                        Bitmap cbitmap01 = null;
                        try {
                            cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(0));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Matrix matrix = new Matrix();
                        matrix.setScale(0.1f, 0.1f);
                        Bitmap bm = Bitmap.createBitmap(cbitmap01, 0, 0, cbitmap01.getWidth(),
                                cbitmap01.getHeight(), matrix, true);
                        imageView1.setImageBitmap(cbitmap01);
                        wssaveImageToSD(bm, "temp");
                        tag = true;
                    }
                }
                if (resultCode == RESULT_OK) {
                    Bitmap cbitmap01 = null;
                    Bitmap cbitmap02 = null;
                    Bitmap cbitmap03 = null;
                    Bitmap cbitmap04 = null;
                    Bitmap cbitmap05 = null;
                    Bitmap cbitmap06 = null;
                    Bitmap cbitmap07 = null;
                    Bitmap cbitmap08 = null;
//                    if (result.size() == 1) {
//                        try {
//                            cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(0));
//                            imageView1.setImageBitmap(cbitmap01);
//                            //图片存储到本地
//                            saveImageToSD(mResults, "temp");
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
                    if (result.size() == 2) {
                        try {
                            cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(0));
                            cbitmap02 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(1));
                            imageView1.setImageBitmap(cbitmap01);
                            imageView2.setImageBitmap(cbitmap02);
                            //图片存储到本地
                            saveImageToSD(mResults, "temp");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (mResults.size() == 3) {
                        linearLayout1.setVisibility(View.VISIBLE);
                        try {
                            cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(0));
                            cbitmap02 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(1));
                            cbitmap03 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(2));
                            imageView1.setImageBitmap(cbitmap01);
                            imageView2.setImageBitmap(cbitmap02);
                            imageView3.setImageBitmap(cbitmap03);
                            //图片存储到本地
                            saveImageToSD(mResults, "temp");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (mResults.size() == 4) {
                        linearLayout1.setVisibility(View.VISIBLE);
                        try {
                            cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(0));
                            cbitmap02 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(1));
                            cbitmap03 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(2));
                            cbitmap04 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(3));
                            imageView1.setImageBitmap(cbitmap01);
                            imageView2.setImageBitmap(cbitmap02);
                            imageView3.setImageBitmap(cbitmap03);
                            imageView4.setImageBitmap(cbitmap04);
                            //图片存储到本地
                            saveImageToSD(mResults, "temp");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (mResults.size() == 5) {
                        linearLayout1.setVisibility(View.VISIBLE);
                        linearLayout2.setVisibility(View.VISIBLE);
                        try {
                            cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(0));
                            cbitmap02 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(1));
                            cbitmap03 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(2));
                            cbitmap04 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(3));
                            cbitmap05 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(4));
                            imageView1.setImageBitmap(cbitmap01);
                            imageView2.setImageBitmap(cbitmap02);
                            imageView3.setImageBitmap(cbitmap03);
                            imageView4.setImageBitmap(cbitmap04);
                            imageView5.setImageBitmap(cbitmap05);
                            //图片存储到本地
                            saveImageToSD(mResults, "temp");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (mResults.size() == 6) {
                        linearLayout1.setVisibility(View.VISIBLE);
                        linearLayout2.setVisibility(View.VISIBLE);
                        try {
                            cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(0));
                            cbitmap02 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(1));
                            cbitmap03 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(2));
                            cbitmap04 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(3));
                            cbitmap05 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(4));
                            cbitmap06 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(5));
                            imageView1.setImageBitmap(cbitmap01);
                            imageView2.setImageBitmap(cbitmap02);
                            imageView3.setImageBitmap(cbitmap03);
                            imageView4.setImageBitmap(cbitmap04);
                            imageView5.setImageBitmap(cbitmap05);
                            imageView6.setImageBitmap(cbitmap06);
                            //图片存储到本地
                            saveImageToSD(mResults, "temp");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (mResults.size() == 7) {
                        linearLayout1.setVisibility(View.VISIBLE);
                        linearLayout2.setVisibility(View.VISIBLE);
                        linearLayout3.setVisibility(View.VISIBLE);
                        try {
                            cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(0));
                            cbitmap02 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(1));
                            cbitmap03 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(2));
                            cbitmap04 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(3));
                            cbitmap05 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(4));
                            cbitmap06 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(5));
                            cbitmap07 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(6));
                            imageView1.setImageBitmap(cbitmap01);
                            imageView2.setImageBitmap(cbitmap02);
                            imageView3.setImageBitmap(cbitmap03);
                            imageView4.setImageBitmap(cbitmap04);
                            imageView5.setImageBitmap(cbitmap05);
                            imageView6.setImageBitmap(cbitmap06);
                            imageView7.setImageBitmap(cbitmap07);
                            //图片存储到本地
                            saveImageToSD(mResults, "temp");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (mResults.size() == 8) {
                        linearLayout1.setVisibility(View.VISIBLE);
                        linearLayout2.setVisibility(View.VISIBLE);
                        linearLayout3.setVisibility(View.VISIBLE);
                        try {
                            cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(0));
                            cbitmap02 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(1));
                            cbitmap03 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(2));
                            cbitmap04 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(3));
                            cbitmap05 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(4));
                            cbitmap06 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(5));
                            cbitmap07 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(6));
                            cbitmap08 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(7));
                            imageView1.setImageBitmap(cbitmap01);
                            imageView2.setImageBitmap(cbitmap02);
                            imageView3.setImageBitmap(cbitmap03);
                            imageView4.setImageBitmap(cbitmap04);
                            imageView5.setImageBitmap(cbitmap05);
                            imageView6.setImageBitmap(cbitmap06);
                            imageView7.setImageBitmap(cbitmap07);
                            imageView8.setImageBitmap(cbitmap08);
                            //图片存储到本地
                            saveImageToSD(mResults, "temp");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            case TAG_TWO:
//                if (resultCode == Constant.TAG_THERE) {
//                    carName = data.getStringExtra("bian");
//                    carNameId = data.getStringExtra("bianId");
//                    etSelectCar.setText(carName);
//                }
                if (resultCode == Constant.TAG_THERE) {
                    carName = data.getStringExtra("bian");
                    busCode = data.getStringExtra("bianId");
                    etSelectCar.setText(carName);
                    line = etSelectLine.getText().toString();
                    getCorrelationData(busCode);
                }
                break;
            case Constant.TAG_THERE:
//                if (resultCode == Constant.TAG_FOUR) {
//                    line = data.getStringExtra("bian");
//                    lineCode = data.getStringExtra("bianCode");
//                    depName = data.getStringExtra("bianName");
//                    depId = data.getStringExtra("bianId");
//                    etSelectLine.setText(lineCode);
//                }
                if (resultCode == Constant.TAG_FOUR) {
                    line = data.getStringExtra("bianCode");
                    depId = data.getStringExtra("bianId");
                    depName = data.getStringExtra("bianName");
                    etSelectLine.setText(line);
                }
                break;
            case Constant.TAG_FOUR:
                if (resultCode == Constant.TAG_FIVE) {
                    String line = data.getStringExtra("bianName");
                    driverName = data.getStringExtra("bianName");
                    profileId = data.getStringExtra("bianId");
                    sex = data.getStringExtra("bianSex");
                    checkUserCode = data.getStringExtra("bianUserCode");
                    etSelectDriver.setText(line);
                }
                break;
        }
    }

    /**
     * 图片保存到本地
     *
     * @param dirPath
     */

    private void saveImageToSD(ArrayList<String> mResults, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }
        for (int i = 0; i < mResults.size(); i++) {
            Bitmap cbitmap = BitmapFactory.decodeFile(mResults.get(i));
            Matrix matrix = new Matrix();
            matrix.setScale(0.1f, 0.1f);
            Bitmap bm = Bitmap.createBitmap(cbitmap, 0, 0, cbitmap.getWidth(),
                    cbitmap.getHeight(), matrix, true);
            //新建文件存储裁剪后的图片
            File img = new File(tmpDir.getAbsolutePath() + "/" + "shigu" + String.valueOf(i) + ".png");
            try {
                //打开文件输出流
                FileOutputStream fos = new FileOutputStream(img);
                //将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
                bm.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                //刷新输出流
                fos.flush();
                //关闭输出流
                fos.close();
                //返回File类型的Uri
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            photoPath.add(String.valueOf(img));
//            //getImageFromSD(dirPath);
//            Map<String, String> map = new HashMap<>();
//            map.put(String.valueOf(tag), "shigu" + ".png");
//            imageList.add(map);
        }

    }

    private Handler handlerSend = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    final String turl = BASE_URL + "busmanager/saveNewAccidentBasicInformation.do";
                    final String dateText = tvTime.getText().toString().trim();
                    if (dateText.equals("")) {
                        Toast.makeText(ShiGuActivity.this, "事故时间不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }
                    final String line_Code = etSelectLine.getText().toString().trim();
                    if (line_Code.equals("")) {
                        Toast.makeText(ShiGuActivity.this, "线路编号不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }
                    final String car_No = etSelectCar.getText().toString().trim();
                    if (car_No.equals("")) {
                        Toast.makeText(ShiGuActivity.this, "车牌号码不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }
                    final String driver_Name = etSelectDriver.getText().toString().trim();
                    if (driver_Name.equals("")) {
                        Toast.makeText(ShiGuActivity.this, "驾驶员不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }
                    final String atAtDate = tvTime.getText().toString().trim();
                    String name = null;
                    if (pathName0 != null) {
                        name = pathName0;
                    }
                    if (pathName1 != null) {
                        name = name + "," + pathName1;
                    }
                    if (pathName2 != null) {
                        name = name + "," + pathName2;
                    }
                    if (pathName3 != null) {
                        name = name + "," + pathName3;
                    }
                    if (pathName4 != null) {
                        name = name + "," + pathName4;
                    }
                    if (pathName5 != null) {
                        name = name + "," + pathName5;
                    }
                    if (pathName6 != null) {
                        name = name + "," + pathName6;
                    }
                    if (pathName7 != null) {
                        name = name + "," + pathName7;
                    }
//                    final String name = pathName0 + "," + pathName1 + "," + pathName2 + "," + pathName3
//                            + "," + pathName4 + "," + pathName5 + "," + pathName6 + "," + pathName7;
                    final String finalName = name;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    // TODO Auto-generated method stub
                                    DBHandler db = new DBHandler();
                                    String res = db.accidentCommitValue(turl, atAtDate, atTime, car_No, busCode, depId,
                                            depName, line, profileId, type_, zeren, xingzhi, atPleace,
                                            atReason, finalName, sideName, sideSex, sideContact, sideCarPlate, sideLicenseNum,
                                            atOtherPay, atPersonPay, userCode);
                                    if (res.equals("")) {
                                        handler.sendEmptyMessage(22);
                                    } else {
                                        handler.sendEmptyMessage(33);
                                    }

                                }
                            }).start();
                        }
                    }, mResults.size());
                }
            }, 500);
        }
    };

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    tag = false;
                    Toast.makeText(ShiGuActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                    refresh();
                    break;
                case TAG_TWO:
                    Toast.makeText(ShiGuActivity.this, "提交失败", Toast.LENGTH_SHORT).show();
                    break;
                case Constant.TAG_FIVE:
                    Bundle b = msg.getData();
                    String msg1 = b.getString("msg");
                    Toast.makeText(ShiGuActivity.this, msg1, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case 22:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(ShiGuActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                    refresh();
                    break;
                case 33:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(ShiGuActivity.this, "提交失败", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private Handler handler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    ShiGuLeiXIngAdapter adapter = new ShiGuLeiXIngAdapter(ShiGuActivity.this);
                    adapter.setDatas(list_1);
                    spShiGuLeiXing.setAdapter(adapter);
                    break;
                case 2:
                    ShiGuZeRenAdapter adapter1 = new ShiGuZeRenAdapter(ShiGuActivity.this);
                    adapter1.setDatas(list_2);
                    spShiGuZeRen.setAdapter(adapter1);
                    break;
                case 3:
                    ShiGuXingZhiAdapter adapter2 = new ShiGuXingZhiAdapter(ShiGuActivity.this);
                    adapter2.setDatas(list_3);
                    spShiGuXingZhi.setAdapter(adapter2);
                    break;
                case 4:
                    ShiGuLeiBieAdapter adapter3 = new ShiGuLeiBieAdapter(ShiGuActivity.this);
                    adapter3.setDatas(list_4);
                    spShiGuLeiBei.setAdapter(adapter3);
                    break;
            }
            ProgressDialogUtil.stopLoad();
        }
    };

    public void refresh() {
        finish();
        Intent intent = new Intent(ShiGuActivity.this, ShiGuActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        deleteFolderFile(Environment.getExternalStorageDirectory() + "/" + dirPath, true);
    }
    //清空文件夹

    public void deleteFolderFile(String filePath, boolean deleteThisPath) {
        if (!TextUtils.isEmpty(filePath)) {
            try {
                File file = new File(filePath);
                if (file.isDirectory()) { //目录
                    File files[] = file.listFiles();
                    for (int i = 0; i < files.length; i++) {
                        deleteFolderFile(files[i].getAbsolutePath(), true);
                    }
                }
                if (deleteThisPath) {
                    if (!file.isDirectory()) { //如果是文件，删除
                        file.delete();
                    } else { //目录
                        if (file.listFiles().length == 0) { //目录下没有文件或者目录，删除
                            file.delete();
                        }
                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取关联数据
     *
     * @param busCode
     */
    private void getCorrelationData(String busCode) {
        String rq = tvTime.getText().toString();
        correctionPresenter.getCorrelationPresenterData(busCode, rq);
    }

    @Override
    public void getCorrelationViewData(Correlat correlat) {
        String car = correlat.getData().getCarNo();
        if (correlat.getData().getCarNo() != null) {
            userCode = correlat.getData().getJsy();
            line = correlat.getData().getXlbh();
            carNo = correlat.getData().getCarNo();
            busCode = correlat.getData().getCh();
            depId = correlat.getData().getDepId();
            depName = correlat.getData().getDepName();
            //String sql = "select * from carcode where name like '%" + userCode + "%'";
            String sql = "select * from inspectDriveP where userCode like " + userCode + "";
            cursor = DbManager.queryBySQL(db, sql, null);
            listInspectDrive = DbManager.cursorToInspectDrive(cursor);
            if (listInspectDrive.size() != 0) {
                carDrive = listInspectDrive.get(0).getFullname();
                profileId = listInspectDrive.get(0).getProfileId();
            }
            String lineText = etSelectLine.getText().toString();
            if (lineText.equals("")) {
                etSelectLine.setText(line);
            }
            etSelectDriver.setText(carDrive);
        } else {
            Toast.makeText(this, "暂无该车辆关联驾驶员，请手动填写", Toast.LENGTH_SHORT).show();
        }
    }

    protected String getAbsoluteImagePath(Uri uri) {
        // can post image
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri,
                proj,       // Which columns to return
                null,       // WHERE clause; which rows to return (all rows)
                null,       // WHERE clause selection arguments (none)
                null);      // Order-by clause (ascending by name)


        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();

        return cursor.getString(column_index);
    }

    private void wssaveImageToSD(Bitmap cbitmap01, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }

        Random random = new Random();
        //新建文件存储裁剪后的图片
        File img = new File(tmpDir.getAbsolutePath() + "/" + "shigu0" + ".png");
        try {
            //打开文件输出流
            FileOutputStream fos = new FileOutputStream(img);
            //将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
            cbitmap01.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            //刷新输出流
            fos.flush();
            //关闭输出流
            fos.close();
            //返回File类型的Uri
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //getImageFromSD(dirPath);
        Map<String, String> map = new HashMap<>();
        final RequestParams params = new RequestParams();
        ProgressDialogUtil.startLoad(ShiGuActivity.this,"图片上传中");
        File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "shigu0" + ".png");
        String filepath = "shigu0" + ".png";
        try {
            params.put("upload", file);
            params.put("fullname", filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 执行post请求
        // 异步的客户端对象
        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(30000);
        String url = BASE_URL + "busmanager/upLoadImageAccidentBasicInformation.do";
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int arg0, String arg1) {
                super.onSuccess(arg0, arg1);
                try {
                    Log.i("XXX", "XXX");
                    JSONObject jsonObject = new JSONObject(arg1);
                    pathName0 = jsonObject.getString("msg");
                    Message message = new Message();
                    handlerSend1.sendMessage(message);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  byte[] responseBody, Throwable error) {
                super.onFailure(statusCode, headers, responseBody, error);
                Log.i("XXX", "XXXXX");
            }
        });
    }
    private Handler handlerSend1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ProgressDialogUtil.stopLoad();
        }
    };
}
