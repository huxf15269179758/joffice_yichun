package com.hy.powerplatform.car_maintain.model;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;


/**
 * Created by dell on 2017/8/2.
 */

public interface LineModel {
    void getLineModel(String httpTag, Context context, BaseModeBackLisenter baseModeBackLisenter);
}
