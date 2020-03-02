package com.hy.powerplatform.statist.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/1/6.
 */

public class CostComparison implements Serializable {

    /**
     * ksType : 202001
     * cb : 0.0
     * sr : 0.0
     */

    private String ksType;
    private String cb;
    private String sr;

    public String getKsType() {
        return ksType;
    }

    public void setKsType(String ksType) {
        this.ksType = ksType;
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }
}
