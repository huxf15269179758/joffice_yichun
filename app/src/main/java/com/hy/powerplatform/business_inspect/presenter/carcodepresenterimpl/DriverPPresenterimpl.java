package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.DriverP;
import com.hy.powerplatform.business_inspect.model.DriverPModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.DriverPModelimpl;
import com.hy.powerplatform.business_inspect.presenter.DriverPPresenter;
import com.hy.powerplatform.business_inspect.view.DriverPView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class DriverPPresenterimpl implements DriverPPresenter {

    Context context;
    DriverPModel driverPModel;
    DriverPView driverPView;

    public DriverPPresenterimpl(DriverPView driverPView, Context context){
        this.context = context;
        this.driverPView = driverPView;
        driverPModel = new DriverPModelimpl();
    }


    @Override
    public void getDriverPPresenterData() {
        driverPModel.getDriverPModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                driverPView.getDriverPViewData((DriverP) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
