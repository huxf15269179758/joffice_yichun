package com.hy.powerplatform.car_maintain.model;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;


/**
 * Created by dell on 2017/8/2.
 */

public interface MainTainListModel {
    void getMainTainListModel(String httpTag, String startTime, String endTime, String type, Context context, BaseModeBackLisenter baseModeBackLisenter);
}
