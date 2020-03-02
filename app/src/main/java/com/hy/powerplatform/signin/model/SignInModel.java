package com.hy.powerplatform.signin.model;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;

/**
 * Created by dell on 2018/5/8.
 */

public interface SignInModel {
    void getSignInModelData(String httpTag, String userName, String addr, String rq, String sj, String gps, String photo,
                            Context context, BaseModeBackLisenter baseModeBackLisenter);
}
