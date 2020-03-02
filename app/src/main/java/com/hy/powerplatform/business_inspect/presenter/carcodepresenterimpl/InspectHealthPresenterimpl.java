package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.InspectHealth;
import com.hy.powerplatform.business_inspect.model.InspectHealthModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.InspectHealthModelimpl;
import com.hy.powerplatform.business_inspect.presenter.InspectHealthPresenter;
import com.hy.powerplatform.business_inspect.view.InspectHealthView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class InspectHealthPresenterimpl implements InspectHealthPresenter {

    Context context;
    InspectHealthModel inspectHealthModel;
    InspectHealthView inspectHealthView;

    public InspectHealthPresenterimpl(InspectHealthView inspectHealthView, Context context){
        this.context = context;
        this.inspectHealthView = inspectHealthView;
        inspectHealthModel = new InspectHealthModelimpl();
    }

    @Override
    public void getInspectHealthPresenterData() {
        inspectHealthModel.getInspectHealthModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                inspectHealthView.getInspectHealthViewData((InspectHealth) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
