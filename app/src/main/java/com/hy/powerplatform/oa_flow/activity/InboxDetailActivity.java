package com.hy.powerplatform.oa_flow.activity;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.hy.powerplatform.my_utils.base.Constant.TAG_NINE;
import static com.hy.powerplatform.my_utils.base.Constant.TAG_TWO;

public class InboxDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.webView)
    WebView webView;
    int width;
    private String fujianData;
    @BindView(R.id.tvfujian)
    TextView tvfujian;
    @BindView(R.id.llfujian)
    LinearLayout llfujian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String content = intent.getStringExtra("content");
        String person = intent.getStringExtra("person");
        String time = intent.getStringExtra("time");
        final String title = intent.getStringExtra("title");
        final String fujian = intent.getStringExtra("fijian");
        final String fujianId = intent.getStringExtra("fijianId");
        if (fujian.equals("")){
            llfujian.setVisibility(View.GONE);
        }else {
            tvfujian.setText(fujian);
        }

        tvfujian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final List<String> dataList = new MyStringSpilt().stringSpiltList(fujianId);
                final List<String> dataList1 = new MyStringSpilt().stringSpiltList(fujian);
                if (dataList.size() == 1) {
                    String newString = fujianId.toString().replace(",","");
                    final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + newString;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            DBHandler dbA = new DBHandler();
                            fujianData = dbA.OAQingJiaMyDetail(url);
                            if (fujianData.equals("获取数据失败") || fujianData.equals("")) {
                                handler.sendEmptyMessage(TAG_TWO);
                            } else {
                                handler.sendEmptyMessage(TAG_NINE);
                            }
                        }
                    }).start();
                } else if (dataList.size() > 1) {
                    MyAlertDialog.MyListAlertDialog(InboxDetailActivity.this, dataList1, new AlertDialogCallBackP() {
                        @Override
                        public void oneselect(final String data1) {
                            String selectId = "";
                            for (int i = 0;i<dataList1.size();i++){
                                if (data1.equals(dataList1.get(i))){
                                    selectId = dataList.get(i);
                                }
                            }
                            final String url = Constant.BASE_URL2 + Constant.FILEDATA + "?fileId=" + selectId;
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    DBHandler dbA = new DBHandler();
                                    fujianData = dbA.OAQingJiaMyDetail(url);
                                    if (fujianData.equals("获取数据失败") || fujianData.equals("")) {
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
            }
        });

        tvTitle.setText(title);
        tvTime.setText(time);
        tvPerson.setText(person);

        //支持javascript
        webView.getSettings().setJavaScriptEnabled(true);
        // 设置可以支持缩放
        webView.getSettings().setSupportZoom(false);
        // 设置出现缩放工具
        webView.getSettings().setBuiltInZoomControls(false);
        //扩大比例的缩放
        webView.getSettings().setUseWideViewPort(true);
        //自适应屏幕
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setTextSize(WebSettings.TextSize.LARGEST);

        Display display = getWindowManager().getDefaultDisplay();
        // 方法一(推荐使用)使用Point来保存屏幕宽、高两个数据
        Point outSize = new Point();
        // 通过Display对象获取屏幕宽、高数据并保存到Point对象中
        display.getSize(outSize);
        // 从Point对象中获取宽、高
        width = outSize.x;
        int y = outSize.y;
        webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ProgressDialogUtil.stopLoad();
            }
        }, 1000);
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            imgReset();//重置webview中img标签的图片大小
            // html加载完成之后，添加监听图片的点击js函数
            //addImageClickListner();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    /**
     * 对图片进行重置大小，宽度就是手机屏幕宽度，高度根据宽度比便自动缩放
     **/
    private void imgReset() {
        webView.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName('img'); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "var img = objs[i];   " +
                "    img.style.maxWidth = '100%'; img.style.height = 'auto'; img.style.width = +" + width * 2 + "+'px';  " +
                "}" +
                "})()");
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_inbox_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_TWO:
                    Toast.makeText(InboxDetailActivity.this, "获取数据失败，请重试", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_NINE:
                    Gson gson2 = new Gson();
                    Filed filed = gson2.fromJson(fujianData, Filed.class);
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
