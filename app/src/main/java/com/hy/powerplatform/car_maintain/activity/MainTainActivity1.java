package com.hy.powerplatform.car_maintain.activity;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hy.powerplatform.AndroidForJs;
import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.Header;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainTainActivity1 extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.webView)
    WebView webView;
    private ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> uploadMessage;
    public static final int REQUEST_SELECT_FILE = 100;
    private final static int FILECHOOSER_RESULTCODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        //设置编码
        webView.getSettings().setDefaultTextEncodingName("utf-8");
        //支持js
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {});
        webView.setWebViewClient(new WebViewClient());//限制在WebView中打开网页，而不用默认浏览器
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
        //本地地址
//        String tpl = getFromAssets("file:///android_asset/muiH/view/first-page.html");
        String Ip = new SharedPreferencesHelper(MainTainActivity1.this,"login").getData(this, "Ip", "");
        String Socket = new SharedPreferencesHelper(MainTainActivity1.this,"login").getData(this, "Socket", "");
        final String url = "http://"+Ip+":"+Socket+"/";
        String url1 = "http://220.178.249.25:7083/";
//        webView.loadUrl("http://192.168.2.96:8020/muiH/index.html");
        webView.loadUrl(url+"muiH/index.html");
//        webView.loadUrl(url+"muiH/view/first-page.html");
        webView.addJavascriptInterface(new AndroidForJs(this),"AndroidView");
    }
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main_pai_dan;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
