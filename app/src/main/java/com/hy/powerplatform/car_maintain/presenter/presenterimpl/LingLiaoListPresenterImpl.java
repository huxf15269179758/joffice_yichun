package com.hy.powerplatform.car_maintain.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.LingLiao;
import com.hy.powerplatform.car_maintain.model.LingLiaoModel;
import com.hy.powerplatform.car_maintain.model.modelimpl.LingLiaoModelImpl;
import com.hy.powerplatform.car_maintain.presenter.LingLiaoListPresenter;
import com.hy.powerplatform.car_maintain.view.LingLiaoView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class LingLiaoListPresenterImpl implements LingLiaoListPresenter {
    private LingLiaoModel lingLiaoModel;
    private Context context;
    private LingLiaoView lingLiaoView;

    //构造方法
    public LingLiaoListPresenterImpl(LingLiaoView lingLiaoView, Context context){
        this.context = context;
        this.lingLiaoView = lingLiaoView;
        lingLiaoModel = new LingLiaoModelImpl();
    }

    @Override
    public void getLingLiaoListPresenter(String startTime, String endTime,String type) {
        lingLiaoModel.getLingLiaoModel(Constant.LOGIN_HTTP_TAG,startTime,endTime , type, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                lingLiaoView.getLingLiaoView((LingLiao) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
