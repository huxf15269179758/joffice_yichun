package com.hy.powerplatform.login.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2020/1/15.
 */

public class PersonContent implements Serializable {

    /**
     * success : true
     * totalCounts : 1
     * result : [{"userId":"1","fullname":"超级管理员","logTime":"2020-01-15 10:59:23.893","logIp":"123.232.38.10","num":"515"}]
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
         * userId : 1
         * fullname : 超级管理员
         * logTime : 2020-01-15 10:59:23.893
         * logIp : 123.232.38.10
         * num : 515
         */

        private String userId;
        private String fullname;
        private String logTime;
        private String logIp;
        private String num;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getLogTime() {
            return logTime;
        }

        public void setLogTime(String logTime) {
            this.logTime = logTime;
        }

        public String getLogIp() {
            return logIp;
        }

        public void setLogIp(String logIp) {
            this.logIp = logIp;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }
    }
}
