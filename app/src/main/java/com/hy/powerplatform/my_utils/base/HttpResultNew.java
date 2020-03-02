package com.hy.powerplatform.my_utils.base;

/**
 * Created by dell on 2017/4/20.
 */

public class HttpResultNew<T> {

    /**
     * result : 参数异常
     * state : PAREMATER
     */

    private String success;
    private String stateCode;
    private String msg;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    private T obj;
}
