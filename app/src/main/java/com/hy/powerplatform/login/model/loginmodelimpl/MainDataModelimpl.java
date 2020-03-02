package com.hy.powerplatform.login.model.loginmodelimpl;

import android.content.Context;

import com.hy.powerplatform.login.bean.MainData;
import com.hy.powerplatform.login.model.MainDataModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;

/**
 * Created by dell on 2018/6/5.
 */

public class MainDataModelimpl implements MainDataModel {

    @Override
    public void getMainDataModelData(String httpTag, String userName, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getMainData(userName)
                ,new MySubscriberbean(httpTag,context, Constant.LOGIN, new BaseRequestBackLisenter<MainData>() {
                    @Override
                    public void success(MainData mainData) {
                        baseModeBackLisenter.success(mainData);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
