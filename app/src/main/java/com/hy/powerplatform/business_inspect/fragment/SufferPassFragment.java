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
import com.hy.powerplatform.business_inspect.adapter.ExpandableStartPassAdapter;
import com.hy.powerplatform.business_inspect.adapter.InspectStarteAdapter;
import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.bean.InspectDrive;
import com.hy.powerplatform.business_inspect.bean.InspectHealth;
import com.hy.powerplatform.business_inspect.bean.InspectLine;
import com.hy.powerplatform.business_inspect.bean.InspectSuffeer;
import com.hy.powerplatform.business_inspect.bean.ShowLine;
import com.hy.powerplatform.business_inspect.presenter.CarCodePresenter;
import com.hy.powerplatform.business_inspect.presenter.InspectDrivePresenter;
import com.hy.powerplatform.business_inspect.presenter.InspectLinePresenter;
import com.hy.powerplatform.business_inspect.presenter.InspectSufferPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CarCodePresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.InspectDrivePresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.InspectLinePresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.InspectSufferPresenterimpl;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.business_inspect.utils.GetDataThread;
import com.hy.powerplatform.business_inspect.view.CarCodeView;
import com.hy.powerplatform.business_inspect.view.InspectDriveView;
import com.hy.powerplatform.business_inspect.view.InspectLineView;
import com.hy.powerplatform.business_inspect.view.InspectSufferView;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;

/**
 * Created by dell on 2017/8/1.
 */

