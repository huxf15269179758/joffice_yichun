package com.hy.powerplatform.statist.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/1/6.
 */

public class HuiZong implements Serializable {

    /**
     * YSYHMXB_Fuel : 柴油
     * YSYHMXB_ZJE : 1553693.91
     */

    private String YSYHMXB_Fuel;
    private String YSYHMXB_ZJE;

    public String getYSYHMXB_Fuel() {
        return YSYHMXB_Fuel;
    }

    public void setYSYHMXB_Fuel(String YSYHMXB_Fuel) {
        this.YSYHMXB_Fuel = YSYHMXB_Fuel;
    }

    public String getYSYHMXB_ZJE() {
        return YSYHMXB_ZJE;
    }

    public void setYSYHMXB_ZJE(String YSYHMXB_ZJE) {
        this.YSYHMXB_ZJE = YSYHMXB_ZJE;
    }
}
