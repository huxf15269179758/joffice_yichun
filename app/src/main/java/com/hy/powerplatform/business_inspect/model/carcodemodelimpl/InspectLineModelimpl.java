package com.hy.powerplatform.business_inspect.model.carcodemodelimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.InspectLine;
import com.hy.powerplatform.business_inspect.model.InspectLineModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;

/**
 * Created by dell on 2018/5/8.
 */

public class InspectLineModelimpl implements InspectLineModel{

    @Override
    public void getInspectLineModelData(String httpTag, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).inspectLine()
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<InspectLine>() {
                    @Override
                    public void success(InspectLine inspectLine) {
                        baseModeBackLisenter.success(inspectLine);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
