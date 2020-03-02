package com.hy.powerplatform.signin.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.utils.CurrentDate;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class NewSignActivity extends BaseActivity {

    @BindView(R.id.btnUp)
    TextView btnUp;
    @BindView(R.id.btnDown)
    TextView btnDown;
    @BindView(R.id.tvSignInTime)
    TextView tvSignInTime;
    @BindView(R.id.tvSignInAddress)
    TextView tvSignInAddress;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.imageView4)
    ImageView imageView4;
    @BindView(R.id.btnSend)
    Button btnSend;
    @BindView(R.id.header)
    com.hy.powerplatform.my_utils.myViews.Header header;
    private View view;

    public LocationClient mLocationClient = null;
    String addr, userName, currentDate, currentTime;
    private ArrayList<String> mResults = new ArrayList<>();
    private MyLocationListener myListener = new MyLocationListener();
    List<Map<String, String>> imageList = new ArrayList<>();
    int tag;
    File tmpDir;
    String dirPath = "temp";
    double latitude;    //获取纬度信息
    double longitude;
    String res, mesg;

    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
//        new EditTextChange(tvSignInAddress).changeText();
        sharedPreferencesHelper = new SharedPreferencesHelper(this, "login");
        userName = sharedPreferencesHelper.getData(this, "userStatus", "");
        currentDate = new CurrentDate().getCurrentData();
        currentTime = new CurrentDate().getCurrentTime();

        tvSignInTime.setText(currentTime);
//        mLocationClient = new LocationClient(this.getApplicationContext());
//        //声明LocationClient类
//        mLocationClient.registerLocationListener(myListener);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                    TAG_ONE);
        } else {
            //开始定位
            getLatAndLod();
        }

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_new_sign;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        Intent intent = new Intent(this,SignHisActivity.class);
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case TAG_ONE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    //开始定位
                    getLatAndLod();
                } else {
                    Toast.makeText(NewSignActivity.this, "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                break;
            case TAG_TWO:
                if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Matisse.from(NewSignActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(1)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.hy.powerplatform.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .thumbnailScale(0.3f)  //图片缩放比例
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(TAG_ONE);//
                } else {
                    Toast.makeText(NewSignActivity.this, "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_TWO:
                if (resultCode == RESULT_OK) {
                    List<Uri> result1 = new ArrayList<>();
                    if (requestCode == TAG_TWO && resultCode == RESULT_OK) {
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
                        imageView1.setImageBitmap(bm);
                        saveImageToSD(bm, "temp");
                    }
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
        File img = new File(tmpDir.getAbsolutePath() + "/" + "signin" + ".png");
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
        map.put(String.valueOf(tag), "signin" + ".png");
        imageList.add(map);
    }

    /**
     * 开始定位
     */
    private void getLatAndLod() {
        mLocationClient.start();
        LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setCoorType("bd09ll");
        option.setScanSpan(0);
       option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    @OnClick({R.id.imageView1, R.id.btnSend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView1:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                            TAG_TWO);
                } else {
                    Matisse.from(NewSignActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(1)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.hy.powerplatform.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .thumbnailScale(0.3f)  //图片缩放比例
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(TAG_TWO);//
                }
                break;
            case R.id.btnSend:
                upSignInData();
                break;
        }
    }


    /**
     * 定位回调
     */
    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            latitude = location.getLatitude();    //获取纬度信息
            longitude = location.getLongitude();    //获取经度信息
            float radius = location.getRadius();    //获取定位精度，默认值为0.0f
            addr = location.getAddrStr();    //获取详细地址信息
            String coorType = location.getCoorType();
            int errorCode = location.getLocType();
            if (addr != null) {
                tvSignInAddress.setText(addr);
            }
        }
    }

    private void upSignInData() {
        final String addess = tvSignInAddress.getText().toString();
        if (addess.equals("")) {
            Toast.makeText(NewSignActivity.this, "位置定位错误，请手动输入", Toast.LENGTH_SHORT).show();
        } else {
            ProgressDialogUtil.startLoad(NewSignActivity.this, Constant.UPDATA);
            if (imageList.size() != 0) {
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + "signin" + ".png");
                String filepath = "signin" + ".png";
                if (file != null) {
                    String url = BASE_URL + "hrm/upLoadImageAttendanceSheet.do";
                    RequestParams params = new RequestParams();
                    try {
                        params.put("upload", file);
                        params.put("fullname", filepath);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    AsyncHttpClient client = new AsyncHttpClient();
                    // 执行post请求
                    client.post(url, params, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int arg0, String arg1) {
                            super.onSuccess(arg0, arg1);
                            Log.i("XXX", arg1.toString());
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(arg1);
                                String fullName = jsonObject.getString("msg");
                                Message message = new Message();
                                Bundle bundle = new Bundle();
                                bundle.putString("name", fullName);
                                message.setData(bundle);
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
                        final String gps = longitude + "," + latitude;
                        DBHandler dbS = new DBHandler();
                        String turl = BASE_URL + "hrm/saveDataAttendanceSheet.do";
                        String userCode = sharedPreferencesHelper.getData(NewSignActivity.this, "userName", "");
                        final String rq = new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date());
                        final String sj = new SimpleDateFormat("HHmmss", Locale.CHINA).format(new Date());
                        String addess = tvSignInAddress.getText().toString();
                        res = dbS.qiandaoCommitValue(turl, userName, addess, rq, sj, gps, userCode, "");
                        if (res.equals("")) {
                            handler.sendEmptyMessage(22);
                        } else {
                            handler.sendEmptyMessage(33);
                        }
                    }
                }).start();
            }
        }
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Toast.makeText(NewSignActivity.this, res, Toast.LENGTH_SHORT).show();
                    break;
                case TAG_TWO:
                    Toast.makeText(NewSignActivity.this, res, Toast.LENGTH_SHORT).show();
                    break;
                case 22:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(NewSignActivity.this, "签到成功", Toast.LENGTH_SHORT).show();
                    refresh();
                    break;
                case 33:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(NewSignActivity.this, res, Toast.LENGTH_SHORT).show();
                default:
                    break;
            }
        }

        ;
    };

    private Handler handlerSend = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            final String name = bundle.getString("name");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final String gps = longitude + "," + latitude;
                    DBHandler dbS = new DBHandler();
                    String turl = BASE_URL + "hrm/saveDataAttendanceSheet.do";
                    final String rq = new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date());
                    final String sj = new SimpleDateFormat("HHmmss", Locale.CHINA).format(new Date());
                    String userCode = sharedPreferencesHelper.getData(NewSignActivity.this, "userName", "");
                    String addess = tvSignInAddress.getText().toString();
                    res = dbS.qiandaoCommitValue(turl, userName, addess, rq, sj, gps, userCode, name);
                    if (res.equals("")) {
                        handler.sendEmptyMessage(22);
                    } else {
                        handler.sendEmptyMessage(33);
                    }
                }
            }).start();
        }
    };

    public void refresh() {
        finish();
        Intent intent = new Intent(NewSignActivity.this, NewSignActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        deleteFolderFile(Environment.getExternalStorageDirectory() + "/" + dirPath, true);
        mLocationClient.stop();
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
}
