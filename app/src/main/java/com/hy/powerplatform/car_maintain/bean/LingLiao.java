package com.hy.powerplatform.car_maintain.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/11/2.
 */

public class LingLiao implements Serializable {

    /**
     * success : true
     * totalCounts : 1
     * result : [{"carCode":"赣C02113D","driverCode":"undefined","driverName":"蔡韧","measureBusNo":"A2018103171732","houseName":"","depName":"枢纽分公司","lineCode":"12","materialType":"单燃料","repaircategory":"回厂小修","checkDate":"2018-11-01"}]
     */

    private boolean success;
    private int totalCounts;
    private List<ResultBean> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * carCode : 赣C02113D
         * driverCode : undefined
         * driverName : 蔡韧
         * measureBusNo : A2018103171732
         * houseName :
         * depName : 枢纽分公司
         * lineCode : 12
         * materialType : 单燃料
         * repaircategory : 回厂小修
         * checkDate : 2018-11-01
         */

        private String carCode;
        private String driverCode;
        private String driverName;
        private String measureBusNo;
        private String houseName;
        private String depName;
        private String lineCode;
        private String materialType;
        private String repaircategory;
        private String checkDate;

        public String getCarCode() {
            return carCode;
        }

        public void setCarCode(String carCode) {
            this.carCode = carCode;
        }

        public String getDriverCode() {
            return driverCode;
        }

        public void setDriverCode(String driverCode) {
            this.driverCode = driverCode;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getMeasureBusNo() {
            return measureBusNo;
        }

        public void setMeasureBusNo(String measureBusNo) {
            this.measureBusNo = measureBusNo;
        }

        public String getHouseName() {
            return houseName;
        }

        public void setHouseName(String houseName) {
            this.houseName = houseName;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getMaterialType() {
            return materialType;
        }

        public void setMaterialType(String materialType) {
            this.materialType = materialType;
        }

        public String getRepaircategory() {
            return repaircategory;
        }

        public void setRepaircategory(String repaircategory) {
            this.repaircategory = repaircategory;
        }

        public String getCheckDate() {
            return checkDate;
        }

        public void setCheckDate(String checkDate) {
            this.checkDate = checkDate;
        }
    }
}
