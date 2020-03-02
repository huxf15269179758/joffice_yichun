package com.hy.powerplatform.signin.model;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;

/**
 * Created by dell on 2018/5/8.
 */

public interface SignInHisModel {
    void getSignInHisModelData(String httpTag, String beginDate, String endDate, String userCode,
                               Context context, BaseModeBackLisenter baseModeBackLisenter);
}
