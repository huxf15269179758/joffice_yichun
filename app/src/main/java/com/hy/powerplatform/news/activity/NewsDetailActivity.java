package com.hy.powerplatform.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Patterns;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.myViews.RichTextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NewsDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvContent)
    RichTextView tvContent;
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.tvContent0)
    RichTextView tvContent0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String heard = intent.getStringExtra("heard");
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        String time = intent.getStringExtra("time");
        String section = intent.getStringExtra("section");
        header.setTvTitle(heard);
        tvTitle.setText(title);
        tvTime.setText(time);
        tvDepartment.setText(section);
        tvContent0.setText(Html.fromHtml(content));

        webView.getSettings().setLoadWithOverviewMode(true);
        //字体大小
        webView.getSettings().setTextSize(WebSettings.TextSize.LARGEST);
        //缩放开关
        webView.getSettings().setSupportZoom(true);
        // 设置是否可缩放
        webView.getSettings().setBuiltInZoomControls(true);
        //无限缩放
        webView.getSettings().setUseWideViewPort(true);
        if (Patterns.WEB_URL.matcher(tvContent0.getText().toString()).matches() || URLUtil.isValidUrl(tvContent0.getText().toString())) {
            webView.loadUrl(tvContent0.getText().toString());
            //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    // TODO Auto-generated method stub
                    //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                    view.loadUrl(url);
                    return true;
                }
            });
        } else {
            tvContent.setText(Html.fromHtml(content));
        }
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_newsdetail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
