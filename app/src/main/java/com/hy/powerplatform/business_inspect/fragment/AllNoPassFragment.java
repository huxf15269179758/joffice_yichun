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
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.activity.SelectOneCarActivity;
import com.hy.powerplatform.business_inspect.adapter.ExpandableStartNoPassAdapter;
import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.bean.InspectAll;
import com.hy.powerplatform.business_inspect.presenter.CarCodePresenter;
import com.hy.powerplatform.business_inspect.presenter.InspectAllPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CarCodePresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.InspectAllPresenterimpl;
import com.hy.powerplatform.business_inspect.utils.GetDataThread;
import com.hy.powerplatform.business_inspect.view.CarCodeView;
import com.hy.powerplatform.business_inspect.view.InspectAllView;
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

import static android.app.Activity.RESULT_OK;
import static com.hy.powerplatform.R.id.size;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;

/**
 * Created by dell on 2017/8/1.
 */

public class AllNoPassFragment extends Fragment implements CarCodeView, InspectAllView {
    View view;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.etSelectCar)
    EditText etSelectCar;
    @BindView(R.id.imCarSelect)
    ImageView imCarSelect;
    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    @BindView(R.id.btn)
    Button btn;

    String groupPosition1;
    String childPosition1;
    String groupPosition;
    String childPosition;
    String aqxcWmjs = null;
    String aqxcWmjsBz = "";
    String aqxcWmjsPic = "";
    String aqxcPwjs = null;
    String aqxcPwjsBz = "";
    String aqxcPwjsPic = "";
    String aqxcJcz = null;
    String aqxcJczBz = "";
    String aqxcJczPic = "";
    String aqxcAnjian = null;
    String aqxcAnjianBz = "";
    String aqxcAnjianPic = "";
    String aqxcZdgfyy = null;
    String aqxcZdgfyyBz = "";
    String aqxcZdgfyyPic = "";
    String aqxcYingji = null;
    String aqxcYingjiBz = "";
    String aqxcYingjiPic = "";
    String aqxcDanzhan = null;
    String aqxcDanzhanBz = "";
    String aqxcDanzhanPic = "";
    String aqxcYindaock = null;
    String aqxcYindaockBz = "";
    String aqxcYindaockPic = "";
    String aqxcZdzsk = null;
    String aqxcZdzskBz = "";
    String aqxcZdzskPic = "";
    String jsjnBabuzou = null;
    String jsjnBabuzouBz = "";
    String jsjnBabuzouPic = "";
    String jsjnDaisuyz = null;
    String jsjnDaisuyzBz = "";
    String jsjnDaisuyzPic = "";
    String jsjnYibiaojc = null;
    String jsjnYibiaojcBz = "";
    String jsjnYibiaojcPic = "";
    String jsjnQiqong = null;
    String jsjnQiqongBz = "";
    String jsjnQiqongPic = "";
    String jsjnDangwei = null;
    String jsjnDangweiBz = "";
    String jsjnDangweiPic = "";
    String jsjnDengguang = null;
    String jsjnDengguangBz = "";
    String jsjnDengguangPic = "";
    String jsjnKgqb = null;
    String jsjnKgqbBz = "";
    String jsjnKgqbPic = "";
    String jsjnZengjiand = null;
    String jsjnZengjiandBz = "";
    String jsjnZengjiandPic = "";
    String jsjnZongdianyuan = null;
    String jsjnZongdianyuanBz = "";
    String jsjnZongdianyuanPic = "";
    String fwgfYryb = null;
    String fwgfYrybBz = "";
    String fwgfYrybPic = "";
    String fwgfYuyantaidu = null;
    String fwgfYuyantaiduBz = "";
    String fwgfYuyantaiduPic = "";
    String fwgfPutonghua = null;
    String fwgfPutonghuaBz = "";
    String fwgfPutonghuaPic = "";
    String fwgfZhaogu = null;
    String fwgfZhaoguBz = "";
    String fwgfZhaoguPic = "";
    String fwgfShudao = null;
    String fwgfShudaoBz = "";
    String fwgfShudaoPic = "";
    String fwgfBaozhanqi = null;
    String fwgfBaozhanqiBz = "";
    String fwgfBaozhanqiPic = "";
    String fwgfWendu = null;
    String fwgfWenduBz = "";
    String fwgfWenduPic = "";
    String fwgfWeisheng = null;
    String fwgfWeishengBz = "";
    String fwgfWeishengPic = "";
    String fwgfBaifang = null;
    String fwgfBaifangBz = "";
    String fwgfBaifangPic = "";
    String fwgfZhanshipai = null;
    String fwgfZhanshipaiBz = "";
    String fwgfZhanshipaiPic = "";
    String fwgfWeizhan = null;
    String fwgfWeizhanBz = "";
    String fwgfWeizhanPic = "";
    String fwgfErcijz = null;
    String fwgfErcijzBz = "";
    String fwgfErcijzPic = "";
    String fwgfYiweishipin = null;
    String fwgfYiweishipinBz = "";
    String fwgfYiweishipinPic = "";
    String fwgfZhongdianzhanjc = null;
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
    String busCode;

    //检查结果
    List<String> typeList = new ArrayList<>();
    List<Map<String, String>> imageList = new ArrayList<>();
    List<Map<String, String>> imageList1 = new ArrayList<>();

    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    SharedPreferencesHelper sharecPreferencesHelper;
    CarCodePresenter carCodePresenter;
    ExpandableStartNoPassAdapter expandableListViewAdapter;
    InspectAllPresenter inspectAllPresenter;
    private ArrayList<String> mResults = new ArrayList<>();
    List<CarCode.DataBean> listCarCode = new ArrayList<>();
    List<CarCode.DataBean> listCarCodeTest = new ArrayList<>();
    List<InspectAll.DataBean> inspectAllList = new ArrayList<>();
    //检查大项
    List<String> bigTypeList = new ArrayList<>();
    //检查小项
    List<List<String>> smallTypeList = new ArrayList<>();
    //子项list
    List<String> smallTypeList01 = new ArrayList<String>();
    //储存不通过i;
    List<String> typeNoList = new ArrayList<String>();

    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_all_pass, container, false);
        ButterKnife.bind(this, view);
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        expandableListView.setIndicatorBounds(width-100, width);
        sharecPreferencesHelper = new SharedPreferencesHelper(getActivity(), "login");
        carCodePresenter = new CarCodePresenterimpl(this, getActivity());
        inspectAllPresenter = new InspectAllPresenterimpl(this, getActivity());
        inspectAllPresenter.getInspectAllPresenterData();
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        //选择时间
        initDatePicker();
        //查询数据
        String sqlR = "select * from carcode order by random() limit '" + 10 + "'";// order by random() limit 100
        cursor = DbManager.queryBySQL(db, sqlR, null);
        listCarCodeTest = DbManager.cursorToClassCar(cursor);
        if (listCarCodeTest.size() != 0) {
        } else {
            carCodePresenter.getCarCodePresenterData();
        }
        //设置EditText
        new EditTextChange(etSelectCar).changeText();
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
        },  "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvTime.setText(time);
            }
        },  "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(true); // 显示时和分
        customDatePicker2.setIsLoop(true); // 允许循环滚动
    }

    @OnClick({R.id.tvTime, R.id.imCarSelect, R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTime:
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.imCarSelect:
                String etText = etSelectCar.getText().toString().trim();
                Intent intent = new Intent(getActivity(), SelectOneCarActivity.class);
                intent.putExtra("condition", etText);
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.btn:
                carNo = etSelectCar.getText().toString();
                if (carNo.isEmpty()) {
                    Toast.makeText(getActivity(), "请输入车牌号", Toast.LENGTH_SHORT).show();
                } else {
                    ProgressDialogUtil.startLoad(getActivity(), Constant.UPRESULT);
                    String sqlR = "select * from carcode where name = '" + etSelectCar.getText().toString() + "'";// order by random() limit 100
                    cursor = DbManager.queryBySQL(db, sqlR, null);
                    listCarCodeTest = DbManager.cursorToClassCar(cursor);
//                    busCode = listCarCodeTest.get(0).getValue();
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
        }
    }

    private void saveImageToSD(Bitmap cbitmap01, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }

        //新建文件存储裁剪后的图片
        int size = 0;
        if (!groupPosition.equals("0")) {
            for (int i = 0; i < Integer.valueOf(groupPosition); i++) {
                size = size + (smallTypeList.get(i).size());
            }
            size = size + Integer.valueOf(childPosition);
            File img = new File(tmpDir.getAbsolutePath() + "/" + String.valueOf(size) + ".png");
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
            map.put(String.valueOf(size), String.valueOf(size) + ".png");
            imageList.add(map);
            imageList1.add(map);
        } else {
            File img = new File(tmpDir.getAbsolutePath() + "/" + groupPosition + ".png");
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
            map.put(String.valueOf(childPosition), String.valueOf(childPosition) + ".png");
            imageList.add(map);
            imageList1.add(map);
        }
    }

    private void getImageFromSD(String dirPath) {
        String sdpath = Environment.getExternalStorageDirectory()
                + "/" + dirPath;// 获取sdcard的根路径
        String filepath = sdpath + File.separator + String.valueOf(tag) + ".png";
        File file = new File(filepath);
        if (file.exists()) {
            Bitmap bm = BitmapFactory.decodeFile(filepath);
            // 将图片显示到ImageView中
        }
    }

    /**
     * 向服务器发送数据
     */
    private void sendInspectData() {
        for (int j = 0; j < inspectAllList.size(); j++) {
            typeList.add("0");
        }
        for (int j = 0; j < typeNoList.size(); j++) {
            for (int i = 0; i < inspectAllList.size(); i++) {
                if (i == Integer.valueOf(typeNoList.get(j))) {
                    typeList.set(i,"1");
                }
            }
            Log.i("XXXtypelisst", typeList.toString());
        }

        final AsyncHttpClient client = new AsyncHttpClient();
        Random rand = new Random();
        final String url = BASE_URL + "starkh/upLoadImageZonghejinnengKaohe.do";
        for (int i = 0; i<imageList.size();i++){
            for (String key :imageList.get(i).keySet()){
                final RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + imageList.get(i).get(key));
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = imageList.get(i).get(key);
                String name = filepath.substring(0, filepath.lastIndexOf("."))
                        +System.currentTimeMillis()+rand.nextInt(10)+filepath.substring(filepath.lastIndexOf("."));
                imageList1.get(i).put(key,name);
                try {
                    params.put("upload", file);
                    params.put("fullname", name);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 执行post请求
                        client.post(url, params, new AsyncHttpResponseHandler() {
                            @Override
                            public void onSuccess(int arg0, String arg1) {
                                super.onSuccess(arg0, arg1);
                                Log.i("XXX", "XXX");
                            }

                            @Override
                            public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                                super.onFailure(statusCode, headers, responseBody, error);
                                Log.i("XXX", "XXXXX");
                            }
                        });
                    }
                },2500);
            }
        }
        int num = 0;
        if (num < size) {
            String filePath = null;
            aqxcWmjs = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        aqxcWmjsPic = imageList1.get(i).get(key);
                    }
                }
            }
            num++;
            if (num <= size) {
                aqxcPwjs = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            filePath = imageList.get(i).get(key);
                            aqxcPwjsPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                aqxcJcz = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            aqxcJczPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                aqxcAnjian = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            aqxcAnjianPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                aqxcZdgfyy = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            aqxcZdgfyyPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                aqxcYingji = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            aqxcYingjiPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                aqxcDanzhan = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            aqxcDanzhanPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                aqxcYindaock = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            aqxcYindaockPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                aqxcZdzsk = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            aqxcZdzskPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                jsjnBabuzou = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            jsjnBabuzouPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                jsjnDaisuyz = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            jsjnDaisuyzPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                jsjnYibiaojc = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            jsjnYibiaojcPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                jsjnQiqong = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            jsjnQiqongPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                jsjnDangwei = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            jsjnDangweiPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                jsjnDengguang = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            jsjnDengguangPic = imageList.get(i).get(key);
                            jsjnDengguangPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                jsjnKgqb = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            jsjnKgqbPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                jsjnZengjiand = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            jsjnZengjiandPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                jsjnZongdianyuan = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            jsjnZongdianyuanPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }

            if (num <= size) {
                fwgfYryb = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfYrybPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfYuyantaidu = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfYuyantaiduPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfPutonghua = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfPutonghuaPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfZhaogu = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfZhaoguPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfShudao = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfShudaoPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfBaozhanqi = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfBaozhanqiPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfWendu = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfWenduPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfWeisheng = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfWeishengPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfBaifang = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfBaifangPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfZhanshipai = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfZhanshipaiPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfWeizhan = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfWeizhanPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfErcijz = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfErcijzPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfYiweishipin = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfYiweishipinPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
            if (num <= size) {
                fwgfZhongdianzhanjc = typeList.get(num);
                for (int i = 0; i < imageList.size(); i++) {
                    for (String key : imageList.get(i).keySet()) {
                        if (Integer.valueOf(key).equals(num)) {
                            fwgfZhongdianzhanjcPic = imageList1.get(i).get(key);
                        }
                    }
                }
                num++;
            }
        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                DBHandler dbA = new DBHandler();
//                String turl = Constant.BASE_URL + "starkh/mobileSaveZonghejinnengKaohe.do";
//                String userName = sharecPreferencesHelper.getData(getActivity(), "userName", "");
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-" +
//                        "dd");
//                Date date = new Date(System.currentTimeMillis());
//                String kaoheDate = tvTime.getText().toString();
//                String fenshu = "0.0";
//                String position = "";
//                String busCode = "1";
//                String res = dbA.kaoheCommitValue(turl, userName, kaoheDate, carNo, busCode, aqxcWmjs,
//                        aqxcWmjsBz, aqxcWmjsPic, aqxcPwjs, aqxcPwjsBz, aqxcPwjsPic, aqxcJcz, aqxcJczBz,
//                        aqxcJczPic, aqxcAnjian, aqxcAnjianBz, aqxcAnjianPic, aqxcZdgfyy, aqxcZdgfyyBz,
//                        aqxcZdgfyyPic, aqxcYingji, aqxcYingjiBz, aqxcYingjiPic, aqxcDanzhan,
//                        aqxcDanzhanBz, aqxcDanzhanPic, aqxcYindaock, aqxcYindaockBz, aqxcYindaockPic,
//                        aqxcZdzsk, aqxcZdzskBz, aqxcZdzskPic, jsjnBabuzou, jsjnBabuzouBz, jsjnBabuzouPic,
//                        jsjnDaisuyz, jsjnDaisuyzBz, jsjnDaisuyzPic, jsjnYibiaojc, jsjnYibiaojcBz,
//                        jsjnYibiaojcPic, jsjnQiqong, jsjnQiqongBz, jsjnQiqongPic, jsjnDangwei,
//                        jsjnDangweiBz, jsjnDangweiPic, jsjnDengguang, jsjnDengguangBz, jsjnDengguangPic,
//                        jsjnKgqb, jsjnKgqbBz, jsjnKgqbPic, jsjnZengjiand, jsjnZengjiandBz,
//                        jsjnZengjiandPic, jsjnZongdianyuan, jsjnZongdianyuanBz, jsjnZongdianyuanPic,
//                        fwgfYryb, fwgfYrybBz, fwgfYrybPic, fwgfYuyantaidu, fwgfYuyantaiduBz,
//                        fwgfYuyantaiduPic, fwgfPutonghua, fwgfPutonghuaBz, fwgfPutonghuaPic, fwgfZhaogu,
//                        fwgfZhaoguBz, fwgfZhaoguPic, fwgfShudao, fwgfShudaoBz, fwgfShudaoPic,
//                        fwgfBaozhanqi, fwgfBaozhanqiBz, fwgfBaozhanqiPic, fwgfWendu, fwgfWenduBz,
//                        fwgfWenduPic, fwgfWeisheng, fwgfWeishengBz, fwgfWeishengPic, fwgfBaifang,
//                        fwgfBaifangBz, fwgfBaifangPic, fwgfZhanshipai, fwgfZhanshipaiBz, fwgfZhanshipaiPic,
//                        fwgfWeizhan, fwgfWeizhanBz, fwgfWeizhanPic, fwgfErcijz, fwgfErcijzBz,
//                        fwgfErcijzPic, fwgfYiweishipin, fwgfYiweishipinBz, fwgfYiweishipinPic,
//                        fwgfZhongdianzhanjc, fwgfZhongdianzhanjcBz, fwgfZhongdianzhanjcPic,fenshu,position);
//                ProgressDialogUtil.stopLoad();
//                if (res.equals("")) {
//                    handler.sendEmptyMessage(Constant.TAG_ONE);
//                } else {
//                    handler.sendEmptyMessage(Constant.TAG_TWO);
//                }
//            }
//        }).start();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
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
            }
        }
    };


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
     * 获取车票号
     *
     * @param carCode
     */
    @Override
    public void getCarCodeViewData(CarCode carCode) {
        GetDataThread.saveCarCoodeData(carCode, db, helper, listCarCode);
    }

    /**
     * 获取考核项
     *
     * @param inspectAll
     */
    @Override
    public void getInspectAllViewData(InspectAll inspectAll) {
        for (int i = 0; i < inspectAll.getData().size(); i++) {
            inspectAllList.add(inspectAll.getData().get(i));
            if (!bigTypeList.contains(inspectAll.getData().get(i).getType())) {
                bigTypeList.add(inspectAll.getData().get(i).getType());
            }
        }
        for (int j = 0; j < bigTypeList.size(); j++) {
            smallTypeList01 = new ArrayList<>();
            for (int k = 0; k < inspectAll.getData().size(); k++) {
                if (bigTypeList.get(j).equals(inspectAll.getData().get(k).getType())) {
                    smallTypeList01.add(inspectAll.getData().get(k).getProjectName());
                }
            }
            smallTypeList.add(smallTypeList01);
        }
        expandableListViewAdapter = new ExpandableStartNoPassAdapter(MyApplication.getContextObject(), bigTypeList, smallTypeList,handler);
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

}
