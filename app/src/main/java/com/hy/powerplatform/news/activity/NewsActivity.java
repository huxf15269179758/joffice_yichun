package com.hy.powerplatform.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.base.BaseActivity;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.myViews.Header;
import com.hy.powerplatform.my_utils.utils.HttpURLConnectionCallBackListener;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.Util;
import com.hy.powerplatform.news.adapter.NewsAndNoticeAdapter;
import com.hy.powerplatform.news.bean.ShowNews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.pullLoadMoreRecyclerView)
    RecyclerView pullLoadMoreRecyclerView;
    @BindView(R.id.imageView)
    LinearLayout imageView;
    @BindView(R.id.activity_notice)
    LinearLayout activityNotice;

    NewsAndNoticeAdapter adapter;
    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";
    String url = BASE_URL+"htmobile/listNews.do?Q_isNotice_SN_EQ=0";
    List<ShowNews> beanListN = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String heard = intent.getStringExtra("heard");
        header.setTvTitle(heard);
        LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
        pullLoadMoreRecyclerView.setLayoutManager(manager);
        getNoticeData();
    }

    private void getNoticeData() {
        ProgressDialogUtil.startLoad(this, Constant.GETDATA);
        Util.getDataByHttpUrlConnection(url, new HttpURLConnectionCallBackListener() {
            @Override
            public void onSuccess(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = jsonObject.getJSONArray("result");
                    for (int i = 0;i<jsonArray.length();i++){
                        ShowNews showNews = new ShowNews();
                        JSONObject jsonObjectBigData = jsonArray.getJSONObject(i);
                        JSONObject jsonObjectsmallData = jsonObjectBigData.getJSONObject("section");
                        showNews.title = jsonObjectBigData.getString("subject");
                        String content = jsonObjectBigData.getString("content");
                        content = content.replace("\n\t","");
                        content = content.replace("\n","");
                        showNews.content = content;
                        showNews.time = jsonObjectBigData.getString("updateTime");
                        showNews.section = jsonObjectsmallData.getString("sectionName");
                        beanListN.add(showNews);
                    }
                    Message message = new Message();
                    message.what = Constant.TAG_ONE;
                    handler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFaile(Exception e) {

            }
        });
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (beanListN.size() == 0) {
                pullLoadMoreRecyclerView.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
            }else {
                adapter = new NewsAndNoticeAdapter(beanListN);
                pullLoadMoreRecyclerView.setAdapter(adapter);
            }
            ProgressDialogUtil.stopLoad();
        }
    };

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_notice;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}

