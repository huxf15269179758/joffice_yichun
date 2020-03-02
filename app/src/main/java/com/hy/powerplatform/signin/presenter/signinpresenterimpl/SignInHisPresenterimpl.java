package com.hy.powerplatform.signin.presenter.signinpresenterimpl;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.signin.bean.SignHis;
import com.hy.powerplatform.signin.model.SignInHisModel;
import com.hy.powerplatform.signin.model.signinmodelimpl.SignInHisModelimpl;
import com.hy.powerplatform.signin.presenter.SignInHisPresenter;
import com.hy.powerplatform.signin.view.SignInHisView;

/**
 * Created by dell on 2018/5/8.
 */

public class SignInHisPresenterimpl implements SignInHisPresenter {

    private SignInHisModel signInHisModel;
    private Context context;
    private SignInHisView signInHisView;

    //构造方法
    public SignInHisPresenterimpl(SignInHisView signInhisView, Context context){
        this.context = context;
        this.signInHisView = signInhisView;
        signInHisModel = new SignInHisModelimpl();
    }

    @Override
    public void getSignInHisPresenterData(String bedinDate, String endDate, String userCode) {
        signInHisModel.getSignInHisModelData(Constant.UPRESULT,bedinDate,endDate,userCode,context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                signInHisView.getSignInHisData((SignHis) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
