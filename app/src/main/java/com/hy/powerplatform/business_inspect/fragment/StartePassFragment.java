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
import com.hy.powerplatform.business_inspect.adapter.ExpandableStartPassAdapter;
import com.hy.powerplatform.business_inspect.adapter.InspectStarteAdapter;
import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.bean.InspectStarte;
import com.hy.powerplatform.business_inspect.presenter.CarCodePresenter;
import com.hy.powerplatform.business_inspect.presenter.InspectStartePresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CarCodePresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.InspectStartePresenterimpl;
import com.hy.powerplatform.business_inspect.utils.GetDataThread;
import com.hy.powerplatform.business_inspect.view.CarCodeView;
import com.hy.powerplatform.business_inspect.view.InspectStarteView;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;

/**
 * Created by dell on 2017/8/1.
 */

public class StartePassFragment extends Fragment implements CarCodeView, InspectStarteView, InspectStarteAdapter.MyClickListener {
    View view;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.etSelectCar)
    EditText etSelectCar;
    @BindView(R.id.imCarSelect)
    ImageView imCarSelect;
    @BindView(R.id.etSelectAddress)
    EditText etSelectAddress;
    @BindView(R.id.expandableListView)
    ExpandableListView expandableListView;
    @BindView(R.id.btn)
    Button btn;


    String gffwYrybyt = null;
    String gffwYrybytBz = null;
    String gffwYrybytPic = "";
    String gffwPth = null;
    String gffwPthBz = null;
    String gffwPthPic = "";
    String gffwSzwmyy = null;
    String gffwSzwmyyBz = null;
    String gffwSzwmyyPic = "";
    String gffwFwyytd = null;
    String gffwFwyytdBz = null;
    String gffwFwyytdPic = "";
    String gffwZgsd = null;
    String gffwZgsdBz = null;
    String gffwZgsdPic = "";
    String gffwBaozhanqi = null;
    String gffwBaozhanqiBz = null;
    String gffwBaozhanqiPic = "";
    String gffwClws = null;
    String gffwClwsBz = null;
    String gffwClwsPic = "";
    String gffwWpbf = null;
    String gffwWpbfBz = null;
    String gffwWpbfPic = "";
    String gffwLEDlp = null;
    String gffwLEDlpBz = null;
    String gffwLEDlpPic = "";
    String gffwClbz = null;
    String gffwClbzBz = null;
    String gffwClbzPic = "";
    String gffwFwzsp = null;
    String gffwFwzspBz = null;
    String gffwFwzspPic = "";
    String gffwWendutf = null;
    String gffwWendutfBz = null;
    String gffwWendutfPic = "";
    String gffwGuzhanghc = null;
    String gffwGuzhanghcBz = null;
    String gffwGuzhanghcPic = "";
    String gffwFuwuts = null;
    String gffwFuwutsBz = null;
    String gffwFuwutsPic = "";

    String jsjnTingzhansk = null;
    String jsjnTingzhanskBz = null;
    String jsjnTingzhanskPic = "";
    String jsjnJiashiypcl = null;
    String jsjnJiashiypclBz = null;
    String jsjnJiashiypclPic = "";
    String jsjnYibiaojc = null;
    String jsjnYibiaojcBz = null;
    String jsjnYibiaojcPic = "";
    String jsjnLiheqi = null;
    String jsjnLiheqiBz = null;
    String jsjnLiheqiPic = "";
    String jsjnDwsy = null;
    String jsjnDwsyBz = null;
    String jsjnDwsyPic = "";
    String jsjnZhuanxiangd = null;
    String jsjnZhuanxiangdBz = null;
    String jsjnZhuanxiangdPic = "";
    String jsjnGuifantk = null;
    String jsjnGuifantkBz = null;
    String jsjnGuifantkPic = "";

    String aqxcZuishougz = null;
    String aqxcZuishougzBz = null;
    String aqxcZuishougzPic = "";
    String aqxcWenmingjs = null;
    String aqxcWenmingjsBz = null;
    String aqxcWenmingjsPic = "";
    String aqxcChaosu = null;
    String aqxcChaosuBz = null;
    String aqxcChaosuPic = "";
    String aqxcShigu = null;
    String aqxcShiguBz = null;
    String aqxcShiguPic = "";
    String aqxcGuifanjcz = null;
    String aqxcGuifanjczBz = null;
    String aqxcGuifanjczPic = "";
    String aqxcPaolaid = null;
    String aqxcPaolaidBz = null;
    String aqxcPaolaidPic = "";
    String aqxcKaiguancm = null;
    String aqxcKaiguancmBz = null;
    String aqxcKaiguancmPic = "";
    String aqxcAnjian = null;
    String aqxcAnjianBz = null;
    String aqxcAnjianPic = "";
    String aqxcXiaofangss = null;
    String aqxcXiaofangssBz = null;
    String aqxcXiaofangssPic = "";
    String aqxcZhongdianz = null;
    String aqxcZhongdianzBz = null;
    String aqxcZhongdianzPic = "";
    String dirPath = "temp";

    SQLiteDatabase db;
    MyDatabaseHelper helper;
    String textData;
    String carName, con;
    Cursor cursor;
    int num, tag;
    File tmpDir;
    String carNo;
    String busCode;

    //检查结果
    List<String> typeList = new ArrayList<>();
    List<Map<String, String>> imageList = new ArrayList<>();

    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    SharedPreferencesHelper sharecPreferencesHelper;
    CarCodePresenter carCodePresenter;
    ExpandableStartPassAdapter expandableListViewAdapter;
    InspectStartePresenter inspectStartePresenter;
    private ArrayList<String> mResults = new ArrayList<>();
    List<CarCode.DataBean> listCarCode = new ArrayList<>();
    List<CarCode.DataBean> listCarCodeTest = new ArrayList<>();
    List<InspectStarte.DataBean> inspectStarteList = new ArrayList<>();
    //检查大项
    List<String> bigTypeList = new ArrayList<>();
    //检查小项
    List<List<String>> smallTypeList = new ArrayList<>();
    //子项list
    List<String> smallTypeList01 = new ArrayList<String>();
    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_starte_pass, container, false);
        ButterKnife.bind(this, view);
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        expandableListView.setIndicatorBounds(width-100, width);
        sharecPreferencesHelper = new SharedPreferencesHelper(getActivity(), "login");
        carCodePresenter = new CarCodePresenterimpl(this, getActivity());
        inspectStartePresenter = new InspectStartePresenterimpl(this, getActivity());
        inspectStartePresenter.getInspectStartePresenterData();
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
        }, now, "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvTime.setText(time);
            }
        }, now, "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
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
                    busCode = listCarCodeTest.get(0).getValue();
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
                    busCode = data.getStringExtra("bianId");
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
        AsyncHttpClient client = new AsyncHttpClient();
        String url = BASE_URL + "starkh/upLoadImageYoufushifancheKaohe.do";
        //http://221.195.69.109:7080/joffice/starkh/upLoadImageYoufushifancheKaohe.do
        //if (con.equals("规范服务")) {
        int size = typeList.size();
        int num = 0;
        if (num < size) {
            gffwYrybyt = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwYrybytPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwYrybytPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwPth = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwPthPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwPthPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwSzwmyy = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwSzwmyyPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwSzwmyyPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwFwyytd = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwFwyytdPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwFwyytdPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwZgsd = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwZgsdPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwZgsdPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwBaozhanqi = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwBaozhanqiPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwBaozhanqiPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwClws = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwClwsPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwClwsPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwWpbf = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwWpbfPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwWpbfPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwClws = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwClwsPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwClwsPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwClbz = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwClbzPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwClbzPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwFwzsp = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwFwzspPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwFwzspPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwWendutf = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwWendutfPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwWendutfPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwGuzhanghc = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwGuzhanghcPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwGuzhanghcPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            gffwFuwuts = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        gffwFuwutsPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!gffwFuwutsPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        // } else if (con.equals("驾驶技能")) {
//            int size = typeList.size();
//            int num = 0;
        if (num <= size) {
            jsjnTingzhansk = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        jsjnTingzhanskPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!jsjnTingzhanskPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            jsjnJiashiypcl = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        jsjnJiashiypclPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!jsjnJiashiypclPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            jsjnYibiaojc = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        jsjnYibiaojcPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!jsjnYibiaojcPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            jsjnLiheqi = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        jsjnLiheqiPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!jsjnLiheqiPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            jsjnDwsy = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        jsjnDwsyPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!jsjnDwsyPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            jsjnZhuanxiangd = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        jsjnZhuanxiangdPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!jsjnZhuanxiangdPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            jsjnGuifantk = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        jsjnGuifantkPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!jsjnGuifantkPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
//        } else if (con.equals("规范运营安全行车")) {
//            int size = typeList.size();
//            int num = 0;
        if (num <= size) {
            aqxcZuishougz = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        aqxcZuishougzPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!aqxcZuishougzPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            aqxcWenmingjs = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        aqxcWenmingjsPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!aqxcWenmingjsPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            aqxcChaosu = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        aqxcChaosuPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!aqxcChaosuPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            aqxcShigu = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        aqxcShiguPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!aqxcShiguPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            aqxcGuifanjcz = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        aqxcGuifanjczPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!aqxcGuifanjczPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            aqxcPaolaid = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        aqxcPaolaidPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!aqxcPaolaidPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            aqxcKaiguancm = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        aqxcKaiguancmPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!aqxcKaiguancmPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            aqxcAnjian = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        aqxcAnjianPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!aqxcAnjianPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            aqxcXiaofangss = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        aqxcXiaofangssPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!aqxcXiaofangssPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
        if (num <= size) {
            aqxcZhongdianz = typeList.get(num);
            for (int i = 0; i < imageList.size(); i++) {
                for (String key : imageList.get(i).keySet()) {
                    if (Integer.valueOf(key).equals(num)) {
                        aqxcZhongdianzPic = imageList.get(i).get(key);
                    }
                }
            }
            if (!aqxcZhongdianzPic.isEmpty()) {
                RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + String.valueOf(num) + ".png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                String filepath = String.valueOf(num) + ".png";
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
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXX", "XXXXX");
                    }
                });
            }
            num++;
        }
