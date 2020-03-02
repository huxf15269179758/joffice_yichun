package com.hy.powerplatform.statist.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/6.
 */

public class PersonChange implements Serializable {

    /**
     * success : true
     * totalCounts : 5
     * result : [{"project":"入职人数","total":"4"},{"project":"调入人数","total":"24"},{"project":"调出人数","total":"24"},{"project":"离职人数","total":"2"},{"project":"退休人数","total":"3"}]
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
         * project : 入职人数
         * total : 4
         */

        private String project;
        private String total;

        public String getProject() {
            return project;
        }

        public void setProject(String project) {
            this.project = project;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }
    }
}
