package com.hy.powerplatform.news.presenter.newspresenterimpl;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.news.bean.News;
import com.hy.powerplatform.news.model.NewsModel;
import com.hy.powerplatform.news.model.newsmodelimpl.NewsModelImpl;
import com.hy.powerplatform.news.presenter.NewsPresenter;
import com.hy.powerplatform.news.view.NewsView;

/**
 * Created by dell on 2017/8/2.
 */

public class NewsPresenterImpl implements NewsPresenter {
    private NewsModel newsModel;
    private Context context;
    private NewsView newsView;

    //构造方法
    public NewsPresenterImpl(NewsView newsView, Context context){
        this.context = context;
        this.newsView = newsView;
        newsModel = new NewsModelImpl();
    }


    @Override
    public void getNewsPresenterData(String type) {
        newsModel.getNewsModelData(Constant.LOGIN_HTTP_TAG, type, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                newsView.getNewsViewData((News) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
