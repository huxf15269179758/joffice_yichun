package com.hy.powerplatform.business_inspect.newactivity;

import android.Manifest;
import android.content.ContentValues;
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
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.activity.InspectDriveSelectTypeActivity;
import com.hy.powerplatform.business_inspect.activity.InspectLineSelectTypeActivity;
import com.hy.powerplatform.business_inspect.activity.SelectOneCarActivity;
import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.bean.Correlat;
import com.hy.powerplatform.business_inspect.bean.InspectStarte;
import com.hy.powerplatform.business_inspect.bean.NewDriver;
import com.hy.powerplatform.business_inspect.newadapter.InspectAllAQAdapter;
import com.hy.powerplatform.business_inspect.newadapter.InspectAllGFAdapter;
import com.hy.powerplatform.business_inspect.newadapter.InspectAllJNAdapter;
import com.hy.powerplatform.business_inspect.presenter.CorrelationPresenter;
import com.hy.powerplatform.business_inspect.presenter.InspectStartePresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CorrectionPresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.InspectStartePresenterimpl;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.business_inspect.view.CorrelationView;
import com.hy.powerplatform.business_inspect.view.InspectStarteView;
import com.hy.powerplatform.database.DbManager;
import com.hy.powerplatform.database.MyDatabaseHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.EditTextChange;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.MyRecyclerView;
import com.hy.powerplatform.my_utils.utils.HttpURLConnectionCallBackListener;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.Util;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import org.json.JSONArray;
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

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FIVE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class InspectStarteActivity extends BaseActivity implements InspectStarteView,
        InspectAllAQAdapter.GetItemPosition,
        InspectAllJNAdapter.GetJNItemPosition,
        InspectAllGFAdapter.GetGFItemPosition,
        CorrelationView {

    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.etSelectCar)
    EditText etSelectCar;
    @BindView(R.id.imCarSelect)
    ImageView imCarSelect;
    @BindView(R.id.etSelectAddress)
    EditText etSelectAddress;
    @BindView(R.id.btn)
    Button btn;

    String gffwYrybyt = "0";
    String gffwYrybytBz = "";
    String gffwYrybytPic = "";
    String gffwPth = "0";
    String gffwPthBz = "";
    String gffwPthPic = "";
    String gffwSzwmyy = "0";
    String gffwSzwmyyBz = "";
    String gffwSzwmyyPic = "";
    String gffwFwyytd = "0";
    String gffwFwyytdBz = "";
    String gffwFwyytdPic = "";
    String gffwZgsd = "0";
    String gffwZgsdBz = "";
    String gffwZgsdPic = "";
    String gffwBaozhanqi = "0";
    String gffwBaozhanqiBz = "";
    String gffwBaozhanqiPic = "";
    String gffwClws = "0";
    String gffwClwsBz = "";
    String gffwClwsPic = "";
    String gffwWpbf = "0";
    String gffwWpbfBz = "";
    String gffwWpbfPic = "";
    String gffwLEDlp = "0";
    String gffwLEDlpBz = "";
    String gffwLEDlpPic = "";
    String gffwClbz = "0";
    String gffwClbzBz = "";
    String gffwClbzPic = "";
    String gffwFwzsp = "0";
    String gffwFwzspBz = "";
    String gffwFwzspPic = "";
    String gffwWendutf = "0";
    String gffwWendutfBz = "";
    String gffwWendutfPic = "";
    String gffwGuzhanghc = "0";
    String gffwGuzhanghcBz = "";
    String gffwGuzhanghcPic = "";
    String gffwFuwuts = "0";
    String gffwFuwutsBz = "";
    String gffwFuwutsPic = "";

    String jsjnTingzhansk = "0";
    String jsjnTingzhanskBz = "";
    String jsjnTingzhanskPic = "";
    String jsjnJiashiypcl = "0";
    String jsjnJiashiypclBz = "";
    String jsjnJiashiypclPic = "";
    String jsjnYibiaojc = "0";
    String jsjnYibiaojcBz = "";
    String jsjnYibiaojcPic = "";
    String jsjnLiheqi = "0";
    String jsjnLiheqiBz = "";
    String jsjnLiheqiPic = "";
    String jsjnDwsy = "0";
    String jsjnDwsyBz = "";
    String jsjnDwsyPic = "";
    String jsjnZhuanxiangd = "0";
    String jsjnZhuanxiangdBz = "";
    String jsjnZhuanxiangdPic = "";
    String jsjnGuifantk = "0";
    String jsjnGuifantkBz = "";
    String jsjnGuifantkPic = "";

    String aqxcZuishougz = "0";
    String aqxcZuishougzBz = "";
    String aqxcZuishougzPic = "";
    String aqxcWenmingjs = "0";
    String aqxcWenmingjsBz = "";
    String aqxcWenmingjsPic = "";
    String aqxcChaosu = "0";
    String aqxcChaosuBz = "";
    String aqxcChaosuPic = "";
    String aqxcShigu = "0";
    String aqxcShiguBz = "";
    String aqxcShiguPic = "";
    String aqxcGuifanjcz = "0";
    String aqxcGuifanjczBz = "";
    String aqxcGuifanjczPic = "";
    String aqxcPaolaid = "0";
    String aqxcPaolaidBz = "";
    String aqxcPaolaidPic = "";
    String aqxcKaiguancm = "0";
    String aqxcKaiguancmBz = "";
    String aqxcKaiguancmPic = "";
    String aqxcAnjian = "0";
    String aqxcAnjianBz = "";
    String aqxcAnjianPic = "";
    String aqxcXiaofangss = "0";
    String aqxcXiaofangssBz = "";
    String aqxcXiaofangssPic = "";
    String aqxcZhongdianz = "0";
    String aqxcZhongdianzBz = "";
    String aqxcZhongdianzPic = "";
    String dirPath = "temp";
    int code = 0;

    SQLiteDatabase db;
    MyDatabaseHelper helper;
    String carName, con;
    Cursor cursor;
    File tmpDir;
    String carNo;
    String busCode;
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.etSelectCheck)
    TextView etSelectCheck;
    @BindView(R.id.imCheckSelect)
    ImageView imCheckSelect;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.etSelectLine)
    EditText etSelectLine;
    @BindView(R.id.imLineSelect)
    ImageView imLineSelect;
    @BindView(R.id.etSelectDriver)
    EditText etSelectDriver;
    @BindView(R.id.imDriverSelect)
    ImageView imDriverSelect;

    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    SharedPreferencesHelper sharecPreferencesHelper;
    InspectStartePresenter inspectStartePresenter;
    private ArrayList<String> mResults = new ArrayList<>();
    List<CarCode.DataBean> listCarCode = new ArrayList<>();
    List<CarCode.DataBean> listCarCodeTest = new ArrayList<>();
    int position;
    ImageView imageView;
    @BindView(R.id.tvAnQuan)
    TextView tvAnQuan;
    @BindView(R.id.recyAnQuan)
    MyRecyclerView recyAnQuan;
    @BindView(R.id.tvJiNeng)
    TextView tvJiNeng;
    @BindView(R.id.recyJiNeng)
    MyRecyclerView recyJiNeng;
    @BindView(R.id.tvGuiFan)
    TextView tvGuiFan;
    @BindView(R.id.recyGuiFan)
    MyRecyclerView recyGuiFan;
    //检查结果
    List<Map<String, String>> imageListaq = new ArrayList<>();
    List<Map<String, String>> imageListjn = new ArrayList<>();
    List<Map<String, String>> imageListgf = new ArrayList<>();
    List<Map<String, String>> imageListaq1 = new ArrayList<>();
    List<Map<String, String>> imageListjn1 = new ArrayList<>();
    List<Map<String, String>> imageListgf1 = new ArrayList<>();
    List<String> anquanSList = new ArrayList<>();
    List<String> jinengSList = new ArrayList<>();
    List<String> guifanSList = new ArrayList<>();
    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";
    final String url = BASE_URL + "starkh/upLoadImageYoufushifancheKaohe.do";
    Intent intent;
    String userName;
    String carDrive;
    String driverName, line,userCode, depId, depName;
    CorrelationPresenter correctionPresenter;
    List<NewDriver.DataBean> listInspectDrive = new ArrayList<>();
    List<NewDriver.DataBean> listInspectDrive1 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        sharecPreferencesHelper = new SharedPreferencesHelper(this, "login");
        inspectStartePresenter = new InspectStartePresenterimpl(this, this);
        inspectStartePresenter.getInspectStartePresenterData();
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        //选择时间
        initDatePicker();
        //设置EditText
        new EditTextChange(etSelectCar).changeText();
        new EditTextChange(etSelectDriver).changeText();
        new EditTextChange(etSelectLine).changeText();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyAnQuan.setLayoutManager(manager);
        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        recyJiNeng.setLayoutManager(manager1);
        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        recyGuiFan.setLayoutManager(manager2);
        correctionPresenter = new CorrectionPresenterimpl(this, this);

        String sqlR = "select * from inspectDriveP";// order by random() limit 100
        cursor = DbManager.queryBySQL(db, sqlR, null);
        listInspectDrive1 = DbManager.cursorToInspectDrive(cursor);
        if (listInspectDrive1.size() == 0) {
            ProgressDialogUtil.startLoad(this,"获取数据中");
            String url = BASE_URL+"hrm/profileByPosEmpProfile.do";
            Util.getDataByHttpUrlConnection(url, new HttpURLConnectionCallBackListener() {
                @Override
                public void onSuccess(String s) {
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0;i<jsonArray.length();i++){
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            String name = jsonObject1.getString("fullname");
                            String profileId = jsonObject1.getString("profileId");
                            String sex = jsonObject1.getString("sex");
                            String userCode = jsonObject1.getString("userCode");
                            ContentValues values = new ContentValues();
                            values.put(com.hy.powerplatform.database.Constant.DRIVERNAME, name);
                            values.put(com.hy.powerplatform.database.Constant.DRIVERID, profileId);
                            values.put(com.hy.powerplatform.database.Constant.SEX, sex);
                            values.put(com.hy.powerplatform.database.Constant.USERCODE, userCode);
                            db.insert(com.hy.powerplatform.database.Constant.TABBLE_INSPECT_DRIVE_P, null, values);
                            values.clear();
                        }
                        Message message = new Message();
                        message.what = 66;
                        handler.sendMessage(message);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFaile(Exception e) {

                }
            });
        }
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_inspect_starte;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvTime.setText(now.split(" ")[0]);
        //currentTime.setText(now);

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvTime.setText(time.split(" ")[0]);
            }
        }, now, "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvTime.setText(time);
            }
        }, now, "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(true); // 显示时和分
        customDatePicker2.setIsLoop(true); // 允许循环滚动
    }

    @OnClick({R.id.tvTime, R.id.imCarSelect, R.id.btn, R.id.tvGuiFan, R.id.tvJiNeng,
            R.id.tvAnQuan, R.id.imCheckSelect,R.id.imLineSelect, R.id.imDriverSelect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imLineSelect:
                String etTextLine = etSelectLine.getText().toString().trim();
                intent = new Intent(this, InspectLineSelectTypeActivity.class);
                intent.putExtra("condition", etTextLine);
                startActivityForResult(intent, Constant.TAG_SIX);
                break;
            case R.id.imDriverSelect:
                String etTextDrive = etSelectDriver.getText().toString().trim();
                intent = new Intent(this, InspectDriveSelectTypeActivity.class);
                intent.putExtra("condition", etTextDrive);
                startActivityForResult(intent, Constant.TAG_SEVEN);
                break;
            case R.id.imCheckSelect:
                Intent intent1 = new Intent(this, StarteCheckPersonActivity.class);
                startActivityForResult(intent1, TAG_FIVE);
                break;
            case R.id.tvAnQuan:
                if (recyAnQuan.getVisibility() == View.GONE) {
                    recyAnQuan.setVisibility(View.VISIBLE);
                } else {
                    recyAnQuan.setVisibility(View.GONE);
                }
                break;
            case R.id.tvJiNeng:
                if (recyJiNeng.getVisibility() == View.GONE) {
                    recyJiNeng.setVisibility(View.VISIBLE);
                } else {
                    recyJiNeng.setVisibility(View.GONE);
                }
                break;
            case R.id.tvGuiFan:
                if (recyGuiFan.getVisibility() == View.GONE) {
                    recyGuiFan.setVisibility(View.VISIBLE);
                } else {
                    recyGuiFan.setVisibility(View.GONE);
                }
                break;
            case R.id.tvTime:
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.imCarSelect:
//                String etText = etSelectCar.getText().toString().trim();
//                Intent intent = new Intent(this, SelectOneCarActivity.class);
//                intent.putExtra("condition", etText);
//                startActivityForResult(intent, Constant.TAG_TWO);
                Intent intent = new Intent(this, SelectOneCarActivity.class);
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
            case R.id.btn:
                carNo = etSelectCar.getText().toString();
                if (carNo.isEmpty()) {
                    Toast.makeText(this, "请输入车牌号", Toast.LENGTH_SHORT).show();
                } else if (userName.isEmpty()) {
                    Toast.makeText(this, "请输入检查人", Toast.LENGTH_SHORT).show();
                } else {
                    String sqlR = "select * from carcode where name = '" + etSelectCar.getText().toString() + "'";// order by random() limit 100
                    cursor = DbManager.queryBySQL(db, sqlR, null);
                    listCarCodeTest = DbManager.cursorToClassCar(cursor);
                    ProgressDialogUtil.startLoad(this, Constant.UPDATA);
                    sendInspectData();
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Constant.TAG_ONE:
                if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Matisse.from(InspectStarteActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(1)//可选的最大数
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
                if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Matisse.from(InspectStarteActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(1)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.hy.powerplatform.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .thumbnailScale(0.3f)  //图片缩放比例
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(TAG_THERE);//
                } else {
                    Toast.makeText(this, "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                break;
            case Constant.TAG_THERE:
                if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Matisse.from(InspectStarteActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(1)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.hy.powerplatform.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .thumbnailScale(0.3f)  //图片缩放比例
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(TAG_FOUR);//
                } else {
                    Toast.makeText(this, "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constant.TAG_ONE:
                List<Uri> result1 = new ArrayList<>();
                if (requestCode == TAG_ONE && resultCode == RESULT_OK) {
                    result1 = Matisse.obtainResult(data);
                }
                if (resultCode == RESULT_OK) {
                    BitmapFactory.Options opts = new BitmapFactory.Options();//获取缩略图显示到屏幕上
                    opts.inSampleSize = 2;
                    Bitmap cbitmap01 = null;
                    try {
                        cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result1.get(0));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Matrix matrix = new Matrix();
                    matrix.setScale(0.2f, 0.2f);
                    Bitmap bm = Bitmap.createBitmap(cbitmap01, 0, 0, cbitmap01.getWidth(),
                            cbitmap01.getHeight(), matrix, true);
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageBitmap(bm);
                    aqsaveImageToSD(bm, "temp");
                }
                break;
            case Constant.TAG_TWO:
                if (resultCode == TAG_THERE) {
                    carName = data.getStringExtra("bian");
                    busCode = data.getStringExtra("bianId");
                    etSelectCar.setText(carName);
                    getCorrelationData(busCode);
                }
                break;
            case TAG_THERE:
                List<Uri> result2 = new ArrayList<>();
                if (requestCode == TAG_THERE && resultCode == RESULT_OK) {
                    result2 = Matisse.obtainResult(data);
                }
                if (resultCode == RESULT_OK) {
                    BitmapFactory.Options opts = new BitmapFactory.Options();//获取缩略图显示到屏幕上
                    opts.inSampleSize = 2;
                    Bitmap cbitmap01 = null;
                    try {
                        cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result2.get(0));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Matrix matrix = new Matrix();
                    matrix.setScale(0.2f, 0.2f);
                    Bitmap bm = Bitmap.createBitmap(cbitmap01, 0, 0, cbitmap01.getWidth(),
                            cbitmap01.getHeight(), matrix, true);
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageBitmap(bm);
                    jnSaveImageToSD(bm, "temp");
                }
                break;
            case TAG_FOUR:
                List<Uri> result3 = new ArrayList<>();
                if (requestCode == TAG_FOUR && resultCode == RESULT_OK) {
                    result3 = Matisse.obtainResult(data);
                }
                if (resultCode == RESULT_OK) {
                    BitmapFactory.Options opts = new BitmapFactory.Options();//获取缩略图显示到屏幕上
                    opts.inSampleSize = 2;
                    Bitmap cbitmap01 = null;
                    try {
                        cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result3.get(0));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Matrix matrix = new Matrix();
                    matrix.setScale(0.2f, 0.2f);
                    Bitmap bm = Bitmap.createBitmap(cbitmap01, 0, 0, cbitmap01.getWidth(),
                            cbitmap01.getHeight(), matrix, true);
                    gfSaveImageToSD(bm, "temp");
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageBitmap(bm);
                }
                break;
            case Constant.TAG_FIVE:
                if (resultCode == Constant.TAG_SIX) {
                    userName = data.getStringExtra("name");
                    userCode = data.getStringExtra("profileId");
                    etSelectCheck.setText(userName);
                }
                break;
            case Constant.TAG_SIX:
                if (resultCode == Constant.TAG_FOUR) {
                    line = data.getStringExtra("bianCode");
                    depId = data.getStringExtra("bianId");
                    depName = data.getStringExtra("bianName");
                    etSelectLine.setText(line);
                }
                break;
            case Constant.TAG_SEVEN:
                if (resultCode == Constant.TAG_FIVE) {
                    String line = data.getStringExtra("bian");
                    driverName = data.getStringExtra("bian");
                    userCode = data.getStringExtra("bianId");
                    etSelectDriver.setText(line);
                }
                break;
        }
    }

    private void aqsaveImageToSD(Bitmap cbitmap01, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }

        Random random = new Random();
        //新建文件存储裁剪后的图片
        String imageName = String.valueOf(position)
                + System.currentTimeMillis() + random.nextInt(10) + ".png";
        File img = new File(tmpDir.getAbsolutePath() + "/" + imageName);

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
        Map<String, String> map = new HashMap<>();
        map.put(String.valueOf(position), imageName);
        imageListaq.add(map);
        imageListaq1.add(map);
        for (int i = 0; i < imageListaq.size(); i++) {
            for (String key : imageListaq.get(i).keySet()) {
                final RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + imageListaq.get(i).get(key));
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String name = imageListaq.get(i).get(key);
                try {
                    params.put("upload", file);
                    params.put("fullname", name);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ProgressDialogUtil.startLoad(this,"");
                final AsyncHttpClient client = new AsyncHttpClient();
                client.post(url, params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int arg0, String arg1) {
                        super.onSuccess(arg0, arg1);
                        imageListaq = new ArrayList<Map<String, String>>();
                        Log.i("XXX", "成功");
                        Log.i("XXX", arg1);
                        for (int i = 0; i < imageListaq1.size(); i++) {
                            for (String key : imageListaq1.get(i).keySet()) {
                                if (key.equals("0")) {
                                    aqxcZuishougzPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("1")) {
                                    aqxcWenmingjsPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("2")) {
                                    aqxcChaosuPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("3")) {
                                    aqxcShiguPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("4")) {
                                    aqxcGuifanjczPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("5")) {
                                    aqxcPaolaidPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("6")) {
                                    aqxcKaiguancmPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("7")) {
                                    aqxcAnjianPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("8")) {
                                    aqxcXiaofangssPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("9")) {
                                    aqxcZhongdianzPic = imageListaq1.get(i).get(key);
                                }
                            }
                        }
                        Message message = new Message();
                        message.what = 111;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
        }

    }

    private void jnSaveImageToSD(Bitmap cbitmap01, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }
        Random random = new Random();
        //新建文件存储裁剪后的图片
        String imageName = String.valueOf(position)
                + System.currentTimeMillis() + random.nextInt(10) + ".png";
        File img = new File(tmpDir.getAbsolutePath() + "/" + imageName);

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
        map.put(String.valueOf(position), imageName);
        imageListjn.add(map);
        imageListjn1.add(map);
        for (int i = 0; i < imageListjn.size(); i++) {
            for (String key : imageListjn.get(i).keySet()) {
                final RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + imageListjn.get(i).get(key));
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String name = imageListjn.get(i).get(key);
                try {
                    params.put("upload", file);
                    params.put("fullname", name);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ProgressDialogUtil.startLoad(this,"");
                final AsyncHttpClient client = new AsyncHttpClient();
                client.post(url, params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int arg0, String arg1) {
                        super.onSuccess(arg0, arg1);
                        imageListjn = new ArrayList<Map<String, String>>();
                        Log.i("XXX", "成功");
                        Log.i("XXX", arg1);
                        for (int i = 0; i < imageListjn1.size(); i++) {
                            for (String key : imageListjn1.get(i).keySet()) {
                                if (key.equals("0")) {
                                    jsjnTingzhanskPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("1")) {
                                    jsjnJiashiypclPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("2")) {
                                    jsjnYibiaojcPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("3")) {
                                    jsjnLiheqiPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("4")) {
                                    jsjnDwsyPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("5")) {
                                    jsjnZhuanxiangdPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("6")) {
                                    jsjnGuifantkPic = imageListjn1.get(i).get(key);
                                }
                            }
                        }
                        Message message = new Message();
                        message.what = 111;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
        }
    }

    private void gfSaveImageToSD(Bitmap cbitmap01, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }
        Random random = new Random();
        //新建文件存储裁剪后的图片
        String imageName = String.valueOf(position)
                + System.currentTimeMillis() + random.nextInt(10) + ".png";
        File img = new File(tmpDir.getAbsolutePath() + "/" + imageName);
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f);
        Bitmap bm = Bitmap.createBitmap(cbitmap01, 0, 0, cbitmap01.getWidth(),
                cbitmap01.getHeight(), matrix, true);
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
        //getImageFromSD(dirPath);
        Map<String, String> map = new HashMap<>();
        map.put(String.valueOf(position), imageName);
        imageListgf.add(map);
        imageListgf1.add(map);
        for (int i = 0; i < imageListgf.size(); i++) {
            for (String key : imageListgf.get(i).keySet()) {
                final RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + imageListgf.get(i).get(key));
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String name = imageListgf.get(i).get(key);
                try {
                    params.put("upload", file);
                    params.put("fullname", name);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ProgressDialogUtil.startLoad(this,"");
                final AsyncHttpClient client = new AsyncHttpClient();
                client.post(url, params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int arg0, String arg1) {
                        super.onSuccess(arg0, arg1);
                        imageListgf = new ArrayList<Map<String, String>>();
                        Log.i("XXX", "成功");
                        Log.i("XXX", arg1);
                        for (int i = 0; i < imageListgf1.size(); i++) {
                            for (String key : imageListgf1.get(i).keySet()) {
                                if (key.equals("0")) {
                                    gffwYrybytPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("1")) {
                                    gffwPthPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("2")) {
                                    gffwSzwmyyPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("3")) {
                                    gffwFwyytdPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("4")) {
                                    gffwZgsdPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("5")) {
                                    gffwBaozhanqiPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("6")) {
                                    gffwClwsPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("7")) {
                                    gffwWpbfPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("8")) {
                                    gffwLEDlpPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("9")) {
                                    gffwClbzPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("10")) {
                                    gffwFwzspPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("11")) {
                                    gffwWendutfPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("12")) {
                                    gffwGuzhanghcPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("13")) {
                                    gffwFuwutsPic = imageListgf1.get(i).get(key);
                                }
                            }
                        }
                        Message message = new Message();
                        message.what = 111;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
        }
    }

    /**
     * 设置组的子View的高度
     *
     * @param listView
     * @param groupPosition
     * @param isExpanded
     */
    public static void setChildViewHeight(ExpandableListView listView, int groupPosition, Boolean isExpanded) {
        ExpandableListAdapter listAdapter = listView.getExpandableListAdapter();
        int childTotalHeight = 0;
        View child = null;
        for (int i = 0; i < listAdapter.getChildrenCount(groupPosition); i++) {
            child = listAdapter.getChildView(groupPosition, i, false, null, listView);
            child.measure(0, 0);
            childTotalHeight += child.getMeasuredHeight();
//            RadioButton rbY = (RadioButton) child.findViewById(R.id.rbY);
//            RadioButton rbN = (RadioButton) child.findViewById(R.id.rbN);
//            TextView tvGet = (TextView) child.findViewById(R.id.tvGet);
//            final int finalI = i;
//            tvGet.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(MyApplication.getContextObject(), String
//                            .valueOf(finalI), Toast.LENGTH_SHORT).show();
//                }
//            });
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        if (isExpanded) {//展开状态，增加高度
            layoutParams.height += childTotalHeight;
        } else {//收起状态，减掉二阶子项高度
            layoutParams.height -= childTotalHeight;
        }
        listView.setLayoutParams(layoutParams);
    }

    /**
     * 获取考核项
     *
     * @param inspectStarte
     */
    @Override
    public void getInspectStarteViewData(InspectStarte inspectStarte) {
        List<String> anquanList = new ArrayList<>();
        List<String> jinengList = new ArrayList<>();
        List<String> guifanList = new ArrayList<>();
        for (int i = 0; i < inspectStarte.getData().size(); i++) {
            if (inspectStarte.getData().get(i).getType().equals("规范运营安全行车")) {
                anquanList.add(inspectStarte.getData().get(i).getProjectName());
                anquanSList.add(String.valueOf(inspectStarte.getData().get(i).getScore()));
            } else if (inspectStarte.getData().get(i).getType().equals("驾驶技能")) {
                jinengList.add(inspectStarte.getData().get(i).getProjectName());
                jinengSList.add(String.valueOf(inspectStarte.getData().get(i).getScore()));
            } else {
                guifanList.add(inspectStarte.getData().get(i).getProjectName());
                guifanSList.add(String.valueOf(inspectStarte.getData().get(i).getScore()));
            }
        }
        InspectAllAQAdapter aqAdapter = new InspectAllAQAdapter(this, anquanList);
        aqAdapter.setOnInnerItemOnClickListener(this);
        recyAnQuan.setAdapter(aqAdapter);
        InspectAllJNAdapter jnAdapter = new InspectAllJNAdapter(this, jinengList);
        jnAdapter.setOnInnerItemOnClickListener(this);
        recyJiNeng.setAdapter(jnAdapter);
        InspectAllGFAdapter gfAdapter = new InspectAllGFAdapter(this, guifanList);
        gfAdapter.setOnInnerItemOnClickListener(this);
        recyGuiFan.setAdapter(gfAdapter);
    }

    /**
     * 获取安全position
     *
     * @param position
     */
    @Override
    public void getPosition(final int position, String tag) {
        recyJiNeng.setVisibility(View.GONE);
        recyGuiFan.setVisibility(View.GONE);
        this.position = position;
        View layout = recyAnQuan.getLayoutManager().findViewByPosition(position);// 获得子item的layout
        imageView = (ImageView) layout.findViewById(R.id.imaheView);
        final ImageView ivNoPass = (ImageView) layout.findViewById(R.id.ivNoPass);
        final ImageView ivPass = (ImageView) layout.findViewById(R.id.ivPass);
        if (tag.equals("photo")) {
            if (ContextCompat.checkSelfPermission(InspectStarteActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(InspectStarteActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(InspectStarteActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        TAG_ONE);
            } else {
                Matisse.from(InspectStarteActivity.this)
                        .choose(MimeType.allOf())//图片类型
                        .countable(true)//true:选中后显示数字;false:选中后显示对号
                        .maxSelectable(1)//可选的最大数
                        .capture(true)//选择照片时，是否显示拍照
                        .captureStrategy(new CaptureStrategy(true, "com.hy.powerplatform.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                        .thumbnailScale(0.3f)  //图片缩放比例
                        .imageEngine(new GlideEngine())//图片加载引擎
                        .forResult(TAG_ONE);//
            }
        }
        if (tag.equals("pass")) {
            aqChaeck(position);
            ivNoPass.setImageResource(R.drawable.nocheck);
            ivPass.setImageResource(R.drawable.check);
        }
        if (tag.equals("nopass")) {
            aqNoChaeck(position);
            ivNoPass.setImageResource(R.drawable.check);
            ivPass.setImageResource(R.drawable.nocheck);
        }
    }

    /**
     * 技能position
     *
     * @param position
     */
    @Override
    public void getJNPosition(final int position, String tag) {
        recyAnQuan.setVisibility(View.GONE);
        recyGuiFan.setVisibility(View.GONE);
        this.position = position;
        View layout = recyJiNeng.getLayoutManager().findViewByPosition(position);// 获得子item的layout
        imageView = (ImageView) layout.findViewById(R.id.imaheView);
        final ImageView ivNoPass = (ImageView) layout.findViewById(R.id.ivNoPass);
        final ImageView ivPass = (ImageView) layout.findViewById(R.id.ivPass);
        if (tag.equals("photo")) {
            if (ContextCompat.checkSelfPermission(InspectStarteActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(InspectStarteActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(InspectStarteActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        TAG_TWO);
            } else {
                Matisse.from(InspectStarteActivity.this)
                        .choose(MimeType.allOf())//图片类型
                        .countable(true)//true:选中后显示数字;false:选中后显示对号
                        .maxSelectable(1)//可选的最大数
                        .capture(true)//选择照片时，是否显示拍照
                        .captureStrategy(new CaptureStrategy(true, "com.hy.powerplatform.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                        .thumbnailScale(0.3f)  //图片缩放比例
                        .imageEngine(new GlideEngine())//图片加载引擎
                        .forResult(TAG_THERE);//
            }
        }
        if (tag.equals("pass")) {
            jnChaeck(position);
            ivNoPass.setImageResource(R.drawable.nocheck);
            ivPass.setImageResource(R.drawable.check);
        }
        if (tag.equals("nopass")) {
            jnNoChaeck(position);
            ivNoPass.setImageResource(R.drawable.check);
            ivPass.setImageResource(R.drawable.nocheck);
        }
    }

    /**
     * 规范position
     *
     * @param position
     */
    @Override
    public void getGFPosition(final int position, String tag) {
        recyAnQuan.setVisibility(View.GONE);
        recyJiNeng.setVisibility(View.GONE);
        this.position = position;
        View layout = recyGuiFan.getLayoutManager().findViewByPosition(position);// 获得子item的layout
        final ImageView ivNoPass = (ImageView) layout.findViewById(R.id.ivNoPass);
        final ImageView ivPass = (ImageView) layout.findViewById(R.id.ivPass);
        imageView = (ImageView) layout.findViewById(R.id.imaheView);
        if (tag.equals("photo")) {
            if (ContextCompat.checkSelfPermission(InspectStarteActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(InspectStarteActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(InspectStarteActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        TAG_THERE);
            } else {
                Matisse.from(InspectStarteActivity.this)
                        .choose(MimeType.allOf())//图片类型
                        .countable(true)//true:选中后显示数字;false:选中后显示对号
                        .maxSelectable(1)//可选的最大数
                        .capture(true)//选择照片时，是否显示拍照
                        .captureStrategy(new CaptureStrategy(true, "com.hy.powerplatform.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                        .thumbnailScale(0.3f)  //图片缩放比例
                        .imageEngine(new GlideEngine())
                        .forResult(TAG_FOUR);//
            }
        }
        if (tag.equals("pass")) {
            gfChaeck(position);
            ivNoPass.setImageResource(R.drawable.nocheck);
            ivPass.setImageResource(R.drawable.check);
        }
        if (tag.equals("nopass")) {
            gfNoChaeck(position);
            ivNoPass.setImageResource(R.drawable.check);
            ivPass.setImageResource(R.drawable.nocheck);
        }
    }

    private void gfChaeck(int position) {
        if (position == 0) {
            gffwYrybyt = "0";
        } else if (position == 1) {
            gffwPth = "0";
        } else if (position == 2) {
            gffwSzwmyy = "0";
        } else if (position == 3) {
            gffwFwyytd = "0";
        } else if (position == 4) {
            gffwZgsd = "0";
        } else if (position == 5) {
            gffwBaozhanqi = "0";
        } else if (position == 6) {
            gffwClws = "0";
        } else if (position == 7) {
            gffwWpbf = "0";
        } else if (position == 8) {
            gffwLEDlp = "0";
        } else if (position == 9) {
            gffwClbz = "0";
        } else if (position == 10) {
            gffwFwzsp = "0";
        } else if (position == 11) {
            gffwWendutf = "0";
        } else if (position == 12) {
            gffwGuzhanghc = "0";
        } else if (position == 13) {
            gffwFuwuts = "0";
        }
    }

    private void gfNoChaeck(int position) {
        if (position == 0) {
            gffwYrybyt = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 1) {
            gffwPth = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 2) {
            gffwSzwmyy = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 3) {
            gffwFwyytd = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 4) {
            gffwZgsd = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 5) {
            gffwBaozhanqi = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 6) {
            gffwClws = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 7) {
            gffwWpbf = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 8) {
            gffwLEDlp = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 9) {
            gffwClbz = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 10) {
            gffwFwzsp = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 11) {
            gffwWendutf = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 12) {
            gffwGuzhanghc = "1";
            code += Integer.parseInt(guifanSList.get(position));
        } else if (position == 13) {
            gffwFuwuts = "1";
            code += Integer.parseInt(guifanSList.get(position));
        }
    }

    private void jnNoChaeck(int position) {
        if (position == 0) {
            jsjnTingzhansk = "1";
            code += Integer.parseInt(jinengSList.get(position));
        } else if (position == 1) {
            jsjnJiashiypcl = "1";
            code += Integer.parseInt(jinengSList.get(position));
        } else if (position == 2) {
            jsjnYibiaojc = "1";
            code += Integer.parseInt(jinengSList.get(position));
        } else if (position == 3) {
            jsjnLiheqi = "1";
            code += Integer.parseInt(jinengSList.get(position));
        } else if (position == 4) {
            jsjnDwsy = "1";
            code += Integer.parseInt(jinengSList.get(position));
        } else if (position == 5) {
            jsjnZhuanxiangd = "1";
            code += Integer.parseInt(jinengSList.get(position));
        } else if (position == 6) {
            jsjnGuifantk = "1";
            code += Integer.parseInt(jinengSList.get(position));
        }
    }

    private void jnChaeck(int position) {
        if (position == 0) {
            jsjnTingzhansk = "0";
        } else if (position == 1) {
            jsjnJiashiypcl = "0";
        } else if (position == 2) {
            jsjnYibiaojc = "0";
        } else if (position == 3) {
            jsjnLiheqi = "0";
        } else if (position == 4) {
            jsjnDwsy = "0";
        } else if (position == 5) {
            jsjnZhuanxiangd = "0";
        } else if (position == 6) {
            jsjnGuifantk = "0";
        }
    }

    /**
     * 安全驾驶选项
     *
     * @param position
     */
    private void aqChaeck(int position) {
        if (position == 0) {
            aqxcZuishougz = "0";
        } else if (position == 1) {
            aqxcWenmingjs = "0";
        } else if (position == 2) {
            aqxcChaosu = "0";
        } else if (position == 3) {
            aqxcShigu = "0";
        } else if (position == 4) {
            aqxcGuifanjcz = "0";
        } else if (position == 5) {
            aqxcPaolaid = "0";
        } else if (position == 6) {
            aqxcKaiguancm = "0";
        } else if (position == 7) {
            aqxcAnjian = "0";
        } else if (position == 8) {
            aqxcXiaofangss = "0";
        } else if (position == 9) {
            aqxcZhongdianz = "0";
        }
    }

    private void aqNoChaeck(int position) {
        if (position == 0) {
            aqxcZuishougz = "1";
            code += Integer.parseInt(anquanSList.get(position));
        } else if (position == 1) {
            aqxcWenmingjs = "1";
            code += Integer.parseInt(anquanSList.get(position));
        } else if (position == 2) {
            aqxcChaosu = "1";
            code += Integer.parseInt(anquanSList.get(position));
        } else if (position == 3) {
            aqxcShigu = "1";
            code += Integer.parseInt(anquanSList.get(position));
        } else if (position == 4) {
            aqxcGuifanjcz = "1";
            code += Integer.parseInt(anquanSList.get(position));
        } else if (position == 5) {
            aqxcPaolaid = "1";
            code += Integer.parseInt(anquanSList.get(position));
        } else if (position == 6) {
            aqxcKaiguancm = "1";
            code += Integer.parseInt(anquanSList.get(position));
        } else if (position == 7) {
            aqxcAnjian = "1";
            code += Integer.parseInt(anquanSList.get(position));
        } else if (position == 8) {
            aqxcXiaofangss = "1";
            code += Integer.parseInt(anquanSList.get(position));
        } else if (position == 9) {
            aqxcZhongdianz = "1";
            code += Integer.parseInt(anquanSList.get(position));
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    Toast.makeText(InspectStarteActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    refresh();
                    break;
                case Constant.TAG_TWO:
                    Toast.makeText(InspectStarteActivity.this, "提交失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case 66:
                    ProgressDialogUtil.stopLoad();
                    break;
                case 111:
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

    public void refresh() {
        finish();
        Intent intent = new Intent(InspectStarteActivity.this, InspectStarteActivity.class);
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
            }
            etSelectLine.setText(line);
            etSelectDriver.setText(carDrive);
        }else {
            Toast.makeText(this, "线路关联失败，请手动填写", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 向服务器发送数据
     */
    private void sendInspectData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                DBHandler dbH = new DBHandler();
                String turl = BASE_URL + "starkh/mobileSaveYoufushifancheKaohe.do";
                String dirverName = etSelectDriver.getText().toString();
                String kaoheDate = tvTime.getText().toString();
                String res = dbH.kaoheCommitValue_(turl, userCode, kaoheDate, dirverName,
                        userCode, line, carNo, busCode, gffwYrybyt,
                        gffwYrybytBz, gffwYrybytPic, gffwPth, gffwPthBz, gffwPthPic, gffwSzwmyy,
                        gffwSzwmyyBz, gffwSzwmyyPic, gffwFwyytd, gffwFwyytdBz, gffwFwyytdPic, gffwZgsd,
                        gffwZgsdBz, gffwZgsdPic, gffwBaozhanqi, gffwBaozhanqiBz, gffwBaozhanqiPic,
                        gffwClws, gffwClwsBz, gffwClwsPic, gffwWpbf, gffwWpbfBz, gffwWpbfPic, gffwLEDlp,
                        gffwLEDlpBz, gffwLEDlpPic, gffwClbz, gffwClbzBz, gffwClbzPic, gffwFwzsp,
                        gffwFwzspBz, gffwFwzspPic, gffwWendutf, gffwWendutfBz, gffwWendutfPic,
                        gffwGuzhanghc, gffwGuzhanghcBz, gffwGuzhanghcPic, gffwFuwuts, gffwFuwutsBz,
                        gffwFuwutsPic, jsjnTingzhansk, jsjnTingzhanskBz, jsjnTingzhanskPic, jsjnJiashiypcl,
                        jsjnJiashiypclBz, jsjnJiashiypclPic, jsjnYibiaojc, jsjnYibiaojcBz, jsjnYibiaojcPic,
                        jsjnLiheqi, jsjnLiheqiBz, jsjnLiheqiPic, jsjnDwsy, jsjnDwsyBz, jsjnDwsyPic,
                        jsjnZhuanxiangd, jsjnZhuanxiangdBz, jsjnZhuanxiangdPic, jsjnGuifantk,
                        jsjnGuifantkBz, jsjnGuifantkPic, aqxcZuishougz, aqxcZuishougzBz, aqxcZuishougzPic,
                        aqxcWenmingjs, aqxcWenmingjsBz, aqxcWenmingjsPic, aqxcChaosu, aqxcChaosuBz,
                        aqxcChaosuPic, aqxcShigu, aqxcShiguBz, aqxcShiguPic, aqxcGuifanjcz,
                        aqxcGuifanjczBz, aqxcGuifanjczPic, aqxcPaolaid, aqxcPaolaidBz, aqxcPaolaidPic,
                        aqxcKaiguancm, aqxcKaiguancmBz, aqxcKaiguancmPic, aqxcAnjian, aqxcAnjianBz,
                        aqxcAnjianPic, aqxcXiaofangss, aqxcXiaofangssBz, aqxcXiaofangssPic, aqxcZhongdianz,
                        aqxcZhongdianzBz, aqxcZhongdianzPic, String.valueOf(code));//, fenshu,position
                if (res.equals("")) {
                    handler.sendEmptyMessage(TAG_ONE);
                } else {
                    handler.sendEmptyMessage(Constant.TAG_TWO);
                }
            }
        }).start();
    }
}
