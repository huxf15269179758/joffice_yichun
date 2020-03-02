package com.hy.powerplatform.duban.model;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;

/**
 * Created by dell on 2018/5/8.
 */

public interface DBCheckPersonModel {
    void getCheckPersonModelData(String httpTag, Context context, BaseModeBackLisenter baseModeBackLisenter);
}
