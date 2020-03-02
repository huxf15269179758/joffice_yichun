package com.hy.powerplatform.operation.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/12/31.
 */

public class DepartmentData implements Serializable {
    public String depName;
    public String depIp;

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepIp() {
        return depIp;
    }

    public void setDepIp(String depIp) {
        this.depIp = depIp;
    }
}
