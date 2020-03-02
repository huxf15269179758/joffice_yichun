package com.hy.powerplatform.car_maintain.model.modelimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.JianChaRen;
import com.hy.powerplatform.car_maintain.model.JianChaRenModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;


/**
 * Created by dell on 2017/8/2.
 */

public class JianChaRenModelImpl implements JianChaRenModel {

    @Override
    public void getJianChaRenModel(String httpTag, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getJianChaRen()
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<JianChaRen>() {
                    @Override
                    public void success(JianChaRen jianChaRen) {
                        baseModeBackLisenter.success(jianChaRen);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
