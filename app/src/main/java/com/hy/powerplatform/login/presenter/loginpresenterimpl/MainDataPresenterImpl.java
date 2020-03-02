package com.hy.powerplatform.login.presenter.loginpresenterimpl;

import android.content.Context;

import com.hy.powerplatform.login.bean.MainData;
import com.hy.powerplatform.login.model.MainDataModel;
import com.hy.powerplatform.login.model.loginmodelimpl.MainDataModelimpl;
import com.hy.powerplatform.login.presenter.MainDataPresenter;
import com.hy.powerplatform.login.view.MainView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class MainDataPresenterImpl implements MainDataPresenter {
    private MainDataModel mainDataModel;
    private Context context;
    private MainView mainView;

    //构造方法
    public MainDataPresenterImpl(MainView mainView, Context context){
        this.context = context;
        this.mainView = mainView;
        mainDataModel = new MainDataModelimpl();
    }

    @Override
    public void getMainDataPresenterData(String userName) {
        mainDataModel.getMainDataModelData(Constant.GETDATA, userName, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                mainView.getMainViewData((MainData) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
