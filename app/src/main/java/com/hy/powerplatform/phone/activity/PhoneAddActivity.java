package com.hy.powerplatform.phone.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hy.powerplatform.R;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.myViews.EditTextChange;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.time_select.CustomDatePickerDay;
import com.hy.powerplatform.phone.fragment.ItemsDialogFragment;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneAddActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.tvChengW)
    TextView tvChengW;
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.tvLib)
    TextView tvLib;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.ivSelectChengW)
    ImageView ivSelectChengW;
    @BindView(R.id.ivSelectLib)
    ImageView ivSelectLib;

    public static final String TAG = "PersonListActivity";
    private CustomDatePickerDay customDatePicker1, customDatePicker2;
    private static HashMap<String, String> CookieContiner = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        new EditTextChange(etName).changeText();
        new EditTextChange(etPhone).changeText();
        //选择时间
        initDatePicker();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_phone_add;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.tvChengW, R.id.tvLib, R.id.btn,R.id.ivSelectChengW, R.id.ivSelectLib})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvChengW:
                showItemsDialogFragment();
                break;
            case R.id.tvLib:
                customDatePicker1.show(tvLib.getText().toString());
                break;
            case R.id.ivSelectChengW:
                showItemsDialogFragment();
                break;
            case R.id.ivSelectLib:
                customDatePicker1.show(tvLib.getText().toString());
                break;
            case R.id.btn:
                final String strUrlPath = "http://221.195.69.109:7080/joffice/htmobile/saveAddressBook.do";
//                final Map<String, String> params = new HashMap<String, String>();
//                try {
//                    params.put("fullname", String.valueOf(etName.getText().toString().getBytes("UTF-8")));
//                    params.put("title", String.valueOf(tvChengW.getText().toString().getBytes("UTF-8")));
//                    params.put("mobile", String.valueOf(etPhone.getText().toString().getBytes("UTF-8")));
//                    params.put("birthday", String.valueOf(tvLib.getText().toString().getBytes("UTF-8")));
//                    params.put("email", String.valueOf("1526617@163.com".getBytes("UTF-8")));
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//                final String strUrlPath = "http://221.195.69.109:7080/joffice/htmobile/saveAddressBook.do";
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        String strResult= Util.submitPostData(strUrlPath,params, "utf-8");
//                        Log.i("XXX",strResult);
//                        Looper.prepare();
//                        Toast.makeText(PhoneAddActivity.this, strResult, Toast.LENGTH_SHORT).show();
//                        Looper.loop();
//                    }
//                }).start();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        DefaultHttpClient httpclient = new DefaultHttpClient();
                        HttpGet httpget = new HttpGet("http://221.195.69.109:7080/joffice/mobile.do?username=admin&password=adminhycz");
                        HttpResponse response = null;
                        try {
                            response = httpclient.execute(httpget);
                            HttpEntity entity = response.getEntity();
                            List<Cookie> cookies = httpclient.getCookieStore().getCookies();
                            if (entity != null) {
                                entity.consumeContent();
                            }
                            if (cookies.isEmpty()) {
                                Log.i(TAG, "NONE");
                            } else {
                                for (int i = 0; i < cookies.size(); i++) {
                                    Log.i(TAG, "- domain " + cookies.get(i).getDomain());
                                    Log.i(TAG, "- path " + cookies.get(i).getPath());
                                    Log.i(TAG, "- value " + cookies.get(i).getValue());
                                    Log.i(TAG, "- name " + cookies.get(i).getName());
                                    Log.i(TAG, "- port " + cookies.get(i).getPorts());
                                    Log.i(TAG, "- comment " + cookies.get(i).getComment());
                                    Log.i(TAG, "- commenturl" + cookies.get(i).getCommentURL());
                                    Log.i(TAG, "- all " + cookies.get(i).toString());
                                }
                            }
                            httpclient.getConnectionManager().shutdown();

                            org.apache.http.Header[] headers = response.getHeaders("Set-Cookie");
                            String headerstr = headers.toString();
                            if (headers == null)
                                return;
                            for (int i = 0; i < headers.length; i++) {
                                String cookie = headers[i].getValue();
                                String[] cookievalues = cookie.split(";");
                                for (int j = 0; j < cookievalues.length; j++) {
                                    String[] keyPair = cookievalues[j].split("=");
                                    String key = keyPair[0].trim();
                                    String value = keyPair.length > 1 ? keyPair[1].trim() : "";
                                    CookieContiner.put(key, value);
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        HttpPost httpPost = new HttpPost("http://221.195.69.109:7080/joffice/htmobile/addPeople.do?isOut=0");
                        StringBuilder sb = new StringBuilder();
                        Iterator iter = CookieContiner.entrySet().iterator();
                        while (iter.hasNext()) {
                            Map.Entry entry = (Map.Entry) iter.next();
                            String key = entry.getKey().toString();
                            String val = entry.getValue().toString();
                            sb.append(key);
                            sb.append("=");
                            sb.append(val);
                            sb.append(";");
                        }
                        httpPost.addHeader("cookie", sb.toString());
                        try {
                            HttpEntity entity = new StringEntity(sb.toString(), "UTF-8");
                            httpPost.setEntity(entity);
                            DefaultHttpClient httpclientPost = new DefaultHttpClient();
                            HttpResponse responsePost = httpclientPost.execute(httpPost);
                            HttpEntity entityPost = responsePost.getEntity();
                            Log.i("XXX",entityPost.toString());
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        } catch (ClientProtocolException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
//                Util.getDataByPost(strUrlPath,etName.getText().toString(),tvChengW.getText().toString()
//                ,etPhone.getText().toString(),tvLib.getText().toString(),"151@163.com", new HttpURLConnectionCallBackListener() {
//                            @Override
//                            public void onSuccess(String s) {
//                                Log.i("XXX",s);
//                            }
//
//                            @Override
//                            public void onFaile(Exception e) {
//
//                            }
//                        });
                break;
        }
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvLib.setText(now.split(" ")[0]);
        //currentTime.setText(now);

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvLib.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvLib.setText(time);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(true); // 显示时和分
        customDatePicker2.setIsLoop(true); // 允许循环滚动
    }

    public void showItemsDialogFragment() {
        ItemsDialogFragment itemsDialogFragment = new ItemsDialogFragment();
        final String[] items = {"先生", "女士"};
        itemsDialogFragment.show("", items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tvChengW.setText(items[which]);
            }
        }, getFragmentManager());
    }
}
