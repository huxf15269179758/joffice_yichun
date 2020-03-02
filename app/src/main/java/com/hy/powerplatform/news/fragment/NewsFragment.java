package com.hy.powerplatform.news.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hy.powerplatform.R;
import com.hy.powerplatform.SharedPreferencesHelper;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MyApplication;
import com.hy.powerplatform.my_utils.utils.HttpURLConnectionCallBackListener;
import com.hy.powerplatform.my_utils.utils.ProgressDialogUtil;
import com.hy.powerplatform.my_utils.utils.Util;
import com.hy.powerplatform.news.adapter.NewsAndNoticeAdapter;
import com.hy.powerplatform.news.bean.ShowNews;
import com.hy.powerplatform.news.presenter.NewsPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dell on 2017/8/1.
 */

public class NewsFragment extends Fragment  {
    @BindView(R.id.pullLoadMoreRecyclerView)
    RecyclerView pullLoadMoreRecyclerView;
    NewsAndNoticeAdapter adapter;
    NewsPresenter newsPresenter;
    Unbinder unbinder;
    @BindView(R.id.imageView)
    LinearLayout imageView;
    private View view;

    SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MyApplication.getContextObject(),"login");
    String found = sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Found","");
    String BASE_URL="http://"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Ip","")
            +":"+sharedPreferencesHelper.getData(MyApplication.getContextObject(),"Socket","")+"/"+found+"/";
    String url = BASE_URL+"htmobile/listNews.do?Q_isNotice_SN_EQ=0";
    List<ShowNews> beanList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getContextObject());
        pullLoadMoreRecyclerView.setLayoutManager(manager);
        ProgressDialogUtil.startLoad(getActivity(),Constant.GETDATA);
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
                        beanList.add(showNews);
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
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (beanList.size() == 0) {
                pullLoadMoreRecyclerView.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
            }else {
                adapter = new NewsAndNoticeAdapter(beanList);
                pullLoadMoreRecyclerView.setAdapter(adapter);
            }
            ProgressDialogUtil.stopLoad();
        }
    };
}