//        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                DBHandler dbH = new DBHandler();
//                String turl = Constant.BASE_URL + "starkh/mobileSaveYoufushifancheKaohe.do";
//                String userName = sharecPreferencesHelper.getData(getActivity(), "userName", "");
//               // String kaoheDate = String.valueOf(System.currentTimeMillis());
//                String kaoheDate = tvTime.getText().toString();
//                String res = dbH.kaoheCommitValue_(turl, userName, kaoheDate, carNo, busCode, gffwYrybyt,
//                        gffwYrybytBz, gffwYrybytPic, gffwPth, gffwPthBz, gffwPthPic, gffwSzwmyy,
//                        gffwSzwmyyBz, gffwSzwmyyPic, gffwFwyytd, gffwFwyytdBz, gffwFwyytdPic, gffwZgsd,
//                        gffwZgsdBz, gffwZgsdPic, gffwBaozhanqi, gffwBaozhanqiBz, gffwBaozhanqiPic,
//                        gffwClws, gffwClwsBz, gffwClwsPic, gffwWpbf, gffwWpbfBz, gffwWpbfPic, gffwLEDlp,
//                        gffwLEDlpBz, gffwLEDlpPic, gffwClbz, gffwClbzBz, gffwClbzPic, gffwFwzsp,
//                        gffwFwzspBz, gffwFwzspPic, gffwWendutf, gffwWendutfBz, gffwWendutfPic,
//                        gffwGuzhanghc, gffwGuzhanghcBz, gffwGuzhanghcPic, gffwFuwuts, gffwFuwutsBz,
//                        gffwFuwutsPic, jsjnTingzhansk, jsjnTingzhanskBz, jsjnTingzhanskPic, jsjnJiashiypcl,
//                        jsjnJiashiypclBz, jsjnJiashiypclPic, jsjnYibiaojc, jsjnYibiaojcBz, jsjnYibiaojcPic,
//                        jsjnLiheqi, jsjnLiheqiBz, jsjnLiheqiPic, jsjnDwsy, jsjnDwsyBz, jsjnDwsyPic,
//                        jsjnZhuanxiangd, jsjnZhuanxiangdBz, jsjnZhuanxiangdPic, jsjnGuifantk,
//                        jsjnGuifantkBz, jsjnGuifantkPic, aqxcZuishougz, aqxcZuishougzBz, aqxcZuishougzPic,
//                        aqxcWenmingjs, aqxcWenmingjsBz, aqxcWenmingjsPic, aqxcChaosu, aqxcChaosuBz,
//                        aqxcChaosuPic, aqxcShigu, aqxcShiguBz, aqxcShiguPic, aqxcGuifanjcz,
//                        aqxcGuifanjczBz, aqxcGuifanjczPic, aqxcPaolaid, aqxcPaolaidBz, aqxcPaolaidPic,
//                        aqxcKaiguancm, aqxcKaiguancmBz, aqxcKaiguancmPic, aqxcAnjian, aqxcAnjianBz,
//                        aqxcAnjianPic, aqxcXiaofangss, aqxcXiaofangssBz, aqxcXiaofangssPic, aqxcZhongdianz,
//                        aqxcZhongdianzBz, aqxcZhongdianzPic,"0");//, fenshu,position
//                ProgressDialogUtil.stopLoad();
//                if (res.equals("")) {
//                    handler.sendEmptyMessage(TAG_ONE);
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
     * @param inspectStarte
     */
    @Override
    public void getInspectStarteViewData(InspectStarte inspectStarte) {
        for (int i = 0; i < inspectStarte.getData().size(); i++) {
            typeList.add("0");
            inspectStarteList.add(inspectStarte.getData().get(i));
            if (!bigTypeList.contains(inspectStarte.getData().get(i).getType())) {
                bigTypeList.add(inspectStarte.getData().get(i).getType());
            }
        }
        for (int j = 0; j < bigTypeList.size(); j++) {
            smallTypeList01 = new ArrayList<>();
            for (int k = 0; k < inspectStarte.getData().size(); k++) {
                if (bigTypeList.get(j).equals(inspectStarte.getData().get(k).getType())) {
                    smallTypeList01.add(inspectStarte.getData().get(k).getProjectName());
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
}
