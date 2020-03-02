package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.ShiGuHis;
import com.hy.powerplatform.business_inspect.model.HisModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.HisModelimpl;
import com.hy.powerplatform.business_inspect.presenter.HisPresenter;
import com.hy.powerplatform.business_inspect.view.HisView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class HisPresenterimpl implements HisPresenter {

    Context context;
    HisModel hisModel;
    HisView hisView;

    public HisPresenterimpl(HisView hisView, Context context){
        this.context = context;
        this.hisView = hisView;
        hisModel = new HisModelimpl();
    }

    @Override
    public void getHisPresenterData(String starTime, String endTime, String userCode) {
        hisModel.getHisModelData(Constant.GETDATA,starTime,endTime,userCode, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                hisView.getHisViewData((ShiGuHis) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
