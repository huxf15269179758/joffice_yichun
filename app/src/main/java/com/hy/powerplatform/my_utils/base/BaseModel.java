package com.hy.powerplatform.my_utils.base;

/**
 * Created by dell on 2017/4/24.
 */

public interface BaseModel {
    /**
     * 取消相应的网络请求
     * @param httpTag
     */
    void cancelHttp(String httpTag);
}
