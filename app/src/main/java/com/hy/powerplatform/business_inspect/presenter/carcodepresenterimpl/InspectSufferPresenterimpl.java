package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.InspectSuffeer;
import com.hy.powerplatform.business_inspect.model.InspectSufferModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.InspectSufferModelimpl;
import com.hy.powerplatform.business_inspect.presenter.InspectSufferPresenter;
import com.hy.powerplatform.business_inspect.view.InspectSufferView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class InspectSufferPresenterimpl implements InspectSufferPresenter {

    Context context;
    InspectSufferModel inspectSufferModel;
    InspectSufferView inspectSufferView;

    public InspectSufferPresenterimpl(InspectSufferView inspectSufferView, Context context){
        this.context = context;
        this.inspectSufferView = inspectSufferView;
        inspectSufferModel = new InspectSufferModelimpl();
    }

    @Override
    public void getInspectSufferPresenterData() {
        inspectSufferModel.getInspectSufferModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                inspectSufferView.getInspectSufferViewData((InspectSuffeer) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
