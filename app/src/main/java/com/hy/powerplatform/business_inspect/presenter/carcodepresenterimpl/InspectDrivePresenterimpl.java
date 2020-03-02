package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.InspectDrive;
import com.hy.powerplatform.business_inspect.model.InspectDriveModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.InspectDriveModelimpl;
import com.hy.powerplatform.business_inspect.presenter.InspectDrivePresenter;
import com.hy.powerplatform.business_inspect.view.InspectDriveView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class InspectDrivePresenterimpl implements InspectDrivePresenter {

    Context context;
    InspectDriveModel inspectDriveModel;
    InspectDriveView inspectDriveView;

    public InspectDrivePresenterimpl(InspectDriveView inspectDriveView, Context context){
        this.context = context;
        this.inspectDriveView = inspectDriveView;
        inspectDriveModel = new InspectDriveModelimpl();
    }

    @Override
    public void getInspectDrivePresenterData() {
        inspectDriveModel.getInspectDriveModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                inspectDriveView.getInspectDriveViewData((InspectDrive) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
