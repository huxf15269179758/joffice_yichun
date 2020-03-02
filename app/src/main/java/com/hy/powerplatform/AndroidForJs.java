package com.hy.powerplatform;

import android.content.Context;
import android.webkit.JavascriptInterface;

import com.hy.powerplatform.my_utils.base.MyApplication;

/**
 * Created by Administrator on 2018/11/1.
 */

public class AndroidForJs extends Object{

    private Context context;

    public AndroidForJs(Context context) {
        this.context = context;
    }

    //api17以后，只有public且添加了 @JavascriptInterface 注解的方法才能被调用
    @JavascriptInterface
    public String  showToast() {
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
        String Ip = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","");
        String Port = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","");
        String Found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
        return "Http://"+Ip+":"+Port+"/"+Found+"/";
    }
}
