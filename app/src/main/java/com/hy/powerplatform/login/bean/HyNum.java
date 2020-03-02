package com.hy.powerplatform.login.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/15.
 */

public class HyNum implements Serializable {

    /**
     * success : true
     * totalCounts : 1
     * result : [{"dcjnum":"0","ycjnum":"16","dknum":"0","yknum":"19"}]
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
         * dcjnum : 0
         * ycjnum : 16
         * dknum : 0
         * yknum : 19
         */

        private String dcjnum;
        private String ycjnum;
        private String dknum;
        private String yknum;

        public String getDcjnum() {
            return dcjnum;
        }

        public void setDcjnum(String dcjnum) {
            this.dcjnum = dcjnum;
        }

        public String getYcjnum() {
            return ycjnum;
        }

        public void setYcjnum(String ycjnum) {
            this.ycjnum = ycjnum;
        }

        public String getDknum() {
            return dknum;
        }

        public void setDknum(String dknum) {
            this.dknum = dknum;
        }

        public String getYknum() {
            return yknum;
        }

        public void setYknum(String yknum) {
            this.yknum = yknum;
        }
    }
}
