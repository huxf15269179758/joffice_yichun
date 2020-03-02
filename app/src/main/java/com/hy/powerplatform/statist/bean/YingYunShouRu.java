package com.hy.powerplatform.statist.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/1/6.
 */

public class YingYunShouRu implements Serializable {

    /**
     * project : 现金
     * total : 1939659.0
     */

    private String project;
    private double total;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
