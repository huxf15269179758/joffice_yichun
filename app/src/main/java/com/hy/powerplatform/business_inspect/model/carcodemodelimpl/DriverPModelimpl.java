package com.hy.powerplatform.business_inspect.model.carcodemodelimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.DriverP;
import com.hy.powerplatform.business_inspect.model.DriverPModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;

/**
 * Created by dell on 2018/5/8.
 */

public class DriverPModelimpl implements DriverPModel{

    @Override
    public void getDriverPModelData(String httpTag, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getDriverP()
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<DriverP>() {
                    @Override
                    public void success(DriverP driverP) {
                        baseModeBackLisenter.success(driverP);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
