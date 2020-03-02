package com.hy.powerplatform.business_inspect.utils;

import com.hy.powerplatform.business_inspect.bean.CarCode;

import java.util.List;

/**
 * Created by dell on 2017/12/18.
 */

public interface BaseRequestAssessLisenter<T,T1> {
    void success(T t, T1 t1);
    void fail(String message);

    void success(List<CarCode> listCarCodeFromdb);
}
