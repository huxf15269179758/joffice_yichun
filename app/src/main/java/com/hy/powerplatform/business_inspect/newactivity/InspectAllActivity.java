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
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.hy.powerplatform.business_inspect.bean.InspectAll;
import com.hy.powerplatform.business_inspect.bean.NewDriver;
import com.hy.powerplatform.business_inspect.newadapter.InspectAllAQAdapter;
import com.hy.powerplatform.business_inspect.newadapter.InspectAllGFAdapter;
import com.hy.powerplatform.business_inspect.newadapter.InspectAllJNAdapter;
import com.hy.powerplatform.business_inspect.presenter.CorrelationPresenter;
import com.hy.powerplatform.business_inspect.presenter.InspectAllPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CorrectionPresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.InspectAllPresenterimpl;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.business_inspect.view.CorrelationView;
import com.hy.powerplatform.business_inspect.view.InspectAllView;
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

public class InspectAllActivity extends BaseActivity implements InspectAllView,
        InspectAllAQAdapter.GetItemPosition,
        InspectAllJNAdapter.GetJNItemPosition,
        InspectAllGFAdapter.GetGFItemPosition,
        CorrelationView {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.etSelectCar)
    EditText etSelectCar;
    @BindView(R.id.imCarSelect)
    ImageView imCarSelect;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.scrollView)
    ScrollView scrollView;

    String aqxcWmjs = "0";
    String aqxcWmjsBz = "";
    String aqxcWmjsPic = "";
    String aqxcPwjs = "0";
    String aqxcPwjsBz = "";
    String aqxcPwjsPic = "";
    String aqxcJcz = "0";
    String aqxcJczBz = "";
    String aqxcJczPic = "";
    String aqxcAnjian = "0";
    String aqxcAnjianBz = "";
    String aqxcAnjianPic = "";
    String aqxcZdgfyy = "0";
    String aqxcZdgfyyBz = "";
    String aqxcZdgfyyPic = "";
    String aqxcYingji = "0";
    String aqxcYingjiBz = "";
    String aqxcYingjiPic = "";
    String aqxcDanzhan = "0";
    String aqxcDanzhanBz = "";
    String aqxcDanzhanPic = "";
    String aqxcYindaock = "0";
    String aqxcYindaockBz = "";
    String aqxcYindaockPic = "";
    String aqxcZdzsk = "0";
    String aqxcZdzskBz = "";
    String aqxcZdzskPic = "";
    String jsjnBabuzou = "0";
    String jsjnBabuzouBz = "";
    String jsjnBabuzouPic = "";
    String jsjnDaisuyz = "0";
    String jsjnDaisuyzBz = "";
    String jsjnDaisuyzPic = "";
    String jsjnYibiaojc = "0";
    String jsjnYibiaojcBz = "";
    String jsjnYibiaojcPic = "";
    String jsjnQiqong = "0";
    String jsjnQiqongBz = "";
    String jsjnQiqongPic = "";
    String jsjnDangwei = "0";
    String jsjnDangweiBz = "";
    String jsjnDangweiPic = "";
    String jsjnDengguang = "0";
    String jsjnDengguangBz = "";
    String jsjnDengguangPic = "";
    String jsjnKgqb = "0";
    String jsjnKgqbBz = "";
    String jsjnKgqbPic = "";
    String jsjnZengjiand = "0";
    String jsjnZengjiandBz = "";
    String jsjnZengjiandPic = "";
    String jsjnZongdianyuan = "0";
    String jsjnZongdianyuanBz = "";
    String jsjnZongdianyuanPic = "";
    String fwgfYryb = "0";
    String fwgfYrybBz = "";
    String fwgfYrybPic = "";
    String fwgfYuyantaidu = "0";
    String fwgfYuyantaiduBz = "";
    String fwgfYuyantaiduPic = "";
    String fwgfPutonghua = "0";
    String fwgfPutonghuaBz = "";
    String fwgfPutonghuaPic = "";
    String fwgfZhaogu = "0";
    String fwgfZhaoguBz = "";
    String fwgfZhaoguPic = "";
    String fwgfShudao = "0";
    String fwgfShudaoBz = "";
    String fwgfShudaoPic = "";
    String fwgfBaozhanqi = "0";
    String fwgfBaozhanqiBz = "";
    String fwgfBaozhanqiPic = "";
    String fwgfWendu = "0";
    String fwgfWenduBz = "";
    String fwgfWenduPic = "";
    String fwgfWeisheng = "0";
    String fwgfWeishengBz = "";
    String fwgfWeishengPic = "";
    String fwgfBaifang = "0";
    String fwgfBaifangBz = "";
    String fwgfBaifangPic = "";
    String fwgfZhanshipai = "0";
    String fwgfZhanshipaiBz = "";
    String fwgfZhanshipaiPic = "";
    String fwgfWeizhan = "0";
    String fwgfWeizhanBz = "";
    String fwgfWeizhanPic = "";
    String fwgfErcijz = "0";
    String fwgfErcijzBz = "";
    String fwgfErcijzPic = "";
    String fwgfYiweishipin = "0";
    String fwgfYiweishipinBz = "";
    String fwgfYiweishipinPic = "";
    String fwgfZhongdianzhanjc = "0";
    String fwgfZhongdianzhanjcBz = "";
    String fwgfZhongdianzhanjcPic = "";
    String dirPath = "temp";

    SQLiteDatabase db;
    MyDatabaseHelper helper;
    String carName;
    Cursor cursor;
    int tag;
    File tmpDir;
    String carNo;

    //检查结果
    List<Map<String, String>> imageListaq = new ArrayList<>();
    List<Map<String, String>> imageListjn = new ArrayList<>();
    List<Map<String, String>> imageListgf = new ArrayList<>();
    List<Map<String, String>> imageListaq1 = new ArrayList<>();
    List<Map<String, String>> imageListjn1 = new ArrayList<>();
    List<Map<String, String>> imageListgf1 = new ArrayList<>();
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
    @BindView(R.id.etSelectCheck)
    TextView etSelectCheck;
    @BindView(R.id.imCheckSelect)
    ImageView imCheckSelect;
    @BindView(R.id.activity_login)
    LinearLayout activityLogin;
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
    InspectAllPresenter inspectAllPresenter;
    private ArrayList<String> mResults = new ArrayList<>();
    List<CarCode.DataBean> listCarCodeTest = new ArrayList<>();
    InspectAllAQAdapter aqAdapter;
    InspectAllJNAdapter jnAdapter;
    InspectAllGFAdapter gfAdapter;
    List<String> pathList = new ArrayList<>();
    private ArrayList<String> path = new ArrayList<>();
    int position;
    String busCode ;
    String carDrive;
    String userName, profileId, userName1;
    ImageView imageView;
    Intent intent;
    CorrelationPresenter correctionPresenter;
    String driverName, line, userCode, depId, depName;
    LinearLayoutManager manager, manager1, manager2;
    List<NewDriver.DataBean> listInspectDrive = new ArrayList<>();
    List<NewDriver.DataBean> listInspectDrive1 = new ArrayList<>();

    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        int width = getWindowManager().getDefaultDisplay().getWidth();
        sharecPreferencesHelper = new SharedPreferencesHelper(this, "login");
        inspectAllPresenter = new InspectAllPresenterimpl(this, this);
        correctionPresenter = new CorrectionPresenterimpl(this, this);
        inspectAllPresenter.getInspectAllPresenterData();
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        //选择时间
        initDatePicker();
        //设置EditText
        new EditTextChange(etSelectCar).changeText();
        new EditTextChange(etSelectDriver).changeText();
        new EditTextChange(etSelectLine).changeText();

        manager = new LinearLayoutManager(this);
        recyAnQuan.setLayoutManager(manager);
        manager1 = new LinearLayoutManager(this);
        recyJiNeng.setLayoutManager(manager1);
        manager2 = new LinearLayoutManager(this);
        recyGuiFan.setLayoutManager(manager2);

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
        return R.layout.activity_inspect_all;
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

    @OnClick({R.id.tvTime, R.id.imCarSelect, R.id.btn, R.id.tvAnQuan, R.id.tvJiNeng,
            R.id.tvGuiFan, R.id.imCheckSelect, R.id.imLineSelect, R.id.imDriverSelect})
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
                Intent intent1 = new Intent(this, CheckOnePersonActivity.class);
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
                //String etText = etSelectCar.getText().toString().trim();
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
                userName1 = etSelectCheck.getText().toString();
                if (carNo.isEmpty()) {
                    Toast.makeText(this, "请输入车牌号", Toast.LENGTH_SHORT).show();
                } else if (userName1.isEmpty()) {
                    Toast.makeText(this, "请输入检查人", Toast.LENGTH_SHORT).show();
                } else {
                    ProgressDialogUtil.startLoad(this, Constant.UPDATA);
                    String sqlR = "select * from carcode where name = '" + etSelectCar.getText().toString() + "'";// order by random() limit 100
                    cursor = DbManager.queryBySQL(db, sqlR, null);
                    listCarCodeTest = DbManager.cursorToClassCar(cursor);
//                    busCode = listCarCodeTest.get(0).getValue();
                    sendInspectData();
//                    Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            sendInspectData();
//                        }
//                    }, 3000);
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case TAG_ONE:
                if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//                    Intent intent = new Intent(this, ImagesSelectorActivity.class);
//                    intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 1);
//                    intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 100000);
//                    intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
//                    startActivityForResult(intent, TAG_ONE);
                    Matisse.from(InspectAllActivity.this)
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
                    Matisse.from(InspectAllActivity.this)
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
                    Matisse.from(InspectAllActivity.this)
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
            case TAG_ONE:
//                if (resultCode == RESULT_OK) {
//                    mResults = data.getStringArrayListExtra(SelectorSettings.SELECTOR_RESULTS);
//                    assert mResults != null;
//
//                    // show results in textview
//                    StringBuilder sb = new StringBuilder();
//                    sb.append(String.format("Totally %d images selected:", mResults.size())).append("\n");
//                    for (String result : mResults) {
//                        sb.append(result).append("\n");
//                    }
//                }
                pathList.clear();
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
                    matrix.setScale(0.5f, 0.5f);
                    Bitmap bm = Bitmap.createBitmap(cbitmap01, 0, 0, cbitmap01.getWidth(),
                            cbitmap01.getHeight(), matrix, true);
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageBitmap(bm);
                    aqSaveImageToSD(bm, "temp");
                }
                break;
            case TAG_TWO:
                if (resultCode == Constant.TAG_THERE) {
                    carName = data.getStringExtra("bian");
                    busCode = data.getStringExtra("bianId");
                    etSelectCar.setText(carName);
                    line = etSelectLine.getText().toString();
                    getCorrelationData(busCode);
                }
                break;
            case TAG_THERE:
                pathList.clear();
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
                if (resultCode == RESULT_OK) {
                    pathList.clear();
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
                        matrix.setScale(0.5f, 0.5f);
                        Bitmap bm = Bitmap.createBitmap(cbitmap01, 0, 0, cbitmap01.getWidth(),
                                cbitmap01.getHeight(), matrix, true);
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageBitmap(bm);
                        gfSaveImageToSD(bm, "temp");
                    }
                    break;
                }
            case TAG_FIVE:
                if (resultCode == Constant.TAG_SIX) {
                    userName = data.getStringExtra("name");
                    profileId = data.getStringExtra("profileId");
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

    private void aqSaveImageToSD(Bitmap cbitmap01, String dirPath) {
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
//        Filed file = new Filed(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" +
//                String.valueOf(position)
//                + System.currentTimeMillis() + random.nextInt(10) + ".png");
//        OkHttpClient client = new OkHttpClient();
//        List<Filed> fileList = new ArrayList<>();
//        fileList.add(file);
//
//        // mImgUrls为存放图片的url集合
//        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
//        for (int i = 0; i < fileList.size(); i++) {
//            Filed f = new Filed(String.valueOf(fileList.get(i)));
//            if (f != null) {
//                builder.addFormDataPart("img", f.getName());
//            }
//        }
//        //添加其它信息
////        builder.addFormDataPart("time",takePicTime);
//        MultipartBody requestBody = builder.build();
//        //构建请求
//        final String url = Constant.BASE_URL + "starkh/upLoadImageZonghejinnengKaohe.do";
//        Request request = new Request.Builder()
//                .url(url)//地址
//                .post(requestBody)//添加请求体
//                .build();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//                System.out.println("上传失败:e.getLocalizedMessage() = " + e.getLocalizedMessage());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//                System.out.println("上传照片成功：response = " + response.body().string());
//                showTag(response.body().toString());
//                for (int i = 0; i < imageListaq1.size(); i++) {
//                            for (String key : imageListaq1.get(i).keySet()) {
//                                if (key.equals("0")) {
//                                    aqxcWmjsPic = imageListaq1.get(i).get(key);
//                                } else if (key.equals("1")) {
//                                    aqxcPwjsPic = imageListaq1.get(i).get(key);
//                                } else if (key.equals("2")) {
//                                    aqxcJczPic = imageListaq1.get(i).get(key);
//                                } else if (key.equals("3")) {
//                                    aqxcAnjianPic = imageListaq1.get(i).get(key);
//                                } else if (key.equals("4")) {
//                                    aqxcZdgfyyPic = imageListaq1.get(i).get(key);
//                                } else if (key.equals("5")) {
//                                    aqxcYingjiPic = imageListaq1.get(i).get(key);
//                                } else if (key.equals("6")) {
//                                    aqxcDanzhanPic = imageListaq1.get(i).get(key);
//                                } else if (key.equals("7")) {
//                                    aqxcYindaockPic = imageListaq1.get(i).get(key);
//                                } else if (key.equals("8")) {
//                                    aqxcZdzskPic = imageListaq1.get(i).get(key);
//                                }
//                            }
//                        }
//            }
//        });
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
                final AsyncHttpClient client = new AsyncHttpClient();
                final String url = BASE_URL + "starkh/upLoadImageZonghejinnengKaohe.do";
                ProgressDialogUtil.startLoad(this,"");
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
                                    aqxcWmjsPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("1")) {
                                    aqxcPwjsPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("2")) {
                                    aqxcJczPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("3")) {
                                    aqxcAnjianPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("4")) {
                                    aqxcZdgfyyPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("5")) {
                                    aqxcYingjiPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("6")) {
                                    aqxcDanzhanPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("7")) {
                                    aqxcYindaockPic = imageListaq1.get(i).get(key);
                                } else if (key.equals("8")) {
                                    aqxcZdzskPic = imageListaq1.get(i).get(key);
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
                final String url = BASE_URL + "starkh/upLoadImageZonghejinnengKaohe.do";
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
                                    jsjnBabuzouPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("1")) {
                                    jsjnDaisuyzPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("2")) {
                                    jsjnYibiaojcPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("3")) {
                                    jsjnQiqongPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("4")) {
                                    jsjnDangweiPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("5")) {
                                    jsjnDengguangPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("6")) {
                                    jsjnKgqbPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("6")) {
                                    jsjnKgqbPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("7")) {
                                    jsjnZengjiandPic = imageListjn1.get(i).get(key);
                                } else if (key.equals("8")) {
                                    jsjnZongdianyuanPic = imageListjn1.get(i).get(key);
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
                final String url = BASE_URL + "starkh/upLoadImageZonghejinnengKaohe.do";
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
                                    fwgfYrybPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("1")) {
                                    fwgfYuyantaiduPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("2")) {
                                    fwgfPutonghuaPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("3")) {
                                    fwgfZhaoguPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("4")) {
                                    fwgfShudaoPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("5")) {
                                    fwgfBaozhanqiPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("6")) {
                                    fwgfWenduPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("7")) {
                                    fwgfWeishengPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("8")) {
                                    fwgfBaifangPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("9")) {
                                    fwgfZhanshipaiPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("10")) {
                                    fwgfWeizhanPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("11")) {
                                    fwgfErcijzPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("12")) {
                                    fwgfYiweishipinPic = imageListgf1.get(i).get(key);
                                } else if (key.equals("13")) {
                                    fwgfZhongdianzhanjcPic = imageListgf1.get(i).get(key);
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
     * @param inspectAll
     */
    @Override
    public void getInspectAllViewData(InspectAll inspectAll) {
//        for (int i = 0; i < inspectAll.getData().size(); i++) {
//            inspectAllList.add(inspectAll.getData().get(i));
//            if (!bigTypeList.contains(inspectAll.getData().get(i).getType())) {
//                bigTypeList.add(inspectAll.getData().get(i).getType());
//            }
//        }
//        for (int j = 0; j < bigTypeList.size(); j++) {
//            smallTypeList01 = new ArrayList<>();
//            for (int k = 0; k < inspectAll.getData().size(); k++) {
//                if (bigTypeList.get(j).equals(inspectAll.getData().get(k).getType())) {
//                    smallTypeList01.add(inspectAll.getData().get(k).getProjectName());
//                }
//            }
//            smallTypeList.add(smallTypeList01);
//        }
//        expandableListViewAdapter = new ExpandableStartNoPassAdapter(MyApplication.getContextObject(), bigTypeList, smallTypeList,handler);
//        expandableListView.setAdapter(expandableListViewAdapter);
//        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                setChildViewHeight(expandableListView, groupPosition, true);
//            }
//        });
//        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                setChildViewHeight(expandableListView, groupPosition, false);
//            }
//        });
        List<String> anquanList = new ArrayList<>();
        List<String> jinengList = new ArrayList<>();
        List<String> guifanList = new ArrayList<>();
        for (int i = 0; i < inspectAll.getData().size(); i++) {
            if (inspectAll.getData().get(i).getType().equals("安全行车")) {
                anquanList.add(inspectAll.getData().get(i).getProjectName());
            } else if (inspectAll.getData().get(i).getType().equals("驾驶技能")) {
                jinengList.add(inspectAll.getData().get(i).getProjectName());
            } else {
                guifanList.add(inspectAll.getData().get(i).getProjectName());
            }
        }
        aqAdapter = new InspectAllAQAdapter(this, anquanList);
        aqAdapter.setOnInnerItemOnClickListener(this);
        recyAnQuan.setAdapter(aqAdapter);
        jnAdapter = new InspectAllJNAdapter(this, jinengList);
        jnAdapter.setOnInnerItemOnClickListener(this);
        recyJiNeng.setAdapter(jnAdapter);
        gfAdapter = new InspectAllGFAdapter(this, guifanList);
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
        this.position = position;
        View layout = recyAnQuan.getLayoutManager().findViewByPosition(position);// 获得子item的layout
        imageView = (ImageView) layout.findViewById(R.id.imaheView);
        final ImageView ivNoPass = (ImageView) layout.findViewById(R.id.ivNoPass);
        final ImageView ivPass = (ImageView) layout.findViewById(R.id.ivPass);
        if (tag.equals("photo")) {
            if (ContextCompat.checkSelfPermission(InspectAllActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(InspectAllActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(InspectAllActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        TAG_ONE);
            } else {
                Matisse.from(InspectAllActivity.this)
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
        this.position = position;
        View layout = recyJiNeng.getLayoutManager().findViewByPosition(position);// 获得子item的layout
        imageView = (ImageView) layout.findViewById(R.id.imaheView);
        final ImageView ivNoPass = (ImageView) layout.findViewById(R.id.ivNoPass);
        final ImageView ivPass = (ImageView) layout.findViewById(R.id.ivPass);
        if (tag.equals("photo")) {
            if (ContextCompat.checkSelfPermission(InspectAllActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(InspectAllActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(InspectAllActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        TAG_ONE);
            } else {
                Matisse.from(InspectAllActivity.this)
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
        this.position = position;
        View layout = recyGuiFan.getLayoutManager().findViewByPosition(position);// 获得子item的layout
        final ImageView ivNoPass = (ImageView) layout.findViewById(R.id.ivNoPass);
        final ImageView ivPass = (ImageView) layout.findViewById(R.id.ivPass);
        imageView = (ImageView) layout.findViewById(R.id.imaheView);
        if (tag.equals("photo")) {
            if (ContextCompat.checkSelfPermission(InspectAllActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(InspectAllActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(InspectAllActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        TAG_ONE);
            } else {
                Matisse.from(InspectAllActivity.this)
                        .choose(MimeType.allOf())//图片类型
                        .countable(true)//true:选中后显示数字;false:选中后显示对号
                        .maxSelectable(1)//可选的最大数
                        .capture(true)//选择照片时，是否显示拍照
                        .captureStrategy(new CaptureStrategy(true, "com.hy.powerplatform.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                        .thumbnailScale(0.3f)  //图片缩放比例
                        .imageEngine(new GlideEngine())//图片加载引擎
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
            fwgfYryb = "0";
        } else if (position == 1) {
            fwgfYuyantaidu = "0";
        } else if (position == 2) {
            fwgfPutonghua = "0";
        } else if (position == 3) {
            fwgfZhaogu = "0";
        } else if (position == 4) {
            fwgfShudao = "0";
        } else if (position == 5) {
            fwgfBaozhanqi = "0";
        } else if (position == 6) {
            fwgfWendu = "0";
        } else if (position == 7) {
            fwgfWeisheng = "0";
        } else if (position == 8) {
            fwgfBaifang = "0";
        } else if (position == 9) {
            fwgfZhanshipai = "0";
        } else if (position == 10) {
            fwgfWeizhan = "0";
        } else if (position == 11) {
            fwgfErcijz = "0";
        } else if (position == 12) {
            fwgfYiweishipin = "0";
        } else if (position == 13) {
            fwgfZhongdianzhanjc = "0";
        }
    }

    private void gfNoChaeck(int position) {
        if (position == 0) {
            fwgfYryb = "1";
        } else if (position == 1) {
            fwgfYuyantaidu = "1";
        } else if (position == 2) {
            fwgfPutonghua = "1";
        } else if (position == 3) {
            fwgfZhaogu = "1";
        } else if (position == 4) {
            fwgfShudao = "1";
        } else if (position == 5) {
            fwgfBaozhanqi = "1";
        } else if (position == 6) {
            fwgfWendu = "1";
        } else if (position == 7) {
            fwgfWeisheng = "1";
        } else if (position == 8) {
            fwgfBaifang = "1";
        } else if (position == 9) {
            fwgfZhanshipai = "1";
        } else if (position == 10) {
            fwgfWeizhan = "1";
        } else if (position == 11) {
            fwgfErcijz = "1";
        } else if (position == 12) {
            fwgfYiweishipin = "1";
        } else if (position == 13) {
            fwgfZhongdianzhanjc = "1";
        }
    }

    private void jnNoChaeck(int position) {
        if (position == 0) {
            jsjnBabuzou = "1";
        } else if (position == 1) {
            jsjnDaisuyz = "1";
        } else if (position == 2) {
            jsjnYibiaojc = "1";
        } else if (position == 3) {
            jsjnQiqong = "1";
        } else if (position == 4) {
            jsjnDangwei = "1";
        } else if (position == 5) {
            jsjnDengguang = "1";
        } else if (position == 6) {
            jsjnKgqb = "1";
        } else if (position == 7) {
            jsjnZengjiand = "1";
        } else if (position == 8) {
            jsjnZongdianyuan = "1";
        }
    }

    private void jnChaeck(int position) {
        if (position == 0) {
            jsjnBabuzou = "0";
        } else if (position == 1) {
            jsjnDaisuyz = "0";
        } else if (position == 2) {
            jsjnYibiaojc = "0";
        } else if (position == 3) {
            jsjnQiqong = "0";
        } else if (position == 4) {
            jsjnDangwei = "0";
        } else if (position == 5) {
            jsjnDengguang = "0";
        } else if (position == 6) {
            jsjnKgqb = "0";
        } else if (position == 7) {
            jsjnZengjiand = "0";
        } else if (position == 8) {
            jsjnZongdianyuan = "0";
        }
    }

    /**
     * 安全驾驶选项
     *
     * @param position
     */
    private void aqChaeck(int position) {
        if (position == 0) {
            aqxcWmjs = "0";
        } else if (position == 1) {
            aqxcPwjs = "0";
        } else if (position == 2) {
            aqxcJcz = "0";
        } else if (position == 3) {
            aqxcAnjian = "0";
        } else if (position == 4) {
            aqxcZdgfyy = "0";
        } else if (position == 5) {
            aqxcYingji = "0";
        } else if (position == 6) {
            aqxcDanzhan = "0";
        } else if (position == 7) {
            aqxcYindaock = "0";
        } else if (position == 8) {
            aqxcZdzsk = "0";
        }
    }

    private void aqNoChaeck(int position) {
        if (position == 0) {
            aqxcWmjs = "1";
        } else if (position == 1) {
            aqxcPwjs = "1";
        } else if (position == 2) {
            aqxcJcz = "1";
        } else if (position == 3) {
            aqxcAnjian = "1";
        } else if (position == 4) {
            aqxcZdgfyy = "1";
        } else if (position == 5) {
            aqxcYingji = "1";
        } else if (position == 6) {
            aqxcDanzhan = "1";
        } else if (position == 7) {
            aqxcYindaock = "1";
        } else if (position == 8) {
            aqxcZdzsk = "1";
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    Toast.makeText(InspectAllActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                    refresh();
//                    imageListaq.clear();
//                    imageListjn.clear();
//                    imageListgf.clear();
//                    imageListaq1.clear();
//                    imageListjn1.clear();
//                    imageListgf1.clear();
//                    aqAdapter.notifyDataSetChanged();
//                    gfAdapter.notifyDataSetChanged();
//                    jnAdapter.notifyDataSetChanged();
                    break;
                case TAG_TWO:
                    Toast.makeText(InspectAllActivity.this, "提交失败", Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(InspectAllActivity.this, InspectAllActivity.class);
        startActivity(intent);
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
            String lineText = etSelectLine.getText().toString();
            if (lineText.equals("")){
                etSelectLine.setText(line);
            }
            etSelectDriver.setText(carDrive);
        } else {
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
                DBHandler dbA = new DBHandler();
                String turl = BASE_URL + "starkh/mobileSaveZonghejinnengKaohe.do";
                String kaoheDate = tvTime.getText().toString();
                String dirverName = etSelectDriver.getText().toString();
                String fenshu = "0.0";
                String position = "";
                String res = dbA.kaoheCommitValue(turl, profileId, kaoheDate, dirverName,
                        userCode, line, carNo, busCode, aqxcWmjs,
                        aqxcWmjsBz, aqxcWmjsPic, aqxcPwjs, aqxcPwjsBz, aqxcPwjsPic, aqxcJcz, aqxcJczBz,
                        aqxcJczPic, aqxcAnjian, aqxcAnjianBz, aqxcAnjianPic, aqxcZdgfyy, aqxcZdgfyyBz,
                        aqxcZdgfyyPic, aqxcYingji, aqxcYingjiBz, aqxcYingjiPic, aqxcDanzhan,
                        aqxcDanzhanBz, aqxcDanzhanPic, aqxcYindaock, aqxcYindaockBz, aqxcYindaockPic,
                        aqxcZdzsk, aqxcZdzskBz, aqxcZdzskPic, jsjnBabuzou, jsjnBabuzouBz, jsjnBabuzouPic,
                        jsjnDaisuyz, jsjnDaisuyzBz, jsjnDaisuyzPic, jsjnYibiaojc, jsjnYibiaojcBz,
                        jsjnYibiaojcPic, jsjnQiqong, jsjnQiqongBz, jsjnQiqongPic, jsjnDangwei,
                        jsjnDangweiBz, jsjnDangweiPic, jsjnDengguang, jsjnDengguangBz, jsjnDengguangPic,
                        jsjnKgqb, jsjnKgqbBz, jsjnKgqbPic, jsjnZengjiand, jsjnZengjiandBz,
                        jsjnZengjiandPic, jsjnZongdianyuan, jsjnZongdianyuanBz, jsjnZongdianyuanPic,
                        fwgfYryb, fwgfYrybBz, fwgfYrybPic, fwgfYuyantaidu, fwgfYuyantaiduBz,
                        fwgfYuyantaiduPic, fwgfPutonghua, fwgfPutonghuaBz, fwgfPutonghuaPic, fwgfZhaogu,
                        fwgfZhaoguBz, fwgfZhaoguPic, fwgfShudao, fwgfShudaoBz, fwgfShudaoPic,
                        fwgfBaozhanqi, fwgfBaozhanqiBz, fwgfBaozhanqiPic, fwgfWendu, fwgfWenduBz,
                        fwgfWenduPic, fwgfWeisheng, fwgfWeishengBz, fwgfWeishengPic, fwgfBaifang,
                        fwgfBaifangBz, fwgfBaifangPic, fwgfZhanshipai, fwgfZhanshipaiBz, fwgfZhanshipaiPic,
                        fwgfWeizhan, fwgfWeizhanBz, fwgfWeizhanPic, fwgfErcijz, fwgfErcijzBz,
                        fwgfErcijzPic, fwgfYiweishipin, fwgfYiweishipinBz, fwgfYiweishipinPic,
                        fwgfZhongdianzhanjc, fwgfZhongdianzhanjcBz, fwgfZhongdianzhanjcPic, fenshu, position);
                ProgressDialogUtil.stopLoad();
                if (res.equals("")) {
                    handler.sendEmptyMessage(TAG_ONE);
                } else {
                    handler.sendEmptyMessage(Constant.TAG_TWO);
                }
            }
        }).start();
    }

}

