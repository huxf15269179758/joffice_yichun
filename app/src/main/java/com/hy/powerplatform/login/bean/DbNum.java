package com.hy.powerplatform.login.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/15.
 */

public class DbNum implements Serializable {

    /**
     * success : true
     * totalCounts : 1
     * result : [{"dzxnum":"0","dshnum":"1"}]
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
         * dzxnum : 0
         * dshnum : 1
         */

        private String dzxnum;
        private String dshnum;

        public String getDzxnum() {
            return dzxnum;
        }

        public void setDzxnum(String dzxnum) {
            this.dzxnum = dzxnum;
        }

        public String getDshnum() {
            return dshnum;
        }

        public void setDshnum(String dshnum) {
            this.dshnum = dshnum;
        }
    }
}
