package com.hy.powerplatform.weekly;

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
import com.hy.powerplatform.business_inspect.utils.DBHandler;
import com.hy.powerplatform.my_utils.base.AlertDialogCallBackP;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.MyAlertDialog;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.oa_flow.bean.Filed;
import com.hy.powerplatform.oa_flow.util.MyStringSpilt;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_ONE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class WeekDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.llData)
    LinearLayout llData;
    @BindView(R.id.webView)
    WebView webView;

    String data;
    String dataId;
    String downloadData;
    @BindView(R.id.tvUser)
    TextView tvUser;
    @BindView(R.id.tvDep)
    TextView tvDep;
    @BindView(R.id.llUser)
    LinearLayout llUser;
    @BindView(R.id.llDep)
    LinearLayout llDep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        WeeklyList bean = (WeeklyList) intent.getSerializableExtra("bean");
        data = bean.getFileName();
        dataId = bean.getFileId();
        if (bean.getFileName().equals("")) {
            llData.setVisibility(View.GONE);
        } else {
            tvData.setText(data);
        }
        tvTime.setText(bean.getDayTime());
        tvStartTime.setText(bean.getStartDate());
        tvEndTime.setText(bean.getEndDate());
        String userName = bean.getUserName().toString();
        if (!userName.equals("")) {
            tvUser.setText(userName);
        }else {
            llUser.setVisibility(View.GONE);
        }
        String dep = bean.getDepName().toString();
        if (!dep.equals("")) {
            tvDep.setText(dep);
        }else {
            llDep.setVisibility(View.GONE);
        }
        //加载url
        webView.loadDataWithBaseURL(null, bean.getContent(), "text/html", "utf-8", null);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
        //不使用缓存，只从网络获取数据.
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        //支持屏幕缩放
        webSettings.setSupportZoom(true);
        webSettings.setTextZoom(200);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_week_detail;
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
        List<String> dataList = new ArrayList<>();
        List<String> dataIdList = new ArrayList<>();
        if (!data.equals("")) {
            dataList = new MyStringSpilt().stringSpiltList(data);
            dataIdList = new MyStringSpilt().stringSpiltList(dataId);
            if (dataList.size() == 1) {
                String id = dataIdList.get(0);
                final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DBHandler dbA = new DBHandler();
                        downloadData = dbA.OAQingJiaMyDetail(url);
                        if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                            handler.sendEmptyMessage(TAG_ONE);
                        } else {
                            handler.sendEmptyMessage(TAG_TWO);
                        }
                    }
                }).start();
            } else if (dataList.size() > 1) {
                final List<String> finalDataList = dataList;
                final List<String> finalDataIdList = dataIdList;
                MyAlertDialog.MyListAlertDialog(this, dataList, new AlertDialogCallBackP() {
                    @Override
                    public void oneselect(final String data1) {
                        String id = "";
                        for (int i = 0; i < finalDataList.size(); i++) {
                            if (finalDataList.get(i).equals(data1)) {
                                id = finalDataIdList.get(i);
                            }
                        }
//                        String id = new MyStringSpilt().stringSpilt(data1);
                        final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + id;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                DBHandler dbA = new DBHandler();
                                downloadData = dbA.OAQingJiaMyDetail(url);
                                if (downloadData.equals("获取数据失败") || downloadData.equals("")) {
                                    handler.sendEmptyMessage(TAG_ONE);
                                } else {
                                    handler.sendEmptyMessage(TAG_TWO);
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
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    Toast.makeText(WeekDetailActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
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
