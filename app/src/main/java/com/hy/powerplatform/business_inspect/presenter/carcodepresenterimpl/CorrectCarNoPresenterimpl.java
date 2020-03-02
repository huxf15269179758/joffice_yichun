package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.model.CorrelatCarNoModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.CorrelatCarNoModelimpl;
import com.hy.powerplatform.business_inspect.presenter.CorrelatCarNoPresenter;
import com.hy.powerplatform.business_inspect.view.CorrelatCarNoView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class CorrectCarNoPresenterimpl implements CorrelatCarNoPresenter {

    Context context;
    CorrelatCarNoModel correlatCarNoModel;
    CorrelatCarNoView correlatCarNoView;

    public CorrectCarNoPresenterimpl(CorrelatCarNoView correlatCarNoView, Context context){
        this.context = context;
        this.correlatCarNoView = correlatCarNoView;
        correlatCarNoModel = new CorrelatCarNoModelimpl();
    }

    @Override
    public void getCorrelatCarNoPresenterData(String lineCode, String rq) {
        correlatCarNoModel.getCorrelatCarNoModelData(Constant.GETDATA, lineCode,rq,context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                correlatCarNoView.getCorrelatCarNoViewData((CarCode) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
