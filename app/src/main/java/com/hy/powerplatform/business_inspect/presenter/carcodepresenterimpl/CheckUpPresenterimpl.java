package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.CheckUp;
import com.hy.powerplatform.business_inspect.model.CheckUpModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.CheckUpModelimpl;
import com.hy.powerplatform.business_inspect.presenter.CheckUpPresenter;
import com.hy.powerplatform.business_inspect.view.CheckUpView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class CheckUpPresenterimpl implements CheckUpPresenter {

    Context context;
    CheckUpModel checkUpModel;
    CheckUpView checkUpView;

    public CheckUpPresenterimpl(CheckUpView checkUpView, Context context){
        this.context = context;
        this.checkUpView = checkUpView;
        checkUpModel = new CheckUpModelimpl();
    }

    @Override
    public void getCheckUpPresenterData() {
        checkUpModel.getCheckUpModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                checkUpView.getCheckUpViewData((CheckUp) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
