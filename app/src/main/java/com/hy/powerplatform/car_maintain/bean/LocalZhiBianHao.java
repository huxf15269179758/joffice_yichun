package com.hy.powerplatform.car_maintain.bean;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2018/12/21.
 */

public class LocalZhiBianHao extends DataSupport {
    public String zhibianhao;
    public String carno;

    public String getCarno() {
        return carno;
    }

    public void setCarno(String carno) {
        this.carno = carno;
    }

    public String getZhibianhao() {
        return zhibianhao;
    }

    public void setZhibianhao(String zhibianhao) {
        this.zhibianhao = zhibianhao;
    }
}
