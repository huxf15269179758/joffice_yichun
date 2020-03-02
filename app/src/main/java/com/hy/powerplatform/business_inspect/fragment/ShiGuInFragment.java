package com.hy.powerplatform.business_inspect.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.hy.powerplatform.business_inspect.activity.InspectDrivePSelectTypeActivity;
import com.hy.powerplatform.business_inspect.activity.InspectLineSelectTypeActivity;
import com.hy.powerplatform.business_inspect.activity.SelectOneCarActivity;
import com.hy.powerplatform.business_inspect.adapter.ShiGuLeiBieAdapter;
import com.hy.powerplatform.business_inspect.adapter.ShiGuLeiXIngAdapter;
import com.hy.powerplatform.business_inspect.adapter.ShiGuXingZhiAdapter;
import com.hy.powerplatform.business_inspect.adapter.ShiGuZeRenAdapter;
import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.bean.DriverP;
import com.hy.powerplatform.business_inspect.bean.InspectDrive;
import com.hy.powerplatform.business_inspect.bean.InspectLine;
import com.hy.powerplatform.business_inspect.bean.ShowLine;
import com.hy.powerplatform.business_inspect.presenter.CarCodePresenter;
import com.hy.powerplatform.business_inspect.presenter.DriverPPresenter;
import com.hy.powerplatform.business_inspect.presenter.InspectDrivePresenter;
import com.hy.powerplatform.business_inspect.presenter.InspectLinePresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CarCodePresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.DriverPPresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.InspectDrivePresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.InspectLinePresenterimpl;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.business_inspect.utils.GetDataThread;
import com.hy.powerplatform.business_inspect.view.CarCodeView;
import com.hy.powerplatform.business_inspect.view.DriverPView;
import com.hy.powerplatform.business_inspect.view.InspectDriveView;
import com.hy.powerplatform.business_inspect.view.InspectLineView;
import com.hy.powerplatform.database.DbManager;
import com.hy.powerplatform.database.MyDatabaseHelper;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.EditTextChange;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.select_photo.ImagesSelectorActivity;
import com.hy.powerplatform.select_photo.SelectorSettings;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

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
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;

/**
 * Created by dell on 2018/6/15.
 */

