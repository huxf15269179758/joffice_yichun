package com.hy.powerplatform.login.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/1/3.
 */

public class YingYunData implements Serializable {

    /**
     * type : 收入
     * num : 18.07
     */

    private String type;
    private String num;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
