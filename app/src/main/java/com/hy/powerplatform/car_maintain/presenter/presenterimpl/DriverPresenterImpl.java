package com.hy.powerplatform.car_maintain.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.Driver;
import com.hy.powerplatform.car_maintain.model.DriverModel;
import com.hy.powerplatform.car_maintain.model.modelimpl.DriverModelImpl;
import com.hy.powerplatform.car_maintain.presenter.DriverPresenter;
import com.hy.powerplatform.car_maintain.view.DriverView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class DriverPresenterImpl implements DriverPresenter {
    private DriverModel driverModel;
    private Context context;
    private DriverView driverView;

    //构造方法
    public DriverPresenterImpl(DriverView driverView, Context context){
        this.context = context;
        this.driverView = driverView;
        driverModel = new DriverModelImpl();
    }

    @Override
    public void getDriverPresenter() {
        driverModel.getDriverModel(Constant.LOGIN_HTTP_TAG, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                driverView.getDriverView((Driver) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
