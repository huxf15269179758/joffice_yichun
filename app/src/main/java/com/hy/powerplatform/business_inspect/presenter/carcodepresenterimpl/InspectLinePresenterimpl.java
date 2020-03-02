package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.InspectLine;
import com.hy.powerplatform.business_inspect.model.InspectLineModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.InspectLineModelimpl;
import com.hy.powerplatform.business_inspect.presenter.InspectLinePresenter;
import com.hy.powerplatform.business_inspect.view.InspectLineView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class InspectLinePresenterimpl implements InspectLinePresenter {

    Context context;
    InspectLineModel inspectLineModel;
    InspectLineView inspectLineView;

    public InspectLinePresenterimpl(InspectLineView inspectLineView, Context context){
        this.context = context;
        this.inspectLineView = inspectLineView;
        inspectLineModel = new InspectLineModelimpl();
    }

    @Override
    public void getInspectLinePresenterData() {
        inspectLineModel.getInspectLineModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                inspectLineView.getInspectLineViewData((InspectLine) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
