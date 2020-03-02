package com.hy.powerplatform.business_inspect.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.activity.SelectOneCarActivity;
import com.hy.powerplatform.business_inspect.activity.SelectOneCheckUpActivity;
import com.hy.powerplatform.business_inspect.adapter.CheckUpSpinnerAdapter;
import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.bean.CheckUp;
import com.hy.powerplatform.business_inspect.bean.Matter;
import com.hy.powerplatform.business_inspect.presenter.CarCodePresenter;
import com.hy.powerplatform.business_inspect.presenter.CheckUpPresenter;
import com.hy.powerplatform.business_inspect.presenter.MatterPresenter;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CarCodePresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.CheckUpPresenterimpl;
import com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl.MatterPresenterimpl;
import com.hy.powerplatform.business_inspect.utils.GetDataThread;
import com.hy.powerplatform.business_inspect.view.CarCodeView;
import com.hy.powerplatform.business_inspect.view.CheckUpView;
import com.hy.powerplatform.business_inspect.view.MatterView;
import com.hy.powerplatform.database.DbManager;
import com.hy.powerplatform.database.MyDatabaseHelper;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.EditTextChange;
import com.hy.powerplatform.my_utils.utils.HttpURLConnectionCallBackListener;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.Util;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.select_photo.ImagesSelectorActivity;
import com.hy.powerplatform.select_photo.SelectorSettings;

import org.apache.http.entity.StringEntity;
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

import static android.R.attr.scaleHeight;
import static android.R.attr.scaleWidth;
import static android.app.Activity.RESULT_OK;
import static android.widget.Toast.makeText;

/**
 * Created by dell on 2018/6/15.
 */

