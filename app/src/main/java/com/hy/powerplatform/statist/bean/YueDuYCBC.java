package com.hy.powerplatform.statist.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/1/6.
 */

public class YueDuYCBC implements Serializable {

    /**
     * type : 停班
     * counts : 4012.0
     */

    private String type;
    private double counts;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCounts() {
        return counts;
    }

    public void setCounts(double counts) {
        this.counts = counts;
    }
}
