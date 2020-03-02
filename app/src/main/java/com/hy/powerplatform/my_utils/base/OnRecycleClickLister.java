package com.hy.powerplatform.my_utils.base;

/**
 * recyleView 点击监听事件
 */

public interface OnRecycleClickLister<T> {
    void click(int positon, T t);
}
