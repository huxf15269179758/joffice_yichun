package com.hy.powerplatform.business_inspect.model.carcodemodelimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.CarCode;
import com.hy.powerplatform.business_inspect.model.CorrelatCarNoModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils3;

/**
 * Created by dell on 2018/5/8.
 */

public class CorrelatCarNoModelimpl implements CorrelatCarNoModel{

    @Override
    public void getCorrelatCarNoModelData(String httpTag, String lineCode, String rq, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils3.initlist(HttpUtils3.getService(RetrofitService.class).getCorrelatCarNo(lineCode,rq)
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<CarCode>() {
                    @Override
                    public void success(CarCode carCode) {
                        baseModeBackLisenter.success(carCode);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
