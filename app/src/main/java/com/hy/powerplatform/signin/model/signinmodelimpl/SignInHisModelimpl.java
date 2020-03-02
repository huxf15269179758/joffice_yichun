package com.hy.powerplatform.signin.model.signinmodelimpl;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;
import com.hy.powerplatform.signin.bean.SignHis;
import com.hy.powerplatform.signin.model.SignInHisModel;

/**
 * Created by dell on 2018/5/8.
 */

public class SignInHisModelimpl implements SignInHisModel {

    @Override
    public void getSignInHisModelData(String httpTag, String beginDate, String endDate, String userCode, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).SignInHis(beginDate,endDate,userCode)
                ,new MySubscriberbean(httpTag,context, Constant.UPDATA, new BaseRequestBackLisenter<SignHis>() {
                    @Override
                    public void success(SignHis signHis) {
                        baseModeBackLisenter.success(signHis);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
