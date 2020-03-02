package com.hy.powerplatform.signin.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.utils.CurrentDate;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

/**
 * Created by dell on 2018/6/15.
 */

public class SignInFragment extends Fragment {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_signin, container, false);
        ButterKnife.bind(this, view);

        sharedPreferencesHelper = new SharedPreferencesHelper(getActivity(), "login");
        userName = sharedPreferencesHelper.getData(getActivity(), "userStatus", "");
        currentDate = new CurrentDate().getCurrentData();
        currentTime = new CurrentDate().getCurrentTime();

        tvSignInTime.setText(currentTime);
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


    @OnClick({R.id.btnUp, R.id.btnDown,R.id.imageView1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnUp:
                upSignInData();
                break;
            case R.id.btnDown:
                upSignInData();
                break;
            case R.id.imageView1:
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                            TAG_TWO);
                } else {
                    Intent intent = new Intent(getActivity(), ImagesSelectorActivity.class);
                    intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 1);
                    intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 100000);
                    intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
                    startActivityForResult(intent, TAG_TWO);
                }
                break;
        }
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
                    Toast.makeText(getActivity(), "权限被拒绝", Toast.LENGTH_SHORT).show();
                }
                break;
            case TAG_TWO:
                if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(getActivity(), ImagesSelectorActivity.class);
                    intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 1);
                    intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 100000);
                    intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
                    startActivityForResult(intent, TAG_TWO);
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
            case TAG_TWO:
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
//                    Bitmap btmUp = Bitmap.createBitmap(cbitmap01, 0, 0, cbitmap01.getWidth(),
//                            cbitmap01.getHeight(), matrix, true);
                    //base64DataUp = bitmapToBase64(btmUp);
                }
                if (mResults.size() != 0) {
                    Bitmap cbitmap01 = BitmapFactory.decodeFile(mResults.get(0), opts);
                    //图片存储到本地
                    saveImageToSD(cbitmap01, "temp");
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
        if (addess.equals("正在定位...")) {
            Toast.makeText(getActivity(), "定位失败", Toast.LENGTH_SHORT).show();
        } else {
            ProgressDialogUtil.startLoad(getActivity(), Constant.UPDATA);
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
                        String userCode = sharedPreferencesHelper.getData(getActivity(), "userName", "");
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
                    Toast.makeText(getActivity(), res, Toast.LENGTH_SHORT).show();
                    break;
                case TAG_TWO:
                    Toast.makeText(getActivity(), res, Toast.LENGTH_SHORT).show();
                    break;
                case 22:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(getActivity(), "签到成功", Toast.LENGTH_SHORT).show();
                    break;
                case 33:
                    ProgressDialogUtil.stopLoad();
                    Toast.makeText(getActivity(), res, Toast.LENGTH_SHORT).show();
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
                    String userCode = sharedPreferencesHelper.getData(getActivity(), "userName", "");
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

}

