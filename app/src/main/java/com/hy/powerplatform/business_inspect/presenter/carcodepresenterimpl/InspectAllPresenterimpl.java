package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.InspectAll;
import com.hy.powerplatform.business_inspect.model.InspectAllModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.InspectAllModelimpl;
import com.hy.powerplatform.business_inspect.presenter.InspectAllPresenter;
import com.hy.powerplatform.business_inspect.view.InspectAllView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class InspectAllPresenterimpl implements InspectAllPresenter {

    Context context;
    InspectAllModel inspectAllModel;
    InspectAllView inspectAllView;

    public InspectAllPresenterimpl(InspectAllView inspectAllView, Context context){
        this.context = context;
        this.inspectAllView = inspectAllView;
        inspectAllModel = new InspectAllModelimpl();
    }

    @Override
    public void getInspectAllPresenterData() {
        inspectAllModel.getInspectAllModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                inspectAllView.getInspectAllViewData((InspectAll) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
