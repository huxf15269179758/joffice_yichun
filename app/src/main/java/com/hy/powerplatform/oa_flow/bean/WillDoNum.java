package com.hy.powerplatform.oa_flow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/10/12.
 */

public class WillDoNum implements Serializable {

    /**
     * success : true
     * totalCounts : 5
     * result : [{"proTypeId":"4813","quantity":"1"},{"proTypeId":"4814","quantity":"6"},{"proTypeId":"4815","quantity":"7"},{"proTypeId":"4816","quantity":"1"},{"proTypeId":"4817","quantity":"3"}]
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

    public static class ResultBean {
        /**
         * proTypeId : 4813
         * quantity : 1
         */

        private String proTypeId;
        private String quantity;

        public String getProTypeId() {
            return proTypeId;
        }

        public void setProTypeId(String proTypeId) {
            this.proTypeId = proTypeId;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }
    }
}
