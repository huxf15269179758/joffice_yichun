package com.hy.powerplatform.statist.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/1/6.
 */

public class CLXHTongJi implements Serializable {

    /**
     * typeName : 01 引擎类
     * je : 13077.42
     */

    private String typeName;
    private double je;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getJe() {
        return je;
    }

    public void setJe(double je) {
        this.je = je;
    }
}
