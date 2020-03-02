package com.hy.powerplatform.signin.bean;

import java.io.Serializable;

/**
 * Created by dell on 2018/5/8.
 */

public class SignIn implements Serializable{


    /**
     * success : true
     * msg : 保存失败
     * show : false
     */

    private boolean success;
    private String msg;
    private String show;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }
}
