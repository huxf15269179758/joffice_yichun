package com.hy.powerplatform.duban.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/12/4.
 */

public class DBXG implements Serializable {

    /**
     * success : true
     * msg : 信息成功保存！
     */

    private boolean success;
    private String msg;

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
}
