package com.hy.powerplatform.login.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/23.
 */

public class Type implements Serializable{
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String code;
}
