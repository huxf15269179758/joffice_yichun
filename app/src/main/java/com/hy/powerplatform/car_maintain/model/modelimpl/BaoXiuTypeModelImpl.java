package com.hy.powerplatform.car_maintain.model.modelimpl;

import android.content.Context;

import com.hy.powerplatform.car_maintain.bean.BaoXiuType;
import com.hy.powerplatform.car_maintain.model.BaoXiuTypeModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;


/**
 * Created by dell on 2017/8/2.
 */

public class BaoXiuTypeModelImpl implements BaoXiuTypeModel {

    @Override
    public void getBaoXiuTypeModel(String httpTag, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getBaoXiuType()
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<BaoXiuType>() {
                    @Override
                    public void success(BaoXiuType baoXiuType) {
                        baseModeBackLisenter.success(baoXiuType);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
