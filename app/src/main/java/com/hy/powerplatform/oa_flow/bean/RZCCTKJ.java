package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/12/6.
 */

public class RZCCTKJ implements Serializable {

    /**
     * success : true
     * username : 吴迪
     */

    private boolean success;
    private String username;

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
}
