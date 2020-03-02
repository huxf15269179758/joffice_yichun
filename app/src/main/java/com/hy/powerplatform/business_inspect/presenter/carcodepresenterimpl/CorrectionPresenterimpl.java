package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.Correlat;
import com.hy.powerplatform.business_inspect.model.CorrelationModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.CorrelationModelimpl;
import com.hy.powerplatform.business_inspect.presenter.CorrelationPresenter;
import com.hy.powerplatform.business_inspect.view.CorrelationView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class CorrectionPresenterimpl implements CorrelationPresenter {

    Context context;
    CorrelationModel correlationModel;
    CorrelationView correlationView;

    public CorrectionPresenterimpl(CorrelationView correlationView, Context context){
        this.context = context;
        this.correlationView = correlationView;
        correlationModel = new CorrelationModelimpl();
    }

    @Override
    public void getCorrelationPresenterData(String busCode, String rq) {
        correlationModel.getCorrelationModelData(Constant.GETDATA, busCode,rq,context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                correlationView.getCorrelationViewData((Correlat) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
