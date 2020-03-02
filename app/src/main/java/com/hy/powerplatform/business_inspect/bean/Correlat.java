package com.hy.powerplatform.business_inspect.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/6.
 */

public class Correlat implements Serializable {

    /**
     * success : true
     * data : {"xlbh":"3331","ch":"100","jsy":"2387","carNo":"冀JN3159","carType":"福田6123","bus_maker":"北汽福田汽车股份有限公司","bus_supplier":"北汽福田汽车有限公司","depId":"434","depName":"成达巴士公司"}
     */

    private boolean success;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * xlbh : 3331
         * ch : 100
         * jsy : 2387
         * carNo : 冀JN3159
         * carType : 福田6123
         * bus_maker : 北汽福田汽车股份有限公司
         * bus_supplier : 北汽福田汽车有限公司
         * depId : 434
         * depName : 成达巴士公司
         */

        private String xlbh;
        private String ch;
        private String jsy;
        private String carNo;
        private String carType;
        private String bus_maker;
        private String bus_supplier;
        private String depId;
        private String depName;

        public String getXlbh() {
            return xlbh;
        }

        public void setXlbh(String xlbh) {
            this.xlbh = xlbh;
        }

        public String getCh() {
            return ch;
        }

        public void setCh(String ch) {
            this.ch = ch;
        }

        public String getJsy() {
            return jsy;
        }

        public void setJsy(String jsy) {
            this.jsy = jsy;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public String getBus_maker() {
            return bus_maker;
        }

        public void setBus_maker(String bus_maker) {
            this.bus_maker = bus_maker;
        }

        public String getBus_supplier() {
            return bus_supplier;
        }

        public void setBus_supplier(String bus_supplier) {
            this.bus_supplier = bus_supplier;
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
}
