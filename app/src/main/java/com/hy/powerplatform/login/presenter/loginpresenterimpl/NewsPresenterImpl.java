package com.hy.powerplatform.login.presenter.loginpresenterimpl;

import android.content.Context;

import com.hy.powerplatform.login.bean.News;
import com.hy.powerplatform.login.model.NewsModel;
import com.hy.powerplatform.login.model.loginmodelimpl.NewsModelImpl;
import com.hy.powerplatform.login.presenter.NewsPresenter;
import com.hy.powerplatform.login.view.NewsView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class NewsPresenterImpl implements NewsPresenter {
    private NewsModel newsModel;
    private Context context;
    private NewsView newsView;

    //构造方法
    public NewsPresenterImpl(NewsView newsView, Context context){
        this.context=context;
        this.newsView=newsView;
        newsModel=new NewsModelImpl();
    }


    @Override
    public void getNewsPresenterData(String type) {
        newsModel.getNewsModelData(Constant.LOGIN_HTTP_TAG, type, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                newsView.getNewsData((News) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