public class ShiGuInFragment extends Fragment implements CarCodeView, InspectLineView
        , InspectDriveView, DriverPView {
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
    CarCodePresenter carCodePresenter;
    InspectLinePresenter inspectLinePresenter;
    InspectDrivePresenter inspectDrivePresenter;
    public LocationClient mLocationClient = null;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.llTime)
    LinearLayout llTime;
    private MyLocationListener myListener = new MyLocationListener();
    File tmpDir;
    String dirPath = "temp";
    String groupPosition;
    String childPosition;
    String driverName, line;
    String profileId, sex, depId, depName, lineCode, addr, userCode;
    SharedPreferencesHelper sharecPreferencesHelper;
    private ArrayList<String> mResults = new ArrayList<>();//图片list
    private ArrayList<String> photoPath = new ArrayList<>();//图片地址
    List<CarCode.DataBean> listCarCode = new ArrayList<>();
    List<CarCode.DataBean> listCarCodeTest = new ArrayList<>();//判断数据库是否有车牌号信息
    List<InspectLine.DataBean> listInspectLine = new ArrayList<>();//获取线路网络数据
    List<ShowLine> listInspectLineTest = new ArrayList<>();//获取线路数据库数据
    List<InspectDrive.DataBean> listInspectDrive = new ArrayList<>();//获取驾驶员网络数据
    List<InspectDrive.DataBean> listInspectDriveTest = new ArrayList<>();//获取驾驶员数据库数据
    List<DriverP.DataBean> listInspectDrivePTest = new ArrayList<>();//获取驾驶员数据库数据
    //检查小项
    List<List<String>> smallTypeList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    //图片list
    List<Map<String, String>> imageList = new ArrayList<>();
    List<DriverP.DataBean> driviewPList = new ArrayList<>();
    DriverPPresenter driverPPresenter;
    private List<String> list_1 = new ArrayList<String>();
    private List<String> list_2 = new ArrayList<String>();
    private List<String> list_3 = new ArrayList<String>();
    private List<String> list_4 = new ArrayList<String>();
    private List<String> list_5 = new ArrayList<String>();
    private List<String> list_6 = new ArrayList<String>();
    List<String> typeNoList = new ArrayList<String>();
    String type_, zeren, xingzhi, liebie, pathName0, pathName1, pathName2, pathName3;
    String atPleace, atReason, sideName, sideSex, sideContact, sideCarPlate, sideLicenseNum, atOtherPay, atPersonPay;
    Intent intent;
    String atTime;
    private View view;

    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_shiguin, container, false);
        ButterKnife.bind(this, view);
        sharecPreferencesHelper = new SharedPreferencesHelper(getActivity(), "login");
        helper = DbManager.getInstance(MyApplication.getContextObject());
        userCode = sharecPreferencesHelper.getData(getActivity(), "userName", "");
        db = helper.getReadableDatabase();
        carCodePresenter = new CarCodePresenterimpl(this, getActivity());
        inspectLinePresenter = new InspectLinePresenterimpl(this, getActivity());
        inspectDrivePresenter = new InspectDrivePresenterimpl(this, getActivity());
        driverPPresenter = new DriverPPresenterimpl(this, getActivity());
        //driverPPresenter.getDriverPPresenterData();
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

        ProgressDialogUtil.startLoad(getActivity(), Constant.GETDATA);
        //选择时间
        initDatePicker();
        //判断数据库是否有车牌号信息
        decideDbForCarCodeData();
        //判断数据库是否有线路信息
        decideDbForInspectLineData();
        //判断数据库是否有驾驶员信息
        decideDbForInspectDriverPData();
        //请求事故类型
        getShiGuType();
        //请求事责任
        getShiGuZeRen();
        //请求事性质
        getShiGuXingZhi();
        //开始定位
        mLocationClient = new LocationClient(getActivity().getApplicationContext());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);
        mLocationClient.start();
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                    TAG_ONE);
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
        return view;
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
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");
        atTime = simpleDateFormatTime.format(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        tvTime.setText(now.split(" ")[0]);
        tvTime.setText(now);
        tvDate.setText(atTime);

        customDatePicker1 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvTime.setText(time.split(" ")[0]);
                tvDate.setText(atTime);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvTime.setText(time);
                tvDate.setText(atTime);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(true); // 显示时和分
        customDatePicker2.setIsLoop(true); // 允许循环滚动
    }

    /**
     * 判断数据库是否有车牌号信息
     */
    private void decideDbForCarCodeData() {
        //查询数据
        String sqlR = "select * from carcode order by random() limit '" + 10 + "'";// order by random() limit 100
        cursor = DbManager.queryBySQL(db, sqlR, null);
        listCarCodeTest = DbManager.cursorToClassCar(cursor);
        if (listCarCodeTest.size() != 0) {
        } else {
            carCodePresenter.getCarCodePresenterData();
        }
    }

    /**
     * 判断数据库是否有线路信息
     */
    private void decideDbForInspectLineData() {
        //查询数据
        Cursor cursor;
        String sqlR = "select * from inspectLine order by random() limit '" + 1 + "'";// order by random() limit 100
        cursor = DbManager.queryBySQL(db, sqlR, null);
        listInspectLineTest = DbManager.cursorToInspectLine(cursor);
        if (listInspectLineTest.size() != 0) {
        } else {
            inspectLinePresenter.getInspectLinePresenterData();
        }
    }

    /**
     * 判断数据库是否有驾驶员信息
     */
    private void decideDbForInspectDriveData() {
        //查询数据
        Cursor cursor;
        String sqlR = "select * from inspectDrive order by random() limit '" + 1 + "'";// order by random() limit 100
        cursor = DbManager.queryBySQL(db, sqlR, null);
       // listInspectDriveTest = DbManager.cursorToInspectDrive(cursor);
        if (listInspectDriveTest.size() != 0) {
        } else {
            inspectDrivePresenter.getInspectDrivePresenterData();
        }
    }

    /**
     * 判断数据库是否有驾驶员信息
     */
    private void decideDbForInspectDriverPData() {
        //查询数据
        Cursor cursor;
        String sqlR = "select * from inspectDriveP order by random() limit '" + 1 + "'";// order by random() limit 100
        cursor = DbManager.queryBySQL(db, sqlR, null);
        listInspectDrivePTest = DbManager.cursorToInspectDriveP(cursor);
        if (listInspectDrivePTest.size() != 0) {
        } else {
            driverPPresenter.getDriverPPresenterData();
        }
    }


    /**
     * 车牌号回调
     *
     * @param carCode
     */
    @Override
    public void getCarCodeViewData(CarCode carCode) {
        GetDataThread.saveCarCoodeData(carCode, db, helper, listCarCode);
    }

    /**
     * 驾驶人员回掉
     *
     * @param inspectDrive
     */
    @Override
    public void getInspectDriveViewData(InspectDrive inspectDrive) {
        GetDataThread.saveInspectDriveData(inspectDrive, db, helper, listInspectDrive);
    }

    /**
     * 线路回调
     *
     * @param
     */
    @Override
    public void getInspectLineViewData(InspectLine inspectLine) {
        GetDataThread.saveInspectLineData(inspectLine, db, helper, listInspectLine);
    }

    @Override
    public void getDriverPViewData(DriverP driverP) {
        GetDataThread.saveInspectDrivePData(driverP, db, helper, driviewPList);
    }

    @OnClick({R.id.tvTime, R.id.imLineSelect, R.id.imCarSelect, R.id.imDriverSelect, R.id.btn, R.id.imageView1
            , R.id.llOut, R.id.llPeiC,R.id.llTime})
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
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.llTime:
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.imLineSelect:
                String etTextLine = etSelectLine.getText().toString().trim();
                intent = new Intent(getActivity(), InspectLineSelectTypeActivity.class);
                intent.putExtra("condition", etTextLine);
                startActivityForResult(intent, Constant.TAG_THERE);
                break;
            case R.id.imCarSelect:
                String etText = etSelectCar.getText().toString().trim();
                intent = new Intent(getActivity(), SelectOneCarActivity.class);
                intent.putExtra("condition", etText);
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.imDriverSelect:
                String etTextDrive = etSelectDriver.getText().toString().trim();
                intent = new Intent(getActivity(), InspectDrivePSelectTypeActivity.class);
                intent.putExtra("condition", etTextDrive);
                startActivityForResult(intent, Constant.TAG_FOUR);
                break;
            case R.id.imageView1:
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                            TAG_ONE);
                } else {
                    Intent intent = new Intent(getActivity(), ImagesSelectorActivity.class);
                    intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 3);
                    intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 100000);
                    intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
                    startActivityForResult(intent, TAG_ONE);
                }
                break;
            case R.id.btn:
                sideSex = "";
                if (tvAddress.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "定位失败请手动填写", Toast.LENGTH_SHORT).show();
                } else {
                    atPleace = tvAddress.getText().toString();
                }
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
                final String dateText = tvTime.getText().toString().trim();
                if (dateText.equals("")) {
                    Toast.makeText(getActivity(), "事故时间不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                final String line_Code = etSelectLine.getText().toString().trim();
                if (line_Code.equals("")) {
                    Toast.makeText(getActivity(), "线路编号不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                final String car_No = etSelectCar.getText().toString().trim();
                if (car_No.equals("")) {
                    Toast.makeText(getActivity(), "车牌号码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                final String driver_Name = etSelectDriver.getText().toString().trim();
                if (driver_Name.equals("")) {
                    Toast.makeText(getActivity(), "驾驶员不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                final String atAtDate = tvTime.getText().toString();
                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");
                final String atTime = simpleDateFormatTime.format(date);
                ProgressDialogUtil.startLoad(getActivity(), Constant.UPDATA);
                if (mResults.size() == 1) {
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
                                    Log.i("XXX", arg1);
                                    JSONObject jsonObject = new JSONObject(arg1);
                                    pathName0 = jsonObject.getString("msg");
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

                } else if (mResults.size() == 2) {
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
                } else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            DBHandler db = new DBHandler();
                            String res = db.accidentCommitValue(turl, atAtDate, atTime, car_No, carNameId, depId,
                                    depName, lineCode, profileId, type_, zeren, xingzhi, atPleace,
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
                    Intent intent = new Intent(getActivity(), ImagesSelectorActivity.class);
                    intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 3);
                    intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 100000);
                    intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
                    startActivityForResult(intent, Constant.TAG_ONE);
                } else {
                    Toast.makeText(getActivity(), "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constant.TAG_ONE:
                if (resultCode == RESULT_OK) {
                    mResults = data.getStringArrayListExtra(SelectorSettings.SELECTOR_RESULTS);
                    assert mResults != null;

                    // show results in textview
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.format("Totally %d images selected:", mResults.size())).append("\n");
                    for (String result : mResults) {
                        sb.append(result).append("\n");
                    }
                }
                BitmapFactory.Options opts = new BitmapFactory.Options();//获取缩略图显示到屏幕上
                opts.inSampleSize = 2;
                if (mResults.size() == 1) {
                    Bitmap cbitmap01 = BitmapFactory.decodeFile(mResults.get(0), opts);
                    imageView1.setImageBitmap(cbitmap01);
                    //图片存储到本地
                    saveImageToSD(mResults, "temp");
                }
                if (mResults.size() == 2) {
                    Bitmap cbitmap01 = BitmapFactory.decodeFile(mResults.get(0), opts);
                    Bitmap cbitmap02 = BitmapFactory.decodeFile(mResults.get(1), opts);
                    imageView1.setImageBitmap(cbitmap01);
                    imageView2.setImageBitmap(cbitmap02);
                    //图片存储到本地
                    saveImageToSD(mResults, "temp");
                }
                if (mResults.size() == 3) {
                    Bitmap cbitmap01 = BitmapFactory.decodeFile(mResults.get(0), opts);
                    Bitmap cbitmap02 = BitmapFactory.decodeFile(mResults.get(1), opts);
                    Bitmap cbitmap03 = BitmapFactory.decodeFile(mResults.get(2), opts);
                    imageView1.setImageBitmap(cbitmap01);
                    imageView2.setImageBitmap(cbitmap02);
                    imageView3.setImageBitmap(cbitmap03);
                    //图片存储到本地
                    saveImageToSD(mResults, "temp");
                }
                if (mResults.size() == 4) {
                    Bitmap cbitmap01 = BitmapFactory.decodeFile(mResults.get(0), opts);
                    Bitmap cbitmap02 = BitmapFactory.decodeFile(mResults.get(1), opts);
                    Bitmap cbitmap03 = BitmapFactory.decodeFile(mResults.get(2), opts);
                    Bitmap cbitmap04 = BitmapFactory.decodeFile(mResults.get(3), opts);
                    imageView1.setImageBitmap(cbitmap01);
                    imageView2.setImageBitmap(cbitmap02);
                    imageView3.setImageBitmap(cbitmap03);
                    imageView4.setImageBitmap(cbitmap04);
                    //图片存储到本地
                    saveImageToSD(mResults, "temp");
                }
                break;
            case Constant.TAG_TWO:
                if (resultCode == Constant.TAG_THERE) {
                    carName = data.getStringExtra("bian");
                    carNameId = data.getStringExtra("bianId");
                    etSelectCar.setText(carName);
                }
                break;
            case Constant.TAG_THERE:
                if (resultCode == Constant.TAG_FOUR) {
                    line = data.getStringExtra("bian");
                    lineCode = data.getStringExtra("bianCode");
                    depName = data.getStringExtra("bianName");
                    depId = data.getStringExtra("bianId");
                    etSelectLine.setText(lineCode);
                }
                break;
            case Constant.TAG_FOUR:
                if (resultCode == Constant.TAG_FIVE) {
                    String line = data.getStringExtra("bianName");
                    driverName = data.getStringExtra("bianName");
                    profileId = data.getStringExtra("bianId");
                    sex = data.getStringExtra("bianSex");
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
            //新建文件存储裁剪后的图片
            File img = new File(tmpDir.getAbsolutePath() + "/" + "shigu" + String.valueOf(i) + ".png");
            try {
                //打开文件输出流
                FileOutputStream fos = new FileOutputStream(img);
                //将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
                cbitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
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
                        Toast.makeText(getActivity(), "事故时间不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }
                    final String line_Code = etSelectLine.getText().toString().trim();
                    if (line_Code.equals("")) {
                        Toast.makeText(getActivity(), "线路编号不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }
                    final String car_No = etSelectCar.getText().toString().trim();
                    if (car_No.equals("")) {
                        Toast.makeText(getActivity(), "车牌号码不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }
                    final String driver_Name = etSelectDriver.getText().toString().trim();
                    if (driver_Name.equals("")) {
                        Toast.makeText(getActivity(), "驾驶员不能为空", Toast.LENGTH_LONG).show();
                        return;
                    }
                    final String atAtDate = tvTime.getText().toString().trim();
                    final String name = pathName0 + "," + pathName1 + "," + pathName2;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            DBHandler db = new DBHandler();
                            String res = db.accidentCommitValue(turl, atAtDate, atTime, car_No, carNameId, depId,
                                    depName, lineCode, profileId, type_, zeren, xingzhi, atPleace,
                                    atReason, name, sideName, sideSex, sideContact, sideCarPlate, sideLicenseNum,
                                    atOtherPay, atPersonPay, userCode);
                            if (res.equals("")) {
                                handler.sendEmptyMessage(22);
                            } else {
                                handler.sendEmptyMessage(33);
                            }

                        }
                    }).start();
                }
            }, 3500);
        }
    };

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Toast.makeText(getActivity(), "提交成功", Toast.LENGTH_SHORT).show();
                    break;
                case Constant.TAG_TWO:
                    Toast.makeText(getActivity(), "提交失败", Toast.LENGTH_SHORT).show();
                    break;
                case Constant.TAG_THERE:
                    Bundle bundle = msg.getData();
                    groupPosition = bundle.getString("groupPosition");
                    childPosition = bundle.getString("childPosition");
                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                            || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                                TAG_ONE);
                    } else {
                        Intent intent = new Intent(getActivity(), ImagesSelectorActivity.class);
                        intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 1);
                        intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 100000);
                        intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
                        startActivityForResult(intent, TAG_ONE);
                    }
                    break;
                case Constant.TAG_FOUR:
                    Bundle bundle1 = msg.getData();
                    String groupPosition1 = bundle1.getString("groupPosition");
                    String childPosition1 = bundle1.getString("childPosition");
                    int size = 0;
                    if (!groupPosition1.equals("0")) {
                        for (int i = 0; i < Integer.valueOf(groupPosition1); i++) {
                            size = size + (smallTypeList.get(i).size());
                        }
                        size = size + Integer.valueOf(childPosition1);
                    } else {
                        size = Integer.parseInt(childPosition1);
                    }
                    typeNoList.add(String.valueOf(size));
                    Log.i("size", String.valueOf(typeNoList.size()));
                    Log.i("sizet", typeNoList.toString());
                    break;
                case Constant.TAG_FIVE:
                    Bundle b = msg.getData();
                    String msg1 = b.getString("msg");
                    Toast.makeText(getActivity(), msg1, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case 22:
                    ProgressDialogUtil.stopLoad();
                    etSelectDriver.setText("");
                    etSelectCar.setText("");
                    etSelectLine.setText("");
                    etOutName.setText("");
                    etOutPhone.setText("");
                    etOutCarNo.setText("");
                    etCarId.setText("");
                    etDiredP.setText("");
                    etOutP.setText("");
                    etBeiZhu.setText("");
                    imageView1.setImageResource(R.drawable.photo);
                    imageView2.setImageBitmap(null);
                    imageView3.setImageBitmap(null);
                    Toast.makeText(getActivity(), "提交成功", Toast.LENGTH_SHORT).show();
                    break;
                case 33:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(getActivity(), "提交失败", Toast.LENGTH_SHORT).show();
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
                    ShiGuLeiXIngAdapter adapter = new ShiGuLeiXIngAdapter(getActivity());
                    adapter.setDatas(list_1);
                    spShiGuLeiXing.setAdapter(adapter);
                    break;
                case 2:
                    ShiGuZeRenAdapter adapter1 = new ShiGuZeRenAdapter(getActivity());
                    adapter1.setDatas(list_2);
                    spShiGuZeRen.setAdapter(adapter1);
                    break;
                case 3:
                    ShiGuXingZhiAdapter adapter2 = new ShiGuXingZhiAdapter(getActivity());
                    adapter2.setDatas(list_3);
                    spShiGuXingZhi.setAdapter(adapter2);
                    break;
                case 4:
                    ShiGuLeiBieAdapter adapter3 = new ShiGuLeiBieAdapter(getActivity());
                    adapter3.setDatas(list_4);
                    spShiGuLeiBei.setAdapter(adapter3);
                    break;
            }
            ProgressDialogUtil.stopLoad();
        }
    };


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}

