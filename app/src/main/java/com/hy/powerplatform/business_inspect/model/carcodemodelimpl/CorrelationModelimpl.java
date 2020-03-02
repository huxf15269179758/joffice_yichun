package com.hy.powerplatform.business_inspect.model.carcodemodelimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.Correlat;
import com.hy.powerplatform.business_inspect.model.CorrelationModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;

/**
 * Created by dell on 2018/5/8.
 */

public class CorrelationModelimpl implements CorrelationModel{

    @Override
    public void getCorrelationModelData(String httpTag, String busCode, String rq, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getCorrelation(busCode,rq)
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<Correlat>() {
                    @Override
                    public void success(Correlat correlat) {
                        baseModeBackLisenter.success(correlat);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
