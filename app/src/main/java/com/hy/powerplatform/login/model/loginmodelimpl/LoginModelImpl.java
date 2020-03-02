package com.hy.powerplatform.login.model.loginmodelimpl;

import android.content.Context;

import com.hy.powerplatform.login.bean.Login;
import com.hy.powerplatform.login.model.LoginModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;


/**
 * Created by dell on 2017/8/2.
 */

public class LoginModelImpl implements LoginModel {

    @Override
    public void getLoginModelData(String httpTag, String username, String password, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).lgoin(username, password)
                ,new MySubscriberbean(httpTag,context, Constant.LOGIN, new BaseRequestBackLisenter<Login>() {
                    @Override
                    public void success(Login user) {
                        baseModeBackLisenter.success(user);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
