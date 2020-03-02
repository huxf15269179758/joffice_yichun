package com.hy.powerplatform.car_maintain.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.LingLiaoItem;
import com.hy.powerplatform.car_maintain.model.LingLiaoItemModel;
import com.hy.powerplatform.car_maintain.model.modelimpl.LingLiaoItemModelImpl;
import com.hy.powerplatform.car_maintain.presenter.LingLiaoItemPresenter;
import com.hy.powerplatform.car_maintain.view.LingLiaoItemView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class LingLiaoItemPresenterImpl implements LingLiaoItemPresenter {
    private LingLiaoItemModel lingLiaoItemModel;
    private Context context;
    private LingLiaoItemView lingLiaoItemView;

    //构造方法
    public LingLiaoItemPresenterImpl(LingLiaoItemView lingLiaoItemView, Context context){
        this.context = context;
        this.lingLiaoItemView = lingLiaoItemView;
        lingLiaoItemModel = new LingLiaoItemModelImpl();
    }

    @Override
    public void getLingLiaoItemPresenter(String ziCode) {
        lingLiaoItemModel.getDriverModel(Constant.LOGIN_HTTP_TAG, ziCode, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                lingLiaoItemView.getLingLiaoItemView((LingLiaoItem) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
