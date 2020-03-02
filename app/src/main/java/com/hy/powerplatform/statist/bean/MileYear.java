package com.hy.powerplatform.statist.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/6.
 */

public class MileYear implements Serializable{

    /**
     * success : true
     * totalCounts : 12
     * result : [{"monthRq":"2020-01","factMile":0},{"monthRq":"2020-02","factMile":0},{"monthRq":"2020-03","factMile":0},{"monthRq":"2020-04","factMile":0},{"monthRq":"2020-05","factMile":0},{"monthRq":"2020-06","factMile":0},{"monthRq":"2020-07","factMile":0},{"monthRq":"2020-08","factMile":0},{"monthRq":"2020-09","factMile":0},{"monthRq":"2020-10","factMile":0},{"monthRq":"2020-11","factMile":0},{"monthRq":"2020-12","factMile":0}]
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
         * monthRq : 2020-01
         * factMile : 0.0
         */

        private String monthRq;
        private String factMile;

        public String getMonthRq() {
            return monthRq;
        }

        public void setMonthRq(String monthRq) {
            this.monthRq = monthRq;
        }

        public String getFactMile() {
            return factMile;
        }

        public void setFactMile(String factMile) {
            this.factMile = factMile;
        }
    }
}
