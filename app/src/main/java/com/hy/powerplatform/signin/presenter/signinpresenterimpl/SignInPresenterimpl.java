package com.hy.powerplatform.signin.presenter.signinpresenterimpl;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.signin.bean.SignIn;
import com.hy.powerplatform.signin.model.SignInModel;
import com.hy.powerplatform.signin.model.signinmodelimpl.SignInModelimpl;
import com.hy.powerplatform.signin.presenter.SignInPresenter;
import com.hy.powerplatform.signin.view.SignInView;

/**
 * Created by dell on 2018/5/8.
 */

public class SignInPresenterimpl implements SignInPresenter {

    private SignInModel signInModel;
    private Context context;
    private SignInView signInView;

    //构造方法
    public SignInPresenterimpl(SignInView signInView, Context context){
        this.context = context;
        this.signInView = signInView;
        signInModel = new SignInModelimpl();
    }

    @Override
    public void getSignInPresenterData(String userName, String addr, String rq, String sj,String gps, String photo) {
        signInModel.getSignInModelData(Constant.UPRESULT,userName,addr,rq,sj,gps,photo,context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                signInView.getSignInViewData((SignIn) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
