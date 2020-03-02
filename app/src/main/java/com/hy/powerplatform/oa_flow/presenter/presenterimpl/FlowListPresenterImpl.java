package com.hy.powerplatform.oa_flow.presenter.presenterimpl;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;
import com.hy.powerplatform.my_utils.base.Constant;
import com.hy.powerplatform.oa_flow.bean.FlowList;
import com.hy.powerplatform.oa_flow.model.FlowListModel;
import com.hy.powerplatform.oa_flow.model.modelimpl.FlowListModelimpl;
import com.hy.powerplatform.oa_flow.presenter.FlowListPresenter;
import com.hy.powerplatform.oa_flow.view.FlowListView;

/**
 * Created by dell on 2017/8/2.
 */

public class FlowListPresenterImpl implements FlowListPresenter {
    private FlowListModel flowListModel;
    private Context context;
    private FlowListView flowListView;

    //构造方法
    public FlowListPresenterImpl(FlowListView flowListView, Context context){
        this.context = context;
        this.flowListView = flowListView;
        flowListModel = new FlowListModelimpl();
    }

    @Override
    public void getFlowListPresenter(String size, String page, String userName) {
        flowListModel.getFlowList(Constant.GETDATA, size, page, userName, context, new BaseModeBackLisenter() {
            @Override
            public void success(Object o) {
                flowListView.getFlowList((FlowList) o);
            }

            @Override
            public void error(String errorMessage) {

            }
        });
    }
}
