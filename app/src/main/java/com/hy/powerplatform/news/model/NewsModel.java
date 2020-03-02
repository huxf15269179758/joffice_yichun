package com.hy.powerplatform.news.model;

import android.content.Context;

import com.hy.powerplatform.my_utils.base.BaseModeBackLisenter;


/**
 * Created by dell on 2017/8/2.
 */

public interface NewsModel {
    void getNewsModelData(String httpTag, String type, Context context, BaseModeBackLisenter baseModeBackLisenter);
}
