package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/11/28.
 */

public class Person implements Serializable {
    public String userName;
    public String userCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

}
