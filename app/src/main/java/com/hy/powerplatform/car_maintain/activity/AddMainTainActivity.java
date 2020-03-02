package com.hy.powerplatform.car_maintain.activity;

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
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.car_maintain.bean.AboutData;
import com.hy.powerplatform.car_maintain.bean.Line;
import com.hy.powerplatform.car_maintain.presenter.AboutDataPresenter;
import com.hy.powerplatform.car_maintain.presenter.presenterimpl.AboutDataPresenterImpl;
import com.hy.powerplatform.car_maintain.view.AboutDataView;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerMin;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_FOUR;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_THERE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class AddMainTainActivity extends BaseActivity implements AboutDataView{

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvList)
    TextView tvList;
    @BindView(R.id.tvDanHao)
    TextView tvDanHao;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvZiBianHao)
    TextView tvZiBianHao;
    @BindView(R.id.tvCarNo)
    TextView tvCarNo;
    @BindView(R.id.tvLine)
    TextView tvLine;
    @BindView(R.id.tvDriver)
    TextView tvDriver;
    @BindView(R.id.tvBaoXiuRen)
    TextView tvBaoXiuRen;
    @BindView(R.id.tvJianChaRen)
    TextView tvJianChaRen;
    @BindView(R.id.tvBaoXiuType)
    TextView tvBaoXiuType;
    @BindView(R.id.tvDongliType)
    TextView tvDongliType;
    @BindView(R.id.tvCheXing)
    TextView tvCheXing;
    @BindView(R.id.tvLiCheng)
    TextView tvLiCheng;
    @BindView(R.id.tvChangShang)
    TextView tvChangShang;
    @BindView(R.id.tvDepart)
    TextView tvDepart;
    @BindView(R.id.etReasion)
    EditText etReasion;
    @BindView(R.id.etAddress)
    EditText etAddress;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    private CustomDatePickerMin customDatePicker;
    List<String> pathList = new ArrayList<>();
    Intent intent;
    File tmpDir;
    String Path;
    String data;

    AboutDataPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Calendar calendar = Calendar.getInstance();
        //年
        int year = calendar.get(Calendar.YEAR);
        //月
        int month = calendar.get(Calendar.MONTH) + 1;
        //日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String strRand = "";
        for (int i = 0; i < 5; i++) {
            strRand += String.valueOf((int) (Math.random() * 10));
        }
        tvDanHao.setText("A" + year + month + day + strRand);
        //选择时间
        initDatePicker();
        presenter = new AboutDataPresenterImpl(this,this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_add_main_tain;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        if (tvTime.getText().toString()!=null&&tvTime.getText().toString().length()!=0 &&
                tvZiBianHao.getText().toString()!=null&&tvZiBianHao.getText().toString().length()!=0 &&
                tvCarNo.getText().toString()!=null&&tvCarNo.getText().toString().length()!=0 &&
                tvLine.getText().toString()!=null&&tvLine.getText().toString().length()!=0 &&
                tvDriver.getText().toString()!=null&&tvDriver.getText().toString().length()!=0 &&
                tvBaoXiuRen.getText().toString()!=null&&tvBaoXiuRen.getText().toString().length()!=0 &&
                tvJianChaRen.getText().toString()!=null&&tvJianChaRen.getText().toString().length()!=0 &&
                tvBaoXiuType.getText().toString()!=null&&tvZiBianHao.getText().toString().length()!=0&&
                etReasion.getText().toString()!=null&&etReasion.getText().toString().length()!=0&&
                etAddress.getText().toString()!=null&&etAddress.getText().toString().length()!=0){

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");// HH:mm:ss
            Date date = new Date(System.currentTimeMillis());
            String myTime = simpleDateFormat.format(date);

            data = "?flag="+"0"+"&zt="+"1"+"&jobStatus="+"1"+"&prodata="+"[]"
                    +"&clPicData="+""+"&measureBus.depName="+tvDepart.getText().toString()
                    +"&measureBusNo="+tvDanHao.getText().toString()+"&measureBus.measureBusNo="+tvDanHao.getText().toString()
                    +"&measureBus.carNo="+tvCarNo.getText().toString()+"&measurePlace="+tvDepart.getText().toString()
                    +"&measureBus.materialType="+"单燃料"+"&measureBus.bustypeCode="+tvCheXing.getText().toString()
                    +"&measureBus.busCode="+tvZiBianHao.getText().toString()+"&measureBus.measurePlace="+tvDepart.getText().toString()
                    +"&measureBus.enterDate="+tvTime.getText().toString().split(" ")[0]+"&measureBus.repairDate="+tvTime.getText().toString().split(" ")[0]
                    +"&measureBus.busmaker="+"contents.bus_maker"+"&measureBus.mile="+tvLiCheng.getText().toString()
                    +"&measureBus.driverName="+tvDriver.getText().toString()
                    +"&measureBus.memo="+etReasion.getText().toString()
                    +"&measureBus.enterTime="+myTime+"&measureBus.repairTime="+myTime+"&measureBus.inputPersonName="+tvBaoXiuType.getText().toString()
                    +"&measureBus.repairCategory="+tvBaoXiuType.getText().toString()+"&measureBus.checkName="+tvJianChaRen.getText().toString()
                    +"&measureBus.repairAddress="+etAddress.getText().toString();

            String Ip = new SharedPreferencesHelper(AddMainTainActivity.this,"login").getData(this, "Ip", "");
            String Socket = new SharedPreferencesHelper(AddMainTainActivity.this,"login").getData(this, "Socket", "");
            String Found = new SharedPreferencesHelper(AddMainTainActivity.this,"login").getData(this, "Found", "");
            final String url = "http://"+Ip+":"+Socket+"/"+Found+"/" + "repair/saveMeasureBus.do";
            final String session = new SharedPreferencesHelper(AddMainTainActivity.this,"login").getData(AddMainTainActivity.this,"session","");
            ProgressDialogUtil.startLoad(AddMainTainActivity.this,"数据上传中");
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    MyHttpURLConnection.getData(url, new BaseRequestBackTLisenter() {
//                        @Override
//                        public void success(Object o) {
//                            handler.sendEmptyMessage(Constant.TAG_THERE);
//                        }
//
//                        @Override
//                        public void fail(String message) {
//                            handler.sendEmptyMessage(Constant.TAG_FOUR);
//                        }
//
//                        @Override
//                        public void failF(String message) {
//                            handler.sendEmptyMessage(Constant.TAG_FOUR);
//                        }
//                    });
                    upData(url,session);
                }
            }).start();
        }else {
            Toast.makeText(this, "请补全上传数据", Toast.LENGTH_SHORT).show();
        }

    }

    private void upData(String url1, String session) {
        try {
            //建立连接
            URL url = new URL(url1);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setDoOutput(false);
//            connection.setDoInput(true);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Charsert", "UTF-8");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(10000);
            //connection.setRequestProperty("Cookie", session);
            connection.connect();
            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
            dos.write(data.getBytes());
            dos.flush();
            dos.close();

            //获取响应状态
            int responseCode = connection.getResponseCode();

            if (200 == responseCode) { //连接成功
                //当正确响应时处理数据
                StringBuffer buffer = new StringBuffer();
                String readLine;
                BufferedReader responseReader;
                //处理响应流
                responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
                while ((readLine = responseReader.readLine()) != null) {
                    buffer.append(readLine).append("\n");
                }
                responseReader.close();
                Log.d("HttpGET", buffer.toString());
                handler.sendEmptyMessage(Constant.TAG_THERE);
                //JSONObject result = new JSONObject(buffer.toString());
            }else if (401 == responseCode){
                handler.sendEmptyMessage(Constant.TAG_FOUR);
            }else {
                handler.sendEmptyMessage(Constant.TAG_FOUR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            handler.sendEmptyMessage(Constant.TAG_FOUR);
        }
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvTime.setText(now);
        //currentTime.setText(now);

        customDatePicker = new CustomDatePickerMin(this, new CustomDatePickerMin.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvTime.setText(time);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker.showSpecificTime(true); // 不显示时和分
        customDatePicker.setIsLoop(false); // 不允许循环滚动
    }

    @OnClick({R.id.tvTime, R.id.tvZiBianHao, R.id.tvCarNo, R.id.tvLine, R.id.tvDriver, R.id.tvBaoXiuRen, R.id.tvJianChaRen, R.id.tvBaoXiuType, R.id.imageView1,R.id.tvDongliType})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTime:
                customDatePicker.show(tvTime.getText().toString());
                break;
            case R.id.tvZiBianHao:
                intent = new Intent(this, ZiBianHaoActivity.class);
                intent.putExtra("tag", "自编号");
                startActivityForResult(intent,Constant.TAG_TWO);
                break;
            case R.id.tvCarNo:
                intent = new Intent(this, CarNoActivity.class);
                intent.putExtra("tag", "车牌号");
                startActivityForResult(intent,Constant.TAG_THERE);
                break;
            case R.id.tvLine:
                intent = new Intent(this, LineActivity.class);
                intent.putExtra("tag", "线路");
                startActivityForResult(intent,Constant.TAG_FOUR);
                break;
            case R.id.tvDriver:
                intent = new Intent(this, DriverActivity.class);
                intent.putExtra("tag", "驾驶员");
                startActivityForResult(intent,Constant.TAG_FIVE);
                break;
            case R.id.tvBaoXiuRen:
                intent = new Intent(this, BaoxiuActivity.class);
                intent.putExtra("tag", "报修人");
                startActivityForResult(intent,Constant.TAG_SIX);
                break;
            case R.id.tvJianChaRen:
                intent = new Intent(this, JianChaRenActivity.class);
                intent.putExtra("tag", "检查人");
                startActivityForResult(intent,Constant.TAG_SEVEN);
                break;
            case R.id.tvDongliType:
                intent = new Intent(this, WeiXiuChangActivity.class);
                intent.putExtra("tag", "维修厂");
                startActivityForResult(intent,Constant.TAG_EIGHT);
                break;
            case R.id.tvBaoXiuType:
                intent = new Intent(this, BaoxiuTypeActivity.class);
                intent.putExtra("tag", "报修类型");
                startActivityForResult(intent,Constant.TAG_NINE);
                break;
            case R.id.imageView1:
                if (ContextCompat.checkSelfPermission(AddMainTainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(AddMainTainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(AddMainTainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                            TAG_ONE);
                } else {
                    Matisse.from(AddMainTainActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(1)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.hy.powerplatform.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .thumbnailScale(0.3f)  //图片缩放比例
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(TAG_ONE);//
                }
                break;
        }
    }

    //权限申请结果
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case TAG_ONE:
                if (grantResults.length == 2 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Matisse.from(AddMainTainActivity.this)
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

    //数据回调
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_ONE:
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
                    imageView1.setImageBitmap(bm);
                    SaveImageToSD(bm, "temp");
                }
                break;
            case Constant.TAG_TWO:
                if (requestCode == Constant.TAG_TWO){
                    if (data!=null){
                        String ZiBianHao = data.getStringExtra("ziBianHao");
                        tvZiBianHao.setText(ZiBianHao);
                        presenter.getAboutDataPresenter(ZiBianHao);
                    }
                }
                break;
            case Constant.TAG_THERE:
                if (requestCode == Constant.TAG_THERE){
                    if (data!=null) {
                        String carNo = data.getStringExtra("carNo");
                        tvCarNo.setText(carNo);
                    }
                }
                break;
            case Constant.TAG_FOUR:
                if (requestCode == Constant.TAG_FOUR){
                    if (data!=null) {
                        Line.DataBean line = (Line.DataBean) data.getSerializableExtra("line");
                        tvLine.setText(line.getLineCode());
                        tvDepart.setText(line.getDepartment().getDepName());
                    }
                }
                break;
            case Constant.TAG_FIVE:
                if (requestCode == Constant.TAG_FIVE){
                    if (data!=null) {
                        String driver = data.getStringExtra("driver");
                        tvDriver.setText(driver);
                    }
                }
                break;
            case Constant.TAG_SIX:
                if (requestCode == Constant.TAG_SIX){
                    if (data!=null) {
                        String baoXiu = data.getStringExtra("baoXiu");
                        tvBaoXiuRen.setText(baoXiu);
                    }
                }
                break;
            case Constant.TAG_SEVEN:
                if (requestCode == Constant.TAG_SEVEN){
                    if (data!=null) {
                        String jianChaRen = data.getStringExtra("jianChaRen");
                        tvJianChaRen.setText(jianChaRen);
                    }
                }
                break;
            case Constant.TAG_EIGHT:
                if (requestCode == Constant.TAG_EIGHT){
                    if (data!=null) {
                        String weiXiuChang = data.getStringExtra("weiXiuChang");
                        tvDongliType.setText(weiXiuChang);
                    }
                }
                break;
            case Constant.TAG_NINE:
                if (requestCode == Constant.TAG_NINE){
                    if (data!=null) {
                        String baoXiuType = data.getStringExtra("baoXiuType");
                        tvBaoXiuType.setText(baoXiuType);
                    }
                }
                break;
        }
    }

    //图片存储本地
    private void SaveImageToSD(Bitmap cbitmap01, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }
        Random random = new Random();
        //新建文件存储裁剪后的图片
        String imageName = "weixiu" + ".png";
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
                final RequestParams params = new RequestParams();
                File file = new File(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" +"weixiu.png");
                String sdpath = Environment.getExternalStorageDirectory()
                        + "/" + dirPath;// 获取sdcard的根路径
                try {
                    params.put("upload", file);
                    params.put("fullname", "weixiu.png");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                final AsyncHttpClient client = new AsyncHttpClient();
                final String url = Constant.BASE_URL1 + "busmanager/upLoadImageAccidentBasicInformation.do";
//                ProgressDialogUtil.startLoad(this,"");
                client.post(url, params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int arg0, String arg1) {
                        super.onSuccess(arg0, arg1);
                        Log.e("XXXH",arg1);
                        Message message = new Message();
                        message.what = Constant.TAG_ONE;
                        handler.sendMessage(message);
                    }
                    @Override
                    public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                        super.onFailure(statusCode, headers, responseBody, error);
                        Log.i("XXXH", "XXXXX");
                        Message message = new Message();
                        message.what = Constant.TAG_TWO;
                        handler.sendMessage(message);
                    }
                });
            }

    @Override
    public void getAboutDataViewView(AboutData aboutData) {
        if (aboutData.getData().getCh()!=null){
            tvZiBianHao.setText(aboutData.getData().getCh());
        }

        if (aboutData.getData().getCarNo()!=null){
            tvCarNo.setText(aboutData.getData().getCarNo());
        }
        if (aboutData.getData().getFullname()!=null){
            tvDriver.setText(aboutData.getData().getFullname());
        }
        if (String.valueOf(aboutData.getData().getLc())!=null){
            tvLiCheng.setText(String.valueOf(aboutData.getData().getLc()));
        }
        if (aboutData.getData().getVehicleType()!=null){
            tvCheXing.setText(aboutData.getData().getVehicleType());
        }
        if (aboutData.getData().getBus_maker()!=null){
            tvChangShang.setText(aboutData.getData().getBus_maker());
        }
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case TAG_ONE:
                    Toast.makeText(AddMainTainActivity.this, "图片上传成功", Toast.LENGTH_SHORT).show();
                    break;
                case TAG_TWO:
                    Toast.makeText(AddMainTainActivity.this, "图片上传失败", Toast.LENGTH_SHORT).show();
                    break;
                case TAG_THERE:
                    Toast.makeText(AddMainTainActivity.this, "数据上传成功", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_FOUR:
                    Toast.makeText(AddMainTainActivity.this, "数据上传失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
