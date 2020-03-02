package com.hy.powerplatform.business_inspect.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.adapter.ShiGuLeiXIngAdapter;
import com.hy.powerplatform.business_inspect.adapter.ShiGuXingZhiAdapter;
import com.hy.powerplatform.business_inspect.adapter.ShiGuZeRenAdapter;
import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.bean.DriverP;
import com.hy.powerplatform.business_inspect.bean.InspectLine;
import com.hy.powerplatform.business_inspect.bean.ShiGuHis;
import com.hy.powerplatform.business_inspect.bean.ShowLine;
import com.hy.powerplatform.business_inspect.presenter.CarCodePresenter;
import com.hy.powerplatform.business_inspect.presenter.DriverPPresenter;
import com.hy.powerplatform.business_inspect.presenter.InspectLinePresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CarCodePresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.DriverPPresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.InspectLinePresenterimpl;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.business_inspect.utils.GetDataThread;
import com.hy.powerplatform.business_inspect.view.CarCodeView;
import com.hy.powerplatform.business_inspect.view.DriverPView;
import com.hy.powerplatform.business_inspect.view.InspectLineView;
import com.hy.powerplatform.database.DbManager;
import com.hy.powerplatform.database.MyDatabaseHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.EditTextChange;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;

public class ShiGuCheckActivity extends BaseActivity implements CarCodeView, InspectLineView
        , DriverPView {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.imTimeSelect)
    ImageView imTimeSelect;
    @BindView(R.id.tvAddress)
    EditText tvAddress;
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
    @BindView(R.id.spShiGuLeiXing)
    Spinner spShiGuLeiXing;
    @BindView(R.id.ivShiGu)
    ImageView ivShiGu;
    @BindView(R.id.spShiGuZeRen)
    Spinner spShiGuZeRen;
    @BindView(R.id.tvZeRen)
    TextView tvZeRen;
    @BindView(R.id.ivZeRen)
    ImageView ivZeRen;
    @BindView(R.id.spShiGuXingZhi)
    Spinner spShiGuXingZhi;
    @BindView(R.id.tvXingZhi)
    TextView tvXingZhi;
    @BindView(R.id.ivXingZhi)
    ImageView ivXingZhi;
    @BindView(R.id.llOut)
    LinearLayout llOut;
    @BindView(R.id.etOutName)
    EditText etOutName;
    @BindView(R.id.etOutPhone)
    EditText etOutPhone;
    @BindView(R.id.etOutCarNo)
    EditText etOutCarNo;
    @BindView(R.id.etCarId)
    EditText etCarId;
    @BindView(R.id.llOutShow)
    LinearLayout llOutShow;
    @BindView(R.id.llPeiC)
    LinearLayout llPeiC;
    @BindView(R.id.etDiredP)
    EditText etDiredP;
    @BindView(R.id.etOutP)
    EditText etOutP;
    @BindView(R.id.llPeiCShow)
    LinearLayout llPeiCShow;
    @BindView(R.id.etBeiZhu)
    EditText etBeiZhu;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.activity_shi_gu_check)
    LinearLayout activityShiGuCheck;

    CarCodePresenter carCodePresenter;
    InspectLinePresenter inspectLinePresenter;
    DriverPPresenter driverPPresenter;
    List<CarCode.DataBean> listCarCode = new ArrayList<>();
    List<CarCode.DataBean> listCarCodeTest = new ArrayList<>();//判断数据库是否有车牌号信息
    List<InspectLine.DataBean> listInspectLine = new ArrayList<>();//获取线路网络数据
    List<ShowLine> listInspectLineTest = new ArrayList<>();//获取线路数据库数据
    List<DriverP.DataBean> listInspectDrivePTest = new ArrayList<>();//获取驾驶员数据库数据
    List<DriverP.DataBean> driviewPList = new ArrayList<>();
    @BindView(R.id.tvShiGuLeiXing)
    TextView tvShiGuLeiXing;
    @BindView(R.id.tvShiGuZeRen)
    TextView tvShiGuZeRen;
    @BindView(R.id.tvShiGuXingZhi)
    TextView tvShiGuXingZhi;
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
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.llTime)
    LinearLayout llTime;
    private List<String> list_1 = new ArrayList<String>();
    private List<String> list_2 = new ArrayList<String>();
    private List<String> list_3 = new ArrayList<String>();
    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    String atPleace, atReason, sideName, sideSex, sideContact, sideCarPlate, sideLicenseNum, atOtherPay, atPersonPay;
    String profileId, sex, depId, depName, lineCode, addr, userCode, carName, carNameId, type_, zeren, xingzhi, driverName, line, atTreatmentId, partyId;
    ShiGuHis.ResultBean bean;
    List<DriverP.DataBean> listInspectDrive = new ArrayList<>();
    Intent intent;
    SQLiteDatabase db;
    Cursor cursor;
    MyDatabaseHelper helper;

    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        initDatePicker();

        carCodePresenter = new CarCodePresenterimpl(this, this);
        inspectLinePresenter = new InspectLinePresenterimpl(this, this);
        driverPPresenter = new DriverPPresenterimpl(this, this);

        new EditTextChange(etSelectLine).changeText();
        new EditTextChange(etSelectCar).changeText();
        new EditTextChange(etSelectDriver).changeText();
        new EditTextChange(etOutName).changeText();
        new EditTextChange(etOutPhone).changeText();
        new EditTextChange(etOutCarNo).changeText();
        new EditTextChange(etCarId).changeText();
        new EditTextChange(etDiredP).changeText();
        new EditTextChange(etOutP).changeText();
        new EditTextChange(etBeiZhu).changeText();

        Intent intent = getIntent();
        bean = (ShiGuHis.ResultBean) intent.getSerializableExtra("content");

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
        setData();

        spShiGuLeiXing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvShiGuLeiXing.setText(spShiGuLeiXing.getSelectedItem().toString());
                type_ = spShiGuLeiXing.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spShiGuZeRen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvShiGuZeRen.setText(spShiGuZeRen.getSelectedItem().toString());
                zeren = spShiGuZeRen.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spShiGuXingZhi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvShiGuXingZhi.setText(spShiGuXingZhi.getSelectedItem().toString());
                xingzhi = spShiGuXingZhi.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setData() {
        tvTime.setText(bean.getAtAtDate());
        tvAddress.setText(bean.getAtPlace());
        etSelectLine.setText(bean.getLineCode());
        etSelectCar.setText(bean.getCarNo());
        etSelectDriver.setText(bean.getDriverName());
        tvShiGuLeiXing.setText(bean.getAtType());
        tvShiGuZeRen.setText(bean.getAtLiability());
        tvShiGuXingZhi.setText(bean.getAcNature());
        etOutName.setText(bean.getSideName());
        etOutPhone.setText(bean.getSideContact());
        etOutCarNo.setText(bean.getSideCarPlate());
        etCarId.setText(bean.getSideLicenseNum());
        etDiredP.setText(bean.getAtPersonPay());
        etOutP.setText(bean.getAtOtherPay());
        etBeiZhu.setText(bean.getAtReason());

        carNameId = bean.getBusCode();
        depId = bean.getDepId();
        depName = bean.getDepName();
        lineCode = bean.getLineCode();
        type_ = bean.getAtType();
        zeren = bean.getAtLiability();
        xingzhi = bean.getAcNature();
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(this,"login");
        userCode = sharedPreferencesHelper.getData(this, "userName", "");
        String sql = "select * from inspectDriveP where fullname = '" + bean.getDriverName() + "'";
        cursor = DbManager.queryBySQL(db, sql, null);
        listInspectDrive = DbManager.cursorToInspectDriveP(cursor);
        profileId = listInspectDrive.get(0).getProfileId();
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        //currentTime.setText(now);

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvTime.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvTime.setText(time);
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

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_shi_gu_check;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.tvTime, R.id.imLineSelect, R.id.imCarSelect, R.id.imDriverSelect, R.id.ivShiGu,
            R.id.ivZeRen, R.id.ivXingZhi, R.id.btn, R.id.llOut, R.id.llPeiC, R.id.llTime})
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
                intent = new Intent(this, InspectLineSelectTypeActivity.class);
                intent.putExtra("condition", etTextLine);
                startActivityForResult(intent, Constant.TAG_THERE);
                break;
            case R.id.imCarSelect:
                String etText = etSelectCar.getText().toString().trim();
                intent = new Intent(this, SelectOneCarActivity.class);
                intent.putExtra("condition", etText);
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.imDriverSelect:
                String etTextDrive = etSelectDriver.getText().toString().trim();
                intent = new Intent(this, InspectDrivePSelectTypeActivity.class);
                intent.putExtra("condition", etTextDrive);
                startActivityForResult(intent, Constant.TAG_FOUR);
                break;
            case R.id.ivShiGu:
                tvShiGuLeiXing.setVisibility(View.GONE);
                spShiGuLeiXing.setVisibility(View.VISIBLE);
                spShiGuLeiXing.performClick();
                break;
            case R.id.ivZeRen:
                tvShiGuZeRen.setVisibility(View.GONE);
                spShiGuZeRen.setVisibility(View.VISIBLE);
                spShiGuZeRen.performClick();
                break;
            case R.id.ivXingZhi:
                tvShiGuXingZhi.setVisibility(View.GONE);
                spShiGuXingZhi.setVisibility(View.VISIBLE);
                spShiGuXingZhi.performClick();
                break;
            case R.id.btn:
                sendData();
                break;
        }
    }

    /**
     * 向服务器传递数据
     */
    private void sendData() {
        sideSex = "";
        if (tvAddress.getText().toString().isEmpty()) {
            Toast.makeText(this, "定位失败请手动填写", Toast.LENGTH_SHORT).show();
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
        if (!etOutP.getText().toString().equals("0.0")) {
            atOtherPay = etOutP.getText().toString();
        } else {
            atOtherPay = "";
        }
        if (!etDiredP.getText().toString().equals("0.0")) {
            atPersonPay = etDiredP.getText().toString();
        } else {
            atPersonPay = "";
        }
        // 保存文字信息
        final String turl = BASE_URL + "busmanager/saveNewAccidentBasicInformation.do";
        final String dateText = tvTime.getText().toString().trim();
        if (dateText.equals("")) {
            Toast.makeText(this, "事故时间不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        final String line_Code = etSelectLine.getText().toString().trim();
        if (line_Code.equals("")) {
            Toast.makeText(this, "线路编号不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        final String car_No = etSelectCar.getText().toString().trim();
        if (car_No.equals("")) {
            Toast.makeText(this, "车牌号码不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        final String driver_Name = etSelectDriver.getText().toString().trim();
        if (driver_Name.equals("")) {
            Toast.makeText(this, "驾驶员不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        final String atAtDate = tvTime.getText().toString().trim();
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");
        final String atTime = simpleDateFormatTime.format(date);
        ProgressDialogUtil.startLoad(this, Constant.UPDATA);
        final String atId = bean.getAtId();
        partyId = bean.getPartyId();
        if (partyId.equals("0")) {
            partyId = "";
        }
        atTreatmentId = bean.getAtTreatmentId();
        if (atTreatmentId.equals("0")) {
            atTreatmentId = "";
        }
        //String partyId = bean.getPar
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                DBHandler db = new DBHandler();
                String res = db.accidentCommitValue(turl, atAtDate, atTime, car_No, carNameId, depId,
                        depName, lineCode, profileId, type_, zeren, xingzhi, atPleace,
                        atReason, "", sideName, sideSex, sideContact, sideCarPlate, sideLicenseNum,
                        atOtherPay, atPersonPay, userCode, atId, partyId, atTreatmentId);
                if (res.equals("")) {
                    handler.sendEmptyMessage(22);
                } else {
                    handler.sendEmptyMessage(33);
                }

            }
        }).start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_ONE:
                if (resultCode == RESULT_OK) {
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

    private Handler handler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    ShiGuLeiXIngAdapter adapter = new ShiGuLeiXIngAdapter(ShiGuCheckActivity.this);
                    adapter.setDatas(list_1);
                    spShiGuLeiXing.setAdapter(adapter);
                    break;
                case 2:
                    ShiGuZeRenAdapter adapter1 = new ShiGuZeRenAdapter(ShiGuCheckActivity.this);
                    adapter1.setDatas(list_2);
                    spShiGuZeRen.setAdapter(adapter1);
                    break;
                case 3:
                    ShiGuXingZhiAdapter adapter2 = new ShiGuXingZhiAdapter(ShiGuCheckActivity.this);
                    adapter2.setDatas(list_3);
                    spShiGuXingZhi.setAdapter(adapter2);
                    break;
            }
            ProgressDialogUtil.stopLoad();
        }
    };
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 22:
                    ProgressDialogUtil.stopLoad();
//                    etSelectDriver.setText("");
//                    etSelectCar.setText("");
//                    etSelectLine.setText("");
//                    etOutName.setText("");
//                    etOutPhone.setText("");
//                    etOutCarNo.setText("");
//                    etCarId.setText("");
//                    etDiredP.setText("");
//                    etOutP.setText("");
//                    etBeiZhu.setText("");
//                    imageView1.setImageResource(R.drawable.photo);
//                    imageView2.setImageBitmap(null);
//                    imageView3.setImageBitmap(null);
                    Toast.makeText(ShiGuCheckActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                    break;
                case 33:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(ShiGuCheckActivity.this, "提交失败", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

}
