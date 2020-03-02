package com.hy.powerplatform.business_inspect.bean;

/**
 * Created by dell on 2018/6/1.
 */

public class ShowLine {
    public String lineCode;
    public String  depId;
    public String depName;

    public ShowLine(String lineCode, String depId, String depName) {
        this.lineCode = lineCode;
        this.depId = depId;
        this.depName = depName;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
