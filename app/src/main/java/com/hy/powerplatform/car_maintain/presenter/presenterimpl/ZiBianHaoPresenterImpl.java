package com.hy.powerplatform.car_maintain.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.zhibianhao;
import com.hy.powerplatform.car_maintain.model.ZiBianHaoModel;
import com.hy.powerplatform.car_maintain.model.modelimpl.ZiBianHaoModelImpl;
import com.hy.powerplatform.car_maintain.presenter.ZiBianHaoPresenter;
import com.hy.powerplatform.car_maintain.view.ZiBianHaoView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class ZiBianHaoPresenterImpl implements ZiBianHaoPresenter {
    private ZiBianHaoModel ziBianHaoModel;
    private Context context;
    private ZiBianHaoView ziBianHaoView;

    //构造方法
    public ZiBianHaoPresenterImpl(ZiBianHaoView ziBianHaoView, Context context){
        this.context = context;
        this.ziBianHaoView = ziBianHaoView;
        ziBianHaoModel = new ZiBianHaoModelImpl();
    }

    @Override
    public void getZiBianHaoPresenter() {
        ziBianHaoModel.getZiBianHaoModel(Constant.LOGIN_HTTP_TAG, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                ziBianHaoView.getZiBianHaoView((zhibianhao) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