public class YeWuInFragment extends Fragment implements CarCodeView, CheckUpView
        , MatterView, CheckUpSpinnerAdapter.GetItemTextViewPosition {
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
    ListView listView;
    @BindView(R.id.etInspectRemarks)
    EditText etInspectRemarks;
    @BindView(R.id.btn)
    Button btn;

    Intent intent;
    Cursor cursor;
    SQLiteDatabase db;
    MyDatabaseHelper helper;
    String carName, carNameId, checkUpName, checkUpId, userName;
    CarCodePresenter carCodePresenter;
    CheckUpPresenter checkUpPresenter;
    MatterPresenter matterPresenter;
    SharedPreferencesHelper sharecPreferencesHelper;
    List<CarCode.DataBean> listCarCode = new ArrayList<>();
    //判断数据库是否有车牌号信息
    List<CarCode.DataBean> listCarCodeTest = new ArrayList<>();
    List<CheckUp.DataBean> dataBeanList = new ArrayList<>();
    List<CheckUp.DataBean> dataBeanListTest = new ArrayList<>();
    //检查项
    List<Matter.ResultBean> matterList = new ArrayList<>();
    //检查选择
    List<String> typeList = new ArrayList<>();
    @BindView(R.id.imageview)
    ImageView imageview;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    private ArrayList<String> mResults = new ArrayList<>();//图片list
    private ArrayList<String> photoPath = new ArrayList<>();//图片地址

    List<Map<String, String>> imageList = new ArrayList<>();
    List<Map<String, String>> imageList1 = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    ImageView imageView1, imageView2;
    CheckUpSpinnerAdapter adapter;
    RelativeLayout llImageView;
    int position;
    File tmpDir;
    boolean num = false;
    private View view;

    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";
    String url = BASE_URL+"starkh/mobileSaveWeishengJc.do";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_yewuin, container, false);
        ButterKnife.bind(this, view);
        sharecPreferencesHelper = new SharedPreferencesHelper(getActivity(), "login");
        userName = sharecPreferencesHelper.getData(getActivity(), "userStatus", "");
        helper = DbManager.getInstance(MyApplication.getContextObject());
        db = helper.getReadableDatabase();
        //设置Edittext
        new EditTextChange(etSelectCar).changeText();
        new EditTextChange(etSelectClean).changeText();
        new EditTextChange(etSelectWork).changeText();
        new EditTextChange(etInspectRemarks).changeText();
        carCodePresenter = new CarCodePresenterimpl(this, getActivity());
        checkUpPresenter = new CheckUpPresenterimpl(this, getActivity());
        matterPresenter = new MatterPresenterimpl(this, getActivity());
        matterPresenter.getMatterPresenterData();
        //判断数据库是否有车牌号信息
        decideDbForCarCodeData();
        //判断数据库是否有洗车人信息
        decideDbForCheckUpData();
        initDatePicker();
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageview.setVisibility(View.GONE);
            }
        });
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
        customDatePicker1 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
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

        customDatePicker2 = new CustomDatePickerDay(getActivity(), new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                tvTime.setText(time);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        customDatePicker2.showSpecificTime(true);
        customDatePicker2.setIsLoop(true);
    }

    @OnClick({R.id.tvTime, R.id.imCarSelect, R.id.imCleanSelect, R.id.imWorkSelect, R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTime:
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.imCarSelect:
                String etText = etSelectCar.getText().toString().trim();
                intent = new Intent(getActivity(), SelectOneCarActivity.class);
                intent.putExtra("condition", etText);
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.imCleanSelect:
                String etText1 = etSelectClean.getText().toString().trim();
                intent = new Intent(getActivity(), SelectOneCheckUpActivity.class);
                intent.putExtra("condition", etText1);
                startActivityForResult(intent, Constant.TAG_THERE);
                break;
            case R.id.imWorkSelect:
                break;
            case R.id.btn:
                judgeTimeAndSend();
                if (photoPath.size()!=0){
                    String url = BASE_URL+"starkh/upLoadImageWeishengJc.do";
                    upLoadFile(url, photoPath, new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Looper.prepare();
                            makeText(getActivity(), "上传失败", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            makeText(getActivity(), response.body().string(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                String carNo = etSelectCar.getText().toString();
                String CheckUp = etSelectClean.getText().toString();
                JSONObject jsonObject = new JSONObject();
                //Map<String, String> params = new HashMap<String, String>();
                if (carNo.isEmpty()) {
                    makeText(getActivity(), "请选择车辆", Toast.LENGTH_SHORT).show();
                } else if (CheckUp.isEmpty()) {
                    makeText(getActivity(), "请选择检查人", Toast.LENGTH_SHORT).show();
                } else {
                    StringEntity entity = null;
                    for (int i = 0; i < matterList.size(); i++) {
                        View itemView = getViewByPosition(i, listView);
                       // RadioButton rbY = (RadioButton) itemView.findViewById(R.id.rbY);
//                        if (rbY.isChecked()) {
//                            typeList.add("√");
//                        } else {
//                            typeList.add("x");
//                        }
                    }
                    try {
                        jsonObject.put("busCode", carNameId);
                        jsonObject.put("carNo", carName);
                        jsonObject.put("xcgCode", checkUpId);
                        jsonObject.put("xcgName", checkUpName);
                        jsonObject.put("jcrName", userName);
                        jsonObject.put("jcDate", tvTime.getText().toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < matterList.size(); j++) {
                        try {
                            jsonObject.put(matterList.get(j).getProjectName(), typeList.get(j));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.put(jsonObject);
                    Log.i("XXX", jsonArray.toString());
                    url = url + "?data=" + URLEncoder.encode(String.valueOf(jsonArray));
                    ProgressDialogUtil.startLoad(getActivity(), Constant.UPDATA);
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
                                message.what = Constant.TAG_ONE;
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
                break;
        }
    }

    /**
     * 根据url，发送异步Post请求
     * @param url 提交到服务器的地址
     * @param fileNames 完整的上传的文件的路径名
     * @param callback OkHttp的回调接口
     */
    public static void upLoadFile(String url, List<String> fileNames, Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(getRequest(url,fileNames)) ;
        call.enqueue(callback);
    }

    /**
     * 获得Request实例
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

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Bundle b = msg.getData();
                    String msg1 = b.getString("msg");
                    makeText(getActivity(), msg1, Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    etSelectClean.setText("");
                    etSelectCar.setText("");
                    break;
                case Constant.TAG_TWO:
                    makeText(getActivity(), "上传失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

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
            makeText(getActivity(), "请选择正确时间", Toast.LENGTH_SHORT).show();
        }
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
     * 判断数据库是否有检查人信息
     */
    private void decideDbForCheckUpData() {
        //查询数据
        String sqlR = "select * from checkUp order by random() limit '" + 10 + "'";// order by random() limit 100
        cursor = DbManager.queryBySQL(db, sqlR, null);
        dataBeanListTest = DbManager.cursorToCheckUp(cursor);
        if (dataBeanListTest.size() != 0) {
        } else {
            checkUpPresenter.getCheckUpPresenterData();
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
     * 检查人回调
     *
     * @param checkUp
     */
    @Override
    public void getCheckUpViewData(CheckUp checkUp) {
        GetDataThread.saveCheckUpData(checkUp, db, helper, dataBeanList);
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
        }
        adapter = new CheckUpSpinnerAdapter(getActivity(), matterList);
        adapter.setItemPosition(this);
        //listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);
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
                if (mResults.size() == 1) {
                    llImageView.setVisibility(View.VISIBLE);
                    final Bitmap cbitmap01 = BitmapFactory.decodeFile(mResults.get(0), opts);
                    imageView1.setImageBitmap(cbitmap01);
                    //图片存储到本地
                    saveImageToSD(mResults, "temp");
                    setHeight();
                    imageView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Matrix matrix = new Matrix();
                            matrix.postScale(scaleWidth, scaleHeight);
                            imageview.setVisibility(View.VISIBLE);
                            imageview.setImageBitmap(cbitmap01);
                            num = false;

                        }
                    });
                }
                if (mResults.size() == 2) {
                    llImageView.setVisibility(View.VISIBLE);
                    final Bitmap cbitmap01 = BitmapFactory.decodeFile(mResults.get(0), opts);
                    final Bitmap cbitmap02 = BitmapFactory.decodeFile(mResults.get(1), opts);
                    imageView1.setImageBitmap(cbitmap01);
                    imageView2.setImageBitmap(cbitmap02);
                    //图片存储到本地
                    saveImageToSD(mResults, "temp");
                    imageView1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Matrix matrix = new Matrix();
                            matrix.postScale(scaleWidth, scaleHeight);
                            imageview.setVisibility(View.VISIBLE);
                            imageview.setImageBitmap(cbitmap01);
                            num = false;

                        }
                    });
                    imageView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Matrix matrix = new Matrix();
                            matrix.postScale(scaleWidth, scaleHeight);
                            imageview.setVisibility(View.VISIBLE);
                            imageview.setImageBitmap(cbitmap02);
                            num = false;

                        }
                    });
                    setHeight();
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
                    etSelectClean.setText(checkUpName);
                }
                break;
        }
    }

    /**
     * 图片保存到本地
     *
     * @param dirPath
     */
    private void saveImageToSD(ArrayList<String> mResults, String dirPath) {
        //新建文件夹用于存放裁剪后的图片
        tmpDir = new File(Environment.getExternalStorageDirectory() + "/" + dirPath);
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }
        for (int i = 0; i < mResults.size(); i++) {
            Bitmap cbitmap = BitmapFactory.decodeFile(mResults.get(i));
            //新建文件存储裁剪后的图片
            File img = new File(tmpDir.getAbsolutePath() + "/" + String.valueOf(position) + String.valueOf(i) + ".png");
            try {
                //打开文件输出流
                FileOutputStream fos = new FileOutputStream(img);
                //将bitmap压缩后写入输出流(参数依次为图片格式、图片质量和输出流)
                cbitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
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
            map.put(String.valueOf(position), String.valueOf(position)+ String.valueOf(i) + ".png");
            photoPath.add(String.valueOf(position)+ String.valueOf(i) + ".png");
            imageList.add(map);
        }

    }

    /**
     * 解决ScrollView嵌套ListView只显示一条的问题
     *
     * @param listView
     */
    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() *
                (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
        listView.invalidate();
    }

    /**
     * 通过位置找到ListView中的某个item的View
     *
     * @param pos
     * @param listView
     * @return
     */
    public View getViewByPosition(int pos, ListView listView) {
        int firstListItemPosition = listView.getFirstVisiblePosition();
        int lastListItemPosition = firstListItemPosition
                + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }

