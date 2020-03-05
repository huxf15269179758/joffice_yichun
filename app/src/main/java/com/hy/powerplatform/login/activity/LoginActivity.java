package com.hy.powerplatform.login.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.login.bean.Login;
import com.hy.powerplatform.login.presenter.LoginPresenter;
import com.hy.powerplatform.login.presenter.loginpresenterimpl.LoginPresenterImpl;
import com.hy.powerplatform.login.view.LoginView;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.AlertDialogUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.btn_FitWindow)
    Button btnFitWindow;
    @BindView(R.id.et_LoginName)
    EditText etLoginName;
    @BindView(R.id.et_LoginPassword)
    EditText etLoginPassword;
    @BindView(R.id.btn_Login)
    Button btnLogin;
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvHeard)
    TextView tvHeard;

    AlertDialogUtil alertDialogUtil;
    SharedPreferencesHelper sharedPreferencesHelper;
    LoginPresenter loginPresenter;
    private static boolean isExit = false;
    String userName, userName1, userPassword, userPassword1, cid;
    String access;
    Intent intent;

    //推出程序
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.activity_login)
    LinearLayout activityLogin;

    ConnectivityManager mConnectivityManager;
    NetworkInfo mNetworkInfo  ;

    //推出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
//            alertDialogUtil.showDialog1("您确定要退出程序吗", new AlertDialogCallBack() {
//                @Override
//                public void select(String data) {
//
//                }
//
//                @Override
//                public void confirm() {
//                    finish();
//                }
//
//                @Override
//                public void cancel() {
//
//                }
//            });
            Toast.makeText(this, "再点一次退出程序", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        etLoginName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeScrollView();
                return false;
            }
        });
        etLoginPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeScrollView();
                return false;
            }
        });
        //密码隐藏
        etLoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
        alertDialogUtil = new AlertDialogUtil(this);
        sharedPreferencesHelper = new SharedPreferencesHelper(this, "login");
        loginPresenter = new LoginPresenterImpl(this, this);
        userName = sharedPreferencesHelper.getData(this, "userName", "");
        userPassword = sharedPreferencesHelper.getData(this, "userPwd", "");
        cid = sharedPreferencesHelper.getData(this, "cid", "");
        Log.i("loginXXX", cid);
        if (!userName.isEmpty()) {
//            intent = new Intent(LoginActivity.this, .class);
//            startActivity(intent);
//            finish();
            etLoginName.setText(userName);
        }
        if (!userPassword.isEmpty()) {
            etLoginPassword.setText(userPassword);
        }
    }

    /**
     * 100毫秒之后使ScrollView指向底部
     */
    private void changeScrollView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, scrollView.getHeight());
            }
        }, 100);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean isHasHeader() {
        return false;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.btn_FitWindow, R.id.btn_Login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_FitWindow:
                intent = new Intent(LoginActivity.this, FitWindowActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_Login:
                mConnectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
                mNetworkInfo  = mConnectivityManager.getActiveNetworkInfo();
                userName1 = etLoginName.getText().toString().trim();
                userPassword1 = etLoginPassword.getText().toString().trim();
                String Ip = sharedPreferencesHelper.getData(this, "Ip", "");
                String Socket = sharedPreferencesHelper.getData(this, "Socket", "");
                String Found = sharedPreferencesHelper.getData(this, "Found", "");
                if (Ip.equals("") && Socket.equals("")) {
                    Toast.makeText(this, getResources().getString(R.string.toast_infor), Toast.LENGTH_SHORT).show();
                    break;
                } else if (userName1.equals("") && userPassword1.equals("")) {
                    alertDialogUtil.showSmallDialog(getResources().getString(R.string.toast_login_infor));
                    break;
                } else if(mNetworkInfo == null){
                    Toast.makeText(this, "请检查网络", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    //final String url1 = "http://"+Ip+":"+Socket+"/"+Found+"/"+"mobile.do"+"?username="+userName1+"&password="+userPassword1;
                    String url1 = null;
                    try {
                        url1 = Constant.BASE_URL2 + "mobile.do" + "?username=" + URLEncoder.encode(userName1, "utf-8") + "&password=" + userPassword1 + "&clientid=" + cid;
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    showLoading(Constant.LOGIN);
                    final String finalUrl = url1;
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            HttpURLConnection connection = null;
                            BufferedReader reader = null;
                            try {
                                URL url = new URL(finalUrl);
                                connection = (HttpURLConnection) url.openConnection();
                                connection.setRequestMethod("GET");
                                connection.setReadTimeout(200000);
                                connection.setConnectTimeout(200000);
//                                connection.setRequestProperty("Content-type", "application/json;charset=UTF-8");
//                                connection.setRequestProperty("Accept", "application/json");
//                                connection.setRequestProperty("Charset", "UTF-8");
                                InputStream in = connection.getInputStream();
                                reader = new BufferedReader(new InputStreamReader(in));
                                StringBuilder builder = new StringBuilder();
                                String line;
                                int responseCode = connection.getResponseCode();
                                if (200 == responseCode) {
                                    while ((line = reader.readLine()) != null) {
                                        builder.append(line);
                                    }
                                    JSONObject jsonObject = new JSONObject(builder.toString());
                                    if (jsonObject.get("success").equals(true)) {
//                                        sharedPreferencesHelper.saveData(LoginActivity.this, "userName", userName1);
//                                        sharedPreferencesHelper.saveData(LoginActivity.this, "userId", jsonObject.getString("userId"));
//                                        sharedPreferencesHelper.saveData(LoginActivity.this, "userStatus", jsonObject.getString("username"));
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "userName", userName1);
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "userPwd", userPassword1);
                                        String cookieString = connection.getHeaderField("Set-Cookie");
                                        cookieString = cookieString.substring(0, cookieString.indexOf(";"));
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "session", cookieString);
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "userCode", jsonObject.getString("userCode"));
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "userStatus", jsonObject.getString("username"));
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "userId", jsonObject.getString("userId"));
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "rolues", jsonObject.getString("rolues"));
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "rights", jsonObject.getString("rights"));
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "roleName", jsonObject.getString("roleName"));
                                        String superRoleName = jsonObject.getString("superRoleName");
                                        if (jsonObject.getString("superRoleName") != null) {
                                            sharedPreferencesHelper.saveData(LoginActivity.this, "superRoleName", jsonObject.getString("superRoleName"));
                                        }
                                        if (jsonObject.getString("depName") == null || jsonObject.getString("depName").equals("null") || jsonObject.getString("depName").equals("")) {
                                            sharedPreferencesHelper.saveData(LoginActivity.this, "depName", "宜春公交集团有限公司");
                                            sharedPreferencesHelper.saveData(LoginActivity.this, "depId", "378");
                                        } else {
                                            sharedPreferencesHelper.saveData(LoginActivity.this, "depName", jsonObject.getString("depName"));
                                            sharedPreferencesHelper.saveData(LoginActivity.this, "depId", jsonObject.getString("depId"));
                                        }

                                        JSONObject myJsonObject = jsonObject.getJSONObject("empprofile");
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "myAge", myJsonObject.getString("age"));
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "mySex", myJsonObject.getString("sex"));
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "myMobile", myJsonObject.getString("mobile"));
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "myIcCard", myJsonObject.getString("idCard"));
                                        sharedPreferencesHelper.saveData(LoginActivity.this, "myAddress", myJsonObject.getString("address"));

                                        Message message = new Message();
                                        message.what = Constant.TAG_ONE;
                                        handler.sendMessage(message);
                                    } else {
                                        Looper.prepare();
                                        Toast.makeText(LoginActivity.this, jsonObject.getString("msg"), Toast.LENGTH_SHORT).show();
                                        hideLoading();
                                        Looper.loop();
                                    }
                                    String cookieString = connection.getHeaderField("Set-Cookie");
                                    cookieString = cookieString.substring(0, cookieString.indexOf(";"));
                                    new SharedPreferencesHelper(MyApplication.getContextObject(), "login").saveData(MyApplication.getContextObject(),
                                            "session", cookieString);
                                    Log.e("XXXH", cookieString);
                                }
                            } catch (MalformedURLException e) {
                                Log.i("XXX", e.toString());
                            } catch (IOException e) {
                                Log.i("XXX", e.toString());
                                Message message = new Message();
                                message.what = Constant.TAG_ONE;
                                handler1.sendMessage(message);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } finally {
                                if (reader != null) {
                                    try {
                                        reader.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (connection != null) {
                                    connection.disconnect();
                                }
                            }
                        }
                    }).start();
                }
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            hideLoading();
            intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
//            intent = new Intent(LoginActivity.this, DBActivity.class);
//            startActivity(intent);
            finish();
        }
    };

    private Handler handler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            hideLoading();
            Toast.makeText(LoginActivity.this, "登录异常 请重试", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void getLoginData(Login login) {
        access = String.valueOf(login.isSuccess());
        if (access.equals("true")) {
            sharedPreferencesHelper.saveData(this, "userName", userName1);
            sharedPreferencesHelper.saveData(this, "userPwd", userPassword1);
            sharedPreferencesHelper.saveData(this, "userCode", login.getUserId());
            sharedPreferencesHelper.saveData(this, "userStatus", login.getUsername());
            hideLoading();
            intent = new Intent(LoginActivity.this, SecondActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, login.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }
}
