package com.hy.powerplatform.login.presenter.loginpresenterimpl;

import android.content.Context;

import com.hy.powerplatform.login.bean.Login;
import com.hy.powerplatform.login.model.LoginModel;
import com.hy.powerplatform.login.model.loginmodelimpl.LoginModelImpl;
import com.hy.powerplatform.login.presenter.LoginPresenter;
import com.hy.powerplatform.login.view.LoginView;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;

/**
 * Created by dell on 2017/8/2.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private LoginModel loginModel;
    private Context context;
    private LoginView loginView;

    //构造方法
    public LoginPresenterImpl(LoginView loginView, Context context){
        this.context=context;
        this.loginView=loginView;
        loginModel=new LoginModelImpl();
    }


    @Override
    public void getLoginPresenterData(String username, String passWord) {
        loginModel.getLoginModelData(Constant.LOGIN_HTTP_TAG, username, passWord, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                loginView.getLoginData((Login) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
