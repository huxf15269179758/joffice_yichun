package com.hy.powerplatform.duban.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/12/19.
 */

public class AboutPerson implements Serializable{

    /**
     * success : true
     * fullname : 王少云,唐根六,晏慧锋,何爱民
     * userId : 9386,9387,9398,9391
     */

    private boolean success;
    private String fullname;
    private String userId;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
