package com.hy.powerplatform.signin.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dell on 2018/6/15.
 */

public class SignHis implements Serializable {

    /**
     * success : true
     * totalCounts : 4
     * result : [{"id":"1489954","rq":"2018-06-25","sj":"21:40","userCode":"101866","userName":"白峰"},{"id":"1489953","rq":"2018-06-25","sj":"14:27","userCode":"101866","userName":"白峰"},{"id":"1489952","rq":"2018-06-25","sj":"12:09","userCode":"101866","userName":"白峰"},{"id":"1489951","rq":"2018-06-25","sj":"07:57","userCode":"101866","userName":"白峰"}]
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

    public static class ResultBean implements Serializable{
        /**
         * id : 1489954
         * rq : 2018-06-25
         * sj : 21:40
         * userCode : 101866
         * userName : 白峰
         */

        private String id;
        private String rq;
        private String sj;
        private String userCode;
        private String userName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRq() {
            return rq;
        }

        public void setRq(String rq) {
            this.rq = rq;
        }

        public String getSj() {
            return sj;
        }

        public void setSj(String sj) {
            this.sj = sj;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
