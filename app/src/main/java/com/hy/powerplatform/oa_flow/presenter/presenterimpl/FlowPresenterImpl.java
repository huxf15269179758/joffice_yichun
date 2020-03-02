package com.hy.powerplatform.oa_flow.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.oa_flow.bean.FlowItem;
import com.hy.powerplatform.oa_flow.model.FlowModel;
import com.hy.powerplatform.oa_flow.model.modelimpl.FlowModelimpl;
import com.hy.powerplatform.oa_flow.presenter.FlowPresenter;
import com.hy.powerplatform.oa_flow.view.FlowView;

/**
 * Created by dell on 2017/8/2.
 */

public class FlowPresenterImpl implements FlowPresenter {
    private FlowModel flowModel;
    private Context context;
    private FlowView flowView;

    //构造方法
    public FlowPresenterImpl(FlowView flowView, Context context){
        this.context = context;
        this.flowView = flowView;
        flowModel = new FlowModelimpl();
    }

    @Override
    public void getFlowPresenter(String userName) {
        flowModel.getFlowModel(Constant.GETDATA, userName, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                flowView.getFlowView((FlowItem) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
