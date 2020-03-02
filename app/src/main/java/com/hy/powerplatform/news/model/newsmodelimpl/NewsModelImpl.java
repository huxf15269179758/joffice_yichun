package com.hy.powerplatform.news.model.newsmodelimpl;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;
import com.hy.powerplatform.news.bean.News;
import com.hy.powerplatform.news.model.NewsModel;


/**
 * Created by dell on 2017/8/2.
 */

public class NewsModelImpl implements NewsModel {

    @Override
    public void getNewsModelData(String httpTag,  String type, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).news(type)
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<News>() {
                    @Override
                    public void success(News news) {
                        baseModeBackLisenter.success(news);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
