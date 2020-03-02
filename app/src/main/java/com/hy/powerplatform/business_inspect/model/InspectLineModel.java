package com.hy.powerplatform.business_inspect.model;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;

/**
 * Created by dell on 2018/5/8.
 */

public interface InspectLineModel {
    void getInspectLineModelData(String httpTag, Context context, BaseModeBackLisenter baseModeBackLisenter);
}
