package com.hy.powerplatform.oa_flow.model.modelimpl;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtils;
import com.hy.powerplatform.oa_flow.bean.FlowItem;
import com.hy.powerplatform.oa_flow.model.FlowModel;

/**
 * Created by dell on 2018/6/5.
 */

public class FlowModelimpl implements FlowModel {

    @Override
    public void getFlowModel(String httpTag, String userName, Context context, final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtils.initlist(HttpUtils.getService(RetrofitService.class).getFlowItemData(userName)
                ,new MySubscriberbean(httpTag,context, Constant.LOGIN, new BaseRequestBackLisenter<FlowItem>() {
                    @Override
                    public void success(FlowItem flowItem) {
                        baseModeBackLisenter.success(flowItem);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
