package com.hy.powerplatform.car_maintain.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.JianChaRen;
import com.hy.powerplatform.car_maintain.model.JianChaRenModel;
import com.hy.powerplatform.car_maintain.model.modelimpl.JianChaRenModelImpl;
import com.hy.powerplatform.car_maintain.presenter.JianChaRenPresenter;
import com.hy.powerplatform.car_maintain.view.JianChanRenView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class JianChaRenPresenterImpl implements JianChaRenPresenter {
    private JianChaRenModel jianChaRenModel;
    private Context context;
    private JianChanRenView jianChanRenView;

    //构造方法
    public JianChaRenPresenterImpl(JianChanRenView jianChanRenView, Context context){
        this.context = context;
        this.jianChanRenView = jianChanRenView;
        jianChaRenModel = new JianChaRenModelImpl();
    }

    @Override
    public void getJianChaRenPresenter() {
        jianChaRenModel.getJianChaRenModel(Constant.LOGIN_HTTP_TAG, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                jianChanRenView.getJianChanRenViewView((JianChaRen) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
