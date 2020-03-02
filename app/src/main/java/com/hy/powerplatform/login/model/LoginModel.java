package com.hy.powerplatform.login.model;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;


/**
 * Created by dell on 2017/8/2.
 */

public interface LoginModel {
    void getLoginModelData(String httpTag, String username, String password, Context context, BaseModeBackLisenter baseModeBackLisenter);
}
