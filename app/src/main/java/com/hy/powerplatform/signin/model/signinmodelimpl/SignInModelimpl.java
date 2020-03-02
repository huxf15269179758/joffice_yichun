package com.hy.powerplatform.signin.model.signinmodelimpl;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;
import com.hy.powerplatform.signin.bean.SignIn;
import com.hy.powerplatform.signin.model.SignInModel;

/**
 * Created by dell on 2018/5/8.
 */

public class SignInModelimpl implements SignInModel {

    @Override
    public void getSignInModelData(String httpTag, String userName, String addr, String rq, String sj,String gps, String photo, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).SignIn(userName,addr,rq,sj,gps,photo)
                ,new MySubscriberbean(httpTag,context, Constant.UPDATA, new BaseRequestBackLisenter<SignIn>() {
                    @Override
                    public void success(SignIn signIn) {
                        baseModeBackLisenter.success(signIn);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
