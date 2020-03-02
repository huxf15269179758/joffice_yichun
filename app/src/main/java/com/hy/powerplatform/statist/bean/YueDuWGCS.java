package com.hy.powerplatform.statist.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/1/6.
 */

public class YueDuWGCS implements Serializable {

    /**
     * irregularities : 甩站
     * sl : 1
     */

    private String irregularities;
    private String sl;

    public String getIrregularities() {
        return irregularities;
    }

    public void setIrregularities(String irregularities) {
        this.irregularities = irregularities;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }
}
