package com.hy.powerplatform.oa_flow.model;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;

/**
 * Created by dell on 2018/6/5.
 */

public interface FlowModel {
    void getFlowModel(String httpTag, String userName, Context context, BaseModeBackLisenter baseModeBackLisenter);
}
