package com.hy.powerplatform.car_maintain.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.WeiXiuChang;
import com.hy.powerplatform.car_maintain.model.WeiXiuChangModel;
import com.hy.powerplatform.car_maintain.model.modelimpl.WeiXiuChangModelImpl;
import com.hy.powerplatform.car_maintain.presenter.WeiXiuChangPresenter;
import com.hy.powerplatform.car_maintain.view.WeiXiuChangView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class WeiXiuChangPresenterImpl implements WeiXiuChangPresenter {
    private WeiXiuChangModel weiXiuChangModel;
    private Context context;
    private WeiXiuChangView weiXiuChangView;

    //构造方法
    public WeiXiuChangPresenterImpl(WeiXiuChangView weiXiuChangView, Context context){
        this.context = context;
        this.weiXiuChangView = weiXiuChangView;
        weiXiuChangModel = new WeiXiuChangModelImpl();
    }

    @Override
    public void getWeiXiuChangPresenter() {
        weiXiuChangModel.getWeiXiuChangModel(Constant.LOGIN_HTTP_TAG, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                weiXiuChangView.getWeiXiuChangView((WeiXiuChang) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
