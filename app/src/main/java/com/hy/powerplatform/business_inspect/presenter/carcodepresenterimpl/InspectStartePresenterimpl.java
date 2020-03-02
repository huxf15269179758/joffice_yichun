package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.InspectStarte;
import com.hy.powerplatform.business_inspect.model.InspectStarteModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.InspectStarteModelimpl;
import com.hy.powerplatform.business_inspect.presenter.InspectStartePresenter;
import com.hy.powerplatform.business_inspect.view.InspectStarteView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class InspectStartePresenterimpl implements InspectStartePresenter {

    Context context;
    InspectStarteModel inspectStarteModel;
    InspectStarteView inspectStarteView;

    public InspectStartePresenterimpl(InspectStarteView inspectStarteView, Context context){
        this.context = context;
        this.inspectStarteView = inspectStarteView;
        inspectStarteModel = new InspectStarteModelimpl();
    }

    @Override
    public void getInspectStartePresenterData() {
        inspectStarteModel.getInspectStarteModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                inspectStarteView.getInspectStarteViewData((InspectStarte) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
