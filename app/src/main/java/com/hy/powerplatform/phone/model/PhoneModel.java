package com.hy.powerplatform.phone.model;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;

/**
 * Created by dell on 2018/6/12.
 */

public interface PhoneModel {
    void getPhoneModelData(String httpTag, String userId, Context context, BaseModeBackLisenter baseModeBackLisenter);
}
