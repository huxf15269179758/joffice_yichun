package com.hy.powerplatform.car_maintain.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.BaoXiuType;
import com.hy.powerplatform.car_maintain.model.BaoXiuTypeModel;
import com.hy.powerplatform.car_maintain.model.modelimpl.BaoXiuTypeModelImpl;
import com.hy.powerplatform.car_maintain.presenter.BaoXiuTypePresenter;
import com.hy.powerplatform.car_maintain.view.BaoXiuTypeView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class BaoXiuTypePresenterImpl implements BaoXiuTypePresenter {
    private BaoXiuTypeModel baoXiuTypeModel;
    private Context context;
    private BaoXiuTypeView baoXiuTypeView;

    //构造方法
    public BaoXiuTypePresenterImpl(BaoXiuTypeView baoXiuTypeView, Context context){
        this.context = context;
        this.baoXiuTypeView = baoXiuTypeView;
        baoXiuTypeModel = new BaoXiuTypeModelImpl();
    }

    @Override
    public void getBaoXiuTypePresenter() {
        baoXiuTypeModel.getBaoXiuTypeModel(Constant.LOGIN_HTTP_TAG, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                baoXiuTypeView.getBaoXiuTypeView((BaoXiuType) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
