package com.hy.powerplatform.car_maintain.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.MainTainList;
import com.hy.powerplatform.car_maintain.model.MainTainListModel;
import com.hy.powerplatform.car_maintain.model.modelimpl.MainTainListModelImpl;
import com.hy.powerplatform.car_maintain.presenter.MainTainListPresenter;
import com.hy.powerplatform.car_maintain.view.MainTainListView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class MainTainListPresenterImpl implements MainTainListPresenter {
    private MainTainListModel mainTainListModel;
    private Context context;
    private MainTainListView mainTainListView;

    //构造方法
    public MainTainListPresenterImpl(MainTainListView mainTainListView, Context context){
        this.context = context;
        this.mainTainListView = mainTainListView;
        mainTainListModel = new MainTainListModelImpl();
    }

    @Override
    public void getMainTainListPresenter(String startTime, String endTime,String type) {
        mainTainListModel.getMainTainListModel(Constant.LOGIN_HTTP_TAG,startTime,endTime ,type , context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                mainTainListView.getMainTainListView((MainTainList) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
