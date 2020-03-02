package com.hy.powerplatform.business_inspect.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
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
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.adapter.CheckUpSpinnerAdapter;
import com.hy.powerplatform.business_inspect.bean.Matter;
import com.hy.powerplatform.business_inspect.presenter.MatterPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.MatterPresenterimpl;
import com.hy.powerplatform.business_inspect.view.MatterView;
import com.hy.powerplatform.database.DbManager;
import com.hy.powerplatform.database.MyDatabaseHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.EditTextChange;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.HttpURLConnectionCallBackListener;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.Util;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
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
import java.net.URLEncoder;
import java.text.ParseException;
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
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.widget.Toast.makeText;
import static com.hy.powerplatform.R.drawable.check;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;


public class InspectYeWuActivity extends BaseActivity implements MatterView, CheckUpSpinnerAdapter.GetItemTextViewPosition {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.imTimeSelect)
    ImageView imTimeSelect;
    @BindView(R.id.etSelectCar)
    EditText etSelectCar;
    @BindView(R.id.imCarSelect)
    ImageView imCarSelect;
    @BindView(R.id.etSelectClean)
    EditText etSelectClean;
    @BindView(R.id.imCleanSelect)
    ImageView imCleanSelect;
    @BindView(R.id.etSelectWork)
    EditText etSelectWork;
    @BindView(R.id.imWorkSelect)
    ImageView imWorkSelect;
    @BindView(R.id.listView)
    RecyclerView listView;
    @BindView(R.id.etInspectRemarks)
    EditText etInspectRemarks;
    @BindView(R.id.btn)
    Button btn;

    Intent intent;
    Cursor cursor;
    SQLiteDatabase db;
    MyDatabaseHelper helper;
    String carName, carNameId, checkUpName, checkUpId, userName;
    MatterPresenter matterPresenter;
    SharedPreferencesHelper sharecPreferencesHelper;
    //检查项
    List<Matter.ResultBean> matterList = new ArrayList<>();
    @BindView(R.id.imageview)
    ImageView imageview;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.llOut)
    LinearLayout llOut;
    private ArrayList<String> mResults = new ArrayList<>();//图片list

    List<Map<String, String>> imageListws = new ArrayList<>();
    List<String> checkList = new ArrayList<>();
    List<String> imageList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";
    String url = BASE_URL + "starkh/upLoadImageVehicleHealthInspection.do";
    ImageView imageView1, imageView2;
    CheckUpSpinnerAdapter adapter;
    int position;
    File tmpDir;
    String userCode, checkUserCode;
    boolean num = false;
    String dirPath = "temp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        sharecPreferencesHelper = new SharedPreferencesHelper(this, "login");
        userName = sharecPreferencesHelper.getData(this, "userStatus", "");
        userCode = sharecPreferencesHelper.getData(this, "userName", "");
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        //设置Edittext
        new EditTextChange(etSelectCar).changeText();
        new EditTextChange(etSelectClean).changeText();
        new EditTextChange(etSelectWork).changeText();
        new EditTextChange(etInspectRemarks).changeText();
        matterPresenter = new MatterPresenterimpl(this, this);
        matterPresenter.getMatterPresenterData();
        initDatePicker();
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageview.setVisibility(View.GONE);
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        listView.setLayoutManager(manager);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_inspect_yewu;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        Intent intent = new Intent(this, InspectYeWuListActivity.class);
        startActivity(intent);
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvTime.setText(now.split(" ")[0]);
        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvTime.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker1.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker1.setIsLoop(false);

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                tvTime.setText(time);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        customDatePicker2.showSpecificTime(true);
        customDatePicker2.setIsLoop(true);
    }

    @OnClick({R.id.tvTime, R.id.imCarSelect, R.id.imCleanSelect, R.id.imWorkSelect, R.id.btn, R.id.llOut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTime:
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.imCarSelect:
                String etText = etSelectCar.getText().toString().trim();
                intent = new Intent(this, SelectOneCarActivity.class);
                intent.putExtra("condition", etText);
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.imCleanSelect:
                String etText1 = etSelectClean.getText().toString().trim();
                intent = new Intent(this, SelectOneCheckUpActivity.class);
                intent.putExtra("condition", etText1);
                startActivityForResult(intent, Constant.TAG_THERE);
                break;
            case R.id.imWorkSelect:
                break;
            case R.id.btn:
                judgeTimeAndSend();
                break;
            case R.id.llOut:
                if (listView.getVisibility() == View.GONE) {
                    listView.setVisibility(View.VISIBLE);
                } else {
                    listView.setVisibility(View.GONE);
                }
                break;
        }
    }

    /**
     * 根据url，发送异步Post请求
     *
     * @param url       提交到服务器的地址
     * @param fileNames 完整的上传的文件的路径名
     * @param callback  OkHttp的回调接口
     */
    public static void upLoadFile(String url, List<String> fileNames, Callback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(getRequest(url, fileNames));
        call.enqueue(callback);
    }

    /**
     * 获得Request实例
     *
     * @param url
     * @param fileNames 完整的文件路径
     * @return
     */
    private static Request getRequest(String url, List<String> fileNames) {
        Request.Builder builder = new Request.Builder();
        builder.url(url)
                .post(getRequestBody(fileNames));
        return builder.build();
    }

    /**
     * 通过上传的文件的完整路径生成RequestBody
     *
     * @param fileNames 完整的文件路径
     * @return
     */
    private static RequestBody getRequestBody(List<String> fileNames) {
        //创建MultipartBody.Builder，用于添加请求的数据
        MultipartBody.Builder builder = new MultipartBody.Builder();
        for (int i = 0; i < fileNames.size(); i++) { //对文件进行遍历
            File file = new File(fileNames.get(i)); //生成文件
            //根据文件的后缀名，获得文件类型
            //String fileType = getMimeType(file.getName());
            builder.addFormDataPart( //给Builder添加上传的文件
                    "image",  //请求的名字
                    file.getName(), //文件的文字，服务器端用来解析的
                    RequestBody.create(MediaType.parse(".png"), file) //创建RequestBody，把上传的文件放入
            );
        }
        return builder.build(); //根据Builder创建请求
    }

    private void judgeTimeAndSend() {
        Date date = null;
        Date currentDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = tvTime.getText().toString();
        String currentTime = sdf.format(new Date(System.currentTimeMillis()));
        try {
            date = sdf.parse(time);
            currentDate = sdf.parse(currentTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date.getTime() > currentDate.getTime()) {
            makeText(InspectYeWuActivity.this, "请选择正确时间", Toast.LENGTH_SHORT).show();
        } else {
            ProgressDialogUtil.startLoad(InspectYeWuActivity.this, Constant.UPDATA);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    sendContent();
                }
            }, 2000);
        }
    }

    private void sendContent() {
        String url = BASE_URL + "starkh/mobileSaveWeishengJc.do";
        String carNo = etSelectCar.getText().toString();
        String CheckUp = etSelectClean.getText().toString();
        JSONObject jsonObject = new JSONObject();
        //Map<String, String> params = new HashMap<String, String>();
        if (carNo.isEmpty()) {
            makeText(InspectYeWuActivity.this, "请选择车辆", Toast.LENGTH_SHORT).show();
            ProgressDialogUtil.stopLoad();
        } else if (CheckUp.isEmpty()) {
            makeText(InspectYeWuActivity.this, "请选择检查人", Toast.LENGTH_SHORT).show();
            ProgressDialogUtil.stopLoad();
        } else {
            try {
                jsonObject.put("busCode", carNameId);
                jsonObject.put("carNo", carName);
                jsonObject.put("xcgCode", checkUserCode);
                jsonObject.put("xcgName", checkUpName);
                jsonObject.put("jcrName", userName);
                jsonObject.put("jcDate", tvTime.getText().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < matterList.size(); j++) {
                try {
                    jsonObject.put(matterList.get(j).getProjectName(), checkList.get(j));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 0; j < matterList.size(); j++) {
                try {
                    jsonObject.put(matterList.get(j).getProjectName() + "_picPath", imageList.get(j));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(jsonObject);
            Log.i("XXX", jsonArray.toString());
            url = url + "?data=" + URLEncoder.encode(String.valueOf(jsonArray)) + "&userCode=" + userCode;
            Util.getDataByHttpUrlConnection(url, new HttpURLConnectionCallBackListener() {
                @Override
                public void onSuccess(String s) {
                    try {
                        JSONObject jsonObject1 = new JSONObject(s);
                        String msg = jsonObject1.getString("msg");
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putString("msg", msg);
                        message.setData(bundle);//bundle传值，耗时，效率低
                        handler.sendMessage(message);//发送message信息
                        message.what = TAG_ONE;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFaile(Exception e) {
                    Message message = new Message();
                    handler.sendMessage(message);//发送message信息
                    message.what = Constant.TAG_TWO;
                }
            });

        }
    }

    /**
     * 检查项回调
     *
     * @param matter
     */
    @Override
    public void getMatterViewData(Matter matter) {
        for (int i = 0; i < matter.getResult().size(); i++) {
            matterList.add(matter.getResult().get(i));
            checkList.add("√");
            imageList.add("");
        }
        adapter = new CheckUpSpinnerAdapter(InspectYeWuActivity.this, matterList);
        adapter.setItemPosition(this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_ONE:
                List<Uri> result = new ArrayList<>();
                if (requestCode == TAG_ONE && resultCode == RESULT_OK) {
                    result = Matisse.obtainResult(data);
                }
                Bitmap cbitmap01 = null;
                Bitmap cbitmap02 = null;
                if (result.size() == 1) {
                    try {
                        cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(0));
                        imageView1.setVisibility(View.VISIBLE);
                        imageView1.setImageBitmap(cbitmap01);
                        //图片存储到本地
                        saveImageToSD(cbitmap01, "temp");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (result.size() == 2) {
                    try {
                        cbitmap01 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(0));
                        cbitmap02 = MediaStore.Images.Media.getBitmap(this.getContentResolver(), result.get(1));
                        imageView1.setVisibility(View.VISIBLE);
                        imageView2.setVisibility(View.VISIBLE);
                        imageView1.setImageBitmap(cbitmap01);
                        imageView2.setImageBitmap(cbitmap02);
                        //图片存储到本地
                        saveImageToSD2(cbitmap01, cbitmap02, "temp");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                    imageView1.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Matrix matrix = new Matrix();
//                            matrix.postScale(scaleWidth, scaleHeight);
//                            imageview.setVisibility(View.VISIBLE);
//                            imageview.setImageBitmap(cbitmap01);
//                            num = false;
//
//                        }
//                    });
//                    imageView2.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Matrix matrix = new Matrix();
//                            matrix.postScale(scaleWidth, scaleHeight);
//                            imageview.setVisibility(View.VISIBLE);
//                            imageview.setImageBitmap(cbitmap02);
//                            num = false;
//
//                        }
//                    });
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
                    checkUpName = data.getStringExtra("bianName");
                    checkUpId = data.getStringExtra("bianId");
                    checkUserCode = data.getStringExtra("bianUserCode");
                    etSelectClean.setText(checkUpName);
                }
                break;
//                    imageView1.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Matrix matrix = new Matrix();
//                            ////matrix.postScale(scaleWidth, scaleHeight);
//                            imageview.setVisibility(View.VISIBLE);
//                            imageview.setImageBitmap(cbitmap01);
//                            num = false;
//
//                        }
//                    });
        }
    }

    /**
     * 图片保存到本地
     *
     * @param dirPath
     */
    private void saveImageToSD(Bitmap cbitmap01, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }

        Matrix matrix = new Matrix();
        matrix.setScale(0.2f, 0.2f);
        Bitmap bm = Bitmap.createBitmap(cbitmap01, 0, 0, cbitmap01.getWidth(),
                cbitmap01.getHeight(), matrix, true);
        Random random = new Random();
        //新建文件存储裁剪后的图片
        String imageName = String.valueOf(position)
                + System.currentTimeMillis() + random.nextInt(10) + ".png";
        File img = new File(tmpDir.getAbsolutePath() + "/" + imageName);
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
        imageListws.add(map);
        imageList.set(position, imageName);
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
                List<String> pathList = new ArrayList<>();
                pathList.add(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + imageName);
                upLoadFile(url, pathList, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.i("XXX", e.toString());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.i("XXX", response.toString());
                    }
                });
//                Handler handler = new Handler();
//                final AsyncHttpClient client = new AsyncHttpClient();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        // 执行post请求
//                        client.post(url, params, new AsyncHttpResponseHandler() {
//                            @Override
//                            public void onSuccess(int arg0, String arg1) {
//                                super.onSuccess(arg0, arg1);
////                                for (int i = 0; i < imageListws.size(); i++) {
////                                    for (String key : imageListws.get(i).keySet()) {
////                                        if (!Integer.valueOf(key).equals(i)) {
////                                            String tag = weishengList.get(i);
////                                            boolean contains = map_photoName.containsKey(tag);
////                                            if (contains) {         //如果条件为真
////                                            } else {
////                                                map_photoName.put(weishengList.get(i), "");
////                                            }
////                                        }
////                                    }
////                                }
//                                imageListws = new ArrayList<Map<String, String>>();
//                                Log.i("XXX", "成功");
//                                Log.i("XXX", arg1);
//                            }
//
//                            @Override
//                            public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
//                                super.onFailure(statusCode, headers, responseBody, error);
//                                Log.i("XXX", "XXXXX");
//                            }
//                        });
//                    }
//                }, 1500);
            }
        }
    }

    private void saveImageToSD2(Bitmap cbitmap01, Bitmap cbitmap02, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }
        Matrix matrix = new Matrix();
        matrix.setScale(0.2f, 0.2f);
        Bitmap bm = Bitmap.createBitmap(cbitmap01, 0, 0, cbitmap01.getWidth(),
                cbitmap01.getHeight(), matrix, true);
        Matrix matrix1 = new Matrix();
        matrix1.setScale(0.2f, 0.2f);
        Bitmap bm1 = Bitmap.createBitmap(cbitmap02, 0, 0, cbitmap02.getWidth(),
                cbitmap02.getHeight(), matrix1, true);
        Random random = new Random();
        //新建文件存储裁剪后的图片
        String imageName = String.valueOf(position)
                + System.currentTimeMillis() + random.nextInt(10) + ".png";
        String imageName2 = String.valueOf(position) + "2" +
                +System.currentTimeMillis() + random.nextInt(10) + ".png";
        File img = new File(tmpDir.getAbsolutePath() + "/" + imageName);
        File img2 = new File(tmpDir.getAbsolutePath() + "/" + imageName2);
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

            //打开文件输出流
            FileOutputStream fos2 = new FileOutputStream(img2);
            //将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
            bm1.compress(Bitmap.CompressFormat.JPEG, 100, fos2);
            //刷新输出流
            fos2.flush();
            //关闭输出流
            fos2.close();
            //返回File类型的Uri
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageList.set(position, imageName + "," + imageName2);
        List<String> pathList = new ArrayList<>();
        pathList.add(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + imageName);
        pathList.add(Environment.getExternalStorageDirectory() + "/" + dirPath + "/" + imageName2);
        upLoadFile(url, pathList, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("XXX", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("XXX", response.toString());
            }
        });
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
                    Matisse.from(InspectYeWuActivity.this)
                            .choose(MimeType.allOf())//图片类型
                            .countable(true)//true:选中后显示数字;false:选中后显示对号
                            .maxSelectable(2)//可选的最大数
                            .capture(true)//选择照片时，是否显示拍照
                            .captureStrategy(new CaptureStrategy(true, "com.hy.powerplatform.fileprovider"))//参数1 true表示拍照存储在共有目录，false表示存储在私有目录；参数2与 AndroidManifest中authorities值相同，用于适配7.0系统 必须设置
                            .thumbnailScale(0.3f)  //图片缩放比例
                            .imageEngine(new GlideEngine())//图片加载引擎
                            .forResult(TAG_ONE);//
                } else {
                    makeText(InspectYeWuActivity.this, "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void getItemPosition(int position, String tag) {
        this.position = position;
        View layout = listView.getLayoutManager().findViewByPosition(position);// 获得子item的layout
        imageView1 = (ImageView) layout.findViewById(R.id.imageView1);
        imageView2 = (ImageView) layout.findViewById(R.id.imageView2);
        final ImageView ivNoPass = (ImageView) layout.findViewById(R.id.ivNoPass);
        final ImageView ivPass = (ImageView) layout.findViewById(R.id.ivPass);
        if (tag.equals("photo")) {
            if (ContextCompat.checkSelfPermission(InspectYeWuActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(InspectYeWuActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(InspectYeWuActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        TAG_ONE);
            } else {
                Matisse.from(InspectYeWuActivity.this)
                        .choose(MimeType.allOf())//图片类型
                        .countable(true)//true:选中后显示数字;false:选中后显示对号
                        .maxSelectable(2)//可选的最大数
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
            ivPass.setImageResource(check);
        }
        if (tag.equals("nopass")) {
            aqNoChaeck(position);
            ivNoPass.setImageResource(check);
            ivPass.setImageResource(R.drawable.nocheck);
        }
    }

    /**
     * 安全驾驶选项
     *
     * @param position
     */
    private void aqChaeck(int position) {
        checkList.set(position, "√");
    }

    private void aqNoChaeck(int position) {
        checkList.set(position, "X");
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    Bundle b = msg.getData();
                    String msg1 = b.getString("msg");
                    makeText(InspectYeWuActivity.this, msg1, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    refresh();
                    break;
                case Constant.TAG_TWO:
                    makeText(InspectYeWuActivity.this, "上传失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

    public void refresh() {
        finish();
        Intent intent = new Intent(InspectYeWuActivity.this, InspectYeWuActivity.class);
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
}
