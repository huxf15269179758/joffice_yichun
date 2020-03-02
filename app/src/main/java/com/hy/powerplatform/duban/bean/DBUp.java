package com.hy.powerplatform.duban.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/11/28.
 */

public class DBUp implements Serializable {

    /**
     * success : true
     * workId : 123
     */

    private boolean success;
    private String workId;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }
}
