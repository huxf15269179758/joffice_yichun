package com.hy.powerplatform.business_inspect.model.carcodemodelimpl;

import android.content.Context;

import com.hy.powerplatform.business_inspect.bean.InspectStarte;
import com.hy.powerplatform.business_inspect.model.InspectStarteModel;
import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;

/**
 * Created by dell on 2018/5/8.
 */

public class InspectStarteModelimpl implements InspectStarteModel {
    @Override
    public void getInspectStarteModelData(String httpTag, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).inspectStarte()
                ,new MySubscriberbean(httpTag,context, Constant.GETDATA, new BaseRequestBackLisenter<InspectStarte>() {
                    @Override
                    public void success(InspectStarte inspectStarte) {
                        baseModeBackLisenter.success(inspectStarte);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
