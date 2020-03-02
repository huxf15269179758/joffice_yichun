package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.model.CarCodeModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.CarCodeModelimpl;
import com.hy.powerplatform.business_inspect.presenter.CarCodePresenter;
import com.hy.powerplatform.business_inspect.view.CarCodeView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class CarCodePresenterimpl implements CarCodePresenter {

    Context context;
    CarCodeModel carCodeModel;
    CarCodeView carCodeView;

    public CarCodePresenterimpl(CarCodeView carCodeView,Context context){
        this.context = context;
        this.carCodeView = carCodeView;
        carCodeModel = new CarCodeModelimpl();
    }

    @Override
    public void getCarCodePresenterData() {
        carCodeModel.getCarCodeModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                carCodeView.getCarCodeViewData((CarCode) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