public class SufferPassFragment extends Fragment implements CarCodeView, InspectLineView
        , InspectDriveView, InspectStarteAdapter.MyClickListener, InspectSufferView {
    View view;
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
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
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
    Unbinder unbinder;

    SQLiteDatabase db;
    MyDatabaseHelper helper;
    Cursor cursor;
    String carName;
    CarCodePresenter carCodePresenter;
    InspectLinePresenter inspectLinePresenter;
    InspectDrivePresenter inspectDrivePresenter;
    InspectSufferPresenter inspectSufferPresenter;
    int tag;
    File tmpDir;
    String carNo;
    String dirPath = "temp";
    String busCode, carLine, carDrive, carAddress, userCode, depId, depName,res;
    SharedPreferencesHelper sharecPreferencesHelper;

    private ArrayList<String> mResults = new ArrayList<>();//图片list
    List<CarCode.DataBean> listCarCode = new ArrayList<>();
    List<CarCode.DataBean> listCarCodeTest = new ArrayList<>();//判断数据库是否有车牌号信息
    List<InspectLine.DataBean> listInspectLine = new ArrayList<>();//获取线路网络数据
    List<ShowLine> listInspectLineTest = new ArrayList<>();//获取线路数据库数据
    List<InspectDrive.DataBean> listInspectDrive = new ArrayList<>();//获取驾驶员网络数据
    List<InspectDrive.DataBean> listInspectDriveTest = new ArrayList<>();//获取驾驶员数据库数据
    List<String> smallTypeList01 = new ArrayList<String>();//子项list
    //检查小项
    List<List<String>> smallTypeList = new ArrayList<>();
    List<String> bigTypeList = new ArrayList<>();
    List<String> typeList = new ArrayList<>();  //检查结果
    List<InspectHealth.ResultBean> inspectHealthList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    //图片list
    List<Map<String, String>> imageList = new ArrayList<>();
    private Map<String, String> map_project = new HashMap<String, String>();
    private Map<String, String> map_project_ = new HashMap<String, String>();
    private Map<String, String> map_photoName = new HashMap<String, String>();
    private Map<String, String> map_photoName_ = new HashMap<String, String>();
    private Map<String, String> map_beizhu = new HashMap<String, String>();
    private Map<String, String> map_beizhu_ = new HashMap<String, String>();
    List<InspectSuffeer.ResultBean> inspectSufferList = new ArrayList<>();
    ExpandableStartPassAdapter expandableListViewAdapter;
    Intent intent;

    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_stuffer_pass, container, false);
        unbinder = ButterKnife.bind(this, view);
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        expandableListView.setIndicatorBounds(width - 100, width);
        sharecPreferencesHelper = new SharedPreferencesHelper(getActivity(), "login");
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        carCodePresenter = new CarCodePresenterimpl(this, getActivity());
        inspectLinePresenter = new InspectLinePresenterimpl(this, getActivity());
        inspectDrivePresenter = new InspectDrivePresenterimpl(this, getActivity());
        inspectSufferPresenter = new InspectSufferPresenterimpl(this, getActivity());
        inspectSufferPresenter.getInspectSufferPresenterData();
        //设置Edittext
        new EditTextChange(etSelectLine).changeText();
        new EditTextChange(etSelectCar).changeText();
        new EditTextChange(etSelectDriver).changeText();
        new EditTextChange(etSelectAddress).changeText();
        //选择时间
        initDatePicker();
        //判断数据库是否有车牌号信息
        decideDbForCarCodeData();
        //判断数据库是否有线路信息
        decideDbForInspectLineData();
        //判断数据库是否有驾驶员信息
        decideDbForInspectDriveData();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tvTime, R.id.imLineSelect, R.id.imCarSelect, R.id.imDriverSelect, R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTime:
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
                intent = new Intent(getActivity(), InspectDriveSelectTypeActivity.class);
                intent.putExtra("condition", etTextDrive);
                startActivityForResult(intent, Constant.TAG_FOUR);
                break;
            case R.id.btn:
                carNo = etSelectCar.getText().toString();
                carLine = etSelectLine.getText().toString();
                carDrive = etSelectDriver.getText().toString();
                carAddress = etSelectAddress.getText().toString();
                if (carNo.isEmpty()) {
                    Toast.makeText(getActivity(), "请输入车牌号", Toast.LENGTH_SHORT).show();
                } else if (carLine.isEmpty()) {
                    Toast.makeText(getActivity(), "请输入线路", Toast.LENGTH_SHORT).show();
                } else if (carDrive.isEmpty()) {
                    Toast.makeText(getActivity(), "请输入驾驶员", Toast.LENGTH_SHORT).show();
                } else if (carDrive.isEmpty()) {
                    Toast.makeText(getActivity(), "请输入区段", Toast.LENGTH_SHORT).show();
                } else {
                    ProgressDialogUtil.startLoad(getActivity(), Constant.UPRESULT);
                    String sqlR = "select * from carcode where name = '" + etSelectCar.getText().toString() + "'";// order by random() limit 100
                    cursor = DbManager.queryBySQL(db, sqlR, null);
                    listCarCodeTest = DbManager.cursorToClassCar(cursor);
                    //busCode = listCarCodeTest.get(0).getValue();
                    String sqlH = "select * from inspectDrive where driverName = '" + etSelectDriver.getText().toString() + "'";// order by random() limit 100
                    Cursor cursor1;
                    cursor1 = DbManager.queryBySQL(db, sqlH, null);
                   // listInspectDriveTest = DbManager.cursorToInspectDrive(cursor1);
                    sendHealthData();
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
                    intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 1);
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
                if (mResults.size() != 0) {
                    Bitmap cbitmap01 = BitmapFactory.decodeFile(mResults.get(0), opts);
                    //图片存储到本地
                    saveImageToSD(cbitmap01, "temp");
                }
                break;
            case Constant.TAG_TWO:
                if (resultCode == Constant.TAG_THERE) {
                    carName = data.getStringExtra("bian");
                    etSelectCar.setText(carName);
                }
                break;
            case Constant.TAG_THERE:
                if (resultCode == Constant.TAG_FOUR) {
                    String line = data.getStringExtra("bianCode");
                    etSelectLine.setText(line);
                }
                break;
            case Constant.TAG_FOUR:
                if (resultCode == Constant.TAG_FIVE) {
                    String line = data.getStringExtra("bian");
                    etSelectDriver.setText(line);
                }
                break;
        }
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

        //新建文件存储裁剪后的图片
        File img = new File(tmpDir.getAbsolutePath() + "/" + String.valueOf(tag) + ".png");
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
        map.put(String.valueOf(tag), String.valueOf(tag) + ".png");
        imageList.add(map);
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvTime.setText(now.split(" ")[0]);
        //currentTime.setText(now);

        customDatePicker1 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvTime.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
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

    @Override
    public void getInspectSufferViewData(InspectSuffeer inspectSuffeer) {
        for (int i = 0; i < inspectSuffeer.getResult().size(); i++) {
            typeList.add("0");
            inspectSufferList.add(inspectSuffeer.getResult().get(i));
            if (!bigTypeList.contains(inspectSuffeer.getResult().get(i).getType())) {
                bigTypeList.add(inspectSuffeer.getResult().get(i).getType());
            }
        }
        for (int j = 0; j < bigTypeList.size(); j++) {
            smallTypeList01 = new ArrayList<>();
            for (int k = 0; k < inspectSuffeer.getResult().size(); k++) {
                if (bigTypeList.get(j).equals(inspectSuffeer.getResult().get(k).getType())) {
                    smallTypeList01.add(inspectSuffeer.getResult().get(k).getProjectName());
                }
            }
            smallTypeList.add(smallTypeList01);
        }
        expandableListViewAdapter = new ExpandableStartPassAdapter(MyApplication.getContextObject(), bigTypeList, smallTypeList);
        expandableListView.setAdapter(expandableListViewAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                setChildViewHeight(expandableListView, groupPosition, true);
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                setChildViewHeight(expandableListView, groupPosition, false);
            }
        });
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
     * 线路回调
     *
     * @param inspectLine
     */
    @Override
    public void getInspectLineViewData(InspectLine inspectLine) {
        GetDataThread.saveInspectLineData(inspectLine, db, helper, listInspectLine);
    }

    @Override
    public void clickListener(View v) {
        tag = (int) v.getTag();
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
    }

    /**
     * 向服务器发送数据
     */
    private void sendHealthData() {
        AsyncHttpClient client = new AsyncHttpClient();
        String url = BASE_URL + "busmanager/upLoadImageAnquanzhixuJc.do";
        //http://221.195.69.109:7080/joffice/starkh/upLoadImageYoufushifancheKaohe.do
        for (int i = 0; i < smallTypeList01.size(); i++) {
            map_beizhu.put(smallTypeList01.get(i), "");
            map_project.put(smallTypeList01.get(i), typeList.get(i));
            if (imageList.size() != 0) {
                for (int j = 0; j < imageList.size(); j++) {
                    for (String key : imageList.get(j).keySet()) {
                        if (!Integer.valueOf(key).equals(i)) {
                            map_photoName.put(smallTypeList01.get(i), "");
                        } else {
                            map_photoName.put(smallTypeList01.get(i), imageList.get(j).get(key));
                            RequestParams params = new RequestParams();
                            File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + imageList.get(i).get(key));
                            String sdpath = Environment.getExternalStorageDirectory()
                                    + "/" + dirPath;// 获取sdcard的根路径
                            String filepath = imageList.get(j).get(key);
                            try {
                                params.put("upload", file);
                                params.put("fullname", filepath);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            // 执行post请求
                            client.post(url, params, new AsyncHttpResponseHandler() {
                                @Override
                                public void onSuccess(int arg0, String arg1) {
                                    super.onSuccess(arg0, arg1);
                                    Log.i("XXX", "XXX");
                                }

                                @Override
                                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                    super.onFailure(statusCode, headers, responseBody, error);
                                    Log.i("XXX", "XXXXX");
                                }
                            });
                        }
                    }
                }
            } else {
                map_photoName.put(smallTypeList01.get(i), "");
            }
            map_photoName_.putAll(map_photoName);
            map_project_.putAll(map_project);
            map_beizhu_.putAll(map_beizhu);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                DBHandler dbS = new DBHandler();
                String turl = BASE_URL + "busmanager/mobileSaveAnquanzhixuJc.do";
                String userName = sharecPreferencesHelper.getData(getActivity(), "userName", "");
                //获取当前时间
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date(System.currentTimeMillis());
                String InspectionDate = tvTime.getText().toString();
                SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm:ss");
                String InspectionTime = simpleDateFormatTime.format(date);
                String dirverName = etSelectDriver.getText().toString();
                String depId_ = depId;
                String depName_ = depName;
                String rode = "1";
                String note = "";
                String position = "";
                String busCode = "1";
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
                        userCode, String.valueOf(1), carNo, busCode, depId_, depName_, section_, pingjia_, luoshi_,
                        note, map_project_,map_photoName_,map_beizhu_,position);
                ProgressDialogUtil.stopLoad();
                handler.sendEmptyMessage(Constant.TAG_ONE);

            }
        }).start();
    }

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
            }
        }
    };

}
