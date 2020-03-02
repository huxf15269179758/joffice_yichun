package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.Matter;
import com.hy.powerplatform.business_inspect.model.MatterModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.MatterModelimpl;
import com.hy.powerplatform.business_inspect.presenter.MatterPresenter;
import com.hy.powerplatform.business_inspect.view.MatterView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class MatterPresenterimpl implements MatterPresenter {

    Context context;
    MatterModel matterModel;
    MatterView matterView;

    public MatterPresenterimpl(MatterView matterView, Context context){
        this.context = context;
        this.matterView = matterView;
        matterModel = new MatterModelimpl();
    }

    @Override
    public void getMatterPresenterData() {
        matterModel.getMatterModelData(Constant.GETDATA, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                matterView.getMatterViewData((Matter) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
