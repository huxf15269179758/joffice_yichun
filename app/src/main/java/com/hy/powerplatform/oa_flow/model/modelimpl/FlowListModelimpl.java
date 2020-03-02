package com.hy.powerplatform.oa_flow.model.modelimpl;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.BaseRequestBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.my_utils.base.MySubscriberbean;
import com.hy.powerplatform.my_utils.base.RetrofitService;
import com.hy.powerplatform.my_utils.utils.HttpUtilsTest;
import com.hy.powerplatform.oa_flow.bean.FlowList;
import com.hy.powerplatform.oa_flow.model.FlowListModel;

/**
 * Created by dell on 2018/6/5.
 */

public class FlowListModelimpl implements FlowListModel {

    @Override
    public void getFlowList(String httpTag, String size, String page, String id, Context context,
                            final BaseModeBackLisenter baseModeBackLisenter) {
        HttpUtilsTest.initlist(HttpUtilsTest.getService(RetrofitService.class).getFlowListData(size,page,id)
                ,new MySubscriberbean(httpTag,context, Constant.LOGIN, new BaseRequestBackLisenter<FlowList>() {
                    @Override
                    public void success(FlowList flowList) {
                        baseModeBackLisenter.success(flowList);
                    }

                    @Override
                    public void fail(String message) {
                        baseModeBackLisenter.error(message);
                    }
                }));
    }
}
