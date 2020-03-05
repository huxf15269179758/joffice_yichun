package com.hy.powerplatform.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.myViews.StatusBarUtils;

public class FirstActivity extends AppCompatActivity {
    SharedPreferencesHelper sharedPreferencesHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        sharedPreferencesHelper = new SharedPreferencesHelper(this, "login");
//        sharedPreferencesHelper.saveData(this,"Ip","58.17.74.135");
//        sharedPreferencesHelper.saveData(this,"Socket","6770");
//        sharedPreferencesHelper.saveData(this,"Found","joffice");
//        sharedPreferencesHelper.saveData(this,"Address","宜春");

//测试
        sharedPreferencesHelper.saveData(this,"Ip","58.17.74.135");
        sharedPreferencesHelper.saveData(this,"Socket","6775");
        sharedPreferencesHelper.saveData(this,"Found","joffice");
        sharedPreferencesHelper.saveData(this,"Address","宜春");

//        sharedPreferencesHelper.saveData(this, "Ip", "192.168.2.132");
//        sharedPreferencesHelper.saveData(this, "Socket", "8080");
//        sharedPreferencesHelper.saveData(this, "Found", "joffice");
//        sharedPreferencesHelper.saveData(this, "Address", "宜春");

//        sharedPreferencesHelper.saveData(this, "Ip", "192.168.3.150");
//        sharedPreferencesHelper.saveData(this, "Socket", "9999");
//        sharedPreferencesHelper.saveData(this, "Found", "joffice");
//        sharedPreferencesHelper.saveData(this, "Address", "宜春");
        new StatusBarUtils().setWindowStatusBarColor(FirstActivity.this, R.color.white);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                //你需要跳转的地方的代码
                Intent intent=new Intent(FirstActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000); //延迟2秒跳转
    }
}