//    @Override
//    public void getItemPosition(int position) {
//        this.position = position;
//        LinearLayout layout = (LinearLayout) listView.getChildAt(position);
//        imageView1 = (ImageView) layout.findViewById(R.id.imageView1);
//        imageView2 = (ImageView) layout.findViewById(R.id.imageView2);
//       // llImageView = (RelativeLayout) layout.findViewById(R.id.llImageView);
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
//                || ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//
//            ActivityCompat.requestPermissions(getActivity(),
//                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
//                    TAG_ONE);
//        } else {
//            Intent intent = new Intent(getActivity(), ImagesSelectorActivity.class);
//            intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 2);
//            intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 100000);
//            intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
//            startActivityForResult(intent, TAG_ONE);
//        }
//    }

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
                    intent.putExtra(SelectorSettings.SELECTOR_MAX_IMAGE_NUMBER, 2);
                    intent.putExtra(SelectorSettings.SELECTOR_MIN_IMAGE_SIZE, 100000);
                    intent.putExtra(SelectorSettings.SELECTOR_SHOW_CAMERA, true);
                    startActivityForResult(intent, Constant.TAG_ONE);
                } else {
                    makeText(getActivity(), "权限被拒绝，请手动开启", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void setHeight() {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1)) + 120;
        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10);
        listView.setLayoutParams(params);
    }

    @Override
    public void getItemPosition(int position, String tag) {

    }
}

