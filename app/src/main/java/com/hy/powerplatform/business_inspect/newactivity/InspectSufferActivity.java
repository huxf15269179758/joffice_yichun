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
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.activity.InspectDriveSelectTypeActivity;
import com.hy.powerplatform.business_inspect.activity.InspectLineSelectTypeActivity;
import com.hy.powerplatform.business_inspect.activity.SelectOneCarActivity;
import com.hy.powerplatform.business_inspect.bean.Correlat;
import com.hy.powerplatform.business_inspect.bean.InspectSuffeer;
import com.hy.powerplatform.business_inspect.bean.NewDriver;
import com.hy.powerplatform.business_inspect.newadapter.InspectAllAQAdapter;
import com.hy.powerplatform.business_inspect.presenter.CorrelationPresenter;
import com.hy.powerplatform.business_inspect.presenter.InspectSufferPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CorrectionPresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.InspectSufferPresenterimpl;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.business_inspect.view.CorrelationView;
import com.hy.powerplatform.business_inspect.view.InspectSufferView;
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
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class InspectSufferActivity extends BaseActivity implements InspectSufferView, InspectAllAQAdapter.GetItemPosition
,CorrelationView {

    @BindView(R.id.header)
    Header header;
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
    @BindView(R.id.etSelectAddress)
    EditText etSelectAddress;
    @BindView(R.id.tvSelectAssess)
    TextView tvSelectAssess;
    @BindView(R.id.rbSelectAssessM)
    RadioButton rbSelectAssessM;
    @BindView(R.id.rbSelectAssessC)
    RadioButton rbSelectAssessC;
    @BindView(R.id.tvSelectSure)
    TextView tvSelectSure;
    @BindView(R.id.rbSelectSureM)
    RadioButton rbSelectSureM;
    @BindView(R.id.rbSelectSureC)
    RadioButton rbSelectSureC;
    @BindView(R.id.tvZhiXu)
    TextView tvZhiXu;
    @BindView(R.id.recyZhiXu)
    MyRecyclerView recyZhiXu;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.scrollView)
    ScrollView scrollView;

    SQLiteDatabase db;
    MyDatabaseHelper helper;
    Cursor cursor;
    String carName;
    InspectSufferPresenter inspectSufferPresenter;
    File tmpDir;
    String carNo;
    String dirPath = "temp";
    String driverName, line, lineCode, carLine, carDrive;
    String carAddress, userCode, depId, depName, res,checkPerson;
    SharedPreferencesHelper sharecPreferencesHelper;
    @BindView(R.id.etSelectCheck)
    TextView etSelectCheck;
    @BindView(R.id.imCheckSelect)
    ImageView imCheckSelect;

    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    //图片list
    private Map<String, String> map_project = new HashMap<String, String>();
    private Map<String, String> map_project_ = new HashMap<String, String>();
    private Map<String, String> map_photoName = new HashMap<String, String>();
    private Map<String, String> map_photoName_ = new HashMap<String, String>();
    private Map<String, String> map_beizhu = new HashMap<String, String>();
    private Map<String, String> map_beizhu_ = new HashMap<String, String>();
    List<String> aqList;
    List<String> fwtypeList = new ArrayList<>();
    List<String> wsimageList = new ArrayList<>();
    int position;
    Intent intent;
    ImageView imageView;
    String userName;
    String rode = "1";
    String busCode = "1";
    CorrelationPresenter correctionPresenter;
    List<Map<String, String>> imageListws = new ArrayList<>();
    List<NewDriver.DataBean> listInspectDrive = new ArrayList<>();
    List<NewDriver.DataBean> listInspectDrive1 = new ArrayList<>();
    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";
    final String url = BASE_URL + "starkh/upLoadImageVehicleHealthInspection.do";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        sharecPreferencesHelper = new SharedPreferencesHelper(this, "login");
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        inspectSufferPresenter = new InspectSufferPresenterimpl(this, this);
        inspectSufferPresenter.getInspectSufferPresenterData();
        //设置Edittext
        new EditTextChange(etSelectLine).changeText();
        new EditTextChange(etSelectCar).changeText();
        new EditTextChange(etSelectDriver).changeText();
        new EditTextChange(etSelectAddress).changeText();
        correctionPresenter = new CorrectionPresenterimpl(this, this);
        //选择时间
        initDatePicker();
        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        recyZhiXu.setLayoutManager(manager1);

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
        return R.layout.activity_inspect_suffer;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.tvTime, R.id.imLineSelect, R.id.imCarSelect, R.id.imDriverSelect, R.id.tvZhiXu, R.id.btn,R.id.imCheckSelect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTime:
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.imLineSelect:
                String etTextLine = etSelectLine.getText().toString().trim();
                intent = new Intent(this, InspectLineSelectTypeActivity.class);
                intent.putExtra("condition", etTextLine);
                startActivityForResult(intent, Constant.TAG_THERE);
                break;
            case R.id.imCarSelect:
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
            case R.id.imDriverSelect:
                String etTextDrive = etSelectDriver.getText().toString().trim();
                intent = new Intent(this, InspectDriveSelectTypeActivity.class);
                intent.putExtra("condition", etTextDrive);
                startActivityForResult(intent, Constant.TAG_FOUR);
                break;
            case R.id.tvZhiXu:
                if (recyZhiXu.getVisibility() == View.GONE) {
                    recyZhiXu.setVisibility(View.VISIBLE);
                } else {
                    recyZhiXu.setVisibility(View.GONE);
                }
                break;
            case R.id.btn:
                carNo = etSelectCar.getText().toString();
                carLine = etSelectLine.getText().toString();
                carDrive = etSelectDriver.getText().toString();
                carAddress = etSelectAddress.getText().toString();
                checkPerson = etSelectCheck.getText().toString();
                if (carNo.isEmpty()) {
                    Toast.makeText(this, "请输入车牌号", Toast.LENGTH_SHORT).show();
                } else if (carLine.isEmpty()) {
                    Toast.makeText(this, "请输入线路", Toast.LENGTH_SHORT).show();
                } else if (carDrive.isEmpty()) {
                    Toast.makeText(this, "请输入驾驶员", Toast.LENGTH_SHORT).show();
                } else if (carAddress.isEmpty()) {
                    Toast.makeText(this, "请输入区段", Toast.LENGTH_SHORT).show();
                }else if (checkPerson.isEmpty()) {
                    Toast.makeText(this, "请输入检查人", Toast.LENGTH_SHORT).show();
                } else {
                    ProgressDialogUtil.startLoad(this, Constant.UPDATA);
                    for (int i = 0; i < fwtypeList.size(); i++) {
                        map_project.put(aqList.get(i), fwtypeList.get(i));
                    }
                    for (int i = 0; i < wsimageList.size(); i++) {
                        map_photoName.put(aqList.get(i), wsimageList.get(i));
                    }
                    map_project_.putAll(map_project);
                    map_photoName_.putAll(map_photoName);
                    sendHealthData();
                }
                break;
            case R.id.imCheckSelect:
                Intent intent1 = new Intent(this,CheckPersonActivity.class);
                startActivityForResult(intent1, TAG_FIVE);
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
            case TAG_ONE:
                if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Matisse.from(InspectSufferActivity.this)
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
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_ONE:
                List<Uri> result2 = new ArrayList<>();
                if (requestCode == TAG_ONE && resultCode == RESULT_OK) {
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
                    saveImageToSD(bm, "temp");
                }
                break;
            case TAG_TWO:
                if (resultCode == Constant.TAG_THERE) {
                    carNo = data.getStringExtra("bian");
                    etSelectCar.setText(carNo);
                    busCode = data.getStringExtra("bianId");
                    getCorrelationData(busCode);
                }
                break;
            case Constant.TAG_THERE:
                if (resultCode == Constant.TAG_FOUR) {
                    line = data.getStringExtra("bianCode");
                    depId = data.getStringExtra("bianId");
                    depName = data.getStringExtra("bianName");
                    etSelectLine.setText(line);
                }
                break;
            case Constant.TAG_FOUR:
                if (resultCode == Constant.TAG_FIVE) {
                    String line = data.getStringExtra("bian");
                    driverName = data.getStringExtra("bian");
                    userCode = data.getStringExtra("bianId");
                    etSelectDriver.setText(line);
                }
                break;
            case Constant.TAG_FIVE:
                if (resultCode == Constant.TAG_SIX) {
                    userName = data.getStringExtra("name");
                    etSelectCheck.setText(userName);
                }
                break;
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

    /**
     * 图片保存到本地
     *
     * @param cbitmap01
     * @param dirPath
     */
    private void saveImageToSD(Bitmap cbitmap01, String dirPath) {
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
        imageListws.add(map);
        wsimageList.set(position, imageName);
        for (int i = 0; i < imageListws.size(); i++) {
            for (String key : imageListws.get(i).keySet()) {
                final RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + imageListws.get(i).get(key));
                String name = imageListws.get(i).get(key);
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
//                                for (int i = 0; i < imageListws.size(); i++) {
//                                    for (String key : imageListws.get(i).keySet()) {
//                                        if (!Integer.valueOf(key).equals(i)) {
//                                            String tag = weishengList.get(i);
//                                            boolean contains = map_photoName.containsKey(tag);
//                                            if (contains) {         //如果条件为真
//                                            } else {
//                                                map_photoName.put(weishengList.get(i), "");
//                                            }
//                                        }
//                                    }
//                                }
                        imageListws = new ArrayList<Map<String, String>>();
                        Log.i("XXX", "成功");
                        Log.i("XXX", arg1);
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


    @Override
    public void getInspectSufferViewData(InspectSuffeer inspectSuffeer) {
        aqList = new ArrayList<>();
        for (int i = 0; i < inspectSuffeer.getResult().size(); i++) {
            aqList.add(inspectSuffeer.getResult().get(i).getProjectName());
        }
        InspectAllAQAdapter aqAdapter = new InspectAllAQAdapter(this, aqList);
        aqAdapter.setOnInnerItemOnClickListener(this);
        recyZhiXu.setAdapter(aqAdapter);
        for (int i = 0; i < aqList.size(); i++) {
            map_beizhu.put(aqList.get(i), "");
        }
        for (int i = 0; i < aqList.size(); i++) {
            fwtypeList.add("1");
        }
        for (int i = 0; i < aqList.size(); i++) {
            wsimageList.add("");
        }
        map_beizhu_.putAll(map_beizhu);
        //判断数据库是否有驾驶员信息
        decideDbForInspectDriveData();
    }

    /**
     * 判断数据库是否有驾驶员信息
     */
    private void decideDbForInspectDriveData() {
        //查询数据
        Cursor cursor;
        String sqlR = "select * from inspectDriveP order by random() limit 100";// order by random() limit 100
        cursor = DbManager.queryBySQL(db, sqlR, null);
        listInspectDrive = DbManager.cursorToInspectDrive(cursor);
        if (listInspectDrive.size() == 0) {
            ProgressDialogUtil.startLoad(this,"获取驾驶员信息");
            String url = BASE_URL + "hrm/profileByPosEmpProfile.do";
            Util.getDataByHttpUrlConnection(url, new HttpURLConnectionCallBackListener() {
                @Override
                public void onSuccess(String s) {
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {
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
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFaile(Exception e) {

                }
            });
            //inspectDrivePresenter.getInspectDrivePresenterData();
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

    @Override
    public void getPosition(int position, String tag) {
        this.position = position;
        View layout = recyZhiXu.getLayoutManager().findViewByPosition(position);// 获得子item的layout
        imageView = (ImageView) layout.findViewById(R.id.imaheView);
        final ImageView ivNoPass = (ImageView) layout.findViewById(R.id.ivNoPass);
        final ImageView ivPass = (ImageView) layout.findViewById(R.id.ivPass);
        if (tag.equals("photo")) {
            if (ContextCompat.checkSelfPermission(InspectSufferActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(InspectSufferActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(InspectSufferActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        TAG_ONE);
            } else {
                Matisse.from(InspectSufferActivity.this)
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
     * 安全驾驶选项
     *
     * @param position
     */
    private void aqChaeck(int position) {
        fwtypeList.set(position, "1");
    }

    private void aqNoChaeck(int position) {
        fwtypeList.set(position, "0");
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    Toast.makeText(InspectSufferActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                    refresh();
                    break;
                case TAG_TWO:
                    Toast.makeText(InspectSufferActivity.this, "提交失败", Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(InspectSufferActivity.this, InspectSufferActivity.class);
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
    private void sendHealthData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBHandler dbS = new DBHandler();
                String turl = BASE_URL + "busmanager/mobileSaveAnquanzhixuJc.do";
                userName = etSelectCheck.getText().toString();
                //String userName = sharecPreferencesHelper.getData(InspectSufferActivity.this, "userName", "");
                //获取当前时间
                Date date = new Date(System.currentTimeMillis());
                String InspectionDate = tvTime.getText().toString();
                SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");
                String InspectionTime = simpleDateFormatTime.format(date);
                String dirverName = etSelectDriver.getText().toString();
                String depId_ = depId;
                String depName_ = depName;
                String note = "";
                String position = "";
                String pingjia_, luoshi_ = null;
                if (rbSelectAssessC.isChecked()) {
                    pingjia_ = "及格";
                } else {
                    pingjia_ = "优秀";
                }
                if (rbSelectSureC.isChecked()) {
                    luoshi_ = "通知公司";
                } else {
                    luoshi_ = "告诫本人";
                }
                String section_ = carAddress;
                res = dbS.anquanzhixuCommitValue(turl, userName, InspectionDate, InspectionTime, dirverName,
                        userCode, line, carNo, busCode, depId_, depName_, etSelectAddress.getText().toString(), pingjia_, luoshi_,
                        note, map_project_, map_photoName_, map_beizhu_, position);
                ProgressDialogUtil.stopLoad();
                if (res.equals("")) {
                    handler.sendEmptyMessage(TAG_ONE);
                } else {
                    handler.sendEmptyMessage(TAG_TWO);
                }

            }
        }).start();
    }
}
