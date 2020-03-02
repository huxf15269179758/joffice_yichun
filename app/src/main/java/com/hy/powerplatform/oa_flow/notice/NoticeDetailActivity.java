package com.hy.powerplatform.oa_flow.notice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.OkHttpUtil;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.bean.Filed;
import com.hy.powerplatform.oa_flow.notice.bean.NoticeList;
import com.hy.powerplatform.oa_flow.util.MyStringSpilt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;
import okhttp3.Response;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_NINE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class NoticeDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvAuthor)
    TextView tvAuthor;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.llData)
    LinearLayout llData;

    String newId = "";
    String fileId = "";
    String downloadData = "";
    private OkHttpUtil httpUtil;
    final HashMap<String, String> map = new HashMap();
    List<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        NoticeList bean = (NoticeList) getIntent().getSerializableExtra("bean");
        tvTitle.setText(bean.getTitle());
        tvAuthor.setText(bean.getAuthor());
        tvTime.setText(bean.getCreatetime());
        tvEndTime.setText(bean.getEndtime());
        String data= bean.getFileName();
        if (bean.getFileName().equals("")){
            llData.setVisibility(View.GONE);
        }else {
            if (!data.substring(data.length()-1,data.length()).equals(",")){
                tvData.setText(bean.getFileName());
            }else {
                tvData.setText(bean.getFileName().substring(0,bean.getFileName().length()-1));
            }
        }
        fileId = bean.fileId;
        newId = bean.newsId;
        String content = bean.getContent();
        //加载html
        webView.loadDataWithBaseURL(null, content, "text/html", "UTF-8", null);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
        //不使用缓存，只从网络获取数据.
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        //支持屏幕缩放
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        webSettings.setTextZoom(260);
        httpUtil = OkHttpUtil.getInstance(this);
        String userId= new SharedPreferencesHelper(this,"login").getData(this,"userId","");
        getData(newId, userId);
    }

    private void getData(String newId, String userId) {
        ProgressDialogUtil.startLoad(this, getResources().getString(R.string.get_data));
        final String path_url = Constant.BASE_URL2 + Constant.NOTICETYPE ;
        map.clear();
        map.put("newsId", newId);
        map.put("userId", userId);
        httpUtil.postForm(path_url, map, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Request request, Exception e) {
//                Log.i("main", "response:" + e.toString());
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("error", e.toString());
                message.setData(b);
                message.what = TAG_ONE;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Response response) throws IOException {
//                Log.i("main", "response:" + response.body().string());
                String data = response.body().string();
                Message message = new Message();
                Bundle b = new Bundle();
                b.putString("data", data);
                message.setData(b);
                message.what = TAG_ONE;
                handler.sendMessage(message);
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_notice_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick(R.id.tvData)
    public void onViewClicked() {
        if (!tvData.getText().toString().equals("")) {
            dataList = new MyStringSpilt().stringSpiltList(tvData.getText().toString());
            if (dataList.size() == 1) {
                String id = new MyStringSpilt().stringSpilt1(fileId);
                final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DBHandler dbA = new DBHandler();
                        downloadData = dbA.OAQingJiaMyDetail(url);
                        if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                            handler.sendEmptyMessage(TAG_TWO);
                        } else {
                            handler.sendEmptyMessage(TAG_NINE);
                        }
                    }
                }).start();
            } else if (dataList.size() > 1) {
                MyAlertDialog.MyListAlertDialog(this, dataList, new AlertDialogCallBackP() {
                    @Override
                    public void oneselect(final String data1) {
                        String id = "";
                        List<String> idList = new ArrayList<>();
                        idList = new MyStringSpilt().stringSpiltList(fileId);
                        for (int i = 0;i<dataList.size();i++){
                            if (dataList.get(i).equals(data1)){
                                id = idList.get(i);
                            }
                        }
                        final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                DBHandler dbA = new DBHandler();
                                downloadData = dbA.OAQingJiaMyDetail(url);
                                if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                                    handler.sendEmptyMessage(TAG_TWO);
                                } else {
                                    handler.sendEmptyMessage(TAG_NINE);
                                }
                            }
                        }).start();
                    }

                    @Override
                    public void select(List<String> list) {

                    }

                    @Override
                    public void confirm() {

                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        }else {
            llData.setVisibility(View.GONE);
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(NoticeDetailActivity.this, "操作数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_NINE:
                    Gson gson2 = new Gson();
                    Filed filed = gson2.fromJson(downloadData, Filed.class);
                    String filePath = filed.getData().getFilePath();
                    String url = Constant.FIELDETAIL + filePath;
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                    break;
            }
        }
    };
}
