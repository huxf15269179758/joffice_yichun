package com.hy.powerplatform.duban.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/12/17.
 */

public class ItemBean implements Serializable {
    public String name;
    public int address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
