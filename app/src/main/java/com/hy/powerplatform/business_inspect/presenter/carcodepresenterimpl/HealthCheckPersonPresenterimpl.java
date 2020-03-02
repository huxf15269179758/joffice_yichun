package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.CheckPerson;
import com.hy.powerplatform.business_inspect.model.CheckPersonModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.HealthCheckPersonModelimpl;
import com.hy.powerplatform.business_inspect.presenter.CheckPersonPresenter;
import com.hy.powerplatform.business_inspect.view.CheckPersonView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class HealthCheckPersonPresenterimpl implements CheckPersonPresenter {

    Context context;
    CheckPersonModel checkPersonModel;
    CheckPersonView checkPersonView;

    public HealthCheckPersonPresenterimpl(CheckPersonView checkPersonView, Context context){
        this.context = context;
        this.checkPersonView = checkPersonView;
        checkPersonModel = new HealthCheckPersonModelimpl();
    }

    @Override
    public void getCheckPersonPresenterData() {
        checkPersonModel.getCheckPersonModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                checkPersonView.getCheckPersonViewData((CheckPerson) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
