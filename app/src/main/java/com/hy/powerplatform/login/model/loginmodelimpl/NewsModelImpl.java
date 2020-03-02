package com.hy.powerplatform.login.model.loginmodelimpl;

import android.content.Context;

import com.hy.powerplatform.login.bean.News;
import com.hy.powerplatform.login.model.NewsModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;


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
