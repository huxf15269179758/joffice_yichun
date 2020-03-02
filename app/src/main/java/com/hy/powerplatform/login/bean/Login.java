package com.hy.powerplatform.login.bean;

import java.io.Serializable;

/**
 * Created by dell on 2018/5/3.
 */

public class Login implements Serializable {

    /**
     * success : true
     * username : 超级管理员
     * userId : 1
     */

    private boolean success;
    private String username;
    private String msg;
    private String userId;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
