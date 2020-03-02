package com.hy.powerplatform.car_maintain.model.modelimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.WeiXiuChang;
import com.hy.powerplatform.car_maintain.model.WeiXiuChangModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;


/**
 * Created by dell on 2017/8/2.
 */

public class WeiXiuChangModelImpl implements WeiXiuChangModel {

    @Override
    public void getWeiXiuChangModel(String httpTag, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getWeiXiuChang()
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<WeiXiuChang>() {
                    @Override
                    public void success(WeiXiuChang weiXiuChang) {
                        baseModeBackLisenter.success(weiXiuChang);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
