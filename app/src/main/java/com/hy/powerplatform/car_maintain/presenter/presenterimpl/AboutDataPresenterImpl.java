package com.hy.powerplatform.car_maintain.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.AboutData;
import com.hy.powerplatform.car_maintain.model.AboutDataModel;
import com.hy.powerplatform.car_maintain.model.modelimpl.AboutDataModelImpl;
import com.hy.powerplatform.car_maintain.presenter.AboutDataPresenter;
import com.hy.powerplatform.car_maintain.view.AboutDataView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class AboutDataPresenterImpl implements AboutDataPresenter {
    private AboutDataModel aboutDataModel;
    private Context context;
    private AboutDataView aboutDataView;

    //构造方法
    public AboutDataPresenterImpl(AboutDataView aboutDataView, Context context){
        this.context = context;
        this.aboutDataView = aboutDataView;
        aboutDataModel = new AboutDataModelImpl();
    }

    @Override
    public void getAboutDataPresenter(String busCode) {
        aboutDataModel.getAboutDataModel(Constant.LOGIN_HTTP_TAG,busCode, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                aboutDataView.getAboutDataViewView((AboutData) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
