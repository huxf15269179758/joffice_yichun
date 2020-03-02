package com.hy.powerplatform.business_inspect.presenter.carcodepresenterimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.YeWuList;
import com.hy.powerplatform.business_inspect.model.YeWuModel;
import com.hy.powerplatform.business_inspect.model.carcodemodelimpl.YeWuListModelimpl;
import com.hy.powerplatform.business_inspect.presenter.YeWuListPresenter;
import com.hy.powerplatform.business_inspect.view.YeWuListView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2018/5/8.
 */

public class YeWuListPresenterimpl implements YeWuListPresenter {

    Context context;
    YeWuModel yeWuModel;
    YeWuListView yeWuListView;

    public YeWuListPresenterimpl(YeWuListView yeWuListView, Context context){
        this.context = context;
        this.yeWuListView = yeWuListView;
        yeWuModel = new YeWuListModelimpl();
    }

    @Override
    public void getYeWuListPresenterData(String beginDate, String endDate, String operCode) {
        yeWuModel.getYeWuModelData(Constant.GETDATA,beginDate,endDate,operCode, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                yeWuListView.getYeWuListViewData((YeWuList) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
